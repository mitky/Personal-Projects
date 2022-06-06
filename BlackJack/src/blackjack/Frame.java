
package blackjack;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;


public class Frame extends javax.swing.JFrame {

    
   private Image pic = null;
   private Image pic1 = null;
   private Image pic2 = null;
   private Image mat = null;
   public int position = 0;
   
    static    card card1 = new card("C:\\Users\\mmiit\\Pictures\\pics\\77986.jpg");
    static    card card2 = new card("C:\\Users\\mmiit\\Pictures\\pics\\284288.jpg");
    static    card card3 = new card("C:\\Users\\mmiit\\Pictures\\pics\\349005.jpg");
    
 static ArrayList<card> deck = new ArrayList<card>();
 static ArrayList<String> list = new ArrayList<String>();
 
   
  
  
  
   
   public int getRandomNumber(){
  
      Random rand = new Random();
        
      int int_rand = rand.nextInt(3);
      
      return int_rand;
   }
   
   public  void paint(Graphics g){
       
           Graphics2D g2 = (Graphics2D)g;
           g.drawImage(mat,0,0,800, 550, null);
           
           
           if(position==1&&pic!=null){
           g.drawImage(pic,300, 230, 150, 150, null);
           
           
           }
           
           else if(position==2){
               g.drawImage(mat,0,0, 800,550, null);
               g.drawImage(pic,200, 230, 150, 150, null);
               g.drawImage(pic1,450, 230, 150, 150, null);
              
           }
    }
   
   public   void loadpics(){
        
        mat = new ImageIcon("C:\\Users\\mmiit\\Pictures\\pics\\mat1.jpg").getImage();
        
        
        if(position==0){
       
        pic = new ImageIcon(list.get(1)).getImage();
        repaint();
        
        }
        
        if(position==1){
        pic1 = new ImageIcon("C:\\Users\\mmiit\\Pictures\\pics\\284288.jpg").getImage();
        repaint();
        }
    }
   
    public Frame() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jButton1.setText("card");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(360, 360, 60, 26);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\mmiit\\Pictures\\pics\\mat1.jpg")); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 790, 471);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        loadpics();
//        for(int i=0;i<=deck.size();i++){
//        System.out.println(deck.get(i).getPath());
//    }

      
        position++;
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public static void main(String args[]) {
        
       
        
            
            deck.add(card1);
            deck.add(card2);
            deck.add(card3);
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            
            deck.add(card1);
            deck.add(card2);
            deck.add(card3);    
                
            }
        });
    }

          
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}


