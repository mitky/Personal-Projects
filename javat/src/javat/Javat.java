
package javat;
import javax.swing.JFrame;

public class Javat {

 
    public static void main(String[] args) {
        clientTest charlie;
        charlie = new clientTest("127.0.0.1");
        charlie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        charlie.startRunning();
    }
    
}
