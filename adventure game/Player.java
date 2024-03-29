import java.util.*;
public class Player{
  Room location;
  static final int invSize = 20;
  WorldObject[] inventory = new WorldObject[invSize]; //making inventory of size 20
  
  
  public void moveTo(Room position){ //sets current room
    location = position;
  } 
  
  public String getLoc(){ //returns location
    return location.name;
  }
  
  public void pickUp(){  //places object in inventory
    for(int i=0;i<inventory.length;i++){
      if(inventory[i]==null && location.object!=null && location.object.isObtainable){ //if slot in array is empty, there is an object, and it is obtainable
        inventory[i]=location.object;  //object goes in inventory
        System.out.println("You have picked up " + location.object.count + " " + location.object.name);
        location.object=null;  //removes object from world       
        break;  //ends loop so else if portion doesn't print
      }
      else {
        System.out.println("There is nothing to pick up!");
        break;  //ends loop so else if portion only prints once
      }
    }
  }
  
  public void dropItem(String x){
    for(int i=0; i<x.length();i++){
      if(inventory[i]!=null && inventory[i].name.equalsIgnoreCase(x)){  
        location.object = inventory[i];  //putting object in world
        System.out.println("You have dropped " + inventory[i].toString());
        inventory[i] = null;  //deleting object from inventory
        break;  //ends loop so else if portion doesn't print
      }
      else if (inventory[i]==null || !inventory[i].name.equalsIgnoreCase(x)){ 
        {System.out.println("You can't drop that");
          break;  //ends loop so else if portion doesn't print
        }
      }
    }  
  }
  
  public void useItem(String x){
    boolean isLeverPulled;
    for(int i=0; i<x.length();i++){
      if(inventory[i]!=null && inventory[i].name.equalsIgnoreCase(x) && inventory[i].isUseable){  
        if(inventory[i].name.equals("keys") && location==(Main.rooms[5]) && (inventory[i].isLeverPulled)){
          System.out.println("You get in the car and drive away, as the house collapses behind you");
          System.exit(0);
        }
        else if (x.equals("lever") && location.equals(Main.rooms[5])){
        inventory[i].isLeverPulled = true;
        System.out.println("The garage door opens, but it is snowing outside. You wouldn't make it far on foot.");
      }
        
      else if (inventory[i].name.equals("keys") && location.equals(Main.rooms[5])){
        System.out.println("You get in the car, but you notice the garage door is closed.");
      }
      }
    
      else if (inventory[i]==null || !inventory[i].name.equalsIgnoreCase(x)){ 
        System.out.println("You can't use that.");
        break;
        }
      }
    }
  
  public void look(){  //Display items in room 
    if(location.object!=null){
      System.out.println("You look around the " + location + ". You see" + location.object.name);
    }
    else{
      System.out.println("You look around the " + location + ", but you see nothing of value");
    }
  }
}