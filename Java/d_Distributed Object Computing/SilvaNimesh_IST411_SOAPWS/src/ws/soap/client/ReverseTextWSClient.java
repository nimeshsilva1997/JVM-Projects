package ws.soap.client;

public class ReverseTextWSClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseTextWSService client = new ReverseTextWSService();
		ReverseTextWS ws = client.getReverseTextWSPort();
		String text = "Hello World!";
		String reversedText = ws.reverseText("Hello World!");
		System.out.println("Text " + text);
		System.out.println("Reversed Text: " + reversedText);
	}

}
