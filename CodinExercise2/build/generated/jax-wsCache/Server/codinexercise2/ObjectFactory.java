
package codinexercise2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the codinexercise2 package. 
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

    private final static QName _FindShortestBetween_QNAME = new QName("http://server/", "findShortestBetween");
    private final static QName _FindShortestAmongAllStringsResponse_QNAME = new QName("http://server/", "findShortestAmongAllStringsResponse");
    private final static QName _FindShortestBetweenNameAndSurname_QNAME = new QName("http://server/", "findShortestBetweenNameAndSurname");
    private final static QName _IsConnected_QNAME = new QName("http://server/", "isConnected");
    private final static QName _AddString_QNAME = new QName("http://server/", "addString");
    private final static QName _IsConnectedResponse_QNAME = new QName("http://server/", "isConnectedResponse");
    private final static QName _FindShortestBetweenWithExceptionResponse_QNAME = new QName("http://server/", "findShortestBetweenWithExceptionResponse");
    private final static QName _Hello_QNAME = new QName("http://server/", "hello");
    private final static QName _FindShortestAmongAllStrings_QNAME = new QName("http://server/", "findShortestAmongAllStrings");
    private final static QName _FindShortestBetweenNameAndSurnameResponse_QNAME = new QName("http://server/", "findShortestBetweenNameAndSurnameResponse");
    private final static QName _FindShortestBetweenWithException_QNAME = new QName("http://server/", "findShortestBetweenWithException");
    private final static QName _HelloResponse_QNAME = new QName("http://server/", "helloResponse");
    private final static QName _AddStringResponse_QNAME = new QName("http://server/", "addStringResponse");
    private final static QName _FindShortestBetweenResponse_QNAME = new QName("http://server/", "findShortestBetweenResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: codinexercise2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link IsConnected }
     * 
     */
    public IsConnected createIsConnected() {
        return new IsConnected();
    }

    /**
     * Create an instance of {@link FindShortestAmongAllStringsResponse }
     * 
     */
    public FindShortestAmongAllStringsResponse createFindShortestAmongAllStringsResponse() {
        return new FindShortestAmongAllStringsResponse();
    }

    /**
     * Create an instance of {@link FindShortestBetweenNameAndSurname }
     * 
     */
    public FindShortestBetweenNameAndSurname createFindShortestBetweenNameAndSurname() {
        return new FindShortestBetweenNameAndSurname();
    }

    /**
     * Create an instance of {@link FindShortestBetween }
     * 
     */
    public FindShortestBetween createFindShortestBetween() {
        return new FindShortestBetween();
    }

    /**
     * Create an instance of {@link FindShortestBetweenResponse }
     * 
     */
    public FindShortestBetweenResponse createFindShortestBetweenResponse() {
        return new FindShortestBetweenResponse();
    }

    /**
     * Create an instance of {@link AddStringResponse }
     * 
     */
    public AddStringResponse createAddStringResponse() {
        return new AddStringResponse();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link FindShortestAmongAllStrings }
     * 
     */
    public FindShortestAmongAllStrings createFindShortestAmongAllStrings() {
        return new FindShortestAmongAllStrings();
    }

    /**
     * Create an instance of {@link FindShortestBetweenNameAndSurnameResponse }
     * 
     */
    public FindShortestBetweenNameAndSurnameResponse createFindShortestBetweenNameAndSurnameResponse() {
        return new FindShortestBetweenNameAndSurnameResponse();
    }

    /**
     * Create an instance of {@link FindShortestBetweenWithException }
     * 
     */
    public FindShortestBetweenWithException createFindShortestBetweenWithException() {
        return new FindShortestBetweenWithException();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link FindShortestBetweenWithExceptionResponse }
     * 
     */
    public FindShortestBetweenWithExceptionResponse createFindShortestBetweenWithExceptionResponse() {
        return new FindShortestBetweenWithExceptionResponse();
    }

    /**
     * Create an instance of {@link AddString }
     * 
     */
    public AddString createAddString() {
        return new AddString();
    }

    /**
     * Create an instance of {@link IsConnectedResponse }
     * 
     */
    public IsConnectedResponse createIsConnectedResponse() {
        return new IsConnectedResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindShortestBetween }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "findShortestBetween")
    public JAXBElement<FindShortestBetween> createFindShortestBetween(FindShortestBetween value) {
        return new JAXBElement<FindShortestBetween>(_FindShortestBetween_QNAME, FindShortestBetween.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindShortestAmongAllStringsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "findShortestAmongAllStringsResponse")
    public JAXBElement<FindShortestAmongAllStringsResponse> createFindShortestAmongAllStringsResponse(FindShortestAmongAllStringsResponse value) {
        return new JAXBElement<FindShortestAmongAllStringsResponse>(_FindShortestAmongAllStringsResponse_QNAME, FindShortestAmongAllStringsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindShortestBetweenNameAndSurname }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "findShortestBetweenNameAndSurname")
    public JAXBElement<FindShortestBetweenNameAndSurname> createFindShortestBetweenNameAndSurname(FindShortestBetweenNameAndSurname value) {
        return new JAXBElement<FindShortestBetweenNameAndSurname>(_FindShortestBetweenNameAndSurname_QNAME, FindShortestBetweenNameAndSurname.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsConnected }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "isConnected")
    public JAXBElement<IsConnected> createIsConnected(IsConnected value) {
        return new JAXBElement<IsConnected>(_IsConnected_QNAME, IsConnected.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddString }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "addString")
    public JAXBElement<AddString> createAddString(AddString value) {
        return new JAXBElement<AddString>(_AddString_QNAME, AddString.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsConnectedResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "isConnectedResponse")
    public JAXBElement<IsConnectedResponse> createIsConnectedResponse(IsConnectedResponse value) {
        return new JAXBElement<IsConnectedResponse>(_IsConnectedResponse_QNAME, IsConnectedResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindShortestBetweenWithExceptionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "findShortestBetweenWithExceptionResponse")
    public JAXBElement<FindShortestBetweenWithExceptionResponse> createFindShortestBetweenWithExceptionResponse(FindShortestBetweenWithExceptionResponse value) {
        return new JAXBElement<FindShortestBetweenWithExceptionResponse>(_FindShortestBetweenWithExceptionResponse_QNAME, FindShortestBetweenWithExceptionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindShortestAmongAllStrings }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "findShortestAmongAllStrings")
    public JAXBElement<FindShortestAmongAllStrings> createFindShortestAmongAllStrings(FindShortestAmongAllStrings value) {
        return new JAXBElement<FindShortestAmongAllStrings>(_FindShortestAmongAllStrings_QNAME, FindShortestAmongAllStrings.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindShortestBetweenNameAndSurnameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "findShortestBetweenNameAndSurnameResponse")
    public JAXBElement<FindShortestBetweenNameAndSurnameResponse> createFindShortestBetweenNameAndSurnameResponse(FindShortestBetweenNameAndSurnameResponse value) {
        return new JAXBElement<FindShortestBetweenNameAndSurnameResponse>(_FindShortestBetweenNameAndSurnameResponse_QNAME, FindShortestBetweenNameAndSurnameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindShortestBetweenWithException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "findShortestBetweenWithException")
    public JAXBElement<FindShortestBetweenWithException> createFindShortestBetweenWithException(FindShortestBetweenWithException value) {
        return new JAXBElement<FindShortestBetweenWithException>(_FindShortestBetweenWithException_QNAME, FindShortestBetweenWithException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStringResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "addStringResponse")
    public JAXBElement<AddStringResponse> createAddStringResponse(AddStringResponse value) {
        return new JAXBElement<AddStringResponse>(_AddStringResponse_QNAME, AddStringResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindShortestBetweenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "findShortestBetweenResponse")
    public JAXBElement<FindShortestBetweenResponse> createFindShortestBetweenResponse(FindShortestBetweenResponse value) {
        return new JAXBElement<FindShortestBetweenResponse>(_FindShortestBetweenResponse_QNAME, FindShortestBetweenResponse.class, null, value);
    }

}
