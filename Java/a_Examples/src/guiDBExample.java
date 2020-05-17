import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class guiDBExample extends JFrame implements ActionListener {
	String inputNumber;
	int sqlNumber;
	String partName = null;
	String partDescription = null;
	String partPrice = null;
	JTextField name;
	JTextField number;

	public guiDBExample() {
		buildGUI();
	}

	public final void buildGUI() {
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		getContentPane().add(panel1, "North");
		getContentPane().add(panel2, "West");
		getContentPane().add(panel3, "Center");
		getContentPane().add(panel4, "East");
		getContentPane().add(panel5, "South");
		JLabel partNumber = new JLabel("Part number ");
		panel1.add(partNumber);
		number = new JTextField("", 10);
		panel1.add(number);
		JLabel partNameLabel = new JLabel("Name ");
		panel1.add(partNameLabel);
		name = new JTextField("", 15);
		panel1.add(name);
		JButton read = new JButton("Read");
		read.addActionListener(this);
		panel5.add(read);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void getPartName() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded");
		// Establish a connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
		// Sample connection if you have a password set on your machine
		// Connection connection = DriverManager.getConnection
		// ("jdbc:mysql://localhost/test","root", "MySQL");
		System.out.println("Database connected");
		// Create a statement
		Statement statement = connection.createStatement();
		// Execute a statement
		ResultSet resultSet = statement.executeQuery("select * from Inventory WHERE partNumber = " + sqlNumber + ";");
		// Iterate through the result and print the student names
		while (resultSet.next()) {
			partName = resultSet.getString(2);
		}
		// Close the connection
		connection.close();
	}

	public void actionPerformed(ActionEvent action) {
		if (action.getActionCommand().equals("Read")) {
			try {
				inputNumber = number.getText();
				sqlNumber = Integer.parseInt(inputNumber);
				getPartName();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			name.setText(partName);
		}
	}

	public static void main(String[] args) {
		guiDBExample ex = new guiDBExample();
		// the next statement correctly sizes your GUI
		ex.pack();
		ex.setVisible(true);
	}
}
