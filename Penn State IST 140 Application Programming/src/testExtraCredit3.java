//package userinput;

import java.util.Scanner;

public class testExtraCredit3 {
	public static void main(String[] args) {
		number(args, null);
	}

    


	public static void number(String[] args, int[] array) {

    	{
    		String yes;
    			do
    			{
    				Scanner input = new Scanner(System.in);

    		        //allow user  input;
    		        System.out.println("How many numbers do you want to enter?");
    		        int num = input.nextInt();

    		        int array2[] = new int[num];

    		        System.out.println("Enter the " + num + " numbers now.");

    		        for (int i = 0 ; i < array2.length; i++ ) {
    		           array2[i] = input.nextInt();
    		        }

    		        //you notice that now the elements have been stored in the array .. array[]

    		        //System.out.println("These are the numbers you have entered.");
    		       // printArray(array);

    			@SuppressWarnings("resource")
				Scanner next = new Scanner(System.in);
    			System.out.println("would you like to continue?....(Y/N)");
    			yes = next.nextLine();
    			}
    			
    			while(yes.equals("Y"));
    			
    			
    	}
    	System.out.println("These are the numbers you have entered.");
        printArray(array);
    }
    
    	
 //this method prints the elements in an array......
 //if this case is true, then that's enough to prove to you that the user input has  //been stored in an array!!!!!!!
    public static void printArray(int arr[]){

        int n = arr.length;

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
