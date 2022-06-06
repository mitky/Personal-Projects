/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalyearproject;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
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
import javax.swing.JToggleButton;
import jdk.javadoc.internal.tool.Main;

/**
 *
 * @author mmiit
 */
public class Forest extends javax.swing.JFrame {

    /**
     * Creates new form Forest
     */
    public int dice6 = 0;
    private float alpha = 0.5f;
    
    
    
    public boolean hunterFound = false;
    public boolean hunterQuestAccepted = false;
    public boolean werewolfFound = false;
    
    
    
     public boolean position25Hit = false;
     public boolean position26Hit = false;
     public boolean position27Hit = false;
     public boolean position28Hit = false;
     public boolean position29Hit = false;
     public boolean position30Hit = false;
     public boolean position31Hit = false;
     public boolean position32Hit = false;
     public boolean position33Hit = false;
     public boolean position34Hit = false;
     public boolean position35Hit = false;
     public boolean position36Hit = false;
     public boolean position37Hit = false;
     public boolean position38Hit = false;
     public boolean position39Hit = false;
     public boolean position40Hit = false;
     public boolean position41Hit = false;
     public boolean position42Hit = false;
     public boolean position43Hit = false;
     public boolean position44Hit = false;
     public boolean position45Hit = false;
     public boolean position46Hit = false;
     
    
    
     public  void paint(Graphics g){
         
         URL url = Main.class.getResource("/forest.png");
         URL url1 = Main.class.getResource("/bottomPanel.png");//bottom panel image
         URL url2 = Main.class.getResource("/newBlock5.png");
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
                 jButton5.setIcon(commonCloak);
             }
             if(User.items.get(i).getType().equals("Boots")){
                 jButton6.setIcon(commonBoots);
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
          
         
          
          //draww steping blocks
          
          g.drawImage(block,50,450,75, 75, null);
          g.setFont(new Font("TimesRoman", Font.PLAIN,40));
          g.setColor(Color.red);
          g.drawString("24", 80, 570);
          
          g.drawImage(block,140,400,75, 75, null);
          g.drawString("25", 165, 510);
          
          g.drawImage(block,230,350,75, 75, null);
          g.drawString("26", 255, 460);
          
          g.drawImage(block,315,300,75, 75, null);
          g.drawString("27", 345, 410);
          
          g.drawImage(block,400,250,75, 75, null);
          g.drawString("28", 430, 360);
          
          g.drawImage(block,485,250,75, 75, null);
          g.drawString("29", 510, 360);
          
          g.drawImage(block,565,300,75, 75, null);
          g.drawString("30", 590, 410);
          
          g.drawImage(block,645,370,75, 75, null);
          g.drawString("31", 675, 480);
          
          g.drawImage(block,725,430,75, 75, null);
          g.drawString("32", 750, 540);
          
          g.drawImage(block,805,490,75, 75, null);
          g.drawString("33", 820, 600);
          
          g.drawImage(block,885,550,75, 75, null);
          g.drawString("34", 905, 660);
          
          g.drawImage(block,965,610,75, 75, null);
          g.drawString("35", 980, 720);
          
          g.drawImage(block,1045,550,75, 75, null);
          g.drawString("36", 1060, 660);
          
          g.drawImage(block,1125,490,75, 75, null);
          g.drawString("37", 1140, 600);
          
          g.drawImage(block,1205,430,75, 75, null);
          g.drawString("38", 1220, 540);
          
          g.drawImage(block,1285,370,75, 75, null);
          g.drawString("39", 1300, 480);
          
          g.drawImage(block,1365,300,75, 75, null);
          g.drawString("40", 1380, 410);
          
          g.drawImage(block,1445,250,75, 75, null);
          g.drawString("41", 1460, 360);
          
          g.drawImage(block,1530,200,75, 75, null);
          g.drawString("42", 1545, 310);
          
          g.drawImage(block,1615,250,75, 75, null);
          g.drawString("43", 1630, 360);
          
          g.drawImage(block,1700,300,75, 75, null);
          g.drawString("44", 1720, 410);
          
          g.drawImage(block,1785,370,75, 75, null);
          g.drawString("45", 1805, 480);
          
          g.drawImage(block,1855,460,75, 75, null);
          g.drawString("46", 1875, 570);
          
          String gold = String.valueOf(User.gold);
          
          g.drawString("Gold:", 1685, 870);
          g.drawString(gold, 1720, 930);
          //draw player position
          
           if(User.position==24){
             g.drawImage(player_piece,53,408,70, 70, null); //position 24
          }
          else if(User.position==25){
              if(position25Hit==false){
                   g.drawImage(player_piece,143,358,70, 70, null);//position 25
                   position25Hit=true;
                    jButton3.setEnabled(false);
                   position25();
                  
              }else{
                  g.drawImage(player_piece,143,358,70, 70, null);//position 25
              }
           }
          else if(User.position==26){
              if(position26Hit==false){
                   g.drawImage(player_piece,233,308,70, 70, null);//position 26
                   position26Hit=true;
                   jButton3.setEnabled(false);
                   position26();
                   
              }else{
                   g.drawImage(player_piece,233,308,70, 70, null);//position 26
              }
              
            
          }
          else if(User.position==27){
              if(position27Hit==false){
                    g.drawImage(player_piece,318,258,70, 70, null);//position 27
                   position27Hit=true;
                    jButton3.setEnabled(false);
                   position27();
                  
              }else{
                   g.drawImage(player_piece,318,258,70, 70, null);//position 27
              }
             
          }
          else if(User.position==28){
              if(position28Hit==false){
                    g.drawImage(player_piece,403,208,70, 70, null);//position 28
                   position28Hit=true;
                    jButton3.setEnabled(false);
                   position28();
                  
              }else{
                   g.drawImage(player_piece,403,208,70, 70, null);//position 28
              }
             
          }
          else if(User.position==29){
              if(position29Hit==false){
                    g.drawImage(player_piece,488,208,70, 70, null);//position 29
                   position29Hit=true;
                   jButton3.setEnabled(false);
                   position29();
                   
              }else{
                   g.drawImage(player_piece,488,208,70, 70, null);//position 29
              }
             
          }
          else if(User.position==30){
              if(position30Hit==false){
                    g.drawImage(player_piece,568,258,70, 70, null);//position 30
                   position30Hit=true;
                   position30();
                   
              }else{
                   g.drawImage(player_piece,568,258,70, 70, null);//position 30
              }
             
          }
          else if(User.position==31){
              if(position31Hit==false){
                    g.drawImage(player_piece,648,328,70, 70, null);//position 31
                   position31Hit=true;
                    jButton3.setEnabled(false);
                   position31();
                  
              }else{
                   g.drawImage(player_piece,648,328,70, 70, null);//position 31
              }
             
         }
          else if(User.position==32){
              if(position32Hit==false){
                    g.drawImage(player_piece,728,388,70, 70, null);//position 32
                   position32Hit=true;
                   jButton3.setEnabled(false);
                   position32();
                   
              }else{
                   g.drawImage(player_piece,728,388,70, 70, null);//position 32
              }
             
        }
          else if(User.position==33){
              if(position33Hit==false){
                     g.drawImage(player_piece,808,448,70, 70, null);//position 33
                   position33Hit=true;
                    jButton3.setEnabled(false);
                   position33();
                  
              }else{
                    g.drawImage(player_piece,808,448,70, 70, null);//position 33
              }
            
       }
          else if(User.position==34){
              if(position34Hit==false){
                     g.drawImage(player_piece,888,508,70, 70, null);//position 34 
                   position34Hit=true;
                    jButton3.setEnabled(false);
                   position34();
                  
              }else{
                    g.drawImage(player_piece,888,508,70, 70, null);//position 34 
              }
              
        }
          else if(User.position==35){
              if(position35Hit==false){
                     g.drawImage(player_piece,968,568,70, 70, null);//position 35
                   position35Hit=true;
                    jButton3.setEnabled(false);
                   position35();
                  
              }else{
                    g.drawImage(player_piece,968,568,70, 70, null);//position 35
              }
              
         }
          else if(User.position==36){
              if(position36Hit==false){
                     g.drawImage(player_piece,1048,508,70, 70, null);//position 36
                   position36Hit=true;
                   jButton3.setEnabled(false);
                   position36();
                   
              }else{
                    g.drawImage(player_piece,1048,508,70, 70, null);//position 36
              }
              
          }
          else if(User.position==37){
               if(position37Hit==false){
                      g.drawImage(player_piece,1128,448,70, 70, null);//position 37
                   position37Hit=true;
                   jButton3.setEnabled(false);
                   position37();
                   
              }else{
                     g.drawImage(player_piece,1128,448,70, 70, null);//position 37
              }
             
          }
          else if(User.position==38){
              if(position38Hit==false){
                      g.drawImage(player_piece,1208,388,70, 70, null);//position 38
                   position38Hit=true;
                   jButton3.setEnabled(false);
                   position38();
                   
              }else{
                    g.drawImage(player_piece,1208,388,70, 70, null);//position 38
              }
              
          }
          else if(User.position==39){
              if(position39Hit==false){
                      g.drawImage(player_piece,1288,328,70, 70, null);//position 39
                   position39Hit=true;
                   position39();
                  // jButton3.setEnabled(false);
              }else{
                    g.drawImage(player_piece,1288,328,70, 70, null);//position 39
              }
              
          }
          else if(User.position==40){
              if(position40Hit==false){
                      g.drawImage(player_piece,1368,258,70, 70, null);//position 40
                   position40Hit=true;
                    jButton3.setEnabled(false);
                   position40();
                  
              }else{
                    g.drawImage(player_piece,1368,258,70, 70, null);//position 40
              }
              
          }
          else if(User.position==41){
              if(position41Hit==false){
                      g.drawImage(player_piece,1448,208,70, 70, null);//position 41
                   position41Hit=true;
                   jButton3.setEnabled(false);
                   position41();
                   
              }else{
                    g.drawImage(player_piece,1448,208,70, 70, null);//position 41
              }
              
          }
          else if(User.position==42){
              if(position42Hit==false){
                      g.drawImage(player_piece,1533,158,70, 70, null);//position 42
                   position42Hit=true;
                   jButton3.setEnabled(false);
                   position42();
                  
              }else{
                    g.drawImage(player_piece,1533,158,70, 70, null);//position 42
              }
              
          }
          else if(User.position==43){
              if(position43Hit==false){
                     g.drawImage(player_piece,1618,208,70, 70, null);//position 43
                   position43Hit=true;
                   jButton3.setEnabled(false);
                   position43();
                   
              }else{
                    g.drawImage(player_piece,1618,208,70, 70, null);//position 43
              }
              
          }
          else if(User.position==44){
              if(position44Hit==false){
                      g.drawImage(player_piece,1703,258,70, 70, null);//position 44
                   position44Hit=true;
                    jButton3.setEnabled(false);
                   position44();
                  
              }else{
                    g.drawImage(player_piece,1703,258,70, 70, null);//position 44
              }
              
          }
          else if(User.position==45){
              if(position45Hit==false){
                     g.drawImage(player_piece,1788,328,70, 70, null);//position 45
                   position45Hit=true;
                    jButton3.setEnabled(false);
                   position45();
                  
              }else{
                    g.drawImage(player_piece,1788,328,70, 70, null);//position 45
              }
              
          }
          else if(User.position==46){
              if(position46Hit==false){
                     g.drawImage(player_piece,1858,418,70, 70, null);//position 46
                   position46Hit=true;
                   position46();
                  // jButton3.setEnabled(false);
              }else{
                    g.drawImage(player_piece,1858,418,70, 70, null);//position 46
              }
              
          }
           
            //bottom panel
         
          g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,alpha));
          
          g.drawImage(image1,0,770,2500, 270, null);
         
     }
    
    public Forest() {
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

        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
                        .addGap(66, 66, 66)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(305, Short.MAX_VALUE)
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
        
        if(User.position>=46){
                    
                    Town town = new Town();
                    town.setVisible(true);
                    town.pack();
                    town.setLocationRelativeTo(null);
                    town.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    town.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    //town.setSize(1950,1050);
                    User.position=47;
                    User.skillUsed = false;
                    dispose();
                    JOptionPane.showMessageDialog(null, "You Reached the town. Explore before you leave");
        }

        repaint();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Forest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Forest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Forest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Forest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
                
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Forest().setVisible(true);
                
                
            }
        });
    }
    
    
    public void position25(){
        hunterFound();
        hunterFound = true;
    }
    
    public void position26(){
        if(hunterFound==false){
            hunterFound();
            hunterFound = true;
        }else{
            eventAtPosition26();
        }
    }
    
    public void position27(){
        if(hunterFound==false){
            hunterFound();
            hunterFound = true;
        }else{
            eventAtPosition27();
        }
    }
    
    public void position28(){
        JPanel panel = new JPanel();
        JFrame position28 = new JFrame();
        JButton rollDodge = new JButton("Roll");
        JButton leave = new JButton("leave");
       
       
        //JLabel label1 = new JLabel("Chest");
        
        
         
         panel.setSize(400, 400);
         rollDodge.setBounds(20, 140, 75, 45);
        leave.setBounds(110, 140, 75, 45);
         
         
       
        position28.setUndecorated(true);
        position28.add(leave);
        position28.add(rollDodge);
        position28.setSize(200, 200);
        position28.setLocationRelativeTo(null);
        position28.add(panel, BorderLayout.CENTER);
        position28.setVisible(true);
        
        JOptionPane.showMessageDialog(null, "You met a fairy. She need your help.Roll 7 or more to help her");
        
        rollDodge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                int min =1;
                int max = 20;
                int random_roll = (int) (Math.random() * (max - min + 1) + min);
                
                
                if(random_roll>=7){
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll + " and the fairy give you 5 gold");
                    jButton3.setEnabled(true);
                    User.gold = User.gold + 5;
                    position28.dispose();
                    repaint();
                }else{
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll +  " you failed to help the fairy");
                   
                    jButton3.setEnabled(true);
                    position28.dispose();
                    repaint();
                }
            }
        });
        
        leave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "You did not help the fairy and left");
                jButton3.setEnabled(true);
                position28.dispose();
            }
        });
        
    }
    
    public void position29(){
         JPanel panel = new JPanel();
        JFrame position29 = new JFrame();
        JButton roll = new JButton("Roll");
        JToggleButton userSkill = new JToggleButton("Skill");
       
        //JLabel label1 = new JLabel("Chest");
        
        if(User.skillUsed==true){
             userSkill.setEnabled(false);
         }
         
         panel.setSize(400, 400);
         roll.setBounds(20, 140, 75, 45);
         userSkill.setBounds(110, 140, 75, 45);
         
         
       
        position29.setUndecorated(true);
        position29.add(userSkill);
        position29.add(roll);
        position29.setSize(200, 200);
        position29.setLocationRelativeTo(null);
        position29.add(panel, BorderLayout.CENTER);
        position29.setVisible(true);
        
        JOptionPane.showMessageDialog(null, "You are attacked by a bear. Roll 7 or more to defeat the bear");
        
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
                
                
                
                
                if(totalRoll>=7){
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll + " From dice " + roll + " from stats and " + actualSkill + " from skill, for totatl of " + totalRoll + " and defeated the bear");
                    jButton3.setEnabled(true);
                    position29.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll + " From dice " + roll + " from stats and " + actualSkill + " from skill, for totatl of " + totalRoll + " and lost the fight and 1 life (-1 life)");
                    User.hp=User.hp-1;
                    jButton3.setEnabled(true);
                    position29.dispose();
                    repaint();
                }
            }
        });
    }
    
    public void position30(){
            JOptionPane.showMessageDialog(null, "You entered dark part of the forest. A poisonus mist is all around you. Lose 1 life");
            User.hp=User.hp-1;
            repaint();
            jButton3.setEnabled(true);
    }
    
    public void position31(){
        JPanel panel = new JPanel();
        JFrame position31 = new JFrame();
        JButton roll = new JButton("Roll");
        JToggleButton userSkill = new JToggleButton("Skill");
       
        //JLabel label1 = new JLabel("Chest");
        
        if(User.skillUsed==true){
             userSkill.setEnabled(false);
         }
         
         panel.setSize(400, 400);
         roll.setBounds(20, 140, 75, 45);
         userSkill.setBounds(110, 140, 75, 45);
         
         
       
        position31.setUndecorated(true);
        position31.add(userSkill);
        position31.add(roll);
        position31.setSize(200, 200);
        position31.setLocationRelativeTo(null);
        position31.add(panel, BorderLayout.CENTER);
        position31.setVisible(true);
        
        JOptionPane.showMessageDialog(null, "You are attacked by a thievs. Roll 7 or more to defeat them");
        
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
                
                
                
                
                if(totalRoll>=7){
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll + " From dice " + roll + " from stats and " + actualSkill + " from skill, for totatl of " + totalRoll + " and defeated the thievs");
                    jButton3.setEnabled(true);
                    position31.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll + " From dice " + roll + " from stats and " + actualSkill + " from skill, for totatl of " + totalRoll + " and lost the fight and 1 life (-1 life)");
                    User.hp=User.hp-1;
                    jButton3.setEnabled(true);
                    position31.dispose();
                    repaint();
                }
            }
        });
    }
    
    public void position32(){
        JPanel panel = new JPanel();
        JFrame position32 = new JFrame();
        JButton rollDodge = new JButton("Roll");
       
       
        //JLabel label1 = new JLabel("Chest");
        
        
         
         panel.setSize(400, 400);
         rollDodge.setBounds(20, 140, 75, 45);
        
         
         
       
        position32.setUndecorated(true);
        
        position32.add(rollDodge);
        position32.setSize(200, 200);
        position32.setLocationRelativeTo(null);
        position32.add(panel, BorderLayout.CENTER);
        position32.setVisible(true);
        
        JOptionPane.showMessageDialog(null, "As you are walking trough the forest a tree falls towards you. Roll 7 or more to dodge the tree");
        
        rollDodge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                int min =1;
                int max = 20;
                int random_roll = (int) (Math.random() * (max - min + 1) + min);
                int dodge = User.dodge;
                int totalRoll = random_roll + dodge;
                
                if(totalRoll>=7){
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll + " From dice " + dodge + " from stats for totatl of " + totalRoll + " and moved out of the way in time");
                    jButton3.setEnabled(true);
                    position32.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll + " From dice " + dodge + " from stats for totatl of " + totalRoll + " and the tree hit you, Lose 1 life");
                    User.hp=User.hp-1;
                    jButton3.setEnabled(true);
                    position32.dispose();
                    repaint();
                }
            }
        });
    }
    
    public void position33(){
        JPanel panel = new JPanel();
        JFrame position33 = new JFrame();
        JButton rollEat = new JButton("Eat");
        JButton no = new JButton("Don't");
        
       
       
        //JLabel label1 = new JLabel("Chest");
        
        
         
         panel.setSize(400, 400);
         rollEat.setBounds(20, 140, 75, 45);
         no.setBounds(110, 140, 75, 45);
         
         
       
        position33.setUndecorated(true);
        position33.add(no);
        position33.add(rollEat);
        position33.setSize(200, 200);
        position33.setLocationRelativeTo(null);
        position33.add(panel, BorderLayout.CENTER);
        position33.setVisible(true);
        
            JOptionPane.showMessageDialog(null, "You found magic muchroom. Eat it, or maybe not");
            
            rollEat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "You ate the musroom and gained 1 life (+ 1 life)");
                User.hp = User.hp + 1;
                jButton3.setEnabled(true);
                 position33.dispose();
                repaint();
            }
        });
            no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "You decided not to eat the musroom");
                
                jButton3.setEnabled(true);
                position33.dispose();
                repaint();
            }
        });
    }
    
    public void position34(){
        if(hunterQuestAccepted == true && werewolfFound == false){
            werewolf();
        }else{
           eventAtPosition34();
        }
    }
    
    public void position35(){
        if(hunterQuestAccepted == true && werewolfFound == false){
            werewolf();
        }else{
            eventAtPostion35();
        }
    }
    
    public void position36(){
        if(hunterQuestAccepted == true && werewolfFound == false){
            werewolf();
        }else{
            eventAtPostion36();
        }
    }
    
    public void position37(){
        if(hunterQuestAccepted == true && werewolfFound == false){
            werewolf();
        }else{
            eventAtPostion37();
        }
    }
    
    public void position38(){
        if(hunterQuestAccepted == true && werewolfFound == false){
            werewolf();
        }else{
            eventAtPostion38();
        }
    }
    
    public void position39(){
        if(hunterQuestAccepted == true && werewolfFound == false){
            werewolf();
        }else{
            eventAtPostion39();
        }
        
    }
    
    public void position40(){
        
        if(User.keyUsed==true){
            
            User.keyUsed = false;
            
            elfReward();
            
        }else{
            eventAtPostion40();
            jButton3.setEnabled(true);
        }
        
        
    }
    
    public void position41(){
         if(User.keyUsed==true){
            
            User.keyUsed = false;
            jButton3.setEnabled(true);
            elfReward();
        }else{
            eventAtPosition41();
        }
    }
    
    public void position42(){
         if(User.keyUsed==true){
           
            jButton3.setEnabled(true);
            User.keyUsed = false;
             elfReward();
        }else{
            eventAtPosition42();
            jButton3.setEnabled(true);
        }
    }
    
    public void position43(){
         if(User.keyUsed==true){
           
            User.keyUsed = false;
            jButton3.setEnabled(true);
             elfReward();
        }else{
            eventAtPosition43();
            jButton3.setEnabled(true);
        }
    }
    
    public void position44(){
         if(User.keyUsed==true){
            
            User.keyUsed = false;
            jButton3.setEnabled(true);
            elfReward();
        }else{
            eventAtPosition44();
            jButton3.setEnabled(true);
        }
    }
    
    public void position45(){
         if(User.keyUsed==true){
            
            User.keyUsed = false;
            jButton3.setEnabled(true);
            elfReward();
        }else{
            eventAtPosition45();
            jButton3.setEnabled(true);
        }
    }
    
    public void position46(){
        eventAtPosition46();
    }
    
   
    
    
    
    
    public void hunterFound(){
        JPanel panel = new JPanel();
        JFrame hunterFound = new JFrame();
        JLabel label = new JLabel("Accept Quest");
        JButton yes = new JButton("Yes");
        JButton no = new JButton("No");
       
        //JLabel label1 = new JLabel("Chest");
        
      
         
         panel.setSize(400, 400);
         yes.setBounds(20, 140, 75, 45);
         no.setBounds(110, 140, 75, 45);
         label.setBounds(40,40,105,45);
         
        
       
        hunterFound.setUndecorated(true);
        
        hunterFound.add(yes);
        hunterFound.add(no);
        hunterFound.add(label);
        hunterFound.setSize(200, 200);
        hunterFound.setLocationRelativeTo(null);
        hunterFound.add(panel, BorderLayout.CENTER);
        hunterFound.setVisible(true);
        JOptionPane.showMessageDialog(null, "You met a hunter looking for Werewolfs, help the hunter, accept the quest");
        
        yes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User.keyUsed=true;
                JOptionPane.showMessageDialog(null, "You accepted the quest");
                hunterFound.dispose();
                jButton3.setEnabled(true);
                hunterQuestAccepted = true;
                repaint();
            }
        });
        no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "You decided the quest");
                hunterFound.dispose();
                jButton3.setEnabled(true);
                repaint();
            }
        });
    }
    
    
    public void werewolf(){
        werewolfFound = true;
        
        JPanel panel = new JPanel();
        JFrame werewolf = new JFrame();
        
        JButton roll = new JButton("Roll");
        JToggleButton userSkill = new JToggleButton("Skill");
       
        //JLabel label1 = new JLabel("Chest");
        
        if(User.skillUsed==true){
             userSkill.setEnabled(false);
         }
         
         panel.setSize(400, 400);
         roll.setBounds(20, 140, 75, 45);
         userSkill.setBounds(110, 140, 75, 45);
         
         
       
        werewolf.setUndecorated(true);
        werewolf.add(userSkill);
        werewolf.add(roll);
        werewolf.setSize(200, 200);
        werewolf.setLocationRelativeTo(null);
        werewolf.add(panel, BorderLayout.CENTER);
        werewolf.setVisible(true);
        
        JOptionPane.showMessageDialog(null, "You found the Werewolf. Roll 10 or more to kill the Werewolf");
        
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
                
                
                
                
                if(totalRoll>=10){
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll + " From dice " + roll + " from stats and " + actualSkill + " from skill, for totatl of " + totalRoll + " and killed the Warelof");
                    JOptionPane.showMessageDialog(null, "Your reward is 15 Gold");
                    User.gold = User.gold + 15;
                    jButton3.setEnabled(true);
                    werewolf.dispose();
                    repaint();
                }else{
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll + " From dice " + roll + " from stats and " + actualSkill + " from skill, for totatl of " + totalRoll + " and lost the fight(-1 life)");
                    User.hp=User.hp-1;
                    jButton3.setEnabled(true);
                    werewolf.dispose();
                    repaint();
                }
            }
        });
    }
    
    
    
    public void  eventAtPostion35(){
        JPanel panel = new JPanel();
        JFrame prisonGuards = new JFrame();
        JButton rollStealth = new JButton("Roll");
        JToggleButton userSkill = new JToggleButton("Skill");
       
        //JLabel label1 = new JLabel("Chest");
        
        
         
         panel.setSize(400, 400);
         rollStealth.setBounds(20, 140, 75, 45);
         userSkill.setBounds(110, 140, 75, 45);
         
         if(User.skillUsed==true){
             userSkill.setEnabled(false);
         }
        
       
        prisonGuards.setUndecorated(true);
        
        prisonGuards.add(rollStealth);
        prisonGuards.add(userSkill);
        prisonGuards.setSize(200, 200);
        prisonGuards.setLocationRelativeTo(null);
        prisonGuards.add(panel, BorderLayout.CENTER);
        prisonGuards.setVisible(true);
        
        JOptionPane.showMessageDialog(null, "There are Guards from the prison looking for escaped prisoners. Roll 7 or more to sneak past them");
        
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
                 
               
                
                 if(total>=7){
                    JOptionPane.showMessageDialog(null, "You rolled " + roll +" from dice "+StealthStats + " from  stealth stats " +  " and " + actualSkill+ " from skill for totatl of " + total + " and sneaked unnoticed");
                   jButton3.setEnabled(true);
                   prisonGuards.dispose();
                 }
                 
                 
                 else{
                  JOptionPane.showMessageDialog(null, "You rolled " + roll + " from dice " + StealthStats + " from stealth stats " + " and " + actualSkill+ " from skill for totatl of " + total + " and one of the guards heard noice from the bushes and cached you. ");
                  JOptionPane.showMessageDialog(null, "You have no choice but to fight them now. Roll 7 or more to defeat the guards");
                  
                  
                 prisonGuards.dispose();
                  
                JPanel panel = new JPanel();
                JFrame fightGuards = new JFrame();
                JButton rollFight = new JButton("Roll");
                JToggleButton userSkill1 = new JToggleButton("Skill");
       
                //JLabel label1 = new JLabel("Chest");
        
      
         
                 panel.setSize(400, 400);
                 rollFight.setBounds(20, 140, 75, 45);
                 userSkill1.setBounds(110, 140, 75, 45);
         
         
                 if(User.skillUsed==true){
                        userSkill1.setEnabled(false);
                    }
       
                fightGuards.setUndecorated(true);
        
                fightGuards.add(rollFight);
                fightGuards.add(userSkill1);
                fightGuards.setSize(200, 200);
                fightGuards.setLocationRelativeTo(null);
                fightGuards.add(panel, BorderLayout.CENTER);
                fightGuards.setVisible(true);
                
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
                 
                 if(total1>=7){
                 JOptionPane.showMessageDialog(null, "You rolled " + roll1 +" from dice "+ RollStats1 + " from Roll stats " +  " and " + actualSkill1+ " from skill for totatl of " + total1 + " and defieted the guards ");
                   fightGuards.dispose();
                  jButton3.setEnabled(true);
                   
                   
                 }else{
                     JOptionPane.showMessageDialog(null, "You rolled " + roll1 +" from dice "+ RollStats1 + " from Roll stats " +  " and " + actualSkill1+ " from skill for totatl of " + total1 + " and lost the fight and 1 life (-1 life)");
                    fightGuards.dispose();
                    User.hp = User.hp -1;
                   jButton3.setEnabled(true);
                   repaint();
                 }
                          
                      }
                  });
                
                  
               }
               
                 
            }
        });
    }
     
    public void  eventAtPostion36(){
        JPanel panel = new JPanel();
        JFrame position36 = new JFrame();
        JButton rollDodge = new JButton("Roll");
       
       
        //JLabel label1 = new JLabel("Chest");
        
        
         
         panel.setSize(400, 400);
         rollDodge.setBounds(20, 140, 75, 45);
        
         
         
       
        position36.setUndecorated(true);
        
        position36.add(rollDodge);
        position36.setSize(200, 200);
        position36.setLocationRelativeTo(null);
        position36.add(panel, BorderLayout.CENTER);
        position36.setVisible(true);
        
        JOptionPane.showMessageDialog(null, "As you are walking trough the forest and you see a trap. Roll 7 or more to dodge it");
        
        rollDodge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                int min =1;
                int max = 20;
                int random_roll = (int) (Math.random() * (max - min + 1) + min);
                int dodge = User.dodge;
                int totalRoll = random_roll + dodge;
                
                if(totalRoll>=7){
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll + " From dice " + dodge + " from stats for totatl of " + totalRoll + " and moved out of the way in time");
                    jButton3.setEnabled(true);
                    position36.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll + " From dice " + dodge + " from stats for totatl of " + totalRoll + " and the tree hit you, Lose 1 life");
                    User.hp=User.hp-1;
                    jButton3.setEnabled(true);
                    position36.dispose();
                    repaint();
                }
            }
        });
    }
      
    public void  eventAtPostion37(){
            JOptionPane.showMessageDialog(null, "You Rolled found health potion (+1 life)");
            User.hp=User.hp+1;
            jButton3.setEnabled(true);
            repaint();
    }
       
    public void  eventAtPostion38(){
        JPanel panel = new JPanel();
        JFrame position31 = new JFrame();
        JButton roll = new JButton("Roll");
        JToggleButton userSkill = new JToggleButton("Skill");
       
        //JLabel label1 = new JLabel("Chest");
        
        if(User.skillUsed==true){
             userSkill.setEnabled(false);
         }
         
         panel.setSize(400, 400);
         roll.setBounds(20, 140, 75, 45);
         userSkill.setBounds(110, 140, 75, 45);
         
         
       
        position31.setUndecorated(true);
        position31.add(userSkill);
        position31.add(roll);
        position31.setSize(200, 200);
        position31.setLocationRelativeTo(null);
        position31.add(panel, BorderLayout.CENTER);
        position31.setVisible(true);
        
        JOptionPane.showMessageDialog(null, "You are attacked by a wild beast. Roll 7 or more to defeat him");
        
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
                
                
                
                
                if(totalRoll>=7){
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll + " From dice " + roll + " from stats and " + actualSkill + " from skill, for totatl of " + totalRoll + " and defeated the beast");
                    jButton3.setEnabled(true);
                    position31.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll + " From dice " + roll + " from stats and " + actualSkill + " from skill, for totatl of " + totalRoll + " and lost the fight and 1 life (-1 life)");
                    User.hp=User.hp-1;
                    jButton3.setEnabled(true);
                    position31.dispose();
                    repaint();
                }
            }
        });
    }
        
    public void  eventAtPostion39(){
            jButton3.setEnabled(true);
            JOptionPane.showMessageDialog(null, "You found a cave and decided to check it out... Roll again ");
           
    }
    
    public void  eventAtPostion40(){
        
          
            
        JPanel panel = new JPanel();
        JFrame rockFalling = new JFrame();
        JButton rollDodge = new JButton("Roll");
       
       
        //JLabel label1 = new JLabel("Chest");
        
        
         
         panel.setSize(400, 400);
         rollDodge.setBounds(20, 140, 75, 45);
        
         
         
       
        rockFalling.setUndecorated(true);
        
        rockFalling.add(rollDodge);
        rockFalling.setSize(200, 200);
        rockFalling.setLocationRelativeTo(null);
        rockFalling.add(panel, BorderLayout.CENTER);
        rockFalling.setVisible(true);
        
        JOptionPane.showMessageDialog(null, "You are walking close to a cliff and a Rock is falling towards you. Roll 7 or more to dodge the Rock");
        
        rollDodge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                int min =1;
                int max = 20;
                int random_roll = (int) (Math.random() * (max - min + 1) + min);
                int dodge = User.dodge;
                int totalRoll = random_roll + dodge;
                
                if(totalRoll>=7){
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll + " From dice " + dodge + " from stats for totatl of " + totalRoll + " and moved out of the way in time");
                    jButton3.setEnabled(true);
                    rockFalling.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll + " From dice " + dodge + " from stats for totatl of " + totalRoll + " and the Rock hit you, Lose 1 life");
                    User.hp=User.hp-1;
                    jButton3.setEnabled(true);
                    rockFalling.dispose();
                    repaint();
                }
            }
        });
            
    }
    
    public void eventAtPosition41(){
         JPanel panel = new JPanel();
        JFrame position41 = new JFrame();
        JButton rollStealth = new JButton("Roll");
        JToggleButton userSkill = new JToggleButton("Skill");
       
        //JLabel label1 = new JLabel("Chest");
        
        
         
         panel.setSize(400, 400);
         rollStealth.setBounds(20, 140, 75, 45);
         userSkill.setBounds(110, 140, 75, 45);
         
         if(User.skillUsed==true){
             userSkill.setEnabled(false);
         }
        
       
        position41.setUndecorated(true);
        
        position41.add(rollStealth);
        position41.add(userSkill);
        position41.setSize(200, 200);
        position41.setLocationRelativeTo(null);
        position41.add(panel, BorderLayout.CENTER);
        position41.setVisible(true);
        
        JOptionPane.showMessageDialog(null, "You hear a sound froum the bushes. When you checked you see a giant monster coming yout way. Use stealth to hide from it.");
        
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
                 
               
                
                 if(total>=7){
                    JOptionPane.showMessageDialog(null, "You rolled " + roll +" from dice "+StealthStats + " from  stealth stats " +  " and " + actualSkill+ " from skill for totatl of " + total + " and hid unnoticed");
                   jButton3.setEnabled(true);
                   position41.dispose();
                 }
                 
                 
                 else{
                  JOptionPane.showMessageDialog(null, "You rolled " + roll + " from dice " + StealthStats + " from stealth stats " + " and " + actualSkill+ " from skill for totatl of " + total + " and made a sound, the beast saw you and attacked you. ");
                  JOptionPane.showMessageDialog(null, "You have no choice but to fight  now. Roll 7 or more to defeat the Beast");
                  
                  
                 position41.dispose();
                  
                JPanel panel = new JPanel();
                JFrame fightBeast = new JFrame();
                JButton rollFight = new JButton("Roll");
                JToggleButton userSkill1 = new JToggleButton("Skill");
       
                //JLabel label1 = new JLabel("Chest");
        
      
         
                 panel.setSize(400, 400);
                 rollFight.setBounds(20, 140, 75, 45);
                 userSkill1.setBounds(110, 140, 75, 45);
         
         
                 if(User.skillUsed==true){
                        userSkill1.setEnabled(false);
                    }
       
                fightBeast.setUndecorated(true);
        
                fightBeast.add(rollFight);
                fightBeast.add(userSkill1);
                fightBeast.setSize(200, 200);
                fightBeast.setLocationRelativeTo(null);
                fightBeast.add(panel, BorderLayout.CENTER);
                fightBeast.setVisible(true);
                
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
                 
                 if(total1>=7){
                 JOptionPane.showMessageDialog(null, "You rolled " + roll1 +" from dice "+ RollStats1 + " from Roll stats " +  " and " + actualSkill1+ " from skill for totatl of " + total1 + " and defieted the Beast ");
                   fightBeast.dispose();
                  jButton3.setEnabled(true);
                   
                   
                 }else{
                     JOptionPane.showMessageDialog(null, "You rolled " + roll1 +" from dice "+ RollStats1 + " from Roll stats " +  " and " + actualSkill1+ " from skill for totatl of " + total1 + " and lost the fight and 1 life (-1 life)");
                    fightBeast.dispose();
                    User.hp = User.hp -1;
                   jButton3.setEnabled(true);
                   repaint();
                 }
                          
                      }
                  });
                
                  
               }
               
                 
            }
        });
    }
    
    public void eventAtPosition42(){
        
        JPanel panel = new JPanel();
        JFrame position42 = new JFrame();
        JButton roll = new JButton("Roll");
        JToggleButton userSkill = new JToggleButton("Skill");
       
        //JLabel label1 = new JLabel("Chest");
        
        if(User.skillUsed==true){
             userSkill.setEnabled(false);
         }
         
         panel.setSize(400, 400);
         roll.setBounds(20, 140, 75, 45);
         userSkill.setBounds(110, 140, 75, 45);
         
         
       
        position42.setUndecorated(true);
        position42.add(userSkill);
        position42.add(roll);
        position42.setSize(200, 200);
        position42.setLocationRelativeTo(null);
        position42.add(panel, BorderLayout.CENTER);
        position42.setVisible(true);
        
        JOptionPane.showMessageDialog(null, "You are attacked by Goblins. Roll 7 or more to defeat Them");
        
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
                
                
                
                
                if(totalRoll>=7){
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll + " From dice " + roll + " from stats and " + actualSkill + " from skill, for totatl of " + totalRoll + " and defeated the Goblins");
                    jButton3.setEnabled(true);
                    position42.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll + " From dice " + roll + " from stats and " + actualSkill + " from skill, for totatl of " + totalRoll + " and lost the fight and 1 life (-1 life)");
                    User.hp=User.hp-1;
                    jButton3.setEnabled(true);
                    position42.dispose();
                    repaint();
                }
            }
        });
            
    }
    
    public void eventAtPosition43(){
        JPanel panel = new JPanel();
        JFrame position33 = new JFrame();
        JButton rollEat = new JButton("Drink");
        JButton no = new JButton("Don't");
        
       
       
        //JLabel label1 = new JLabel("Chest");
        
        
         
         panel.setSize(400, 400);
         rollEat.setBounds(20, 140, 75, 45);
         no.setBounds(110, 140, 75, 45);
         
         
       
        position33.setUndecorated(true);
        position33.add(no);
        position33.add(rollEat);
        position33.setSize(200, 200);
        position33.setLocationRelativeTo(null);
        position33.add(panel, BorderLayout.CENTER);
        position33.setVisible(true);
        
            JOptionPane.showMessageDialog(null, "You found watter fountain, and you are verrry thirsty, Do you drink from it?");
            
            rollEat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "You drank from the fountain and gained  1 life (+ 1 life)");
                User.hp = User.hp + 1;
                jButton3.setEnabled(true);
                 position33.dispose();
                repaint();
            }
        });
            no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "You decided not to drink and lost 1 life (-1 life)");
                User.hp = User.hp - 1;
                jButton3.setEnabled(true);
                position33.dispose();
                repaint();
            }
        });
    }
    
    public void eventAtPosition44(){
        jButton3.setEnabled(true);
        JOptionPane.showMessageDialog(null, "Your lucky day! nothing to be found here keep Rolling the Dice");
        
    }
    
    public void eventAtPosition45(){
         JPanel panel = new JPanel();
        JFrame position27 = new JFrame();
        JButton roll = new JButton("Roll");
        JToggleButton userSkill = new JToggleButton("Skill");
       
        //JLabel label1 = new JLabel("Chest");
        
        if(User.skillUsed==true){
             userSkill.setEnabled(false);
         }
         
         panel.setSize(400, 400);
         roll.setBounds(20, 140, 75, 45);
         userSkill.setBounds(110, 140, 75, 45);
         
         
       
        position27.setUndecorated(true);
        position27.add(userSkill);
        position27.add(roll);
        position27.setSize(200, 200);
        position27.setLocationRelativeTo(null);
        position27.add(panel, BorderLayout.CENTER);
        position27.setVisible(true);
        
        JOptionPane.showMessageDialog(null, "You are attacked by One of the escaped prisoners. Roll 7 or more to defeat Him");
        
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
                
                
                
                
                if(totalRoll>=7){
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll + " From dice " + roll + " from stats and " + actualSkill + " from skill, for totatl of " + totalRoll + " and defeated the Prisoner");
                    jButton3.setEnabled(true);
                    position27.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll + " From dice " + roll + " from stats and " + actualSkill + " from skill, for totatl of " + totalRoll + " and lost the fight and 1 life (-1 life)");
                    User.hp=User.hp-1;
                    jButton3.setEnabled(true);
                    position27.dispose();
                    repaint();
                }
            }
        });
    }
    
    public void eventAtPosition26(){
        JPanel panel = new JPanel();
        JFrame position26 = new JFrame();
        JButton rollDodge = new JButton("Roll");
       
       
        //JLabel label1 = new JLabel("Chest");
        
        
         
         panel.setSize(400, 400);
         rollDodge.setBounds(20, 140, 75, 45);
        
         
         
       
        position26.setUndecorated(true);
        
        position26.add(rollDodge);
        position26.setSize(200, 200);
        position26.setLocationRelativeTo(null);
        position26.add(panel, BorderLayout.CENTER);
        position26.setVisible(true);
        
        JOptionPane.showMessageDialog(null, "As Reached a broken rope bridge. Roll 7 or more to jump over to the other side.");
        
        rollDodge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                int min =1;
                int max = 20;
                int random_roll = (int) (Math.random() * (max - min + 1) + min);
                int dodge = User.dodge;
                int totalRoll = random_roll + dodge;
                
                if(totalRoll>=7){
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll + " From dice " + dodge + " from stats for totatl of " + totalRoll + " and jumped over");
                    jButton3.setEnabled(true);
                    position26.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll + " From dice " + dodge + " from stats for totatl of " + totalRoll + " and fell down, Lose 1 life");
                    User.hp=User.hp-1;
                    jButton3.setEnabled(true);
                    position26.dispose();
                    repaint();
                }
            }
        });
    }
    
     public void eventAtPosition27(){
        JPanel panel = new JPanel();
        JFrame position27 = new JFrame();
        JButton roll = new JButton("Roll");
        JToggleButton userSkill = new JToggleButton("Skill");
       
        //JLabel label1 = new JLabel("Chest");
        
        if(User.skillUsed==true){
             userSkill.setEnabled(false);
         }
         
         panel.setSize(400, 400);
         roll.setBounds(20, 140, 75, 45);
         userSkill.setBounds(110, 140, 75, 45);
         
         
       
        position27.setUndecorated(true);
        position27.add(userSkill);
        position27.add(roll);
        position27.setSize(200, 200);
        position27.setLocationRelativeTo(null);
        position27.add(panel, BorderLayout.CENTER);
        position27.setVisible(true);
        
        JOptionPane.showMessageDialog(null, "You are attacked by Bandits. Roll 7 or more to defeat Them");
        
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
                
                
                
                
                if(totalRoll>=7){
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll + " From dice " + roll + " from stats and " + actualSkill + " from skill, for totatl of " + totalRoll + " and defeated the Bandits");
                    jButton3.setEnabled(true);
                    position27.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "You Rolled " + random_roll + " From dice " + roll + " from stats and " + actualSkill + " from skill, for totatl of " + totalRoll + " and lost the fight and 1 life (-1 life)");
                    User.hp=User.hp-1;
                    jButton3.setEnabled(true);
                    position27.dispose();
                    repaint();
                }
            }
        });
    }
     
      public void eventAtPosition46(){
         JOptionPane.showMessageDialog(null, "Your almost reached the city keep going.");
          jButton3.setEnabled(true);
    }
      
     public void eventAtPosition34(){
          JOptionPane.showMessageDialog(null, "It is almost night. You stop to settle for the night.");
         jButton3.setEnabled(true);
     }
    
    public void elfReward(){
        JOptionPane.showMessageDialog(null, "You met the elf you helped in the prison. He is thankfull for your help and give you 15 gold (Gold +15) ");
        User.gold = User.gold +15;
        User.keyUsed = false;
        jButton3.setEnabled(true);
        repaint();
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
