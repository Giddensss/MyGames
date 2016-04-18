package main.java.display.npcFrame;

import javax.swing.*;
import java.awt.*;

import main.java.controllor.*;
import main.java.game.*;
import main.java.display.*;

public class expFrame extends JPanel implements npcFrame{
    
    private static final int DEFAULT_WIDTH = 308;
    private static final int DEFAULT_HEIGHT = 338;
    private static final int DEFAULT_BOUND = 4;
    private static final int DEFAULT_GAP = 5;
    
    private game myGame;
    private clientUI cui;
    private expListener el;
    private int level;
    private JButton levelB = new shopButton("");
    private JButton attack = new shopButton("");
    private JButton defense = new shopButton("");
    private JButton quit = new shopButton("<html><font color='white'>Leave</font></html>");
    private JLabel info = new JLabel();
    private ImageIcon icon = new ImageIcon("source/materials/npc/exp.png");

    public expFrame(game g,clientUI c){
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
        el = new expListener(level,myGame,this,cui);
        setLabel();
        setButtons(level);
        setSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT));
        setPreferredSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT));
        setLayout(null);
    }
    
    private void setLabel(){
        
        
        String s = "";
        
        s = "<html><font color='white'>Hello warrior. I can help you<br/> to strength your power if<br/> you have enough EXP.</font></html>";
        
        info.setText(s);
        info.setBounds(100,0,225,90);
        info.setVisible(true);
        this.add(info);
    }
    
    private void setButtons(int level){
        if (level == 5){
            levelB.setText("<html><font color='white'>Level up by 1 (100 EXP)</font></html>");
            attack.setText("<html><font color='white'>Increase 5 Attack (30 EXP)</font></html>");
            defense.setText("<html><font color='white'>Increase 5 Defense (30 EXP)</font></html>");
        }
        else if (level == 13){
            levelB.setText("<html><font color='white'>Level up by 3 (270 EXP)</font></html>");
            attack.setText("<html><font color='white'>Increase 17 Attack (95 EXP)</font></html>");
            defense.setText("<html><font color='white'>Increase 17 Defense (95 EXP)</font></html>");
        }
        
        levelB.setBounds(10,90,290,50);
        levelB.setVisible(true);
        levelB.addMouseListener(el);
        this.add(levelB);
        attack.setBounds(10,150,290,50);
        attack.setVisible(true);
        attack.addMouseListener(el);
        this.add(attack);
        defense.setBounds(10,210,290,50);
        defense.setVisible(true);
        defense.addMouseListener(el);
        this.add(defense);
        quit.setBounds(10,270,290,50);
        quit.setVisible(true);
        quit.addMouseListener(el);
        this.add(quit);
    }
    
    public JButton getLevel(){
        return levelB;
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
    
    public void removeMouseListener(){
        levelB.removeMouseListener(el);
        attack.removeMouseListener(el);
        defense.removeMouseListener(el);
        quit.removeMouseListener(el);
    }
    
    
}