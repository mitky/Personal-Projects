
package codinexercise2;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Server", targetNamespace = "http://server/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Server {


    /**
     * 
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "isConnected", targetNamespace = "http://server/", className = "codinexercise2.IsConnected")
    @ResponseWrapper(localName = "isConnectedResponse", targetNamespace = "http://server/", className = "codinexercise2.IsConnectedResponse")
    @Action(input = "http://server/Server/isConnectedRequest", output = "http://server/Server/isConnectedResponse")
    public Boolean isConnected();

    /**
     * 
     * @param p
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findShortestBetweenNameAndSurname", targetNamespace = "http://server/", className = "codinexercise2.FindShortestBetweenNameAndSurname")
    @ResponseWrapper(localName = "findShortestBetweenNameAndSurnameResponse", targetNamespace = "http://server/", className = "codinexercise2.FindShortestBetweenNameAndSurnameResponse")
    @Action(input = "http://server/Server/findShortestBetweenNameAndSurnameRequest", output = "http://server/Server/findShortestBetweenNameAndSurnameResponse")
    public String findShortestBetweenNameAndSurname(
        @WebParam(name = "p", targetNamespace = "")
        Object p);

    /**
     * 
     * @param a
     * @param b
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findShortestBetween", targetNamespace = "http://server/", className = "codinexercise2.FindShortestBetween")
    @ResponseWrapper(localName = "findShortestBetweenResponse", targetNamespace = "http://server/", className = "codinexercise2.FindShortestBetweenResponse")
    @Action(input = "http://server/Server/findShortestBetweenRequest", output = "http://server/Server/findShortestBetweenResponse")
    public String findShortestBetween(
        @WebParam(name = "a", targetNamespace = "")
        String a,
        @WebParam(name = "b", targetNamespace = "")
        String b);

    /**
     * 
     * @param a
     * @param b
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findShortestBetweenWithException", targetNamespace = "http://server/", className = "codinexercise2.FindShortestBetweenWithException")
    @ResponseWrapper(localName = "findShortestBetweenWithExceptionResponse", targetNamespace = "http://server/", className = "codinexercise2.FindShortestBetweenWithExceptionResponse")
    @Action(input = "http://server/Server/findShortestBetweenWithExceptionRequest", output = "http://server/Server/findShortestBetweenWithExceptionResponse")
    public String findShortestBetweenWithException(
        @WebParam(name = "a", targetNamespace = "")
        String a,
        @WebParam(name = "b", targetNamespace = "")
        String b);

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findShortestAmongAllStrings", targetNamespace = "http://server/", className = "codinexercise2.FindShortestAmongAllStrings")
    @ResponseWrapper(localName = "findShortestAmongAllStringsResponse", targetNamespace = "http://server/", className = "codinexercise2.FindShortestAmongAllStringsResponse")
    @Action(input = "http://server/Server/findShortestAmongAllStringsRequest", output = "http://server/Server/findShortestAmongAllStringsResponse")
    public String findShortestAmongAllStrings();

    /**
     * 
     * @param name
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "hello", targetNamespace = "http://server/", className = "codinexercise2.Hello")
    @ResponseWrapper(localName = "helloResponse", targetNamespace = "http://server/", className = "codinexercise2.HelloResponse")
    @Action(input = "http://server/Server/helloRequest", output = "http://server/Server/helloResponse")
    public String hello(
        @WebParam(name = "name", targetNamespace = "")
        String name);

    /**
     * 
     * @param string
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addString", targetNamespace = "http://server/", className = "codinexercise2.AddString")
    @ResponseWrapper(localName = "addStringResponse", targetNamespace = "http://server/", className = "codinexercise2.AddStringResponse")
    @Action(input = "http://server/Server/addStringRequest", output = "http://server/Server/addStringResponse")
    public String addString(
        @WebParam(name = "string", targetNamespace = "")
        String string);

}