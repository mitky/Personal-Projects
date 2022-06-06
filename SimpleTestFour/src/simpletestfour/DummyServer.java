
package simpletestfour;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.util.logging.PlatformLogger;


public class DummyServer {
    
    ArrayList<TemperatureSample> samples = new ArrayList<TemperatureSample>();
    String fileName = "Sample.ser";
    
    public DummyServer(){
        try{
            laodFromFile();
        }catch(IOException ex){
            Logger.getLogger(DummyServer.class.getName()).log(Level.SEVERE, null, ex);
        }catch(ClassNotFoundException ex){
            Logger.getLogger(DummyServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean isConnected(){
        System.out.println("[SERCER] - Testing if server is connected...");
        return true;
    }
    
    public void addSample(TemperatureSample s) throws IOException{
        System.out.println("[SERVER] - Adding " + s + " to " + samples);
        samples.add(s);
        System.out.println("[SERVER] - Samples are " + samples);
    }
    
    public void getColdestTemperatureIn(String city){
        
        double min = (double) samples.get(0).getValue();
        
        for(int i=0;i<samples.size();i++){
            if(city == samples.get(i).getLocation()){
                if(min>samples.get(i).getValue()){
                    min=samples.get(i).getValue();
                }
            }else{
                System.out.println("City doesn't exist");
            }
        }
        System.out.println("The coldest temperature in " + city + " is " + min);
    }
    
    public void getHottestTemperatureIn(String city){
        
        double max = (double) samples.get(0).getValue();
        
        for(int i=0;i<samples.size();i++){
            if(city == samples.get(i).getLocation()){
                if(max<samples.get(i).getValue()){
                    max=samples.get(i).getValue();
                }
            }else{
                System.out.println("City doesn't exist");
            }
        }
        System.out.println("The hottest temperature in " + city + " is " + max);
    }
    
    public void getAverageTemperature(String city){
        int temp = 0;
        double average= 0;
        
        for(int i=0;i<samples.size();i++){
            if(city == samples.get(i).getLocation()){
                average = average + samples.get(i).getValue();
                temp++;
            }else{
                System.out.println("City doesn't exist");
            }
        }
        System.out.println("The average temperature in " + city + " is " + average/temp);
    }
    
    public void getNumberOfSamples(String city){
        int temp=0;
        
        for(int i=0;i<samples.size();i++){
            if(city==samples.get(i).getLocation()){
                temp++;
            }
        }
        System.out.println("The number of samples for " + city + " are " + temp);
    }
    
    private void saveToFile() throws FileNotFoundException, IOException{
        System.out.println("[SERVER] - Saving " + samples + " to file " + fileName );
        
        FileOutputStream file = new FileOutputStream(fileName);
        ObjectOutputStream out = new ObjectOutputStream(file);
        
        out.writeObject(samples);
        
        out.close();
        file.close();
        
        System.out.println("Object has been serialized");
    }
    
    private void laodFromFile() throws FileNotFoundException, IOException, ClassNotFoundException{
        System.out.println("[SERVER] - Loading samples form file " + fileName);
        
        FileInputStream file = new FileInputStream(fileName);
        ObjectInputStream in = new ObjectInputStream(file);
        
        samples = (ArrayList<TemperatureSample>)in.readObject();
        
        in.close();
        file.close();
    }
    
    
}
