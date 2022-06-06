
import static java.lang.Thread.sleep;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mmiit
 */
public class CurrentAccount implements BankAccount{
    
    //Monitor
    
    private double blance;
    private String holderName;
    private int accNumber;
    public  Statement statement;
    public boolean overdrawn;
    private  boolean busy = false;
    private boolean locked = false;
    private boolean student = false;
    private boolean parent = false;
    private boolean studentLoan = false;
   
    
    public CurrentAccount(Statement s){
        statement = s;
    }

    
    public synchronized double getBalance() {
       return blance;
    }

    
    public synchronized int getAccNumber() {
       return accNumber;
    }

    
    public synchronized String getHolderName() {
        return holderName;
    }

    
    public synchronized void printStatement() {
        System.out.println(statement.toString());
    }

    
    public synchronized  void deposit(Transaction t) {
        
       
       while(busy == true){
            try{
            System.out.println("Account busy");
            wait();
           
        }catch(InterruptedException e){}
           
        }
       
       //while the thread is making the transaction the account is locked and other treads will go to wait() state.
   
        
         busy = true;  //lock set
        blance = blance + t.getAmount();  //making the deposit
        System.out.println(t.getCID() + " making deposit: " + t.getAmount());
        statement.addTransaction(t.getCID(), t.getAmount(), (int)getBalance());  //updateing the statement
        busy = false; //releasing the lock;
        notifyAll();  
        
      
    }

    
    public synchronized  void withdrawal(Transaction t) {
        
       while(busy == true){
            try{
            System.out.println("Account busy");
            wait();
           
        }catch(InterruptedException e){}
           
        }
       //if there is not enough money in the account cannot make withdrawal
          while(getBalance()<t.getAmount()){
               try{
            System.out.println("Not enough money in the account");
            wait();
           
                 }catch(InterruptedException e){}
            }
                busy = true;
                blance = blance - t.getAmount();
                statement.addTransaction(t.getCID(), -t.getAmount(), (int)getBalance());
                busy = false;
                notifyAll();
          
    }

    
    public synchronized boolean isOverdrawal() {
       if(blance <= 0){
           overdrawn = true;
           return true;
       }
       else{
           overdrawn = false;
           return false;
       }
    }
    
    
    
}
