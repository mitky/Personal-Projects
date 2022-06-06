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
public class Producer extends Thread{
      private final Mailbox mailbox ; // Mailbox "interface"
  private final int numberOfItems ;   

  public Producer( Mailbox mailbox, 
                   int Pid, 
                   int numberOfItems ) 
  {
     super( "Producer #" + Pid ) ;  // Thread( thrd_name )
     this.mailbox = mailbox ;
     this.numberOfItems = numberOfItems ;
  }

  public void run() 
  {
    for (int i = 0; i < numberOfItems; i++) 
    {
       mailbox.put(i) ;
       System.out.println(getName() + " put:   " + i) ;
       try {
            sleep( (int)(Math.random() * 100) ) ;
           } 
       catch (InterruptedException e) { }
    }
  }

}
