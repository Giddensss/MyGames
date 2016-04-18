package main.java.controllor;

import main.java.game.*;
import main.java.display.*;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class mainControllor{
    
    private mainListener ml;
    
    public mainControllor(game g,clientUI c){
        
        ml = new mainListener(g,c);
        
        Toolkit.getDefaultToolkit().addAWTEventListener(ml,AWTEvent.KEY_EVENT_MASK);
    }

}