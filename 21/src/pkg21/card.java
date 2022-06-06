
package pkg21;

import java.util.ArrayList;

/**
 *
 * @author mmiit
 */
public class card {
    
    public String path;
    public String name;
    public String boq;
    public int score;
    
    
    public card(String name,String boq,int score,String path){
        this.path = path;
        this.name = name;
        this.boq = boq;
        this.score = score;
        
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public void setBoq(String boq){
        this.boq = boq;
    }
    
    public String getBoq(){
        return boq;
    }
    
    public void setScore(int score){
        this.score = score;
    }
    
    public int getScore(){
        return score;
    }
    
    public void setPath(String path){
        this.path = path;
    }
    
    public String getPath(){
        return path;
    }
    
}
