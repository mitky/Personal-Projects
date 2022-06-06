
package assessment;


public class Student {
    private String name;
    private String course;
    private String role; 

   public Student(String name, String course, String role) {
   this.name = name;
   this.course = course;
   this.role = role;
   }
   public Student() {}

   //toString
   public String toString(){
    String string;
    
    return string = "Name: " + getName()+
        "  Course: " + getCourse()+
        "  Role: " + getRole();
       }
    
   //getters
 public String getName() {return this.name;}
 public String getCourse(){return this.course;}
 public String getRole(){return this.role;}
 
 //setters
 public void setName(String newName) {
 if (newName.length() >0)this.name=newName;
 }
 public  void  setCourse(String newCourse){
 if (newCourse.length() >0)course=newCourse;
 }
 public void setRole(String newRole){
 if (newRole.length() >0)role=newRole;
 }
public void  display(){
    
     System.out.println(toString());
     
}






}
