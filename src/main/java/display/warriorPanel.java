package main.java.display;

import java.awt.*;
import javax.swing.*;

import main.java.game.*;

public class warriorPanel extends JPanel{

    private game myGame;
    private static final int DEFAULT_WIDTH = 308;
    private static final int DEFAULT_HEIGHT = 368;
    private static final int DEFAULT_LENGTH = 60;
    private static final int DEFAULT_BOUND = 4;
    private JLabel level = new JLabel();
    private JLabel health = new JLabel();
    private JLabel healthNum = new JLabel();
    private JLabel attack = new JLabel();
    private JLabel attNum = new JLabel();
    private JLabel def = new JLabel();
    private JLabel defNum = new JLabel();
    private JLabel gold = new JLabel();
    private JLabel goldNum = new JLabel();
    private JLabel exp = new JLabel();
    private JLabel expNum = new JLabel();
    public warriorPanel(game g){
        myGame = g;
        
        setSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT));
        setPreferredSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT));
        
        setLayout(null);
    
        

    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        paintBackground(g);
        paintBound(g);
        paintIcon(g);
        paintInf();
        paintOtherInf();
        repaint();


    }
    
    private void paintBackground(Graphics g){
        ImageIcon icon = new ImageIcon("source/materials/map/Image 69 at frame 0.png");
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 6; j++){
                g.drawImage(icon.getImage(),i*DEFAULT_LENGTH+DEFAULT_BOUND,j*DEFAULT_LENGTH+DEFAULT_BOUND,DEFAULT_LENGTH,DEFAULT_LENGTH,this);
            }
        }
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
        ImageIcon icon = new ImageIcon("source/materials/warrior/1.png");
        g.drawImage(icon.getImage(),30,20,70,70,this);
    }
    
    private void paintInf(){
        level.setText("<html><font size='10' color='white'>LV. &nbsp "+myGame.getWarriorLevel()+"</font></html>");
        level.setVisible(true);
        
        level.setBounds(154,24,200,50);
        
        this.add(level);
    }
    
    private void paintOtherInf(){
        
        health.setText("<html><font size='10' color='white'>HP</font></html>");
        healthNum.setText("<html><font size='7' color='white'>"+myGame.getWarriorHealth()+"</font></html>");
        health.setVisible(true);
        healthNum.setVisible(true);
        health.setBounds(34,100,50,50);
        healthNum.setBounds(150,100,200,50);
        this.add(health);
        this.add(healthNum);
        
        attack.setText("<html><font size='10' color='white'>Att. </font></html>");
        attNum.setText("<html><font size='7' color='white'>"+myGame.getWarriorAttack()+"</font></html>");
        attack.setVisible(true);
        attNum.setVisible(true);
        attack.setBounds(34,150,70,50);
        attNum.setBounds(150,150,200,50);
        this.add(attack);
        this.add(attNum);
        
        def.setText("<html><font size='10' color='white'>Def. </font></html>");
        defNum.setText("<html><font size='7' color='white'>"+myGame.getWarriorDefense()+"</font></html>");
        def.setVisible(true);
        defNum.setVisible(true);
        def.setBounds(34,200,70,50);
        defNum.setBounds(150,200,200,50);
        this.add(def);
        this.add(defNum);
        
        gold.setText("<html><font size='10' color='white'>Gold </font></html>");
        goldNum.setText("<html><font size='7' color='white'>"+myGame.getWarriorGold()+"</font></html>");
        gold.setVisible(true);
        goldNum.setVisible(true);
        gold.setBounds(34,250,80,50);
        goldNum.setBounds(150,250,200,50);
        this.add(gold);
        this.add(goldNum);
        
        exp.setText("<html><font size='10' color='white'>EXP </font></html>");
        expNum.setText("<html><font size='7' color='white'>"+myGame.getWarriorExp()+"</font></html>");
        exp.setVisible(true);
        expNum.setVisible(true);
        exp.setBounds(34,300,80,50);
        expNum.setBounds(150,300,200,50);
        this.add(exp);
        this.add(expNum);
    }
    
    public int getWidth(){
        return DEFAULT_WIDTH;
    }
    
    public int getHeight(){
        return DEFAULT_HEIGHT;
    }
}