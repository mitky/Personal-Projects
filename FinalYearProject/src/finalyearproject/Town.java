/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalyearproject;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import jdk.javadoc.internal.tool.Main;

/**
 *
 * @author mmiit
 */
public class Town extends javax.swing.JFrame {

    public boolean swordChanged=false;
    public boolean bootsChanged=false;
    public boolean cloakChanged=false;
    
     public boolean townHallVisited=false;
    
    public int dice6 = 0;
    private float alpha = 0.5f;
    
    
     public  void paint(Graphics g){
     
             URL url = Main.class.getResource("/town1.png");
         URL url1 = Main.class.getResource("/bottomPanel.png");//bottom panel image
        
          
         //Swords images
         URL commonSwordUrl = Main.class.getResource("/commonSword.png");
         URL rareSwordUrl = Main.class.getResource("/rareSword.png");
         URL epicSwordUrl = Main.class.getResource("/epicSword.png");
         
         URL commonCloakUrl = Main.class.getResource("/commonCloak.png");
         URL rareCloakUrl = Main.class.getResource("/rareCloak.png");
         
         
         URL commonBootsUrl = Main.class.getResource("/commonBoots.png");
         URL rareBootsUrl = Main.class.getResource("/rareBoots.png");
         
         ImageIcon commonSword = new ImageIcon(commonSwordUrl);
         ImageIcon rareSword = new ImageIcon(rareSwordUrl);
         ImageIcon epicSword = new ImageIcon(epicSwordUrl);
         
         ImageIcon commonCloak = new ImageIcon(commonCloakUrl);
         ImageIcon rareCloak = new ImageIcon(rareCloakUrl);
         
         
         ImageIcon commonBoots = new ImageIcon(commonBootsUrl);
         ImageIcon rareBoots = new ImageIcon(rareBootsUrl);
      
         
         Image image = new ImageIcon(url).getImage(); //background
         Image image1 = new ImageIcon(url1).getImage(); //bottomPanel
        
         
          //draw he back ground
          Graphics2D g2 = (Graphics2D)g;
          
//           Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//            int height = (int) screenSize.getHeight();
//            int width = (int) screenSize.getWidth();
        
            //g.drawImage(image, 0, 0, width, height, null);
          
          g.drawImage(image,0,0,1950, 1050, null);
    
          //draw the character in bottom left and skill and dice images
          
         URL warrior = Main.class.getResource("/warrior1.jpg");
         URL mage = Main.class.getResource("/mage2.png");
         URL warrior_skill = Main.class.getResource("/warrior_skill1.png");
         URL url3 = Main.class.getResource("/mage_skill.jpg");
         URL dice6 = Main.class.getResource("/dice6.png");
         URL inventory_bag = Main.class.getResource("/inventory_bag.png");
         URL player = Main.class.getResource("/inventory_bag.png");
         
         
        
         
         ImageIcon i1 = new ImageIcon(warrior);
         ImageIcon i2 = new ImageIcon(mage);
         ImageIcon i3 = new ImageIcon(warrior_skill);
         ImageIcon i4 = new ImageIcon(url3);
         ImageIcon i5 = new ImageIcon(dice6);
         ImageIcon i6 = new ImageIcon(inventory_bag);
         
         String charClass = User.characterClass;
         
         if(charClass=="warrior"){
         jButton1.setIcon(i1);
         jButton2.setIcon(i3);
         
         }
         else{
         jButton1.setIcon(i2);
         jButton2.setIcon(i4);
         }
         
         jButton3.setIcon(i5);
         
         
         //paint empty inventory  image
         
         jButton4.setIcon(i6);
         jButton5.setIcon(i6);
         jButton6.setIcon(i6);
         jButton7.setIcon(i6);
         
         
         //display sword image
         for(int i=0;i<User.items.size();i++){
             if(User.items.get(i).getType().equals("Sword")){
                 if(User.items.get(i).rarety.equals("common")){
                     jButton4.setIcon(commonSword);
                 }else if(User.items.get(i).rarety.equals("rare")){
                      jButton4.setIcon(rareSword);
                 }else if(User.items.get(i).rarety.equals("epic")){
                     jButton4.setIcon(epicSword);
                 }
              }
             if(User.items.get(i).getType().equals("Cloak")){
                 if(User.items.get(i).rarety.equals("common")){
                     jButton5.setIcon(commonCloak);
                 }else if(User.items.get(i).rarety.equals("rare")){
                     jButton5.setIcon(rareCloak);
                 }
             }
             
             
             
             
             if(User.items.get(i).getType().equals("Boots")){
                if(User.items.get(i).rarety.equals("common")){
                    jButton6.setIcon(commonBoots);
                }else if(User.items.get(i).rarety.equals("rare")){
                    jButton6.setIcon(rareBoots);
                }
             }
          }
         
         
          String name = User.name;
          String hp = String.valueOf(User.hp);
          String roll = String.valueOf(User.roll);
          String stealth = String.valueOf(User.stealth);
          String dogde = String.valueOf(User.dodge);
          String dice = String.valueOf(this.dice6);
         
          //draw dice roll value
           g.setFont(new Font("TimesRoman", Font.PLAIN,40));
          g.setColor(Color.red);
          g.drawString(dice, 1020, 830);
           
          g.drawString(name, 295, 810);
          
          g.drawString("Stats: ", 295, 850);
          
          g.drawString("HP:", 295, 890);
          g.drawString(hp, 375, 890);
          
          g.drawString("Strenght:", 295, 930);
          g.drawString(roll, 460, 930);
          
          g.drawString("Stealth:", 295, 970);
          g.drawString(stealth, 435, 970);
          
          g.drawString("Dogde:", 295, 1010);
          g.drawString(dogde, 435, 1010);
          
          
          g.drawString("Skill ", 570, 850);
           
          g.drawString("Inventory ", 1415, 820);
          
          
          //draw visit bordrs
          g.setColor(Color.RED); 
          g.drawString("Merchant ", 355, 585);
          g.drawRect(322,540,237,66); 
          
          g.drawString("Town Hall ", 920, 650);
          g.drawRect(914,602,186,66);
          
          g.drawString("Exit ", 1780, 615);
          g.drawRect(1693,570,237,66);
     
          String gold = String.valueOf(User.gold);
          
          g.drawString("Gold:", 1685, 870);
          g.drawString(gold, 1720, 930);
          
          g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,alpha));
          
          g.drawImage(image1,0,770,2500, 270, null);
          
          
         
     }
    
    
    public Town() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton2.setText("jButton2");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("jButton4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("jButton5");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("jButton6");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("jButton7");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton1.setText("jButton1");

        jLabel1.setText("jLabel1");
        jLabel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel1MouseMoved(evt);
            }
        });
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
        });

        jLabel2.setText("jLabel2");
        jLabel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel2MouseMoved(evt);
            }
        });
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
        });

        jLabel3.setText("jLabel3");
        jLabel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel3MouseMoved(evt);
            }
        });
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
        });

        jLabel4.setText("jLabel4");
        jLabel4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel4MouseMoved(evt);
            }
        });
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/merchant.jpg"))); // NOI18N
        jButton8.setText("jButton8");
        jButton8.setMargin(new java.awt.Insets(2, 20, 2, 20));

        jButton9.setText("Merchant");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Exit");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton12.setText("Town Hall");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(136, 136, 136)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(308, 308, 308)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(311, 311, 311)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(314, 314, 314)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(357, 357, 357)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(133, 133, 133))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(101, 101, 101)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked

        if(User.characterClass=="warrior"){
            JOptionPane.showMessageDialog(this, "A powerfull attack that gives you +3 to Roll");
            JOptionPane.showMessageDialog(this, "This skil can be used once per zone");
        }
        else{
            JOptionPane.showMessageDialog(this, "Cast a invisability spell that gives you +3 to Stealth");
            JOptionPane.showMessageDialog(this, "This skil can be used once per zone");
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
     
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jLabel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseMoved

    }//GEN-LAST:event_jLabel1MouseMoved

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        JOptionPane.showMessageDialog(this, "Healt points");
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered

    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseMoved

    }//GEN-LAST:event_jLabel2MouseMoved

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        JOptionPane.showMessageDialog(this, "Adds the roll number to the number you rolled on the dice");
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered

    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseMoved

    }//GEN-LAST:event_jLabel3MouseMoved

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        JOptionPane.showMessageDialog(this, "Adds the stelath number to the number you rolled on the dice when rolling for stealth action");
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered

    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseMoved

    }//GEN-LAST:event_jLabel4MouseMoved

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        JOptionPane.showMessageDialog(this, "Adds the dogde number to the number you rolled on the dice when rolling for dogde action");
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered

    }//GEN-LAST:event_jLabel4MouseEntered

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
                
        JPanel panel = new JPanel();
        JFrame merchent = new JFrame();
        JButton choose1 = new JButton("Choose");
        JButton choose2 = new JButton("Choose");
        JButton choose3 = new JButton("Choose");
        JButton item1 = new JButton();
        JButton item2 = new JButton();
        JButton item3 = new JButton();
        JButton close = new JButton("Close");
        
        
       
        JLabel rare = new JLabel("rare items");
        
      
        JLabel roll = new JLabel("+2 Strenght");
        JLabel stealth = new JLabel("+2 Stealth");
        JLabel dodge = new JLabel("+2 Dodge");
        
        JLabel gold = new JLabel("15 gold");
        JLabel gold1 = new JLabel("15 gold");
        JLabel gold2 = new JLabel("15 gold");
        
        
        URL rareBootsUrl = Main.class.getResource("/rareBoots.png");
        ImageIcon rareBoots = new ImageIcon(rareBootsUrl);
        
        URL rareCloakUrl = Main.class.getResource("/rareCloak.png");
        ImageIcon rareCloak = new ImageIcon(rareCloakUrl);
        
        URL rareSwordUrl = Main.class.getResource("/rareSword.png");
        ImageIcon rareSword = new ImageIcon(rareSwordUrl);
        
        
      
         
         panel.setSize(450, 450);
         choose1.setBounds(15, 230, 100, 45);
         choose2.setBounds(140, 230, 100, 45);
         choose3.setBounds(260, 230, 100, 45);
         
         item1.setBounds(0, 70, 125, 125);
         item2.setBounds(125, 70, 125, 125);
         item3.setBounds(250, 70, 125, 125);
         
        item1.setIcon(rareBoots);
        dodge.setBounds(40,200,100,45);
        
        
        item2.setIcon(rareSword);
        rare.setBounds(170, 7, 100, 45);
        roll.setBounds(175, 200, 100, 45);
        
        item3.setIcon(rareCloak);
        stealth.setBounds(290,200,100,45);
        
        gold.setBounds(40, 30, 100, 45);
        gold1.setBounds(175, 30, 100, 45);
        gold2.setBounds(290, 30, 100, 45);
       
        close.setBounds(140,300,100,45);
       
        merchent.setUndecorated(true);
        
        merchent.add(choose1);
        merchent.add(choose2);
        merchent.add(choose3);
        merchent.add(item1);
        merchent.add(item2);
        merchent.add(item3);
        merchent.add(rare);
        merchent.add(roll);
        merchent.add(stealth);
        merchent.add(dodge);
        merchent.add(gold);
        merchent.add(gold1);
        merchent.add(gold2);
        merchent.add(close);
        merchent.setSize(375, 355);
        merchent.setLocationRelativeTo(null);
        merchent.add(panel, BorderLayout.CENTER);
        merchent.setVisible(true);
        
        
       
        
        
        choose1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(User.gold>=15){
                for(int i=0;i<User.items.size();i++){
                    if(User.items.get(i).type.equals("Boots")){
                         bootsChanged=true;
                        JPanel panel = new JPanel();
                        JFrame replace = new JFrame();
                        JButton yes = new JButton("Yes");
                        JButton no = new JButton("No");
                        
                        JLabel label = new JLabel("You have boots,");
                        JLabel label1 = new JLabel("replace it?");
                        
                        
                        yes.setBounds(20, 50, 75, 45);
                        no.setBounds(95, 50, 75,45);
                        label.setBounds(25, 10, 104,25);
                        label1.setBounds(20, 20, 124,25);
                        
                        replace.setUndecorated(true);
        
                        replace.add(yes);
                        replace.add(no);
                        replace.add(label);
                        replace.add(label1);
                        replace.setSize(200, 100);
                        replace.setLocationRelativeTo(null);
                        replace.add(panel, BorderLayout.CENTER);
                        replace.setVisible(true);
                        
                        
                        yes.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                           Items rareBoots = new Items(2,"Boots", "rare");
                           for(int i=0;i<User.items.size();i++){
                               if(User.items.get(i).type.equals("Boots")){
                                   User.dodge=User.dodge - User.items.get(i).dodge;
                                   User.items.remove(i);
                                   
                               }
                           }
                          
                           User.items.add(rareBoots);
                           User.dodge=User.dodge+rareBoots.dodge;
                           replace.dispose();
                           merchent.dispose();
                           jButton3.setEnabled(true);
                           User.gold=User.gold-15;
                           repaint();
                        }
                        });
                        
                         
                        no.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            replace.dispose();
                        }
                        });
                        
                    }
                    else{
                           
                    }
                }
                 
                        if(bootsChanged==false){
                           Items rareBoots = new Items(2,"Boots", "rare");
                           User.items.add(rareBoots);
                           User.dodge=User.dodge+rareBoots.dodge;
                           merchent.dispose();
                           jButton3.setEnabled(true);
                           bootsChanged=true;
                           User.gold=User.gold-15;
                           repaint();
                        }
                
            }else{
                    JOptionPane.showMessageDialog(null, "Not enough gold");
                }
           }
        });
        
        
        
        choose2.addActionListener(new ActionListener() {
          
            @Override
            public void actionPerformed(ActionEvent e) {
                if(User.gold>=15){
                 for(int i=0;i<User.items.size();i++){
                    if(User.items.get(i).type.equals("Sword")){
                        swordChanged=true;
                        JPanel panel = new JPanel();
                        JFrame replace = new JFrame();
                        JButton yes = new JButton("Yes");
                        JButton no = new JButton("No");
                        
                        JLabel label = new JLabel("You have sword,");
                        JLabel label1 = new JLabel("replace it?");
                        
                        
                        yes.setBounds(20, 50, 75, 45);
                        no.setBounds(95, 50, 75,45);
                        label.setBounds(25, 10, 104,25);
                        label1.setBounds(20, 20, 124,25);
                        
                        replace.setUndecorated(true);
        
                        replace.add(yes);
                        replace.add(no);
                        replace.add(label);
                        replace.add(label1);
                        replace.setSize(200, 100);
                        replace.setLocationRelativeTo(null);
                        replace.add(panel, BorderLayout.CENTER);
                        replace.setVisible(true);
                        
                        
                        yes.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                           Items rareSword = new Items("Sword", "rare",2);
                           for(int i=0;i<User.items.size();i++){
                               if(User.items.get(i).type.equals("Sword")){
                                   User.roll=User.roll - User.items.get(i).roll;
                                   User.items.remove(i);
                                   
                               }
                           }
                           
                           User.items.add(rareSword);
                           User.roll=User.roll+rareSword.roll;
                           replace.dispose();
                           merchent.dispose();
                           jButton3.setEnabled(true);
                           User.gold=User.gold-15;
                           repaint();
                        }
                        });
                        
                         
                        no.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            replace.dispose();
                        }
                        });
                        
                    }
                    else{
                        
                    }
                    
                    
                }
                 
                        if(swordChanged==false){
                           Items rareSword = new Items("Sword", "rare",2);
                           User.items.add(rareSword);
                           User.roll=User.roll+rareSword.roll;
                           User.gold=User.gold-15;
                           jButton3.setEnabled(true);
                           swordChanged=true;
                           merchent.dispose();
                           repaint();
                        }
                }else{
                    JOptionPane.showMessageDialog(null, "Not enough gold");
                }
           }
        });
        
        
        choose3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(User.gold>=15){
                for(int i=0;i<User.items.size();i++){
                    if(User.items.get(i).type.equals("Cloak")){
                        cloakChanged=true;
                        JPanel panel = new JPanel();
                        JFrame replace = new JFrame();
                        JButton yes = new JButton("Yes");
                        JButton no = new JButton("No");
                        
                        JLabel label = new JLabel("You have cloak,");
                        JLabel label1 = new JLabel("replace it?");
                        
                        
                        yes.setBounds(20, 50, 75, 45);
                        no.setBounds(95, 50, 75,45);
                        label.setBounds(25, 10, 104,25);
                        label1.setBounds(20, 20, 124,25);
                        
                        replace.setUndecorated(true);
        
                        replace.add(yes);
                        replace.add(no);
                        replace.add(label);
                        replace.add(label1);
                        replace.setSize(200, 100);
                        replace.setLocationRelativeTo(null);
                        replace.add(panel, BorderLayout.CENTER);
                        replace.setVisible(true);
                        
                        
                        yes.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                           Items rareCloak = new Items("Cloak",2,"rare");
                           for(int i=0;i<User.items.size();i++){
                               if(User.items.get(i).type.equals("Cloak")){
                                   User.stealth=User.stealth - User.items.get(i).stealth;
                                   User.items.remove(i);
                                   
                               }
                           }
                           
                           User.items.add(rareCloak);
                           User.stealth=User.stealth+rareCloak.stealth;
                           replace.dispose();
                           merchent.dispose();
                           jButton3.setEnabled(true);
                           User.gold=User.gold-15;
                           repaint();
                        }
                        });
                        
                         
                        no.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            replace.dispose();
                        }
                        });
                        
                    }
                    else{
                           
                    }
                }
                 
                        if(cloakChanged==false){
                           Items rareCloak = new Items("Cloak",2, "rare");
                           User.items.add(rareCloak);
                           User.stealth=User.stealth+rareCloak.stealth;
                           merchent.dispose();
                           jButton3.setEnabled(true);
                           cloakChanged=true;
                           User.gold=User.gold-15;
                           repaint();
                        }
                }else{
                    JOptionPane.showMessageDialog(null, "Not enough gold");
                }    
            }
        });
        
        
       close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                merchent.dispose();
            }
        });
        
    
        
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
                    
        if(townHallVisited==true){
                    Desert desert = new Desert();
                    desert.setVisible(true);
                    desert.pack();
                    desert.setLocationRelativeTo(null);
                    desert.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    desert.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    //desert.setSize(1950,1050);
                    User.position=47;
                    
                   dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Visit the Town Hall before you leave");
        }
        
                   
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
       
        
        if(townHallVisited==false){
            JOptionPane.showMessageDialog(null, "An evil mage has cast a spell on the lands. Reach his castle and defeat him to lift the curse!");
            JOptionPane.showMessageDialog(null, "You can leave the town now");
            townHallVisited=true;
        }else{
             JOptionPane.showMessageDialog(null, "You can leave the town now");
        }
        
        
    }//GEN-LAST:event_jButton12ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Town.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Town.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Town.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Town.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Town().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
