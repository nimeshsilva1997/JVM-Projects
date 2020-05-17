import java.util.Scanner;

public class HW4 {
   

	public static void main (String [] args) {
        /* Set up variables */
        float valueTemperature=0;
        String typeTemperature = "", fullInput = "";
        int counter = 0;
 
        /* Ask for input */
        speakIntroduction();
        Scanner in = new Scanner (System.in);
 
        while ((!fullInput.equals("quit")) && (!fullInput.equals("stop"))) {
            counter++;
            if (counter > 5) {
                /* Every 5 occurences, remind the user of the introduction */
                speakIntroduction();
                counter = 0;
            }
            /* Collect Input */
            System.out.println("");
            System.out.println("To quit, enter 'quit' or 'stop'.");
            System.out.print("Temperature to convert: "); //Calls Array from calculateOutput
            fullInput = in.nextLine();
 
            /* Parse Input */
            fullInput.trim();
            fullInput = fullInput.toLowerCase();
 
            //verify the string is not empty:
            if (fullInput.length() <=0) 
                continue;
 
            typeTemperature = fullInput.substring(fullInput.length()-1);
            /* Verify that requested temperature is numeric (float) */
            try {
                valueTemperature = Float.parseFloat(fullInput.substring(0,fullInput.length()-1));
            } catch(NumberFormatException nfe) {
                if ((!fullInput.equals("quit")) && (!fullInput.equals("stop"))) 
                    System.out.println("Please specify a numerical temperature.");
                continue;
            }
            /* Calculate Output */
            calculateOutput(typeTemperature, valueTemperature);
        }
        
        
        /* END */
        System.out.println(""); 
        System.out.println("Thank you!"); //End of program
 
    }
 
    /**
     * Prints the introduction text.
     */
    public static void speakIntroduction () { //menu
        System.out.println(""); 
        System.out.println("Please enter a temperature to convert.");
        System.out.println("Enter C/c for celsius or F/f for Fahrenheit");
        System.out.println("(Examples: 100C, 32f)\n"); 
        return;
    }
 
    /**
     * Calculates and outputs the converted temperature based 
     * on the parameters received by the user.
     *
     * @param typeOfTemperature   Temperature type, expects
     *                            C or c for Celsius, or 
     *                            F or f for Fahrenheit.
     * @param valueOfTemperature  Temperature value, expects
     *                            numerical representation (float)
     * @return boolean            returns TRUE if output caculated
     *                            successfully. FALSE otherwise.
     *
     */
    public static void calculateOutput (String typeOfTemperature, float valueOfTemperature) { //Array for beginning
        /* expected input: calculateOutput(typeTemperature, valueTemperature) */
        /* output 'true' if type is F/f/C/c, otherwise return false */
        String resultConvert = "", resultType = "";
        float convertedResult = 0;
 
        if (typeOfTemperature.equals("c")) { //if statement for c symbol for celcius
            /* convert to fahrenheit */
            convertedResult = 9 * valueOfTemperature /5 +32;
            resultConvert = " Celsius ";
            resultType = " Fahrenheit ";
        } else if (typeOfTemperature.equals("f")) { //if statement for f symbol for fahrenheit
            /* convert to celsius */
            convertedResult = 5*(valueOfTemperature - 32)/9;
            resultConvert = " Fahrenheit ";
            resultType = " Celsius ";
        } else { //else statement for specifying c or f
            System.out.println("Please specify C(celsius) or F(fahrenheit). Example: 32F or 100C");
            return;
        }
        /* Display Output */
        System.out.println(""); 
        System.out.println(valueOfTemperature + resultConvert + "is " + convertedResult + resultType);
        return;
    }
 
}
			

		