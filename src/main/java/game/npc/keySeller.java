package main.java.game.npc;
import main.java.game.*;

import java.util.*;

public class keySeller implements npc{
    
    private int[] pos = new int[2];
    private int status; // tracks current npc status, start from 0
    private game myGame;
    private int level;
    
    public keySeller(game g,int s){
        
        myGame = g;
        status = s;
        level = myGame.getLevel();
        if (level == 5){
            pos[0] = 10;
            pos[1] = 3;
        }else if (level == 12){
            pos[0] = 0;
            pos[1] = 0;
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
        return "k";
    }
    
  
    
    
    
}