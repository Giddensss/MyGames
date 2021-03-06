package main.java.display.abstractFactory;

import main.java.display.*;

import java.awt.Graphics2D;
import java.awt.Color;


public class paintSix implements numberDisplay{
    private static final int DEFAULT_GAP = 3;
    private static final int DEFAULT_WIDTH = 14;
    private static final int DEFAULT_HEIGHT = 24;
    private static final int DEFAULT_THICK = 3;
    
    private int startX = 0;
    private int startY = 0;
    
    private Graphics2D g;
    
    private void paintSix(Graphics2D g2d){
        
        int[] x = {
            DEFAULT_GAP+DEFAULT_WIDTH+startX,
            DEFAULT_GAP+startX,
            DEFAULT_GAP+startX,
            DEFAULT_GAP+DEFAULT_WIDTH+startX,
            DEFAULT_GAP+DEFAULT_WIDTH+startX,
            DEFAULT_GAP+DEFAULT_WIDTH-DEFAULT_THICK+startX,
            DEFAULT_GAP+DEFAULT_WIDTH-DEFAULT_THICK+startX,
            DEFAULT_GAP+DEFAULT_THICK+startX,
            DEFAULT_GAP+DEFAULT_THICK+startX,
            DEFAULT_GAP+DEFAULT_WIDTH-DEFAULT_THICK+startX
        };
        
        int[] y = {
            DEFAULT_GAP+startY,
            DEFAULT_GAP+startY,
            DEFAULT_GAP+DEFAULT_HEIGHT+startY,
            DEFAULT_GAP+DEFAULT_HEIGHT+startY,
            DEFAULT_GAP+DEFAULT_HEIGHT/2+startY,
            DEFAULT_GAP+DEFAULT_HEIGHT/2+DEFAULT_THICK+startY-1,
            DEFAULT_GAP+DEFAULT_HEIGHT-DEFAULT_THICK+startY,
            DEFAULT_GAP+DEFAULT_HEIGHT-DEFAULT_THICK+startY,
            DEFAULT_GAP+startY+DEFAULT_THICK,
            DEFAULT_GAP+startY+DEFAULT_THICK
        
        };
        int[] x2 = {
            DEFAULT_GAP+DEFAULT_THICK+startX,
            DEFAULT_GAP+DEFAULT_WIDTH-DEFAULT_THICK+startX,
            DEFAULT_GAP+DEFAULT_WIDTH+startX,
            DEFAULT_GAP+DEFAULT_WIDTH-DEFAULT_THICK+startX,
            DEFAULT_GAP+DEFAULT_THICK+startX,
            DEFAULT_GAP+startX,
        };
        
        int[] y2 = {
            DEFAULT_GAP+DEFAULT_HEIGHT/2-DEFAULT_THICK+startY+1,
            DEFAULT_GAP+DEFAULT_HEIGHT/2-DEFAULT_THICK+startY+1,
            DEFAULT_GAP+DEFAULT_HEIGHT/2+startY,
            DEFAULT_GAP+DEFAULT_HEIGHT/2+DEFAULT_THICK+startY-1,
            DEFAULT_GAP+DEFAULT_HEIGHT/2+DEFAULT_THICK+startY-1,
            DEFAULT_GAP+DEFAULT_HEIGHT/2+startY,
        };
        
        g2d.setColor(Color.red);
        g2d.drawPolygon(x,y,10);
        g.fillPolygon(x,y,10);
        g2d.drawPolygon(x2,y2,6);
        g.fillPolygon(x2,y2,6);
        
        
        g.setColor(Color.black);
        
        int[] line1 = {DEFAULT_GAP+startX-1,DEFAULT_GAP+startY-1,DEFAULT_GAP+DEFAULT_THICK+startX+1,DEFAULT_GAP+DEFAULT_THICK+startY+1};
        int[] line3 = {DEFAULT_GAP+startX,DEFAULT_GAP+DEFAULT_HEIGHT+startY,DEFAULT_GAP+DEFAULT_THICK+startX, DEFAULT_GAP+DEFAULT_HEIGHT-DEFAULT_THICK+startY-1};
        int[] line4 = {DEFAULT_GAP+DEFAULT_WIDTH+startX,DEFAULT_GAP+DEFAULT_HEIGHT+startY,DEFAULT_GAP+DEFAULT_WIDTH-DEFAULT_THICK+startX-1,DEFAULT_GAP+DEFAULT_HEIGHT-DEFAULT_THICK+startY-1};
        int[] line5 = {DEFAULT_GAP+startX-1,DEFAULT_GAP+DEFAULT_HEIGHT/2+startY,DEFAULT_GAP+startX+DEFAULT_THICK,DEFAULT_GAP+DEFAULT_HEIGHT/2-DEFAULT_THICK+startY};
        int[] line6 = {DEFAULT_GAP+startX-1,DEFAULT_GAP+DEFAULT_HEIGHT/2+startY,DEFAULT_GAP+startX+DEFAULT_THICK,DEFAULT_GAP+DEFAULT_HEIGHT/2+DEFAULT_THICK+startY};
        
        int[] line8 = {DEFAULT_GAP+DEFAULT_WIDTH+startX,DEFAULT_GAP+DEFAULT_HEIGHT/2+startY,DEFAULT_GAP+DEFAULT_WIDTH-DEFAULT_THICK+startX-1,DEFAULT_GAP+DEFAULT_HEIGHT/2+DEFAULT_THICK+startY};
        g2d.drawLine(line1[0],line1[1],line1[2],line1[3]);
        g2d.drawLine(line3[0],line3[1],line3[2],line3[3]);
        g2d.drawLine(line4[0],line4[1],line4[2],line4[3]);
        g2d.drawLine(line5[0],line5[1],line5[2],line5[3]);
        g2d.drawLine(line6[0],line6[1],line6[2],line6[3]);
        g2d.drawLine(line8[0],line8[1],line8[2],line8[3]);
        //g2d.dispose();
        
        
        
    }
    
    public void show(Graphics2D g2d){
        g = g2d;
        paintSix(g);
    }
    
    public void setLocation(int x, int y){
        
        startX = x;
        startY = y+1;
    }
}