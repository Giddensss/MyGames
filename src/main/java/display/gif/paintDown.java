package main.java.display.gif;

import main.java.display.*;

import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;

public class paintDown extends JComponent implements environment{
    private static final int DEFAULT_IMAGEWIDTH = 60;
    private int startX = 0;
    private int startY = 0;
    private Graphics myG;
    private ImageIcon icon1 = new ImageIcon("source/materials/map/down.png");
    private ImageIcon icon2 = new ImageIcon("source/materials/map/Image 69 at frame 0.png");
    private void paintDown(Graphics g){
        g.drawImage(icon2.getImage(),startX, startY,DEFAULT_IMAGEWIDTH,DEFAULT_IMAGEWIDTH,this);
        g.drawImage(icon1.getImage(),startX, startY,DEFAULT_IMAGEWIDTH,DEFAULT_IMAGEWIDTH,this);
        
    }
    
    public void show(Graphics g, int i){
        myG = g;
        paintDown(myG);
    }
    
    public void setLocation(int x, int y){
        startX = x;
        startY = y;
    }
}