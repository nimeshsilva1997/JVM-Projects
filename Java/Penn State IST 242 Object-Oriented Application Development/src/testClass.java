import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

//collects data from Manager
public class testClass extends Manager {

	public String department;
	Manager[] Array_Stored_Values = new Manager[3];

	public static void main(String[] args) throws Exception {
		String backupDir = "/Users/al/backups";

		// create a jframe
		JFrame frame = new JFrame("JOptionPane showMessageDialog");

		// show a joptionpane dialog using showMessageDialog
		JOptionPane.showMessageDialog(frame, "Welcome to the program! Please press OK to continue with the program.");

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the number of Employees: ");
		int numOfEmployees = scanner.nextInt();
		// arrays to populate getDepartment, setSalary, and getName
		String[] names = new String[numOfEmployees];
		String[] departments = new String[numOfEmployees];
		double[] salaries = new double[numOfEmployees];

		// for loop to make the program repeat
		for (int i = 0; i < names.length; i++) {
			System.out.println("Enter a players name: ");
			String name = scanner.next();
			names[i] = name;
			System.out.println("Enter " + name + "\'s salary: $");

			// while loop for condition
			while (scanner.hasNext()) {
				if (scanner.hasNextDouble()) {
					double salary = scanner.nextDouble();
					salaries[i] = salary;
					break;
				} else {
					System.out.println("ERROR: Invalid Input");
					System.out.println("Enter " + name + "\'s salary: ");
				}
			}
			// allows user to enter department
			System.out.println("Enter " + name + "\'s department: ");
			String department = scanner.next();
			departments[i] = department;
		}
		// prints names, salaries, and departments in array format
		System.out.println("The name(s) entered were " + Arrays.toString(names) + ", the salaries entered were "
				+ Arrays.toString(salaries) + ", and the departments entered were " + Arrays.toString(departments)
				+ ", respectfully.");

		System.exit(0);
	}

}
