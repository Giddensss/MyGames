package main.java.display.gif;

import main.java.display.*;

public class minionsDisplayFactory extends abstractFactory{
    public minionsdis getMin(String m){
        if(m.equals("l")){
            return new paintLv();
        }
        else if (m.equals("h")){
            return new paintHong();
        }
        else if (m.equals("q")){
            return new paintQing();
        }
        else if (m.equals("c")){
            return new paintChu();
        }
        else if (m.equals("b")){
            return new paintBian();
        }
        else if (m.equals("k")){
            return new paintKu();
        }
        else if (m.equals("s")){
            return new paintShi();
        }
        else if (m.equals("m")){
            return new paintMian();
        }
        else if (m.equals("F")){
            return new paintHongB();
        }
        else if (m.equals("%")){
            return new paintNull();
        }
        else if (m.equals("Y")){
            return new paintBai();
        }
        else if (m.equals("D")){
            return new paintDa();
        }
        else if (m.equals("Z")){
            return new paintDuiZhang();
        }
        else if (m.equals("w")){
            return new paintWei();
        }
        else if (m.equals("j")){
            return new paintJinDui();
        }
        else if (m.equals("g")){
            return new paintJinWei();
        }
        else if (m.equals("v")){
            return new paintHongM();
        }
        else if (m.equals("x")){
            return new paintGaoF();
        }
        else if (m.equals("a")){
            return new paintGuai();
        }
        else if (m.equals("t")){
            return new paintShiT();
        }
        else if (m.equals("e")){
            return new paintMaY();
        }
        else if (m.equals("i")){
            return new paintShou();
        }
        else if (m.equals("n")){
            return new paintMing();
        }
        else if (m.equals("o")){
            return new paintJianShi();
        }
        else if (m.equals("p")){
            return new paintGaoW();
        }
        else if (m.equals("u")){
            return new paintMingD();
        }
        else if (m.equals("!")){
            return new paintLingW();
        }
        else if (m.equals("@")){
            return new paintLingF();
        }
        else if (m.equals("#")){
            return new paintYingZ();
        }
        else if (m.equals("$")){
            return new paintMingZ();
        }
        else if (m.equals("^")){
            return new paintHongY();
        }
        else if (m.equals("*")||m.equals("~")){
            return new paintBoss();
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
    
    public npcdis getNpc(String n){
        return null;
    }
}