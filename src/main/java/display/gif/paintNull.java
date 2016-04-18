package main.java.display.gif;

import main.java.display.*;

import javax.swing.JComponent;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class paintNull extends JComponent implements environment,item,minionsdis,npcdis{
    private static final int DEFAULT_IMAGEWIDTH = 60;
    private int startX = 0;
    private int startY = 0;
    private Graphics myG;
   
    private void paintNull(Graphics g){
        
        
    }
    
    public void show(Graphics g, int i){
       
    }
    
    public void show(Graphics g){
        myG = g;
        paintNull(myG);
    }
    
    public void setLocation(int x, int y){
        startX = x;
        startY = y;
    }
}