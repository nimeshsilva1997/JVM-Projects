/*
 * Nimesh Silva
 * IST 411: Section 001
 * Lab 3
 * April 8th, 2020
 */

package ws.soap.server;


import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class InterestCalculatorWS {
	@WebMethod
	public double calculateInterest (double p, double r, int y) {
		double in = (p * r * y); //Calculates simple interest
		
		return in; //returns double
		}
	}


