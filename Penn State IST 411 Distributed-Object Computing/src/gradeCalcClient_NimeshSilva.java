/**
 * Author 			Nimesh Silva
 * Class			IST411 001
 * Project			Lab 1
 * Due Date			2/5/2020
 * class name 		gradeCalcClient_NimeshSilva				
 */

//import statements
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Scanner;

public class gradeCalcClient_NimeshSilva {
	public static void main(String[] args) {
		System.out.println("Client started");
		try {
			// Setup client sockets and establish server connection on localhost port 6000
			InetAddress localAddress = InetAddress.getLocalHost();
			Socket clientSocket = new Socket(localAddress, 6000);

			// Display successful connection message
			System.out.println("Successfully connected to the server");

			// Setup to read from and write to client
			BufferedReader streamIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter streamOut = new PrintWriter(clientSocket.getOutputStream(), true);

			// Setup to read from client console
			Scanner consoleIn = new Scanner(System.in);

			// An array to store the grades the user enters
			ArrayList<Double> averageGrades = new ArrayList<Double>();

			// Strings to store the responses the user enters
			String setEnter = "";
			String regEnter = "";

			// String to store messages from the server
			String serverMsg = "";

			// Integer to hold the number of grades that were inputed into the arrayList
			int counter = 0;

			// Continue to run the program and calculate grade average until the user says
			// they are done (Enters X)
			do {
				// TODO Auto-generated method stub

				do {
					// Variables to hold input coming from client console
					averageGrades.add(
							validatePosDoubleInput("Enter an assignment grade as a grade as a percentage:", consoleIn));

					// Resets the scanner if the user wants to enter another set of inputs
					consoleIn.nextLine();

					counter++;

					// A loop to allow the user to enter another grade or to close the array
					do {
						regEnter = validateStringInput(
								"Enter Y to add another assignment grade. Enter N to calculate the final grade.",
								consoleIn);
					} while ((!regEnter.toUpperCase().equals("Y")) && !regEnter.toUpperCase().equals("N"));

				} while ((!regEnter.toUpperCase().equals("N")));

				// A loop that will process all the grades in the array and will send the
				// results to the server
				for (int i = 0; i < counter; i++) {
					streamOut.println(averageGrades.get(i).toString());
				}
				streamOut.println("X");

				// A loop that will print out the server messages
				while ((serverMsg = streamIn.readLine()) != null) {
					if (serverMsg.toUpperCase().equals("X")) {
						break;
					}
					System.out.println("Server response: " + serverMsg);
				}
				counter = 0;

				// A loop that will allows the user to make another set of inputs or to quit the
				// server
				do {
					setEnter = validateStringInput(
							"Do you want to enter another set of assignment grades? Enter Y to Continue or Enter X to Quit",
							consoleIn);
				} while ((!setEnter.toUpperCase().equals("Y")) && !setEnter.toUpperCase().equals("X"));

			} while ((!setEnter.toUpperCase().equals("X")));

			System.out.println("Client stopped");
			System.exit(0);
		} catch (SocketException ex) {
			System.out.println("Client stopped");
			System.exit(0);
		} catch (IOException ex) {
			System.out.println("Exception occurred");
			ex.printStackTrace();
		}
	}

	// Method repeatedly displays the prompt until valid positive int input is
	// entered
	public static int validatePosIntegerInput(String prompt, Scanner in) {
		int var = 0;
		do {
			System.out.println(prompt);
			while (!in.hasNextInt() || !in.hasNextDouble()) {
				System.out.println(prompt);
				in.next();
			}
			var = in.nextInt();
		} while (var < 0);
		return var;
	}

	// Method repeatedly displays the prompt until valid positive double input is
	// entered
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

	// Method repeatedly displays the prompt until valid String input is entered
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
