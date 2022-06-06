
package library;




public class Library {

    
    public static void main(String[] args) {
        
        LibraryManager manager = new WestminsterLibraryManager(150);
        
        boolean exit = false;
        
        while(!exit){
            exit = manager.printMenu();
        }
        
    }
}
