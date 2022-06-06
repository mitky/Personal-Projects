
package javagame;

import java.awt.*;
import javax.swing.JFrame; 

public class JavaGame extends JFrame{

    
    public static void main(String[] args) {
        
        DisplayMode dm = new DisplayMode(800,600,16, DisplayMode.REFRESH_RATE_UNKNOWN);
        JavaGame b = new JavaGame();
        b.run(dm);
    }
    
    
    public void run(DisplayMode dm){
        setBackground(Color.PINK);
        setForeground(Color.WHITE);
        setFont(new Font("Ariel", Font.PLAIN, 24));
        
        Screen s = new Screen();
        try{
            s.setFullScreen(dm, this);
            
            try{
                Thread.sleep(5000);
            }catch(Exception e){}
        }finally{
            s.restoreScreen();
        }
    }
    
    public void paint(Graphics g){
        g.drawString("This is ok", 200, 200);
    }
    
}
