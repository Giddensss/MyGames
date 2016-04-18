package main.java.display.abstractFactory;

import main.java.display.*;

import java.awt.Graphics2D;
import java.awt.Color;


public class paintMinus implements numberDisplay{
    private static final int DEFAULT_GAP = 3;
    private static final int DEFAULT_WIDTH = 14;
    private static final int DEFAULT_HEIGHT = 24;
    private static final int DEFAULT_THICK = 3;
    
    private int startX = 0;
    private int startY = 0;
    
    private Graphics2D g;
    
    private void paintMinus(Graphics2D g2d){
        
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
        g2d.drawPolygon(x2,y2,6);
        g.fillPolygon(x2,y2,6);
        
        
        g.setColor(Color.black);
        
        //g2d.dispose();
        
        
        
    }
    
    public void show(Graphics2D g2d){
        g = g2d;
        paintMinus(g);
    }
    
    public void setLocation(int x, int y){
        
        startX = x;
        startY = y+1;
    }
}