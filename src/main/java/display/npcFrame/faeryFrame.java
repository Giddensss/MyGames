package main.java.display.npcFrame;

import main.java.game.*;
import main.java.game.npc.*;
import main.java.display.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class faeryFrame extends JPanel implements npcFrame{
    private game myGame;
    private faery myFaery;
    private final static int DEFAULT_WIDTH = 500;
    private final static int DEFAULT_HEIGHT = 500;
    private final static int DEFAULT_BOUND = 30;
    private final static int DEFAULT_GAP = 10;
    private JTextArea txt;
    private clientUI cui;
    public faeryFrame(game g, faery f,clientUI c){
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
        if (myFaery.getStatus() == 0 ){
            
            String words = "Fairy:\n\n\"Hey, you are awake! I saved you after you passed out. By the way, I'm  the faery of this Mota.\n\nYou were beaten by the minions minutes ago, and they took away your amors. Therefore, your power has been weaken. I know you are here to rescue the princess, but don't worry, I can help you if you can find one thing for me. It's a CROSS with a RED GEM in the middle. Bring it to me, and I will give my power to you.\n\nOh one more thing, I find that your sword is stored on THIRD floor and your shield is stored on FIFTH floor.\n\n Here are the keys. Go, warrior!\"";
            txt = new JTextArea(words);
            txt.setVisible(true);
            txt.setBackground(Color.black);
            txt.setForeground(Color.white);
            txt.setBounds(DEFAULT_GAP+DEFAULT_BOUND,
                          DEFAULT_GAP+DEFAULT_BOUND,
                          DEFAULT_WIDTH-2*(DEFAULT_GAP+DEFAULT_BOUND),
                          DEFAULT_HEIGHT-100-2*(DEFAULT_GAP+DEFAULT_BOUND));
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
                    myFaery.setPos(4,8);
                    myGame.setYellowKey(1);
                    myGame.setBlueKey(1);
                    myGame.setRedKey(1);
                    myFaery.setStatus(1);
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