
import static java.lang.Thread.sleep;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mmiit
 */
public class StudentLoanCompany extends Thread{
    
    private String name;
    private ThreadGroup threadGroup;
    private CurrentAccount bankAccount;
    private Transaction transaction;
    
    public StudentLoanCompany(String name, ThreadGroup tGroup, CurrentAccount bAcc){
        super(name);
        this.name = name;
        threadGroup = tGroup;
        bankAccount = bAcc;
    }
    
     public void run(){
          
          System.out.println(getName() + " Starts to make a deposit");
           
        for(int i=0;i<3;i++){
            
            
            Random rand = new Random(); 
            int value = rand.nextInt(100); 
            
            Transaction t = new Transaction("Student Loan Company",value);
          
             bankAccount.deposit(t);
             //System.out.println(getName() + " making deposit: " + value);
            
            
            try{
                sleep((int)(Math.random() * 1000));
            }catch(InterruptedException e){
                
            }
        }
           
         System.out.println(getName() + " Finished making a deposit");
        
         
        
         
    }
    
     public void deposit(){
        
    }
    
}
