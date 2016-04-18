package main.java.display.infoPanel;

import main.java.display.*;
import main.java.game.game;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class paintCheckinfo extends JPanel implements infoPanel{
    
    private static final int DEFAULT_WIDTH = 668;
    private static final int DEFAULT_HEIGHT = 228;
    private static final int DEFAULT_BOUND = 4;
    
    private clientUI cui;
    
    public paintCheckinfo(){
        setSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT));
        setPreferredSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT));
        setVisible(true);
        setLayout(null);
        setText();
        setButton();
        
        
    }
    
    
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.fillRect(0,0,DEFAULT_WIDTH,DEFAULT_HEIGHT);
        paintBound(g,DEFAULT_WIDTH,DEFAULT_HEIGHT,DEFAULT_BOUND,0,0);
    }
    
    private void paintBound(Graphics g,int width, int height1, int bound,int startx, int starty){
        g.setColor(new Color(189,95,34));
        int[] x1 = {startx,
            width+startx,
            width+startx,
            width+startx-bound,
            width+startx-bound,
            bound+startx};
        
        int[] y1 = {starty,
            starty,
            height1+starty,
            height1+starty-bound,
            bound+starty,
            bound+starty};
        
        int[] x2 = {startx,
            startx,
            width+startx,
            width-bound+startx,
            bound+startx,
            bound+startx};
        int[] y2 = {starty,
            height1+starty,
            height1+starty,
            height1-bound+starty,
            height1-bound+starty,
            bound+starty};
        g.drawPolygon(x1,y1,6);
        g.drawPolygon(x2,y2,6);
        g.fillPolygon(x1,y1,6);
        g.fillPolygon(x2,y2,6);
    }
    
    private void setText(){
        JLabel title = new JLabel("<html><Font size='7', color='white'>Badge of Holy Light</Font></html>",JLabel.CENTER);
        title.setVisible(true);
        title.setBounds (DEFAULT_WIDTH/2-200,15,400,50);
        this.add(title);
        
        String s = "You find the Badge of Holy Light. It can help you to check the informations about the minions in this level. Press \"L\" to turn on the checking panel, and press again to turn off.";
        JTextArea info = new JTextArea(s);
        info.setVisible(true);
        info.setBackground(Color.black);
        info.setForeground(Color.white);
        info.setFont(new Font("Times new Rome", Font.PLAIN, 21));
        info.setLineWrap(true);
        info.setWrapStyleWord(true);
        info.setEditable(false);
        info.setBounds(25,80,668-50,90);
        this.add(info);
    }
    
    private void setButton(){
        JButton button = new shopButton("<html><Font size='5',color='white'>Put into pocket</Font></html>");
        button.setVisible(true);
        button.setBounds(DEFAULT_WIDTH - 225, 175,200,35);
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                button.removeActionListener(this);
                cui.infoPanDispose();
                cui.addFrameListener();
                
            }
        });
        

        this.add(button);
    }

   
    
    public int getWidth(){
        return DEFAULT_WIDTH;
    }
    
    public int getHeight(){
        return DEFAULT_HEIGHT;
    }
    
    public void setClientUI(clientUI c){
        cui = c;
    }
}