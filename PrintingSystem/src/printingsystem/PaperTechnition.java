/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printingsystem;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mmiit
 */
public class PaperTechnition extends Thread implements Runnable{
    
    private LaserPrinter printer;
    private String threadGroup;
    private String name;
    public PaperTechnition paperTechnition;
    public Document document;
    
    
    public PaperTechnition(LaserPrinter printer, String group, String name){
        this.printer = printer;
        threadGroup = group;
        this.name = name;
    }
    
    public PaperTechnition(){
       
    }
    
    
    
    public void run() {
        LaserPrinter p1 = new LaserPrinter();
        int paperLevel = p1.getPaperLevel();
              
        
                  
                      while(Student.printer.getPaperLevel()==0 && Student.printed==false){
                                System.out.println("Paper Technition reffiling the printer");
                                putPaper();
                                
                                
                          
                      }
                      
                       try{
                                    synchronized(paperTechnition){
                                     paperTechnition.wait(3000);
                                    System.out.println("Paper Technition reffiling the printer");
                                    putPaper();
                                   // paperTechnition.wait(5000);
                                }
                                }catch(Exception e){
                                    
                                }
                 
    
        
            
        
        
        
        
        
        
        
    }
    
    public void putPaper(){
        
        
         
         Student.printer.setPaperLevel(3);
         System.out.println("Paper refilled");
         Student s1 = new Student();
         
         s1.printLeftPaper();
    }
    
   
    public void PaperTechnition(PaperTechnition p){
        paperTechnition=p;
    }
    
     public void document(Document d){
        document=d;
    }
    
    
}
