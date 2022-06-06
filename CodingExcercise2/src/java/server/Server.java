/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author mmiit
 */
@WebService(serviceName = "Server")
public class Server {

    ArrayList<String> list = new ArrayList<String>();
    String shortest;
    Object p;
    //Person person = new Person();
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "isConnected")
    public Boolean isConnected() {
        System.out.println("[SERVER] - Testing Connection");
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "findShortestBetween")
    public String findShortestBetween(@WebParam(name = "a") String a, @WebParam(name = "b") String b) {
        String shortest;
        if(a.length()<b.length()){
            shortest = a;
        }
        else{
            shortest = b;
        }
        return shortest;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "findShortestBetweenWithException")
    public String findShortestBetweenWithException(@WebParam(name = "a") String a, @WebParam(name = "b") String b) throws NullPointerException {
        String shortest;
        if(a.length()<b.length()){
            shortest = a;
        }
        else{
            shortest = b;
        }
        return shortest;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addString")
    public String addString(@WebParam(name = "string") String string) {
        list.add(string);
        System.out.println("[SERVER] - " + string + " added to the list");
        return string;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "findShortestAmongAllStrings")
    public String findShortestAmongAllStrings() {
        
        String shortest = list.get(0);
      for(int i=0; i<list.size();i++){
            if(list.get(i).length() < shortest.length()){
               shortest = list.get(i);
            }
            else{
                
            }
          
        }
       System.out.println("[SERVER] - the shortest is " + shortest);
       return shortest;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "findShortestBetweenNameAndSurname")
    public String findShortestBetweenNameAndSurname(@WebParam(name = "p") Object p) {
        
        
        return "";
    }

}
   
