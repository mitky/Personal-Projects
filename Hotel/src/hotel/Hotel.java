
package hotel;





import java.util.Scanner;
public  class Hotel {
  static  Room[] rooms = new Room[12];
    
    public  static void main(String[] args) {
         
        for(int i = 0;i<12;i++){
           rooms[i] = new Room("e", (i+1));
           }
        
        
        Hotel menu = new Hotel();
        menu.printHeader();
        
        
        char quit = 'n';
        
        
       Scanner input = new Scanner(System.in);
       
       while(quit !='y'){
          menu. printMenu();
          String choise=input.next();
          
          switch(choise){
              case "v":
                  Hotel.viewAllRooms();
                  System.out.println("Add customer: A");
                  System.out.println("To main manu: X");
                  System.out.println("");
                  String b=input.next();
                  if(b.equals("a")){
                      Hotel.addCustomer();
                  } else{
                              break;
                              }
                  
         break;
              case "a": 
                 Hotel.addCustomer();
                  
                     break;
              case "e":
                  Hotel.viewEmptyRooms();
                   
                  System.out.println("Add customer: A");
                  System.out.println("To main meny: X");
                  System.out.println("");
                  String c=input.next();
                  if(c.equals("a")){
                      Hotel.addCustomer();
                  } else{
                              break;
                              }
   
                  
               break;
              case "d":
                  Hotel.deleteCustomer();
                  break;
                  
              case "f":
                  Hotel.serchCustomer();
                  break;
                  
              case "o":
                 Hotel.sortCustomer();
                 break;
              case "x":System.out.println("are you sure you want to quit y/n");
                  String a=input.next().toLowerCase();
                  quit=a.charAt(0);
                  break;
              case "s":
                  
                  break;
              case "l":
                 
                 break;
              default:
                  System.out.println("wrong input");
                  System.out.println("");
          }
           
           
       }
        
        
        
    }

   
   private void printHeader(){
        System.out.println("+-----------------------+");
        System.out.println("|    Welcome to our     |");
        System.out.println("|         Hotel         |");
        System.out.println("+-----------------------+");
    }
    private void printMenu(){
        System.out.println("V: View all rooms"); 
        System.out.println("A: Add customer to room"); 
        System.out.println("E: display Empty rooms"); 
        System.out.println("D: Delete customer from room"); 
        System.out.println("F: Find room from customer name"); 
        System.out.println("S: Store program data in to file"); 
        System.out.println("L: Load program data from file");
        System.out.println("O: view rooms Ordered alphabetically by name"); 
        System.out.println("X: Exit");
    }
    public static void   viewEmptyRooms(){
         for(int i=0;i<12;i++){
                      if(rooms[i].getName()=="e"){
                          System.out.println(rooms[i]);
                      }
                          
                  }
    }
    public static void   viewAllRooms(){
                     for(int i=0;i<12;i++){
                     System.out.println( rooms[i].toString());
           
       }
    }
    public static void   addCustomer(){
                Scanner input = new Scanner(System.in);
                 System.out.println("Enter guest name:");
                  String guestName=input.next();
                  System.out.println("number of room:");
                  int numOfRoom=input.nextInt();
                  rooms[numOfRoom-1].setName(guestName);
                  System.out.println(rooms[numOfRoom-1].getName() + " is booked in room " + (numOfRoom));
                  System.out.println("");
            }
    public static void   deleteCustomer(){
                        Scanner input = new Scanner(System.in);
                        System.out.println("Enter number of room");
                  int numOfRoom = input.nextInt();
                  System.out.println("Are you sure you want to delete " + rooms[numOfRoom-1].getName() + " from room: " +  numOfRoom);
                  System.out.println("y/n");
                  String x=input.next();
                  String name="e";
                  if(x.equals("y")){
                      System.out.println(rooms[numOfRoom-1].getName() + " deleted from room: " + numOfRoom);
                      System.out.println("");
                  rooms[numOfRoom-1].setName(name);
                      
                  }else{
                      System.out.println("this customer dosent exist");
                  }
                    }
                   
    public static  void   serchCustomer() {
                    Scanner input = new Scanner(System.in);
                        
                    System.out.println("Enter customer name: ");
                  String cusName=input.next();
                  
                  
                    for(int i=0;i<12;i++){
                        
                        if(rooms[i].getName().equals(cusName)){
                            System.out.println("Guest " + rooms[i].getName() + " is in Room: " + (i+1));
                            System.out.println("");
                            }
                    }
             }
    static void sortCustomer(){
    int N = rooms.length;
                int k = 1;
                int j = N-2;
                int i;
                    while (k < N){
                        i = 0;
                            while ( i <= j ){
                                if (notInOrder(i,i+1)){
                                    swap(i, i+1);
                                    }i++;
                            }k++;
                    }
 
                for (int ii = 0; ii< rooms.length; ii++){
                System.out.println(rooms[ii] + " ");
                }
                System.out.println("");
    }
   static void swap(int i, int j)
 {
     
 String temp;
 temp = rooms[i].getName();
 rooms[i].setName(rooms[j].getName());
 rooms[j].setName(temp);
 }
   static boolean notInOrder(int i , int j)
 {
     String a=rooms[i].getName();
     String b=rooms[j].getName();
     char c=a.charAt(0);
    char d=b.charAt(0);
     
 return     c>d;
        
 }
 
   

   
   
   }

   

        




    

