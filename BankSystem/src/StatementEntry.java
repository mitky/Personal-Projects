/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mmiit
 */
public class StatementEntry {
     private final char TAB = '\t' ;

    private final String CustomerID ;
    private final int    amount ;
    private final int    currentBal ;


    public StatementEntry( String CID, int amount, int currentBal )
    {
        this.CustomerID = CID ;
        this.amount     = amount ;
        this.currentBal = currentBal ;
    }


    public String getCustomer()      { return CustomerID ; }
    public int    getAmount()        { return amount ;     }
    public int    getCurrentBalance(){ return currentBal ; }


    public String toStringOLD( )
    {
        return  new String(  "Customer: " + CustomerID + ","  + TAB + 
                             "Amount: "   + amount     + ", " + TAB + 
                             "Balance: "  + currentBal 
                          ) ;
    }
}
