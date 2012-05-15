public class Room{
  Room north;
  Room south;
  Room east;
  Room west;
  String name;
  WorldObject object;
  
  public void setName(String n){
    name=n;
  }
    public String getName(){
    return name;
  }
  public void setConnections(){
    north=Main.random();
    south=Main.random();
    east=Main.random();
    west=Main.random();
  }
}