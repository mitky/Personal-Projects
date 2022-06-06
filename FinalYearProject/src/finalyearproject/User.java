/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalyearproject;

import java.util.ArrayList;

/**
 *
 * @author mmiit
 */
public class User {
    public static String name;
    public static int hp =5;
    public static int roll=0;
    public static int stealth =0;
    public static int dodge =0;
    public static String characterClass;
    public static int position=1;
    public static boolean skillUsed = false;
    public static int gold =0;
   
   
    
    public static boolean keyFound = false;
     public static boolean keyUsed = false;
    
    public static ArrayList<Items> items = new ArrayList<Items>();
    
    public User(String name,String characterClass){
        this.name= name;
        this.characterClass = characterClass;
        hp=5;
    }
    
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
     public void setHP(int hp){
        this.hp=hp;
    }
    public int getHP(){
        return hp;
    }
}
