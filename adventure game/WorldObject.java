public class WorldObject{
  int count;
  boolean isUseable;
  String name;
  boolean isObtainable;
  boolean isLeverPulled;
  public WorldObject(int a, boolean k, String n, boolean p){
    count=a;
    isUseable=k;
    name=n;
    isObtainable = p;
  }
    public WorldObject(int a, boolean k, String n, boolean p, boolean l){
    count=a;
    isUseable=k;
    name=n;
    isObtainable = p;
    isLeverPulled = l;
  }
    
  public String toString(){
    return name;
  }
  public WorldObject(){};
}