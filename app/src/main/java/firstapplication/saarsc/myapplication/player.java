package firstapplication.saarsc.myapplication;

/**
 * Created by saarsc on 11/07/2017.
 */

public class player {
    char shape;
    String name;
    public player(char shape, String name){
        this.shape = shape;
        this.name = name;
    }
    public player(String name){
        this.name = name;
    }
    public void  setName(String name){
        this.name = name;
    }
    public void setShape(char shape){
        this.shape = shape;
    }
    public String getName(){
        return  this.name;
    }
    public char getShape(){
        return this.shape;
    }
}
