/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocatest;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mmiit
 */
public class OCATest {
    
    
     
    
       
     

    public static void main(String[] args) {
        
        System.out.println(isPalindromString("anna"));
        System.out.println(isPalindromString("Kayak"));
       System.out.println(isPalindromString("mitky"));
        
        } 
      
    
    public static boolean isPalindromString(String text){
        String reverse = reverse(text).toLowerCase();
            if(text.toLowerCase().equals(reverse)){
                return true;
            }
            return false;
      }
    
    
    public static String reverse(String input){
        if(input ==null || input.isEmpty()){
            return input;
        }
        
        return input.charAt(input.length()- 1) + reverse(input.substring(0, input.length()-1));
        
    }
    
    
}       




 
    
    





