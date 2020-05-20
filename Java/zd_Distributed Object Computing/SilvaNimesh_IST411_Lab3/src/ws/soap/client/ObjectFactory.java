
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

    private final static QName _CalculateInterest_QNAME = new QName("http://server.soap.ws/", "calculateInterest");
    private final static QName _CalculateInterestResponse_QNAME = new QName("http://server.soap.ws/", "calculateInterestResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws.soap.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CalculateInterest }
     * 
     */
    public CalculateInterest createCalculateInterest() {
        return new CalculateInterest();
    }

    /**
     * Create an instance of {@link CalculateInterestResponse }
     * 
     */
    public CalculateInterestResponse createCalculateInterestResponse() {
        return new CalculateInterestResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculateInterest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.soap.ws/", name = "calculateInterest")
    public JAXBElement<CalculateInterest> createCalculateInterest(CalculateInterest value) {
        return new JAXBElement<CalculateInterest>(_CalculateInterest_QNAME, CalculateInterest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculateInterestResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.soap.ws/", name = "calculateInterestResponse")
    public JAXBElement<CalculateInterestResponse> createCalculateInterestResponse(CalculateInterestResponse value) {
        return new JAXBElement<CalculateInterestResponse>(_CalculateInterestResponse_QNAME, CalculateInterestResponse.class, null, value);
    }

}
