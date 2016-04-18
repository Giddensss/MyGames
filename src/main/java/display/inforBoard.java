package main.java.display;

import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;

import main.java.game.*;

public class inforBoard extends JComponent{
    private static final int DEFAULT_MARGINE = 10;
    private static final int DEFAULT_GAP = 4;
    private display myDis;
    private int width = 0;
    private int height = 0;
    
    
    public inforBoard(display d,int h){
        myDis = d;
        height = h;
        width = myDis.getWidth();
        setSize(new Dimension(width,height));
        setPreferredSize(new Dimension(width,height));
        
        
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawBoard(g);
    }
    
    private void drawBoard(Graphics g){
        int[] x1 = {DEFAULT_MARGINE/2,width-DEFAULT_MARGINE/2,width-DEFAULT_MARGINE/2-DEFAULT_GAP,DEFAULT_MARGINE/2+DEFAULT_GAP,DEFAULT_MARGINE/2+DEFAULT_GAP,DEFAULT_MARGINE/2}; //up
        int[] y1 = {DEFAULT_MARGINE/2,DEFAULT_MARGINE/2,DEFAULT_MARGINE/2+DEFAULT_GAP,DEFAULT_MARGINE/2+DEFAULT_GAP,height-DEFAULT_MARGINE/2-DEFAULT_GAP,height-DEFAULT_MARGINE/2}; //up
        int[] x2 = {width-DEFAULT_MARGINE/2,width-DEFAULT_MARGINE/2,DEFAULT_MARGINE/2,DEFAULT_MARGINE/2+DEFAULT_GAP,width-DEFAULT_MARGINE/2-DEFAULT_GAP,width-DEFAULT_MARGINE/2-DEFAULT_GAP,}; //down
        int[] y2 = {DEFAULT_MARGINE/2,height-DEFAULT_MARGINE/2,height-DEFAULT_MARGINE/2,height-DEFAULT_MARGINE/2-DEFAULT_GAP,height-DEFAULT_MARGINE/2-DEFAULT_GAP,DEFAULT_MARGINE/2+DEFAULT_GAP}; // down
        g.setColor(new Color(165,165,165));
        g.drawPolygon(x1,y1,6);
        g.fillPolygon(x1,y1,6);
        g.setColor(new Color(220,220,220));
        g.drawPolygon(x2,y2,6);
        g.fillPolygon(x2,y2,6);
    }
    
    public int getCenterX(int x){
        return width/2 - x/2;
    }
    
    public int getCenterY(int y){
        return height/2 - y/2;
    }
    
    public int getHeight(){
        return height;
    }
    
    public int getWidth(){
        return width;
    }
}