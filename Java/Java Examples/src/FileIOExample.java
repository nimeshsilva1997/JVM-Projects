
//program due October 11th, no class on October 4th
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Scanner;

public class FileIOExample {
	// reason declared up here is I can use it through the program
	Scanner inFile;
	PrintWriter outFile;

	private String title;
	private int quantity;

	// perfectly exception for Project 2
	// change all FileIOExample to Project 2
	FileIOExample() {
		try // used to catch something
		{
			inFile = new Scanner(new File("critterinventory.txt"));
			outFile = new PrintWriter(new FileWriter("critterreport.txt"));
			write_report_heading(); // calling a method
			read_data();
			inFile.close();
			outFile.close();
		} catch (Exception e) // exception e is used as a variable
		{
			if (e instanceof FileNotFoundException) {
				System.out.println("FILENAME NOT FOUND");
				System.exit(1);
			}
		}
	}

	public void read_data() throws IOException {
		// allow you to parse your data
		inFile.useDelimiter(",|\\n");

		while (inFile.hasNext()) // it's a boolean
		{
			quantity = inFile.nextInt();
			title = inFile.next(); // return a string data type

			write_a_record();

		} // end while loop

	}

	// tells that you can spin through your file
	public void write_a_record() throws IOException // take the value you have in quantity and print it to the out file
	{

		// outFile.print(" ");
		outFile.print(quantity + "        \t");
		outFile.println(title);
	}

	public void write_report_heading() throws IOException {
		Calendar today = Calendar.getInstance();

		outFile.print("\t\t\tCritters in Store \n\n");
		outFile.println("\t\t\t\t" + today.getTime());
		outFile.println();
		outFile.print("Quantity \t Animal\n");
		outFile.println();
	}

	// create an object of programming
	public static void main(String[] args) {
		FileIOExample z = new FileIOExample();
	}
}
