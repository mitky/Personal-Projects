/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalyearproject;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.net.URL;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import jdk.javadoc.internal.tool.Main;
//import sun.applet.Main;


/**
 *
 * @author mmiit
 */
public class Desert extends javax.swing.JFrame {

     public boolean position47Hit = false;
     public boolean position48Hit = false;
     public boolean position49Hit = false;
     public boolean position50Hit = false;
     public boolean position51Hit = false;
     public boolean position52Hit = false;
     public boolean position53Hit = false;
     public boolean position54Hit = false;
     public boolean position55Hit = false;
     public boolean position56Hit = false;
     public boolean position57Hit = false;
     public boolean position58Hit = false;
     public boolean position59Hit = false;
     public boolean position60Hit = false;
     public boolean position61Hit = false;
     public boolean position62Hit = false;
     public boolean position63Hit = false;
     public boolean position64Hit = false;
     public boolean position65Hit = false;
     public boolean position66Hit = false;
     public boolean position67Hit = false;
     public boolean position68Hit = false;
    
    public int dice6 = 0;
    private float alpha = 0.5f;
    
    
    public  void paint(Graphics g){
    
         URL url = Main.class.getResource("/desert.jpg");
         URL url1 = Main.class.getResource("/bottomPanel.png");//bottom panel image
         URL url2 = Main.class.getResource("/newBlock3.png");
         URL url4 = Main.class.getResource("/player.png");
          
         //Swords images
         URL commonSwordUrl = Main.class.getResource("/commonSword.png");
         URL rareSwordUrl = Main.class.getResource("/rareSword.png");
         URL epicSwordUrl = Main.class.getResource("/epicSword.png");
         
         URL rareCloakUrl = Main.class.getResource("/rareCloak.png");
         URL rareBootsUrl = Main.class.getResource("/rareBoots.png");
         URL commonCloakUrl = Main.class.getResource("/commonCloak.png");
         URL commonBootsUrl = Main.class.getResource("/commonBoots.png");
         
         ImageIcon commonSword = new ImageIcon(commonSwordUrl);
         ImageIcon rareSword = new ImageIcon(rareSwordUrl);
         ImageIcon epicSword = new ImageIcon(epicSwordUrl);
         
         ImageIcon commonCloak = new ImageIcon(commonCloakUrl);
         ImageIcon commonBoots = new ImageIcon(commonBootsUrl);
      
         ImageIcon rareCloak = new ImageIcon(rareCloakUrl);
         ImageIcon rareBoots = new ImageIcon(rareBootsUrl);
         
         Image image = new ImageIcon(url).getImage(); //background
         Image image1 = new ImageIcon(url1).getImage(); //bottomPanel
         Image block = new ImageIcon(url2).getImage();
         Image player_piece = new ImageIcon(url4).getImage(); //player moving piece
         
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
          
          String gold = String.valueOf(User.gold);
          
          g.drawString("Gold:", 1685, 870);
          g.drawString(gold, 1720, 930);
          
          //draww steping blocks
          
          g.drawImage(block,50,450,75, 75, null);
          g.setFont(new Font("TimesRoman", Font.PLAIN,40));
          g.setColor(Color.red);
          g.drawString("47", 80, 570);
          
          g.drawImage(block,140,400,75, 75, null);
          g.drawString("48", 165, 510);
          
          g.drawImage(block,230,350,75, 75, null);
          g.drawString("49", 255, 460);
          
          g.drawImage(block,315,300,75, 75, null);
          g.drawString("50", 345, 410);
          
          g.drawImage(block,400,250,75, 75, null);
          g.drawString("51", 430, 360);
          
          g.drawImage(block,485,250,75, 75, null);
          g.drawString("52", 510, 360);
          
          g.drawImage(block,565,300,75, 75, null);
          g.drawString("53", 590, 410);
          
          g.drawImage(block,645,370,75, 75, null);
          g.drawString("54", 675, 480);
          
          g.drawImage(block,725,430,75, 75, null);
          g.drawString("55", 750, 540);
          
          g.drawImage(block,805,490,75, 75, null);
          g.drawString("56", 820, 600);
          
          g.drawImage(block,885,550,75, 75, null);
          g.drawString("57", 905, 660);
          
          g.drawImage(block,965,610,75, 75, null);
          g.drawString("58", 980, 720);
          
          g.drawImage(block,1045,550,75, 75, null);
          g.drawString("59", 1060, 660);
          
          g.drawImage(block,1125,490,75, 75, null);
          g.drawString("60", 1140, 600);
          
          g.drawImage(block,1205,430,75, 75, null);
          g.drawString("61", 1220, 540);
          
          g.drawImage(block,1285,370,75, 75, null);
          g.drawString("62", 1300, 480);
          
          g.drawImage(block,1365,300,75, 75, null);
          g.drawString("63", 1380, 410);
          
          g.drawImage(block,1445,250,75, 75, null);
          g.drawString("64", 1460, 360);
          
          g.drawImage(block,1530,200,75, 75, null);
          g.drawString("65", 1545, 310);
          
          g.drawImage(block,1615,250,75, 75, null);
          g.drawString("66", 1630, 360);
          
          g.drawImage(block,1700,300,75, 75, null);
          g.drawString("67", 1720, 410);
          
          g.drawImage(block,1785,370,75, 75, null);
          g.drawString("68", 1805, 480);
          
          g.drawImage(block,1855,460,75, 75, null);
          g.drawString("69", 1875, 570);
          
          
           if(User.position==47){
             g.drawImage(player_piece,53,408,70, 70, null); //position 47
          }
          else if(User.position==48){
             g.drawImage(player_piece,143,358,70, 70, null);//position 48
          }
          else if(User.position==49){
             g.drawImage(player_piece,233,308,70, 70, null);//position 49
          }
          else if(User.position==50){
             g.drawImage(player_piece,318,258,70, 70, null);//position 50
          }
          else if(User.position==51){
             g.drawImage(player_piece,403,208,70, 70, null);//position 51
          }
          else if(User.position==52){
             g.drawImage(player_piece,488,208,70, 70, null);//position 52
          }
          else if(User.position==53){
             g.drawImage(player_piece,568,258,70, 70, null);//position 53
          }
          else if(User.position==54){
             g.drawImage(player_piece,648,328,70, 70, null);//position 54
         }
          else if(User.position==55){
             g.drawImage(player_piece,728,388,70, 70, null);//position 55
        }
          else if(User.position==56){
             g.drawImage(player_piece,808,448,70, 70, null);//position 56
       }
          else if(User.position==57){
              g.drawImage(player_piece,888,508,70, 70, null);//position 57
        }
          else if(User.position==58){
              g.drawImage(player_piece,968,568,70, 70, null);//position 58
         }
          else if(User.position==59){
              g.drawImage(player_piece,1048,508,70, 70, null);//position 59
          }
          else if(User.position==60){
              g.drawImage(player_piece,1128,448,70, 70, null);//position 60
          }
          else if(User.position==61){
              g.drawImage(player_piece,1208,388,70, 70, null);//position 61
          }
          else if(User.position==62){
              g.drawImage(player_piece,1288,328,70, 70, null);//position 62
          }
          else if(User.position==63){
              g.drawImage(player_piece,1368,258,70, 70, null);//position 63
          }
          else if(User.position==64){
              g.drawImage(player_piece,1448,208,70, 70, null);//position 64
          }
          else if(User.position==65){
              g.drawImage(player_piece,1533,158,70, 70, null);//position 65
          }
          else if(User.position==66){
              g.drawImage(player_piece,1618,208,70, 70, null);//position 66
          }
          else if(User.position==67){
              g.drawImage(player_piece,1703,258,70, 70, null);//position 67
          }
          else if(User.position==68){
              g.drawImage(player_piece,1788,328,70, 70, null);//position 68
          }
          else if(User.position==69){
              g.drawImage(player_piece,1858,418,70, 70, null);//position 69
          }
           
           
          g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,alpha));
          
          g.drawImage(image1,0,770,2500, 270, null);
    
    }
    
    public Desert() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(332, Short.MAX_VALUE)
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
        Random rand = new Random();

        int min =1;
        int max = 6;
        int random_roll = (int) (Math.random() * (max - min + 1) + min);

        this.dice6 = random_roll;
        User.position = User.position+random_roll;

      if(User.position>=69){
                    castle castle = new castle();
                    castle.setVisible(true);
                    castle.pack();
                    castle.setLocationRelativeTo(null);
                    castle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    castle.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    //town.setSize(1950,1050);
                    User.position=70;
                    dispose();
                    JOptionPane.showMessageDialog(this, "You reached the Evil mage castle. Find him and kill him!");
        }

        repaint();
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
            java.util.logging.Logger.getLogger(Desert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Desert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Desert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Desert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Desert().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
