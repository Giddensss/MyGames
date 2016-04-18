package main.java.controllor;

import java.awt.event.*;
import java.awt.*;
import main.java.display.clientUI;

public class checkBoardListener implements AWTEventListener{
    private clientUI cui;
    
    public checkBoardListener(clientUI c){
        cui = c;
    }
    
    public void eventDispatched(AWTEvent event) {
        if (event.getClass() == KeyEvent.class) {
            KeyEvent keyEvent = (KeyEvent) event;
            if (keyEvent.getID() == KeyEvent.KEY_PRESSED) {
                if(keyEvent.getKeyCode() == 76){
                    //System.out.println("this is added");
                    cui.checkBoardDispose();
                    Toolkit.getDefaultToolkit().removeAWTEventListener(this);
                    cui.addFrameListener();
                }
            }
        }
        
    }
    
}