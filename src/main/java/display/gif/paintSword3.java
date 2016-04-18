package main.java.display.gif;

import main.java.display.*;

import javax.swing.JComponent;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class paintSword3 extends JComponent implements item{
    private static final int DEFAULT_IMAGEWIDTH = 60;
    private int startX = 0;
    private int startY = 0;
    private Graphics myG;
    private ImageIcon icon = new ImageIcon("source/materials/item/3.png");
    private void paintSword3(Graphics g){
        g.drawImage(icon.getImage(),startX, startY,DEFAULT_IMAGEWIDTH,DEFAULT_IMAGEWIDTH,this);
        
    }
    
    public void show(Graphics g){
        myG = g;
        paintSword3(myG);
    }
    
    public void setLocation(int x, int y){
        startX = x;
        startY = y;
    }
}