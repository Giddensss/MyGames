package main.java.display.abstractFactory;

import main.java.display.*;

import java.awt.Graphics2D;
import java.awt.Color;


public class paintThree implements numberDisplay{
    private static final int DEFAULT_GAP = 3;
    private static final int DEFAULT_WIDTH = 14;
    private static final int DEFAULT_HEIGHT = 24;
    private static final int DEFAULT_THICK = 3;
    
    private int startX = 0;
    private int startY = 0;
    
    private Graphics2D g;
    
    private void paintThree(Graphics2D g2d){
        
        int[] x = {
            DEFAULT_GAP+startX,
            DEFAULT_GAP+DEFAULT_WIDTH+startX,
            DEFAULT_GAP+DEFAULT_WIDTH+startX,
            DEFAULT_GAP+startX,
            DEFAULT_GAP+DEFAULT_THICK+startX,
            DEFAULT_GAP+DEFAULT_WIDTH-DEFAULT_THICK+startX,
            DEFAULT_GAP+DEFAULT_WIDTH-DEFAULT_THICK+startX,
            DEFAULT_GAP+DEFAULT_WIDTH+startX,
            DEFAULT_GAP+DEFAULT_WIDTH-DEFAULT_THICK+startX,
            DEFAULT_GAP+DEFAULT_WIDTH-DEFAULT_THICK+startX,
            DEFAULT_GAP+DEFAULT_THICK+startX,
        };
        int[] y = {
            DEFAULT_GAP+startY,
            DEFAULT_GAP+startY,
            DEFAULT_GAP+DEFAULT_HEIGHT+startY,
            DEFAULT_GAP+DEFAULT_HEIGHT+startY,
            DEFAULT_GAP+DEFAULT_HEIGHT-DEFAULT_THICK+startY,
            DEFAULT_GAP+DEFAULT_HEIGHT-DEFAULT_THICK+startY,
            DEFAULT_GAP+DEFAULT_HEIGHT/2+DEFAULT_THICK+startY,
            DEFAULT_GAP+DEFAULT_HEIGHT/2+startY,
            DEFAULT_GAP+DEFAULT_HEIGHT/2-DEFAULT_THICK+startY,
            DEFAULT_GAP+DEFAULT_THICK+startY,
            DEFAULT_GAP+DEFAULT_THICK+startY
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
        g2d.drawPolygon(x,y,11);
        g.fillPolygon(x,y,11);
        g2d.drawPolygon(x2,y2,6);
        g.fillPolygon(x2,y2,6);
        
        
        g.setColor(Color.black);
        int[] line2 = {DEFAULT_GAP+DEFAULT_WIDTH+startX,DEFAULT_GAP+startY,DEFAULT_GAP+DEFAULT_WIDTH-DEFAULT_THICK+startX-1,DEFAULT_GAP+DEFAULT_THICK+startY};
        
        int[] line4 = {DEFAULT_GAP+DEFAULT_WIDTH+startX,DEFAULT_GAP+DEFAULT_HEIGHT+startY,DEFAULT_GAP+DEFAULT_WIDTH-DEFAULT_THICK+startX-1,DEFAULT_GAP+DEFAULT_HEIGHT-DEFAULT_THICK+startY-1};
        int[] line7 = {DEFAULT_GAP+DEFAULT_WIDTH+startX,DEFAULT_GAP+DEFAULT_HEIGHT/2+startY,DEFAULT_GAP+DEFAULT_WIDTH-DEFAULT_THICK+startX-1,DEFAULT_GAP+DEFAULT_HEIGHT/2-DEFAULT_THICK+startY};
        int[] line8 = {DEFAULT_GAP+DEFAULT_WIDTH+startX,DEFAULT_GAP+DEFAULT_HEIGHT/2+startY,DEFAULT_GAP+DEFAULT_WIDTH-DEFAULT_THICK+startX-1,DEFAULT_GAP+DEFAULT_HEIGHT/2+DEFAULT_THICK+startY};
        g2d.drawLine(line2[0],line2[1],line2[2],line2[3]);
        g2d.drawLine(line4[0],line4[1],line4[2],line4[3]);
        g2d.drawLine(line7[0],line7[1],line7[2],line7[3]);
        g2d.drawLine(line8[0],line8[1],line8[2],line8[3]);
        //g2d.dispose();
        
        
        
    }
    
    public void show(Graphics2D g2d){
        g = g2d;
        paintThree(g);
    }
    
    public void setLocation(int x, int y){
        
        startX = x;
        startY = y+1;
    }
}