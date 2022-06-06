
package codinexercise2;

import java.io.Serializable;


public class Person implements Serializable{
    
    String name;
    String surname;
    
    public Person(){
        name = "";
        surname = "";
    }
    public Person(String name, String surname){
    this.name = name;
    this.surname = surname;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public String getSurname(){
        return surname;
    }
}

