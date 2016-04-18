package main.java.display;

import javax.swing.*;
import java.awt.*;

import main.java.game.*;

public class keyPanel extends JPanel{
    private static final int DEFAULT_WIDTH = 308;
    private static final int DEFAULT_HEIGHT = 248;
    private static final int DEFAULT_LENGTH = 60;
    private static final int DEFAULT_BOUND =4;
    private JLabel yellow = new JLabel();
    private JLabel blue = new JLabel();
    private JLabel red = new JLabel();
    private JLabel floor = new JLabel();
    private game myGame;
    public keyPanel(game g){
        myGame = g;
        
        setSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT));
        setPreferredSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT));
        
        setLayout(null);
        
        
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        paintBackground(g);
        paintBound(g);
        paintKeys(g);
        paintInf();
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
        
        int[] x3 = {0,DEFAULT_WIDTH,DEFAULT_WIDTH,0};
        int[] y3 = {(DEFAULT_HEIGHT-2*DEFAULT_BOUND)/4*3+DEFAULT_BOUND/2,
            (DEFAULT_HEIGHT-2*DEFAULT_BOUND)/4*3+DEFAULT_BOUND/2,
            (DEFAULT_HEIGHT-2*DEFAULT_BOUND)/4*3+DEFAULT_BOUND+DEFAULT_BOUND/2,
            (DEFAULT_HEIGHT-2*DEFAULT_BOUND)/4*3+DEFAULT_BOUND+DEFAULT_BOUND/2};
        g.drawPolygon(x1,y1,6);
        g.drawPolygon(x2,y2,6);
        g.drawPolygon(x3,y3,4);
        g.fillPolygon(x1,y1,6);
        g.fillPolygon(x2,y2,6);
        g.fillPolygon(x3,y3,4);
        
    }
    
    private void paintKeys(Graphics g){
        ImageIcon icon1 = new ImageIcon("source/materials/keys/1.png");
        ImageIcon icon2 = new ImageIcon("source/materials/keys/2.png");
        ImageIcon icon3 = new ImageIcon("source/materials/keys/3.png");
        
        g.drawImage(icon1.getImage(),34,10,55,55,this);
        g.drawImage(icon2.getImage(),34,69,55,55,this);
        g.drawImage(icon3.getImage(),34,125,55,55,this);
    }
    
    private void paintInf(){
        yellow.setText("<html><font size='7' color='white'>"+myGame.getYellowKey()+"</font></html>");
        yellow.setVisible(true);
        yellow.setBounds(150,5,200,50);
        this.add(yellow);
        blue.setText("<html><font size='7' color='white'>"+myGame.getBlueKey()+"</font></html>");
        blue.setVisible(true);
        blue.setBounds(150,67,200,50);
        this.add(blue);
        red.setText("<html><font size='7' color='white'>"+myGame.getRedKey()+"</font></html>");
        red.setVisible(true);
        red.setBounds(150,125,200,50);
        this.add(red);
        floor.setText("<html><font size='7' color='white'> Floor &nbsp &nbsp "+myGame.getLevel()+"</font></html>");
        floor.setVisible(true);
        floor.setBounds(60,186,300,50);
        this.add(floor);
    }

    
    public int getWidth(){
        return DEFAULT_WIDTH;
    }
    
    public int getHeight(){
        return DEFAULT_HEIGHT;
    }
}