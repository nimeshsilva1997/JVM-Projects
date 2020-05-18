
package ws.soap.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ws.soap.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ReverseText_QNAME = new QName("http://server.soap.ws/", "reverseText");
    private final static QName _ReverseTextResponse_QNAME = new QName("http://server.soap.ws/", "reverseTextResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws.soap.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReverseText }
     * 
     */
    public ReverseText createReverseText() {
        return new ReverseText();
    }

    /**
     * Create an instance of {@link ReverseTextResponse }
     * 
     */
    public ReverseTextResponse createReverseTextResponse() {
        return new ReverseTextResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReverseText }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.soap.ws/", name = "reverseText")
    public JAXBElement<ReverseText> createReverseText(ReverseText value) {
        return new JAXBElement<ReverseText>(_ReverseText_QNAME, ReverseText.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReverseTextResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.soap.ws/", name = "reverseTextResponse")
    public JAXBElement<ReverseTextResponse> createReverseTextResponse(ReverseTextResponse value) {
        return new JAXBElement<ReverseTextResponse>(_ReverseTextResponse_QNAME, ReverseTextResponse.class, null, value);
    }

}
