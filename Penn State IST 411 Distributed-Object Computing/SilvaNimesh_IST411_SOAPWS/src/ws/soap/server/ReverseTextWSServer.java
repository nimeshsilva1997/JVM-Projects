package ws.soap.server;

import javax.xml.ws.Endpoint;

public class ReverseTextWSServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "http://localhost:9999/ReverseTextWS";
		ReverseTextWS ws = new ReverseTextWS();
		Endpoint.publish(url, ws);
		System.out.println("Server started..." + url);

	}

}
