package main.java.controllor;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.*;

import main.java.game.*;
import main.java.display.*;
import main.java.display.npcFrame.*;


public class keyListener implements MouseListener{
    private game myGame;
    private int level;
    private keySellerFrame myKey;
    private clientUI ui;
    
    public keyListener(int l, game g, keySellerFrame s,clientUI c){
        myGame = g;
        level = l;
        myKey = s;
        ui = c;
    }
    
    public void mouseClicked(MouseEvent e) {
        if (level == 5){
            if(e.getSource().equals(myKey.getQuit())){
                ui.npcFrameDispose();
                ui.requestFocus();
                ui.addFrameListener();
                
             
            }
            
            else if (e.getSource().equals(myKey.getYellow())){
                if(myGame.getWarriorGold() >= 10){
                    myGame.setYellowKey(1);
                    myGame.setWarriorGold(-10);
                }
                else {
                    javax.swing.JOptionPane.showMessageDialog(ui,"Not enough Gold!");
                    ui.requestFocus();
                }
            }
            else if (e.getSource().equals(myKey.getBlue())){
                if(myGame.getWarriorGold() >= 50){
                    myGame.setBlueKey(1);
                    myGame.setWarriorGold(-50);
                }
                else {
                    javax.swing.JOptionPane.showMessageDialog(ui,"Not enough Gold!");
                    ui.requestFocus();
                }

                
            }
            else if (e.getSource().equals(myKey.getRed())){
                if(myGame.getWarriorGold() >= 100){
                    myGame.setRedKey(1);
                    myGame.setWarriorGold(-100);
                }
                else {
                        javax.swing.JOptionPane.showMessageDialog(ui,"Not enough Gold!");
                    ui.requestFocus();
                }
                
                
            }

            
            
            
        }
        else if (level == 12){
            
            if(e.getSource().equals(myKey.getQuit())){
                ui.npcFrameDispose();
                ui.requestFocus();
                ui.addFrameListener();
                
                
            } else if (e.getSource().equals(myKey.getYellow())){
                if(myGame.getYellowKey() >= 1){
                    myGame.setYellowKey(-1);
                    myGame.setWarriorGold(7);
                }
                else {
                    javax.swing.JOptionPane.showMessageDialog(ui,"Not enough Keys!");
                    ui.requestFocus();
                }
            }
            else if (e.getSource().equals(myKey.getBlue())){
                if(myGame.getBlueKey() >= 1){
                    myGame.setBlueKey(-1);
                    myGame.setWarriorGold(35);
                }
                else {
                    javax.swing.JOptionPane.showMessageDialog(ui,"Not enough Keys!");
                    ui.requestFocus();
                }
                
                
            }
            else if (e.getSource().equals(myKey.getRed())){
                if(myGame.getRedKey() >= 1){
                    myGame.setRedKey(-1);
                    myGame.setWarriorGold(70);
                }
                else {
                    javax.swing.JOptionPane.showMessageDialog(ui,"Not enough Keys!");
                    ui.requestFocus();
                }
                
                
            }
            

            
           
            
           

            
        }
 
        
        
    }
    
    public void mouseEntered(MouseEvent e) {
    }
    
    public void mouseExited(MouseEvent e) {
    }
    
    public void mousePressed(MouseEvent e) {
        
    }
    
    public void mouseReleased(MouseEvent e){
        
    }
}