/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalyearproject;

/**
 *
 * @author mmiit
 */
public class FinalYearProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
      // ClassSelectction.main(args);
        tryPanel.main(args);
       
        Items commonSword = new Items("Sword", "common",1);
        Items commonCloak = new Items("Cloak", 1,"common");
        Items commonBoots = new Items(1,"Boots","common");
        
        Items.commonItems.add(commonSword);
        Items.commonItems.add(commonCloak);
        Items.commonItems.add(commonBoots);
        
       // User.items.add(commonSword);
       
    }
    
}
