/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurenttutorial7;

/**
 *
 * @author mmiit
 */
public class Runner extends Thread{
     // Used to TERMINATE the thread 
    public volatile boolean terminate = false ; 

    public int tick = 1;

    public Runner( int id ) 
    { 
	super( "Runner-" + id ) ;
    }

    public void run() 
    {
        while ( (tick < 400000000) && !terminate ) 
        {
            tick++ ;
        }
    }
}
