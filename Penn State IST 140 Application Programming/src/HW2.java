import java.util.Scanner;

public class HW2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter temperature in Fahrenheit: "); //Output line for asking temp in Fahrenheit
		double fahrenheit = input.nextDouble(); //Program waits, then asks user for input
		
		double celsius = (fahrenheit - 32) * 5 / 9; //formula for conversion of Fahrenheit to Celsius
		System.out.println("Temperature in Celsius: " + celsius + " Celsius."); //Output line for displaying converted temp in Celsius
		
		System.out.println();
		
		System.out.println("This is the temperature converted from Fahrenheit to Celsius." //Output line for confirmation
				+ " Now for the temperature converted from Celsius back to Fahrenheit."); 
		
		System.out.println();
		
		System.out.print("Enter a temperature in Celsius: "); //Output line for asking temp in Celsius
		double celsius2 = input.nextDouble(); //Program waits, then asks user for input
		
		double fahrenheit2 = (9.0 / 5) * celsius2 + 32; //formula for conversion of Celsius to Fahrenheit 
		System.out.println("Temperature in fahrenheit: " + fahrenheit2 + " Fahrenheit."); //Output line for displaying converted temp in Fahrenheit

		System.out.println();
		
		System.out.println("This is the temperature converted from Celsius to Fahrenheit."); //Output line for confirmation
		
		System.out.println();
		
		System.out.println("Now both temperatures have been converted from Fahrenheit to Celsius " //Output line for confirmation
				+ "and Celsius to Fahrenheit.");
		
		System.out.println();
		
		System.out.println("Have a great day!"); //Output line saying goodbye
	}

}
