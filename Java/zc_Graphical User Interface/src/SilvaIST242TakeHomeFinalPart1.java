import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SilvaIST242TakeHomeFinalPart1 extends JFrame {
	// Global Variables to be used throughout the program
	static int year;
	JButton leapYearButton, clearFields, exitProgram;
	JLabel enterYear, leapYearLabel;
	JPanel centerPanel = new JPanel();
	JPanel topPanel = new JPanel();
	JPanel bottomPanel = new JPanel();
	JTextArea textArea = new JTextArea(
			"DIRECTIONS: Some years are Leap Years and some are not. To determine if a year is a leap year, enter a year and press the enter key on your keyboard or enter the LEAP YEAR button.",
			10, 100);
	JTextField textYear = new JTextField(6);
	JTextField isItLeap = new JTextField(20);

	public SilvaIST242TakeHomeFinalPart1() { // Constructor for GUI
		int input2 = JOptionPane.showOptionDialog(null,
				"Some years are Leap Years and some are not. To determine if a year is a leap year, enter a year and press the leap year button.",
				"Silva IST 242 Take Home Final Exam", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,
				null, null, null);

		if (input2 == JOptionPane.OK_OPTION) {
			// do something
		} else if (input2 == JOptionPane.CANCEL_OPTION) {
			// Close the connection

			System.out.println("Have a great day!");
			System.exit(0);
		}
		setTitle("Silva Leap Year Take Home Final");
		setSize(1000, 1400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		// GUI colors
		centerPanel.setBackground(Color.ORANGE);

		topPanel.setBackground(Color.RED);
		bottomPanel.setBackground(Color.RED);

		add(topPanel, BorderLayout.NORTH);
		add(bottomPanel, BorderLayout.SOUTH);

		enterYear = new JLabel("Enter a year to test: ");
		enterYear.setFont(new Font("Serif", Font.PLAIN, 20));
		centerPanel.add(enterYear);
		centerPanel.add(textYear);

		textYear.addActionListener(new ActionListener() { // textYear ActionListener
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				year = Integer.parseInt(textYear.getText()); // parseInt converts string to integer

				if (year % 4 == 0 && year % 100 != 0) {
					isItLeap.setText(year + " is a leap year");
				} else if (year % 400 == 0) {
					isItLeap.setText(year + " is a leap year");
				} else {
					isItLeap.setText(year + " is not a leap year");
				}
			}
		});
		add(centerPanel);

		leapYearLabel = new JLabel("Leap Year? ");
		leapYearLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		centerPanel.add(leapYearLabel);
		isItLeap.setEditable(false);
		centerPanel.add(isItLeap);

		leapYearButton = new JButton("Leap Year?");
		centerPanel.add(leapYearButton);

		leapYearButton.addActionListener(new ActionListener() { // leapYeaButton ActionListener
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				year = Integer.parseInt(textYear.getText()); // parseInt converts string to integer

				if (year % 4 == 0 && year % 100 != 0) {
					isItLeap.setText(year + " is a leap year");
				} else if (year % 400 == 0) {
					isItLeap.setText(year + " is a leap year");
				} else {
					isItLeap.setText(year + " is not a leap year");
				}
			}
		});
		clearFields = new JButton("Clear Fields");
		centerPanel.add(clearFields);

		clearFields.addActionListener(new ActionListener() { // clearFieldsr ActionListener

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textYear.setText("");
				isItLeap.setText("");
			}

		});
		exitProgram = new JButton("Exit Program");
		centerPanel.add(exitProgram);

		exitProgram.addActionListener(new ActionListener() { // exitProgram ActionListener

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame f;
				f = new JFrame();
				int input2 = JOptionPane.showOptionDialog(null,
						"If you would like to exit, press the OK button. To try the program again without exiting the program, press the CANCEL button.",
						"Silva IST 242 Take Home Final Exam", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null, null, null);

				if (input2 == JOptionPane.OK_OPTION) {
					// Close the connection
					JOptionPane.showMessageDialog(f, "Have a great day!");
					System.exit(0);

				} else if (input2 == JOptionPane.CANCEL_OPTION) {
					// do something
					JOptionPane.showMessageDialog(f,
							"Some years are Leap Years and some are not. To determine if a year is a leap year, enter a year and press the leap year button.");
				}
			}
		});
		// Text Area
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 24));
		textArea.setEditable(false);
		centerPanel.add(textArea);
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SilvaIST242TakeHomeFinalPart1 ex = new SilvaIST242TakeHomeFinalPart1(); // calls the GUI
	}
}
