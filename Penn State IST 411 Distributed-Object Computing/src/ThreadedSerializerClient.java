import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class ThreadedSerializerClient {

	public static void main(String[] args) {
		try {
			// Display a message that the client started
			System.out.println("Client started");

			// Setup client sockets and establish server connection on port localhost port
			// 6000
			System.out.println("Waiting for a connection to the server");
			InetAddress localAddress = InetAddress.getLocalHost();
			Socket clientSocket = new Socket(localAddress, 7000);

			System.out.println("Successfully connected to the server");

			/*
			 * Setup to read from the server with ObjectInputStream and write to the server
			 * with ObjectOutputStream
			 * 
			 * Since the ObjectOutputStream was already created in the server on the same
			 * address (IP and port) we need to "flush" it here in the client before we can
			 * use it
			 * 
			 * From the Java Doc - ObjectOutputStream.flush(): Flushes this output stream
			 * and forces any buffered output bytes to be written out. The general contract
			 * of flush is that calling it is an indication that, if any bytes previously
			 * written have been buffered by the implementation of the output stream, such
			 * bytes should immediately be written to their intended destination.
			 */
			ObjectOutputStream streamOut = new ObjectOutputStream(clientSocket.getOutputStream());
			streamOut.flush();
			ObjectInputStream streamIn = new ObjectInputStream(clientSocket.getInputStream());

			// Setup to read from the client console
			Scanner consoleIn = new Scanner(System.in);

			// Variable to indicate whether or not to continue running
			String ind = "";

			// Continue to run the program and ask the user for details about animals until
			// they indicate they are done (Enter "X")
			do {
				// Declare an instance of the Animal class
				Animal serializableAnimal = new Animal();

				// Read and validate input from the client console to populate animal
				serializableAnimal.setSpecies(validateStringInput("Enter species: ", consoleIn));
				serializableAnimal.setCommonName(validateStringInput("Enter common name: ", consoleIn));
				serializableAnimal.setName(validateStringInput("Enter name: ", consoleIn));
				serializableAnimal.setAge(validatePosIntegerInput("Enter age: ", consoleIn));
				serializableAnimal.setWeight(validatePosDoubleInput("Enter weight: ", consoleIn));

				// Reset scanner in client console
				consoleIn.nextLine();

				// Pass the instance of Animal to the to the server for processing
				streamOut.writeObject(serializableAnimal);

				// Get the returned instance of Animal from the server
				while ((serializableAnimal = (Animal) streamIn.readObject()) != null) {
					// Displays responses from the server
					System.out.println("New animal species is: " + serializableAnimal.getSpecies());
					System.out.println("New animal common name is: " + serializableAnimal.getCommonName());
					System.out.println("New animal name is: " + serializableAnimal.getName());
					System.out.println("New animal age is: " + serializableAnimal.getAge());
					System.out.println("New animal weight is: " + serializableAnimal.getWeight());

					// Exit the loop after instance of Animal has been retrieved
					break;
				}

				// Ask the user if they want to continue or quit
				do {
					ind = validateStringInput("Enter Y to continue. Enter X to quit.", consoleIn);
				} while ((!ind.toUpperCase().equals("Y")) && !ind.toUpperCase().equals("X"));
			} while ((!ind.toUpperCase().equals("X")));

			// When the user is done and wants to quit, close the client's connection to the
			// server
			clientSocket.close();

			// Stop the client
			System.out.println("Client stopped");
			System.exit(0);
		} catch (ClassNotFoundException ex) {
			System.out.println("Client stopped");
			System.exit(0);
		} catch (SocketException ex) {
			System.out.println("Client stopped");
			System.exit(0);
		} catch (IOException ex) {
			System.out.println("Exception occurred");
			ex.printStackTrace();
		}
	}

	// Method repeatedly displays the prompt until valid positive int input is
	// entered
	public static int validatePosIntegerInput(String prompt, Scanner in) {
		int var = 0;
		do {
			System.out.println(prompt);
			while (!in.hasNextInt() || !in.hasNextDouble()) {
				System.out.println(prompt);
				in.next();
			}
			var = in.nextInt();
		} while (var < 0);
		return var;
	}

	// Method repeatedly displays the prompt until valid positive double input is
	// entered
	public static double validatePosDoubleInput(String prompt, Scanner in) {
		double var = 0.0;
		do {
			System.out.println(prompt);
			while (!in.hasNextDouble()) {
				System.out.println(prompt);
				in.next();
			}
			var = in.nextDouble();
		} while (var < 0);
		return var;
	}

	// Method repeatedly displays the prompt until valid String input is entered
	public static String validateStringInput(String prompt, Scanner in) {
		boolean valid = false;
		String var = "";
		do {
			System.out.println(prompt);
			while (in.hasNextDouble() || in.hasNextInt()) {
				System.out.println(prompt);
				in.nextLine();
			}
			var = in.nextLine();
			valid = true;
		} while (!valid);
		return var;
	}
}
