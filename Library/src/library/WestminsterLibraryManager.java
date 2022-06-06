
package library;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;


public class WestminsterLibraryManager implements LibraryManager{
    
    private ArrayList<LibraryItem> libraryItem;
    private ArrayList<Book> libraryBook; //we have book array and dvd array to keep track of their size because we know we have 100 books and 50 dvds
    private ArrayList<DVD> libraryDVD;
    private int numOfItems = 150;
    private int numOfBooks= 100;
    private int numOfDvds = 50;
    private int pages;
    private String isbn;
    private String isbn1;
    private int days;
    private int hours;
    private int months;
    private int years;
    private String type;
    private double money;
    private String line = null;
    boolean found = false; //flag to check if the item is found - used when we search in the arrayList for ISBN
    boolean found1 = false;
    
    
    public WestminsterLibraryManager(int lisLength){
        numOfItems = lisLength;   
        libraryItem = new ArrayList<LibraryItem>(numOfItems);
        libraryBook = new ArrayList<Book>(numOfBooks);
        libraryDVD = new ArrayList<DVD>(numOfDvds);
    }
    
    
    public void addItem(LibraryItem item){
        //add item to the library
        if(libraryItem.size() < numOfItems){
            libraryItem.add(item);
        }else{
            System.out.println("No more space");
        }
    }
    
    public void deleteItem(LibraryItem item){
        //delete item from the library
        libraryItem.remove(item);
    
    }
    
    public void printItems(){
        //print all items from the arrayList
       for(int i = 0; i<libraryItem.size(); i++){
            
                System.out.println("ISBN: " + libraryItem.get(i).getISBN() + " Title: " + libraryItem.get(i).getTitle() + " Type: " + libraryItem.get(i).getType());
            
        }
        System.out.println("");
       }
    
    public void borrowItem(){
        
        DateTime date = new DateTime();
        Reader reader = new Reader();
        found = false;  //chechs if the ISBN is found
        System.out.println("Please enter ISBN of the item you want to borrow");
        Scanner in = new Scanner(System.in);
        String isbn = in.next();
        
        for(int i = 0; i <libraryItem.size(); i++){
           
            //the next lines of code are checking if the ISBN is found and the Item is awredy borrowed and displays if its borrowed and when will be available again
            if(libraryItem.get(i).getISBN().equals(isbn) && libraryItem.get(i).getBorrowed()==true && libraryItem.get(i).getType().equals("Book")){
                //in case the item is borrowed and its a Book
               if(libraryItem.get(i).getBorrowDate().getDay() + 7 >30 && libraryItem.get(i).getBorrowDate().getMonth()!=12){//in case that the item will be available next month calculates
                         int d = (libraryItem.get(i).getBorrowDate().getDay()+7) - 30;                                      //adds the days and -30 for the next month and add +1 to month
                         System.out.println("The Item is awredy borrowed and will be available again on " + d + "/" + (libraryItem.get(i).getBorrowDate().getMonth() + 1) + "/" + libraryItem.get(i).getBorrowDate().getYear());
                         found = true;
                     }
               else if(libraryItem.get(i).getBorrowDate().getDay()+7>30 && libraryItem.get(i).getBorrowDate().getMonth()==12){//if its the last month and the item will be available next month 
                    int d = (libraryItem.get(i).getBorrowDate().getDay()+7) - 30;                                              //which means next year takes -11 from month so its month 1 January and ads +1 to year
                    System.out.println("The Item is awredy borrowed and will be available again on " + d + "/" + (libraryItem.get(i).getBorrowDate().getMonth() -11) + "/" + (libraryItem.get(i).getBorrowDate().getYear() +1));
                    found = true;
               }
                     else{//if its not next month or next year 
                         System.out.println("The item is awredy borrowed and will be available again on " + (libraryItem.get(i).getBorrowDate().getDay()+7) + "/" + libraryItem.get(i).getBorrowDate().getMonth() + "/" + libraryItem.get(i).getBorrowDate().getYear());
                         found=true;
                     }
                //same code for DVD below
            }else if(libraryItem.get(i).getISBN().equals(isbn) && libraryItem.get(i).getBorrowed()==true && libraryItem.get(i).getType().equals("DVD")){
                if(libraryItem.get(i).getBorrowDate().getDay() + 3 >30 && libraryItem.get(i).getBorrowDate().getMonth()!=12){
                         int d = (libraryItem.get(i).getBorrowDate().getDay()+3) - 30;
                         System.out.println("The Item is awredy borrowed will be available again on " + d + "/" + (libraryItem.get(i).getBorrowDate().getMonth() + 1) + "/" + libraryItem.get(i).getBorrowDate().getYear());
                         found = true;
                     }
                else if(libraryItem.get(i).getBorrowDate().getDay()+3>30 && libraryItem.get(i).getBorrowDate().getMonth()==12){
                        int d = (libraryItem.get(i).getBorrowDate().getDay()+3) - 30;//here we can see what is happening with month and year in case we pass to next month or year
                         int m = (libraryItem.get(i).getBorrowDate().getMonth() - 11);
                         int y = (libraryItem.get(i).getBorrowDate().getYear() +1);
                         System.out.println("The Item is awredy borrowed will be available again on " + d + "/" + m + "/" + y);
                         found = true;
               }
                     else{ // if we are not in the next month or year
                         System.out.println("The item is awredy borrowed will be available again on " + (libraryItem.get(i).getBorrowDate().getDay()+3) + "/" + libraryItem.get(i).getBorrowDate().getMonth() + "/" + libraryItem.get(i).getBorrowDate().getYear());
                         found = true;
                     }
            }
           //now if its all clear we prosead with the borrow information
           else if(libraryItem.get(i).getISBN().equals(isbn)){
                Scanner inn = new Scanner(System.in);
                System.out.println("Please enter the name of the reader");
                String name = inn.next();
                reader.setName(name);
                
                //this type of try/catch in while loop is to check if we are entering the correct type of information as integer needed or to check
                // if we have mistake of sort 40 days or 15 months which don't exist
                //we are gona have the same code below in the code more then once
                //if an error is made we ask for the user to try again and until the corect information is entered
               boolean error11 = true;
                        while(error11){
                            try{
                        System.out.println("Please enter the day");
                        Scanner iin = new Scanner(System.in);
                        int day = iin.nextInt();
                        if(day<=0 || day >30){
                            System.out.println("Wrong input");
                        }
                        else{
                        error11= false;
                        date.setDay(day);
                        }
                        
                              }
                            catch(Exception e){
                                System.out.println("Error wrong input");
                            }
                        }
                
                
               boolean error12 = true;
                        while(error12){
                            try{
                        System.out.println("Please enter the month");
                        Scanner iin = new Scanner(System.in);
                        int month = iin.nextInt();
                        if(month == 0 || month>12){
                            System.out.println("Wrong input");
                        }
                        else{
                            error12= false;
                        date.setMonth(month);
                        }
                        
                              }
                            catch(Exception e){
                                System.out.println("Error wrong input");
                            }
                        }
                
                
               boolean error13 = true;
                        while(error13){
                            try{
                        System.out.println("Please enter the year");
                        Scanner iin = new Scanner(System.in);
                        int year = iin.nextInt();
                        error13= false;
                        date.setYear(year);
                              }
                            catch(Exception e){
                                System.out.println("Error wrong input");
                            }
                        }
                
                
               boolean error14 = true;
                        while(error14){
                            try{
                        System.out.println("Please enter the hour");
                        Scanner iin = new Scanner(System.in);
                        int hour = iin.nextInt();
                        if(hour==0||hour>24){
                            System.out.println("Wrong input");
                        }
                        else{
                            error14= false;
                        date.setHour(hour);
                        }
                         }
                            catch(Exception e){
                                System.out.println("Error wrong input");
                            }
                        }
                
                
                boolean error15 = true;
                        while(error15){
                            try{
                        System.out.println("Please enter the minutes");
                        Scanner iin = new Scanner(System.in);
                        int min = iin.nextInt();
                        if(min>60){
                            System.out.println("Wrong input");
                        }
                        else{
                        error15= false;
                        date.setMin(min);
                        }
                         }
                            catch(Exception e){
                                System.out.println("Error wrong input");
                             }
                        }
                
                libraryItem.get(i).setBorrowDate(date);
                libraryItem.get(i).setBorrowed(true);
                libraryItem.get(i).setReader(reader);
                found=true;
                //the lines of code below are the same like in the beggining of the borrow option siply to tell us when will be the item available again after its borrowed
                 if(libraryItem.get(i).getISBN().equals(isbn) && libraryItem.get(i).getType().equals("Book")){
                 System.out.println("The " + isbn + " is now borrowed from " + reader.getName() + " for 7 days");
                     if(libraryItem.get(i).getBorrowDate().getDay() + 7 >30 && libraryItem.get(i).getBorrowDate().getMonth()!=12){
                         int d = (libraryItem.get(i).getBorrowDate().getDay()+7) - 30;
                         System.out.println("The Item will be available again on " + d + "/" + (libraryItem.get(i).getBorrowDate().getMonth() + 1) + "/" + libraryItem.get(i).getBorrowDate().getYear());
                         
                     }
                     else if(libraryItem.get(i).getBorrowDate().getDay()+7>30 && libraryItem.get(i).getBorrowDate().getMonth()==12){
                    int d = (libraryItem.get(i).getBorrowDate().getDay()+7) - 30;
                    System.out.println("The Item  will be available again on " + d + "/" + (libraryItem.get(i).getBorrowDate().getMonth() -11) + "/" + (libraryItem.get(i).getBorrowDate().getYear() +1));
               }
                     else{
                         System.out.println("The item will be available again on " + (libraryItem.get(i).getBorrowDate().getDay()+7) + "/" + libraryItem.get(i).getBorrowDate().getMonth() + "/" + libraryItem.get(i).getBorrowDate().getYear());
                     }
                     System.out.println("");
                 }else{System.out.println("The " + isbn + " is now borrowed from " + reader.getName() + " for 3 days");
                    if(libraryItem.get(i).getBorrowDate().getDay() + 3 >30 && libraryItem.get(i).getBorrowDate().getMonth()!=12){
                         int d = (libraryItem.get(i).getBorrowDate().getDay()+3) - 30;
                         System.out.println("The Item will be available again on " + d + "/" + (libraryItem.get(i).getBorrowDate().getMonth() + 1) + "/" + libraryItem.get(i).getBorrowDate().getYear());
                         
                     }
                    else if(libraryItem.get(i).getBorrowDate().getDay()+3>30 && libraryItem.get(i).getBorrowDate().getMonth()==12){
                         int d = (libraryItem.get(i).getBorrowDate().getDay()+3) - 30;
                         int m = (libraryItem.get(i).getBorrowDate().getMonth() - 11);
                         int y = (libraryItem.get(i).getBorrowDate().getYear() +1);
                         System.out.println("The Item is awredy borrowed will be available again on " + d + "/" + m + "/" + y);
                    }
                     else{
                         System.out.println("The item will be available again on " + (libraryItem.get(i).getBorrowDate().getDay()+3) + "/" + libraryItem.get(i).getBorrowDate().getMonth() + "/" + libraryItem.get(i).getBorrowDate().getYear());
                     }
                     System.out.println("");
                 }
            }
            
        }
        //this if statement is checking if the ISBN for borrowing item is not found
        //because its all in for loop if we put it in the loop it will print Error for all other items which dont have the same ISBN even if we find the one we are looking for
        if(found == false){
            System.out.println("ISBN not found please try again");
            System.out.println("");
        }
}
    
    public void returnItem(double d, double h, String type){
        
        //return item and calculate how much the reader owns
        
        if(type.equals("Book")){
            if(d <=7 ){//if he returned the item before the date expire
                System.out.println("The Book is now returned and the reader does now own anything");
            }
            else if(d>7 && d<=10){//this is the rate for up to 3 days late
                money = (((d-7)*24) + h) * 0.2;//we convert the days "d" in hours
            }
            else{//more then 3 days
                money = ((((d-10)*24) + h) * 0.5) + 14.4;//we add 14.4 because thats the rate for 3 days late 
            }                                            //and calculate the rest to the new rate for more then 3 days
        }
        else{
             if(d <=3 ){//same for DVD
                System.out.println("The DVD is now returned and the reader does now own anything");
            }
            else if(d>3 && d<=6){
                money = (((d-3)*24) + h) * 0.2;
            }
            else{
               money = ((((d-6)*24) + h) * 0.5) + 14.4;
            }
        }
    }
    
    public void report() throws IOException {
        //this is code i used in Programing Principle 2 last year
        //writes the borrowed items to a file and the reads it and prints it
        BufferedWriter writer = new BufferedWriter(new FileWriter("borrowedItems"));
         for(int i=0;i<libraryItem.size();i++){
            if(libraryItem.get(i).getBorrowed()==true){
                 writer.write(libraryItem.get(i).getTitle()+" is borrowed from " + libraryItem.get(i).getReader().getName() + " At " + libraryItem.get(i).getBorrowDate());
                 writer.newLine();
            }
        }
                  System.out.println("----------------------------------------------");
                  System.out.println("Borrowed Items saved to file.");
                  System.out.println("");
         writer.close();
    
        
          try{
                  Scanner fileScan= new Scanner("borrowedItems");
                 
                  FileReader fileReader = new FileReader("borrowedItems");
                  BufferedReader bufferedReader =  new BufferedReader(fileReader);
                  for(int i = 0;i<libraryItem.size();i++){
                  while((line = bufferedReader.readLine()) != null) {
                      line = line;
                      
                System.out.println(line);
                
            }
                      System.out.println("");
                    bufferedReader.close();
                  }
                  }
             catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file ");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '");                  
           }
       }
    
    public void reservation(){
        //this code is to make reservation and uses the same code to tell us when an item will be available as in borrow item function
        DateTime date = new DateTime();
        Reader reader = new Reader();
        found1 = false;
        System.out.println("Please enter ISBN of the item you want to reserv");
        Scanner in = new Scanner(System.in);
        String isbn = in.next();
        
        for(int i = 0; i <libraryItem.size(); i++){
           
            
            if(libraryItem.get(i).getISBN().equals(isbn) && libraryItem.get(i).getBorrowed()==true && libraryItem.get(i).getType().equals("Book")){
                
               if(libraryItem.get(i).getBorrowDate().getDay() + 7 >30 && libraryItem.get(i).getBorrowDate().getMonth()!=12){
                         int d = (libraryItem.get(i).getBorrowDate().getDay()+7) - 30;
                         System.out.println("The Item will be available again on " + d + "/" + (libraryItem.get(i).getBorrowDate().getMonth() + 1) + "/" + libraryItem.get(i).getBorrowDate().getYear());
                         found1 = true;
                     }
               else if(libraryItem.get(i).getBorrowDate().getDay()+7>30 && libraryItem.get(i).getBorrowDate().getMonth()==12){
                    int d = (libraryItem.get(i).getBorrowDate().getDay()+7) - 30;
                    System.out.println("The Item will be available again on " + d + "/" + (libraryItem.get(i).getBorrowDate().getMonth() -11) + "/" + (libraryItem.get(i).getBorrowDate().getYear() +1));
                    found1 = true;
               }
                     else{
                         System.out.println("The item will be available again on " + (libraryItem.get(i).getBorrowDate().getDay()+7) + "/" + libraryItem.get(i).getBorrowDate().getMonth() + "/" + libraryItem.get(i).getBorrowDate().getYear());
                         found1=true;
                     }
                
            }else if(libraryItem.get(i).getISBN().equals(isbn) && libraryItem.get(i).getBorrowed()==true && libraryItem.get(i).getType().equals("DVD")){
                if(libraryItem.get(i).getBorrowDate().getDay() + 3 >30 && libraryItem.get(i).getBorrowDate().getMonth()!=12){
                         int d = (libraryItem.get(i).getBorrowDate().getDay()+3) - 30;
                         System.out.println("The Item will be available again on " + d + "/" + (libraryItem.get(i).getBorrowDate().getMonth() + 1) + "/" + libraryItem.get(i).getBorrowDate().getYear());
                         found1 = true;
                     }
                else if(libraryItem.get(i).getBorrowDate().getDay()+3>30 && libraryItem.get(i).getBorrowDate().getMonth()==12){
                        int d = (libraryItem.get(i).getBorrowDate().getDay()+3) - 30;
                         int m = (libraryItem.get(i).getBorrowDate().getMonth() - 11);
                         int y = (libraryItem.get(i).getBorrowDate().getYear() +1);
                         System.out.println("The Item will be available again on " + d + "/" + m + "/" + y);
                         found1 = true;
               }
                     else{
                         System.out.println("The item will be available again on " + (libraryItem.get(i).getBorrowDate().getDay()+3) + "/" + libraryItem.get(i).getBorrowDate().getMonth() + "/" + libraryItem.get(i).getBorrowDate().getYear());
                         found1 = true;
                     }
            }
            
            System.out.println("Do you want to reserv this item Y/N");
            String r;
            Scanner inn = new Scanner(System.in);
            r = inn.next();
            if(r.equals("y")){
                System.out.println("The item has been reserved");
                System.out.println("");
            }else{
                System.out.println("");
            }
            
            
            
    }
        
        if(found1 == false){
            System.out.println("Item not borroed and its available");
            System.out.println("");
        }
        
        
        
    }
    public boolean printMenu(){
        //meny
        boolean exit = false;
        DateTime date = new DateTime();
         
        
        System.out.println("A: To add a new item");
        System.out.println("D: To delete an item");
        System.out.println("P: To print the list of items");
        System.out.println("B: To borrow an item");
        System.out.println("R: To return an item");
        System.out.println("G: To generate a report");
        System.out.println("Q: To run GUI");
        System.out.println("E: To make a reservation");
        System.out.println("X: To exit");
        
        Scanner in = new Scanner(System.in);
        
        String choise = in.next();
        
        switch(choise){
            
            case "a":
                
                System.out.println(numOfItems - libraryItem.size() + " free spaces");
                
                System.out.println("To add a new Book press B:");
                System.out.println("To add new DVD press D:");
                
                String choise2 = in.next();
                in.nextLine();
                
                
                
                switch(choise2){
                    
                    case "b":
                        
                        if(libraryItem.size() == numOfItems || libraryBook.size() == numOfBooks){
                    System.out.println("No more space for Books in the library");    //checks if there is space for books
                }else System.out.println(numOfBooks - libraryBook.size() + " free spaces");
                        
                         boolean aa=true;
                         boolean ab=false;
                         
                         
                         do{//this code check if the ISBN is unique
                             System.out.println("Please enter ISBN");
                             isbn = in.nextLine();
                             ab=false;
                             for(int i =0;i<libraryItem.size();i++){
                                 if(libraryItem.get(i).getISBN().equals(isbn)){
                                     System.out.println("ISBN awredy takken");
                                     ab=true;
                                 }
                             }aa=ab;
                         }
                         while(aa);
                       
                        System.out.println("Please enter Title");
                        String title = in.nextLine();
                        System.out.println("Please enter sector");
                        String sector = in.nextLine();
                        System.out.println("Please enter Autor");
                        String autor = in.nextLine();
                        System.out.println("Please enter Publisher");
                        String publisher = in.nextLine();
                        
                        boolean error = true;    //same try/catch in while loop to check for correct information
                        while(error){
                            try{
                        System.out.println("Please enter the day of publishing");
                        Scanner inn = new Scanner(System.in);
                        int day = inn.nextInt();
                        if(day==0 || day>30){
                            System.out.println("Wrong input");
                        }
                        else{
                          error = false;
                        date.setDay(day);  
                        }
                        
                        }
                            catch(Exception e){
                                System.out.println("Error wrong input");
                            }
                        }
                        
                        boolean error1 = true;
                        while(error1){
                            try{
                        System.out.println("Please enter the month of publishing");
                        Scanner inn = new Scanner(System.in);
                        int month = inn.nextInt();
                        if(month==0||month>12){
                            System.out.println("Wrong input");
                        }
                        else{
                            error1 = false;
                        date.setMonth(month);
                        }
                              }
                            catch(Exception e){
                                System.out.println("Error wrong input");
                            }
                        }
                        
                        
                        boolean error2 = true;
                        while(error2){
                            try{
                        System.out.println("Please enter the year of publishing");
                        Scanner inn = new Scanner(System.in);
                        int year = inn.nextInt();
                        error2 = false;
                        date.setYear(year);
                        
                            }
                            catch(Exception e){
                                System.out.println("Error wrong input");
                            }
                        }
                        
                        boolean error3 = true;
                        while(error3){
                            try{
                        System.out.println("Please enter number of pages");
                        Scanner inn = new Scanner(System.in);
                        int page = inn.nextInt();
                        this.pages = page;
                        error3 = false;
                            }
                            catch(Exception e){
                                System.out.println("Error wrong input");
                            }
                        } 
                        
                        if(libraryBook.size()< numOfBooks){//check if there is space in the library
                        Book a = new Book(isbn, title, sector, date, null, autor, publisher, pages);
                        this.addItem(a);//we add to libraryItem
                        libraryBook.add(a);//we add to book library 
                        
                        
                            System.out.println("Book added to library");
                            System.out.println("");
                        }else System.out.println("No more space");
                    
                    break;
                    
                    case "d":
                        
                        if(libraryItem.size() == numOfItems || libraryDVD.size() == numOfDvds){
                    System.out.println("No more space for DVDs in the library");   //check if there is space in library for DVD
                }else System.out.println(numOfDvds - libraryDVD.size() + " free spaces");
                        
                        
                        boolean ba=true;
                         boolean bb=false;
                         
                         
                         do{//checks if ISBN is taken when we add DVD
                             System.out.println("Please enter ISBN");
                             isbn1 = in.nextLine();
                             bb=false;
                             for(int i =0;i<libraryItem.size();i++){
                                 if(libraryItem.get(i).getISBN().equals(isbn1)){
                                     System.out.println("ISBN awredy takken");
                                     bb=true;
                                 }
                             }ba=bb;
                         }
                         while(ba);
                        
                        
                        System.out.println("Please enter Title");
                        String title1 = in.nextLine();
                        System.out.println("Please enter sectror");
                        String sector1 = in.nextLine();
                         System.out.println("Please enter language");
                        String language = in.nextLine();
                        System.out.println("Please enter subtitles");
                        String sub = in.nextLine();
                        System.out.println("Please enter producer");
                        String producer = in.nextLine();
                        System.out.println("Please enter actros");
                        String actors = in.nextLine();
                        
                        
                         boolean error4 = true;
                        while(error4){
                            try{
                        System.out.println("Please enter the day");
                        Scanner inn = new Scanner(System.in);
                        int day = inn.nextInt();
                        if(day==0||day>30){
                            System.out.println("Wrong input");
                        }
                        else{
                           error4 = false;
                        date.setDay(day); 
                        }
                     }
                            catch(Exception e){
                                System.out.println("Error wrong input");
                            }
                        }
                        
                        
                         boolean error5 = true;
                        while(error5){
                            try{
                        System.out.println("Please enter the month");
                        Scanner inn = new Scanner(System.in);
                        int month = inn.nextInt();
                        if(month==0||month>12){
                            System.out.println("Wrong input");
                        }
                        else{
                           error5 = false;
                        date.setMonth(month); 
                        }
                        
                        
                            }
                            catch(Exception e){
                                System.out.println("Error wrong input");
                            }
                        }
                        
                        
                         boolean error6 = true;
                        while(error6){
                            try{
                        System.out.println("Please enter the year");
                        Scanner inn = new Scanner(System.in);
                        int year = inn.nextInt();
                        error6 = false;
                        date.setYear(year);
                        
                            }
                            catch(Exception e){
                                System.out.println("Error wrong input");
                            }
                        }
                       
                        
                        if(libraryDVD.size() < numOfDvds){
                            DVD a = new DVD(isbn1, title1, sector1, date, null, language, sub, producer, actors);
                            this.addItem(a);//add to libraryItem
                            libraryDVD.add(a);//add to DVD library
                            
                            
                            System.out.println("DVD added to library");
                            System.out.println("");
                        }else System.out.println("No more space");
                        
                    
                      break;  
                      
                    default:
                        System.out.println("Wrong input");
                        System.out.println("");
                }
                break;
            case "d":
                
                found = false; //flag if ISBN is found or not because in for loop will print error for every other item
                System.out.println("Enter the ISBN of the item you want to delete");
                Scanner inn = new Scanner(System.in);
                String isbn = inn.nextLine();
                
                for(int i =0; i<libraryItem.size();i++){//search on the array and if ISBN is found deleate the item
                    if(libraryItem.get(i).getISBN().equals(isbn)){
                       System.out.println(libraryItem.get(i).getType() + " has been deleted");
                        System.out.println("");
                        found = true;
                       this.deleteItem(libraryItem.get(i));
                    }
                }
                if(found == false){//again with flag because in the for loop will print that its not found for every other item
                    System.out.println("ISBN not found please try again");
                    
                }
                
                System.out.println(numOfItems - libraryItem.size() + " free spaces left");
                System.out.println("");
                   
            break;
            
            case "p":
                this.printItems();
             
            break;
            
            case "b":
                this.borrowItem();
            break;
            
            case "r":
                //return item
                System.out.println("Enter the ISBN of the returned item");
                Scanner input = new Scanner(System.in);
                isbn = input.nextLine();
                //checks if the item is borrowed
                for(int i =0; i<libraryItem.size(); i++){
                    if(libraryItem.get(i).getISBN().equals(isbn) && libraryItem.get(i).getBorrowed() == true){
                        //same loops for information checks
                         boolean error20 = true;
                        while(error20){
                            try{
                        System.out.println("Please enter the day of return");
                        Scanner inputt = new Scanner(System.in);
                        days = inputt.nextInt();
                        if(days==0||days>30){
                            System.out.println("Wrong input");
                        }
                        else{
                          error20 = false;  
                        }
                        
                         }
                            catch(Exception e){
                                System.out.println("Error wrong input");
                            }
                        }
                        
                        boolean error21 = true;
                        while(error21){
                            try{
                        System.out.println("Please enter the month of return");
                        Scanner inputt = new Scanner(System.in);
                        int m = inputt.nextInt();
                        months = m;
                        if(months==0||months>12){
                            System.out.println("Wrong input");
                        }
                        else{
                            error21 = false;
                        }
                        
                         }
                            catch(Exception e){
                                System.out.println("Error wrong input");
                            }
                        }
                        
                       
                        
                        boolean error23 = true;
                        while(error23){
                            try{
                        System.out.println("Please enter the year of return");
                        Scanner inputt = new Scanner(System.in);
                        int y = inputt.nextInt();
                        years = y;
                        error23 = false;
                         }
                            catch(Exception e){
                                System.out.println("Error wrong input");
                            }
                        }
                        
                        boolean error22 = true;
                        while(error22){
                            try{
                        System.out.println("Please enter hour of return");
                        Scanner inputt = new Scanner(System.in);
                        hours = inputt.nextInt();
                        if(hours==0||hours>24){
                            System.out.println("Wrong input");
                        }
                        else{
                            error22 = false;
                        }
                        
                         }
                            catch(Exception e){
                                System.out.println("Error wrong input");
                            }
                        }
                        
                       
                            if(libraryItem.get(i).getISBN().equals(isbn)){
                                libraryItem.get(i).setBorrowed(false) ;//the item is not borrowed now
                                libraryItem.get(i).setReader(null);    // no reader 
                                System.out.println("The item is now returned");
                                type = libraryItem.get(i).getType();
                                //the next line of code conver everything in days and calcualtes the difference so we can calculate how much the reader owns in returnItem funciton
                                //in the returnItem function we convert days to hours to calculate the corect amoujnt
                                days = (days + (months*30) + (years*360)) - (libraryItem.get(i).getBorrowDate().getDay() + (libraryItem.get(i).getBorrowDate().getMonth() * 30) + (libraryItem.get(i).getBorrowDate().getYear()*360));
                            }else{System.out.println("Wrong ISBN");}
                        
                  
                        
                        this.returnItem(days, hours, type);//
                        System.out.println("The reader owns " + money);
                        System.out.println("");
                  
                        
                    }else{System.out.println("Wrong ISBN or item not borrowed");
                        System.out.println("");
                    }     
                }
                
                        
              
            break;
            
            case "g":
        {
            try {
                this.report();
            } catch (IOException ex) {
                Logger.getLogger(WestminsterLibraryManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
             break;
             
            case "x":
                exit = true;
            break;
            
            case "q":
                Gui frame = new Gui(libraryItem);
                
                break;
                
            case "e":
                 reservation();
                break;
            
            
            default:
                System.out.println("Wrong input");
                System.out.println("");
                break;
        }
        
    return exit;    
    }
    
    
    
}
