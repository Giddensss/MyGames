package main.java.game.npc;
import main.java.game.*;

import java.util.*;

public class sage implements npc{
    
    private int[] pos = new int[2];
    private int status; // tracks current npc status, start from 0
    
    public sage(game g,int s){
        
        status = s;
        pos[0] = 4;
        pos[1] = 3;
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
        return "s";
    }
    
    public void setPos(int x, int y){
        pos[0] = x;
        pos[1] = y;
    }
    
    
    
}