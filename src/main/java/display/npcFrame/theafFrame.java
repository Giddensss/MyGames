package main.java.display.npcFrame;

import main.java.game.*;
import main.java.game.npc.*;
import main.java.display.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class theafFrame extends JPanel implements npcFrame{
    private game myGame;
    private theaf myTheaf;
    private final static int DEFAULT_WIDTH = 500;
    private final static int DEFAULT_HEIGHT = 500;
    private final static int DEFAULT_BOUND = 30;
    private final static int DEFAULT_GAP = 10;
    private JTextArea txt;
    private clientUI cui;
    public theafFrame(game g, theaf t,clientUI c){
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
        if (myTheaf.getStatus() == 0 ){
            
            String words = "Theaf:\n\n\"Oh, hey, I... Well, I am an explorer. I was caught by those minions while I was exploring the Mota. Thanks for saving my life! In return, I will help you to open the gate on SECOND floor. (Well, unlocking is always my strength.)\n\nBy the way, the minions took my pickaxe away, and I don't know where they put the pickaxe. So if you  find my pickaxe, bring it to me, so I can dig a hole on 18th floor which will let you rescue the princess.\n\nBe save my friend. I will be here waiting for you.  \"";
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
                    myTheaf.setStatus(1);
                    myGame.addSpecialItem("T");
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