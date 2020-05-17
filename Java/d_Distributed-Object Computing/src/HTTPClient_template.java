
/* 
 * HTTP is used with the Internet to get pages/resources from a web server and return them to a client (browser)
 * The pages/resources can be in a variety of formats, HTML is the most common
 * URLs identify the resources that is being requested
 * 
 * Visit https://www.w3.org/Protocols/rfc2616/rfc2616.html to view the HTTP specification
 * 
 * HTTP client request format:
 * 		>> Start-Line: Describes the type of request being made, the resource that is being requested
 * 		   and the HTTP protocol version being used
 * 				>> HTTP method (ex. GET or POST) (List of methods can be found in the HTTP specification
 * 				   at: https://www.w3.org/Protocols/rfc2616/rfc2616-sec5.html#sec5.1.1)
 * 				>> Resource (ex. URL or local path)
 * 				>> HTTP version (ex. 1.1)
 * 		
 * 		>> 0+ Header Lines: Provides more information about the request beyond what is contained in 
 * 		   the starter line (List of headers can be found in the HTTP specification at: 
 *         https://www.w3.org/Protocols/rfc2616/rfc2616-sec5.html#sec5.3)
 * 
 * 		>> Blank Line: Separates the response metadata from the response data
 * 
 * 		>> Message Body: Response data (ex. HTML)
 * 
 * 		EXAMPLES:
 * 		Navigating to: https://www.w3.org/Protocols/rfc2616/rfc2616-sec5.html
 * 		GET /Protocols/rfc2616/rfc2616-sec14.html HTTP/1.1
 * 		Host: www.w3.org
 * 
 * 		POST /src/test.html HTTP/1.1
 * 		Host: localhost
 * 		
 * 		firstname=Kelsey&lastname=Kirk
 * 
 * HTTP server response format:
 * 		>> Start-Line: Describes the response with a status code and a status description
 * 				>> HTTP version (ex. 1.1)
 * 				>> Status code (ex. 200 or 404) (List of statuses can be found in the HTTP specification
 *                 at: https://www.w3.org/Protocols/rfc2616/rfc2616-sec6.html#sec6)
 * 				>> Status text (ex. Not Found) (List of statuses can be found in the HTTP specification
 *                 at: https://www.w3.org/Protocols/rfc2616/rfc2616-sec6.html#sec6)
 * 		
 * 		>> 0+ Header Lines: Provides more information about the response beyond what is contained in
 * 		   the starter-line
 * 
 * 		>> Blank Line: Separates the response metadata from the response data
 * 
 * 		>> Message Body: Response data (ex. HTML)
 * 
 * 		EXAMPLES:
 * 		Navigating to: https://www.w3.org/Protocols/rfc2616/rfc2616-sec5.html
 * 		HTTP/1.1 200 OK
 * 		Content-Type: text/html
 * 		<!DOCTYPE html 
 *    	PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
 *    	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
 *		<html xmlns='http://www.w3.org/1999/xhtml'>
 *			<head><title>HTTP/1.1: Request</title></head>
 *			<body><address>part of <a rev='Section' href='rfc2616.html'>Hypertext Transfer Protocol -- HTTP/1.1</a><br />
 *				RFC 2616 Fielding, et al.</address>
 *					<h2><a id='sec5'>5</a> Request</h2>
 *					<p>
 *    					A request message from a client to a server includes, within the
 *   					first line of that message, the method to be applied to the resource,
 *   					the identifier of the resource, and the protocol version in use.
 *					</p>
 *			</body>
 *		</html>
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class HTTPClient_template {
	// Class-level variables and constants
	final static String HTTP_VER = " HTTP/1.0";
	final static String HTTP_GET = "GET ";
	final static String HTTP_POST = "POST ";
	final static String HTTP_RESOURCE = "/src/test.html";
	final static String LINE_BRK = "\r\n";

	public static void main(String[] args) {
		try {
			// Display a message that the server started
			System.out.println("Client started");

			// Setup client sockets and establish server connection on port localhost port
			// 80 (default for HTTP)
			InetAddress localAddress = InetAddress.getLocalHost();
			Socket clientSocket = new Socket(localAddress, 80);

			// Display successful connection message after socket has been created
			System.out.println("Successfully connected to the server");

			// Setup to read from and write to client
			BufferedReader streamIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			OutputStream streamOut = clientSocket.getOutputStream();

			// Variables to gather user input and build HTTP request
			Scanner scanner = new Scanner(System.in);
			String input = "";
			StringBuilder httpRequest = new StringBuilder(); // help build HTTP request

			// Ask the user which type of request they want to send
			do {
				System.out.println("Enter G to send a GET request. Enter P to send a POST request.");
				input = scanner.nextLine();
			} while (!(input.toUpperCase().equals("G") || input.toUpperCase().equals("P")));

			scanner.close();

			// Format the HTTP request
			if (input.toUpperCase().equals("G")) {
				httpRequest.append(HTTP_GET);
			} else {
				httpRequest.append(HTTP_POST);
			}

			httpRequest.append(HTTP_RESOURCE);
			httpRequest.append(HTTP_VER);
			httpRequest.append(LINE_BRK);

			// Preview HTTP Request in client's console
			System.out.println(httpRequest);
			System.out.println("");

			// Send HTTP Request to server
			streamOut.write(httpRequest.toString().getBytes());

			// Get HTTP Response from server and display it in the client's console
			String responseLine = "";
			StringBuilder httpResponse = new StringBuilder();

			while ((responseLine = streamIn.readLine()) != null) {
				httpResponse.append(responseLine).append("\n");
			}

			System.out.println(httpResponse);

			// Stop the client
			streamOut.close();
			clientSocket.close();

			System.out.println("Client stopped");
			System.exit(0);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
