
package javaApplication3;
import javax.swing.event.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class JavaApplication3 extends JFrame {

    private JTextField addressBar;
    private JEditorPane display;
    
   public JavaApplication3(){ 
       super("mitko Browser");
    
       addressBar = new JTextField("enter URL hoss!");
       addressBar.addActionListener(
               new ActionListener(){
                   public void actionPerformed(ActionEvent event){
                       loadCrap(event.getActionCommand());
                   }
                }
       );
       add(addressBar, BorderLayout.NORTH);
       display = new JEditorPane();
       display.setEditable(false);
       display.addHyperlinkListener(
             new HyperlinkListener(){
                 public void hyperlinkUpdate(HyperlinkEvent event){
                     if(event.getEventType()==HyperlinkEvent.EventType.ACTIVATED){
                         loadCrap(event.getURL().toString());
                     }
                 }
                }  
       );
       add(new JScrollPane(display), BorderLayout.CENTER);
       setSize(500,300);
       setVisible(true);
   }
    
    private void loadCrap(String userText){
        try{
            display.setPage(userText);
            addressBar.setText(userText);
        }catch(Exception e){
            System.out.println("Crap!");
        }
    }
}
