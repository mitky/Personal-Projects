
package library;

//code for DateTime from tutorial
public class DateTime {
    
    protected int day;
    protected int month;
    protected int year;
    protected int hour;
    protected int min;
    
    public DateTime(){
        day=0;
        month=0;
        year=0;
        hour = 0;
        min=0;
    }
    
    public DateTime(int day, int month, int year, int hour, int min){
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.min = min;
    }
    
    public void setDay(int day){
        this.day = day;
    }
    
    public int getDay(){
        return day;
    }
    
    public void setMonth(int month){
        this.month = month;
    }
    
    public int getMonth(){
        return month;
    }
    
    public void setYear(int year){
        this.year = year;
    }
    
    public int getYear(){
        return year;
    }
    
    public void setHour(int hour){
        this.hour = hour;
    }
    
    public int getHour(){
        return hour;
    }
    
    public void setMin(int min){
        this.min = min;
    }
    
    public int getMin(){
        return min;
    }
    
    public String toString(){
        return "Date: " + day + "/" + month + "/" + year + " Time: " + hour + ":" + min; 
    }
    
}
