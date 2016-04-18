package main.java.display.abstractFactory;

import main.java.display.*;

import java.awt.Graphics2D;
import java.awt.Color;


public class paintZero implements numberDisplay{
    private static final int DEFAULT_GAP = 3;
    private static final int DEFAULT_WIDTH = 14;
    private static final int DEFAULT_HEIGHT = 24;
    private static final int DEFAULT_THICK = 3;
    
    private int startX = 0;
    private int startY = 0;
    
    private Graphics2D g;
    
    private void paintZero(Graphics2D g2d){
        
        int[] x = {
            DEFAULT_GAP+startX,
            DEFAULT_GAP+DEFAULT_WIDTH+startX,
            DEFAULT_GAP+DEFAULT_WIDTH+startX,
            DEFAULT_GAP+startX,
            DEFAULT_GAP+startX,
            DEFAULT_GAP+DEFAULT_THICK+startX,
            DEFAULT_GAP+DEFAULT_WIDTH-DEFAULT_THICK+startX,
            DEFAULT_GAP+DEFAULT_WIDTH+startX,
            DEFAULT_GAP+DEFAULT_WIDTH-DEFAULT_THICK+startX,
            DEFAULT_GAP+DEFAULT_WIDTH-DEFAULT_THICK+startX,
            DEFAULT_GAP+DEFAULT_WIDTH+startX,
            DEFAULT_GAP+DEFAULT_WIDTH-DEFAULT_THICK+startX,
            DEFAULT_GAP+DEFAULT_WIDTH-DEFAULT_THICK+startX,
            DEFAULT_GAP+DEFAULT_WIDTH+startX,
            DEFAULT_GAP+DEFAULT_WIDTH-DEFAULT_THICK+startX,
            DEFAULT_GAP+DEFAULT_THICK+startX,
            DEFAULT_GAP+startX,
            DEFAULT_GAP+DEFAULT_THICK+startX,
            DEFAULT_GAP+DEFAULT_THICK+startX,
            DEFAULT_GAP+startX,
            DEFAULT_GAP+DEFAULT_THICK+startX,
            DEFAULT_GAP+DEFAULT_THICK+startX
        };
        int[] y = {
            DEFAULT_GAP+startY,
            DEFAULT_GAP+startY,
            DEFAULT_GAP+DEFAULT_HEIGHT+startY,
            DEFAULT_GAP+DEFAULT_HEIGHT+startY,
            DEFAULT_GAP+startY,
            DEFAULT_GAP+DEFAULT_THICK+startY,
            DEFAULT_GAP+DEFAULT_THICK+startY,
            DEFAULT_GAP+startY,
            DEFAULT_GAP+DEFAULT_THICK+startY,
            DEFAULT_GAP+DEFAULT_HEIGHT/2-DEFAULT_THICK+startY,
            DEFAULT_GAP+DEFAULT_HEIGHT/2+startY,
            DEFAULT_GAP+DEFAULT_HEIGHT/2+DEFAULT_THICK+startY,
            DEFAULT_GAP+DEFAULT_HEIGHT-DEFAULT_THICK+startY,
            DEFAULT_GAP+DEFAULT_HEIGHT+startY,
            DEFAULT_GAP+DEFAULT_HEIGHT-DEFAULT_THICK+startY,
            DEFAULT_GAP+DEFAULT_HEIGHT-DEFAULT_THICK+startY,
            DEFAULT_GAP+DEFAULT_HEIGHT+startY,
            DEFAULT_GAP+DEFAULT_HEIGHT-DEFAULT_THICK+startY,
            DEFAULT_GAP+DEFAULT_HEIGHT/2+DEFAULT_THICK+startY,
            DEFAULT_GAP+DEFAULT_HEIGHT/2+startY,
            DEFAULT_GAP+DEFAULT_HEIGHT/2-DEFAULT_THICK+startY,
            DEFAULT_GAP+DEFAULT_THICK+startY
        };
        g2d.setColor(Color.red);
        g2d.drawPolygon(x,y,22);
        g.fillPolygon(x,y,22);
        
        g.setColor(Color.black);
        int[] line1 = {DEFAULT_GAP+startX-1,DEFAULT_GAP+startY-1,DEFAULT_GAP+DEFAULT_THICK+startX+1,DEFAULT_GAP+DEFAULT_THICK+startY+1};
        int[] line2 = {DEFAULT_GAP+DEFAULT_WIDTH+startX,DEFAULT_GAP+startY,DEFAULT_GAP+DEFAULT_WIDTH-DEFAULT_THICK+startX-1,DEFAULT_GAP+DEFAULT_THICK+startY};
        int[] line3 = {DEFAULT_GAP+startX,DEFAULT_GAP+DEFAULT_HEIGHT+startY,DEFAULT_GAP+DEFAULT_THICK+startX, DEFAULT_GAP+DEFAULT_HEIGHT-DEFAULT_THICK+startY-1};
        int[] line4 = {DEFAULT_GAP+DEFAULT_WIDTH+startX,DEFAULT_GAP+DEFAULT_HEIGHT+startY,DEFAULT_GAP+DEFAULT_WIDTH-DEFAULT_THICK+startX-1,DEFAULT_GAP+DEFAULT_HEIGHT-DEFAULT_THICK+startY-1};
        g2d.drawLine(line1[0],line1[1],line1[2],line1[3]);
        g2d.drawLine(line2[0],line2[1],line2[2],line2[3]);
        g2d.drawLine(line3[0],line3[1],line3[2],line3[3]);
        g2d.drawLine(line4[0],line4[1],line4[2],line4[3]);
        //g2d.dispose();
        
        
        
    }
    
    public void show(Graphics2D g2d){
        g = g2d;
        paintZero(g);
    }
    
    public void setLocation(int x, int y){
    
        startX = x;
        startY = y+1;
    }
}