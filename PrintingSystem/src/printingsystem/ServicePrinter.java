/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printingsystem;

/**
 *
 * @author mmiit
 */
public interface ServicePrinter {
    
    
    public void printDocument();
    
    public void refillPaper();
    
    public void refillToner();
    
     public boolean printerInUse();
}
