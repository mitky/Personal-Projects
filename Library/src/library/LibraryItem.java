
package library;





public abstract class LibraryItem {
    
    protected String ISBN;
    protected String title;
    protected String sector;
    protected DateTime publicationDate;
    protected DateTime borrowed;
    protected Reader reader;

    
 
    
    public LibraryItem(){
        ISBN = "";
        title = "";
        sector = "";
        publicationDate = null;
        borrowed = null;
        
        
        
    }
    
    public LibraryItem(String isbn, String title, String sector, DateTime pDate, DateTime borrowed){
        ISBN = isbn;
        this.title = title;
        this.sector = sector;
        publicationDate = pDate;
        this.borrowed = borrowed; 
    }
    
     public void setISBN(String isbn){
         ISBN = isbn;
     }
     
     public String getISBN(){
         return ISBN;
     }
     
     public void setTitle(String title){
         this.title = title;
     }
     
     public String getTitle(){
         return title;
     }
     
     public void setSector(String sector){
         this.sector = sector;
     }
     
     public String getSector(){
         return sector;
     }
     
     public void setPubDate(DateTime date){
         publicationDate = date;
     }
     
     public DateTime getPubDate(){
         return publicationDate;
     }
     
     public void setBorrowDate(DateTime date){
         borrowed = date;
     }
     
     public DateTime getBorrowDate(){
         return borrowed;
     }
     
     public void setReader(Reader reader){
         this.reader = reader;
     }
     
     public Reader getReader(){
         return reader;
     }
     
     public String toString(){
         return "ISBN: " + ISBN + " Title: " + title + " sector: " + sector + " Published date: " + publicationDate + " Date borrowed: " + borrowed;
     }
     
    public abstract void setBorrowed(boolean borrowed); //check if the item is borrowed
   
    public abstract boolean getBorrowed();
    
    
     
    public abstract String getType();  // get the type of the item if its Book or DVD
        
    
   }
