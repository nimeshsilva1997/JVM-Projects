import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class TeamORACLELLC {

	public TeamORACLELLC() {
		// Confirmation prompt
		int confirmation = JOptionPane.showOptionDialog(null,
				"Please read the compiler FIRST for instructions. If you wish to exit, press CANCEL.", "Confirmation",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
		if (confirmation == JOptionPane.OK_OPTION) {
			// do something
			System.out.println("INSTRUCTIONS: ");
			System.out.println("");
			System.out.println("Welcome to the Program!");
			System.out.println("");
			System.out.println("ENJOY!");

		} else if (confirmation == JOptionPane.CANCEL_OPTION) {

			// Close the connection
			System.out.println("Have a great day!");
			System.exit(0);
		}

		// buildGUI(); // calls buildGUI method
	}

	public static void getTimeInOut() throws SQLException, ClassNotFoundException { // getPartUpdate method
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded");
		// Establish a connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/group", "root", "");
		connection.setAutoCommit(false);

		System.out.println("Database connected");

		// Create a statement
		Statement statement = connection.createStatement();

		/*
		 * 
		 * // Execute a statement String command = "insert into timer " +
		 * " (Time_In, Time_Out)" + " values ('Current Time In', 'Current Time Out')";
		 */
		// Execute a statement

		statement.executeUpdate(
				"INSERT INTO timer (time) " + "VALUES ('" + new java.sql.Date(System.currentTimeMillis()));
		// int count = statement.executeUpdate(command);

		connection.rollback();

		// Close the connection
		connection.close();
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TeamORACLELLC ex = new TeamORACLELLC();
		try {
			getTimeInOut();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
