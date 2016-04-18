package main.java.display.npcFrame;

import main.java.game.*;
import main.java.game.npc.*;
import main.java.display.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class princessFrame extends JPanel implements npcFrame{
    private game myGame;
    private princess myPrincess;
    private final static int DEFAULT_WIDTH = 500;
    private final static int DEFAULT_HEIGHT = 300;
    private final static int DEFAULT_BOUND = 30;
    private final static int DEFAULT_GAP = 10;
    private JTextArea txt;
    private clientUI cui;
    public princessFrame(game g, princess p,clientUI c){
        myGame = g;
        myPrincess =p;
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
        if (myPrincess.getStatus() == 0 ){
            
            String words = "Princess:\n\n\"My hero, you made it! However, I can't go with you if you don't kill Mingling Mowang. He cursed me that I would die once I left the Mota. Therefore, you have to kill him and break the curse. \nI will show you the path to next floor, but you need to be more careful because once you are on 21st Floor, you cannot come back only if you kill Mingling Mowang.\nI know you won't disspoint me, and wish you good luck!\"";
            txt = new JTextArea(words);
            txt.setVisible(true);
            txt.setBackground(Color.black);
            txt.setForeground(Color.white);
            txt.setBounds(DEFAULT_GAP+DEFAULT_BOUND,
                          DEFAULT_GAP+DEFAULT_BOUND,
                          DEFAULT_WIDTH-2*(DEFAULT_GAP+DEFAULT_BOUND),
                          DEFAULT_HEIGHT-90-2*(DEFAULT_GAP+DEFAULT_BOUND));
            txt.setFont(new Font("Times new Rome", Font.PLAIN, 15));
            txt.setLineWrap(true);
            txt.setWrapStyleWord(true);
            txt.setEditable(false);
            this.add(txt);
            
            shopButton confirm = new shopButton("<html><Font='6', color='white'>Confirm</Font></html>");
            confirm.setVisible(true);
            confirm.setBounds(DEFAULT_WIDTH/2-50,
                              DEFAULT_GAP+DEFAULT_BOUND+DEFAULT_HEIGHT-120,
                              100,40);
            confirm.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    myGame.loadMap("source/map/level18/mapAlt2.txt");
                    myGame.addSpecialItem("R");
                    myPrincess.setStatus(1);
                    confirm.removeActionListener(this);
                    cui.npcFrameDispose();
                    
                }
            });
            
            this.add(confirm);
        }else if (myPrincess.getStatus() == 1 ){
            if (!myGame.hasItem("B")){
                String words = "Princess:\n\n\"I can't go with you since you haven't break the curse yet. \nGo and kill that monster!\"";
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
                                  100,40);
                confirm.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        confirm.removeActionListener(this);
                        cui.npcFrameDispose();
                        cui.addFrameListener();
                        
                    }
                });
                this.add(confirm);

            }else{
                String words = "Princess:\n\n\"You made it, my hero! Thank you! Let's go home!\"";
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
                                  100,40);
                confirm.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        System.exit(0);                        
                    }
                });
                this.add(confirm);

            }
            
        }
        
    }
    
    public int getWidth(){
        return DEFAULT_WIDTH;
    }
    
    public int getHeight(){
        return DEFAULT_HEIGHT;
    }
}