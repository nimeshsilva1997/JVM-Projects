import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/*
 * Emulates a network exchange that occurs when a user visits a website (in this case psu.edu) via a web browser
 * Eclipse console will display the HTML code that is used to render the web page
 * (You can copy the code from the console after the program is run and save it as an HTML file and load the contents
 * in a browser, just like would happen if you used a browser to visit the website)
 */
public class SimpleNetworkApp_template {

	public static void main(String[] args) {
		try {
			// URL class represents a URL (Internet resource, like a webpage)
			URL url = new URL("https://www.psu.edu");

			// URLConnection class represents a connection between and application and a URL
			// Can be used to read from/write to the resource
			URLConnection urlConn = url.openConnection();

			// BufferedReader class reads text from a character-input stream
			BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

			// Variable will store each line that is read from the BufferedReader
			String line;

			// Use the BufferedReader to read lines from the resource
			// Loop until there is nothing left to read
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

			// Close the BufferedReader since there is nothing left to read
			br.close();
		} catch (Exception ex) {
			System.out.println("Exception occurred");
			ex.printStackTrace();
		}

	}

}
