package main.java.display.npcFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.java.controllor.*;
import main.java.game.*;
import main.java.game.npc.*;
import main.java.display.*;

public class defBoostFrame extends JPanel implements npcFrame{
    
    private static final int DEFAULT_WIDTH = 308;
    private static final int DEFAULT_HEIGHT = 338;
    private static final int DEFAULT_BOUND = 4;

    
    private game myGame;
    private clientUI cui;
    private defBoost myDef;
    private int level;
    private JTextArea txt;
    private JButton quit = new shopButton("<html><font color='white'>Thanks!</font></html>");
    private JLabel info = new JLabel();
    private ImageIcon icon = new ImageIcon("source/materials/npc/key.png");

    public defBoostFrame(game g,defBoost d,clientUI c){
        myGame = g;
        cui = c;
        myDef = d;
        setSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT));
        setPreferredSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT));
        setVisible(true);
        this.setLayout(null);
        
        setup();
        
        //System.out.println(level);
        
        
       
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.fillRect(DEFAULT_BOUND,DEFAULT_BOUND,DEFAULT_WIDTH-DEFAULT_BOUND,DEFAULT_HEIGHT-DEFAULT_BOUND);
        paintBound(g);
        paintIcon(g);
        
    }

    private void paintBound(Graphics g){
        g.setColor(new Color(189,95,34));
        int[] x1 = {0,
            DEFAULT_WIDTH,
            DEFAULT_WIDTH,
            DEFAULT_WIDTH-DEFAULT_BOUND,
            DEFAULT_WIDTH-DEFAULT_BOUND,
            DEFAULT_BOUND};
        int[] y1 = {0,
            0,
            DEFAULT_HEIGHT,
            DEFAULT_HEIGHT-DEFAULT_BOUND,
            DEFAULT_BOUND,
            DEFAULT_BOUND};
        
        int[] x2 = {0,
            0,
            DEFAULT_WIDTH,
            DEFAULT_WIDTH-DEFAULT_BOUND,
            DEFAULT_BOUND,
            DEFAULT_BOUND};
        int[] y2 = {0,
            DEFAULT_HEIGHT,
            DEFAULT_HEIGHT,
            DEFAULT_HEIGHT-DEFAULT_BOUND,
            DEFAULT_HEIGHT-DEFAULT_BOUND,
            DEFAULT_BOUND};
        g.drawPolygon(x1,y1,6);
        g.drawPolygon(x2,y2,6);
        g.fillPolygon(x1,y1,6);
        g.fillPolygon(x2,y2,6);
    }
    
    private void paintIcon(Graphics g){
        g.drawImage(icon.getImage(),10,10,60,60,this);
    }
    
    private void setup(){
        String words = "\"Thank you young man for saving me! In return, I will boost your Defense by 30.\"";
        txt = new JTextArea(words);
        txt.setBackground(Color.black);
        txt.setForeground(Color.white);
        txt.setVisible(true);
        txt.setFont(new Font("Times new Rome", Font.PLAIN, 23));
        txt.setLineWrap(true);
        txt.setWrapStyleWord(true);
        txt.setEditable(false);
        txt.setBounds(14,90,DEFAULT_WIDTH-24,150);
        this.add(txt);
        quit.setVisible(true);
        quit.setBounds(DEFAULT_WIDTH-114,DEFAULT_HEIGHT-74,100,40);
        quit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                quit.removeActionListener(this);
                myGame.setWarriorDefense(30);
                myGame.removeNPC(myDef);
                cui.npcFrameDispose();
                cui.addFrameListener();
                
            }
        });
        this.add(quit);
        
    }
    
    public int getWidth(){
        return DEFAULT_WIDTH;
    }
    
    public int getHeight(){
        return DEFAULT_HEIGHT;
    }
    
    
    
}