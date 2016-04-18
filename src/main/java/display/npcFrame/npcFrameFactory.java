package main.java.display.npcFrame;

import main.java.game.*;
import main.java.display.*;
import main.java.game.npc.*;

public class npcFrameFactory extends npcFrameAbstractFactory{
    public npcFrame getFrame(String n, int i, game g, npc np, clientUI c){
        if (n.equals("f")){
            if (i == 0){
                return new faeryFrame(g,((faery)(np)),c);
            }else if (i == 1){
                return new faeryFrame2(g,((faery)(np)),c);
            }
            else {
                return null;
            }
        }
        else if (n.equals("e")){
            return new expFrame(g,c);
        }
        else if (n.equals("t")){
            if (i == 0){
                return new theafFrame(g,((theaf)(np)),c);
            }else if (i == 1){
                return new theafFrame2(g,((theaf)(np)),c);
            }
            else {
                return null;
            }
        }
        else if (n.equals("a")){
            return new attBoostFrame(g,((attBoost)(np)),c);
        }
        else if (n.equals("k")){
            return new keySellerFrame(g,c);
        }
        else if (n.equals("d")){
            return new defBoostFrame(g,((defBoost)(np)),c);
        }
        else if (n.equals("s")){
            return new sageFrame(g,((sage)(np)),c);
        }
        else if (n.equals("m")){
            return new merchantFrame(g,((merchant)(np)),c);
        }
        else if (n.equals("p")){
            return new princessFrame(g,((princess)(np)),c);
        }
        else if (n.equals("%")){
            return new bossFrame(g,((boss)(np)),c);
        }
        else{
            return null;
        }

    }
    
}