package main.java.display.gif;

import main.java.display.*;

public class npcDisplayFactory extends abstractFactory{
    public npcdis getNpc(String n){
        if (n.equals("f")){
           
            return new paintFaery();
        }
        else if (n.equals("e") || n.equals("a") || n.equals("s")){
            return new paintExp();
        }
        else if (n.equals("t")){
            return new paintTheaf();
        }
        else if (n.equals("k")|| n.equals("d")|| n.equals("m")){
            return new paintKey();
        }
        else if (n.equals("p")){
            return new paintPrincess();
        }
        else if (n.equals("%")){
            return new paintNull();
        }
        else{
            
            return null;
        }
    }
    
    public item getItems(String i){
        return null;
    }
    
    public environment getEnv(String e){
        return null;
    }
    
    public minionsdis getMin(String m){
        return null;
    }
}