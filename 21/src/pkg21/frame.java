package pkg21;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;




public class frame extends javax.swing.JFrame {
    
   private  Image pic = null;
   private Image pic1 = null;
   private Image pic2 = null;
   private Image pic3 = null;
   private Image pic4 = null;
   private Image pic5 = null;
   private Image pic6 = null;
   private Image pic7 = null;
   private Image pic8 = null;
   private Image pic9 = null;
   private  Image pic10 = null;
   private Image pic11 = null;
   private Image pic12 = null;
   
   private Image pic14 = null;
   private Image pic15 = null;
   private Image pic16 = null;
   private Image pic17 = null;
   
   private Image mat = null;
   public int position = 0; //fowols position of the cards for player
   public int position1 = 0;  //folows position of the cards for dealer
   public int score = 0;  //score for the player
   public int score1 = 0;  //score for the dealer
   public boolean ace = false;  //checks if there is one ace on the board
   public boolean ace1 = false;  //checks if there is more then one ace on the board for ajustuing the score
   public boolean ace2 = false;
   public boolean ace3 = false;
   public boolean ace4 = false;
   public boolean ace5 = false;
   public boolean hold = false;//checks if the hold button is pressed
   public boolean win = false; //checks if the game is won
    public boolean lose = false;//checks if the game is lost
   public boolean endGame = false;  //booleand for end game so it can be resetet from new game button
   public static boolean dealt = false;  //checks if the cards have been dealt so the card button is off or on
   private boolean four = false;
  
  static JLabel jLabel2 = new JLabel();
  
                
   
   
  static card card1 = new card("two","clover",2, "C:\\Users\\mmiit\\Pictures\\pics\\PNG\\2C.png");
  static card card2 = new card("two","diamond",2,"C:\\Users\\mmiit\\Pictures\\pics\\PNG\\2D.png");
  static card card3 = new card("two","heart",2,"C:\\Users\\mmiit\\Pictures\\pics\\PNG\\2H.png");
  static card card4 = new card("two","spade",2,"C:\\Users\\mmiit\\Pictures\\pics\\PNG\\2S.png");
  static card card5 = new card("three","clover",3, "C:\\Users\\mmiit\\Pictures\\pics\\PNG\\3C.png");
  static card card6 = new card("three","diamond",3,"C:\\Users\\mmiit\\Pictures\\pics\\PNG\\3D.png");
  static card card7 = new card("three","heart",3,"C:\\Users\\mmiit\\Pictures\\pics\\PNG\\3H.png");
  static card card8 = new card("three","spade",3,"C:\\Users\\mmiit\\Pictures\\pics\\PNG\\3S.png");
  static card card9 = new card("four","clover",4, "C:\\Users\\mmiit\\Pictures\\pics\\PNG\\4C.png");
  static card card10 = new card("four","diamond",4,"C:\\Users\\mmiit\\Pictures\\pics\\PNG\\4D.png");
  static card card11 = new card("four","heart",4,"C:\\Users\\mmiit\\Pictures\\pics\\PNG\\4H.png");
  static card card12 = new card("four","spade",4,"C:\\Users\\mmiit\\Pictures\\pics\\PNG\\4S.png");
  static card card13 = new card("five","clover",5, "C:\\Users\\mmiit\\Pictures\\pics\\PNG\\5C.png");
  static card card14 = new card("five","diamond",5,"C:\\Users\\mmiit\\Pictures\\pics\\PNG\\5D.png");
  static card card15 = new card("five","heart",5,"C:\\Users\\mmiit\\Pictures\\pics\\PNG\\5H.png");
  static card card16 = new card("five","spade",5,"C:\\Users\\mmiit\\Pictures\\pics\\PNG\\5S.png");
  static card card17 = new card("six","clover",6, "C:\\Users\\mmiit\\Pictures\\pics\\PNG\\6C.png");
  static card card18 = new card("six","diamond",6,"C:\\Users\\mmiit\\Pictures\\pics\\PNG\\6D.png");
  static card card19 = new card("six","heart",6,"C:\\Users\\mmiit\\Pictures\\pics\\PNG\\6H.png");
  static card card20 = new card("six","spade",6,"C:\\Users\\mmiit\\Pictures\\pics\\PNG\\6S.png");
  static card card21 = new card("seven","clover",7, "C:\\Users\\mmiit\\Pictures\\pics\\PNG\\7C.png");
  static card card22 = new card("seven","diamond",7,"C:\\Users\\mmiit\\Pictures\\pics\\PNG\\7D.png");
  static card card23 = new card("seven","heart",7,"C:\\Users\\mmiit\\Pictures\\pics\\PNG\\7H.png");
  static card card24 = new card("seven","spade",7,"C:\\Users\\mmiit\\Pictures\\pics\\PNG\\7S.png");
  static card card25 = new card("eight","clover",8, "C:\\Users\\mmiit\\Pictures\\pics\\PNG\\8C.png");
  static card card26 = new card("eight","diamond",8,"C:\\Users\\mmiit\\Pictures\\pics\\PNG\\8D.png");
  static card card27 = new card("eight","heart",8,"C:\\Users\\mmiit\\Pictures\\pics\\PNG\\8H.png");
  static card card28 = new card("eight","spade",8,"C:\\Users\\mmiit\\Pictures\\pics\\PNG\\8S.png");
  static card card29 = new card("nine","clover",9, "C:\\Users\\mmiit\\Pictures\\pics\\PNG\\9C.png");
  static card card30 = new card("nine","diamond",9,"C:\\Users\\mmiit\\Pictures\\pics\\PNG\\9D.png");
  static card card31 = new card("nine","heart",9,"C:\\Users\\mmiit\\Pictures\\pics\\PNG\\9H.png");
  static card card32 = new card("nine","spade",9,"C:\\Users\\mmiit\\Pictures\\pics\\PNG\\9S.png");
  static card card33 = new card("ten","clover",10, "C:\\Users\\mmiit\\Pictures\\pics\\PNG\\10C.png");
  static card card34 = new card("ten","diamond",10,"C:\\Users\\mmiit\\Pictures\\pics\\PNG\\10D.png");
  static card card35 = new card("ten","heart",10,"C:\\Users\\mmiit\\Pictures\\pics\\PNG\\10H.png");
  static card card36 = new card("ten","spade",10,"C:\\Users\\mmiit\\Pictures\\pics\\PNG\\10S.png");
  static card card37 = new card("jack","clover",10, "C:\\Users\\mmiit\\Pictures\\pics\\PNG\\JC.png");
  static card card38 = new card("jack","diamond",10,"C:\\Users\\mmiit\\Pictures\\pics\\PNG\\JD.png");
  static card card39 = new card("jack","heart",10,"C:\\Users\\mmiit\\Pictures\\pics\\PNG\\JH.png");
  static card card40 = new card("jack","spade",10,"C:\\Users\\mmiit\\Pictures\\pics\\PNG\\JS.png");
  static card card41 = new card("queen","clover",10, "C:\\Users\\mmiit\\Pictures\\pics\\PNG\\QC.png");
  static card card42 = new card("queen","diamond",10,"C:\\Users\\mmiit\\Pictures\\pics\\PNG\\QD.png");
  static card card43 = new card("queen","heart",10,"C:\\Users\\mmiit\\Pictures\\pics\\PNG\\QH.png");
  static card card44 = new card("queen","spade",10,"C:\\Users\\mmiit\\Pictures\\pics\\PNG\\QS.png");
  static card card45 = new card("king","clover",10, "C:\\Users\\mmiit\\Pictures\\pics\\PNG\\KC.png");
  static card card46 = new card("king","diamond",10,"C:\\Users\\mmiit\\Pictures\\pics\\PNG\\KD.png");
  static card card47 = new card("king","heart",10,"C:\\Users\\mmiit\\Pictures\\pics\\PNG\\KH.png");
  static card card48 = new card("king","spade",10,"C:\\Users\\mmiit\\Pictures\\pics\\PNG\\KS.png");
  static card card49 = new card("ace","clover",11, "C:\\Users\\mmiit\\Pictures\\pics\\PNG\\AC.png");
  static card card50 = new card("ace","diamond",11,"C:\\Users\\mmiit\\Pictures\\pics\\PNG\\AD.png");
  static card card51 = new card("ace","heart",11,"C:\\Users\\mmiit\\Pictures\\pics\\PNG\\AH.png");
  static card card52 = new card("ace","spade",11,"C:\\Users\\mmiit\\Pictures\\pics\\PNG\\AS.png");
  
   
  static ArrayList<card> deck = new ArrayList<card>();
  
  //reset after ended game or new game button is presed
 public void reset(){
    position=0;
    position1=0;
    score = 0;
    score1 = 0;
    endGame=true;
    ace = false;
    ace1 = false;
    ace2 = false;
    ace3 = false;
    hold=false;
    Card.setEnabled(false);
    Hold.setEnabled(false);
    deal.setEnabled(true);
//    card=null;  
//    score5 = 0;
//    name = null;
//    pic13=null;
    four=false;
    
    //repaint();
 }
  
  //function for lost game
public void lose(){
  
    JOptionPane.showMessageDialog(this, "LOSE");
    
     
    
    lose=true;
    reset();
   
}  
 //function for won game
public void win(){
    
    JOptionPane.showMessageDialog(this, "WIN");
   
    win=true;
    reset();
    
    
   
    
    
}

public void check17(){
    if (score1>=17){
         checkScore();
    }
    else{
        position1++;
        repaint();
       
    }
}


  //function for checking the score
public void checkScore(){
    if(score==21){
        win();
    }
     if(score>21){
        lose();
    }
    
    if(score1==21){
        lose();
    }
    
    if(score1>21){
        win();
    }
    
    
    
    if(score1>score && score1<=21 && hold==true){
        lose();
    }
    
   if(score>score1 && score<=21  && hold==true){
        win();
    }
    
}
//function that check if the drawn card for the player is ace and to decide if its counting it as 11 or as 1
public  void checkCard(String  name,int score){
    
     if(name == "ace" && ace == false){
         ace = true;
     }
    
     
     
     this.score = this.score + score;
     
     if(ace && this.score>21){
         ace = false;
         this.score = this.score - 10;
     }
    
     
     
     
}

   //function that check if the drawn card for the dealer is ace and to decide if its counting it as 11 or as 1
public  void checkCard1(String  name,int score){
    
     if(name == "ace" && ace3 == false){
         ace3 = true;
     }
    
     
     
     this.score1 = this.score1 + score;
     
     if(ace3 && this.score1>21){
         ace3=false;
         this.score1 = this.score1 - 10;
     }
      
     
//      if(ace3 && this.score1<21 && this.score1<this.score){
//         this.score1 = this.score1 - 10;
//     }
     
     
     
}
  //finction for generating random number to draw from the deck
  public int getRandomNumber(){
  
      Random rand = new Random();
        
      int int_rand = rand.nextInt(52);
      
      return int_rand;
   }
    //function that loads the pic for the cards
   public  void loadpics(String path){
        
        mat = new ImageIcon("C:\\Users\\mmiit\\Pictures\\pics\\mat3.jpg").getImage();
        

        if(position1==0){
            pic8 = new ImageIcon(path).getImage();
            repaint();
        }
        
        if(position==0){
        pic = new ImageIcon(path).getImage();
        repaint();
        
        }
        
        if(position==1){
        pic1 = new ImageIcon(path).getImage();
        
        repaint();
        }
        
        
        
        if(position==2){
            pic2 = new ImageIcon(path).getImage();
            repaint();
        }
        
        if(position==3){
            pic3 = new ImageIcon(path).getImage();
            repaint();
        }
        
        if(position==4){
            pic4 = new ImageIcon(path).getImage();
            repaint();
        }
        
        if(position==5){
            pic5 = new ImageIcon(path).getImage();
            repaint();
        }
        if(position==6){
            pic6 = new ImageIcon(path).getImage();
            repaint();
        }
        
        if(position1==1){
            pic7 = new ImageIcon(path).getImage();
            repaint();
        }
        
        
        
        
    }
   
   
    //paint function that paints the cards on the screen
    public  void paint(Graphics g){
       
           Graphics2D g2 = (Graphics2D)g;
           g.drawImage(mat,0,0,1950, 1050, null);
           g.setFont(new Font("TimesRoman", Font.PLAIN,30));
           g.drawString("Score   " + score, 900, 550);
           g.drawString("Score   " + score1, 900, 500);
            
            
           
           
           
           g.drawRect(404, 861, 226, 66);
           g.drawString("Deal   ", 485, 905);
            
           g.drawRect(665, 861, 226, 66);
           g.drawString("Card   ", 740, 905);
           
           g.drawRect(941, 861, 226, 66);
           g.drawString("Hold   ", 1023, 905);
           
           g.drawRect(1205, 861, 226, 66);
           g.drawString("New Game   ", 1245, 905);
          
           
           
            
          
          
          
          
          
          
          //the postion of the cards is incremented if there is card on the board then next will be displayed in different position
          
          if(position == 2 && position1 == 1){
               g.drawImage(pic,700, 600, 150, 150, null);
               g.drawImage(pic1,950, 600, 150, 150, null);
               g.drawImage(pic8,700, 300, 150, 150, null);//dealer card
               
               checkScore();
            }
          
          if(position == 3 && position1==1){
              g.drawImage(pic,500, 600, 150, 150, null);
              g.drawImage(pic1,750, 600, 150, 150, null);
              g.drawImage(pic8,700, 300, 150, 150, null);//dealer card
              g.drawImage(pic2,1000, 600, 150, 150, null);
               
              checkScore();
          }
          
          if(position == 4 && position1==1){
              g.drawImage(pic,300, 600, 150, 150, null);
              g.drawImage(pic1,550, 600, 150, 150, null);
              g.drawImage(pic8,700, 300, 150, 150, null);//dealer card
              g.drawImage(pic2,800, 600, 150, 150, null);
              g.drawImage(pic3,1050, 600, 150, 150, null);
               
              checkScore();
          }
          
          if(position == 5 && position1==1){
              g.drawImage(pic,200, 600, 150, 150, null);
              g.drawImage(pic1,450, 600, 150, 150, null);
              g.drawImage(pic8,700, 300, 150, 150, null);//dealer card
              g.drawImage(pic2,700, 600, 150, 150, null);
              g.drawImage(pic3,950, 600, 150, 150, null);
              g.drawImage(pic4,1200, 600, 150, 150, null);
              checkScore();
          }
          
          if(position == 6 && position1==1){
              g.drawImage(pic,200, 600, 150, 150, null);
              g.drawImage(pic1,450, 600, 150, 150, null);
              g.drawImage(pic8,700, 300, 150, 150, null);//dealer card
              g.drawImage(pic2,700, 600, 150, 150, null);
              g.drawImage(pic3,950, 600, 150, 150, null);
              g.drawImage(pic4,1200, 600, 150, 150, null);
              g.drawImage(pic5,1450, 600, 150, 150, null);
              checkScore();
          }
          
         
          
          
          
          if(position1 == 3 && position == 2){
              
                int rand = getRandomNumber();
                
                String card = deck.get(rand).getPath();
                String name = deck.get(rand).getName();
                int score = deck.get(rand).getScore();
            
                pic9 = new ImageIcon(card).getImage();
                checkCard1(name,score);
                
                
                
               g.drawImage(pic,700, 600, 150, 150, null);
               g.drawImage(pic1,950, 600, 150, 150, null);
               g.drawImage(pic8,700, 300, 150, 150, null);//dealer card
               g.drawImage(pic7,900, 300, 150, 150, null);//dealer card
               g.drawImage(pic9,1100, 300, 150, 150, null);//dealer card
              
               
             // score1 = score1 + score;
             
             
              
             if(score1<this.score && score1<17){
                 int rand3 = getRandomNumber();
                four=true;
                String card3 = deck.get(rand3).getPath();
                String name3 = deck.get(rand3).getName();
                int score3 = deck.get(rand3).getScore();
            
                pic10 = new ImageIcon(card3).getImage();
                checkCard1(name3,score3);
                
                
                
               g.drawImage(pic,700, 600, 150, 150, null);
               g.drawImage(pic1,950, 600, 150, 150, null);
               g.drawImage(pic8,700, 300, 150, 150, null);//dealer card
               g.drawImage(pic7,900, 300, 150, 150, null);//dealer card
               g.drawImage(pic9,1100, 300, 150, 150, null);//dealer card
               g.drawImage(pic10,1300, 300, 150, 150, null);//dealer card
              
               
             // score1 = score1 + score;
              g.drawString("Score   " + this.score, 1100, 550);
              g.drawString("Score   " + score1, 1100, 500);
              checkScore();
              //repaint();
             
             }
             
              g.drawString("Score   " + this.score, 1100, 550);
              g.drawString("Score   " + score1, 1100, 500);
             
              
              
              checkScore();
            }
          
         
              

          
           if(position1==2 && position == 2){
               g.drawImage(pic,700, 600, 150, 150, null);
               g.drawImage(pic1,950, 600, 150, 150, null);
               g.drawImage(pic8,700, 300, 150, 150, null);//dealer card
               g.drawImage(pic7,900, 300, 150, 150, null);//dealer card
               g.drawString("Score   " + score, 1100, 550);
               g.drawString("Score   " + score1, 1100, 500);
               check17();
               
              
               
            }
          
          if(position1==2 && position ==3){
               g.drawImage(pic,500, 600, 150, 150, null);
               g.drawImage(pic1,750, 600, 150, 150, null);
               g.drawImage(pic8,700, 300, 150, 150, null);//dealer card
               g.drawImage(pic7,900, 300, 150, 150, null);//dealer card
               g.drawImage(pic2,1000, 600, 150, 150, null);
               g.drawString("Score   " + score, 1100, 550);
               g.drawString("Score   " + score1, 1100, 500);
              System.out.println(position);
               System.out.println(position1);
              check17();
              
              }
          
          
         if(position1==2 && position ==4){
               g.drawImage(pic,300, 600, 150, 150, null);
               g.drawImage(pic1,550, 600, 150, 150, null);
               g.drawImage(pic8,700, 300, 150, 150, null);//dealer card
               g.drawImage(pic7,900, 300, 150, 150, null);//dealer card
               g.drawImage(pic2,800, 600, 150, 150, null);
               g.drawImage(pic3,1050, 600, 150, 150, null);
              
              
              
             
                
             
            
             if(score1<17){
                  int rand = getRandomNumber();
                
                String card = deck.get(rand).getPath();
                String name = deck.get(rand).getName();
                int score = deck.get(rand).getScore();
            
                pic11 = new ImageIcon(card).getImage();
                checkCard1(name,score);
                
                 g.drawImage(pic,300, 600, 150, 150, null);
               g.drawImage(pic1,550, 600, 150, 150, null);
               g.drawImage(pic8,700, 300, 150, 150, null);//dealer card
               g.drawImage(pic7,900, 300, 150, 150, null);//dealer card
               g.drawImage(pic11,1100, 300, 150, 150, null);//dealer card
               g.drawImage(pic2,800, 600, 150, 150, null);
               g.drawImage(pic3,1050, 600, 150, 150, null);
               
               
               if(score1<17){
                   int rand1 = getRandomNumber();
                
                String card1 = deck.get(rand1).getPath();
                String name1 = deck.get(rand1).getName();
                int score1 = deck.get(rand1).getScore();
            
                pic12 = new ImageIcon(card1).getImage();
                checkCard1(name1,score1);
                
                 g.drawImage(pic,300, 600, 150, 150, null);
               g.drawImage(pic1,550, 600, 150, 150, null);
               g.drawImage(pic8,700, 300, 150, 150, null);//dealer card
               g.drawImage(pic7,900, 300, 150, 150, null);//dealer card
               g.drawImage(pic11,1100, 300, 150, 150, null);//dealer card
               g.drawImage(pic12,1300, 300, 150, 150, null);//dealer card
               g.drawImage(pic2,800, 600, 150, 150, null);
               g.drawImage(pic3,1050, 600, 150, 150, null);
               
               
                    g.drawString("Score   " + this.score, 1100, 550);
                     g.drawString("Score   " + this.score1, 1100, 500);
                     checkScore();
               }
               
               
               
               g.drawString("Score   " + this.score, 1100, 550);
             g.drawString("Score   " + score1, 1100, 500);
           
             checkScore();
                 
             }
             g.drawString("Score   " + this.score, 1100, 550);
             g.drawString("Score   " + score1, 1100, 500);
           
             checkScore();
             
              }
         
         
       
         
         
         if(position1==2 && position ==5){
               g.drawImage(pic,300, 600, 150, 150, null);
               g.drawImage(pic1,550, 600, 150, 150, null);
               g.drawImage(pic8,700, 300, 150, 150, null);//dealer card
               g.drawImage(pic7,900, 300, 150, 150, null);//dealer card
               g.drawImage(pic2,800, 600, 150, 150, null);
               g.drawImage(pic3,1050, 600, 150, 150, null);
               g.drawImage(pic4,1250, 600, 150, 150, null);
              
              
              
             
                
             
            
             if(score1<17){
                  int rand = getRandomNumber();
                
                String card = deck.get(rand).getPath();
                String name = deck.get(rand).getName();
                int score = deck.get(rand).getScore();
            
                pic11 = new ImageIcon(card).getImage();
                checkCard1(name,score);
                
                 g.drawImage(pic,300, 600, 150, 150, null);
               g.drawImage(pic1,550, 600, 150, 150, null);
               g.drawImage(pic8,700, 300, 150, 150, null);//dealer card
               g.drawImage(pic7,900, 300, 150, 150, null);//dealer card
               g.drawImage(pic11,1100, 300, 150, 150, null);//dealer card
               g.drawImage(pic2,800, 600, 150, 150, null);
               g.drawImage(pic3,1050, 600, 150, 150, null);
               g.drawImage(pic4,1250, 600, 150, 150, null);
               
               
               if(score1<17){
                   int rand1 = getRandomNumber();
                
                String card1 = deck.get(rand1).getPath();
                String name1 = deck.get(rand1).getName();
                int score1 = deck.get(rand1).getScore();
            
                pic12 = new ImageIcon(card1).getImage();
                checkCard1(name1,score1);
                
                 g.drawImage(pic,300, 600, 150, 150, null);
               g.drawImage(pic1,550, 600, 150, 150, null);
               g.drawImage(pic8,700, 300, 150, 150, null);//dealer card
               g.drawImage(pic7,900, 300, 150, 150, null);//dealer card
               g.drawImage(pic11,1100, 300, 150, 150, null);//dealer card
               g.drawImage(pic12,1300, 300, 150, 150, null);//dealer card
               g.drawImage(pic2,800, 600, 150, 150, null);
               g.drawImage(pic3,1050, 600, 150, 150, null);
               g.drawImage(pic4,1250, 600, 150, 150, null);
               
               
                    g.drawString("Score   " + this.score, 1100, 550);
                     g.drawString("Score   " + this.score1, 1100, 500);
                     checkScore();
               }
               
               
               
               g.drawString("Score   " + this.score, 1100, 550);
             g.drawString("Score   " + score1, 1100, 500);
           
             checkScore();
                 
             }
             g.drawString("Score   " + this.score, 1100, 550);
             g.drawString("Score   " + score1, 1100, 500);
           
             checkScore();
             
              }
        
         
         
         
         if(position1==4 && position ==3){
             
             int rand = getRandomNumber();
                
                String card = deck.get(rand).getPath();
                String name = deck.get(rand).getName();
                int score = deck.get(rand).getScore();
            
                pic11 = new ImageIcon(card).getImage();
                checkCard1(name,score);
             
               g.drawImage(pic,500, 600, 150, 150, null);
               g.drawImage(pic1,750, 600, 150, 150, null);
               g.drawImage(pic8,700, 300, 150, 150, null);//dealer card
               g.drawImage(pic7,900, 300, 150, 150, null);//dealer card
               g.drawImage(pic11,1100, 300, 150, 150, null);//dealer card
               g.drawImage(pic2,1000, 600, 150, 150, null);
               
              if(score1<this.score && score1<17){
               int rand3 = getRandomNumber();
              four=true;
              String card3 = deck.get(rand3).getPath();
                String name3 = deck.get(rand3).getName();
                int score3 = deck.get(rand3).getScore();
            
                pic10 = new ImageIcon(card3).getImage();
                checkCard1(name3,score3);
                
                
                
                g.drawImage(pic,500, 600, 150, 150, null);
               g.drawImage(pic1,750, 600, 150, 150, null);
               g.drawImage(pic8,700, 300, 150, 150, null);//dealer card
               g.drawImage(pic7,900, 300, 150, 150, null);//dealer card
               g.drawImage(pic11,1100, 300, 150, 150, null);//dealer card
               g.drawImage(pic10,1300, 300, 150, 150, null);//dealer card
                g.drawImage(pic2,1000, 600, 150, 150, null);
              
               
             // score1 = score1 + score;
              g.drawString("Score   " + this.score, 1100, 550);
              g.drawString("Score   " + score1, 1100, 500);
              checkScore();
                 }
                
                
              
              g.drawString("Score   " + this.score, 1100, 550);
              g.drawString("Score   " + score1, 1100, 500);
              checkScore();
               
              }
          
          if(position1==3 && position ==3){
              
//               int rand = getRandomNumber();
//              
//               String card = deck.get(rand).getPath();
//                String name = deck.get(rand).getName();
//                int score = deck.get(rand).getScore();
//            
//                pic14 = new ImageIcon(card).getImage();
//                checkCard1(name,score);
              
               g.drawImage(pic,500, 600, 150, 150, null);
               g.drawImage(pic1,750, 600, 150, 150, null);
               g.drawImage(pic8,700, 300, 150, 150, null);//dealer card
               g.drawImage(pic7,900, 300, 150, 150, null);//dealer card
               g.drawImage(pic2,1000, 600, 150, 150, null);
               
                g.drawString("Score   " + this.score, 1100, 550);
                g.drawString("Score   " + score1, 1100, 500);
                
               System.out.println(position);
               System.out.println(position1);
               check17();
               
              
              //repaint();
             
              }
          
         
          
          
          
    }

    
    public frame() {
        
        
        
        
         
        loadpics("C:\\Users\\mmiit\\Pictures\\pics\\mat3.jpg");
        
        initComponents();
      
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        Card = new javax.swing.JButton();
        newGame = new javax.swing.JButton();
        deal = new javax.swing.JButton();
        Hold = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Card.setText("Card");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, Card, org.jdesktop.beansbinding.ELProperty.create("${selected}"), Card, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        Card.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CardActionPerformed(evt);
            }
        });

        newGame.setText("New   Game");
        newGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameActionPerformed(evt);
            }
        });

        deal.setText("Deal");
        deal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dealActionPerformed(evt);
            }
        });

        Hold.setText("Hold");
        Hold.setEnabled(false);
        Hold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HoldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(396, 396, 396)
                .addComponent(deal, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(Card, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(Hold, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(newGame, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(174, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Card, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newGame, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deal, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Hold, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(112, 112, 112))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CardActionPerformed
      
        //draw a random card from the deck and check the name if is is and ace and the score
        
        int rand = getRandomNumber();
        String card = deck.get(rand).getPath();
        String name = deck.get(rand).getName();
        int score = deck.get(rand).getScore();
        
        
       
        checkCard(name,score);
        loadpics(card);
        position++;
        
        
        endGame = false;
       
        
    }//GEN-LAST:event_CardActionPerformed

    private void newGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameActionPerformed
       
        score=0;
        position=0;
        score1=0;
        position1=0;
        
        repaint();
        hold=false;
        Card.setEnabled(false);
        Hold.setEnabled(false);
        deal.setEnabled(true);
    }//GEN-LAST:event_newGameActionPerformed

    private void dealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dealActionPerformed
       
        //deal button displays 3 cards and the begining of the game
        
       int rand = getRandomNumber();
       int rand1 = getRandomNumber();
       int rand2 = getRandomNumber();
       int rand3 = getRandomNumber();
       
       String card = deck.get(rand).getPath();
       String card1 = deck.get(rand1).getPath();
       String card2 = deck.get(rand2).getPath();
       String card3 = deck.get(rand3).getPath();
       
       String name = deck.get(rand).getName();
       String name1 = deck.get(rand1).getName();
       String name2 = deck.get(rand2).getName();
       String name3 = deck.get(rand3).getName();
       
       int score = deck.get(rand).getScore();
       int score1 = deck.get(rand1).getScore();
       int score2 = deck.get(rand2).getScore();
       int score3 = deck.get(rand3).getScore();
        


        dealt = true;  
        loadpics(card);
        checkCard(name,score);
        position++;
        
        loadpics(card1);
        checkCard(name1,score1);
        position++;
       
        
        checkCard1(name2,score2);
        loadpics(card2);
        position1++;
       
        Card.setEnabled(true);  //means now the card button is active
        Hold.setEnabled(true);
        deal.setEnabled(false);  //and the deal button is off
        hold=false;
        
    }//GEN-LAST:event_dealActionPerformed

    private void HoldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HoldActionPerformed
       
        hold = true;
        Card.setEnabled(false);
        
        int rand = getRandomNumber();
        
        
        String card = deck.get(rand).getPath();
        String name = deck.get(rand).getName();
        int score = deck.get(rand).getScore();
        
       
        
        loadpics(card);
        checkCard1(name,score);
        position1++;
        
       
        
    }//GEN-LAST:event_HoldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
                
             
                
                 
               // new frame().setVisible(true);
                
                
                
        
        deck.add(card1);
        deck.add(card2);
        deck.add(card3);
        deck.add(card4);
        deck.add(card5);
        deck.add(card6);
        deck.add(card7);
        deck.add(card8);
        deck.add(card9);
        deck.add(card10);
        deck.add(card11);
        deck.add(card12);
        deck.add(card13);
        deck.add(card14);
        deck.add(card15);
        deck.add(card16);
        deck.add(card17);
        deck.add(card18);
        deck.add(card19);
        deck.add(card20);
        deck.add(card21);
        deck.add(card22);
        deck.add(card23);
        deck.add(card24);
        deck.add(card25);
        deck.add(card26);
        deck.add(card27);
        deck.add(card28);
        deck.add(card29);
        deck.add(card30);
        deck.add(card31);
        deck.add(card32);
        deck.add(card33);
        deck.add(card34);
        deck.add(card35);
        deck.add(card36);
        deck.add(card37);
        deck.add(card38);
        deck.add(card39);
        deck.add(card40);
        deck.add(card41);
        deck.add(card42);
        deck.add(card42);
        deck.add(card44);
        deck.add(card45);
        deck.add(card46);
        deck.add(card47);
        deck.add(card48);
        deck.add(card49);
        deck.add(card50);
        deck.add(card51);
        deck.add(card52);
        
       
        
       
        
        
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
             
                JLabel jLabel3 = new JLabel("mitky",JLabel.CENTER);
                jLabel3.setAlignmentX(100);
                jLabel3.setAlignmentY(100);
                jLabel3.setVisible(true);
                jLabel3.setBackground(new Color(0,0,0,0));
                
               
                
                JFrame frame = new frame();
                frame.setVisible(true);
               
                frame.add(jLabel3);
               
               
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Card;
    private javax.swing.JButton Hold;
    private javax.swing.JButton deal;
    private static javax.swing.JButton newGame;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    private void update(Image pic1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
