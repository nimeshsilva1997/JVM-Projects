/**
 * 
 */

/**
 * @author nimes
 *
 */
import java.util.Scanner;
public class HW3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		
		
		{
			
			System.out.print("Enter the test score: "); //output to ask user test score
			double score = in.nextDouble(); //program waits and asks user for input
		

		if (score == 100)  //if statement for score equal to 0
		{
			System.out.println("A+"); //Displays A+ if user enters 100 as score
		}
		else if (score >= 94 && score <= 99) //if statement for score between 94 and 99
		{
			System.out.println("A"); //Displays A if user enters a value between 94 and 99 as score
		}
		else if (score >= 90 && score <= 93.99) //if statement for score between 90 and 93.99
		{
			System.out.println("A-"); //Displays A- if user enters a value between 90 and 93.99 as score
		}
		else if (score >= 87.70 && score <= 89.99) //if statement for score between 87.70 and 89.99
		{
			System.out.println("B+"); //Displays B+ if user enters a value between 87.70 and 89.99 as score
		}
		else if (score >= 83.33 && score <= 87.69) //if statement for score between 83.33 and 87.69
		{
			System.out.println("B"); //Displays B if user enters a value between 83.33 and 87.69 as score
		}
		else if (score >= 80 && score <= 83.32) //if statement for score between 80 and 83.32
		{
			System.out.println("B-"); //Displays B- if user enters a value between 80 and 83.32 as score
		}
		else if (score >= 75 && score <= 79.99) //if statement for score between 75 and 79.99
		{
			System.out.println("C+"); //Displays C+ if user enters a value between 75 and 79.99 as score
		}
		else if (score >= 70 && score <= 74.99) //if statement for score between 70 and 89.99
		{
			System.out.println("C"); //Displays C if user enters a value between 70 and 89.99 as score
		}
		else if (score >= 65 && score <= 69.99) //if statement for score between 65 and 69.99
		{
			System.out.println("C-"); //Displays C- if user enters a value between 65 and 69.99 as score
		}
		else if (score >= 60 && score <= 64.99) //if statement for score between 60 and 64.99
		{
			System.out.println("D"); //Displays D if user enters a value between 60 and 64.99 as score
		}
		else if (score >= 55 && score <= 59.99) //if statement for score between 55 and 59.99
		{
			System.out.println("D-"); //Displays D- if user enters a value between 55 and 59.99 as score
		}
		else if (score >= 0 && score <= 54.99) //if statement for score between 0 and 54.99
		{
			System.out.println("F"); //Displays F if user enters a value between 0 and 54.99 as score
		}
		else 
		{
			System.out.print("Have a great day"); //Displays message if the input of score is greater than 100 or less than 0
		}
		}
	}
}
	


