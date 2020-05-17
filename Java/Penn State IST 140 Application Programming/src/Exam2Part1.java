import java.util.Scanner;
public class Exam2Part1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		
		
		{
			
			System.out.print("Enter the amount of oil ordered, in gallons: "); //output to ask user test oil
			double oil = in.nextDouble(); //program waits and asks user for input
		

		
		if (oil >= 100)  //if statement for oil greater than equal to 100
		{
			int discount = 1; //Displays prompt if user enters a value 100 or greater
			double pricePerGallon = 325.00;
			double pricePerGallon2 = 3.25;
			System.out.println("Number of gallons ordered: " + oil + " - $" + pricePerGallon);
			System.out.println("Discount: " + discount + "% - $" + pricePerGallon2);
			double total = pricePerGallon - pricePerGallon2;
			System.out.println("Your total charge is: $" + total);
		}
		else if (oil >= 200) //if statement for oil greater than or equal to 200
		{
		    int discount2 = 2; //Displays prompt if user enters a value of 200 or greater
			double pricePerGallon = 650.00;
			double pricePerGallon2 = 6.50;
			System.out.println("Number of gallons ordered: " + oil + " - $" + pricePerGallon);
			System.out.println("Discount: " + discount2 + "% - $" + pricePerGallon2);
			double total = pricePerGallon - pricePerGallon2;
			System.out.println("Your total charge is: $" + total);
		}
		else if (oil >= 300) //if statement for oil greater than or equal to 300
		{
			int discount3 = 3; //Displays prompt if user enters a value 300 or greater
			double pricePerGallon = 975.00;
			double pricePerGallon2 = 9.75;
			System.out.println("Number of gallons ordered: " + oil + " - $" + pricePerGallon);
			System.out.println("Discount: " + discount3 + "% - $" + pricePerGallon2);
			double total = pricePerGallon - pricePerGallon2;
			System.out.println("Your total charge is: $" + total);
		}
		else if (oil >= 400) //if statement for oil greater than or equal to 400
		{
			int discount4 = 4; //Displays prompt if user enters a value 400 or greater
			double pricePerGallon = 1300.00;
			double pricePerGallon2 = 13;
			System.out.println("Number of gallons ordered: " + oil + " - $" + pricePerGallon);
			System.out.println("Discount: " + discount4 + "% - $" + pricePerGallon2);
			double total = pricePerGallon - pricePerGallon2;
			System.out.println("Your total charge is: $" + total);
		}
		else if (oil >= 500) //if statement for oil greater than or equal to 500
		{
			int discount5 = 5; //Displays prompt if user enters a value 500 or greater
			double pricePerGallon = 1625.00;
			double pricePerGallon2 = 16.25;
			System.out.println("Number of gallons ordered: " + oil + " - $" + pricePerGallon);
			System.out.println("Discount: " + discount5 + "% - $" + pricePerGallon2);
			double total = pricePerGallon - pricePerGallon2;
			System.out.println("Your total charge is: $" + total);
		}
		else 
		{
			System.out.print("Have a great day"); //Displays message if the input of oil is less than 100 
		}
		
		}
		}
	}


