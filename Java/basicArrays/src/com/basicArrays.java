package com;

import java.util.Scanner;
public class basicArrays {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        //Menu
        System.out.println("Hello, and welcome to the program. ");
        System.out.println("This program will allow you to do the following:");
        System.out.println("Enter four numbers, displays the numbers, finds the sum, "
                + "then finally finds the average. Please enjoy!");
        System.out.println("");
        displayNumbers(0);
    }

    /*
     * Method to display the numbers being displays, summed, and averaged
     */

    public static int displayNumbers (int numbers)
    {
        {

            String yes;
            do
            {
                int [] values = new int [4]; //Used to populate array with the value inside displacement
                @SuppressWarnings("resource")
//Output to enter four numbers
                        Scanner input = new Scanner(System.in);
                System.out.println("---RULES FOR ENTERING NUMBERS--- ");
                System.out.println("*Note: They can be single digit or they can be double digit. ");
                System.out.println("Once you enter it, they will be displayed, summed up, then averaged.");
                System.out.println("Please enter your four numbers here please: ");
                for(int x = 0; x < 4; x++)
                {
                    values[x] = (int) input.nextDouble();
                }
//Displays the four numbers
                {
                    System.out.println("Your four numbers are that you entered was: ");
                    for(int x = 0; x < 4; x++)
                    {
                        System.out.println(values[x]);
                    }
//Displays the sum of the four numbers entered
                    {
                        System.out.println("The sum of your four numbers entered are: ");
                        int sum = 0;
                        for(int x = 0; x < 4; x++)
                        {
                            sum = sum + values[x];
                        }
                        System.out.println(sum);
                    }
//Displays the average of the four numbers entered
                    {
                        System.out.println("The average of your four numbers entered are: ");
                        double average = 0;
                        double sum = 0;
                        for(int x = 0; x < 4; x++)
                        {
                            sum = sum + values[x];
                            average = sum/4;
                        }
                        System.out.println(average);

                    }
                    //do-while loop to ask user if they wish to continue

                    @SuppressWarnings("resource")
                    Scanner next = new Scanner (System.in);
                    System.out.println("Would you like to continue...Y/N");
                    yes = next.nextLine();
                }
            }
            while(yes.equals("Y"));
        }
        return numbers;
    }
}
