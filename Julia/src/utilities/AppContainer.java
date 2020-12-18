package utilities;

import objects.ComplexNumber;
import services.PatternGenerator;

public class AppContainer {
	
	/*
	 * Requirements :
	 * Two PNG images with the names outputJulia.png and outputMandelbrot.png should be present at E:\Pictures location
	 * Center for the Mandelbrot set acts as the C value for the respective Julia set which is the value 'center'
	 * width of the Mandelbrot set image in units is the value 'width'
	 * Julia set top-left : -1.8+1.5i bottom-right : 1.8-1.5i
	 */
	
	//main
	public static void main(String[] args) {
		double time = System.currentTimeMillis();
		ComplexNumber center = new ComplexNumber();
		double width = 0.025d;
		center.value(-0.54d, 0.50d);
		PatternGenerator.generate(center, width, true);
		System.out.println("Time taken ... " + (System.currentTimeMillis() - time)/60000.0d + " mins");
	}
	
}