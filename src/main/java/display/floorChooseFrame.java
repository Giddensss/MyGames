package main.java.display;

import main.java.game.*;
import main.java.controllor.*;

import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class floorChooseFrame extends JPanel{

    private static final int DEFAULT_WIDTH = 548;
    private static final int DEFAULT_HEIGHT = 548;
    private static final int DEFAULT_BOUND = 4;
    
    private game myGame;
    private clientUI cui;
    private shopButton[] button = new shopButton[20];
    private shopButton quit = new shopButton("<html><Font color='white',size='4'>Close</Font></html>");
    private int floor = 0;
    
    private floorChooseListener cfl;
    
    public floorChooseFrame(game g,clientUI c){
        myGame = g;
        cui = c;
        
        setSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT));
        setPreferredSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT));
        setVisible(true);
        this.setLayout(null);
        
        setButton();

    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.fillRect(0,0,DEFAULT_WIDTH,DEFAULT_HEIGHT);
        paintBound(g,DEFAULT_WIDTH,DEFAULT_HEIGHT,DEFAULT_BOUND,0,0);
    }
    
    private void paintBound(Graphics g,int width, int height1, int bound,int startx, int starty){
        g.setColor(new Color(189,95,34));
        int[] x1 = {startx,
            width+startx,
            width+startx,
            width+startx-bound,
            width+startx-bound,
            bound+startx};
        
        int[] y1 = {starty,
            starty,
            height1+starty,
            height1+starty-bound,
            bound+starty,
            bound+starty};
        
        int[] x2 = {startx,
            startx,
            width+startx,
            width-bound+startx,
            bound+startx,
            bound+startx};
        int[] y2 = {starty,
            height1+starty,
            height1+starty,
            height1-bound+starty,
            height1-bound+starty,
            bound+starty};
        g.drawPolygon(x1,y1,6);
        g.drawPolygon(x2,y2,6);
        g.fillPolygon(x1,y1,6);
        g.fillPolygon(x2,y2,6);
    }
    
    private void setButton(){
        int bound = 24;
        int gap = 24;
        int gap_column = 37;
        int row = 0;
        
        for (int i = 0; i < 20; i++){
            button[i] = new shopButton("<html><Font size='4',color='white'>Floor " + (i+1) + "</Font></html>");
            button[i].setVisible(true);
            button[i].setBounds(gap_column+(gap_column+130)*(i%3),bound+(gap+50)*(row),130,40);
            if(i%3 ==2){
                row ++;
            }
            floor = i;
            button[i].setID(i);
            cfl = new floorChooseListener(myGame,cui);
            button[i].addMouseListener(cfl);
            this.add(button[i]);
        }
        quit.setVisible(true);
        quit.setBounds(gap_column+(gap_column+130)*2,bound+(gap+50)*6,130,40);
        quit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                cui.chooseFloorDispose();
                cui.addFrameListener();
            }
        });
        this.add(quit);
    }
    

}