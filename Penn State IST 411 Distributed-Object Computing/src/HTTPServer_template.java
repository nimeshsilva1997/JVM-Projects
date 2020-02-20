
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
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class HTTPServer_template implements Runnable {
	// Class-level variables and constants
	final static String HTTP_VER = "HTTP/1.0 ";
	final static String HTTP_GET = "GET";
	final static String LINE_BRK = "\r\n";
	final static String HTTP_200 = "200 OK" + LINE_BRK;
	final static String HTTP_405 = "405 Method Not Allowed" + LINE_BRK;
	public static Socket clientSocket;

	/*
	 * Create a constructor that will assign each client connection to the
	 * clientSocket property of the ThreadedSerializerServer instance
	 */
	public HTTPServer_template(Socket pClientSocket) {
		clientSocket = pClientSocket;
	}

	public static void main(String[] args) {
		try {
			// Display a message that the server started
			System.out.println("Server started");

			// Setup server sockets and listen for client connection on port 80 (the default
			// for HTTP)
			ServerSocket serverSocket = new ServerSocket(80);

			/*
			 * Continuously listen for and accept client requests
			 * 
			 * This construct allows us to have multiple client connections
			 */
			while (true) {
				// Assign the current client connection to the clientSocket property
				clientSocket = serverSocket.accept();

				// Create a server instance and a new thread for each client connection
				HTTPServer_template httpServer = new HTTPServer_template(clientSocket);

				// Thread.start() method calls the run() method
				new Thread(httpServer).start();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			// Display a message that a thread was started
			System.out.println("*************************************");
			System.out.println("Connected to a client using thread: " + Thread.currentThread());

			// Setup to read from and write to client
			BufferedReader streamIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			DataOutputStream streamOut = new DataOutputStream(clientSocket.getOutputStream());

			// Variables to hold input coming from client
			String httpRequest = streamIn.readLine(); // Stores the HTTP request from the client
			StringTokenizer strTok = new StringTokenizer(httpRequest); // Used to parase the HTTP request from the
																		// client
			String requestMethod = ""; // Stores the HTTP Method from the HTTP

			// Variables to hold response values
			StringBuilder responseBody = new StringBuilder(); // Stroes HTML from test.html
			StringBuilder httpResponse = new StringBuilder(); // Stores the HTTP response
			String responseServerHeader = "Server: HTTPServer_template" + LINE_BRK; // Stores the name
			String responseContentTypeHeader = "Content-Type: text/html" + LINE_BRK; // Stores the media type
			String responseContentLength = "";

			// Stores the HTTP request from the client
			// Used to parse HTTP request from client
			// Stores the HTTP Method from the HTTP request from client

			// Variables to hold response values
			// Stores HTML from test.html file
			// Store the HTTP Response the server will send to the client
			// Stores the name of the server program
			// Stores the media type (in our case text/html)
			// Stores the length of the responseBody (length of HTML)

			// Get the HTTP method from the request
			requestMethod = strTok.nextToken();

			if (requestMethod.equals(HTTP_GET)) {
				System.out.println("************");
				System.out.println("HTTP Request on Thread: " + Thread.currentThread());
				System.out.println("HTTP Request method: " + requestMethod);

				String requestQuery = strTok.nextToken();
				System.out.println("HTTP Request resource " + requestQuery);

				BufferedReader fileIn = new BufferedReader(new FileReader("test.html"));
				String fileLine = "";
				while ((fileLine = fileIn.readLine()) != null) {
					responseBody.append(fileLine);
				}
				fileIn.close();

				responseContentLength = "Content-Length: " + responseBody.toString().length() + LINE_BRK;

				httpResponse.append(HTTP_VER);// Starter-line: HTTP version
				httpResponse.append(HTTP_200);// Starter-line: HTTP status code and text
				httpResponse.append(responseServerHeader);// Headers: Server header
				httpResponse.append(responseContentTypeHeader);// Headers: Content-Type header
				httpResponse.append(responseContentLength);// Headers: Content-Length header
				httpResponse.append(LINE_BRK);// Blank line: Separates metadata from response data
				httpResponse.append(responseBody.toString());// Body: Response data (HTML from test.html)

				// Preview HTTP Response in server's console
				System.out.println("************");
				System.out.println("HTTP Request on Thread: " + Thread.currentThread());
				System.out.println(httpResponse.toString());

				// Send HTTP Response back to client
				streamOut.writeBytes(httpResponse.toString());
				streamOut.close();
			} else {
				System.out.println("************");
				System.out.println("HTTP Request on Thread: " + Thread.currentThread());
				System.out.println("HTTP Request method: " + requestMethod);

				httpResponse.append(HTTP_VER);
				httpResponse.append(HTTP_405);

				System.out.println("************");
				System.out.println("HTTP Request on Thread: " + Thread.currentThread());
				System.out.println(httpResponse.toString());

				streamOut.writeBytes(httpResponse.toString());
				streamOut.close();
			}
			// Terminate the thread by closing the socket
			System.out.println("*************************************");
			System.out.println(Thread.currentThread() + " terminated");
			clientSocket.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
