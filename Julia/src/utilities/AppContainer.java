package utilities;

import objects.CX;
import objects.SX;

public class AppContainer {

	//test1
	public static void test1(){
		SX a = new SX();
		SX b = new SX();
		SX result = new SX();
		double time = 0.0d;
		//assigning values
		a.value("33.33333333333333333333333333333333333333333333333333333333333333");
		b.value("3.00");
		//operations
		System.out.println("SX time...");
		time = (double) System.currentTimeMillis();
		for(int i = 0; i < 10000; i++)
		  result = SX.add(a, b);
		System.out.println("Time taken for addition: " + ((double) System.currentTimeMillis() - time)/10000.0d + "ms\n" + result.value());
		time = (double) System.currentTimeMillis();
		for(int i = 0; i < 10000; i++)
		  result = SX.subtract(a, b);
		System.out.println("Time taken for subtraction: " + ((double) System.currentTimeMillis() - time)/10000.0d + "ms\n" + result.value());
		time = (double) System.currentTimeMillis();
		for(int i = 0; i < 10000; i++)
		  result = SX.multiply(a, b);
		System.out.println("Time taken for multiplication: " + ((double) System.currentTimeMillis() - time)/10000.0d + "ms\n" + result.value());
		time = (double) System.currentTimeMillis();
		for(int i = 0; i < 10; i++)
		  result = SX.divide(a, b);
		System.out.println("Time taken for division: " + ((double) System.currentTimeMillis() - time)/10.0d + "ms\n" + result.value());
	}
	
	//test2
	public static void test2() {
		CX a = new CX();
		CX b = new CX();
		CX result = new CX();
		a.value("15.65607073348075191919191919191919191919191919191919191919191919", "-2.90147859695821556878380854469397338380840307709619446747850733");
		b.value("7.46415154156156145611144651515464615163254135165651321566146316", "2.46849461446516849456146516544631546416515614651564465163146165");
		result = CX.add(a, b);
		System.out.println(result.value());
		result = CX.subtract(a, b);
		System.out.println(result.value());
		result = CX.multiply(a, b);
		System.out.println(result.value());
		result = CX.divide(a, b);
		System.out.println(result.value());
	}
	
	//test3
	public static void test3() throws java.io.FileNotFoundException{
		SX[] set = new SX[20];
		double[] setx = new double[20];
		set[0] = new SX(); set[0].value("-17.00000000000000000000000000000000000003254135165651321566146316");
		setx[0] = -17.000000d;
		set[1] = new SX(); set[1].value("27.46415154156156145611144651515464615163");
		setx[1] = 27.464152d;
		set[2] = new SX(); set[2].value("-37.464151541561563254135165651321566146316");
		setx[2] = -37.464152d;
		set[3] = new SX(); set[3].value("47.46415154156156115616465135165651321566146316");
		setx[3] = 47.464152d;
		set[4] = new SX(); set[4].value("-57.4641515415615163254135165651321566146316");
		setx[4] = -57.464152d;
		set[5] = new SX(); set[5].value("67.40");
		setx[5] = 67.40d;
		set[6] = new SX(); set[6].value("-77.46415154156156145611144651515464615163254135165651321566146316");
		setx[6] = -77.464152d;
		set[7] = new SX(); set[7].value("87.01321566146316");
		setx[7] = 87.01321566d;
		set[8] = new SX(); set[8].value("-97.46415154156156145611144651515464615163254135165651321566146316");
		setx[8] = -97.464152d;
		set[9] = new SX(); set[9].value("-9.464163254135165651321566146316");
		setx[9] = -9.4641632d;
		set[10] = new SX(); set[10].value("9.46415154156156145611144651515464615163254135165651321566146316");
		setx[10] = 9.464152d;
		set[11] = new SX(); set[11].value("5.46415100000000000000000000044440000000000035165651321566146316");
		setx[11] = 5.464151d;
		set[12] = new SX(); set[12].value("-3.46415154156156145611144651515464615163254135165651321566146316");
		setx[12] = -3.464152d;
		set[13] = new SX(); set[13].value("1.4641515415615614535165651321566146316");
		setx[13] = 1.464152d;
		set[14] = new SX(); set[14].value("0.46415154156156145611144651515464615163254135165651321566146316");
		setx[14] = 0.464152d;
		set[15] = new SX(); set[15].value("-0.00415154156156145611144651515464615163254135165651321566146316");
		setx[15] = -0.00415152d;
		set[16] = new SX(); set[16].value("0.00000154156156145611144651515464615163254135165651321566146316");
		setx[16] = 0.0000015415616d;
		set[17] = new SX(); set[17].value("-0.00000000000000000000000000000000615163254135165651321566146316");
		setx[17] = -6.15163254e-33d;
		set[18] = new SX(); set[18].value("0.000000000000000000000000000000000000000000000000000000000000000");
		setx[18] = 0.00d;
		set[19] = new SX(); set[19].value("-0.00000000000000000000000000000000000000000000000000000000000000");
		setx[19] = 0.00d;
		java.io.PrintStream stream = new java.io.PrintStream(new java.io.File("C:\\Users\\Gokul Raj V\\Desktop\\op.txt"));
		java.io.PrintStream console = new java.io.PrintStream(new java.io.FileOutputStream(java.io.FileDescriptor.out));
		int index = 0;
		System.out.println("Please refer the C:\\Users\\Gokul Raj V\\Desktop\\op.txt file ...");
		for(int i = 0; i < 20; i++)
			for (int j = 0; j < 20; j++) {
				System.setOut(stream);
				System.out.println("A : " + set[i].value());
				System.out.println("B : " + set[j].value());
				System.out.println("A + B");
				System.out.println(SX.add(set[i], set[j]).value());
				System.out.println(String.format("%2.62f", setx[i]+setx[j]));
				System.out.println("A - B");
				System.out.println(SX.subtract(set[i], set[j]).value());
				System.out.println(String.format("%2.62f", setx[i]-setx[j]));
				System.out.println("A * B");
				System.out.println(SX.multiply(set[i], set[j]).value());
				System.out.println(String.format("%2.62f", setx[i]*setx[j]));
				System.out.println("A / B");
				System.out.println(SX.divide(set[i], set[j]).value());
				System.out.println(String.format("%2.62f", setx[i]/setx[j]));
				System.out.println("=========================================================================");
				index++;
				System.setOut(console);
				System.out.println(index);
			}
	}
	
	//main
	public static void main(String[] args) throws java.io.FileNotFoundException{
		AppContainer.test3();
	}
	
}