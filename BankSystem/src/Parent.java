
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mmiit
 */
public class Parent extends Thread{
    
    private String name;
    private Transaction transaction;
    private ThreadGroup threadGroup;
    private CurrentAccount bankAccount;
    
    public Parent(String name, ThreadGroup tGroup, CurrentAccount bAcc){
        super(name);
        this.name = name;
        threadGroup = tGroup;
        bankAccount = bAcc;
    }
    
     public void run(){
       
         System.out.println(getName() + " Starts to make a deposit");
         
         Transaction a = new Transaction("Parent",0);
         
        for(int i=0;i<2;i++){
            
            Random rand = new Random(); 
            int value = rand.nextInt(100); 
           
            Transaction t = new Transaction("Parent",value);
            
                      bankAccount.deposit(t);
                     // System.out.println(getName() + " making deposit: " + value);
                      
                  
            try{
                sleep((int)(Math.random() * 1000));
            }catch(InterruptedException e){}
           
             }
       
          System.out.println(getName() + " Finished making a deposit");
          

     }
    
     public void deposit(){
         

    }
    
}
