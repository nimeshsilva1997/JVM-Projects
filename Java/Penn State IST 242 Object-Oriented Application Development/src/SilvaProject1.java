import java.util.Random;
import java.util.Scanner;

//Project 1 - conditional logic looping - included functions and methods for possible bonus points
public class SilvaProject1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// do-while to create a loop
		String yes;
		do {
			System.out.println("Below are the cities of Pennsylvania.");
			System.out.println("");
			System.out.println("The letters for each city in Pennsylvania are as followed: ");
			System.out.println("- A for Carlisle");
			System.out.println("- B for Harrisburg");
			System.out.println("- C for York");
			System.out.println("- D for Lancaster");
			System.out.println("");
			int letter = 0;

			getLetter(letter); // function for calling getLetter

			System.out.println("Do you want to try again? Please pick either (Y or N)"); // Output for user

			@SuppressWarnings("resource")
			Scanner prompt = new Scanner(System.in); // program waits for program to tell user input for prompt Y/N
			yes = prompt.nextLine();

		} while (yes.equals("Y"));

		System.out.println("Have a great day!");
	}

	// function for getLetter
	public static void getLetter(int letter) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in); // program waits for user inputs

		System.out.println(
				"Please enter your corresponding city letter as shown on the prompt, and it will generate a random phone number: ");
		char ch = input.next().charAt(0); // take a char as in input
		Random rand = new Random(); // random generator

		// %04d%n, rand.nextInt(10000) is the random four digit number
		if (ch == 'A') {
			System.out.printf("551-%04d%n", rand.nextInt(10000));
		} else if (ch == 'B') {
			System.out.printf("552-%04d%n", rand.nextInt(10000));
		} else if (ch == 'C') {
			System.out.printf("553-%04d%n", rand.nextInt(10000));
		} else if (ch == 'D') {
			System.out.printf("554-%04d%n", rand.nextInt(10000));
		}

	}

}
