
package concurentprogramingtutorial5;

import static java.lang.Thread.sleep;
import java.util.Random;


public class ConcurentProgramingTutorial5 extends Thread{

     public  static SharedVariable b = new SharedVariable();
    
    public static void main(String[] args) {
        SimpleThread firstThrd = new SimpleThread( "FirstThread",   2 );
         SimpleThread secondThrd = new SimpleThread( "SecondThread",   5 );
         SharedVariable x = new SharedVariable();
         Reader reader1 = new Reader("Reader -1", x);
         Writer writer1 = new Writer("Writer -1", x);
         
        
         
//         firstThrd.start();
//         secondThrd.start();
         reader1.start();
         writer1.start();
         System.out.println("Main test reader1 status: " + reader1.isAlive());
         System.out.println("Main gets state of reader1: " + writer1.getState());
          System.out.println("Main gets state of writer1: " + reader1.getState());
    }
    
    
    
    
}

class SimpleThread extends Thread{
        private final int oneSecond = 1000;
        private int time = 1;
        
       
        
        public SimpleThread(String str, int time){
            super(str);
            this.time = time;
        }
        public void run(){
            for(int i = 0; i < 10; i++){
                System.out.println(getName() + ": " + i);
                try{
                    sleep((int)(Math.random() * oneSecond * time));
                }
                catch(InterruptedException e){}
            }
        }
    }

class SharedVariable{
    
    private int data;
    
    public SharedVariable(){
        data = 0;
    }
    
    public SharedVariable(int value){
        data = value;
    }
    
    public interface Variable{
        void assign(int valie);
        int value();
        boolean isZero();
        boolean isDivisibleBy(int divisor);
    }
    
    void assign(int value){
        data = value;
    }
    public int getData(){
        return data;
    }
}

class Reader extends Thread{
    
    private Object a;
    private String name = "Reader -1";
    private final int oneSecond = 1000;
    private int time = 1;
   
    
   
  
    
    public Reader(String str, SharedVariable a){
        name=str;
        a = ConcurentProgramingTutorial5.b;
    }
    
    public void run(){
       
        for(int i = 0; i < 10; i++){
               
                System.out.println(name + " read: " +  ConcurentProgramingTutorial5.b.getData() );
                
                try{
                    sleep((int)(Math.random() * oneSecond * time));
                    sleep(2000);
                    
                }
                catch(InterruptedException e){}
        }
    }
}

class   Writer extends Thread{
   private Object a;
    private String name = "Writer -1";
    private final int oneSecond = 1000;
    private int time = 1;
   
    
  
    
    public Writer(String str, SharedVariable a){
        
        name=str;
        a = ConcurentProgramingTutorial5.b;
    }
    
    public void run(){
        for(int i = 0; i < 10; i++){
            
            synchronized(ConcurentProgramingTutorial5.b){
            for(int j=0; j<10;j++){
                ConcurentProgramingTutorial5.b.assign(j);
                System.out.println(name + " write: " +  j );
                try{
                    sleep(2000);
                    sleep((int)(Math.random() * oneSecond * time));
                }
                catch(InterruptedException e){}
            }
                
            }
                ConcurentProgramingTutorial5.b.assign(i);
                System.out.println(name + " write: " +  i );
                try{
                    sleep(2000);
                    sleep((int)(Math.random() * oneSecond * time));
                }
                catch(InterruptedException e){}
        }
    }
}

