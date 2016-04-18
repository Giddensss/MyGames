package main.java.game.npc;

import main.java.game.*;

public class npcProducer extends abstractFac{
    private game myGame;
    
    public npcProducer(game g){
        myGame = g;
    }
    
    public npc getNPC(String n,int status){
        if (n.equals("f")){
            return new faery(myGame,status);
        }
        else if (n.equals("e")){
            return new expMan(myGame,status);
        }
        else if (n.equals("t")){
            return new theaf(myGame,status);
        }
        else if (n.equals("a")){
            return new attBoost(myGame,status);
        }
        else if (n.equals("k")){
            return new keySeller(myGame,status);
        }
        else if (n.equals("d")){
            return new defBoost(myGame,status);
        }
        else if (n.equals("s")){
            return new sage(myGame,status);
        }
        else if (n.equals("m")){
            return new merchant(myGame,status);
        }
        else if (n.equals("p")){
            return new princess(myGame,status);
        }
        else if (n.equals("%")){
            return new boss(myGame,status);
        }
        else{
            return null;
        }
    }
    
}
