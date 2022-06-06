/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prodconsimplemailbox;

/**
 *
 * @author mmiit
 */
public class Consumer extends Thread {
      private final Mailbox mailbox ; // Mailbox "interface"
  private final int numberOfItems ;   
  private int[] valuesConsumed ;

  public Consumer( Mailbox mailbox, 
                   int Cid, 
                   int numberOfItems ) 
  {
     super( "Consumer #" + Cid ) ;  // Thread( thrd_name )
     this.mailbox = mailbox ;
     this.numberOfItems = numberOfItems ;

    valuesConsumed = new int[ numberOfItems ] ;

    for (int i = 0; i < numberOfItems; i++) 
    {
      valuesConsumed[i] = -99 ;
    }

  }

  public void run() 
  {

    int[] valuesConsumed = new int[ numberOfItems ] ;
    int value = 0 ;


    for (int i = 0; i < numberOfItems; i++) 
    {
      value = mailbox.take();
      valuesConsumed[i] = value ;      
      System.out.println(getName() + " taken: " + value) ;
    }

    System.out.print( getName() + " consumed: < " ) ;
    for (int i = 0; i < numberOfItems; i++) 
    {
            System.out.print( valuesConsumed[i] + " " ) ; 
    }
    System.out.println( ">") ;
}
}