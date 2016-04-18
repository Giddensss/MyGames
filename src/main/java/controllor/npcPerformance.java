package main.java.controllor;

import main.java.game.*;
import main.java.game.npc.*;
import main.java.display.*;

public class npcPerformance{
    private game myGame;
    private clientUI cui;
    
    public npcPerformance(game g, clientUI ui){
        myGame = g;
        cui = ui;
    }
    
    public void perform(int x, int y){
        String npc = myGame.getNpc(x,y).getName();
        npc myNpc = myGame.getNpc(x,y);
        if (npc.equals("f") ||
            npc.equals("e") ||
            npc.equals("t") ||
            npc.equals("a") ||
            npc.equals("k") ||
            npc.equals("d") ||
            npc.equals("s") ||
            npc.equals("m") ||
            npc.equals("p") ||
            npc.equals("%") ){
            cui.showNPCFrame(npc,myNpc.getStatus(),myGame,myNpc,cui);
        }
    
    }
}