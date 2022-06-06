
package airport;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class Airport {

    
   static String[] queue = new String[50];
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner input = new Scanner(System.in);
        Airport menu=new Airport();
        char quit = 'n';
       menu.printHeader();
        while(quit !='y'){
          menu.printMenu();
          String choise=input.next();
          
          switch(choise){
              case "v":
                 PassengerQueue.viewQueue();               
             break;
              case "a": 
               PassengerQueue.addQueue();
              break;
              case "d":
                 PassengerQueue.removeFromQueue();
               break;
              case "e"://display Passenger Array
                 for(int i=0;i<queue.length;i++){
                     System.out.println(queue[i]);
                   }
                  break;
                  
              case "f"://read PassengersFile
                 PassengerQueue.readFromFile();
                  break;
              case "o":
                 
                 break;
              case "x":System.out.println("are you sure you want to quit y/n");
                  String a=input.next().toLowerCase();
                  quit=a.charAt(0);
                  break;
              case "s"://writ queueArray to file
                 PassengerQueue.writeToFile();
                 
                  break;
              case "l"://read from file and fill queueArray
                  PassengerQueue.scanFromFile();
                 break;
              case "r":
                 PassengerQueue.execute();
                 break;
                  default:
                  System.out.println("----------------------------------------------");
                  System.out.println("wrong input");
                  System.out.println("");
              }
           }
        }
     private void printHeader(){
        System.out.println("+-----------------------+");
        System.out.println("|    Welcome to the     |");
        System.out.println("|       Airport         |");
        System.out.println("+-----------------------+");
    }
    private void printMenu(){
        System.out.println("----------------------------------------------");
        System.out.println("A: Add a passenger to the passengerQueue");
        System.out.println("V: View the passengerQueue. "); 
        System.out.println("D: Delete passenger from the passengerQueue, "); 
        System.out.println("S: Store passengerQueue data into a plain text file, "); 
        System.out.println("L: Load passengerQueue data back from the file into the passengerQueue");
        System.out.println("R:  Run the simulation");
        System.out.println("X: Exit");
        System.out.println("----------------------------------------------");
        System.out.println("");
    }
}