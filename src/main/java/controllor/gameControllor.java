package main.java.controllor;

import main.java.display.*;
import main.java.game.*;

import java.util.*;
import java.awt.*;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import javax.swing.*;

public class gameControllor extends JComponent implements MouseListener{
    private static final int DEFAULT_SIDE = 30;
    private game myGame;
    private inforBoard ib;
    private JButton setGame;
    private display myDis;
    private mainControllor myCon;
    
    public gameControllor(inforBoard i,mainControllor mc,display d,game g){
        myGame = g;
        ib = i;
        myDis = d;
        myCon = mc;
        int startX = i.getCenterX(DEFAULT_SIDE);
        int startY = i.getCenterY(DEFAULT_SIDE);
        setGame = new gameButton("",myGame);
        setGame.setVisible(true);
        setGame.addMouseListener(this);
        
        setGame.setBounds(startX,startY,DEFAULT_SIDE,DEFAULT_SIDE);
        ib.add(setGame);
    }
    
    public void mouseClicked(MouseEvent e) {
        
        
        myGame.reset();
        ib.repaint();
        myDis.repaint();
        myCon.repaintButtons();
        
        
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
