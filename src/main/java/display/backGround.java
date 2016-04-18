package main.java.display;

import javax.swing.*;
import java.awt.*;

public class backGround extends JComponent{
    private static final int DEFAULT_WIDTH = 1140;
    private static final int DEFAULT_HEIGHT = 840;
    private static final int DEFAULT_LENGTH = 60;
    
    public backGround(){
        setSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT));
        setPreferredSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT));
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        ImageIcon icon = new ImageIcon("source/materials/element/background.png");
        g.drawImage(icon.getImage(),0,0,this);
       
        //repaint();
        
    }
}