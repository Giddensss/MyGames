package main.java.display.gif;

import main.java.display.*;

public class itemDisplayFactory extends abstractFactory{

    public item getItems(String e){
        if (e.equals("y")){
            return new paintYellow();
        }
        else if (e.equals("b")){
            return new paintBlue();
        }
        else if (e.equals("r")){
            return new paintRed();
        }
        else if (e.equals("B")){
            return new paintBig();
        }
        else if (e.equals("S")){
            return new paintSmall();
        }
        else if (e.equals("D")){
            return new paintDefense();
        }
        else if (e.equals("A")){
            return new paintAttack();
        }
        else if (e.equals("%")){
            return new paintNull();
        }
        else if (e.equals("c")){
            return new paintCoin();
        }
        else if (e.equals("w")||e.equals("W")){
            return new paintWing();
        }
        else if (e.equals("L")){
            return new paintCheck();
        }
        else if (e.equals("J")){
            return new paintChooseFloor();
        }
        else if (e.equals("C")){
            return new paintCross();
        }
        else if (e.equals("P")){
            return new paintPickaxe();
        }
        else if (e.equals("k")){
            return new paintKeyBox();
        }
        else if (e.equals("1")){
            return new paintSword1();
        }
        else if (e.equals("2")){
            return new paintSword2();
        }
        else if (e.equals("3")){
            return new paintSword3();
        }
        else if (e.equals("4")){
            return new paintShield1();
        }
        else if (e.equals("5")){
            return new paintShield2();
        }
        else if (e.equals("6")){
            return new paintShield3();
        }
        else if (e.equals("h")){
            return new paintHolyWater();
        }
        else{return null;}
    }
    
    public environment getEnv(String e){
        return null;
    }
    
    public npcdis getNpc(String n){
        return null;
    }
    
    public minionsdis getMin(String m){
        return null;
    }
}
