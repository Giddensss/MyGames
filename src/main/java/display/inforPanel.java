package main.java.display;

import java.awt.*;
import javax.swing.*;

import main.java.game.*;

public class inforPanel extends JComponent{
    private game myGame;
    private static final int DEFAULT_WIDTH = 308;
    private static final int DEFAULT_HEIGHT = 754;
    private static final int DEFAULT_GAP = 5;
    private warriorPanel myWar;
    private keyPanel myKey;
    private optionPanel myOpt;
    public inforPanel(game g,clientUI c){
        myGame = g;
        myWar = new warriorPanel(myGame);
        myKey = new keyPanel(g);
        myOpt = new optionPanel(g,c);
        setSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT));
        setPreferredSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT));
        
        this.add(myWar);
        this.add(myKey);
        this.add(myOpt);
        myWar.setLocation(new Point(0,0));
        myKey.setLocation(new Point(0,myWar.getHeight()+DEFAULT_GAP));
        myOpt.setLocation(new Point(0,myWar.getHeight()+myKey.getHeight()+2*DEFAULT_GAP));
    }
    
    public int getWidth(){
        return DEFAULT_WIDTH;
    }
    
    public int getHeight(){
        return DEFAULT_HEIGHT;
    }
    
    
}