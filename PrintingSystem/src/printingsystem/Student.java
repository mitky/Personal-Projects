/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printingsystem;

import java.util.ArrayList;

/**
 *
 * @author mmiit
 */
public  class  Student extends Thread{
    private ServicePrinter p;
    public static LaserPrinter printer;
    public Document document;
    private boolean usingPrinter;
    private String studentName;
    private String threadGroup;
    int docLeftToPRint;
   static int pagesLeft;
   static int paperLeft;
   static String printingStudentName;
  static  boolean printedInUse = false;
  public PaperTechnition paperTechnition;
  public TonerTechnition tonerTechnition;
 static boolean printed = false;
    
  
    
    
    
    public ArrayList<Student> students = new ArrayList<Student>();
     public ArrayList<Document> documents = new ArrayList<Document>();
    
   
    
    public Student(LaserPrinter printer, Document doc,String name, String tGroup){
        document = doc;
        this.studentName = name;
        threadGroup = tGroup;
        this.printer = printer;
        
        
    }
    
    public Student(){
        
    }
    
    public void setStudentName(String name){
        studentName = name;
    }
    
    public String getStudentName(){
        return studentName;
    }
    public void setThreadGroup(String group){
        threadGroup = group;
    }
    
    public String getThreadGroupp(){
       return threadGroup;
    }
    
    public void document(Document doc){
     document = doc;
    }
    
    public void  print(Document doc){
        
        int pages  = doc.getPages();
        int paperLevel = printer.getPaperLevel();
        int tonerLevel = printer.getTonerLevel();
        
        while(paperLevel>0 && tonerLevel>0){
            for(int i=0; i<paperLevel;i++){
                System.out.println("Page " +doc.getPages() + " printed");
                doc.setPages(doc.getPages()-1);
                paperLevel = paperLevel-1;
                printer.setPaperLevel(printer.getPaperLevel() -1);
                printer.setTonerLevel(printer.getTonerLevel() -1);
                pages = pages-1;
                pagesLeft = pages;
                
                
                
        }
            
            }
         if(printer.getPaperLevel()==0){
                 System.out.println("No more paper");
                 PaperTechnition t = new PaperTechnition();
                 t.document(doc);
                
                      try{
                          if(printer.getPaperLevel()==0){
                                 t.putPaper();;
                              }
                          synchronized(tonerTechnition){
                             tonerTechnition.start();
                           
                              
                          }
                          
                      }catch(Exception e){} 
        }
         
         if (printer.getTonerLevel()==0){
             System.out.println("No more toner");
                 TonerTechnition t = new TonerTechnition();
                 t.document(doc);
                
                      try{
                          if(printer.getTonerLevel()==0){
                                 t.putToner();;
                              }
                          synchronized(paperTechnition){
                              paperTechnition.start();
                           
                              
                          }
                          
                      }catch(Exception e){} 
         }
        
       
        
//        for(int i =0; i<documents.size();i++){
//            pages = documents.get(i).getPages();
//            
//           for(int j =0;j<=pages;j++){
//               if(printer.getPaperLevel()==0){
//                   PaperTechnition p = new PaperTechnition();
//                   p.run();
//               }
//               
//               else{
//               System.out.println("Printing doc " + (i+1) + " page " + documents.get(i).getPages());
//               documents.get(i).setPages( documents.get(i).getPages()-1);
//               printer.setPaperLevel(printer.getPaperLevel() -1);
//               }
//               
//               
//               
//               
//           }
//           
//        }
          
         
        //printed = true;
            
    }
    
    public void run(){
        Student s1 = new Student(printer,document, studentName, "g1");
       
       // boolean printedInUse = printer.printerInUse();
        int  paperLevel = printer.getPaperLevel();
        int tonerLevel = printer.getTonerLevel();
        
     
            
                
                
              
                while(printedInUse == false && paperLevel>0 && tonerLevel>0){
                 printedInUse=true;
                System.out.println("Student " + studentName + " is printing now");
                    
                print(document);
                printingStudentName = studentName;
                
              
                
                if(document.getPages()==0){
                 System.out.println("Student " +studentName + " finnished printing");
                 
                
                }
                else if(pagesLeft==0){
                    System.out.println("Student " +studentName + " finnished printing");
                }
               
                    
                 
                 
            }
                
            
             
            printedInUse=false;
        
             
            
       
    }
    
    public void addStudentToArray(Student student){
        students.add(student);
        
    }
    
    public void addDocumentToArray(ArrayList<Document> document){
        documents=document;
        
    }
    public  void printLeftPaper(){
        
      
       
        
         if(pagesLeft>0 && printer.getPaperLevel()>0 && printer.getTonerLevel()>0){
             
             for(int i=0 ;i<=pagesLeft;i++){
                  System.out.println("Page " + (pagesLeft)+ " printed");
                pagesLeft = pagesLeft -1;
                 printer.setPaperLevel(printer.getPaperLevel() - 1);
                  printer.setTonerLevel(printer.getTonerLevel() - 1);
                 if(printer.getPaperLevel()==0){
                     
                     System.out.println("No more paperr");
//                     synchronized(paperTechnition){
//                              paperTechnition.start();
//                              
//                     }
                      PaperTechnition t1 = new PaperTechnition();
                                t1.putPaper();
                     
                    
                 }
                 
                  if(printer.getTonerLevel()==0){
                      System.out.println("No more tonerr");
                       TonerTechnition t1 = new TonerTechnition();
                      t1.putToner();
                 }
             }
              
                     
                }
        
         
         if(pagesLeft==0){
             
             
            // System.out.println("Student " +printingStudentName + " finnished printing");
              
         }
        
    }
    
    public void checkPrinter(){
       
         System.out.println(pagesLeft);
    }
    
    public void sendPaperTechnition(PaperTechnition p){
        paperTechnition =p;
    }
    
     public void sendTonerTechnition(TonerTechnition p){
        tonerTechnition =p;
    }
    
  
    
   
}
