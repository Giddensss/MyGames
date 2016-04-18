package main.java.display.npcFrame;

import main.java.game.*;
import main.java.game.npc.*;
import main.java.display.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bossFrame extends JPanel implements npcFrame{
    private game myGame;
    private boss myBoss;
    private final static int DEFAULT_WIDTH = 500;
    private final static int DEFAULT_HEIGHT = 300;
    private final static int DEFAULT_BOUND = 30;
    private final static int DEFAULT_GAP = 10;
    private JTextArea txt;
    private clientUI cui;
    public bossFrame(game g, boss b,clientUI c){
        myGame = g;
        myBoss=b;
        cui = c;
        setSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT));
        setPreferredSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT));
        setVisible(true);
        this.setLayout(null);
        setup();
        
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(0,0,500,500);
        paintBord(g);
    }
    
    private void paintBord(Graphics g){
        g.setColor(new Color(189,95,34));
        int BOUND = 4;
        int[] x1 = {0,
            DEFAULT_WIDTH,
            DEFAULT_WIDTH,
            DEFAULT_WIDTH-BOUND,
            DEFAULT_WIDTH-BOUND,
            BOUND};
        int[] y1 = {0,
            0,
            DEFAULT_HEIGHT,
            DEFAULT_HEIGHT-BOUND,
            BOUND,
            BOUND};
        
        int[] x2 = {0,
            0,
            DEFAULT_WIDTH,
            DEFAULT_WIDTH-BOUND,
            BOUND,
            BOUND};
        int[] y2 = {0,
            DEFAULT_HEIGHT,
            DEFAULT_HEIGHT,
            DEFAULT_HEIGHT-BOUND,
            DEFAULT_HEIGHT-BOUND,
            BOUND};
        g.drawPolygon(x1,y1,6);
        g.drawPolygon(x2,y2,6);
        g.fillPolygon(x1,y1,6);
        g.fillPolygon(x2,y2,6);
    }

    
    
    private void setup(){
        String words = "Boss:\n\n\"Oh look, here comes the warrior! I have been waiting for you for a while. \nHahahaha... \nSo you think you can beat me? Naive!\"";
        txt = new JTextArea(words);
        txt.setVisible(true);
        txt.setBackground(Color.black);
        txt.setForeground(Color.white);
        txt.setBounds(DEFAULT_GAP+DEFAULT_BOUND,
                      DEFAULT_GAP+DEFAULT_BOUND,
                      DEFAULT_WIDTH-2*(DEFAULT_GAP+DEFAULT_BOUND),
                      DEFAULT_HEIGHT-90-2*(DEFAULT_GAP+DEFAULT_BOUND));
        txt.setFont(new Font("Times new Rome", Font.PLAIN, 18));
        txt.setLineWrap(true);
        txt.setWrapStyleWord(true);
        txt.setEditable(false);
        this.add(txt);
        
        shopButton confirm = new shopButton("<html><Font='6', color='white'>Let's Fight!</Font></html>");
        confirm.setVisible(true);
        confirm.setBounds(DEFAULT_WIDTH/2-60,
                          DEFAULT_GAP+DEFAULT_BOUND+DEFAULT_HEIGHT-120,
                          120,40);
        confirm.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                myGame.removeNPC(myBoss);
                confirm.removeActionListener(this);
                cui.npcFrameDispose();
                cui.addFrameListener();
                
            }
        });
        
        this.add(confirm);
        
    }
    
    public int getWidth(){
        return DEFAULT_WIDTH;
    }
    
    public int getHeight(){
        return DEFAULT_HEIGHT;
    }
}