package main.java.game.npc;

import main.java.game.*;


public class npcfactoryProducer {
    public static abstractFac getFactory(String choice, game g){
        if (choice.equals("npc")){
            return new npcProducer(g);
        }
        else{ return null;}
    }
}
