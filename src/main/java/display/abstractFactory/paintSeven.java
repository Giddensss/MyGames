package main.java.display.abstractFactory;

import main.java.display.*;

import java.awt.Graphics2D;
import java.awt.Color;


public class paintSeven implements numberDisplay{
    private static final int DEFAULT_GAP = 3;
    private static final int DEFAULT_WIDTH = 14;
    private static final int DEFAULT_HEIGHT = 24;
    private static final int DEFAULT_THICK = 3;
    
    private int startX = 0;
    private int startY = 0;
    
    private Graphics2D g;
    
    private void paintSeven(Graphics2D g2d){
        
        int[] x = {
            DEFAULT_GAP+startX,
            DEFAULT_GAP+DEFAULT_WIDTH+startX,
            DEFAULT_GAP+DEFAULT_WIDTH+startX,
            DEFAULT_GAP+DEFAULT_WIDTH-DEFAULT_THICK+startX,
            DEFAULT_GAP+DEFAULT_WIDTH-DEFAULT_THICK+startX,
            DEFAULT_GAP+DEFAULT_WIDTH+startX,
            DEFAULT_GAP+DEFAULT_WIDTH-DEFAULT_THICK+startX,
            DEFAULT_GAP+DEFAULT_WIDTH-DEFAULT_THICK+startX,
            DEFAULT_GAP+DEFAULT_THICK+startX
        };
        int[] y = {
            DEFAULT_GAP+startY,
            DEFAULT_GAP+startY,
            DEFAULT_GAP+DEFAULT_HEIGHT+startY,
            DEFAULT_GAP+DEFAULT_HEIGHT-DEFAULT_THICK+startY,
            DEFAULT_GAP+DEFAULT_HEIGHT/2+DEFAULT_THICK+startY,
            DEFAULT_GAP+DEFAULT_HEIGHT/2,
            DEFAULT_GAP+DEFAULT_HEIGHT/2-DEFAULT_THICK+startY,
            DEFAULT_GAP+DEFAULT_THICK+startY,
            DEFAULT_GAP+DEFAULT_THICK+startY,
        };
        g2d.setColor(Color.red);
        g2d.drawPolygon(x,y,9);
        g.fillPolygon(x,y,9);
        
        g.setColor(Color.black);
        int[] line2 = {DEFAULT_GAP+DEFAULT_WIDTH+startX,DEFAULT_GAP+startY,DEFAULT_GAP+DEFAULT_WIDTH-DEFAULT_THICK+startX-1,DEFAULT_GAP+DEFAULT_THICK+startY};
        g2d.drawLine(line2[0],line2[1],line2[2],line2[3]);
        //g2d.dispose();
        
        
        
    }
    
    public void show(Graphics2D g2d){
        g = g2d;
        paintSeven(g);
    }
    
    public void setLocation(int x, int y){
        
        startX = x;
        startY = y+1;
    }
}