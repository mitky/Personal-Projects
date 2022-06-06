
package hotel;







class Room {

    
    
private String mainName;
private int roomNum;
 
 public Room(String name, int roomNum) {
     this.mainName = name;
     this.roomNum = roomNum;
 }
 
 //setter
 public void setName(String aName) { mainName = aName; }
 public void setRoomSize(int i){this.roomNum = i;}
 
 //getters
 public String getName() { return mainName;}
 public int getRoomNum() {return roomNum; }
 
 public  String toString(){
     
 return   "Room: " + getRoomNum()  + "     Room name: " + getName()  ;
 }
 public void  display(){
    
     System.out.println(toString());
     
}
    
 
}