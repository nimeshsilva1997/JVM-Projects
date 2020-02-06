import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadedSerializerServer implements Runnable {

	// Setup client socket
	public static Socket clientSocket;

	/*
	 * Create a constructor that will assign each client connection to the
	 * clientSocket property of the ThreadedSerializerServer instance
	 */
	public ThreadedSerializerServer(Socket pClientSocket) {
		clientSocket = pClientSocket;
	}

	/*
	 * public Socket getClientSocket() { return this.clientSocket; }
	 */

	public static void main(String[] args) {
		try {
			// Display a message that the server started
			System.out.println("Server started");

			// Setup server sockets and listen for client connection on port 6000
			ServerSocket serverSocket = new ServerSocket(7000);
			System.out.println("Waiting for a connection to the client");

			/*
			 * Continuously listen for and accept client requests
			 * 
			 * This construct allows us to have multiple client connections
			 */
			while (true) {
				// Assign the current client connection to the clientSocket property
				clientSocket = serverSocket.accept();

				// Display successful connection message after accept() method returns a client
				// connection
				System.out.println("Successfully connected to the client");

				// Create a server instance and a new thread for each client connection
				ThreadedSerializerServer tss = new ThreadedSerializerServer(clientSocket);

				// Thread.start() method calls the run() method
				new Thread(tss).start();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			// Display a message that a thread was started
			System.out.println("Connected to a client using thread: " + Thread.currentThread());

			// Setup to read from the client with ObjectInputStream and write to the client
			// with ObjectOutputStream
			ObjectInputStream streamIn = new ObjectInputStream(clientSocket.getInputStream());
			ObjectOutputStream streamOut = new ObjectOutputStream(clientSocket.getOutputStream());

			// Continue to listen for client messages until client terminates
			do {
				// Declare an instance of the Animal class
				Animal serializableAnimal = new Animal();

				try {
					// Get the instance of Animal from the client
					while ((serializableAnimal = (Animal) streamIn.readObject()) != null) {
						// Displays values for Animal that was passed from the client
						System.out.println("Incoming animal species is: " + Thread.currentThread() + " is "
								+ serializableAnimal.getSpecies());
						System.out.println("Incoming animal common name is: " + Thread.currentThread() + " is "
								+ serializableAnimal.getCommonName());
						System.out.println("Incoming animal name is: " + Thread.currentThread() + " is "
								+ serializableAnimal.getName());
						System.out.println("Incoming animal age is: " + Thread.currentThread() + " is "
								+ serializableAnimal.getAge());
						System.out.println("Incoming animal weight is: " + Thread.currentThread() + " is "
								+ serializableAnimal.getWeight());

						// Change properties for the Animal instance
						serializableAnimal.setSpecies("Feline");
						serializableAnimal.setCommonName("Nittany Lion");
						serializableAnimal.setName("Joe");
						serializableAnimal.setAge(10);
						serializableAnimal.setWeight(125.25);

						// Send the updated version of Animal back to the client
						streamOut.writeObject(serializableAnimal);
					}
				} catch (EOFException ex) {
					/*
					 * If the EOFException is raised, the client was terminated and the server
					 * instance can break from the loop, but will continue to run to support other
					 * client connections
					 */
					break;
				}
			} while (true);

			// Terminate the thread by closing the socket
			System.out.println(Thread.currentThread() + " terminated");
			clientSocket.close();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
