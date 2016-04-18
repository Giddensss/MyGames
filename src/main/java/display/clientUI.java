package main.java.display;

import javax.swing.*;
import main.java.game.*;
import main.java.game.npc.*;
import main.java.controllor.*;
import main.java.display.npcFrame.*;
import main.java.display.infoPanel.*;
import java.awt.*;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class clientUI extends JFrame{
    
    private static final int DEFAULT_WIDTH = 1140;
    private static final int DEFAULT_HEIGHT = 840;
    private static final int DEFAULT_LENGTH = 60;

    private boolean isFightVisible = false;
 
    
    private game myGame;
    private map myMap;
    
    private JPanel pan;
    
    private inforPanel myInf;
    
    private floorChooseFrame fcf;
    private minionCheckPanel myCheck;
    private shopFrame myShop;
    private JPanel info;
    private JPanel n_p;
    
    private npcFrameAbstractFactory nfa;
    private panelAbstractFactory paf;
    
    private URL cb;
    private AudioClip bgm;
    private Applet bgm_app;
   
    
    
    public clientUI(game g){
        myGame = g;
        myMap = new map(myGame);
        myInf = new inforPanel(myGame,this);
        
        //myCheck = new minionCheckPanel(myGame,this);
        backGround myBack = new backGround();
        
        this.setSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT));
        this.setPreferredSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT));
        this.getContentPane().add(myInf);
        this.getContentPane().add(myMap);
        this.add(myBack);
        
        
        
        paf = new panelFactoryProducer().getFactory("info");
        nfa = new npcFrameFactoryProducer().getFactory("frame");
        
        int[] size = myMap.returnSize();
        
        myMap.setLocation(new Point(420,DEFAULT_HEIGHT/2-size[1]/2-15));
        
        
        
        myInf.setLocation(new Point(56,DEFAULT_HEIGHT/2-myInf.getHeight()/2-10));
        
        this.setVisible(true);
        this.pack();
        
        int w = (Toolkit.getDefaultToolkit().getScreenSize().width - DEFAULT_WIDTH) / 2;
        int h = (Toolkit.getDefaultToolkit().getScreenSize().height - DEFAULT_HEIGHT) / 2;
        Point start = new Point(w,h);
        this.setLocation(start);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(false);
        //this.setBGM(myGame.getLevel());
    }
    
    
    public void update(){
       // this.setBGM(myGame);
        myMap.update();
        //repaint();
    }
    
    public void updateWarrior(int x,int y){
        myMap.updateWarrior(x,y);
        
    }
    
    
    public void showFight(int[] mininfo,String min){
        fightingFrame fight = new fightingFrame(myGame,this,min,mininfo);
        fight.setLocation(new Point((myMap.returnSize()[0]-fight.getWidth())/2,
                                    (myMap.returnSize()[1]-fight.getHeight())/2));
        isFightVisible = true;
        myMap.add(fight);
        
        
        
    }
    
    public void addFrameListener(){
        Toolkit.getDefaultToolkit().addAWTEventListener(new mainListener(myGame,this),AWTEvent.KEY_EVENT_MASK);
    }
    
    public void showCheckBoard(){
        myCheck = new minionCheckPanel(myGame,this);
        myMap.add(myCheck);
        myCheck.enableListener();
    }
    
    public void checkBoardDispose(){
        myMap.remove(myCheck);
        myCheck.setVisible(false);
        this.repaint();
    }
    
    public void showInfoPan(String s){
        infoPanel i = paf.getPanel(s);
        i.setClientUI(this);
        info = new JPanel();
        info = (JPanel)(i);
        info.setVisible(true);
        info.setLocation(new Point(myMap.returnSize()[0]/2-info.getWidth()/2,myMap.returnSize()[1]/2-info.getHeight()/2));
        myMap.add(info);
        
    }
    
    public void infoPanDispose(){
        myMap.remove(info);
        info.setVisible(false);
       
        
    }
    
    public void showNPCFrame(String n, int i, game g, npc np, clientUI c){
        
        npcFrame n_p_c = nfa.getFrame(n,i,g,np,c);
        n_p = new JPanel();
        n_p = (JPanel)(n_p_c);
        n_p.setVisible(true);
        n_p.setLocation(new Point(myMap.returnSize()[0]/2-n_p.getWidth()/2,
                                myMap.returnSize()[1]/2-n_p.getHeight()/2));
        myMap.add(n_p);
     
    }
    
    public void npcFrameDispose(){
        myMap.remove(n_p);
        n_p.setVisible(false);
       
    }

    
    public void showChooseFloor(){
        fcf = new floorChooseFrame(myGame,this);
        myMap.add(fcf);
        fcf.setLocation(new Point(64,64));
    }
   
    public void chooseFloorDispose(){
        myMap.remove(fcf);
        fcf.setVisible(false);
        
    }
    
    public void showShop(){
        myShop = new shopFrame(myGame,this);
        myMap.add(myShop);
        myShop.setLocation(new Point(myMap.returnSize()[0]/2-myShop.getWidth()/2,
                                     myMap.returnSize()[1]/2-myShop.getHeight()/2));

    }
    
    public void shopDispose(){
        myMap.remove(myShop);
        myShop.setVisible(false);
        
    }
    
    
    public game getGame(){
        return myGame;
    }
    
    public void setFightFrameVisibility(boolean b){
        isFightVisible = b;
    }
    
    public void disposeFrames(){
        if (fcf != null && fcf.isVisible()){
            chooseFloorDispose();
        }
        if (myCheck != null && myCheck.isVisible()){
            checkBoardDispose();
        }
        if (myShop != null && myShop.isVisible()){
            shopDispose();
        }
        if (info != null && info.isVisible()){
            infoPanDispose();
        }
        if (n_p != null && n_p.isVisible()){
            npcFrameDispose();
            
        }
    }
    
    public boolean isFightFrameVisible(){
        return isFightVisible;
    }
    
    public void resetWarriorIcon(){
        myMap.resetWarriorIcon();
    }
    
    
    public void setBGM(int l){
        String s = "";
        if( l == 0){
            s = "source/BGM/3.wav";
        }else if (l == 1){
            s = "source/BGM/4.wav";
        }else if (l == 8){
            s = "source/BGM/5.wav";
        }else if (l == 15){
            s = "source/BGM/6.wav";
        }else if (l == 21){
            s = "source/BGM/7.wav";
        }
        try{
            
            File f = new File(s);
            URL cb;
            cb = f.toURL();
            bgm_app = new Applet();
            bgm = bgm_app.newAudioClip(cb);
           // bgm.stop();
            bgm.play();
            bgm.loop();
            
        }catch(MalformedURLException e){
            e.printStackTrace();
        }
    }

    
}
