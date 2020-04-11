/*
Nimesh Silva
IST 411: Distributed-Object Computing
April 11, 2020
 */
//Reads JSON data from the bankAccounts.json file
import model.BankAcct;

import javax.json.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

public class BankAcctJsonReader {

    public static void main(String[] args) throws IOException {

        //References to the bankAccounts.json file
    	String bankAcctsJsonFile = "/bankAccounts.json";

    	//Creates an instace of the BankAcctJsonReader class
        BankAcctJsonReader bajr = new BankAcctJsonReader();

        /*
        Uses the BankAcctJSonReader and its buildBankAcctsList method to retrieve a list of bank account instaces created from the JSON data in the bankAccounts.json file
         */
        ArrayList<BankAcct> bankAccts = bajr.buildBankAcctsList(bankAcctsJsonFile);

        //Prints the BankAccounts objects from the List
        System.out.println("***BANK ACCOUNT OBJECTS CREATED FROM JSON DATA IN BANKACCOUNTS.JSON FILE***");
        System.out.println(bankAccts.toString());							
    }

    /*
    Reads json ata from the bankAccounts.json file and creates a JsonArray. Creates an instance of bank account for each element in the JsonArray
     */
    public ArrayList<BankAcct> buildBankAcctsList(String bankAcctsJsonFile) throws IOException {
        //Holds instaces of BankAcct that will be generated from the bankAccounts.json file
    	ArrayList<BankAcct> bankAcctsList = new ArrayList<BankAcct>();

    	//Holds data being read from bankAccounts.json file
        InputStream in = null;

        //Reads JSON data and generates JsonObject or JsonArray
        JsonReader jRdr = null;									
        try {

            //Accesses the bankAccount.json file
            in = getClass().getResourceAsStream(bankAcctsJsonFile);
        	//File bankAcctFile = new File(bankAcctsJsonFile);
        	//Reader streamIn = new InputStreamReader(new FileInputStream(bankAcctsJsonFile), "UTF-8");

           //Gets data from the bankAccount.json file
            Reader streamIn = new InputStreamReader(in, "UTF-8");

            //Reads the JSON data in the stream
            jRdr = Json.createReader(streamIn);

            //Uses the JSON data in the reader an the reader's readArray method to create a Json Array
            JsonArray bankAcctsArray = jRdr.readArray();

            //Iterates through each element in the Json Array
            for (JsonValue jVal : bankAcctsArray) {
                if (jVal.getValueType().equals(JsonValue.ValueType.OBJECT)) {

                    //Uses the JsonObject and its data to create an instace of the Animal class
                    JsonObject jObj = (JsonObject) jVal;
                    BankAcct bankAcct = new BankAcct();
                    bankAcct.setAcctId(jObj.getInt("acctId"));
                    bankAcct.setFirstName(jObj.getString("firstName"));
                    bankAcct.setLastName(jObj.getString("lastName"));
                    bankAcct.setAcctBal(jObj.getInt("acctBal")); 
                    bankAcct.setRate(jObj.getInt("rate"));
                    bankAcct.setTerm(jObj.getInt("term"));

                    //Adds the instace of bankAcct to the ArrayList
                    bankAcctsList.add(bankAcct);
                }
            }
        } finally {
            //Closes the stream
            if (in != null) {
                in.close();
            }
            //Closes the reader
            if (jRdr != null) {
                jRdr.close();
            }
        }
        //Passes the list back the the calling method
        return bankAcctsList;
    }
}
