/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication33;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mmiit
 */
public class JavaApplication33 {
    
    
    
 
    
    public static void main(String[] args) {
   
        String S = "<<<";
       char up = '^';
       int up1=0;
       char down = 'v';
       int down1 = 0;
        char left = '<';
        int left1=0;
        char right = '>';
        int right1=0;
        int answer=0;

         for(int i=0;i<S.length();i++){
            if(S.charAt(i)==up){
                up1++;
            }
            else if(S.charAt(i)== down){
                down1++;
            }
            else if(S.charAt(i)== right){
                right1++;
            }
            else if(S.charAt(i)== left){
                left1++;
            }
        }
         
         if(up1>down1 && up1>left1 && up1>left1){
              answer = S.length() - up1;
          } 
          if(down1>up1 && down1>left1 && down1>left1){
              answer = S.length() - down1;
          }  
          if(left1>up1 && left1>down1 && left1>right1){
              answer = S.length() - left1;
          } 
          if(right1>up1 && right1>down1 && right1>left1){
              answer = S.length() - right1;
          }  
          System.out.println("Asnwer" + answer);
        }
       
       
   }
    
 
    
    
    
   

