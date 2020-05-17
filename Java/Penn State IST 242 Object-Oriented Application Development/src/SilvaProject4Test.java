import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SilvaProject4Test extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* Initialize the frame which will contain all the components */
		PizzaUI frame = new PizzaUI();

		/* Set a title, size and other parameters */
		frame.setTitle("Silva Pizza Order");
		frame.setResizable(true);
		frame.setVisible(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

		/* Center the window */

	}// main ending

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}// PizzaClient ending

class PizzaUI2 extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	/* Declare Components to be used in the PizzaUI */

	private JButton GenerateOrder, AnotherOrder, Clear, Submit, Exit;

	private JLabel PizzaSizeLabel, Toppings, pickupDeliveryLabel, imageLabel, imageLabel2, imageLabel3;;
	private JRadioButton S, M, L, P, D;
	private JCheckBox Pepperoni, Cheese, Supreme, Vegetarian;
	private ButtonGroup group, group2;

	private JTextField NumberOfPizzasText, customerName, customerEmail, custPhoneNum;
	private JTextArea ta;

	private JScrollPane scrollPane;

	private JPanel pNorth, pSouth, pCenter, pSideText, pSidePanel, pTopSide, pBotSide, pMidSide;

	/* Temporary Variables */
	private double total, grandTotal = 0;
	private double price, price2, withoutTax, toppingsList;
	private int toppingsCount, pizzaCount;

	private String pizzaSize, CustomerName, CustomerEmail, phoneNumber, pickDeliver, costOfOrder;

	/* All the components will be initialized in this constructor */
	public PizzaUI2() {
		grandTotal = 0;
		/* Set what to do on the close operation */
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		/* Initialize the container window to modify later on */
		Container window = getContentPane();

		/* Set a border layout for the window */
		window.setLayout(new BorderLayout(10, 10));

		NumberOfPizzasText = new JTextField(9999);
		NumberOfPizzasText.setEditable(true);
		NumberOfPizzasText.setToolTipText("Number of Pizzas"); // an informative tool tip

		customerName = new JTextField(130);
		customerName.setEditable(true);
		customerName.setToolTipText("Customer Name"); // an informative tool tip

		customerEmail = new JTextField(130);
		customerEmail.setEditable(true);
		customerEmail.setToolTipText("Customer Email"); // an informative tool tip

		custPhoneNum = new JTextField(130);
		custPhoneNum.setEditable(true);
		custPhoneNum.setToolTipText("Phone #");

		/* Initialize Text Area */
		ta = new JTextArea("", 20, 20);
		ta.setEditable(false);
		ta.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 18));
		/* Set A Scroll Pane to contain the Text Area for neat Presentation */
		scrollPane = new JScrollPane(ta);

		/* Initialize the Panels and set a grid layout for appearance */
		pNorth = new JPanel();
		pNorth.setLayout(new GridLayout(1, 3));

		pCenter = new JPanel();
		pCenter.setLayout(new GridLayout(1, 2));

		pTopSide = new JPanel();
		pTopSide.setLayout(new GridLayout(1, 4));
		pTopSide.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Color.gray));
		pMidSide = new JPanel();
		pMidSide.setLayout(new GridLayout(1, 1));

		pBotSide = new JPanel();
		pBotSide.setLayout(new GridLayout(11, 10));
		pBotSide.setBorder(BorderFactory.createMatteBorder(5, 0, 0, 0, Color.gray));

		pSouth = new JPanel();
		pSouth.setLayout(new GridLayout(1, 4));

		/* Initiallize the RadioButtons */
		S = new JRadioButton("Small");
		M = new JRadioButton("Medium");
		L = new JRadioButton("Large");

		/*
		 * Initialize a Button Group to contain the buttons for simplicity of operations
		 * later
		 */
		group = new ButtonGroup();
		group.add(S);
		group.add(M);
		group.add(L);

		imageLabel = new JLabel();
		imageLabel2 = new JLabel();
		imageLabel3 = new JLabel();

		/*
		 * Initialize a Button Group to contain the buttons for simplicity of operations
		 * later
		 */
		P = new JRadioButton("Pickup");
		D = new JRadioButton("Delivery");
		group2 = new ButtonGroup();
		group2.add(P);
		group2.add(D);

		/* Make the Icon a Label */
		imageLabel.setOpaque(true);
		imageLabel.setBackground(Color.WHITE);

		/* A Lable to contain the Welcome Text */
		imageLabel2.setText("<html><FONT SIZE=14>Pizza Order</FONT><br>");
		imageLabel2.setOpaque(true);
		imageLabel2.setBackground(Color.WHITE);

		/* Make the Icon a Lable Again */
		imageLabel3.setOpaque(true);
		imageLabel3.setBackground(Color.WHITE);

		/* Add the Images and Welcome Text to the North Panel */
		pNorth.add(imageLabel);
		pNorth.add(imageLabel2);
		pNorth.add(imageLabel3);

		/* Side Text Panel */
		pSideText = new JPanel();
		pSideText.setLayout(new GridLayout(1, 1));
		pSideText.add(scrollPane);

		/* Initialize Labels in the Option Side Panel */
		Toppings = new JLabel(" Toppings:");
		Cheese = new JCheckBox("Cheese");
		Pepperoni = new JCheckBox("Pepperoni");
		Supreme = new JCheckBox("Supreme");
		Vegetarian = new JCheckBox("Vegetarian");

		/*
		 * Add the Label and the CheckBoxes to the Grid Layout to the Middle Panel of
		 * the Side Panel
		 */
		pMidSide.add(Toppings);
		pMidSide.add(Cheese);
		pMidSide.add(Pepperoni);
		pMidSide.add(Supreme);
		pMidSide.add(Vegetarian);

		/* Add the TextField to the Bottom Panel of the Side Panel */
		pBotSide.add(new JLabel(" Number of Pizzas: "));
		pBotSide.add(NumberOfPizzasText);

		/* Add the TextField to the Bottom Panel of the Side Panel */
		pBotSide.add(new JLabel(" Customer Name: "));
		pBotSide.add(customerName);

		pBotSide.add(new JLabel(" Customer Email: "));
		pBotSide.add(customerEmail);

		pBotSide.add(new JLabel("Customer Cell Phone #"));
		pBotSide.add(custPhoneNum);

		PizzaSizeLabel = new JLabel(" Pizza Size");
		pickupDeliveryLabel = new JLabel(" Pickup or Delivery");

		/* Add the label and Radio Buttons to the Top Panel of the Side Panel */
		pTopSide.add(PizzaSizeLabel);
		pTopSide.add(S);
		pTopSide.add(M);
		pTopSide.add(L);

		/* Add the label and Radio Buttons to the Top Panel of the Side Panel */
		pBotSide.add(pickupDeliveryLabel);
		pBotSide.add(P);
		pBotSide.add(D);

		/* Initialize and set a grid for 5 rows 3 columns */
		pSidePanel = new JPanel();
		pSidePanel.setLayout(new BorderLayout(10, 10));
		pSidePanel.add("North", pTopSide);
		pSidePanel.add("Center", pMidSide);
		pSidePanel.add("South", pBotSide);

		/* Initialize all the buttons */
		GenerateOrder = new JButton("Generate Order");
		AnotherOrder = new JButton("Add to existing Order");
		Clear = new JButton("Clear");
		Submit = new JButton("Submit");
		Exit = new JButton("Exit");

		/* Add Buttons to the South Panel */
		pSouth.add(GenerateOrder);
		pSouth.add(AnotherOrder);
		pSouth.add(Clear);
		pSouth.add(Submit);
		pSouth.add(Exit);

		/* Add Action Handlers */
		ClickAction handler = new ClickAction();
		GenerateOrder.addActionListener(handler);
		Clear.addActionListener(handler);
		Submit.addActionListener(handler);
		AnotherOrder.addActionListener(handler);
		Exit.addActionListener(handler);

		/* Add the options Panel */
		pCenter.add(pSidePanel);
		/* Add the Text Area Scrollable Panel */
		pCenter.add(pSideText);

		/* Let the panel with pictures and Welcome Text go to North */
		window.add("North", pNorth);
		/* Let the Center Panel have The Text Area Panel and Options Panel */
		window.add("Center", pCenter);
		/* Let the South Panel have the Buttons */
		window.add("South", pSouth);

		ta.append(" Welcome to the Pizza Order Program!" + "\n\n");
		ta.append(" DIRECTIONS: " + "\n");
		ta.append(" - First, please select your Pizza Size" + "\n");
		ta.append(" - Second, select your toppings" + "\n");
		ta.append(" - Third, please fill out your information as followed: " + "\n");
		ta.append(
				" Number of Pizzas, Customer Name, Email, Cell Phone #, and pick either Pickup or Delivery." + "\n\n");
		ta.append(" Once you done that, click Generate Order to create your pizza. " + "\n");
		ta.append(
				" If you wish to add another pizza, fill out your first order, the click generate order, then fill out your"
						+ "\n");
		ta.append(" second order, then click Add To Order." + "\n");
		ta.append(" You can click clear to clear your selection, or you can click exit to exit out of the program."
				+ "\n");
		ta.append(" Once you are finished, click submit ti submit your order and your pizza will be made!" + "\n\n");
		ta.append(" Enjoy!" + "\n\n");

	}// Constructor ending

	private class ClickAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {

			Random rand = new Random();
			int number;

			for (int counter = 1; counter <= 1; counter++) {
				number = 1000 + rand.nextInt(10000);
				ta.append("Order #: " + number + "" + "\n\n");

			}

			/* Calculate Price Button */
			if (event.getSource() == GenerateOrder) {
				getRadioButton();
				getCheckedBoxes();
				try {
					/*
					 * Integer.valueOf throws an Exception if an Integer is not entered which is
					 * necessary for Number of pizzas
					 */
					pizzaCount = Integer.valueOf(NumberOfPizzasText.getText());
					CustomerName = String.valueOf(customerName.getText());
					CustomerEmail = String.valueOf(customerEmail.getText());
					phoneNumber = String.valueOf(custPhoneNum.getText());

					/* If its not a positive integer above 0 also lets throw the same Exception */
					if (pizzaCount < 1)
						throw new Exception();

					else if (pizzaCount > 0) {

						ta.append("Customer Name: ");
						ta.append(CustomerName + "\n");
						ta.append("Customer Email: ");
						ta.append(CustomerEmail + "\n");
						ta.append("Customer Phone Number: ");
						ta.append(phoneNumber + "\n");
						ta.append("Pickup or Delivery: ");
						ta.append(pickDeliver + "\n\n");

						if (toppingsCount > 1) {
							price += toppingsCount - 1;
						}

						ta.append("Pizza Size: ");
						ta.append("$" + price + "0 for " + pizzaSize + "\n");
						ta.append("Cost of Order: ");
						ta.append(costOfOrder + "\n");
						price = (price * pizzaCount);
						ta.append("Price of each Pizza without Tax: $");
						withoutTax = price + toppingsList;
						ta.append(withoutTax + "0 " + "\n\n");
						ta.append("Sales Tax: $");
						ta.append(((0.08 * price * pizzaCount)) + "\n");
						total = price + price2;
						ta.append("Total: $");
						ta.append((total + 0.08 * price * pizzaCount) + "\n\n");

					}
				} catch (Exception e) {
					JPanel warning = new JPanel();
					JOptionPane.showMessageDialog(warning,
							"Please Enter a Positive Integer more than 0 in the Number of Pizzas Field!!!",
							"Not a Integer Problem!!!", JOptionPane.ERROR_MESSAGE);
				}

				/* Clear everything */
				group.clearSelection();
				group2.clearSelection();
				Pepperoni.setSelected(false);
				Cheese.setSelected(false);
				Supreme.setSelected(false);
				Vegetarian.setSelected(false);
				NumberOfPizzasText.setText("");
				customerName.setText("");
				customerEmail.setText("");
				custPhoneNum.setText("");

			} // Calc Price Button

			/* Exit Button */
			if (event.getSource() == Exit) {
				System.exit(0);
			} // Exit Button

			/* Another Order Button */
			else if (event.getSource() == AnotherOrder) {
				/* Clear the selections for a fresh order */
				getRadioButton();
				getCheckedBoxes();
				try {
					/*
					 * Integer.valueOf throws an Exception if an Integer is not entered which is
					 * necessary for Number of pizzas
					 */
					pizzaCount = Integer.valueOf(NumberOfPizzasText.getText());
					CustomerName = String.valueOf(customerName.getText());
					CustomerEmail = String.valueOf(customerEmail.getText());
					phoneNumber = String.valueOf(custPhoneNum.getText());

					/* If its not a positive integer above 0 also lets throw the same Exception */
					if (pizzaCount < 1)
						throw new Exception();

					else if (pizzaCount > 0) {

						ta.append("Customer Name: ");
						ta.append(CustomerName + "\n");
						ta.append("Customer Email: ");
						ta.append(CustomerEmail + "\n");
						ta.append("Customer Phone Number: ");
						ta.append(phoneNumber + "\n");
						ta.append("Pickup or Delivery: ");
						ta.append(pickDeliver + "\n");
						if (toppingsCount > 1) {
							price += toppingsCount - 1;
						}
						ta.append("Pizza Size: ");
						ta.append("$" + price + "0 for " + pizzaSize + "\n");
						ta.append("Cost of Order: ");
						ta.append(costOfOrder + "\n");
						price = (price * pizzaCount);
						ta.append("Price of each Pizza without Tax: $");
						withoutTax = price + toppingsList;
						ta.append(withoutTax + "0 " + "\n\n");
						ta.append("Sales Tax: $");
						ta.append(((0.08 * price * pizzaCount)) + "\n");
						total = price + price2;
						ta.append("Total: $");
						ta.append((total + 0.08 * price * pizzaCount) + "\n\n");
						grandTotal += price + price2 + total;
						ta.append("Grand Total of all pizzas (including tax): $");
						ta.append((grandTotal + 0.08 * price * pizzaCount) + "\n\n");
					}
				} catch (Exception e) {
					JPanel warning = new JPanel();
					JOptionPane.showMessageDialog(warning,
							"Please Enter a Positive Integer more than 0 in the Number of Pizzas Field!!!",
							"Not a Integer Problem!!!", JOptionPane.ERROR_MESSAGE);
				}
				group.clearSelection();
				group2.clearSelection();
				Pepperoni.setSelected(false);
				Cheese.setSelected(false);
				Supreme.setSelected(false);
				Vegetarian.setSelected(false);
				NumberOfPizzasText.setText("");
				customerName.setText("");
				customerEmail.setText("");
				custPhoneNum.setText("");

			}

			/* New Customer Button */
			if (event.getSource() == Clear) {
				/* Clear the selections and Grand Total and Text Area */
				ta.setText("");
				grandTotal = 0;
				group.clearSelection();
				group2.clearSelection();
				Pepperoni.setSelected(false);
				Cheese.setSelected(false);
				Supreme.setSelected(false);
				Vegetarian.setSelected(false);
				NumberOfPizzasText.setText("");
				customerName.setText("");
				customerEmail.setText("");
				custPhoneNum.setText("");

			}
			if (event.getSource() == Submit) {
				// create a jframe
				JFrame frame = new JFrame("JOptionPane showMessageDialog");

				// show a joptionpane dialog using showMessageDialog
				JOptionPane.showMessageDialog(frame,
						"Your Order has been submitted! Please print & keep your receipt in case of emergencies."
								+ " Your receipt has been emailed to you. If you entered a cell phone number, you will be texted tell you your order is ready. Have a great day!");
				System.exit(0);
			}

		}
	}// Click Action End

	private void getRadioButton() {
		/* Find the selected Size */
		price = 0.00;
		if (S.isSelected()) {
			pizzaSize = "Small";
			price = 1.00;
		} else if (M.isSelected()) {
			pizzaSize = "Medium";
			price = 1.00;
		} else if (L.isSelected()) {
			pizzaSize = "Large";
			price = 1.00;
		} else {
			JPanel warning = new JPanel();
			JOptionPane.showMessageDialog(warning, "Please Choose a Size!!!\nFrom the RadioButtons!!!",
					"You Didn't Choose a Size!!!", JOptionPane.ERROR_MESSAGE);
		}

		if (P.isSelected()) {
			pickDeliver = "Pickup";
		} else if (D.isSelected()) {
			pickDeliver = "Deliver";
		} else {
			JPanel warning = new JPanel();
			JOptionPane.showMessageDialog(warning, "Please Choose a Option!!!\nFrom the RadioButtons!!!",
					"You Didn't Choose a option!!!", JOptionPane.ERROR_MESSAGE);
		}
	}// Radio Button Selection Find

	private void getCheckedBoxes() {
		toppingsCount = 0;
		/* Price is 0 if no size has been selected in prechecked condition */
		if (price == 0.0) {
			JPanel warning = new JPanel();
			JOptionPane.showMessageDialog(warning, "Please Choose a Size!!!\nFrom the RadioButtons!!!",
					"You Didn't Choose a Size!!!", JOptionPane.ERROR_MESSAGE);
		}

		/* Check the toppings Selection */
		else {
			price2 = 0.00;

			if (Cheese.isSelected()) {
				price2 = 10.00;
				toppingsCount++;
				toppingsList = price2;
				costOfOrder = "$" + price2 + "0 for Cheese";
			}

			if (Pepperoni.isSelected()) {
				price2 = 11.00;
				toppingsCount++;
				toppingsList = price2;
				costOfOrder = "$" + price2 + "0 for Pepperoni";
			}
			if (Supreme.isSelected()) {
				price2 = 13.00;
				toppingsCount++;
				toppingsList = price2;
				costOfOrder = "$" + price2 + "0 for Supreme";
			}
			if (Vegetarian.isSelected()) {
				price2 = 12.00;
				toppingsCount++;
				toppingsList = price2;
				costOfOrder = "$" + price2 + "0 for Vegetarian";
			}
			if (Cheese.isSelected() && Pepperoni.isSelected()) {
				price2 = 11.00;
				toppingsCount++;
				toppingsList = price2;
				costOfOrder = "$" + price2 + "0 for both Cheese & Pepperoni";
			}
			if (Cheese.isSelected() && Supreme.isSelected()) {
				price2 = 13.00;
				toppingsCount++;
				toppingsList = price2;
				costOfOrder = "$" + price2 + "0 for both Cheese & Supreme";
			}
			if (Cheese.isSelected() && Vegetarian.isSelected()) {
				price2 = 12.00;
				toppingsCount++;
				toppingsList = price2;
				costOfOrder = "$" + price2 + "0 for both Cheese & Vegetarian";
			}
			if (Pepperoni.isSelected() && Supreme.isSelected()) {
				price2 = 12.00;
				toppingsCount++;
				toppingsList = price2;
				costOfOrder = "$" + price2 + "0 for both Pepperoni & Supreme";
			}
			if (Pepperoni.isSelected() && Vegetarian.isSelected()) {
				price2 = 11.50;
				toppingsCount++;
				toppingsList = price2;
				costOfOrder = "$" + price2 + "0 for both Pepperoni & Vegetarian";
			}
			if (Supreme.isSelected() && Vegetarian.isSelected()) {
				price2 = 12.50;
				toppingsCount++;
				toppingsList = price2;
				costOfOrder = "$" + price2 + "0 for both Supreme & Vegetarian";
			}
			if (Cheese.isSelected() && Pepperoni.isSelected() && Supreme.isSelected() && Vegetarian.isSelected()) {
				price = 23.00;
				toppingsCount++;
				toppingsList = price2;
				costOfOrder = "$" + price2 + "0 for all four toppings";

			}
		}
	}// Check Boxes Selection Find

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

} // PizzaUI ending
