package main.java.display;

import javax.swing.*;
import java.awt.*;

public class shopButton extends JButton{
    private static final int DEFAULT_BOUND = 4;
    private int id;
    public shopButton(String s){
        super(s);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        paintBound(g);
    }
    
    private void paintBound(Graphics g){
        g.setColor(Color.WHITE);
        int width = this.getWidth();
        int height = this.getHeight();
        
        int[] x1 = {0,
            width,
            width,
            width-DEFAULT_BOUND,
            width-DEFAULT_BOUND,
            DEFAULT_BOUND};
        int[] y1 = {0,
            0,
            height,
            height-DEFAULT_BOUND,
            DEFAULT_BOUND,
            DEFAULT_BOUND};
        
        int[] x2 = {0,
            0,
            width,
            width-DEFAULT_BOUND,
            DEFAULT_BOUND,
            DEFAULT_BOUND};
        int[] y2 = {0,
            height,
            height,
            height-DEFAULT_BOUND,
            height-DEFAULT_BOUND,
            DEFAULT_BOUND};
        
        g.fillPolygon(x1,y1,6);
        g.fillPolygon(x2,y2,6);

    }
    
    public void setID(int i){
        id = i;
    }
    
    public int getID(){
        return id;
    }
    
}