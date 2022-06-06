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
public class SimpleMailbox implements Mailbox{
    private int contents ;
    
    public int take( )
    {
	printState( "take():"+ contents ) ;

	return contents ;
    }
    
    public void put( int value ) 
    {
	printState( "put(" + value + ")   " +1 ) ;

	contents = value ;
    }

   public void printState ( String operation )
    {
	System.out.println( "SimpleMailbox." + operation + this ) ;
    }

    public String toString ( )
    {
	return new String ( "[ contents = " + contents + " ]" ) ;
    }
}
