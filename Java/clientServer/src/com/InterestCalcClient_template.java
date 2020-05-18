package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;
/*
 * 1. Wait for client connection
 * 2. Wait for client messages
 * 3. int rate; init. inv amount; yrs
 * 4. Perform calc
 * 5. Send to into + new bal. to client
 * 
 * 
 * 1. establish connection to server
 * 2. Prompt for init bal; int rate; term (yrs.)
 * 3. Send values to server
 * 4. Wait for server response
 * 5. isplay new balance and to int
 * 6. Continue to prompt user
 */

public class InterestCalcClient_template {

	public static void main(String[] args) {
		System.out.println("Client started");

		try {
			// Setup client sockets and establish server connection on port localhost port
			// 6000
			InetAddress localAdress = InetAddress.getLocalHost();
			Socket clientSocket = new Socket(localAdress, 6000);
			// Display successful connection message after socket has been created
			System.out.println("Successfully connected to the server");

			// Setup to read from and write to client
			BufferedReader streamIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter streamOut = new PrintWriter(clientSocket.getOutputStream(), true);

			// Setup to read from the client console
			Scanner consoleIn = new Scanner(System.in);

			// Variable to indicate whether or not to continue running
			String ind = "";

			// Continue to run the program and calculate interest until the user says their
			// done (Enters X)
			do {

				// Variables to hold input coming from client console
				double initBal = 0.0;
				double rate = 0.0;
				int term = 0;

				// Read and validate input from the client console
				initBal = validatePosDoubleInput("Enter initial balance: ", consoleIn);
				rate = validatePosDoubleInput("Enter annual interest rate: ", consoleIn);
				term = validatePosIntegerInput("Enter investment term (in years): ", consoleIn);

				// Reset scanner in client console
				consoleIn.nextLine();

				// Pass each input to the server for processing
				streamOut.println(initBal);
				streamOut.println(rate);
				streamOut.println(term);

				// Tell the server the client is done sending messages
				streamOut.println("X");

				// Variable to hold the server's response message
				String serverMsg = "";
				// Read messages coming from the client until the server says it is done sending
				// messages
				// (indicated by message X)
				while ((serverMsg = streamIn.readLine()) != null) {
					if (serverMsg.toUpperCase().equals("X")) {
						break;
					}
					System.out.println("Server response: " + serverMsg);
				}

				// Ask the user if they're done
				do {
					ind = validateStringInput("Enter Y to continue. Enter X to quit.", consoleIn);
				} while ((!ind.toUpperCase().equals("Y")) && !ind.toUpperCase().equals("X"));
			} while ((!ind.toUpperCase().equals("X")));

			// When the user is done, stop the client
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
