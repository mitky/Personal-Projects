
package airport;


public class Passenger {
     private String firstName;
   private  String lastName;
   private int secoundsInQueue;
    
   
    
    public  Passenger(String name,String surName, int secInQueue) {
     this.firstName = name;
     this.lastName = surName;
     this.secoundsInQueue=secInQueue;
 }

  
    public  void setName(String aName,String bName) { firstName = aName; lastName=bName;}
    public  String getName() { return firstName + " " + lastName;}
    
    public void setSecoundsInQueue(int i){this.secoundsInQueue = i;}
    public int getecoundsInQueue() {return secoundsInQueue; }
    
    
    public  String toString(){
     
 return   getName()  + "     Time in queue: " + getecoundsInQueue()  ;
 }
    
 
}
