package main.java.game.npc;
import main.java.game.*;

import java.util.*;

public class expMan implements npc{
    
    private int[] pos = new int[2];
    private int status; // tracks current npc status, start from 0
    private game myGame;
    private int level;

    
    public expMan(game g,int s){
        
        myGame = g;
        status = s;
        level = myGame.getLevel();
        if (level == 5){
            pos[0] = 1;
            pos[1] = 7;
        }else if (level == 13){
            pos[0] = 4;
            pos[1] = 6;
        }
        
    }

    
    public int getStatus(){
        return status;
    }
    
    public void setStatus(int s){
        status = s;
    }
    
   
    public int[] getPos(){
        return pos;
    }
 
    
    public String getName(){
        return "e";
    }
    
   
    
   
    
    
}