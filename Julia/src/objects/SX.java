package objects;

public class SX {

	//data
	public boolean sign = true;
	public byte[] x = {0, 0, 0, 0, 0, 0, 0, 0,
	                   0, 0, 0, 0, 0, 0, 0, 0,
	                   0, 0, 0, 0, 0, 0, 0, 0,
	                   0, 0, 0, 0, 0, 0, 0, 0};
	
	//clone
	public SX clone() {
	  SX copy = new SX();
	  for (int i = 0; i < 32; i++)
	    copy.x[i] = this.x[i];
	  copy.sign = this.sign;
	  return copy;
	}
	
	//get value
	public String value() {
	  String result = "";
	  if (!this.sign)
	    result += "-";
	  result += this.x[0] + ".";
	  for(int i = 1; i < 32; i++){
	    result += String.format("%02d", this.x[i]);
	  }
	  return result;
	}
	
	//set value
	public void value(String val) {
	  if(val.startsWith("-")){
	    this.sign = false;
	    val = val.substring(1);
	  }
	  else
	    this.sign = true;
	  String[] parts = val.split("\\.", 2);
	  String ip = parts[0];
	  String fp = parts[1];
	  int fpLength = fp.length();
	  this.x[0] = Byte.parseByte(ip);
	  for (int i = 0; i < (62 - fpLength); i++)
	    fp += "0";
	  for (int i = 1; i < 32; i++){
	    this.x[i] = Byte.parseByte(fp.substring(0, 2));
	    fp = fp.substring(2);
	  }
	}
	
	//compare numbers
	public static int compare(SX a, SX b){
		if(a.sign && b.sign) {
			for(int i = 0; i < 32; i++){
				if (a.x[i] > b.x[i])
					return 1;
				else if (a.x[i] < b.x[i])
					return -1;
			}
			return 0;
		}
		else if(!a.sign && b.sign)
			return -1;
		else if(a.sign && !b.sign)
			return 1;
		else {
			SX a1 = a.clone();
			SX b1 = b.clone();
			a1.sign = true;
			b1.sign = true;
			return 0-SX.compare(a1, b1);
		}
	}
	
	//add
	public static SX add(SX a1, SX b1) {
	  SX a = a1.clone();
	  SX b = b1.clone();
	  int temp = 0;
	  if(a.sign && b.sign){
	    SX result = new SX();
	    for(int i = 31; i >= 0; i--){
	      temp = result.x[i] + a.x[i] + b.x[i];
	      result.x[i] = (byte) (temp%100);
	      if(i != 0)
	        result.x[i-1] = (byte) (temp/100);
	    }
	    result.sign = true;
	    return result;
	  }
	  else if(!a.sign && !b.sign){
	    a.sign = true;
	    b.sign = true;
	    SX result = SX.add(a, b);
	    result.sign = false;
	    return result;
	  }
	  else if(!a.sign){
	    a.sign = true;
	    return SX.subtract(b, a);
	  }
	  else{
	    b.sign = true;
	    return SX.subtract(a, b);
	  }
	}
	
	//subtract
	public static SX subtract(SX a1, SX b1) {
	  SX a = a1.clone();
	  SX b = b1.clone();
	  if(a.sign && b.sign){
	    SX result;
	    if(SX.compare(a, b) != -1){
	      result = new SX();
	      int temp = 0;
	      for(int i = 31; i >= 0; i--){
	        temp = a.x[i] - b.x[i];
	        if(temp >= 0)
	          result.x[i] = (byte) temp;
	        else{
	          result.x[i] = (byte) (100 + temp);
	          if(i != 0)
	            a.x[i-1] = (byte) (a.x[i-1] - 1);
	        }
	      }
	      result.sign = true;
	    }
	    else{
	      result = SX.subtract(b, a);
	      result.sign = false;
	    }
	    return result;
	  }
	  else if(!a.sign && !b.sign){
	    a.sign = true;
	    b.sign = true;
	    return SX.subtract(b, a);
	  }
	  else if(!a.sign){
	    a.sign = true;
	    SX result = SX.add(a, b);
	    result.sign = false;
	    return result;
	  }
	  else{
	    b.sign = true;
	    return SX.add(a, b);
	  }
	}
	
	//multiply
	public static SX multiply(SX a, SX b) {
	  int cursor = 0;
	  int unitProd = 0;
	  SX result = new SX();
	  result.sign = true;
	  SX temp = new SX();
	  temp.sign = true;
	  for (int i = 0; i < 32; i++){
	    for (int j = (31 - i); j >= 0; j--){
	      cursor = i + j;
	      if (cursor != 0)
	        unitProd = 100*temp.x[cursor - 1] + temp.x[cursor] + a.x[i]*b.x[j];
	      else
	        unitProd = temp.x[cursor] + a.x[i]*b.x[j];
	      temp.x[cursor] = (byte) (unitProd%100);
	      if (cursor > 0){
	        unitProd = unitProd/100;
	        temp.x[cursor - 1] = (byte) (unitProd%100);
	      }
	      if (cursor > 1){
	        unitProd = unitProd/100;
	        temp.x[cursor - 2] = (byte) unitProd;
	      }
	    }
	    result = SX.add(result, temp);
	    temp.value("0.00");
	  }
	  result.sign = (a.sign && b.sign) || (!a.sign && !b.sign);
	  return result;
	}
	
	//divide
	public static SX divide(SX a1, SX b1) {
	  SX a = a1.clone();
	  SX b = b1.clone();
	  SX result = new SX();
	  SX temp = new SX();
	  a.sign = true;
	  b.sign = true;
	  result.sign = true;
	  temp.sign = true;
	  for(int i = 0; i < 32; i++){
	    while(SX.compare(temp, a) == -1){
	      result.x[i] = (byte) (result.x[i] + 1);
	      if(result.x[i] == 100) {
	    	  result.x[i]--;
	    	  break;
	      }
	      temp = SX.multiply(result, b);
	    }
	    if(SX.compare(temp, a) == 0)
	      break;
	    else{
	      result.x[i] = (byte) (result.x[i] - 1);
	      temp = SX.multiply(result, b);
	    }
	  }
	  result.sign = (a1.sign && b1.sign) || (!a1.sign && !b1.sign);
	  return result;
	}
	
}