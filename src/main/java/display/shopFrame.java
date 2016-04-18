package main.java.display;

import javax.swing.*;
import java.awt.*;

import main.java.controllor.*;
import main.java.game.*;


public class shopFrame extends JPanel{
    
    private static final int DEFAULT_WIDTH = 308;
    private static final int DEFAULT_HEIGHT = 338;
    private static final int DEFAULT_BOUND = 4;
    private static final int DEFAULT_GAP = 5;
    
    private game myGame;
    private clientUI cui;
    private shopListener sl;
    private int level;
    private JButton health = new shopButton("");
    private JButton attack = new shopButton("");
    private JButton defense = new shopButton("");
    private JButton quit = new shopButton("<html><font color='white'>Leave</font></html>");
    private JLabel info = new JLabel();
    private ImageIcon icon = new ImageIcon("source/materials/map/second.png");

    public shopFrame(game g,clientUI c){
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
        sl = new shopListener(level,myGame,this,cui);
        setLabel(level);
        setButtons(level);
        setSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT));
        setPreferredSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT));
        setLayout(null);
    }
    
    private void setLabel(int level){
        
        
        String s = "";
        if (level == 3){
            s = "<html><font color='white'>You can click to purchase<br/> the Items that are listed<br/> below. Each will cost 25 gold.</font></html>";
        }
        else if (level == 11){
            s =  "<html><font color='white'>You can click to purchase<br/> the Items that are listed<br/> below. Each will cost 100 gold.</font></html>";
        }
        
        info.setText(s);
        info.setBounds(100,0,225,90);
        info.setVisible(true);
        this.add(info);
    }
    
    private void setButtons(int level){
        if (level == 3){
            health.setText("<html><font color='white'>Increase 800 HP</font></html>");
            attack.setText("<html><font color='white'>Increase 4 Attack</font></html>");
            defense.setText("<html><font color='white'>Increase 4 Defense</font></html>");
        }
        else if (level == 11){
            health.setText("<html><font color='white'>Increase 4000 HP</font></html>");
            attack.setText("<html><font color='white'>Increase 20 Attack</font></html>");
            defense.setText("<html><font color='white'>Increase 20 Defense</font></html>");
        }
        
        health.setBounds(10,90,290,50);
        health.setVisible(true);
        health.addMouseListener(sl);
        this.add(health);
        attack.setBounds(10,150,290,50);
        attack.setVisible(true);
        attack.addMouseListener(sl);
        this.add(attack);
        defense.setBounds(10,210,290,50);
        defense.setVisible(true);
        defense.addMouseListener(sl);
        this.add(defense);
        quit.setBounds(10,270,290,50);
        quit.setVisible(true);
        quit.addMouseListener(sl);
        this.add(quit);
    }
    
    public JButton getHealth(){
        return health;
    }
    
    public JButton getAttack(){
        return attack;
    }
    
    public JButton getDefense(){
        return defense;
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
    
    public void removeListener(){
        health.removeMouseListener(sl);
        attack.removeMouseListener(sl);
        defense.removeMouseListener(sl);
        quit.removeMouseListener(sl);
    }
    
    
}