package main.java.display.npcFrame;

import main.java.game.*;
import main.java.game.npc.*;
import main.java.display.*;

public abstract class npcFrameAbstractFactory {
    abstract public npcFrame getFrame(String n, int i, game g, npc np, clientUI c);

}
