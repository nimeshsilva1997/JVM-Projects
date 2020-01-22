import java.util.Arrays;
import java.util.Scanner;

public class testExtraCredit2
{
	public static void main(String[] arg)
	{
		String yes;
		do
		{
			firstRate(0);
			System.out.println("");
			secondRate(0);
			System.out.println("");
			thirdRate(0);
			System.out.println("");					
			@SuppressWarnings("resource")
			Scanner next = new Scanner(System.in);
			System.out.println("Would you like to try again? "
					+ "Please type Y to start again or N to end program:");
			yes = next.nextLine();
		}
		
		while(yes.equals("Y"));
		}
		
	
   	public static int firstRate (int interestRate)
    {
    	 @SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);

        int count = 0;
        double interest = 0;
                  
        System.out.println("Please enter the number one in order to "
        		+ "populate array and display one time (Ex. 1): ");
        int threeToPopulateArray = keyboard.nextInt();                 

        int[] bankRate = new int[threeToPopulateArray];

        do
        {
            System.out.println("Please enter your rate without decimal numbers. "
            		+ "(*Note: Rate you enter will appear from smallest to largest): ");
            interestRate = keyboard.nextInt();
            bankRate[count]= interestRate;
            count++;
            

        } while (count < threeToPopulateArray);

        Arrays.sort(bankRate);

        for(count=0; count < bankRate.length; count++)
        {
        	System.out.println("Rate you entered was: " + bankRate[count] + "%. ");

        }
        
        System.out.println("Please enter your loan amount: ");
        double loanAmount = keyboard.nextDouble();
        
        System.out.println("");
        
		interest = loanAmount * interestRate;
        System.out.println("At an interest rate of " + interestRate 
        		+ "%, you will pay this amount of interest, $" + interest + 
        		", on a loan of $" + loanAmount + ".");
        //System.out.println("The average of grades entered is: " + totalAverage);
    	
       
		return interestRate;
    }
        
   	public static int secondRate (int interestRate2)
    {
    	 @SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);

        int count = 0;
        double interest = 0;
        
        //double loanAmount = 0;
        
        System.out.println("Please enter the number one in order to "
        		+ "populate array and display one time (Ex. 1): ");
        int threeToPopulateArray = keyboard.nextInt();                 

        int[] bankRate = new int[threeToPopulateArray];

        do
        {
            System.out.println("Please enter your rate without decimal numbers. "
            		+ "(*Note: Rate you enter will appear from smallest to largest): ");
            interestRate2 = keyboard.nextInt();
            bankRate[count]= interestRate2;
            count++;
            

        } while (count < threeToPopulateArray);

        Arrays.sort(bankRate);

        for(count=0; count < bankRate.length; count++)
        {
        	System.out.println("Rate you entered was: " + bankRate[count] + "%. ");

        }
        
        System.out.println("Please enter your loan amount: ");
        double loanAmount = keyboard.nextDouble();
        
        System.out.println("");
        
		interest = loanAmount * interestRate2;
        System.out.println("At an interest rate of " + interestRate2 
        		+ "%, you will pay this amount of interest, $" + interest + 
        		", on a loan of $" + loanAmount + ".");
        //System.out.println("The average of grades entered is: " + totalAverage);
    	
       
		return interestRate2;
    }
   	public static int thirdRate (int interestRate3)
    {
    	 @SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);

        int count = 0;
        double interest = 0;
        
        //double loanAmount = 0;
        
        System.out.println("Please enter the number one in order to "
        		+ "populate array and display one time (Ex. 1): ");
        int threeToPopulateArray = keyboard.nextInt();                 

        int[] bankRate = new int[threeToPopulateArray];

        do
        {
            System.out.println("Please enter your rate without decimal numbers. "
            		+ "(*Note: Rate you enter will appear from smallest to largest): ");
            interestRate3 = keyboard.nextInt();
            bankRate[count]= interestRate3;
            count++;
            

        } while (count < threeToPopulateArray);

        Arrays.sort(bankRate);

        for(count=0; count < bankRate.length; count++)
        {
        	System.out.println("Rate you entered was: " + bankRate[count] + "%. ");

        }
        
        System.out.println("Please enter your loan amount: ");
        double loanAmount = keyboard.nextDouble();
        
        System.out.println("");
        
		interest = loanAmount * interestRate3;
        System.out.println("At an interest rate of " + interestRate3 
        		+ "%, you will pay this amount of interest, $" + interest + 
        		", on a loan of $" + loanAmount +".");
        //System.out.println("The average of grades entered is: " + totalAverage);
    	
       
		return interestRate3;
    }
}
   	
    
    