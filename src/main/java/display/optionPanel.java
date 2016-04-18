package main.java.display;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.java.game.*;

public class optionPanel extends JPanel{
    
    private game myGame;
    private clientUI ui;
    private static final int DEFAULT_WIDTH = 308;
    private static final int DEFAULT_HEIGHT = 128;
    private static final int DEFAULT_LENGTH = 60;
    private static final int DEFAULT_BOUND = 4;
    
    public optionPanel(game g,clientUI c){
        myGame = g;
        ui = c;
        setSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT));
        setPreferredSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT));
        
        setLayout(null);
        
        setButtons();
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        paintBackground(g);
        paintBound(g);
        
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
    
    private void setButtons(){
        optButton save = new optButton("<html><font size='6' color='white'>Save </font></html>");
        save.setVisible(true);
        save.setBounds(34,10,110,50);
        save.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(!ui.isFightFrameVisible()){
                    myGame.save();
                    JOptionPane.showMessageDialog(ui,"Saved!");
                }
                
            }
        });
        this.add(save);
        optButton load = new optButton("<html><font size='6' color='white'>Load </font></html>");
        load.setVisible(true);
        load.setBounds(34,70,110,50);
        load.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(!ui.isFightFrameVisible()){
                    ui.disposeFrames();
                    myGame.load();
                    ui.update();
                }
            }
        });
        this.add(load);
        optButton restart = new optButton("<html><font size='6' color='white'>Restart </font></html>");
        restart.setVisible(true);
        restart.setBounds(164,10,110,50);
        restart.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(!ui.isFightFrameVisible()){
                    myGame.restart();
                    ui.update();
                    ui.disposeFrames();
                }
            }
        });
        this.add(restart);
        optButton quit = new optButton("<html><font size='6' color='white'>Quit </font></html>");
        quit.setVisible(true);
        quit.setBounds(164,70,110,50);
        quit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        this.add(quit);
    }
    
    public int getWidth(){
        return DEFAULT_WIDTH;
    }
    
    public int getHeight(){
        return DEFAULT_HEIGHT;
    }
}