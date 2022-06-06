
package library;

public class Book extends LibraryItem {
    
    protected String autor;
    protected String publisher;
    protected int numOfPages;
    protected String type = "Book";
    protected static  int counter;
    protected boolean borrowed = false;
    protected Reader reader;
    
   
    
    public Book(){
        super();
        autor = "";
        publisher = "";
        type = "Book";
        numOfPages = 0;
    }
    
    public Book(String isbn, String title, String sector, DateTime pDate, DateTime borrowed, String autor, String publisher, int pages){
        super(isbn, title, sector, pDate, borrowed);
        this.autor = autor;
        this.publisher = publisher;
        type = "Book";
        numOfPages = pages;
    }
    
    public void setAutor(String autor){
        this.autor = autor;
    }
    
    public String getAutor(){
        return autor;
    }
    
    public void setPublisher(String publisher){
        this.publisher = publisher;
    }
    
    public String getPublisher(){
        return publisher;
    }
    
    public void setNumOfPages(int pages){
        numOfPages = pages;
    }
    
    public int getNumOfPages(){
        return numOfPages;
    }
    
    public void setType(String type){
        this.type = type;
    }
    
    public String getType(){
        return type;
    }
    
    public void setBorrowed(boolean borrowed){
        this.borrowed = borrowed;
    }
    
    public boolean getBorrowed(){
        return borrowed;
    }
    
    public void setReader(Reader reader){
        this.reader = reader;
    }
    
    public Reader getReader(){
        return reader;
    }
    
    public String toString(){
        return super.toString() + " Book Info: " + " Autor " + autor + " Publisher: " + publisher + " Pages: " + numOfPages;
    }
    
    

    
    
    
  }
