/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printingsystem;

/**
 *
 * @author mmiit
 */
public class LaserPrinter implements ServicePrinter{
    private Document document;
    private Student student;
    private PaperTechnition paperTechnition;
    private TonerTechnition tonerTechnition;
    private String name;
    private int id;
    private int paperLevel =3;
    private int tonerLevel=3;
    private int docPrinted;
    private boolean printerInUse = false;
    
    public LaserPrinter( String name, int id){
       
        this.name = name;
        this.id = id;
    }
    
     public LaserPrinter( ){
       
       
    }
    
    public void setID(int id){
        this.id = id;
    }
    
    public int getID(){
        return id;
    }
    
    public void setPaperLevel(int paper){
        paperLevel = paper;
    }
    
    public int getPaperLevel(){
        return paperLevel;
    }
    
    public void setTonerLevel(int toner){
        tonerLevel = toner;
    }
    public int getTonerLevel(){
        return tonerLevel;
    }
    
    public void setDocPrinterd(int doc){
        docPrinted = doc;
    }
    
    public int getDocPrinted(){
        return docPrinted;
    }
    
    public String toString(){
        return ("PrinterID " + id + " Paper Level " + paperLevel + "Toner Level " + tonerLevel + "Documents printed" + docPrinted);
    }
    
    public void printDocument(){
    
    }
    
    public void refillPaper(){
    
    }
    
    public void refillToner(){
    
    }
    public boolean printerInUse(){
        return printerInUse;
    }
}
