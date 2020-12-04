package objects;

public class CX {
	
	//data
	public SX real = new SX();
	public SX imaginary = new SX();
	
	//clone
	public CX clone() {
		CX copy = new CX();
		copy.real = this.real.clone();
		copy.imaginary = this.imaginary.clone();
		return copy;
	}
	
	//get value
	public String value() {
		String result = this.real.value();
		if(this.imaginary.sign)
			result += "+";
		result += this.imaginary.value() + "i";
		return result;
	}
	
	//set value
	public void value(String real, String imaginary) {
		SX real1 = new SX();
		SX imaginary1 = new SX();
		real1.value(real);
		imaginary1.value(imaginary);
		this.real = real1;
		this.imaginary = imaginary1;
	}
	
	//difference magnitude between complex numbers squared
	public static SX diff(CX a, CX b) {
		CX diff = CX.subtract(a, b);
		return SX.add(SX.multiply(diff.real, diff.real), SX.multiply(diff.imaginary, diff.imaginary));
	}
	
	//add
	public static CX add(CX a, CX b) {
		CX result = new CX();
		result.real = SX.add(a.real, b.real);
		result.imaginary = SX.add(a.imaginary, b.imaginary);
		return result;
	}
	
	//subtract
	public static CX subtract(CX a, CX b) {
		CX result = new CX();
		result.real = SX.subtract(a.real, b.real);
		result.imaginary = SX.subtract(a.imaginary, b.imaginary);
		return result;
	}
	
	//multiply
	public static CX multiply(CX a, CX b) {
		CX result = new CX();
		result.real = SX.subtract(SX.multiply(a.real, b.real), SX.multiply(a.imaginary, b.imaginary));
		result.imaginary = SX.add(SX.multiply(a.real, b.imaginary), SX.multiply(a.imaginary, b.real));
		return result;
	}
	
	//divide
	public static CX divide(CX a, CX b) {
		CX result = new CX();
		CX num = new CX();
		SX dem = new SX();
		num.real = SX.add(SX.multiply(a.real, b.real), SX.multiply(a.imaginary, b.imaginary));
		num.imaginary = SX.subtract(SX.multiply(a.imaginary, b.real), SX.multiply(a.real, b.imaginary));
		dem = SX.add(SX.multiply(b.real, b.real), SX.multiply(b.imaginary, b.imaginary));
		result.real = SX.divide(num.real, dem);
		result.imaginary = SX.divide(num.imaginary, dem);
		return result;
	}
	
}
