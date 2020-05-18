package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.text.DecimalFormat;

public class InterestCalcServer_template {

	public static void main(String[] args) {
		System.out.println("Server started");

		try {
			// Setup server sockets and listen for client connection on port 6000
			ServerSocket serverSocket = new ServerSocket(6000);
			System.out.println("Waiting for connection to client");
			Socket clientSocket = serverSocket.accept();
			System.out.println("Successfully connected to client");

			// Setup to read from and write to client
			BufferedReader streamIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter streamOut = new PrintWriter(clientSocket.getOutputStream(), true);

			// Continue to listen for client messages until client terminates
			do {
				// Variables to hold input coming from client and accumulate final values for
				// processing
				String clientMsg = "";
				double rate = 0.0;
				int term = 0;
				double bal = 0.0;
				int counter = 0;
				double totalInt = 0.0;
				DecimalFormat df = new DecimalFormat("0.00");

				// Read messages coming from the client until the client says it is done sending
				// messages
				// (indicated by message X)
				while ((clientMsg = streamIn.readLine()) != null) {
					if (clientMsg.toUpperCase().equals("X")) {
						break;
					}
					System.out.println("The incoming message from the client is: " + clientMsg);

					if (counter == 0) {
						bal = Double.parseDouble(clientMsg);
					} else if (counter == 1) {
						rate = Double.parseDouble(clientMsg);
					} else {
						term = Integer.parseInt(clientMsg);
					}
					counter++;
				}
				// Calculate average grade and determine corresponding letter grade
				for (int t = 0; t < term; t++) {
					totalInt += (bal * (rate / 100));
					bal += (bal * (rate / 100));
				}
				// Send average grade and letter grade back to the client
				streamOut.println("The total interest is: " + df.format(totalInt));
				streamOut.println("The new balance is: $" + df.format(bal));

				// Tell the client the server is done sending messages
				streamOut.println("X");
			} while (true);
		} catch (SocketException ex) {
			System.out.println("Client closed. Server stopped.");
			System.exit(0);
		} catch (IOException ex) {
			System.out.println("Exception occurred");
			ex.printStackTrace();
		}

	}

}
