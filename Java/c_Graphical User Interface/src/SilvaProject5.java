import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class SilvaProject5 {

	int pNumber;

	public void getPartName() throws SQLException, ClassNotFoundException {
		String partName = null;
		String partDescription = null;
		String partPrice = null;
		// Load the JDBC driver
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded");
		// Establish a connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
		System.out.println("Database connected" + "\n");
		// Create a statement
		Statement statement = connection.createStatement();
		// Execute a statement

		@SuppressWarnings("resource")
		String yes;
		do {

			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			int input2 = JOptionPane.showOptionDialog(null,
					"Please enter either 11111 or 22222 for a part number, description, and price on the Java compiler.",
					"Silva Project 5", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

			if (input2 == JOptionPane.OK_OPTION) {
				// do something
			} else if (input2 == JOptionPane.CANCEL_OPTION) {
				// Close the connection

				System.out.println("Have a great day!");
				System.exit(0);
			}

			System.out.println("Please enter a part number: ");
			pNumber = input.nextInt();
			System.out.println("");

			ResultSet resultSet = statement.executeQuery("select * from Inventory where partNumber = " + pNumber);
			// Iterate through the result and print the student names
			while (resultSet.next()) {
				partName = resultSet.getString(2);
				partDescription = resultSet.getString(3);
				partPrice = resultSet.getString(4);
				System.out.println("Part Name: " + partName);
				System.out.println("Part Description: " + partDescription);
				System.out.println("Part Price: " + partPrice + "\n");
			}

			System.out.println("Do you want to try again? Please pick either (Y or N)"); // Output for user

			@SuppressWarnings("resource")
			Scanner prompt = new Scanner(System.in); // program waits for program to tell user input for prompt Y/N
			yes = prompt.nextLine();

		} while (yes.equals("Y"));

		System.out.println("");
		System.out.println("Have a great day!");

		// Close the connection
		connection.close();

	}

	public static void main(String[] args) throws IOException {
		SilvaProject5 x = new SilvaProject5();
		try {
			x.getPartName();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// end of main
}
