package main.java.display.gif;

import main.java.display.*;

import javax.swing.JComponent;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class paintRoad extends JComponent implements environment{
    private static final int DEFAULT_IMAGEWIDTH = 60;
    private int startX = 0;
    private int startY = 0;
    private Graphics myG;
    private ImageIcon icon = new ImageIcon("source/materials/map/Image 69 at frame 0.png");
    private void paintRoad(Graphics g){
        g.drawImage(icon.getImage(),startX, startY,DEFAULT_IMAGEWIDTH,DEFAULT_IMAGEWIDTH,this);

    }

    public void show(Graphics g, int i){
        myG = g;
        paintRoad(myG);
    }

    public void setLocation(int x, int y){
        startX = x;
        startY = y;
    }
}