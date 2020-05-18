import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GUIExample extends JFrame {

	// private JLabel item1;
	private JTextField item1;
	private JTextField item2;
	private JTextField item3;
	private JPasswordField passwordField;

	public GUIExample() {
		super("The title bar");
		setLayout(new FlowLayout());

		item1 = new JTextField(10);
		add(item1);

		item2 = new JTextField("Enter text here: ");
		add(item2);

		item3 = new JTextField("Uneditable", 20);
		item3.setEditable(false);
		add(item3);

		passwordField = new JPasswordField("My Pass");
		add(passwordField);

		thehandler handler = new thehandler();
		item1.addActionListener(handler);
		item2.addActionListener(handler);
		item3.addActionListener(handler);
		passwordField.addActionListener(handler);
		/*
		 * item1 = new JLabel("This is a sentence");
		 * item1.setToolTipText("This is gonna show up on hover"); add(item1);
		 */
	}

	private class thehandler implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			String string = "";
			/*
			 * if (event.getSource() == item1) string = String.format("field 1 : %s",
			 * event.getActionCommand()); else if (event.getSource() == item2) string =
			 * String.format("field 2 : %s", event.getActionCommand()); else if
			 * (event.getSource() == item3) string = String.format("field 2 : %s",
			 * event.getActionCommand()); else if (event.getSource() == passwordField)
			 * string = String.format("Password field is : %s", event.getActionCommand());
			 * 
			 * JOptionPane.showMessageDialog(null, string);
			 */
		}
	}

	public static void main(String[] args) throws Exception {

		GUIExample nim = new GUIExample();
		nim.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		nim.setSize(350, 100);
		nim.setVisible(true);
		/*
		 * SilvaProject6 test = new SilvaProject6();
		 * 
		 * test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); test.setSize(275, 180);
		 * test.setVisible(true);
		 */
		/*
		 * String fn = JOptionPane.showInputDialog("Enter First Number: "); String sn =
		 * JOptionPane.showInputDialog("Enter second Number: ");
		 * 
		 * int num1 = Integer.parseInt(fn); int num2 = Integer.parseInt(sn); int sum =
		 * num1 + num2;
		 * 
		 * JOptionPane.showMessageDialog(null, "The answer is " + sum, "the title",
		 * JOptionPane.PLAIN_MESSAGE);
		 */
	}
}// end of main
