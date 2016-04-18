package main.java.display.npcFrame;

import main.java.game.*;
import main.java.game.npc.*;
import main.java.display.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class theafFrame2 extends JPanel implements npcFrame{
    private game myGame;
    private theaf myTheaf;
    private final static int DEFAULT_WIDTH = 500;
    private final static int DEFAULT_HEIGHT = 300;
    private final static int DEFAULT_BOUND = 30;
    private final static int DEFAULT_GAP = 10;
    private JTextArea txt;
    private clientUI cui;
    public theafFrame2(game g, theaf t,clientUI c){
        myGame = g;
        myTheaf =t;
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
        if (myGame.hasItem("P") ){
            
            String words = "Theaf:\n\n\"Yes, that's the pickaxe which I am looking for. Thanks! And as I promised, I am going to the 18th floor and digging the hole for you. See you around.\"";
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
                    myGame.removeNPC(myTheaf);
                    confirm.removeActionListener(this);
                    cui.npcFrameDispose();
                    cui.addFrameListener();
                    
                }
            });
            
            this.add(confirm);
        }else{
            String words = "Theaf:\n\n\"Sorry, but I can help you without my pickaxe. Bring the pickaxe to me once you fined the pickaxe. \"";
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