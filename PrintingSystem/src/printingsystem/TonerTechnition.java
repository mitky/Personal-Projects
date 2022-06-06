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
public class TonerTechnition extends Thread{
   
    private LaserPrinter printer;
    private String threadGroup;
    private String name;
     public TonerTechnition tonerTechnition;
    public Document document;
    
     public TonerTechnition(LaserPrinter printer, String group, String name){
        this.printer = printer;
        threadGroup = group;
        this.name = name;
    }
     
      public TonerTechnition(){
        
    }
     
      public void run(){
        
         LaserPrinter p1 = new LaserPrinter();
        int paperLevel = p1.getTonerLevel();
              
        
                  
                      while(Student.printer.getTonerLevel()==0 && Student.printed==false){
                                System.out.println("Toner Technition reffiling the printer");
                                putToner();
                                
                                
                          
                      }
                      
                       try{
                                    synchronized(tonerTechnition){
                                     tonerTechnition.wait(3000);
                                    System.out.println("Toner Technition reffiling the printer");
                                    putToner();
                                   // paperTechnition.wait(5000);
                                }
                                }catch(Exception e){
                                    
                                }
        
       
        
    }
      
      
       public void putToner(){
        
        
         
         Student.printer.setTonerLevel(3);
         System.out.println("Toner refilled");
         Student s1 = new Student();
         
         s1.printLeftPaper();
    }
       
        public void TonerTechnition(TonerTechnition p){
        tonerTechnition=p;
    }
    
     public void document(Document d){
        document=d;
    }
    
}
