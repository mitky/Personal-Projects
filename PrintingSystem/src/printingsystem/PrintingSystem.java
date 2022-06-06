/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printingsystem;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mmiit
 */
public class PrintingSystem {

    /**
     * @param args the command line arguments
     */
     public static PaperTechnition Technition;
      public static TonerTechnition tTechnition;
    public static void main(String[] args) {
        
       ArrayList<Document> docs = new ArrayList<Document>();
       
      
       
        Document doc = new Document("student1", "doc1", 5);
         Document doc1 = new Document("student1", "doc2", 5);
         Document doc2 = new Document("student1", "doc3", 5);
          Document doc3 = new Document("student1", "doc4", 5);
           Document doc4 = new Document("student1", "doc5", 5);
           
           docs.add(doc);
//           docs.add(doc1);
//           docs.add(doc2);
//           docs.add(doc3);
//           docs.add(doc4);
           
            
           
       
        LaserPrinter printer = new LaserPrinter("Printer", 1);
          Student s1 = new Student(printer,doc,"Mark", "Student Group");
          Student s2 = new Student(printer,doc1,"Simon", "Student Group");
          Student s3 = new Student(printer,doc2,"John", "Student Group");
          Student s4 = new Student(printer,doc3,"Roger", "Student Group");
        
        PaperTechnition paperTechnition = new PaperTechnition(printer,"technition Group", "mark");
         TonerTechnition tonerTechnition = new TonerTechnition(printer,"technition Group", "mark");
        Technition = paperTechnition;
        s1.sendPaperTechnition(paperTechnition);
        paperTechnition.PaperTechnition(paperTechnition);
        tonerTechnition.TonerTechnition(tonerTechnition);
        s1.sendTonerTechnition(tonerTechnition);
        tTechnition = tonerTechnition;
        
        s1.addStudentToArray(s1);
        s1.document(doc);
        s1.addDocumentToArray(docs);
        
       
        
        
        s2.addStudentToArray(s2);
        s2.document(doc1);
       
        
        s3.addStudentToArray(s3);
        s3.document(doc2);
        
        s4.addStudentToArray(s4);
        s4.document(doc3);
       
        
        
       
         try {
            
              s1.start();
               s1.sleep(1000);
              s2.start();
              s2.sleep(1000);
               s3.sleep(1000);
               
              s3.start();
              
              s4.sleep(1000);
              s4.start();
              
             synchronized(Technition){
             Technition.wait();
            
             }
             
             synchronized(tTechnition){
             tTechnition.wait();
            
             }
            
               
         } catch (InterruptedException ex) {
             Logger.getLogger(PrintingSystem.class.getName()).log(Level.SEVERE, null, ex);
         }
      
      
      
        try {
	        s1.join() ;
                s2.join();
                s3.join();
		paperTechnition.join() ;
	     } 
	catch (InterruptedException e){ }
       
    }
    
   
    
}
