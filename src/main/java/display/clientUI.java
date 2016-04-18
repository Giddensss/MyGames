package main.java.display;

import main.java.controllor.*;
import main.java.game.*;

import javax.swing.*;
import java.awt.*;


public class clientUI extends JFrame {
    private game myGame;
    private display myDis;
    private mainControllor myCon;
    private JPanel pan;
    
    private int width = 0;
    private int height = 0;
    private menuControllor mc;
    private inforBoard ib;
    private gameControllor gc;
    private Point start;
    private timerUI myTimer;
    private counterUI myCounter;
    public clientUI(game g, display d,mainControllor c){
        myGame = g;
        myDis = d;
        myCon = c;
        mc = new menuControllor(this,myGame,myDis);
        width = myDis.getWidth();
        height = myDis.getHeight()+105;
        
        int menuHeight = mc.getHeight();
        
        
        
        ib = new inforBoard(myDis,60-menuHeight);
        ib.setLocation(0,60-menuHeight);
        
        myTimer = new timerUI(ib,myGame);
        myCounter = new counterUI(ib,myGame);
        gc = new gameControllor(ib,myCon,myDis,myGame);
        myDis.setLocation(0,80);
        //myCon.addGameControllor(gc);
        
        this.setSize(new Dimension(width,height));
        this.setPreferredSize(new Dimension(width,height));
        this.getContentPane().add(mc);
        this.getContentPane().add(myDis);
        
        this.getContentPane().add(ib);

        this.pack();
        this.setVisible(true);
        int w = (Toolkit.getDefaultToolkit().getScreenSize().width - width) / 2;
        int h = (Toolkit.getDefaultToolkit().getScreenSize().height - height) / 2;
        start = new Point(w,h);
        this.setLocation(start);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(false);
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }
    
    public Point getStartPoint(){
        return start;
    }
    
    public void repaint(){
        this.dispose();
        myDis = new display(myGame);
        myCon = new mainControllor(myGame,myDis);
        new clientUI(myGame,myDis,myCon);
    }
}