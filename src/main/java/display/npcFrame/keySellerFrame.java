package main.java.display.npcFrame;

import javax.swing.*;
import java.awt.*;

import main.java.controllor.*;
import main.java.game.*;
import main.java.display.*;

public class keySellerFrame extends JPanel implements npcFrame{
    
    private static final int DEFAULT_WIDTH = 308;
    private static final int DEFAULT_HEIGHT = 338;
    private static final int DEFAULT_BOUND = 4;
    private static final int DEFAULT_GAP = 5;
    
    private game myGame;
    private clientUI cui;
    private keyListener kl;
    private int level;
    private JButton yellow = new shopButton("");
    private JButton blue = new shopButton("");
    private JButton red = new shopButton("");
    private JButton quit = new shopButton("<html><font color='white'>Leave</font></html>");
    private JLabel info = new JLabel();
    private ImageIcon icon = new ImageIcon("source/materials/npc/key.png");

    public keySellerFrame(game g,clientUI c){
        myGame = g;
        cui = c;
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
        level = myGame.getLevel();
        kl = new keyListener(level,myGame,this,cui);
        setLabel(level);
        setButtons(level);
        setSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT));
        setPreferredSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT));
        setLayout(null);
    }
    
    private void setLabel(int l){
        
        
        String s = "";
        
        if (l == 5) {
            s = "<html><font color='white'>Hello warrior. Are you looking<br/> for keys? I can sell you keys<br/> that you need if you have enough<br/> gold.</font></html>";
            info.setText(s);
            info.setBounds(85,0,225,90);
            info.setVisible(true);
        }else if (l == 12){
            s = "<html><font color='white'>Hello warrior. If you have extra keys, I will buy them, and you<br/> can get gold back.</font></html>";
            info.setText(s);
            info.setBounds(100,0,225,90);
            info.setVisible(true);
        }
        
       
        
        
        this.add(info);
    }
    
    private void setButtons(int level){
        if (level == 5){
            yellow.setText("<html><font color='white'>Yellow Key (10G Each)</font></html>");
            blue.setText("<html><font color='white'>Blue Key  (50G Each )</font></html>");
            red.setText("<html><font color='white'>Red Key  (100G Each)</font></html>");
        }
        else if (level == 12){
            yellow.setText("<html><font color='white'>Yellow Key (7G Each)</font></html>");
            blue.setText("<html><font color='white'>Blue Key (35G Each)</font></html>");
            red.setText("<html><font color='white'>Red Key (70G Each)</font></html>");
        }
        
        yellow.setBounds(10,90,290,50);
        yellow.setVisible(true);
        yellow.addMouseListener(kl);
        this.add(yellow);
        blue.setBounds(10,150,290,50);
        blue.setVisible(true);
        blue.addMouseListener(kl);
        this.add(blue);
        red.setBounds(10,210,290,50);
        red.setVisible(true);
        red.addMouseListener(kl);
        this.add(red);
        quit.setBounds(10,270,290,50);
        quit.setVisible(true);
        quit.addMouseListener(kl);
        this.add(quit);
    }
    
    public JButton getYellow(){
        return yellow;
    }
    
    public JButton getBlue(){
        return blue;
    }
    
    public JButton getRed(){
        return red;
    }
    
    public JButton getQuit(){
        return quit;
    }
    
    public void dispose(){
        this.dispose();
    }
    
    public int getWidth(){
        return DEFAULT_WIDTH;
    }
    
    public int getHight(){
        return DEFAULT_HEIGHT;
    }
    
    public void removeMouseListener(){
        yellow.removeMouseListener(kl);
        blue.removeMouseListener(kl);
        red.removeMouseListener(kl);
        quit.removeMouseListener(kl);
    }
    
    
}