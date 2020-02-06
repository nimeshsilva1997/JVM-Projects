/**
 * Author 			Nimesh Silva
 * Class			IST411 001
 * Project			Lab 1
 * Due Date			2/5/2020
 * class name 		gradeCalcServer_NimeshSilva				
 */

//import statments 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.text.DecimalFormat;

public class gradeCalcServer_NimeshSilva {

	public static void main(String[] args) {
		System.out.println("Server started");// notifying the user that the server has started
		try {
			ServerSocket serverSocket = new ServerSocket(6000);
			System.out.println("Waiting for connection to client");
			Socket clientSocket = serverSocket.accept();
			System.out.println("Successfully connected to client");

			BufferedReader streamIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter streamOut = new PrintWriter(clientSocket.getOutputStream(), true);

			// A loop that will continue to add all the grades together
			do {
				// Used to store messages and sum of all the grades inputed
				String clientMsg = "";
				double sumGrades = 0.0;

				// Used to track the amount of grades sent back to client
				int sentGrades = 0;

				// Used to store the average of all the grades an to store the letter grade
				double averageGrades = 0.0;
				char storeGrade;

				// formats the decimal for the user to read the percentage properly
				DecimalFormat df = new DecimalFormat("0.00");

				// A loop that will continue to add all the grades together
				while ((clientMsg = streamIn.readLine()) != null) {

					if (clientMsg.toUpperCase().equals("X")) {
						break;
					}
					System.out.println("The incoming message from the client is: " + clientMsg);

					sumGrades = sumGrades + Double.parseDouble(clientMsg);
					sentGrades++;
				}

				// Divides the total amount according to how many grades entered
				averageGrades = sumGrades / sentGrades;

				// A set of If-Else-If statements that will assign a letter grade according to
				// the average
				if (averageGrades >= 90.0 && averageGrades <= 100.0) {
					storeGrade = 'A';
				} else if (averageGrades <= 89.99 && averageGrades >= 80) {
					storeGrade = 'B';
				} else if (averageGrades <= 79.99 && averageGrades >= 70) {
					storeGrade = 'C';
				} else if (averageGrades <= 69.99 && averageGrades >= 60) {
					storeGrade = 'D';
				} else {
					storeGrade = 'F';
				}

				// Tells the user what average and letter grade is
				System.out.println("Server response is: Percentage Grade is: " + df.format(averageGrades) + "%");
				System.out.println("Server response is: Letter Grade is: " + storeGrade);

				// Send this to the client to let the client know that the server is done
				streamOut.println("X");
			} while (true);
		}

		catch (SocketException ex) {
			System.out.println("Client has closed and Server has been stopped.");
			System.exit(0);
		} catch (IOException ex) {
			System.out.println("Exception occurred");
			ex.printStackTrace();
		}

	}

}
