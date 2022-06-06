
package practice;

import java.util.Arrays;
import java.util.HashSet;


public class Practice {

    
    public static void main(String[] args) {
        
        HashSet<Integer> setA = new HashSet<>();
        setA.addAll(Arrays.asList(1,2,3,4));
        
        HashSet<Integer> setB = new HashSet<>();
        setB.addAll(Arrays.asList(1,4,5,6,7));
        
        System.out.println("SetA: " + setA.toString());
        System.out.println("SetB: " + setB.toString());
        
        HashSet<Integer> result = new HashSet<>();
        result.addAll(setA);
        result.addAll(setB);
        
        System.out.println("SetA + SetB: " + result.toString());
        
        HashSet<Integer> temp = new HashSet<>();
        temp.addAll(setB);
        temp.retainAll(setA);
        
        System.out.println(temp.toString());
        
        result.removeAll(temp);
        System.out.println(result.toString());
    }
    
}
