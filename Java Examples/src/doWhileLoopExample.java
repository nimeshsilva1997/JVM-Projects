import java.util.Scanner;

public class doWhileLoopExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// do-while to create a loop
		String yes;
		do {
			// program text here

			System.out.println("Do you want to try again? Please pick either (Y or N)"); // Output for user

			// import scanner
			Scanner prompt = new Scanner(System.in); // program waits for program to tell user input for prompt Y/N
			yes = prompt.nextLine();

		} while (yes.toUpperCase().equals("Y"));

		System.out.println("Have a great day!");

	}

}
