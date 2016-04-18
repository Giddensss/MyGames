package main.java.display;

import javax.swing.*;
import java.awt.Dimension;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

import main.java.game.*;
import main.java.display.abstractFactory.*;

public class counterUI extends JComponent{
    
    private static final int DEFAULT_MARGINE = 10;
    private static final int DEFAULT_GAP = 5;
    private static final int DEFAULT_WIDTH = 60;
    private int height = 0;
    
    private inforBoard myIB;
    private game myGame;
    
    private abstractFactory numF;
    
    private boolean displayed = false;
    
    public counterUI(inforBoard ib,game g){
        myIB = ib;
        myGame = g;
        height = myIB.getHeight();
        
        numF = new factoryProducer().getFactory("number");
        
        setVisible(true);
        int startX = DEFAULT_MARGINE + DEFAULT_GAP;
        int startY = DEFAULT_MARGINE + DEFAULT_GAP;
        
        setLocation(startX,startY);
        setSize(new Dimension(DEFAULT_WIDTH,height));
        setPreferredSize(new Dimension(DEFAULT_WIDTH,height));
        
        myIB.add(this);
        
    }
    
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g.create();
        paintBackgrond(g2d);
        paintNumber(g2d);
        repaint();
        
        g2d.dispose();
    }
    
    private void paintBackgrond(Graphics2D g){
        g.drawRect(0,0,60,height - DEFAULT_GAP*2-DEFAULT_MARGINE*2);
        g.fillRect(0,0,60,height - DEFAULT_GAP*2-DEFAULT_MARGINE*2);
    }
    
    private void paintNumber(Graphics2D g){
        String marked = ((Integer)(myGame.minesLeft())).toString();
        String temp = "";
        int zero;
        if (myGame.minesLeft()>=0){
            zero = 3 - marked.length();
            for (int i = 0; i < zero; i++){
                temp += "0";
            }
            marked = temp + marked;
            int i1 = (int)(Integer.valueOf(marked.codePointAt(0)));
            int i2 = (int)(Integer.valueOf(marked.codePointAt(1)));
            int i3 = (int)(Integer.valueOf(marked.codePointAt(2)));
            
            numberDisplay nd1 = numF.getNumber(i1-48);
            nd1.setLocation(0,0);
            nd1.show(g);
            numberDisplay nd2 = numF.getNumber(i2-48);
            nd2.setLocation(20,0);
            nd2.show(g);
            numberDisplay nd3 = numF.getNumber(i3-48);
            nd3.setLocation(40,0);
            nd3.show(g);
        }
        else{
            if (marked.length()<=3 ){
                marked = marked.replace("-","0");
                zero = 3 - marked.length();
                for (int i = 0; i < zero; i++){
                    temp += "0";
                }
                marked = temp + marked;
               // System.out.println(marked);
                int i1 = 10;
                int i2 = (int)(Integer.valueOf(marked.codePointAt(1)))-48;
                int i3 = (int)(Integer.valueOf(marked.codePointAt(2)))-48;
                
               // System.out.println(i2+ " "+i3);
                
                numberDisplay nd1 = numF.getSymbol(i1);
                nd1.setLocation(0,0);
                nd1.show(g);
                numberDisplay nd2 = numF.getNumber(i2);
                nd2.setLocation(20,0);
                nd2.show(g);
                numberDisplay nd3 = numF.getNumber(i3);
                nd3.setLocation(40,0);
                nd3.show(g);
            }
        }
    }
}