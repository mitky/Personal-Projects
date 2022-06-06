
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
public class BankSystem {

   
    public static void main(String[] args) {
        
      ThreadGroup human = new ThreadGroup("Human");
      ThreadGroup system = new ThreadGroup("System");
      Statement statement = new Statement("Dimitar",1);
      CurrentAccount bAcc = new CurrentAccount(statement);
      Thread student =new Student("Dimitar", human, bAcc );
      Thread parent = new Parent("Stayce", human, bAcc);
      Thread studentLoan = new StudentLoanCompany("Studen Loan Company", system, bAcc);
      Thread university = new University("University", system, bAcc);
      
   
    
     student.start();
     parent.start();
     studentLoan.start();
     university.start();
      
       
    }
    
}
