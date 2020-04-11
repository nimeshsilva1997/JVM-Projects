//Generate JSON data from a JsonObject and write the JSON data to the file
import model.BankAcct;

import javax.json.Json;
import javax.json.stream.JsonGenerator;
import java.io.*;
import java.util.ArrayList;

public class BankAcctJsonGenerator {
    public static void main(String[] args) throws IOException {  
    	String newBankAcctsJsonFile = "newBankAccts.json";              
    	BankAcctJsonGenerator bajg = new BankAcctJsonGenerator();                
        bajg.writeBankAccountsList(newBankAcctsJsonFile);        
    }
    
    public void writeBankAccountsList(String newBankAcctsJsonFile) throws IOException {    	
        ArrayList<BankAcct> bankAccts = getBankAcctsList();							     
        System.out.println("***BANK ACCOUNT OBJECTS WRITTEN AS JSON DATA TO NEWBANKACCOUNTS.JSON FILE***");
        System.out.println(bankAccts.toString());                
        OutputStream streamOut = new FileOutputStream(newBankAcctsJsonFile);              
        Writer wtr = new OutputStreamWriter(streamOut, "UTF-8");                     
        JsonGenerator jGtr = Json.createGenerator(wtr);                             
        jGtr.writeStartArray();               
        for (BankAcct bankAcct : bankAccts) {        	
            jGtr.writeStartObject();                 
            double newAcctBal = bankAcct.getAcctBal() * bankAcct.getRate() * bankAcct.getTerm();
            jGtr.write("acctId", bankAcct.getAcctId());                       
            jGtr.write("firstName", bankAcct.getFirstName());                        
            jGtr.write("lastName", bankAcct.getLastName());  
            jGtr.write("acctBal", newAcctBal);
            jGtr.write("rate", bankAcct.getRate());
            jGtr.write("term", bankAcct.getTerm());
            jGtr.writeEnd();
        }        
        jGtr.writeEnd();
        wtr.flush();
        jGtr.close();
        wtr.close();
        streamOut.close();
    }
    
    private ArrayList<BankAcct> getBankAcctsList() throws IOException {    	
    	String bankAcctsJsonFile = "/bankAccounts.json";    	    	
        BankAcctJsonReader ajr = new BankAcctJsonReader();				           
        ArrayList<BankAcct> animals = ajr.buildBankAcctsList(bankAcctsJsonFile);        
        return animals;
    }
}
