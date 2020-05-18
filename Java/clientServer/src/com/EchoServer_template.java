package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/*
 *  Servers provide a service/response to a client after receiving a request. They are identified by an IP address 
 *  and a port number (since multiple servers can run on the same machine, and the machine only has one IP address)
 * 
 *  Clients request something from a server and receive a response back.  
 *  
 *  The client/server communication can be as simple as messages, which we'll see in this example.
 *  
 *  Sockets are used to facilitate the client/server communication.  Both the client and the server each have a socket.
 *  These sockets must be connected in order for the communication to happen.  There are different types of sockets that you
 *  can use depending on the type of communication that is happening, but we will be working with TCP sockets in this example.
 *  
 *  This program will represent the server component. It will send a string to the client as a request, and await a string
 *  response from the client. 
 */
public class EchoServer_template {

	public static void main(String[] args) {
		// Display message that the server application started
		System.out.println("Server started");

		try {
			/*
			 * Use the ServerSocket to create a socket on the server that will listen for
			 * requests on port 6000
			 * 
			 * The server socket doesn't need to reference the server's IP address, but the
			 * client socket will need this information so that it knows where to send its
			 * requests
			 */
			ServerSocket serverSocket = new ServerSocket(6000);

			// Display message that the server application is waiting to connect
			System.out.println("Waiting for a connection to the client");

			/*
			 * Call the accept() method on the server socket to wait for a request from the
			 * client once its connected
			 * 
			 * This suspends the server program until a request is received from the client,
			 * the ServerSocket that is returned represents the connection between the
			 * client application and the server application
			 */
			Socket clientSocket = serverSocket.accept();

			// Display message that the connection was successfully established
			System.out.println("Successfully connected to the client");

			/*
			 * Use the BufferedReader to read the messages coming from the client
			 * 
			 * Call the getInputStream() method on the client socket to access the incoming
			 * messages from the client
			 */
			BufferedReader streamIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

			/*
			 * Use the PrintWriter to write the responses to send to the client
			 * 
			 * Call the getOutputStream() method on the client socket to access the outgoing
			 * messages to the client
			 */
			PrintWriter streamOut = new PrintWriter(clientSocket.getOutputStream(), true);

			// Variable will store each line that is read from the BufferedReader
			String clientMsg;

			// Use the BufferedReader to incoming messages from the client and loop until
			// there is nothing left to read
			while ((clientMsg = streamIn.readLine()) != null) {
				// Display the incoming message from the client in the server's console
				System.out.println(clientMsg);

				// Send outgoing message back to the client
				streamOut.println("The server echoes your message: " + clientMsg + clientMsg + clientMsg);
			}
		} catch (SocketException ex) {
			System.out.println("Server stopped");
			System.exit(0);
		} catch (IOException ex) {
			System.out.println("Exception occurred");
			ex.printStackTrace();
		}

	}

}
