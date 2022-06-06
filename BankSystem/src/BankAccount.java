/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mmiit
 */
public interface BankAccount {
    double getBalance();
    int getAccNumber();
    String getHolderName();
    
    void  deposit(Transaction t);
    void withdrawal(Transaction t);
    
    boolean isOverdrawal();
    
    void printStatement();
}
