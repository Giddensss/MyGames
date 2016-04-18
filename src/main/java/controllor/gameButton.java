package main.java.controllor;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.swing.JButton;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import main.java.game.*;

public class gameButton extends JButton{
    private static final int DEFAULT_WIDTH_PER_SIDE = 30;
    private static final int DEFAULT_GAP = 2;
    private game myGame;
    
    public gameButton(String text,game g){
        super(text);
        myGame = g;
        //setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
        
        setBackground(Color.gray);
        
        
    }
    
    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g.create();
        super.paintComponent(g);
        
        
        paintBorder(g2d);
        if(!myGame.isWin() && !myGame.isLose()){
            paintGaming(g2d);
        }
        if(myGame.isLose()){
            paintLose(g2d);
        }
        if(myGame.isWin()){
            paintWin(g2d);
        }
        repaint();
        
        g2d.dispose();
    }
    
    protected void paintBorder(Graphics2D g){
        int[] x1 = {0,DEFAULT_WIDTH_PER_SIDE,DEFAULT_WIDTH_PER_SIDE-DEFAULT_GAP,DEFAULT_GAP,DEFAULT_GAP,0};
        int[] y1 = {0,0,DEFAULT_GAP,DEFAULT_GAP,DEFAULT_WIDTH_PER_SIDE-DEFAULT_GAP,DEFAULT_WIDTH_PER_SIDE};
        int[] x2 = {DEFAULT_WIDTH_PER_SIDE-DEFAULT_GAP,DEFAULT_WIDTH_PER_SIDE,DEFAULT_WIDTH_PER_SIDE,0,DEFAULT_GAP,DEFAULT_WIDTH_PER_SIDE-DEFAULT_GAP};
        int[] y2 = {DEFAULT_GAP,0,DEFAULT_WIDTH_PER_SIDE,DEFAULT_WIDTH_PER_SIDE,DEFAULT_WIDTH_PER_SIDE-DEFAULT_GAP,DEFAULT_WIDTH_PER_SIDE-DEFAULT_GAP};
        
        
        g.setBackground(new Color(150,150,150));
        g.setColor(new Color(220,220,220));
        g.drawPolygon(x1,y1,6);
        g.fillPolygon(x1,y1,6);
        
        g.setColor(new Color(150,150,150));
        g.drawPolygon(x2,y2,6);
        g.fillPolygon(x2,y2,6);
        
        
    }
    
    protected void paintGaming(Graphics2D g){
        int cirX = 5;
        int cirY = 5;
        int d = 20;
        
        g.drawOval(cirX,cirY,d,d);
        g.setColor(new Color(242,235,48));
        g.fillOval(cirX,cirY,d,d);
        
        int[] rect1 = {10,11};
        int[] rect2 = {18,11};
        
        g.setColor(Color.black);
        g.drawRect(rect1[0],rect1[1],2,2);
        g.fillRect(rect1[0],rect1[1],2,2);
        g.drawRect(rect2[0],rect2[1],2,2);
        g.fillRect(rect2[0],rect2[1],2,2);
        
        int cirvX = 10;
        int cirvY = DEFAULT_WIDTH_PER_SIDE/2;
        int cirvW = 10;
        int cirvH = 6;
        g.drawArc(cirvX,cirvY,cirvW,cirvH,180,180);
    }
    
    protected void paintLose(Graphics2D g){
        
        
        int cirX = 5;
        int cirY = 5;
        int d = 20;
        
        g.drawOval(cirX,cirY,d,d);
        g.setColor(new Color(242,235,48));
        g.fillOval(cirX,cirY,d,d);
        
        int[] line1 = {10,10,12,12};
        int[] line2 = {10,12,12,10};
        int[] line3 = {18,10,20,12};
        int[] line4 = {18,12,20,10};
        
        g.setColor(Color.black);
        g.drawLine(line1[0],line1[1],line1[2],line1[3]);
        g.drawLine(line2[0],line2[1],line2[2],line2[3]);
        g.drawLine(line3[0],line3[1],line3[2],line3[3]);
        g.drawLine(line4[0],line4[1],line4[2],line4[3]);
        
        int cirvX = 10;
        int cirvY = DEFAULT_WIDTH_PER_SIDE/2+2;
        int cirvW = 10;
        int cirvH = 6;
        g.drawArc(cirvX,cirvY,cirvW,cirvH,180,-180);
    }
    
    protected void paintWin(Graphics2D g){
        
        int cirX = 5;
        int cirY = 5;
        int d = 20;
        
        g.drawOval(cirX,cirY,d,d);
        g.setColor(new Color(242,235,48));
        g.fillOval(cirX,cirY,d,d);
        
        int[] x = {10,20,20,18,15,12,10};
        int[] y = {10,10,15,15,10,15,15};
        g.setColor(Color.black);
        g.drawPolygon(x,y,7);
        g.fillPolygon(x,y,7);
        
        int[] line1 = {10,10,5,15};
        int[] line2 = {20,10,25,15};
        g.drawLine(line1[0],line1[1],line1[2],line1[3]);
        g.drawLine(line2[0],line2[1],line2[2],line2[3]);
        
        int cirvX = 10;
        int cirvY = DEFAULT_WIDTH_PER_SIDE/2+1;
        int cirvW = 10;
        int cirvH = 6;
        g.drawArc(cirvX,cirvY,cirvW,cirvH,180,180);
    }
}
