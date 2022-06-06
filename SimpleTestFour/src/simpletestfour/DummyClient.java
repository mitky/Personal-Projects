
package simpletestfour;

import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DummyClient {

    
    public static void main(String[] args) {
        DummyClient client = new DummyClient();
        client.executeTest();
    }
    
    private void executeTest(){
        DummyServer server = new DummyServer();
        if(server.isConnected()){
            System.out.println("[CLIENT] - The server is connected, the test can procced...");
            
            TemperatureSample s1 = new TemperatureSample();
            s1.value = 10.3;
            s1.location = "London";
            s1.time = new Date();
            System.out.println("[CLIENT] - The sample is : " + s1);
            
            try{
                server.addSample(s1);
            }catch (IOException ex){
                Logger.getLogger(DummyClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            server.getColdestTemperatureIn(s1.location);
            server.getHottestTemperatureIn(s1.location);
            server.getAverageTemperature(s1.location);
            server.getNumberOfSamples(s1.location);
            
            TemperatureSample s2 = new TemperatureSample();
            s2.value = 9.1;
            s2.location = "London";
            s2.time = new Date();
            System.out.println("[CLIENT] - The sample is : " + s2);
            
            try{
                server.addSample(s2);
            }catch (IOException ex){
                Logger.getLogger(DummyClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            server.getColdestTemperatureIn(s2.location);
            server.getHottestTemperatureIn(s2.location);
            server.getAverageTemperature(s2.location);
            server.getNumberOfSamples(s2.location);
            
            TemperatureSample s3 = new TemperatureSample();
            s3.value = 5.1;
            s3.location = "London";
            s3.time = new Date();
            System.out.println("[CLIENT] - The sample is : " + s3);
            
           try{
                server.addSample(s3);
            }catch (IOException ex){
                Logger.getLogger(DummyClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            server.getColdestTemperatureIn(s3.location);
            server.getHottestTemperatureIn(s3.location);
            server.getAverageTemperature(s3.location);
            server.getNumberOfSamples(s3.location);
            
            System.out.println("[CLIENT] - The test has finished.");
        }else{
            System.out.println("[CLIENT] - The server is connected, the test has failed!");
        }
    }
    
}
