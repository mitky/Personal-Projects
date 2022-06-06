/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mmiit
 */
public class BasicCrypto {

    
    //password encryption and dectription
    
    public static byte[] encrypt(byte[] data) {
        byte[] enc = new byte[data.length];
        
        for(int i = 0; i < data.length; i++){
            enc[i] = (byte) ((i %2 == 0) ? data[i] + 1 : data[i] - 1);
        }
        
        return enc;
    }

    
    public static byte[] decrypt(byte[] data) {
        byte[] dec = new byte[data.length];
        
        for(int i = 0; i < data.length; i++){
            dec[i] = (byte) ((i %2 == 0) ? data[i] - 1 : data[i] + 1);
        }
        
        return dec;
  }
    
}
