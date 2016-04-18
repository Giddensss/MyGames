package main.java;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class skipListener implements KeyListener{
    private preface mainFrame;
    
    public skipListener(preface frame){
        mainFrame = frame;
    }
    
    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() == 32){
            mainFrame.dispose();
            mainFrame.removeKeyListener(this);
            mainFrame.BGMStop();
        }
    }
    public void keyReleased(KeyEvent e){
        
    }
    public void keyTyped(KeyEvent e){
        
    }
}