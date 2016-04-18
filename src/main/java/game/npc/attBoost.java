package main.java.game.npc;
import main.java.game.*;

import java.util.*;

public class attBoost implements npc{
    
    private int[] pos = new int[2];
    private int status; // tracks current npc status, start from 0
    private game myGame;
   // private int level;
    
    public attBoost(game g,int s){
        
        myGame = g;
        status = s;
      //  level = myGame.getLevel();
        pos[0] = 7;
        pos[1] = 10;
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
        return "a";
    }
    
    
    
    
}