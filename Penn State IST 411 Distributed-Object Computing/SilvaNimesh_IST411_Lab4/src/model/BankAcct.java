/*
Nimesh Silva
IST 411: Distributed-Object Computing
April 11, 2020
 */
/*
bankAccount.json file contains a set of data.
Using the JSON API in Java, it is converting that data fro mthe JSON format into a Java object by creating a class that mirrors the structure of the JSON data.
The BankAcct.java contains properties of getters and setters that represent each of the name/value pairs the bank account in the JSON array.
 */
package model;

public class BankAcct {
	private int acctId;
	private String firstName;
	private String lastName;
	private double acctBal;
	private double rate;
	private int term;
	
	public int getAcctId() {
		return acctId;
	}
	
	public void setAcctId(int acctId) {
		this.acctId = acctId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getAcctBal() {
		return acctBal;
	}

	public void setAcctBal(double acctBal) {
		this.acctBal = acctBal;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}
	
	@Override
    public String toString() {
        return "Bank Account{" + "acctId=" + acctId + ", firstName=" + firstName + ", lastName=" + lastName + ", acctBal=" + acctBal + ", rate=" + rate + ", term=" + term +"}";
    }
}
