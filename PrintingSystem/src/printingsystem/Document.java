/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printingsystem;

/**
 *
 * @author mmiit
 */
public class Document {
    private String studentName;
    private String docName;
    private int pages;
    
    public Document(String sName, String dName, int p){
        studentName = sName;
        docName = dName;
        pages = p;
    }
    
    public void setName(String name){
        studentName = name;
    }
    public String getStudentName(){
        return studentName;
    }
    public void setDocName(String name){
        docName = name;
    }
    public String getDocName(){
        return docName;
    }
    public void setPages(int p){
        pages = p;
    }
    public int getPages(){
        return pages;
    }
}
