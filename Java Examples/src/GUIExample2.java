import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class GUIExample2 extends JFrame implements ActionListener {

	private JTextArea taArea = new JTextArea("nothing pushed", 10, 10);

	int buttonCount = 0;

	public GUIExample2() { // constructor
		initUI();
	}

	public final void initUI() {
		// panel objects
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		// controlling the placement of the panel
		getContentPane().add(panel1, "North");
		getContentPane().add(panel2, "West");
		getContentPane().add(panel3, "Center");
		getContentPane().add(panel4, "East");
		getContentPane().add(panel5, "South");

		JButton button = new JButton("Button");
		button.addActionListener(this);
		panel1.add(button);

		panel3.add(taArea);
		// creating buttons
		JCheckBox clearButton = new JCheckBox("Clear");
		clearButton.addActionListener(this);
		panel4.add(clearButton);

		JCheckBox checkBox1 = new JCheckBox("Checkbox1");
		checkBox1.addActionListener(this);
		panel4.add(checkBox1);

		JCheckBox checkBox2 = new JCheckBox("Checkbox2");
		checkBox2.addActionListener(this);
		panel4.add(checkBox2);

		JRadioButton radioButton1 = new JRadioButton("radio button1");
		radioButton1.addActionListener(this);
		panel5.add(radioButton1);

		JRadioButton radioButton2 = new JRadioButton("radio button2");
		radioButton2.addActionListener(this);
		panel5.add(radioButton2);

		setSize(800, 300);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	// you have to use this same exact method
	public void actionPerformed(ActionEvent action) {

		if (action.getActionCommand().equals("Clear")) {
			taArea.setText("");
			buttonCount = 0;
		}
		if (action.getActionCommand().equals("Button")) {
			taArea.append("\n" + "button pushed");
		}

		if (action.getActionCommand().equals("Checkbox1")) {
			taArea.append("\n" + "checkbox1 selected");
		}

		if (action.getActionCommand().equals("Checkbox2")) {
			taArea.append("\n" + "checkbox2 selected");
		}

		if (action.getActionCommand().equals("radio button1")) {
			taArea.append("\n" + "radio button1 selected");
		}

		if (action.getActionCommand().equals("radio button2")) {
			taArea.append("\n" + "radio button2 selected");
		}

	}

	public static void main(String[] args) {
		GUIExample2 ex = new GUIExample2();
		ex.setVisible(true);
	}

}