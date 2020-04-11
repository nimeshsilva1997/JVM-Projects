
import model.BankAcct;

import javax.json.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

public class BankAcctJsonReader {

    public static void main(String[] args) throws IOException {
    	String bankAcctsJsonFile = "/bankAccounts.json";
        BankAcctJsonReader bajr = new BankAcctJsonReader();	        
        ArrayList<BankAcct> bankAccts = bajr.buildBankAcctsList(bankAcctsJsonFile);              
        System.out.println("***BANK ACCOUNT OBJECTS CREATED FROM JSON DATA IN BANKACCOUNTS.JSON FILE***");
        System.out.println(bankAccts.toString());							
    }

    public ArrayList<BankAcct> buildBankAcctsList(String bankAcctsJsonFile) throws IOException {
    	ArrayList<BankAcct> bankAcctsList = new ArrayList<BankAcct>();		        
        InputStream in = null;									       
        JsonReader jRdr = null;									
        try {        	
            in = getClass().getResourceAsStream(bankAcctsJsonFile);
        	//File bankAcctFile = new File(bankAcctsJsonFile);
        	//Reader streamIn = new InputStreamReader(new FileInputStream(bankAcctsJsonFile), "UTF-8");    
            Reader streamIn = new InputStreamReader(in, "UTF-8");            
            jRdr = Json.createReader(streamIn);                        
            JsonArray bankAcctsArray = jRdr.readArray();            
            for (JsonValue jVal : bankAcctsArray) {
                if (jVal.getValueType().equals(JsonValue.ValueType.OBJECT)) {                	
                    JsonObject jObj = (JsonObject) jVal;
                    BankAcct bankAcct = new BankAcct();
                    bankAcct.setAcctId(jObj.getInt("acctId"));
                    bankAcct.setFirstName(jObj.getString("firstName"));
                    bankAcct.setLastName(jObj.getString("lastName"));
                    bankAcct.setAcctBal(jObj.getInt("acctBal")); 
                    bankAcct.setRate(jObj.getInt("rate"));
                    bankAcct.setTerm(jObj.getInt("term"));
                    bankAcctsList.add(bankAcct);
                }
            }
        } finally {        	
            if (in != null) {
                in.close();
            }
            if (jRdr != null) {
                jRdr.close();
            }
        }       
        return bankAcctsList;
    }
}
