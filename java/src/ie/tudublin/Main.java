package ie.tudublin;

import example.CubeVisual;
import example.MyVisual;
import c18342126.*;

public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
		processing.core.PApplet.runSketch( a, new My_Visual());

		System.out.println("Hello");
	}

	// public void dots() {
	// 	String[] b = {"MAIN"};
	// 	processing.core.PApplet.runSketch(b, new Dots());
	// }

	public static void main(String[] args)
	{
		Main main = new Main();
		main.startUI();
		
					

		// Main main = new Main();
		// main.
	}
}