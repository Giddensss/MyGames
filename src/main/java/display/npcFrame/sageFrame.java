package main.java.display.npcFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.java.controllor.*;
import main.java.game.*;
import main.java.game.npc.*;
import main.java.display.*;

public class sageFrame extends JPanel implements npcFrame{
    
    private static final int DEFAULT_WIDTH = 308;
    private static final int DEFAULT_HEIGHT = 338;
    private static final int DEFAULT_BOUND = 4;

    
    private game myGame;
    private clientUI cui;
    private sage mySage;
    private int level;
    private JTextArea txt;
    private JButton quit = new shopButton("<html><font color='white'>Not yet.</font></html>");
    private JButton confirm = new shopButton("<html><font color='white'>Yes!</font></html>");
    private JLabel info = new JLabel();
    private ImageIcon icon = new ImageIcon("source/materials/npc/exp.png");

    public sageFrame(game g,sage s,clientUI c){
        myGame = g;
        cui = c;
        mySage = s;
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
        String words = "\"Thank you young. I offer you a chance to boost your attack by 120. But as a cost, you need to pay me 500 EXP. Will you trade with me?\"";
        txt = new JTextArea(words);
        txt.setBackground(Color.black);
        txt.setForeground(Color.white);
        txt.setVisible(true);
        txt.setFont(new Font("Times new Rome", Font.PLAIN, 20));
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
                cui.npcFrameDispose();
                cui.addFrameListener();
                
            }
        });
        this.add(quit);
        
        confirm.setVisible(true);
        confirm.setBounds(14,DEFAULT_HEIGHT-74,100,40);
        confirm.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(myGame.getWarriorExp() >= 500){
                    confirm.removeActionListener(this);
                    myGame.setWarriorAttack(120);
                    myGame.setWarriorExp(-500);
                    myGame.removeNPC(mySage);
                    cui.npcFrameDispose();
                    cui.addFrameListener();
                    
                }
                else{
                    String words = "\"Sorry, but you don't have enough Exp.\"";
                    txt.setText(words);
                    confirm.setVisible(false);
                    quit.setText("<html><font color='white'>Leave</font></html>");
                }
                
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