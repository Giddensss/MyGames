package main.java.display.gif;

import main.java.display.*;

import javax.swing.JComponent;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class paintBai extends JComponent implements minionsdis{
    private static final int DEFAULT_IMAGEWIDTH = 60;
    private int startX = 0;
    private int startY = 0;
    private Graphics myG;
    private ImageIcon icon = new ImageIcon("source/materials/minions/Y.png");
    private ImageIcon icon2 = new ImageIcon("source/materials/minions/Y2.png");
    private void paintBai(Graphics g, int i){
        if ( i == 0){
            g.drawImage(icon.getImage(),startX, startY,DEFAULT_IMAGEWIDTH,DEFAULT_IMAGEWIDTH,this);
        }else if (i == 1){
            g.drawImage(icon2.getImage(),startX, startY,DEFAULT_IMAGEWIDTH,DEFAULT_IMAGEWIDTH,this);
        }
    }
    
    public void show(Graphics g, int i){
        myG = g;
        paintBai(myG,i);
    }
    
    public void setLocation(int x, int y){
        startX = x;
        startY = y;
    }
}