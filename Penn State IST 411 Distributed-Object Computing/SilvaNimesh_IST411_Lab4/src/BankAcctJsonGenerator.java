/*
Nimesh Silva
IST 411: Distributed-Object Computing
April 11, 2020
 */
//Generate JSON data from a JsonObject and write the JSON data to the newBankAccts.json file
import model.BankAcct;

import javax.json.Json;
import javax.json.stream.JsonGenerator;
import java.util.ArrayList;

public class BankAcctJsonGenerator {
    public static void main(String[] args) throws IOException {
        //Reference to the netBackAccts.json file (outputs file where JON data will be written to)
    	String newBankAcctsJsonFile = "newBankAccts.json";

    	//Creates and instance of the BankAcctJSonGenerator class
    	BankAcctJsonGenerator bajg = new BankAcctJsonGenerator();

    	//Uses the BankAcctJsonGenerator and its writeBankAccountList
        //method to write Bank Account data in JSON format to the newBankAccts.json file
        bajg.writeBankAccountsList(newBankAcctsJsonFile);        
    }
    //Generates json data from a JSonObject (based on the newBankAccts.json file) and writes it to the newBankAccts.json
    public void writeBankAccountsList(String newBankAcctsJsonFile) throws IOException {
        //Holds instances of Bank Account generate by reader from newBankAccrs.json file
        ArrayList<BankAcct> bankAccts = getBankAcctsList();

        //Prints instances of Bank Account objects from the List
        System.out.println("***BANK ACCOUNT OBJECTS WRITTEN AS JSON DATA TO NEWBANKACCOUNTS.JSON FILE***");
        System.out.println(bankAccts.toString());

        //Holds data being written to newBankAccts.json file
        OutputStream streamOut = new FileOutputStream(newBankAcctsJsonFile);

        //Writes data to the newBankAccts.json file
        Writer wtr = new OutputStreamWriter(streamOut, "UTF-8");

        //Writes JSON data to an output source. uses the writer and output stream to access the output source
        JsonGenerator jGtr = Json.createGenerator(wtr);

        //JSON data will be an array of bank accounts. Writes the start character for the JSON array
        jGtr.writeStartArray();

        //Interates through each element (object) in the list
        for (BankAcct bankAcct : bankAccts) {
            //Writes the start character for the JSON object
            jGtr.writeStartObject();
            double newAcctBal = bankAcct.getAcctBal() * bankAcct.getRate() * bankAcct.getTerm();

            //Writes the JSON name/value pair for the attributes
            jGtr.write("acctId", bankAcct.getAcctId());                       
            jGtr.write("firstName", bankAcct.getFirstName());                        
            jGtr.write("lastName", bankAcct.getLastName());  
            jGtr.write("acctBal", newAcctBal);
            jGtr.write("rate", bankAcct.getRate());
            jGtr.write("term", bankAcct.getTerm());

            //Writes the end character for the JSON array
            jGtr.writeEnd();
        }        
        jGtr.writeEnd();

        //Clean up, Flushes the writer, closes the generator, writer, an output stream
        wtr.flush();
        jGtr.close();
        wtr.close();
        streamOut.close();
    }

    //Uses BankAcctJSsonReader to create and return a list of Bank Accounts generated from JSON data in the newBankAccts.json file
    private ArrayList<BankAcct> getBankAcctsList() throws IOException {
        //Reference to the bankAccounts.json file
    	String bankAcctsJsonFile = "/bankAccounts.json";

    	//Create an instance of the BankAcctJsonReader class
        BankAcctJsonReader ajr = new BankAcctJsonReader();

        //Use the BankAcctJSonReader and its buildBankAcctsList metho to retrieve a List of Bank Account instances created from the JSON data in the newBankAccts.json file
        ArrayList<BankAcct> animals = ajr.buildBankAcctsList(bankAcctsJsonFile);        
        return animals;
    }
}
