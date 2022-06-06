/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalyearproject;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.blue;
import static java.awt.Color.green;
import static java.awt.Color.red;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.Random;
//import static javafx.scene.paint.Color.rgb;
//import static javafx.scene.paint.Color.rgb;
//import static javafx.scene.paint.Color.rgb;
//import static javafx.scene.paint.Color.rgb;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import jdk.javadoc.internal.tool.Main;

/**
 *
 * @author mmiit
 */
public class Prison extends javax.swing.JFrame {

    /**
     * Creates new form Prison
     */
    
     private float alpha = 0.5f;
     
     public boolean hpInfo = false;
     public boolean rollInfo = false;
     public boolean stealthIngo = false;
     public boolean dogdeInfo = false;
     public int dice6 = 0;
     public int dice20 = 0;
     
    
     public boolean chestFound=false;
     public boolean spearDodged=false;
     public boolean wingEscaped=false;
     
     
     public boolean position1Hit = false;
     public boolean position2Hit = false;
     public boolean position3Hit = false;
     public boolean position4Hit = false;
     public boolean position5Hit = false;
     public boolean position6Hit = false;
     public boolean position7Hit = false;
     public boolean position8Hit = false;
     public boolean position9Hit = false;
     public boolean position10Hit = false;
     public boolean position11Hit = false;
     public boolean position12Hit = false;
     public boolean position13Hit = false;
     public boolean position14Hit = false;
     public boolean position15Hit = false;
     public boolean position16Hit = false;
     public boolean position17Hit = false;
     public boolean position18Hit = false;
     public boolean position19Hit = false;
     public boolean position20Hit = false;
     public boolean position21Hit = false;
     public boolean position22Hit = false;
     public boolean position23Hit = false;
     
     String itemType;//for checking if the user have this item awredy
     String itemType1;
     String itemType2;
     
     Items ItemAddedToInventory = new Items();
     Items ItemAddedToInventory1 = new Items();
     Items ItemAddedToInventory2 = new Items();
     
     public boolean elfFound = false;
    
    private Image img;
    private Image img1;
    
    
    //BufferedImage buffered = (BufferedImage) img1;
    
     public  void loadpics(){
         
     }
    
     public  void paint(Graphics g){
         
         
         //background image
         URL url = Main.class.getResource("/prison2.jpg");
         URL url1 = Main.class.getResource("/bottomPanel.png");//bottom panel image
         URL url2 = Main.class.getResource("/newBlock2.png");
         URL url4 = Main.class.getResource("/player.png");
          
         //Swords images
         URL commonSwordUrl = Main.class.getResource("/commonSword.png");
         URL rareSwordUrl = Main.class.getResource("/rareSword.png");
         URL epicSwordUrl = Main.class.getResource("/epicSword.png");
         
         URL commonCloakUrl = Main.class.getResource("/commonCloak.png");
         URL commonBootsUrl = Main.class.getResource("/commonBoots.png");
         
         ImageIcon commonSword = new ImageIcon(commonSwordUrl);
         ImageIcon rareSword = new ImageIcon(rareSwordUrl);
         ImageIcon epicSword = new ImageIcon(epicSwordUrl);
         
         ImageIcon commonCloak = new ImageIcon(commonCloakUrl);
         ImageIcon commonBoots = new ImageIcon(commonBootsUrl);
      
         
         Image image = new ImageIcon(url).getImage(); //background
         Image image1 = new ImageIcon(url1).getImage(); //bottomPanel
         Image block = new ImageIcon(url2).getImage();
         Image player_piece = new ImageIcon(url4).getImage(); //player moving piece
        
       
         
         
        
            
         //draw he back ground
          Graphics2D g2 = (Graphics2D)g;
          
           Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int height = (int) screenSize.getHeight();
            int width = (int) screenSize.getWidth();
        
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
                 jButton5.setIcon(commonCloak);
             }
             if(User.items.get(i).getType().equals("Boots")){
                 jButton6.setIcon(commonBoots);
             }
          }
         
         
         
          
         //draw steping blocks
          
          g.drawImage(block,50,450,75, 75, null);
          g.setFont(new Font("TimesRoman", Font.PLAIN,40));
          g.setColor(Color.red);
          g.drawString("1", 80, 570);
          
          g.drawImage(block,140,400,75, 75, null);
          g.drawString("2", 165, 510);
          
          g.drawImage(block,230,350,75, 75, null);
          g.drawString("3", 255, 460);
          
          g.drawImage(block,315,300,75, 75, null);
          g.drawString("4", 345, 410);
          
          g.drawImage(block,400,250,75, 75, null);
          g.drawString("5", 430, 360);
          
          g.drawImage(block,485,250,75, 75, null);
          g.drawString("6", 510, 360);
          
          g.drawImage(block,565,300,75, 75, null);
          g.drawString("7", 590, 410);
          
          g.drawImage(block,645,370,75, 75, null);
          g.drawString("8", 675, 480);
          
          g.drawImage(block,725,430,75, 75, null);
          g.drawString("9", 750, 540);
          
          g.drawImage(block,805,490,75, 75, null);
          g.drawString("10", 820, 600);
          
          g.drawImage(block,885,550,75, 75, null);
          g.drawString("11", 905, 660);
          
          g.drawImage(block,965,610,75, 75, null);
          g.drawString("12", 980, 720);
          
          g.drawImage(block,1045,550,75, 75, null);
          g.drawString("13", 1060, 660);
          
          g.drawImage(block,1125,490,75, 75, null);
          g.drawString("14", 1140, 600);
          
          g.drawImage(block,1205,430,75, 75, null);
          g.drawString("15", 1220, 540);
          
          g.drawImage(block,1285,370,75, 75, null);
          g.drawString("16", 1300, 480);
          
          g.drawImage(block,1365,300,75, 75, null);
          g.drawString("17", 1380, 410);
          
          g.drawImage(block,1445,250,75, 75, null);
          g.drawString("18", 1460, 360);
          
          g.drawImage(block,1530,200,75, 75, null);
          g.drawString("19", 1545, 310);
          
          g.drawImage(block,1615,250,75, 75, null);
          g.drawString("20", 1630, 360);
          
          g.drawImage(block,1700,300,75, 75, null);
          g.drawString("21", 1720, 410);
          
          g.drawImage(block,1785,370,75, 75, null);
          g.drawString("22", 1805, 480);
          
          g.drawImage(block,1855,460,75, 75, null);
          g.drawString("23", 1875, 570);
          
          //draw name and stats on bottom panel next to character
          
          String name = User.name;
          String hp = String.valueOf(User.hp);
          String roll = String.valueOf(User.roll);
          String stealth = String.valueOf(User.stealth);
          String dogde = String.valueOf(User.dodge);
          String dice = String.valueOf(this.dice6);
         
          //draw dice roll value
          
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
          
           //draw gold bar
          
          String gold = String.valueOf(User.gold);
          
          g.drawString("Gold:", 1685, 870);
          g.drawString(gold, 1720, 930);
          
          //draw player position on the screen
          
          if(User.position==1){
               g.drawImage(player_piece,53,408,70, 70, null); //position 1
               
          }
          else if(User.position==2){
              if(position2Hit==false){
                   g.drawImage(player_piece,143,358,70, 70, null);//position 2
                   position2Hit=true;
               position2();
               
              }else{
                  g.drawImage(player_piece,143,358,70, 70, null);//position 2
              }
              
              
          }
          else if(User.position==3){
              if(position3Hit==false){
                   g.drawImage(player_piece,233,308,70, 70, null);//position 3
                   position3Hit=true;
                    position3();
              }else{
                  g.drawImage(player_piece,233,308,70, 70, null);//position 3
              }
             
          }
          else if(User.position==4){
              if(position4Hit==false){
                  g.drawImage(player_piece,318,258,70, 70, null);//position 4
                  position4Hit=true;
                    position4();
                }else{
                  g.drawImage(player_piece,318,258,70, 70, null);//position 4
              }
               
          }
          else if(User.position==5){
              if(position5Hit==false){
                   g.drawImage(player_piece,403,208,70, 70, null);//position 5
                   position5Hit=true;
                    position5();
              }else{
                  g.drawImage(player_piece,403,208,70, 70, null);//position 5
              }
             
          }
          else if(User.position==6){
              if(position6Hit==false){
                  g.drawImage(player_piece,488,208,70, 70, null);//position 6
                   position6Hit=true;
                   position6();
               }else{
                  g.drawImage(player_piece,488,208,70, 70, null);//position 6
              }
              
          }
          else if(User.position==7){
              if(position7Hit==false){
                  g.drawImage(player_piece,568,258,70, 70, null);//position 7
              position7Hit=true;
              position7();
              }else{
                   g.drawImage(player_piece,568,258,70, 70, null);//position 7
              }
          }
          else if(User.position==8){
              if(position8Hit==false){
                  g.drawImage(player_piece,648,328,70, 70, null);//position 8
                  position8Hit=true;
                  position8();
              }else{
                  g.drawImage(player_piece,648,328,70, 70, null);//position 8
              }
              
          }
          else if(User.position==9){
              if(position9Hit==false){
                   g.drawImage(player_piece,728,388,70, 70, null);//position 9
                   position9Hit=true;
                   position9();
              }else{
                  g.drawImage(player_piece,728,388,70, 70, null);//position 9
              }
             
          }
          else if(User.position==10){
              if(position10Hit==false){
                  g.drawImage(player_piece,808,448,70, 70, null);//position 10
                  position10Hit=true;
                  position10();
              }else{
                  g.drawImage(player_piece,808,448,70, 70, null);//position 10
              }
             
          }
          else if(User.position==11){
              if(position11Hit==false){
                  g.drawImage(player_piece,888,508,70, 70, null);//position 11
                  position11Hit=true;
                  position11();
              }else{
                 g.drawImage(player_piece,888,508,70, 70, null);//position 11 
              }
              
          }
          else if(User.position==12){
              if(position12Hit==false){
                  g.drawImage(player_piece,968,568,70, 70, null);//position 12
                  position12Hit=true;
                  position12();
              }else{
                  g.drawImage(player_piece,968,568,70, 70, null);//position 12
              }
              
          }
          else if(User.position==13){
              if(position13Hit==false){
                  g.drawImage(player_piece,1048,508,70, 70, null);//position 13
                  position13Hit=true;
                  position13();
              }else{
                  g.drawImage(player_piece,1048,508,70, 70, null);//position 13
              }
              
          }
          else if(User.position==14){
              if(position14Hit==false){
                   g.drawImage(player_piece,1128,448,70, 70, null);//position 14
                  position14Hit=true;
                  position14();
              }else{
                  g.drawImage(player_piece,1128,448,70, 70, null);//position 14
              }
             
          }
          else if(User.position==15){
              if(position15Hit==false){
                    g.drawImage(player_piece,1208,388,70, 70, null);//position 15
                  position15Hit=true;
                  position15();
              }else{
                  g.drawImage(player_piece,1208,388,70, 70, null);//position 15
              }
              
             
          }
          else if(User.position==16){
              if(position16Hit==false){
                    g.drawImage(player_piece,1288,328,70, 70, null);//position 16
                  position16Hit=true;
                  position16();
              }else{
                  g.drawImage(player_piece,1288,328,70, 70, null);//position 16
              }
              
             
          }
          else if(User.position==17){
              if(position17Hit==false){
                    g.drawImage(player_piece,1368,258,70, 70, null);//position 17
                  position17Hit=true;
                  position17();
              }else{
                  g.drawImage(player_piece,1368,258,70, 70, null);//position 17
              }
              
              
          }
          else if(User.position==18){
              if(position18Hit==false){
                  g.drawImage(player_piece,1448,208,70, 70, null);//position 18
                  position18Hit=true;
                  position18();
              }else{
                   g.drawImage(player_piece,1448,208,70, 70, null);//position 18
              }
              
             
          }
          else if(User.position==19){
              if(position19Hit==false){
                  g.drawImage(player_piece,1533,158,70, 70, null);//position 19
                  position19Hit=true;
                  position19();
              }else{
                   g.drawImage(player_piece,1533,158,70, 70, null);//position 19
              }
              
              
          }
          else if(User.position==20){
              if(position20Hit==false){
                   g.drawImage(player_piece,1618,208,70, 70, null);//position 20
                  position20Hit=true;
                  position20();
              }else{
                   g.drawImage(player_piece,1618,208,70, 70, null);//position 20
              }
              
             
          }
          else if(User.position==21){
              if(position21Hit==false){
                    g.drawImage(player_piece,1703,258,70, 70, null);//position 21
                  position21Hit=true;
                  position21();
              }else{
                    g.drawImage(player_piece,1703,258,70, 70, null);//position 21
              }
              
             
          }
          else if(User.position==22){
              if(position22Hit==false){
                    g.drawImage(player_piece,1788,328,70, 70, null);//position 22
                  position22Hit=true;
                  position22();
              }else{
                   g.drawImage(player_piece,1788,328,70, 70, null);//position 22
              }
              
             
          }
          else if(User.position==23){
               if(position23Hit==false){
                    g.drawImage(player_piece,1858,418,70, 70, null);//position 23
                  position23Hit=true;
                  
              }else{
                   g.drawImage(player_piece,1858,418,70, 70, null);//position 23
              }
              
             
          }
          
         
          
           //draw bottom tool bar
           
           
          g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,alpha));
          
          g.drawImage(image1,0,770,2500, 270, null);
          
          
        
          
    
         
     }
    
    
    public Prison() {
        
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(311, 311, 311)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(286, Short.MAX_VALUE)
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

    private void jLabel2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseMoved
     
    }//GEN-LAST:event_jLabel2MouseMoved

    private void jLabel3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseMoved
       
    }//GEN-LAST:event_jLabel3MouseMoved

    private void jLabel4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseMoved
       
    }//GEN-LAST:event_jLabel4MouseMoved

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
       
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
       
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
      
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
       
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        JOptionPane.showMessageDialog(this, "Healt points");
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
          JOptionPane.showMessageDialog(this, "Adds the strenght number to the number you rolled on the dice when in fight event");
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
         JOptionPane.showMessageDialog(this, "Adds the stelath number to the number you rolled on the dice when rolling for stealth action");
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        JOptionPane.showMessageDialog(this, "Adds the dogde number to the number you rolled on the dice when rolling for dogde action");
       
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        
        if(User.characterClass=="warrior"){
            JOptionPane.showMessageDialog(this, "A powerfull attack that gives you +3 to Strenght");
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
        
        if(User.position>=23){
                    jButton3.setEnabled(false);
                    prisonGuard();
                   
                  
                    
             
        }
        
        repaint();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * @param args the command line arguments
     */
    
    
    
    
    public void position2(){
        
        if(User.keyFound==false){
            keyFound();
            jButton3.setEnabled(false);
        }
        
    }
    
    public void position3(){
       if(User.keyFound==false){
            keyFound();
            jButton3.setEnabled(false);
        }else{
           eventAtPosition3();
       }
    }
    
    public void position4(){
        if(User.keyFound==false){
            keyFound();
            jButton3.setEnabled(false);
        }
        else{
            eventAtPosition4();
        }
    }
    
    public void position5(){
        if(User.keyFound==false){
            keyFound();
            jButton3.setEnabled(false);
        }else{
            eventAtPosition5();
        }
    }
    
    public void position6(){
        if(User.keyFound==false){
            keyFound();
            jButton3.setEnabled(false);
        }else{
            eventAtPosition6();
            repaint();
        }
    }
     public void position7(){
        if(User.keyFound==false){
            keyFound();
            jButton3.setEnabled(false);
        }else{
            eventAtPosition7();
        }
    }
     
     public void position8(){
         if(chestFound==false){
             chestFound();
             jButton3.setEnabled(false);
              chestFound=true;
         }
     }
     public void position9(){
         if(chestFound==false){
             chestFound();
             jButton3.setEnabled(false);
              chestFound=true;
         }else{
             eventAtPosition9();
         }
     }
     public void position10(){
         if(chestFound==false){
             chestFound();
             jButton3.setEnabled(false);
              chestFound=true;
         }else{
             eventAtPosition10();
         }
     }
     public void position11(){
         if(chestFound==false){
             chestFound();
             jButton3.setEnabled(false);
         }else{
             eventAtPosition11();
         }
     }
     public void position12(){
         if(chestFound==false){
             chestFound();
             jButton3.setEnabled(false);
              chestFound=true;
         }else{
             eventAtPosition12();
         }
     }
     public void position13(){
         if(chestFound==false){
             chestFound();
             jButton3.setEnabled(false);
             chestFound=true;
         }else{
             eventAtPosition13();
         }
         
     }
     
      public void position14(){
       if(spearDodged==false){
           spearDodged();
           jButton3.setEnabled(false);
           spearDodged=true;
       }
     }
      public void position15(){
       if(spearDodged==false){
           spearDodged();
           jButton3.setEnabled(false);
           spearDodged=true;
       }else{
           eventAtPosition15();
       }
     }
      public void position16(){
       if(spearDodged==false){
           spearDodged();
           jButton3.setEnabled(false);
           spearDodged=true;
       }else{
           eventAtPosition16();
       }
     }
      public void position17(){
       if(elfFound==false){
           seveElf();
           jButton3.setEnabled(false);
           elfFound=true;
       }
     }
      public void position18(){
       if(elfFound==false){
           seveElf();
           jButton3.setEnabled(false);
            elfFound=true;
       }else{
           eventAtPosition18();
       }
     }
      public void position19(){
       if(elfFound==false){
           seveElf();
           jButton3.setEnabled(false);
            elfFound=true;
       }else{
           eventAtPosition19();
       }
     }
      public void position20(){
       if(elfFound==false){
           seveElf();
           jButton3.setEnabled(false);
            elfFound=true;
       }
       else{
           eventAtPosition20();
       }
     }
      public void position21(){
       if(elfFound==false){
           seveElf();
           jButton3.setEnabled(false);
            elfFound=true;
       }else{
           eventAtPosition21();
       }
     }
      public void position22(){
       if(elfFound==false){
           seveElf();
           jButton3.setEnabled(false);
            elfFound=true;
       }else{
           eventAtPosition22();
       }
     }
      
    
    public void keyFound(){
        JPanel panel = new JPanel();
        JFrame keyFound = new JFrame();
        JButton ok = new JButton("OK");
        JButton keyButton = new JButton();
        JLabel label = new JLabel("You found a keyKey");
       
        
        URL keyUrl = Main.class.getResource("/key.png");
        ImageIcon key = new ImageIcon(keyUrl);
        
        panel.setSize(400, 400);
         ok.setBounds(220, 430, 75, 45);
         keyButton.setBounds(85, 70, 345,345);
         //label.setFont(new Font("TimesRoman", Font.PLAIN, 15));
         label.setBounds(140, 20, 104,25);
        
         keyButton.setIcon(key);
         
       
        keyFound.setUndecorated(true);
        
        keyFound.add(ok);
        keyFound.add(keyButton);
        keyFound.add(label);
       
        keyFound.setSize(500, 500);
        keyFound.setLocationRelativeTo(null);
        keyFound.add(panel, BorderLayout.CENTER);
        keyFound.setVisible(true);
        
        
        
         ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               User.keyFound = true;
               jButton3.setEnabled(true);
               keyFound.dispose();
            }
        });
    }
    
    public void chestFound(){
        
        JOptionPane.showMessageDialog(null, "You entered the Guards locker room and fond a chest");
        JPanel panel = new JPanel();
        JFrame chestFound = new JFrame();
        JButton open = new JButton("Open");
        JButton chest = new JButton();
        JLabel label = new JLabel("You found");
        JLabel label1 = new JLabel("Chest");
        
        URL chestUrl = Main.class.getResource("/chest.png");
        ImageIcon chestIcon = new ImageIcon(chestUrl);
        
         panel.setSize(400, 400);
         open.setBounds(220, 430, 75, 45);
         chest.setBounds(85, 70, 345,345);
         //label.setFont(new Font("TimesRoman", Font.PLAIN, 15));
         label.setBounds(215, 10, 104,25);
         label1.setBounds(230, 30, 124,25);
         chest.setIcon(chestIcon);
         
       
        chestFound.setUndecorated(true);
        
        chestFound.add(open);
        chestFound.add(chest);
        chestFound.add(label);
        chestFound.add(label1);
        chestFound.setSize(500, 500);
        chestFound.setLocationRelativeTo(null);
        chestFound.add(panel, BorderLayout.CENTER);
        chestFound.setVisible(true);
        
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chestFound.dispose();
                threeOptions();
                JOptionPane.showMessageDialog(null, "You found items and gold in the chest (+ 15 gold)");
                repaint();
            }
        });
    }
    
    public void threeOptions(){
        JPanel panel = new JPanel();
        JFrame chestOpen = new JFrame();
        JButton choose1 = new JButton("Choose");
        JButton choose2 = new JButton("Choose");
        JButton choose3 = new JButton("Choose");
        JButton item1 = new JButton();
        JButton item2 = new JButton();
        JButton item3 = new JButton();
        User.gold = User.gold + 15;
        
        //JLabel label = new JLabel("common");
        //JLabel label2 = new JLabel("common");
       // JLabel label1 = new JLabel("rare");
        
       // JLabel common1 = new JLabel("+1 Roll");
        //JLabel rare = new JLabel("+2 Roll");
        
        
        URL commonSwordUrl = Main.class.getResource("/commonSword.png");
        ImageIcon commonSword = new ImageIcon(commonSwordUrl);
        
        URL commonCloakUrl = Main.class.getResource("/commonCloak.png");
        ImageIcon commonCloak = new ImageIcon(commonCloakUrl);
        
        URL commonBootsUrl = Main.class.getResource("/commonBoots.png");
        ImageIcon commonBoots = new ImageIcon(commonBootsUrl);
        
        
         //display items in chest
         
         //first item
         Random rand = new Random();
         
         int randomItem = rand.nextInt(3);
         
        if(Items.commonItems.get(randomItem).getType().equals("Sword")){
            item1.setIcon(commonSword);
            JLabel common = new JLabel("+1 Strenght");
            common.setBounds(45, 200, 100, 45);
            chestOpen.add(common);
             itemType=Items.commonItems.get(randomItem).getType();
             ItemAddedToInventory=Items.commonItems.get(randomItem);
        }
        else if(Items.commonItems.get(randomItem).getType().equals("Cloak")){
             item1.setIcon(commonCloak);
             JLabel common = new JLabel("+1 Stealth");
             common.setBounds(45, 200, 100, 45);
             chestOpen.add(common);
             itemType=Items.commonItems.get(randomItem).getType();
             ItemAddedToInventory=Items.commonItems.get(randomItem);
        }
        else if(Items.commonItems.get(randomItem).getType().equals("Boots")){
            item1.setIcon(commonBoots);
             JLabel common = new JLabel("+1 Dodge");
             common.setBounds(45, 200, 100, 45);
             chestOpen.add(common);
              itemType=Items.commonItems.get(randomItem).getType();
              ItemAddedToInventory=Items.commonItems.get(randomItem);
        }
        // third item
        Random rand2 = new Random();
         
         int randomItem2 = rand2.nextInt(3);
         
          if(Items.commonItems.get(randomItem2).getType().equals("Sword")){
            item3.setIcon(commonSword);
            JLabel common = new JLabel("+1 Strenght");
             common.setBounds(280, 200, 100, 45);
             chestOpen.add(common);
             itemType1=Items.commonItems.get(randomItem2).getType();
             ItemAddedToInventory1=Items.commonItems.get(randomItem2);
        }
        else if(Items.commonItems.get(randomItem2).getType().equals("Cloak")){
             item3.setIcon(commonCloak);
             JLabel common = new JLabel("+1 Stealth");
             common.setBounds(280, 200, 100, 45);
             chestOpen.add(common);
             itemType1=Items.commonItems.get(randomItem2).getType();
             ItemAddedToInventory1=Items.commonItems.get(randomItem2);
        }
        else if(Items.commonItems.get(randomItem2).getType().equals("Boots")){
            item3.setIcon(commonBoots);
             JLabel common = new JLabel("+1 Dodge");
             common.setBounds(280, 200, 100, 45);
             chestOpen.add(common);
             itemType1=Items.commonItems.get(randomItem2).getType();
             ItemAddedToInventory1=Items.commonItems.get(randomItem2);
        }
          
           // second item
        Random rand3 = new Random();
         
         int randomItem3 = rand3.nextInt(3);
         
          if(Items.commonItems.get(randomItem3).getType().equals("Sword")){
            item2.setIcon(commonSword);
            JLabel common = new JLabel("+1 Strenght");
             common.setBounds(175, 200, 100, 45);
             chestOpen.add(common);
             itemType2=Items.commonItems.get(randomItem3).getType();
             ItemAddedToInventory2=Items.commonItems.get(randomItem3);
        }
        else if(Items.commonItems.get(randomItem3).getType().equals("Cloak")){
             item2.setIcon(commonCloak);
             JLabel common = new JLabel("+1 Stealth");
             common.setBounds(175, 200, 100, 45);
             chestOpen.add(common);
             itemType2=Items.commonItems.get(randomItem3).getType();
             ItemAddedToInventory2=Items.commonItems.get(randomItem3);
        }
        else if(Items.commonItems.get(randomItem3).getType().equals("Boots")){
            item2.setIcon(commonBoots);
             JLabel common = new JLabel("+1 Dodge");
             common.setBounds(175, 200, 100, 45);
             chestOpen.add(common);
             itemType2=Items.commonItems.get(randomItem3).getType();
             ItemAddedToInventory2=Items.commonItems.get(randomItem3);
        }
         
         
         panel.setSize(450, 450);
         choose1.setBounds(15, 230, 100, 45);
         choose2.setBounds(140, 230, 100, 45);
         choose3.setBounds(260, 230, 100, 45);
         
         item1.setBounds(0, 70, 125, 125);
         item2.setBounds(125, 70, 125, 125);
         item3.setBounds(255, 70, 125, 125);
         
         
        
       // item2.setIcon(rareSword);
        //item3.setIcon(commonSword);
         
        // label2.setBounds(45, 30, 100, 45);
        // label1.setBounds(175, 30, 100, 45);
         //label.setBounds(280, 30, 100, 45);
         
         //common1.setBounds(280, 200, 100, 45);
         //rare.setBounds(175, 200, 100, 45);
        
         
       
        chestOpen.setUndecorated(true);
        
        chestOpen.add(choose1);
        chestOpen.add(choose2);
        chestOpen.add(choose3);
        chestOpen.add(item1);
        chestOpen.add(item2);
        chestOpen.add(item3);
        //chestOpen.add(label);
        //chestOpen.add(label1);
       
        //chestOpen.add(rare);
       // chestOpen.add(label2);
       // chestOpen.add(common1);
        chestOpen.setSize(375, 355);
        chestOpen.setLocationRelativeTo(null);
        chestOpen.add(panel, BorderLayout.CENTER);
        chestOpen.setVisible(true);
        
        
        choose1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
               
                for(int i=0;i<User.items.size();i++){
                        if(User.items.get(i).getType().equals(ItemAddedToInventory.getType())){
                            
                            JPanel panel = new JPanel();
                            JFrame replace = new JFrame();
                            JButton yes = new JButton("Yes");
                            JButton no = new JButton("No");
                        
                        if(ItemAddedToInventory.getType().equals("Sword")){
                             JLabel labelSword = new JLabel("You have sword,");
                             //JLabel label1 = new JLabel("replace it?");
                             labelSword.setBounds(25, 10, 104,25);
                             replace.add(labelSword);
                        }
                        else if(ItemAddedToInventory.getType().equals("Cloak")){
                             JLabel labelCloak = new JLabel("You have Cloak,");
                             labelCloak.setBounds(25, 10, 104,25);
                             replace.add(labelCloak);
                        }
                        else if(ItemAddedToInventory.getType().equals("Boots")){
                             JLabel labelBoots = new JLabel("You have Boots,");
                             labelBoots.setBounds(25, 10, 104,25);
                             replace.add(labelBoots);
                        }
                        
                        yes.setBounds(20, 50, 75, 45);
                        no.setBounds(95, 50, 75,45);
                        
                         replace.setUndecorated(true);
//        
                        replace.add(yes);
                        replace.add(no);
                       // replace.add(label);
                        //replace.add(label1);
                        replace.setSize(200, 100);
                        replace.setLocationRelativeTo(null);
                        replace.add(panel, BorderLayout.CENTER);
                        replace.setVisible(true);
                        
                        yes.addActionListener(new ActionListener(){
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    
                                     Items commonItem = ItemAddedToInventory;
                           for(int i=0;i<User.items.size();i++){
                               if(User.items.get(i).getType().equals(commonItem.getType())){
                                   User.roll=User.roll - commonItem.getRoll();
                                   User.stealth=User.stealth - commonItem.getStealth();
                                   User.dodge=User.dodge - commonItem.getDodge();
                                   User.items.remove(User.items.get(i));
                                   
                               }
                           }
                           User.items.add(commonItem);
                           User.roll=User.roll+commonItem.getRoll();
                           User.stealth=User.stealth+commonItem.getStealth();
                           User.dodge=User.dodge+commonItem.getDodge();
                           replace.dispose();
                           chestOpen.dispose();
                           jButton3.setEnabled(true);
                           chestFound=true;
                           repaint();
                                }
                            
                        });
                        
                        no.addActionListener(new ActionListener(){
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    replace.dispose();
                                }
                            });
                        
                        
                        }
                        else{
                         Items commonItem = ItemAddedToInventory;
                         User.items.add(commonItem);
                         User.roll=User.roll+commonItem.getRoll();
                         User.stealth=User.stealth+commonItem.getStealth();
                         User.dodge=User.dodge+commonItem.getDodge();
                                                 
                         i=3;
                         chestOpen.dispose();
                         jButton3.setEnabled(true);
                         chestFound=true;
                         repaint();
                        }
                            
                    }
                      Items commonItem = ItemAddedToInventory;
                         User.items.add(commonItem);
                         User.roll=User.roll+commonItem.getRoll();
                         User.stealth=User.stealth+commonItem.getStealth();
                         User.dodge=User.dodge+commonItem.getDodge();
                                                 
                         //i=3;
                         chestOpen.dispose();
                         jButton3.setEnabled(true);
                         chestFound=true;
                         repaint();   
                }
                
              });   
                
             
                
                
       
        
        
        choose2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 for(int i=0;i<User.items.size();i++){
                        if(User.items.get(i).getType().equals(ItemAddedToInventory2.getType())){
                            
                            JPanel panel = new JPanel();
                            JFrame replace = new JFrame();
                            JButton yes = new JButton("Yes");
                            JButton no = new JButton("No");
                        
                        if(ItemAddedToInventory2.getType().equals("Sword")){
                             JLabel labelSword = new JLabel("You have sword,");
                             //JLabel label1 = new JLabel("replace it?");
                             labelSword.setBounds(25, 10, 104,25);
                             replace.add(labelSword);
                        }
                        else if(ItemAddedToInventory2.getType().equals("Cloak")){
                             JLabel labelCloak = new JLabel("You have Cloak,");
                             labelCloak.setBounds(25, 10, 104,25);
                             replace.add(labelCloak);
                        }
                        else if(ItemAddedToInventory2.getType().equals("Boots")){
                             JLabel labelBoots = new JLabel("You have Boots,");
                             labelBoots.setBounds(25, 10, 104,25);
                             replace.add(labelBoots);
                        }
                        
                        yes.setBounds(20, 50, 75, 45);
                        no.setBounds(95, 50, 75,45);
                        
                         replace.setUndecorated(true);
//        
                        replace.add(yes);
                        replace.add(no);
                       // replace.add(label);
                        //replace.add(label1);
                        replace.setSize(200, 100);
                        replace.setLocationRelativeTo(null);
                        replace.add(panel, BorderLayout.CENTER);
                        replace.setVisible(true);
                        
                        yes.addActionListener(new ActionListener(){
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    
                                     Items commonItem = ItemAddedToInventory2;
                           for(int i=0;i<User.items.size();i++){
                               if(User.items.get(i).getType().equals(commonItem.getType())){
                                   User.roll=User.roll - commonItem.getRoll();
                                   User.stealth=User.stealth - commonItem.getStealth();
                                   User.dodge=User.dodge - commonItem.getDodge();
                                   User.items.remove(User.items.get(i));
                                   
                               }
                           }
                           User.items.add(commonItem);
                           User.roll=User.roll+commonItem.getRoll();
                           User.stealth=User.stealth+commonItem.getStealth();
                           User.dodge=User.dodge+commonItem.getDodge();
                           replace.dispose();
                           chestOpen.dispose();
                           jButton3.setEnabled(true);
                           chestFound=true;
                           repaint();
                                }
                            
                        });
                        
                        no.addActionListener(new ActionListener(){
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    replace.dispose();
                                }
                            });
                        
                        
                        }
                        else{
                         Items commonItem = ItemAddedToInventory2;
                         User.items.add(commonItem);
                         User.roll=User.roll+commonItem.getRoll();
                         User.stealth=User.stealth+commonItem.getStealth();
                         User.dodge=User.dodge+commonItem.getDodge();
                                                 
                         i=3;
                         chestOpen.dispose();
                         jButton3.setEnabled(true);
                         chestFound=true;
                         repaint();
                        }
                            
                    }
                         Items commonItem = ItemAddedToInventory2;
                         User.items.add(commonItem);
                         User.roll=User.roll+commonItem.getRoll();
                         User.stealth=User.stealth+commonItem.getStealth();
                         User.dodge=User.dodge+commonItem.getDodge();
                                                 
                         //i=3;
                         chestOpen.dispose();
                         jButton3.setEnabled(true);
                         chestFound=true;
                         repaint();   
            }
        });
        
        
        choose3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 for(int i=0;i<User.items.size();i++){
                        if(User.items.get(i).getType().equals(ItemAddedToInventory1.getType())){
                            
                            JPanel panel = new JPanel();
                            JFrame replace = new JFrame();
                            JButton yes = new JButton("Yes");
                            JButton no = new JButton("No");
                        
                        if(ItemAddedToInventory1.getType().equals("Sword")){
                             JLabel labelSword = new JLabel("You have sword,");
                             //JLabel label1 = new JLabel("replace it?");
                             labelSword.setBounds(25, 10, 104,25);
                             replace.add(labelSword);
                        }
                        else if(ItemAddedToInventory1.getType().equals("Cloak")){
                             JLabel labelCloak = new JLabel("You have Cloak,");
                             labelCloak.setBounds(25, 10, 104,25);
                             replace.add(labelCloak);
                        }
                        else if(ItemAddedToInventory1.getType().equals("Boots")){
                             JLabel labelBoots = new JLabel("You have Boots,");
                             labelBoots.setBounds(25, 10, 104,25);
                             replace.add(labelBoots);
                        }
                        
                        yes.setBounds(20, 50, 75, 45);
                        no.setBounds(95, 50, 75,45);
                        
                         replace.setUndecorated(true);
//        
                        replace.add(yes);
                        replace.add(no);
                       // replace.add(label);
                        //replace.add(label1);
                        replace.setSize(200, 100);
                        replace.setLocationRelativeTo(null);
                        replace.add(panel, BorderLayout.CENTER);
                        replace.setVisible(true);
                        
                        yes.addActionListener(new ActionListener(){
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    
                                     Items commonItem = ItemAddedToInventory1;
                           for(int i=0;i<User.items.size();i++){
                               if(User.items.get(i).getType().equals(commonItem.getType())){
                                   User.roll=User.roll - commonItem.getRoll();
                                   User.stealth=User.stealth - commonItem.getStealth();
                                   User.dodge=User.dodge - commonItem.getDodge();
                                   User.items.remove(User.items.get(i));
                                   
                               }
                           }
                           User.items.add(commonItem);
                           User.roll=User.roll+commonItem.getRoll();
                           User.stealth=User.stealth+commonItem.getStealth();
                           User.dodge=User.dodge+commonItem.getDodge();
                           replace.dispose();
                           chestOpen.dispose();
                           jButton3.setEnabled(true);
                           chestFound=true;
                           repaint();
                                }
                            
                        });
                        
                        no.addActionListener(new ActionListener(){
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    replace.dispose();
                                }
                            });
                        
                        }
                        else{
                         Items commonItem = ItemAddedToInventory1;
                         User.items.add(commonItem);
                         User.roll=User.roll+commonItem.getRoll();
                         User.stealth=User.stealth+commonItem.getStealth();
                         User.dodge=User.dodge+commonItem.getDodge();
                                                 
                         i=3;
                         chestOpen.dispose();
                         jButton3.setEnabled(true);
                         chestFound=true;
                         repaint();
                        }
                            
                    }
                         Items commonItem = ItemAddedToInventory1;
                         User.items.add(commonItem);
                         User.roll=User.roll+commonItem.getRoll();
                         User.stealth=User.stealth+commonItem.getStealth();
                         User.dodge=User.dodge+commonItem.getDodge();
                                                 
                         //i=3;
                         chestOpen.dispose();
                         jButton3.setEnabled(true);
                         chestFound=true;
                         repaint(); 
            }
        });
        
    }
    
    
    public void prisonGuard(){
        
        User.position=23;
        repaint();
       
        
        JPanel panel = new JPanel();
        JFrame prisonGuard = new JFrame();
        JButton rollStealth = new JButton("Roll");
        JToggleButton userSkill = new JToggleButton("Skill");
       
        //JLabel label1 = new JLabel("Chest");
        
        
         
         panel.setSize(400, 400);
         rollStealth.setBounds(20, 140, 75, 45);
         userSkill.setBounds(110, 140, 75, 45);
         
         if(User.skillUsed==true){
             userSkill.setEnabled(false);
         }
        
       
        prisonGuard.setUndecorated(true);
        
        prisonGuard.add(rollStealth);
        prisonGuard.add(userSkill);
        prisonGuard.setSize(200, 200);
        prisonGuard.setLocationRelativeTo(null);
        prisonGuard.add(panel, BorderLayout.CENTER);
        prisonGuard.setVisible(true);
        
        JOptionPane.showMessageDialog(null, "You reached the prison exit, use stelth to sneak past the guard, Roll 5 Stealt or more leave the prison undeteckted!");
        
        rollStealth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Random rand = new Random();
        
                 int roll;
                 int mageSkill = 3;
                 int warriorSkill = 3;
                 int skill=0;
                 int actualSkill=0;
                 int StealthStats = User.stealth;
                 int RollStats = User.roll;
                 int total;
                
        
                    
                
                 int min =1;
                 int max = 20;
                 int random_roll = (int) (Math.random() * (max - min + 1) + min);
        
                 roll = random_roll;
                 
                    if(User.characterClass =="mage"){
                        skill = mageSkill;
                     }else if(User.characterClass =="warrior"){
                        skill = 0;
                     }
                 
                 if(userSkill.isSelected()){
                     actualSkill=skill;
                     User.skillUsed=true;
                    
                 }else{
                     actualSkill=0;
                 }
                  
                 
                 total = roll + StealthStats + actualSkill;
                 
               
                
                 if(total>=5){
                    JOptionPane.showMessageDialog(null, "You rolled " + roll +" from dice "+StealthStats + " from  stealth stats " +  " and " + actualSkill+ " from skill for totatl of " + total + " and escaped the prison");
                    Forest forest = new Forest();
                    forest.setVisible(true);
                    forest.pack();
                    forest.setLocationRelativeTo(null);
                    forest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    forest.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    //forest.setSize(1950,1050);
                    User.position=24;
                    JOptionPane.showMessageDialog(null, "Good you made it out! You are in the enchanted forest now. There is a vilige close by. Go trough the forest and reach the vilige.");
                    User.skillUsed = false;
                    prisonGuard.dispose();
                    dispose();
                    
                 }
                 
                 
                 else{
                  JOptionPane.showMessageDialog(null, "You rolled " + roll + " from dice " + StealthStats + " from stealth stats " + " and " + actualSkill+ " from skill for totatl of " + total + " and the guared cathed you. ");
                  JOptionPane.showMessageDialog(null, "You have no choice but to fight him now. Roll 5 or more to defeat the guard and escape the prison");
                  
                  
                 prisonGuard.dispose();
                  
                JPanel panel = new JPanel();
                JFrame fightGuard = new JFrame();
                JButton rollFight = new JButton("Roll");
                JToggleButton userSkill1 = new JToggleButton("Skill");
       
                //JLabel label1 = new JLabel("Chest");
        
      
         
                 panel.setSize(400, 400);
                 rollFight.setBounds(20, 140, 75, 45);
                 userSkill1.setBounds(110, 140, 75, 45);
         
         
                 if(User.skillUsed==true){
                        userSkill1.setEnabled(false);
                    }
       
                fightGuard.setUndecorated(true);
        
                fightGuard.add(rollFight);
                fightGuard.add(userSkill1);
                fightGuard.setSize(200, 200);
                fightGuard.setLocationRelativeTo(null);
                fightGuard.add(panel, BorderLayout.CENTER);
                fightGuard.setVisible(true);
                
                rollFight.addActionListener(new ActionListener() {
                      @Override
                      public void actionPerformed(ActionEvent e) {
                          
                           int roll1;
                           int mageSkill1 = 3;
                           int warriorSkill1 = 3;
                           int skill1=0;
                           int actualSkill1;
                          
                           int RollStats1 = User.roll;
                           int total1;
                
        
                    if(User.characterClass=="mage"){
                        skill1 = 0;
                     }else if(User.characterClass=="warrior"){
                        skill1 = warriorSkill1;
                     }
                
                 int min =1;
                 int max = 20;
                 int random_roll = (int) (Math.random() * (max - min + 1) + min);
        
                 roll1 = random_roll;
                 
                 if(userSkill.isSelected()){
                     actualSkill1=skill1;
                     User.skillUsed=true;
                    
                 }else{
                     actualSkill1=0;
                 }
                 
                 total1 = roll1 + RollStats1 + actualSkill1;
                 
                 if(total1>=5){
                 JOptionPane.showMessageDialog(null, "You rolled " + roll1 +" from dice "+ RollStats1 + " from Roll stats " +  " and " + actualSkill1+ " from skill for totatl of " + total1 + " and defieted the guard and exited the prizon");
                    Forest forest = new Forest();
                    forest.setVisible(true);
                    forest.pack();
                    forest.setLocationRelativeTo(null);
                    forest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    forest.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    //forest.setSize(1950,1050);
                    User.position=24;
                    JOptionPane.showMessageDialog(null, "Good you made it out! You are in the enchanted forest now. There is a vilige close by. Go trough the forest and reach the vilige.");
                    prisonGuard.dispose();
                    fightGuard.dispose();
                    User.skillUsed = false;
                    dispose();
                   
                 }else{
                     JOptionPane.showMessageDialog(null, "You rolled " + roll1 +" from dice "+ RollStats1 + " from Roll stats " +  " and " + actualSkill1+ " from skill for totatl of " + total1 + " and lost the fight and 1 life");
                    Forest forest = new Forest();
                    forest.setVisible(true);
                    forest.pack();
                    forest.setLocationRelativeTo(null);
                    forest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    forest.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    //forest.setSize(1950,1050);
                    User.position=24;
                    JOptionPane.showMessageDialog(null, "Good you made it out! You are in the enchanted forest now. There is a vilige close by. Go trough the forest and reach the vilige.");
                    User.hp = User.hp -1;
                    prisonGuard.dispose();
                    fightGuard.dispose();
                    User.skillUsed = false;
                    dispose();
                    
                    
                 }
                          
                      }
                  });
                
                  
               }
               
                 
            }
        });
        
        
        
        
    }
    
    
    public void seveElf(){
        
      
       
        JPanel panel = new JPanel();
        JFrame saveElf = new JFrame();
        JButton yes = new JButton("Yes");
        JButton no = new JButton("No");
       
        //JLabel label1 = new JLabel("Chest");
        
      
         
         panel.setSize(400, 400);
         yes.setBounds(20, 140, 75, 45);
         no.setBounds(110, 140, 75, 45);
         
         
        
       
        saveElf.setUndecorated(true);
        
        saveElf.add(yes);
        saveElf.add(no);
        saveElf.setSize(200, 200);
        saveElf.setLocationRelativeTo(null);
        saveElf.add(panel, BorderLayout.CENTER);
        saveElf.setVisible(true);
        JOptionPane.showMessageDialog(null, "You found an elf in chains.Do you want to use the key and free the elf!");
        
        yes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User.keyUsed=true;
                JOptionPane.showMessageDialog(null, "You helped the Elf and he will remember the kindnes!");
                saveElf.dispose();
                jButton3.setEnabled(true);
                repaint();
            }
        });
        no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "You decided to keep the key and look for a better use of it!");
                User.keyUsed=false;
                saveElf.dispose();
                jButton3.setEnabled(true);
                repaint();
            }
        });
        
    }
    
    public void spearDodged(){
        JPanel panel = new JPanel();
        JFrame spearDodged = new JFrame();
        JButton rollDodge = new JButton("Roll");
       
       
        //JLabel label1 = new JLabel("Chest");
        
        
         
         panel.setSize(400, 400);
         rollDodge.setBounds(20, 140, 75, 45);
        
         
         
       
        spearDodged.setUndecorated(true);
        
        spearDodged.add(rollDodge);
        spearDodged.setSize(200, 200);
        spearDodged.setLocationRelativeTo(null);
        spearDodged.add(panel, BorderLayout.CENTER);
        spearDodged.setVisible(true);
        
        JOptionPane.showMessageDialog(null, "You entered the Mess Hall and it is chaos, a spear is flying towards you, Roll 5 or more do dodge it");
        
        rollDodge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                int min =1;
                int max = 20;
                int random_roll = (int) (Math.random() * (max - min + 1) + min);
                int dodge = User.dodge;
                int totalRoll = random_roll + dodge;
                
                if(totalRoll>=5){
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll + " From dice " + dodge + " from stats for totatl of " + totalRoll + " and dodged the spear");
                    jButton3.setEnabled(true);
                    spearDodged.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll + " From dice " + dodge + " from stats for totatl of " + totalRoll + " and the spear hit you, Lose 1 life");
                    User.hp=User.hp-1;
                    jButton3.setEnabled(true);
                    spearDodged.dispose();
                    repaint();
                }
            }
        });
        
    }
    
    
    public void  eventAtPosition3(){
        
        JPanel panel = new JPanel();
        JFrame position3 = new JFrame();
        JButton rollDodge = new JButton("Roll");
       
       
        //JLabel label1 = new JLabel("Chest");
        
        
         
         panel.setSize(400, 400);
         rollDodge.setBounds(20, 140, 75, 45);
        
         
         
       
        position3.setUndecorated(true);
        
        position3.add(rollDodge);
        position3.setSize(200, 200);
        position3.setLocationRelativeTo(null);
        position3.add(panel, BorderLayout.CENTER);
        position3.setVisible(true);
        
        JOptionPane.showMessageDialog(null, "You are walking down the coridor and enraged Troll is running towards you, Roll 5 or more do dodge.");
        
        rollDodge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                int min =1;
                int max = 20;
                int random_roll = (int) (Math.random() * (max - min + 1) + min);
                int dodge = User.dodge;
                int totalRoll = random_roll + dodge;
                
                if(totalRoll>=5){
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll + " From dice " + dodge + " from stats for totatl of " + totalRoll + " and moved out of the way in time");
                    jButton3.setEnabled(true);
                    position3.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll + " From dice " + dodge + " from stats for totatl of " + totalRoll + " and the Troll pushed you to the ground, Lose 1 life");
                    User.hp=User.hp-1;
                    jButton3.setEnabled(true);
                    position3.dispose();
                    repaint();
                }
            }
        });
        
    }
    
    public void eventAtPosition4(){
        
        JPanel panel = new JPanel();
        JFrame position4 = new JFrame();
        JButton roll = new JButton("Roll");
        JToggleButton userSkill = new JToggleButton("Skill");
       
        //JLabel label1 = new JLabel("Chest");
        
        
         
         panel.setSize(400, 400);
         roll.setBounds(20, 140, 75, 45);
         userSkill.setBounds(110, 140, 75, 45);
         
         
       
        position4.setUndecorated(true);
        position4.add(userSkill);
        position4.add(roll);
        position4.setSize(200, 200);
        position4.setLocationRelativeTo(null);
        position4.add(panel, BorderLayout.CENTER);
        position4.setVisible(true);
        
        JOptionPane.showMessageDialog(null, "A group of guards are storming in the coridor, One guard is attacking you, Roll 5 or more do defeat him.");
        
        roll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                int min =1;
                int max = 20;
                int random_roll = (int) (Math.random() * (max - min + 1) + min);
                int roll = User.roll;
                
                
                
                int mageSkill = 3;
                int warriorSkill = 3;
                int skill=0;
                int actualSkill;
                
                
               
                 if(User.characterClass=="mage"){
                        skill = 0;
                     }else if(User.characterClass=="warrior"){
                        skill = warriorSkill;
                     }
                 
                 if(userSkill.isSelected()){
                     actualSkill=skill;
                     User.skillUsed=true;
                    
                 }else{
                     actualSkill=0;
                 }
                
                int totalRoll = random_roll + roll + actualSkill;
                
                
                
                
                if(totalRoll>=5){
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll + " From dice " + roll + " from stats and " + actualSkill + " from skill, for totatl of " + totalRoll + " and defeted the guard");
                    jButton3.setEnabled(true);
                    position4.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll + " From dice " + roll + " from stats and " + actualSkill + " from skill, for totatl of " + totalRoll + " and lost the fight and 1 life");
                    User.hp=User.hp-1;
                    jButton3.setEnabled(true);
                    position4.dispose();
                    repaint();
                }
            }
        });
        
    }
    
    public void eventAtPosition5(){
        
        JPanel panel = new JPanel();
        JFrame position5 = new JFrame();
        JButton roll = new JButton("Roll");
        JToggleButton userSkill = new JToggleButton("Skill");
       
        //JLabel label1 = new JLabel("Chest");
        
        if(User.skillUsed==true){
             userSkill.setEnabled(false);
         }
         
         panel.setSize(400, 400);
         roll.setBounds(20, 140, 75, 45);
         userSkill.setBounds(110, 140, 75, 45);
         
         
       
        position5.setUndecorated(true);
        position5.add(userSkill);
        position5.add(roll);
        position5.setSize(200, 200);
        position5.setLocationRelativeTo(null);
        position5.add(panel, BorderLayout.CENTER);
        position5.setVisible(true);
        
        JOptionPane.showMessageDialog(null, "A inmate that hates you is attacking you, Roll 5 or more do defeat him.");
        
        roll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                int min =1;
                int max = 20;
                int random_roll = (int) (Math.random() * (max - min + 1) + min);
                int roll = User.roll;
                
                
                
                int mageSkill = 3;
                int warriorSkill = 3;
                int skill=0;
                int actualSkill;
                
                
               
                 if(User.characterClass=="mage"){
                        skill = 0;
                     }else if(User.characterClass=="warrior"){
                        skill = warriorSkill;
                     }
                 
                 if(userSkill.isSelected()){
                     actualSkill=skill;
                     User.skillUsed=true;
                    
                 }else{
                     actualSkill=0;
                 }
                
                int totalRoll = random_roll + roll + actualSkill;
                
                
                
                
                if(totalRoll>=5){
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll + " From dice " + roll + " from stats and " + actualSkill + " from skill, for totatl of " + totalRoll + " and defeted him");
                    jButton3.setEnabled(true);
                    position5.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll + " From dice " + roll + " from stats and " + actualSkill + " from skill, for totatl of " + totalRoll + " and lost the fight and 1 life");
                    User.hp=User.hp-1;
                    jButton3.setEnabled(true);
                    position5.dispose();
                    repaint();
                }
            }
        });
        
    }
    
    public void eventAtPosition6(){
        
        JOptionPane.showMessageDialog(null, "There is a sharp broken blade on the ground! You did not see it and steped on it and lost 1 life (-1ife)");
        User.hp=User.hp-1;
        repaint();
    }
    
    
    public void eventAtPosition7(){
        
         JPanel panel = new JPanel();
        JFrame position7 = new JFrame();
        JButton roll = new JButton("Roll");
        JToggleButton userSkill = new JToggleButton("Skill");
       
        //JLabel label1 = new JLabel("Chest");
        
        if(User.skillUsed==true){
             userSkill.setEnabled(false);
         }
         
         panel.setSize(400, 400);
         roll.setBounds(20, 140, 75, 45);
         userSkill.setBounds(110, 140, 75, 45);
         
         
       
        position7.setUndecorated(true);
        position7.add(userSkill);
        position7.add(roll);
        position7.setSize(200, 200);
        position7.setLocationRelativeTo(null);
        position7.add(panel, BorderLayout.CENTER);
        position7.setVisible(true);
        
        JOptionPane.showMessageDialog(null, "All of a sudden  you are in the middle of a mass braw. Roll 5 or more to fight your way out");
        
        roll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                int min =1;
                int max = 20;
                int random_roll = (int) (Math.random() * (max - min + 1) + min);
                int roll = User.roll;
                
                
                
                int mageSkill = 3;
                int warriorSkill = 3;
                int skill=0;
                int actualSkill;
                
                
               
                 if(User.characterClass=="mage"){
                        skill = 0;
                     }else if(User.characterClass=="warrior"){
                        skill = warriorSkill;
                     }
                 
                 if(userSkill.isSelected()){
                     actualSkill=skill;
                     User.skillUsed=true;
                    
                 }else{
                     actualSkill=0;
                 }
                
                int totalRoll = random_roll + roll + actualSkill;
                
                
                
                
                if(totalRoll>=5){
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll + " From dice " + roll + " from stats and " + actualSkill + " from skill, for totatl of " + totalRoll + " and did not get hurt");
                    jButton3.setEnabled(true);
                    position7.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll + " From dice " + roll + " from stats and " + actualSkill + " from skill, for totatl of " + totalRoll + " and got smashed to the ground and lost 1 life");
                    User.hp=User.hp-1;
                    jButton3.setEnabled(true);
                    position7.dispose();
                    repaint();
                }
            }
        });
        
    }
    
    public void eventAtPosition9(){
    
        JPanel panel = new JPanel();
        JFrame position9 = new JFrame();
        JButton roll = new JButton("Roll");
       
       
        
       
         
         
         panel.setSize(400, 400);
         roll.setBounds(20, 140, 75, 45);
        
         
         
       
        position9.setUndecorated(true);
        position9.add(roll);
        position9.setSize(200, 200);
        position9.setLocationRelativeTo(null);
        position9.add(panel, BorderLayout.CENTER);
        position9.setVisible(true);
        
        JOptionPane.showMessageDialog(null, "The guards are isolating the wing. The door is closing. Roll 5 or more to escape before the door is closed");
        
        roll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                int min =1;
                int max = 20;
                int random_roll = (int) (Math.random() * (max - min + 1) + min);
               
                int totalRoll = random_roll;
                
                
                if(totalRoll>=5){
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll  + " and rolled under th door");
                    jButton3.setEnabled(true);
                    position9.dispose();
                    wingEscaped=true;
                }else{
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll + " and did not manage to leave this wing! Find onother way");
                    User.hp=User.hp-1;
                    jButton3.setEnabled(true);
                    position9.dispose();
                    repaint();
                    
                }
            }
        });
        
    }
    
    public void eventAtPosition10(){
    
        JPanel panel = new JPanel();
        JFrame position10 = new JFrame();
        JButton roll = new JButton("Roll");
        JToggleButton userSkill = new JToggleButton("Skill");
       
        //JLabel label1 = new JLabel("Chest");
        
        if(User.skillUsed==true){
             userSkill.setEnabled(false);
         }
         
         panel.setSize(400, 400);
         roll.setBounds(20, 140, 75, 45);
         userSkill.setBounds(110, 140, 75, 45);
         
         
       
        position10.setUndecorated(true);
        position10.add(userSkill);
        position10.add(roll);
        position10.setSize(200, 200);
        position10.setLocationRelativeTo(null);
        position10.add(panel, BorderLayout.CENTER);
        position10.setVisible(true);
        
        JOptionPane.showMessageDialog(null, "A Guad saw you trying to go unnoticed and attacked you. Roll 5 or more to fight of the Guadr");
        
        roll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                int min =1;
                int max = 20;
                int random_roll = (int) (Math.random() * (max - min + 1) + min);
                int roll = User.roll;
                
                
                
                int mageSkill = 3;
                int warriorSkill = 3;
                int skill=0;
                int actualSkill;
                
                
               
                 if(User.characterClass=="mage"){
                        skill = 0;
                     }else if(User.characterClass=="warrior"){
                        skill = warriorSkill;
                     }
                 
                 if(userSkill.isSelected()){
                     actualSkill=skill;
                     User.skillUsed=true;
                    
                 }else{
                     actualSkill=0;
                 }
                
                int totalRoll = random_roll + roll + actualSkill;
                
                
                
                
                if(totalRoll>=5){
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll + " From dice " + roll + " from stats and " + actualSkill + " from skill, for totatl of " + totalRoll + " and defeated the Guard");
                    jButton3.setEnabled(true);
                    position10.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll + " From dice " + roll + " from stats and " + actualSkill + " from skill, for totatl of " + totalRoll + " and lost the fight and 1 life(-1 life)");
                    User.hp=User.hp-1;
                    jButton3.setEnabled(true);
                    position10.dispose();
                    repaint();
                }
            }
        });
        
    }
    
    public void eventAtPosition11(){
        
        JPanel panel = new JPanel();
        JFrame position11 = new JFrame();
        JButton roll = new JButton("Roll");
        JToggleButton userSkill = new JToggleButton("Skill");
       
        //JLabel label1 = new JLabel("Chest");
        
        if(User.skillUsed==true){
             userSkill.setEnabled(false);
         }
         
         panel.setSize(400, 400);
         roll.setBounds(20, 140, 75, 45);
         userSkill.setBounds(110, 140, 75, 45);
         
         
       
        position11.setUndecorated(true);
        position11.add(userSkill);
        position11.add(roll);
        position11.setSize(200, 200);
        position11.setLocationRelativeTo(null);
        position11.add(panel, BorderLayout.CENTER);
        position11.setVisible(true);
        
        JOptionPane.showMessageDialog(null, "More Guards are comming. Roll 5 or more to fight them off");
        
        roll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                int min =1;
                int max = 20;
                int random_roll = (int) (Math.random() * (max - min + 1) + min);
                int roll = User.roll;
                
                
                
                int mageSkill = 3;
                int warriorSkill = 3;
                int skill=0;
                int actualSkill;
                
                
               
                 if(User.characterClass=="mage"){
                        skill = 0;
                     }else if(User.characterClass=="warrior"){
                        skill = warriorSkill;
                     }
                 
                 if(userSkill.isSelected()){
                     actualSkill=skill;
                     User.skillUsed=true;
                    
                 }else{
                     actualSkill=0;
                 }
                
                int totalRoll = random_roll + roll + actualSkill;
                
                
                
                
                if(totalRoll>=5){
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll + " From dice " + roll + " from stats and " + actualSkill + " from skill, for totatl of " + totalRoll + " and defeated the Guards");
                    jButton3.setEnabled(true);
                    position11.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll + " From dice " + roll + " from stats and " + actualSkill + " from skill, for totatl of " + totalRoll + " and lost the fight and 1 life(-1 life)");
                    User.hp=User.hp-1;
                    jButton3.setEnabled(true);
                    position11.dispose();
                    repaint();
                }
            }
        });
        
    }
    
    public void eventAtPosition12(){
    
        JOptionPane.showMessageDialog(null, "You entered dark coridor! keep Walking");
        
    }
    
    public void eventAtPosition13(){
    
        JOptionPane.showMessageDialog(null, "You see a door and loud noices are comming from that direction, You decided to ckeck it out!");
        
    }
    
    public void eventAtPosition15(){
        
        JPanel panel = new JPanel();
        JFrame position15 = new JFrame();
        JButton roll = new JButton("Roll");
        JToggleButton userSkill = new JToggleButton("Skill");
       
        //JLabel label1 = new JLabel("Chest");
        
        if(User.skillUsed==true){
             userSkill.setEnabled(false);
         }
         
         panel.setSize(400, 400);
         roll.setBounds(20, 140, 75, 45);
         userSkill.setBounds(110, 140, 75, 45);
         
         
       
        position15.setUndecorated(true);
        position15.add(userSkill);
        position15.add(roll);
        position15.setSize(200, 200);
        position15.setLocationRelativeTo(null);
        position15.add(panel, BorderLayout.CENTER);
        position15.setVisible(true);
        
        JOptionPane.showMessageDialog(null, "Try to leave this Hall and find the Exit. Guards and Inmates are pulling you in to the fight.Roll 5 or more to fight them off and run");
        
        roll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                int min =1;
                int max = 20;
                int random_roll = (int) (Math.random() * (max - min + 1) + min);
                int roll = User.roll;
                
                
                
                int mageSkill = 3;
                int warriorSkill = 3;
                int skill=0;
                int actualSkill;
                
                
               
                 if(User.characterClass=="mage"){
                        skill = 0;
                     }else if(User.characterClass=="warrior"){
                        skill = warriorSkill;
                     }
                 
                 if(userSkill.isSelected()){
                     actualSkill=skill;
                     User.skillUsed=true;
                    
                 }else{
                     actualSkill=0;
                 }
                
                int totalRoll = random_roll + roll + actualSkill;
                
                
                
                
                if(totalRoll>=5){
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll + " From dice " + roll + " from stats and " + actualSkill + " from skill, for totatl of " + totalRoll + " and managed leave the fight");
                    jButton3.setEnabled(true);
                    position15.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll + " From dice " + roll + " from stats and " + actualSkill + " from skill, for totatl of " + totalRoll + " and got beat up and lost 1 life(-1 life)");
                    User.hp=User.hp-1;
                    jButton3.setEnabled(true);
                    position15.dispose();
                    repaint();
                }
            }
        });
        
    }
    
    public void eventAtPosition16(){
        
         JOptionPane.showMessageDialog(null, "As you are walking trough the prison coridors you see a half opend door and decided to ckeck waht is on the other side");
        
    }
    
    public void eventAtPosition18(){
         JPanel panel = new JPanel();
        JFrame position11 = new JFrame();
        JButton roll = new JButton("Roll");
        JToggleButton userSkill = new JToggleButton("Skill");
       
        //JLabel label1 = new JLabel("Chest");
        
        if(User.skillUsed==true){
             userSkill.setEnabled(false);
         }
         
         panel.setSize(400, 400);
         roll.setBounds(20, 140, 75, 45);
         userSkill.setBounds(110, 140, 75, 45);
         
         
       
        position11.setUndecorated(true);
        position11.add(userSkill);
        position11.add(roll);
        position11.setSize(200, 200);
        position11.setLocationRelativeTo(null);
        position11.add(panel, BorderLayout.CENTER);
        position11.setVisible(true);
        
        JOptionPane.showMessageDialog(null, "You are attacked by guard dogs. Roll 5 or more to escape them");
        
        roll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                int min =1;
                int max = 20;
                int random_roll = (int) (Math.random() * (max - min + 1) + min);
                int roll = User.roll;
                
                
                
                int mageSkill = 3;
                int warriorSkill = 3;
                int skill=0;
                int actualSkill;
                
                
               
                 if(User.characterClass=="mage"){
                        skill = 0;
                     }else if(User.characterClass=="warrior"){
                        skill = warriorSkill;
                     }
                 
                 if(userSkill.isSelected()){
                     actualSkill=skill;
                     User.skillUsed=true;
                    
                 }else{
                     actualSkill=0;
                 }
                
                int totalRoll = random_roll + roll + actualSkill;
                
                
                
                
                if(totalRoll>=5){
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll + " From dice " + roll + " from stats and " + actualSkill + " from skill, for totatl of " + totalRoll + " and escaped the dogs");
                    jButton3.setEnabled(true);
                    position11.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll + " From dice " + roll + " from stats and " + actualSkill + " from skill, for totatl of " + totalRoll + " and tripped and the doggs bit(-1 life)");
                    User.hp=User.hp-1;
                    jButton3.setEnabled(true);
                    position11.dispose();
                    repaint();
                }
            }
        });
    }
    
    public void eventAtPosition19(){
        JPanel panel = new JPanel();
        JFrame position11 = new JFrame();
        JButton roll = new JButton("Roll");
        JToggleButton userSkill = new JToggleButton("Skill");
       
        //JLabel label1 = new JLabel("Chest");
        
        if(User.skillUsed==true){
             userSkill.setEnabled(false);
         }
         
         panel.setSize(400, 400);
         roll.setBounds(20, 140, 75, 45);
         userSkill.setBounds(110, 140, 75, 45);
         
         
       
        position11.setUndecorated(true);
        position11.add(userSkill);
        position11.add(roll);
        position11.setSize(200, 200);
        position11.setLocationRelativeTo(null);
        position11.add(panel, BorderLayout.CENTER);
        position11.setVisible(true);
        
        JOptionPane.showMessageDialog(null, "You are attacked by guard dogs. Roll 5 or more to escape them");
        
        roll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                int min =1;
                int max = 20;
                int random_roll = (int) (Math.random() * (max - min + 1) + min);
                int roll = User.roll;
                
                
                
                int mageSkill = 3;
                int warriorSkill = 3;
                int skill=0;
                int actualSkill;
                
                
               
                 if(User.characterClass=="mage"){
                        skill = 0;
                     }else if(User.characterClass=="warrior"){
                        skill = warriorSkill;
                     }
                 
                 if(userSkill.isSelected()){
                     actualSkill=skill;
                     User.skillUsed=true;
                    
                 }else{
                     actualSkill=0;
                 }
                
                int totalRoll = random_roll + roll + actualSkill;
                
                
                
                
                if(totalRoll>=5){
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll + " From dice " + roll + " from stats and " + actualSkill + " from skill, for totatl of " + totalRoll + " and escaped the dogs");
                    jButton3.setEnabled(true);
                    position11.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll + " From dice " + roll + " from stats and " + actualSkill + " from skill, for totatl of " + totalRoll + " and tripped and the doggs bit(-1 life)");
                    User.hp=User.hp-1;
                    jButton3.setEnabled(true);
                    position11.dispose();
                    repaint();
                }
            }
        });
    }
    
    public void eventAtPosition20(){
        JPanel panel = new JPanel();
        JFrame position11 = new JFrame();
        JButton roll = new JButton("Roll");
       
       
        //JLabel label1 = new JLabel("Chest");
        
       
         
         panel.setSize(400, 400);
         roll.setBounds(20, 140, 75, 45);
        
         
         
       
        position11.setUndecorated(true);
        
        position11.add(roll);
        position11.setSize(200, 200);
        position11.setLocationRelativeTo(null);
        position11.add(panel, BorderLayout.CENTER);
        position11.setVisible(true);
        
        JOptionPane.showMessageDialog(null, "You see a trap. Roll 5 or more to go pas it");
        
        roll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                int min =1;
                int max = 20;
                int random_roll = (int) (Math.random() * (max - min + 1) + min);
               
                
               
                
                
                int totalRoll = random_roll;
               
                if(totalRoll>=5){
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll + " and made it past  the trap");
                    jButton3.setEnabled(true);
                    position11.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll +  " and felt in to the trap(-1 life)");
                    User.hp=User.hp-1;
                    jButton3.setEnabled(true);
                    position11.dispose();
                    repaint();
                }
            }
        });
    }
    
    public void eventAtPosition21(){
         JPanel panel = new JPanel();
        JFrame position11 = new JFrame();
        JButton roll = new JButton("Roll");
       
       
        //JLabel label1 = new JLabel("Chest");
        
       
         
         panel.setSize(400, 400);
         roll.setBounds(20, 140, 75, 45);
        
         
         
       
        position11.setUndecorated(true);
        
        position11.add(roll);
        position11.setSize(200, 200);
        position11.setLocationRelativeTo(null);
        position11.add(panel, BorderLayout.CENTER);
        position11.setVisible(true);
        
        JOptionPane.showMessageDialog(null, "You are  close to escape but there is a wall with spikes. Roll 5 or more make it trough");
        
        roll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                int min =1;
                int max = 20;
                int random_roll = (int) (Math.random() * (max - min + 1) + min);
               
                
               
                
                
                int totalRoll = random_roll;
               
                if(totalRoll>=5){
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll + " and made it without hurting yourself");
                    jButton3.setEnabled(true);
                    position11.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll +  " and hit a spike and lost 1 life(-1 life)");
                    User.hp=User.hp-1;
                    jButton3.setEnabled(true);
                    position11.dispose();
                    repaint();
                }
            }
        });
    }
    
    public void eventAtPosition22(){
        JOptionPane.showMessageDialog(null, "Your lucky day nothing to be found here. Roll again");
    }
    
    
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
            java.util.logging.Logger.getLogger(Prison.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Prison.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Prison.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Prison.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Prison().setVisible(true);
               
                
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
