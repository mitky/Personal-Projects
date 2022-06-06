
package library;


public class Reader {
    
    protected String ID;
    protected String name;
    protected int mobNum;
    protected String email;
    
    public Reader(){
        ID = "";
        name = "";
        mobNum = 0;
        email = "";
    }
    
    public Reader(String id, String name, int tel, String email){
        ID = id;
        this.name = name;
        mobNum = tel;
        this.email = email;
    }
    
    public void setID(String id){
        ID = id;
    }
    
    public String getID(){
        return ID;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public void setMobNum(int tel){
        mobNum = tel;
    }
    
    public int getMobNum(){
        return mobNum;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String toString(){
        return "Reader Info: " + "ID: " + ID + " Name: " + name + " Mobile number: " + mobNum + " Email: " + email;
    }
    
    
}
