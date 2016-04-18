package main.java.controllor;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.*;

import main.java.game.*;
import main.java.display.*;
import main.java.display.npcFrame.*;


public class shopListener implements MouseListener{
    private game myGame;
    private int level;
    private shopFrame myShop;
    private clientUI ui;
    
    public shopListener(int l, game g, shopFrame s,clientUI c){
        myGame = g;
        level = l;
        myShop = s;
        ui = c;
    }
    
    public void mouseClicked(MouseEvent e) {
        if (level == 3){
            if(e.getSource().equals(myShop.getQuit())){
                ui.shopDispose();
                ui.addFrameListener();
                myShop.removeListener();
                ui.requestFocus();
                
             
            }
            else if(myGame.getWarriorGold() >= 25){
                if (e.getSource().equals(myShop.getHealth())){
                    myGame.setWarriorHealth(800);
                    myGame.setWarriorGold(-25);
                }
                else if (e.getSource().equals(myShop.getAttack())){
                    myGame.setWarriorAttack(4);
                    myGame.setWarriorGold(-25);
                }
                else if (e.getSource().equals(myShop.getDefense())){
                    myGame.setWarriorDefense(4);
                    myGame.setWarriorGold(-25);
                }
                
            }
            else {
                javax.swing.JOptionPane.showMessageDialog(ui,"Need More Gold!");
            }
            
            
        }
        else if (level == 11){
            if(e.getSource().equals(myShop.getQuit())){
                ui.shopDispose();
                ui.addFrameListener();
                myShop.removeListener();
                ui.requestFocus();
            }
            else if(myGame.getWarriorGold() >= 100){
                if (e.getSource().equals(myShop.getHealth())){
                    myGame.setWarriorHealth(4000);
                    myGame.setWarriorGold(-100);
                }
                else if (e.getSource().equals(myShop.getAttack())){
                    myGame.setWarriorAttack(20);
                    myGame.setWarriorGold(-100);
                }
                else if (e.getSource().equals(myShop.getDefense())){
                    myGame.setWarriorDefense(20);
                    myGame.setWarriorGold(-100);
                }

            }
            else{
                javax.swing.JOptionPane.showMessageDialog(ui,"Need More Gold!");
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