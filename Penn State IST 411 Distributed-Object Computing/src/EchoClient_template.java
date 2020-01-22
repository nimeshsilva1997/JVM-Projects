import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

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
 *  This program will represent the client component. It will send a string to the server as a request, and await a string
 *  response from the server. 
 */
public class EchoClient_template {

	public static void main(String[] args) {
		try {
			// Display message that the client application started
			System.out.println("Client started");

			// Display message that the client application is waiting to connect
			System.out.println("Waiting for a connection to the server");

			/*
			 * InetAddress class represents an IP address, in this case the IP address of
			 * the localhost (this computer, with IP address 127.0.0.1)
			 */
			InetAddress localAddress = InetAddress.getLocalHost();

			/*
			 * Use the ServerSocket to create a socket on the client that will connect to
			 * the localhost (this computer, with IP address 127.0.0.1) and send requests on
			 * port 6000
			 * 
			 * This is the IP address of the machine running the server program, and
			 * references the port that the server will be listening on
			 */
			Socket clientSocket = new Socket(localAddress, 6000);

			/*
			 * Use the PrintWriter to write the requests to send to the server
			 * 
			 * Call the getOutputStream() method on the client socket to access the outgoing
			 * messages to the server
			 */
			PrintWriter streamOut = new PrintWriter(clientSocket.getOutputStream(), true);

			/*
			 * Use the BufferedReader to read the messages coming from the client
			 * 
			 * Call the getInputStream() method on the client socket to access the incoming
			 * messages from the server
			 */
			BufferedReader streamIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

			// Display message that the connection was successfully established
			System.out.println("Sucessfully connected to the server");

			// Use the Scanner to read user input from the client's console
			Scanner consoleIn = new Scanner(System.in);

			while (true) {
				// Prompt user to enter input
				System.out.println("Enter a message to send to the server. Enter X to exit");

				// Variable will store user's input
				String input = consoleIn.nextLine();

				// Determines if the user wants to exit
				if ("X".equalsIgnoreCase(input)) {
					break;
				}

				// Sends outgoing message to the server
				streamOut.println(input);

				// Uses the BufferedReader to retrieve the incoming (response) messages from the
				// server
				String serverResponse = streamIn.readLine();
				// Displays the incoming message from the server in the client's console
				System.out.println(serverResponse);
			}
		} catch (IOException ex) {
			System.out.println("Exception occurred");
			ex.printStackTrace();
		}

	}

}
