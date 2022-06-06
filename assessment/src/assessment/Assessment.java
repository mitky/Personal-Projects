
package assessment;


public class Assessment {

    public static void main(String[] args) {
        
      Student[] student = new Student[4];  
        
      student[0] = new Student("Bob","CG","Lead programmer");
      student[1] = new Student("Jen","CG","Designer");
      student[2] = new Student("Bruce","CG","AI");
      student[3] = new Student("Jan","CG","Play");

      
      for (int i = 0;i<4;i++){
        student[i].display();
      }


    }
   
}
