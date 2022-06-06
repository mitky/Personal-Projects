
package codinexercise2;


public class CodinExercise2 {

    
    public static void main(String[] args) {
        Person p = new Person("Bob", "VeryLongSurname");
        String name = p.getName();
        String surname = p.getSurname();
       
        CodinExercise2 client = new CodinExercise2();
        client.executeTest();
        String a = "short";
        String b = "very very long";
        System.out.println("[CLIENT] - Returns " + client.findShortestBetween(a, b));
       client.addString("String");
        client.addString("Another String");
       client.addString("Yet Another String");
        client.addString("One more String");
        client.addString("Last String");
        System.out.println("[CLIENT] - The shortest string is " + client.findShortestAmongAllStrings());
        
        try{
            System.out.println("[CLIENT] - The shortest betwen is " + client.findShortestBetweenWithException("Short", "very very long"));
        }catch(NullPointerException e){
            System.out.println("Error");
        }
       try{
            System.out.println("[CLIENT] - The shortest betwen is " + client.findShortestBetweenWithException(null, "very very long"));
        }catch(Exception e){
            System.out.println("Error");
        }
       try{
            System.out.println("[CLIENT] - The shortest betwen is " + client.findShortestBetweenWithException("Short", null));
        }catch(Exception e){
            System.out.println("Error");
        }
       try{
            System.out.println("[CLIENT] - The shortest betwen is " + client.findShortestBetweenWithException(null, null));
        }catch(Exception e){
            System.out.println("Error");
        }
        
        //System.out.println("[CLIENT] - The shortest name is " + client.findShortestBetweenNameAndSurname(p));
    }
    
    public void executeTest(){
        System.out.println("[CLIENT] - Testing the connection");
        
        if(isConnected()){
            System.out.println("[CLIENT] - Connection successful");
        }
        else{
            System.out.println("[CLIENT] - Connection failed!");
        }
        System.out.println("[CLIENT] - Connection successfull, Test can procceed...");
    }

    private static String addString(java.lang.String string) {
        codinexercise2.Server_Service service = new codinexercise2.Server_Service();
        codinexercise2.Server port = service.getServerPort();
        return port.addString(string);
    }

    private static String findShortestAmongAllStrings() {
        codinexercise2.Server_Service service = new codinexercise2.Server_Service();
        codinexercise2.Server port = service.getServerPort();
        return port.findShortestAmongAllStrings();
    }

    private static String findShortestBetween(java.lang.String a, java.lang.String b) {
        codinexercise2.Server_Service service = new codinexercise2.Server_Service();
        codinexercise2.Server port = service.getServerPort();
        return port.findShortestBetween(a, b);
    }

    private static String findShortestBetweenWithException(java.lang.String a, java.lang.String b) {
        codinexercise2.Server_Service service = new codinexercise2.Server_Service();
        codinexercise2.Server port = service.getServerPort();
        return port.findShortestBetweenWithException(a, b);
    }

    private static String hello(java.lang.String name) {
        codinexercise2.Server_Service service = new codinexercise2.Server_Service();
        codinexercise2.Server port = service.getServerPort();
        return port.hello(name);
    }

    private static Boolean isConnected() {
        codinexercise2.Server_Service service = new codinexercise2.Server_Service();
        codinexercise2.Server port = service.getServerPort();
        return port.isConnected();
    }

    private static String findShortestBetweenNameAndSurname(java.lang.Object p) {
        codinexercise2.Server_Service service = new codinexercise2.Server_Service();
        codinexercise2.Server port = service.getServerPort();
        return (String) port.findShortestBetweenNameAndSurname(p);
    }


    

   
    
}
