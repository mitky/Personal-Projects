
package airport;
import static airport.Airport.queue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Math.random;
import java.util.Scanner;



public class PassengerQueue {
   static int maxSize=20;
    private static Passenger[] passenger = new Passenger[maxSize];
   private static int first=0;
   private static int last=0;
   private static int maqStayInQueue;
   static int currentSize=0;
   static int queueFirst=0;
   static int queueLast=0;      
   static int random;
   static int min=18;
   static  int max=0;
   static double avarage;
   static int pplcounter;
   static String line=null;
   static String fileName="C:\\Users\\mmiit\\Desktop\\Airport\\passengers.dat"; //location of passenger.dat
   static String queueArray="C:\\Users\\mmiit\\Desktop\\Airport\\queueArray.txt"; //location of file we can save ouer queue.
    
    public static void addQueue(){//add new passenger to the "last" element of the Array(not last index!).
        if(currentSize<20){
        Scanner input = new Scanner(System.in);
        System.out.println("First Name:");
        String firstName=input.next();
        System.out.println("Surname:");
        String surName=input.next();
            passenger[last]=new Passenger(firstName, surName, 0);
               System.out.println("----------------------------------------------");
               System.out.println("Passenger " + passenger[last].getName() + " is added to the queue.");               
               System.out.println("");
               last++;
               currentSize++;
                 
                if(last>=maxSize){
                     last=0;
                 }
          }else{System.out.println("queue is full");}
     }
    public static void removeFromQueue(){//removes the first passenger then increment "first"
        Scanner input = new Scanner(System.in);
        System.out.println("Remove " + passenger[first] + " " + "y/n");
        String a=input.next();
       
        if(a.equals("y")){
            System.out.println("----------------------------------------------");
            System.out.println("Passenger: " + passenger[first].getName() + " is removed from the queue.");                       
            System.out.println("");
            passenger[first]=null;
            first++;
            // maxSize++;
            currentSize--;
            
            if(first>=maxSize){
                first=0;
            }
            if(last>=maxSize){//only if we have loaded all the elements in the queueArray and its full.
            last=0;
            }
        }
        
        else{
        System.out.println("----------------------------------------------");
             System.out.println("queue is empty");
                  System.out.println("");
        }
       }
    public static void viewQueue(){//for loop to print the queueArray

            for (int i =0; i<20; i++){
                System.out.println("Passanger: "  + passenger[i]);
            }         
            System.out.println("----------------------------------------------");
            System.out.println("");
         }       
  public static void readFromFile(){//read and save from file to passengerArray
        try{
                  Scanner fileScan= new Scanner(fileName);
                 
                  FileReader fileReader = new FileReader(fileName);
                  BufferedReader bufferedReader =  new BufferedReader(fileReader);
                  int i=0;
                  while((line = bufferedReader.readLine()) != null) {
                      queue[i]=line;
                      i++;
                System.out.println(line);
            }  
                    bufferedReader.close();
                  }
             catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
           }
       }
    public static void writeToFile() throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(queueArray));
         for(int i=0;i<20;i++){
            if(passenger[i] !=null){
                 writer.write(passenger[i].getName());
                 writer.newLine();
            }
        }
                  System.out.println("----------------------------------------------");
                  System.out.println("Passengers list saved to file.");
                  System.out.println("");
         writer.close();
    }
     public static void scanFromFile(){//Scan and read from file put it into queueArray, reset "first" to 0 and "last" to the last element in the file +1.
        try{
            String name;
            Scanner fileScan= new Scanner(queueArray);
                  FileReader fileReader = new FileReader(queueArray);
                  BufferedReader bufferedReader =  new BufferedReader(fileReader);
                  int i=0;
                  while((line = bufferedReader.readLine()) != null) {
                      name=line;
                    passenger[i]=new Passenger(name, " ", 0);
                      i++;
                      currentSize++;
                     System.out.println(line);
            }  
                  first=0;
                  last=i+1;                  
                   bufferedReader.close();
                  }
                 catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
             }
   }
    
     
     public static int  diceRow(){
          int random = (int )(Math.random() * 6 + 1);
     return random;
     }
     public static int threeDice(){
         int a=PassengerQueue.diceRow() + PassengerQueue.diceRow() + PassengerQueue.diceRow();
     return a;
     }
     
    public static void execute(){ //option "R" callin other functions  below while there is people in passanger array
        PassengerQueue.readFromFile();
        while(queue[queueLast]!=null){
         PassengerQueue.fromArrayToQueue();
        PassengerQueue.removeQueue();
        
     }
        PassengerQueue.printSec();
          first=0;
    last=0;
    
    currentSize=0;
    queueFirst=0;
    queueLast=0;
    random=0;
    min=18;                 // then we reset all variabels 
    max=0;
    avarage=0;
    pplcounter=0;
         
     }
     
     public static void fromArrayToQueue(){ //this function twrows a dice and moves that amount of people from passenger array to queue array until passanger array is epty
        int randomm=diceRow();
         for(int i =0;i<randomm;i++){
             if(queue[queueLast]!=null){
              passenger[i]=new Passenger(queue[queueLast], " ", 0);
              queue[queueLast]=null;
              queueLast++;
              
             
              currentSize++;
             }else{System.out.println("no more ppl");}
         }
     }
   
       
     public static void printSec(){//prints the final results from all passengers through the queue
         System.out.println("----------------------------------------------");
         System.out.println("Minimum sec in queue " + " " + min);
         System.out.println("Maximum sec in queue " + " " + max);
         System.out.println("Avarege sec in queue " + " " + avarage/pplcounter);
     }
     
     public static void removeQueue(){ //first throw dice and sets secound for everyone on queue array then deleates the first and sets new second for the rest 
         int front=0;                                               //until queue array is empty
         
         while(passenger[front]!=null){
             random=threeDice();
             for(int i =0;i<currentSize;i++){
              passenger[front+i].setSecoundsInQueue(random+passenger[front+i].getecoundsInQueue());
              avarage=avarage+random;
              pplcounter++;
             }
             passenger[front]=null;
             currentSize--;
             front++;
             
             
         }
         currentSize=0;
         front=0;
         
            if(random<min){
              min=random;
            }                       //checks the min max 
          if(random>max){
          max=random;
            }
          
     }
    
    
}