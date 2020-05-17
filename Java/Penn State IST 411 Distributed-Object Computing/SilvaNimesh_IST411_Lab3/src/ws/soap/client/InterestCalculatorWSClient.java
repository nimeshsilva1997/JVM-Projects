/*
 * Nimesh Silva
 * IST 411: Section 001
 * Lab 3
 * April 8th, 2020
 */

package ws.soap.client;

import java.text.DecimalFormat;
import java.util.Scanner;

public class InterestCalculatorWSClient {

	public static void main(String[] args) {
		InterestCalculatorWSService client = new InterestCalculatorWSService();
		InterestCalculatorWS ws = client.getInterestCalculatorWSPort();

		boolean flag = true;
		do {
			Scanner in = new Scanner(System.in);
			DecimalFormat df = new DecimalFormat("0.00");
			
			double p = validatePosDoubleInput("Enter principle: ", in);
			double r = validatePosDoubleInput("Enter rate: ", in);
			int y = validatePosIntegerInput("Enter years: ", in);

			in.nextLine();
			
			double i = ws.calculateInterest(p, r, y);

			System.out.println("Calcualted interest: $" + df.format(i));
			
			String response = "";
			do {
				response = validateStringInput("Enter Y to continue. Enter X to exit.", in);
			} while(!response.toUpperCase().equals("Y") && !response.toUpperCase().equals("X"));
			
			if (response.toUpperCase().equals("X")) {
				flag = false;
			}
			
		} while (flag == true);

		System.out.println("Client terminated.");
	}

	//Method repeatedly displays the prompt until valid positive double input is entered
	public static double validatePosDoubleInput(String prompt, Scanner in) {
		double var = 0.0;
		do {
			System.out.println(prompt);
			while (!in.hasNextDouble()) {
				System.out.println(prompt);
				in.next();
			} 
			var = in.nextDouble();
		} while (var < 0);
		return var;
	}
	
	//Method repeatedly displays the prompt until valid positive double input is entered
	public static int validatePosIntegerInput(String prompt, Scanner in) {
		int var = 0;
		do {
			System.out.println(prompt);
			while (!in.hasNextInt()) {
				System.out.println(prompt);
				in.next();
			} 
			var = in.nextInt();
		} while (var < 0);
		return var;
	}

	//Method repeatedly displays the prompt until valid String input is entered
	public static String validateStringInput(String prompt, Scanner in) {
		boolean valid = false;
		String var = "";
		do {
			System.out.println(prompt);
			while (in.hasNextDouble() || in.hasNextInt()) {
				System.out.println(prompt);
				in.nextLine();
			}
			var = in.nextLine();
			valid = true;
		} while (!valid);
		return var;
	}
}
