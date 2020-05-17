import java.text.DecimalFormat;
import java.util.Scanner;

/* This program allows a user to input an earth age and the program will then display the ages on Mercury, Venus, Jupiter, and Saturn.
 * y = (x * 365) / d
 * 
 * X is age on earth, y is age on planet, and d is number of earth days
 */

public class SilvaIST242Exam2Part1 {
	// Strings to allow repeated sentences to be used throughout the program
	public static String ageOfEarthDays = "Your age of Earth days on", yearsOld = " years old.";

	// methods to be used throughout the program
	public static int earthDaysOnMercury = 88, earthDaysOnVenus = 225, earthDaysOnJupiter = 4380,
			earthDaysOnSaturn = 10767;

	public static double xAgeOnEarth, Mercury, Venus, Jupiter, Saturn;

	@SuppressWarnings({ "resource" })
	public static void main(String[] args) {

		// do-while to create a loop
		String yes;
		do {
			Scanner input = new Scanner(System.in);

			System.out.println("Please enter your age on Earth: ");
			xAgeOnEarth = input.nextDouble();
			System.out.println("");
			System.out.println("The age you entered for Earth is " + xAgeOnEarth + yearsOld);
			System.out.println("");
			yAge();
			System.out.println("");
			System.out.println("Do you want to try again? Please pick either (Y or N)."); // Output for user

			Scanner prompt = new Scanner(System.in); // program waits for program to tell user input for prompt Y/N
			yes = prompt.nextLine();

		} while (yes.equals("Y"));

		System.out.println("Have a great day!");

	}

	// Method for finding the age on a different planet
	public static void yAge() {

		Mercury = (xAgeOnEarth * 365) / earthDaysOnMercury;
		System.out.println(ageOfEarthDays + " Mercury is " + (dfRound(Mercury)) + yearsOld);

		Venus = (xAgeOnEarth * 365) / earthDaysOnVenus;
		System.out.println(ageOfEarthDays + " Venus is " + (dfRound(Venus)) + yearsOld);

		Jupiter = (xAgeOnEarth * 365) / earthDaysOnJupiter;
		System.out.println(ageOfEarthDays + " Jupiter is " + (dfRound(Jupiter)) + yearsOld);

		Saturn = (xAgeOnEarth * 365) / earthDaysOnSaturn;
		System.out.println(ageOfEarthDays + " Saturn is " + (dfRound(Saturn)) + yearsOld);
	}

	// Method to be able to round results of different planet's ages
	public static double dfRound(double roundOff) {
		DecimalFormat df = new DecimalFormat("0.0");
		return Double.parseDouble(df.format(roundOff));
	}// end dfRound method

}
