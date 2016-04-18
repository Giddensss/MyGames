package main.java.game.npc;
import main.java.game.*;

import java.util.*;

public class princess implements npc{
    
    private int[] pos = new int[2];
    private int status; // tracks current npc status, start from 0
    private game myGame;
    
    public princess(game g,int s){
        
        myGame = g;
        status = s;
        pos[0] = 5;
        pos[1] = 4;
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
        return "p";
    }
    
    public void setPos(int x, int y){
        pos[0] = x;
        pos[1] = y;
    }
    
    
}