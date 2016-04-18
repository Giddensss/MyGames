package main.java.display.gif;

import main.java.display.*;

public class environmentDisplayFactory extends abstractFactory{

    public environment getEnv(String e){
        if (e.equals("X")){
            return new paintStar();
        }
        else if (e.equals("%")){
            return new paintWall();
        }
        else if (e.equals("M")){
            return new paintMagma();
        }
        else if (e.equals("R")||e.equals("S")||e.equals("B")){
            return new paintRoad();
        }
        else if (e.equals("U")){
            return new paintUp();
        }
        else if (e.equals("D")){
            return new paintDown();
        }
        else if (e.equals("F")){
            return new paintFirst();
        }
        else if(e.equals("s")){
            return new paintSecond();
        }
        else if(e.equals("T")){
            return new paintThird();
        }
        else{return null;}
    }
    
    public item getItems(String i){
        return null;
    }
    
    public npcdis getNpc(String n){
        return null;
    }
    
    public minionsdis getMin(String m){
        return null;
    }
}
