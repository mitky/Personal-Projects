
package library;


public class DVD extends LibraryItem {
    
    protected String languages;
    protected String sub;
    protected String produser;
    protected String actors;
    protected String type = "DVD";
    protected int counter;
    protected boolean borrowed = false;
    protected Reader reader;
    
    
    
    public DVD(){
        super();
        languages = "";
        sub = "";
        produser = "";
        actors = "";
    }
    
    public DVD(String isbn, String title, String sector, DateTime pDate, DateTime borrowed, String languages, String sub, String produser, String actors){
        super(isbn, title, sector, pDate, borrowed);
        this.languages = languages;
        this.sub = sub;
        this.produser = produser;
        this.actors = actors;
        type = "DVD";
    }
    
    public void setLanguage(String language){
        languages = language;
    }
    
    public String getLanguage(){
        return languages;
    }
    
    public void setSub(String sub){
        this.sub = sub;
    }
    
    public String getSub(){
        return sub;
    }
    
    public void setProduser(String produser){
        this.produser = produser;
    }
    
    public String getProduser(){
        return produser;
    }
    
    public void setActor(String actor){
        actors = actor;
    }
    
    public String getActor(){
        return actors;
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
        return super.toString() + "DVD Info: " + " Languages available: " + languages + " Subtitles: " + sub + " Produser: " + produser + " Actors: " + actors;
    }
    
   
    
    
 }
