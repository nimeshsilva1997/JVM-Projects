/*
 * Nimesh Silva
 * IST 411: Section 001
 * Lab 3
 * April 8th, 2020
 */

package ws.soap.server;

import javax.xml.ws.Endpoint;

public class InterestCalculatorWSServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "http://localhost:2525/InterestCalculatorWS"; //Asks the server for the URL
		InterestCalculatorWS ws = new InterestCalculatorWS();
		Endpoint.publish(url, ws);
		System.out.println("Server started..." + url); //Let's the user know that the server has started

	}

}
