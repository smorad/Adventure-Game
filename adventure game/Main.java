import java.util.*;
import java.io.*;
public class Main{
  static final int numRooms = 6; //Number of rooms. Theoretically could make more, but we only created names for 6 rooms.
  static Room[] rooms = new Room[numRooms]; //Static array of rooms to make everything easier
  
  public static void main(String[] args) {
    System.out.println("You awake in an old mansion you have never been to before. You can't seem to remember anything about yourself or how you got here. You get the feeling that someone is watching you.");
    System.out.println("Type 'help' for help.");
    printInstructions();
    buildWorld();  //Sets room connections
    createWorldObject();  //Creates objects and puts them in rooms
    Player player = new Player();
    player.moveTo(rooms[0]);  //Set player location to Antechamber
    play(player);  //Reads system.in and calls functions accordingly
  }
  
  public static void buildWorld(){
    for(int i=0; i<rooms.length; i++){
      rooms[i]= new Room();
    }
    for (int i=0; i<rooms.length; i++){
      rooms[i].setConnections();  //Setting room connections
    }
    rooms[0].setName("Antechamber");
    rooms[1].setName("Conservatory");
    rooms[2].setName("Billiard Room");
    rooms[3].setName("Library");
    rooms[4].setName("Parlor");
    rooms[5].setName("Carraige House");
    
  }
  
  public static Room random(){  //Function to assign room connections randomly
    double x = 6*Math.random();
    if (x<1){
      return Main.rooms[0];
    }
    else if (x>1 && x<2){
      return Main.rooms[1];
    }
    else if (x>2 && x<3){
      return Main.rooms[2];
    }
    else if (x>3 && x<4){
      return Main.rooms[3];
    }
    else if (x>4 && x<5){
      return Main.rooms[4];
    }
    else return Main.rooms[5];
  }
  
  public static void play(Player x){
    Scanner input = new Scanner(System.in);
    while(input.hasNextLine()){
      String y = input.nextLine();  //This first part is just changing location
      if(y.equals("north")){
        x.moveTo(x.location.north);
        System.out.println("You are in the " + x.getLoc());
      }
      else if (y.equals("south")){
        x.moveTo(x.location.south);
        System.out.println("You are in the " + x.getLoc());
      }
      else if (y.equals("east")){
        x.moveTo(x.location.east);
        System.out.println("You are in the " + x.getLoc());
      }
      else if (y.equals("west")){
        x.moveTo(x.location.west);
        System.out.println("You are in the " + x.getLoc());
      }
      else if (y.equals("help")){
        printInstructions();
      }
      else if (y.equals("location")){
        System.out.println("You are in the " + x.getLoc());
      }
      else if (y.equals("inventory")){
        for(int i=0; i<Player.invSize;i++){
          if(x.inventory[i]!=null){
            System.out.println("You are currently holding: " + x.inventory[i].toString());
          }
        }
      }
      else if (y.equals("look")){
        if(x.location.object!=null) {
          System.out.println("You notice some " + x.location.object.name);
        }
        else System.out.println("There is nothing here.");
      }
      else if (y.equals("pick up")){
        x.pickUp();
      }
      else if (y.startsWith("drop")){
        int location;
        location = y.indexOf(' ')+1;  //Parsing strings to get substring after 'drop '
        if(y.substring(location)!=null)
        {
          String object = y.substring(location); 
          x.dropItem(object);
        }
      }
      else if (y.startsWith("use")){
        int location;
        location = y.indexOf(' ')+1;  //Parsing strings to get substring after 'use '
        if(y.substring(location)!=null)
        {
          String object = y.substring(location); 
          x.useItem(object);
        }
      }
      else{
        System.out.println("What?");
      }
    }
  }
  
  
  public static void createWorldObject(){  //Creating world objects
    WorldObject coins = new WorldObject(20,false,"coins",true);
    WorldObject keys = new WorldObject(1,false,"keys",true);  //You need these to escape in the car
    WorldObject books = new WorldObject(2,false,"books",true);
    WorldObject lever = new WorldObject(1,true,"lever", false, false);  //You must pull this to escape
    WorldObject car = new WorldObject(1,true,"cars",false);
    rooms[0].object = coins;
    rooms[1].object = keys;
    rooms[2].object = books;
    rooms[3].object = lever;
    rooms[5].object = car;
  }
  
  public static void printInstructions(){  //Instructions
    System.out.println("Type the cardinal directions ('north', 'south', 'east', and 'west') to head in that direction.");
    System.out.println("Type 'inventory' to view your inventory.");
    System.out.println("Type 'location' to view your location.");
    System.out.println("Type 'look' to inspect your current room.");
    System.out.println("Type 'pick up' to pick up any item(s) in the room.");
    System.out.println("Type 'drop <itemname>' to drop any item.");
    System.out.println("Type 'use <itemname>' to use an item in your inventory.");
  }
  
  
}