
package library;

import java.io.IOException;


public interface LibraryManager {
    
   
    public abstract void addItem(LibraryItem item);
    
    public abstract void deleteItem(LibraryItem item);
   
    public abstract void printItems();
    
    public abstract void borrowItem();
    
    public abstract void returnItem(double h, double d, String type);
    
    public abstract void report() throws IOException;
    
    public abstract boolean printMenu();
    
}
