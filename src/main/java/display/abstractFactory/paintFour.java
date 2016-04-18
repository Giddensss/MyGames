package main.java.display.abstractFactory;

import main.java.display.*;

import java.awt.Graphics2D;
import java.awt.Color;


public class paintFour implements numberDisplay{
    private static final int DEFAULT_GAP = 3;
    private static final int DEFAULT_WIDTH = 14;
    private static final int DEFAULT_HEIGHT = 24;
    private static final int DEFAULT_THICK = 3;
    
    private int startX = 0;
    private int startY = 0;
    
    private Graphics2D g;
    
    private void paintFour(Graphics2D g2d){
        
        int[] x = {
            DEFAULT_GAP+startX,
            DEFAULT_GAP+startX,
            DEFAULT_GAP+DEFAULT_THICK+startX,
            DEFAULT_GAP+DEFAULT_WIDTH-DEFAULT_THICK+startX,
            DEFAULT_GAP+DEFAULT_WIDTH-DEFAULT_THICK+startX,
            DEFAULT_GAP+DEFAULT_WIDTH+startX,
            DEFAULT_GAP+DEFAULT_WIDTH+startX,
            DEFAULT_GAP+DEFAULT_WIDTH-DEFAULT_THICK+startX,
            DEFAULT_GAP+DEFAULT_WIDTH-DEFAULT_THICK+startX,
            DEFAULT_GAP+DEFAULT_THICK+startX,
            DEFAULT_GAP+DEFAULT_THICK+startX
            
        };
        
        int[] y = {
            DEFAULT_GAP+startY,
            DEFAULT_GAP+DEFAULT_HEIGHT/2+startY,
            DEFAULT_GAP+DEFAULT_HEIGHT/2+DEFAULT_THICK+startY-1,
            DEFAULT_GAP+DEFAULT_HEIGHT/2+DEFAULT_THICK+startY-1,
            DEFAULT_GAP+DEFAULT_HEIGHT-DEFAULT_THICK+startY,
            DEFAULT_GAP+DEFAULT_HEIGHT+startY,
            DEFAULT_GAP+startY,
            DEFAULT_GAP+startY+DEFAULT_THICK+startY,
            DEFAULT_GAP+DEFAULT_HEIGHT/2-DEFAULT_THICK+startY+1,
            DEFAULT_GAP+DEFAULT_HEIGHT/2-DEFAULT_THICK+startY+1,
            DEFAULT_GAP+DEFAULT_THICK+startY
        };
        
        g2d.setColor(Color.red);
        g2d.drawPolygon(x,y,11);
        g.fillPolygon(x,y,11);
        
        
        g.setColor(Color.black);
        int[] line7 = {DEFAULT_GAP+DEFAULT_WIDTH+startX,DEFAULT_GAP+DEFAULT_HEIGHT/2+startY,DEFAULT_GAP+DEFAULT_WIDTH-DEFAULT_THICK+startX-1,DEFAULT_GAP+DEFAULT_HEIGHT/2-DEFAULT_THICK+startY};
        int[] line5 = {DEFAULT_GAP+startX-1,DEFAULT_GAP+DEFAULT_HEIGHT/2+startY,DEFAULT_GAP+startX+DEFAULT_THICK,DEFAULT_GAP+DEFAULT_HEIGHT/2-DEFAULT_THICK+startY};
        int[] line8 = {DEFAULT_GAP+DEFAULT_WIDTH+startX,DEFAULT_GAP+DEFAULT_HEIGHT/2+startY,DEFAULT_GAP+DEFAULT_WIDTH-DEFAULT_THICK+startX-1,DEFAULT_GAP+DEFAULT_HEIGHT/2+DEFAULT_THICK+startY};
        g2d.drawLine(line7[0],line7[1],line7[2],line7[3]);
        g2d.drawLine(line5[0],line5[1],line5[2],line5[3]);
        g2d.drawLine(line8[0],line8[1],line8[2],line8[3]);
        //g2d.dispose();
        
        
        
    }
    
    public void show(Graphics2D g2d){
        g = g2d;
        paintFour(g);
    }
    
    public void setLocation(int x, int y){
        
        startX = x;
        startY = y+1;
    }
}