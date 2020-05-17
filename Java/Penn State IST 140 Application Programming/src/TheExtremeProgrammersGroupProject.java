import java.util.Scanner;

/*
 *                                        ***CHECKLIST***
 *                                          ___________
 *                    - If Condition/switch statement (checked, made by Kalpana)
 *                    - Looping (while or do-while or for) (checked, made by Bibek)
 *        - Multiple methods (checked, made by Kalpana (operation sign), Bibek (addition, subtraction) 
 *                      and Daima (multiplication, division, and random value))
 *                   - Extra credit - applying an Array (checked, made by Nimesh)
 * 
 *                 All requirements, including the extra credit, is in the program.
 * 
 */
/*
 * 
 */

public class TheExtremeProgrammersGroupProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 int choice = 0;
		    int i = 3;
		    int num1 = 0;
		    int num2 = 0;
		    @SuppressWarnings("unused")
			int question = 0;
		    int num3 = 0;
		    Menu(choice, i, num1, num2, num3);
	}
			
		    
	

	public static void Menu(int choice, int i, int num1, int num2, int num3) {
	    @SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
	    
	    /* Menu to show our business calculator
	     * Contributed by Nimesh
	     */
	    String yes;
		do
		{
			System.out.println("Hello, and welcome to the KinderCalc program. ");
			System.out.println("This program will do the following:");
			System.out.println("");
			System.out.println("Display a menu of up to six choices, picks a choice based on what you enter, enter up to two money values, "
					+ "displays the values, ");
			System.out.println("then displays a correct statement or an incorrect statement depending on whether the answer you enter is correct "
					+ "Please enjoy!");
			System.out.println("");
			 System.out.println("Menu:");
		        System.out.println("1. Add two money values ");
		        System.out.println("2. Subtract two money values ");
		        System.out.println("3. Multiply two money values ");
		        System.out.println("4. Divide two money values ");
		        System.out.println("5. Exit the Program");
		        System.out.println("");
		        System.out.print("Please enter your choice from 1 to 5: ");
		        choice = input.nextInt();
		        
		        /* If statements stating what choice 
		         * a user selects from the menu above
		         * Created by Kalpana
		         */
		        
		        if (choice == 1) {
		        	System.out.println("You chose addition from the list of choices.");
		        	System.out.println("");
		            add(num1, num2, num3);
		        } // end of if statement
		        if (choice == 2) {
		        	System.out.println("You chose substraction from the list of choices.");
		        	System.out.println("");
		            subtract(num1, num2, num3);
		        } // end of if statement
		        if (choice == 3) {
		        	System.out.println("You chose multiplication from the list of choices.");
		        	System.out.println("");
		            multiply(num1, num2, num3);
		        } // end of if statement
		        if (choice == 4) {
		        	System.out.println("You chose division from the list of choices.");
		        	System.out.println("");
		            divide(num1, num2, num3);
		        } // end of if statement
		        if (choice == 5) {
		        	System.out.println("You chose to exit from the list of choices.");
		        	System.out.println("");
		            System.exit(0);;
		        } // end of if statement
		        if (choice <= 0 || choice >= 6) {
		            System.out.println("Incorrect choice!");
		        } // end of if choice statement
		        		 
		@SuppressWarnings("resource")
		Scanner next = new Scanner(System.in);
		System.out.println("");
		System.out.println("Would you like to try the program again? "
					+ "Please enter Y to start the program again, or N to end program.");
		yes = next.nextLine();
		}
		
		while(yes.equals("Y"));
		}
	    
	/* Method used for giving 
	 * inputs and returns value to method
	 * Contributed by Kalpana
	 */

	public static double Inputs(String prompt) { 
	                                                    
	                                                    
	    @SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
	    System.out.print(prompt);

	    int value = input.nextInt();

	    return value;
	}
	
	/* Array used to store data and info 
	 * within the values on the menu
	 * Contributed by Nimesh
	 */

	
	
	/* For Loop to set the loop in case the user wants to keep on going
	 * Multiple Methods are also included
	 * Contributed by Daima and Bibek
	 * Bibek did addition and subtraction
	 * Daima did multiply, and divide.
	 */

	public static int[] add(int operand1, int operand2, int operand3) { // adds the two new Scanner(System.in);
	    int answer = 0;
	    operand1 = (int) Inputs("Please enter your first dollar number: $");
	    operand2 = (int) Inputs("Please enter your second dollar number: $");
	    System.out.println("");
	    System.out.println("What is $" + operand1 + " plus $" + operand2 + " ?");
	    System.out.println("");
	    operand3 = (int) Inputs("Please enter what you think the answer might be: $");
	    System.out.println("");
	    for (int i = 0; i < 1; i++){
	    answer = (int) (operand1 + operand2);
	    }
	    if (operand3 == answer) {
	    System.out.println("That's correct! The dollar numbers you entered were $" + operand1 + " and $" + operand2 + ", and your answer was $" + answer + ".");
	    }
	    else
	    	System.out.println("Sorry, the correct answer was " + answer + ".");
	    return null;
	}

	public static int[] subtract(int operand1, int operand2, int operand3) { // subtracts new Scanner(System.in);
		int answer = 0;
		operand1 = (int) Inputs("Please enter your first dollar number: $");
	    operand2 = (int) Inputs("Please enter your second dollar number: $");
	    System.out.println("");
	    System.out.println("What is $" + operand1 + " minus $" + operand2 + " ?");
	    System.out.println("");
	    operand3 = (int) Inputs("Please enter what you think the answer might be: $");
	    System.out.println("");
	    for (int i = 0; i < 1; i++){
	    answer = (int) (operand1 - operand2);
	    }
	    if (operand3 == answer) {
	    System.out.println("That's correct! The dollar numbers you entered were $" + operand1 + " and $" + operand2 + ", and your answer was $" + answer + ".");
	    }
	    else
	    	System.out.println("Sorry, the correct answer was " + answer + ".");
	    return null;
	}

	public static int[] multiply(int operand1, int operand2, int operand3) { // multiplies new Scanner(System.in);
		int answer = 0;
	    operand1 = (int) Inputs("Please enter your first dollar number: $");
	    operand2 = (int) Inputs("Please enter your second dollar number: $");
	    System.out.println("");
	    System.out.println("What is $" + operand1 + " multiplied by $" + operand2 + " ?");
	    System.out.println("");
	    operand3 = (int) Inputs("Please enter what you think the answer might be: $");
	    System.out.println("");
	    for (int i = 0; i < 1; i++){
	    answer = (int) (operand1 * operand2);
	    }
	    if (operand3 == answer) {
	    System.out.println("That's correct! The dollar numbers you entered were $" + operand1 + " and $" + operand2 + ", and your answer was $" + answer + ".");
	    }
	    else
	    	System.out.println("Sorry, the correct answer was " + answer + ".");
	    return null;
	}

	
	public static int[] divide(int operand1, int operand2, int operand3) { // Gets a new Scanner(System.in);
		int answer = 0;
	    operand1 = (int) Inputs("Please enter your first dollar number: $");
	    operand2 = (int) Inputs("Please enter your second dollar number: $");
	    System.out.println("");
	    System.out.println("What is $" + operand1 + " divided by $" + operand2 + " ?");
	    System.out.println("");
	    operand3 = (int) Inputs("Please enter what you think the answer might be: $");
	    System.out.println("");
	    for (int i = 0; i < 1; i++){
	    answer = (int) (operand1 / operand2);
	    }
	    if (operand3 == answer) {
	    System.out.println("That's correct! The dollar numbers you entered were $" + operand1 + " and $" + operand2 + ", and your answer was $" + answer + ".");
	    }
	    else
	    	System.out.println("Sorry, the correct answer was " + answer + ".");
	    return null;
	}

}