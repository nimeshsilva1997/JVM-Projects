package ws.soap.server;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class ReverseTextWS {
	@WebMethod
	public String reverseText (String text) {
		String tempText = "";
		for (int x = text.length() - 1; x >= 0; x--) {
			tempText += text.charAt(x);
		}
		return tempText;
	}
}
