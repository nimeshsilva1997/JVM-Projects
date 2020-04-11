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
