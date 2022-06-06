/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package background;

import java.awt.Image;
import javax.swing.JFrame;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class background1 extends javax.swing.JFrame {

    
    private Image pic = null;
   private Image pic1 = null;
   private Image pic2 = null;
   private Image mat = null;
   public int position = 0;
   
    static card card1 = new card("C:\\Users\\mmiit\\Pictures\\pics\\77986.jpg");
  static card card2 = new card("C:\\Users\\mmiit\\Pictures\\pics\\284288.jpg");
  static card card3 = new card("C:\\Users\\mmiit\\Pictures\\pics\\349005.jpg");
  
   
  static ArrayList<card> deck = new ArrayList<card>();
  
  
  public int getRandomNumber(){
  
      Random rand = new Random();
        
      int int_rand = rand.nextInt(2);
      
      return int_rand;
   }
  
  public  void loadpics(String path){
        
        mat = new ImageIcon("C:\\Users\\mmiit\\Pictures\\pics\\mat1.jpg").getImage();
        
        
        if(position==0){
        pic = new ImageIcon(path).getImage();
        repaint();
        
        }
        
        if(position==1){
        pic1 = new ImageIcon(path).getImage();
        repaint();
        }
    }
  
  public  void paint(Graphics g){
       
           Graphics2D g2 = (Graphics2D)g;
           g.drawImage(mat,0,0,2000, 1100, null);
           
           
           if(position==1&&pic!=null){
           g.drawImage(pic,900, 600, 150, 150, null);
           
           
           }
           
           else if(position==2){
               g.drawImage(mat,0,0, 2000,1100, null);
               g.drawImage(pic,750, 600, 150, 150, null);
               g.drawImage(pic1,1000, 600, 150, 150, null);
              }
           
     }
  
  
   
    
    public background1() {
        initComponents();
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\mmiit\\Pictures\\pics\\mat1.jpg")); // NOI18N
        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(355, 355, 355)
                .addComponent(jButton1)
                .addContainerGap(387, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(389, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(176, 176, 176))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        loadpics(deck.get(0).getPath());
        
        position++;
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public static void main(String args[]) {
        
        deck.add(card1);
        deck.add(card2);
        deck.add(card3);
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new background1().setVisible(true);
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
