package main.java.display.gif;

import main.java.display.*;

import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;

public class paintDefense extends JComponent implements item{
    private static final int DEFAULT_IMAGEWIDTH = 60;
    private int startX = 0;
    private int startY = 0;
    private Graphics myG;
    private ImageIcon icon1 = new ImageIcon("source/materials/item/defense.png");
    
    private void paintDefense(Graphics g){
       
        g.drawImage(icon1.getImage(),startX, startY,DEFAULT_IMAGEWIDTH,DEFAULT_IMAGEWIDTH,this);
        
    }
    
    public void show(Graphics g){
        myG = g;
        paintDefense(myG);
    }
    
    public void setLocation(int x, int y){
        startX = x;
        startY = y;
    }
}