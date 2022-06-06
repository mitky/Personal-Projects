
package simpletestfour;

import java.io.Serializable;
import java.util.Date;


public class TemperatureSample implements Serializable {
    
    public double value;
    public String location;
    public Date time;

    @Override
    public String toString() {
        return "TemperatureSample{" + "value=" + value + ", location=" + location + ", time=" + time + '}';
    }
    
    public void setValue(double v){
        value =v;
    }
    public double getValue(){
        return value;
    }
    public void setLocation(String l){
        location = l;
    }
    public String getLocation(){
    return location;
    }
}
