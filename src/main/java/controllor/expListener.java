package main.java.controllor;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.*;

import main.java.game.*;
import main.java.display.*;
import main.java.display.npcFrame.*;


public class expListener implements MouseListener{
    private game myGame;
    private int level;
    private expFrame myExp;
    private clientUI ui;
    
    public expListener(int l, game g,expFrame s,clientUI c){
        myGame = g;
        level = l;
        myExp = s;
        ui = c;
    }
    
    public void mouseClicked(MouseEvent e) {
        if (level == 5){
            if(e.getSource().equals(myExp.getQuit())){
                ui.npcFrameDispose();
                ui.addFrameListener();
                ui.requestFocus();
                
             
            }
            
            else if (e.getSource().equals(myExp.getLevel())){
                if(myGame.getWarriorExp() >= 100){
                    myGame.setWarriorLevel(1);
                    myGame.setWarriorHealth(1000);
                    myGame.setWarriorAttack(7);
                    myGame.setWarriorDefense(7);
                    myGame.setWarriorExp(-100);
                }
                else {
                    javax.swing.JOptionPane.showMessageDialog(ui,"Not enough Exp!");
                }
            }
            else if (e.getSource().equals(myExp.getAttack())){
                if(myGame.getWarriorExp() >= 30){
                    myGame.setWarriorAttack(5);
                    myGame.setWarriorExp(-30);
                }
                else {
                    javax.swing.JOptionPane.showMessageDialog(ui,"Not enough Exp!");
                }
                
            }
            else if (e.getSource().equals(myExp.getDefense())){
                if(myGame.getWarriorExp() >= 30){
                    myGame.setWarriorDefense(5);
                    myGame.setWarriorExp(-30);
                }
                else {
                    javax.swing.JOptionPane.showMessageDialog(ui,"Not enough Exp!");
                }
                
                
            }

            
            
            
        }
        else if (level == 13){
         
            if(e.getSource().equals(myExp.getQuit())){
                ui.npcFrameDispose();
                ui.addFrameListener();
                ui.requestFocus();
                
                
            }
            
            else if (e.getSource().equals(myExp.getLevel())){
                if(myGame.getWarriorExp() >= 270){
                    myGame.setWarriorLevel(3);
                    myGame.setWarriorHealth(3000);
                    myGame.setWarriorAttack(21);
                    myGame.setWarriorDefense(21);
                    myGame.setWarriorExp(-270);
                }
                else {
                    javax.swing.JOptionPane.showMessageDialog(ui,"Not enough Exp!");
                }
            }
            else if (e.getSource().equals(myExp.getAttack())){
                if(myGame.getWarriorExp() >= 95){
                    myGame.setWarriorAttack(17);
                    myGame.setWarriorExp(-95);
                }
                else {
                    javax.swing.JOptionPane.showMessageDialog(ui,"Not enough Exp!");
                }
                
            }
            else if (e.getSource().equals(myExp.getDefense())){
                if(myGame.getWarriorExp() >= 95){
                    myGame.setWarriorDefense(17);
                    myGame.setWarriorExp(-95);
                }
                else {
                    javax.swing.JOptionPane.showMessageDialog(ui,"Not enough Exp!");
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