package main.java.controllor;

import main.java.game.*;
import main.java.display.*;

import javax.swing.*;
import java.awt.*;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import main.java.display.*;
import main.java.game.*;

public class floorChooseListener implements MouseListener{
    private game myGame;
    private clientUI cui;
    
    public floorChooseListener(game g, clientUI c){
        myGame = g;
        cui = c;

    }
    
    public void mouseClicked(MouseEvent e) {
        if((myGame.getLevel() == 21 && myGame.getAllMin().size() ==0) || myGame.getLevel() != 21){
            int floor = ((shopButton)(e.getSource())).getID()+1;
            myGame.chooseFloor(floor);
            cui.update();
            cui.resetWarriorIcon();
            cui.chooseFloorDispose();
            cui.addFrameListener();
            cui.requestFocus();
            

        }
        else if (myGame.getLevel() == 21 && myGame.getAllMin().size() !=0){
            cui.chooseFloorDispose();
            cui.resetWarriorIcon();
            cui.addFrameListener();
            JOptionPane.showMessageDialog(cui,"Can't use Wind Compass!");
            cui.requestFocus();
        }
    }
    
    public void mouseEntered(MouseEvent e) {
    }
    
    public void mouseExited(MouseEvent e) {
    }
    
    public void mousePressed(MouseEvent e) {
        
    }
    
    public void mouseReleased(MouseEvent e) {
    }
}