/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalyearproject;

import java.util.ArrayList;




 

public class Items {
    
    public String type;
    public String rarety;
    public int roll;
    public int stealth;
    public int dodge;
    
    
   
   public static ArrayList<Items> commonItems = new ArrayList<Items>();
    
    
    public Items(String type,String rarety,int roll){
        this.type = type;
        this.rarety = rarety;
        this.roll = roll;
    }
    //cloak
    public Items(String type,int stealth,String rarety){
        this.type = type;
        this.rarety = rarety;
        this.stealth = stealth;
    }
    
    //common boots
    public Items(int dodge,String type,String rarety){
        this.type = type;
        this.rarety = rarety;
        this.dodge = dodge;
    }
    
    public Items(String type,String rarety,int roll,int stealth){
        this.type = type;
        this.rarety = rarety;
        this.roll = roll;
        this.stealth = stealth;
    }
    
    public Items(int roll,String type,String rarety,int dodge){
        this.type = type;
        this.rarety = rarety;
        this.roll = roll;
        this.stealth = stealth;
    }
    
    public Items(String type,int stealth,String rarety,int dodge){
        this.type = type;
        this.rarety = rarety;
        this.stealth = stealth;
        this.stealth = stealth;
    }
    
    public Items(){
        
    }
    
    public String getType(){
        return type;
    }
     public String getRarety(){
        return rarety;
    }
     
     public int getRoll(){
        return roll;
    }
      public int getStealth(){
        return stealth;
    }
       public int getDodge(){
        return dodge;
    }
       public void addCommonItemsToArray(Items item){
           commonItems.add(item);
       }
}
