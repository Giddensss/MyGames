package main.java.display.npcFrame;

import main.java.game.*;
import main.java.game.npc.*;
import main.java.display.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class faeryFrame2 extends JPanel implements npcFrame{
    private game myGame;
    private faery myFaery;
    private final static int DEFAULT_WIDTH = 500;
    private final static int DEFAULT_HEIGHT = 300;
    private final static int DEFAULT_BOUND = 30;
    private final static int DEFAULT_GAP = 10;
    private JTextArea txt;
    private clientUI cui;
    public faeryFrame2(game g, faery f,clientUI c){
        myGame = g;
        myFaery =f;
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
        if (myGame.hasItem("C") ){
            
            String words = "Fairy:\n\n\"Yes, that's the Cross which I am looking for. Thanks! And as I promised, I will give my power to you.\"";
            txt = new JTextArea(words);
            txt.setVisible(true);
            txt.setBackground(Color.black);
            txt.setForeground(Color.white);
            txt.setBounds(DEFAULT_GAP+DEFAULT_BOUND,
                          DEFAULT_GAP+DEFAULT_BOUND,
                          DEFAULT_WIDTH-2*(DEFAULT_GAP+DEFAULT_BOUND),
                          DEFAULT_HEIGHT-120-2*(DEFAULT_GAP+DEFAULT_BOUND));
            txt.setFont(new Font("Times new Rome", Font.PLAIN, 15));
            txt.setLineWrap(true);
            txt.setWrapStyleWord(true);
            txt.setEditable(false);
            this.add(txt);
            
            shopButton confirm = new shopButton("<html><Font='6', color='white'>Confirm</Font></html>");
            confirm.setVisible(true);
            confirm.setBounds(DEFAULT_WIDTH/2-50,
                              DEFAULT_GAP+DEFAULT_BOUND+DEFAULT_HEIGHT-120,
                              100,50);
            confirm.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    myGame.removeNPC(myFaery);
                    myGame.setWarriorHealth(myGame.getWarriorHealth()/3);
                    myGame.setWarriorAttack(myGame.getWarriorAttack()/3);
                    myGame.setWarriorDefense(myGame.getWarriorDefense()/3);
                    confirm.removeActionListener(this);
                    cui.npcFrameDispose();
                    cui.addFrameListener();
                    
                }
            });
            
            this.add(confirm);
        }else{
            String words = "Fairy:\n\n\"Since, yet, you haven't found the cross that I am looking for, I cannot give my power to you. \"";
            txt = new JTextArea(words);
            txt.setVisible(true);
            txt.setBackground(Color.black);
            txt.setForeground(Color.white);
            txt.setBounds(DEFAULT_GAP+DEFAULT_BOUND,
                          DEFAULT_GAP+DEFAULT_BOUND,
                          DEFAULT_WIDTH-2*(DEFAULT_GAP+DEFAULT_BOUND),
                          DEFAULT_HEIGHT-120-2*(DEFAULT_GAP+DEFAULT_BOUND));
            txt.setFont(new Font("Times new Rome", Font.PLAIN, 15));
            txt.setLineWrap(true);
            txt.setWrapStyleWord(true);
            txt.setEditable(false);
            this.add(txt);
            
            shopButton confirm = new shopButton("<html><Font='6', color='white'>Confirm</Font></html>");
            confirm.setVisible(true);
            confirm.setBounds(DEFAULT_WIDTH/2-50,
                              DEFAULT_GAP+DEFAULT_BOUND+DEFAULT_HEIGHT-120,
                              100,50);
            confirm.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    confirm.removeActionListener(this);
                    cui.npcFrameDispose();
                    cui.addFrameListener();
                    
                }
            });
            this.add(confirm);

        }
        
    }
    
    public int getWidth(){
        return DEFAULT_WIDTH;
    }
    
    public int getHeight(){
        return DEFAULT_HEIGHT;
    }
}