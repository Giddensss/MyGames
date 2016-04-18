package main.java.display.abstractFactory;

import main.java.display.*;

import java.awt.Graphics2D;
import java.awt.Color;


public class paintOne implements numberDisplay{
    private static final int DEFAULT_GAP = 3;
    private static final int DEFAULT_WIDTH = 14;
    private static final int DEFAULT_HEIGHT = 24;
    private static final int DEFAULT_THICK = 3;
    
    private int startX = 0;
    private int startY = 0;
    
    private Graphics2D g;
    
    private void paintOne(Graphics2D g2d){
        
        int[] x = {
            
            DEFAULT_GAP+DEFAULT_WIDTH+startX,
            DEFAULT_GAP+DEFAULT_WIDTH+startX,
            DEFAULT_GAP+DEFAULT_WIDTH-DEFAULT_THICK+startX,
            DEFAULT_GAP+DEFAULT_WIDTH-DEFAULT_THICK+startX,
            DEFAULT_GAP+DEFAULT_WIDTH+startX,
            DEFAULT_GAP+DEFAULT_WIDTH-DEFAULT_THICK+startX,
            DEFAULT_GAP+DEFAULT_WIDTH-DEFAULT_THICK+startX,
        };
        int[] y = {
            DEFAULT_GAP+startY,
            DEFAULT_GAP+DEFAULT_HEIGHT+startY,
            DEFAULT_GAP+DEFAULT_HEIGHT-DEFAULT_THICK+startY,
            DEFAULT_GAP+DEFAULT_HEIGHT/2+DEFAULT_THICK+startY,
            DEFAULT_GAP+DEFAULT_HEIGHT/2,
            DEFAULT_GAP+DEFAULT_HEIGHT/2-DEFAULT_THICK+startY,
            DEFAULT_GAP+DEFAULT_THICK+startY
        };
        g2d.setColor(Color.red);
        g2d.drawPolygon(x,y,7);
        g.fillPolygon(x,y,7);
        //g2d.dispose();
        
        
        
    }
    
    public void show(Graphics2D g2d){
        g = g2d;
        paintOne(g);
    }
    
    public void setLocation(int x, int y){
        
        startX = x;
        startY = y+1;
    }
}