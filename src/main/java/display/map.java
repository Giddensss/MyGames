package main.java.display;

import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.ImageIcon;
import main.java.display.gif.*;
import main.java.game.*;
import main.java.game.npc.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class map extends JPanel implements ActionListener{
    
    private abstractFactory envF;
    private abstractFactory itmF;
    private abstractFactory npcF;
    private abstractFactory minF;
    private game myGame;
    private static final int DEFAULT_WIDTH = 11;
    private static final int DEFAULT_HEIGHT = 11;
    private static final int DEFAULT_LENGTH = 60;
    private static final int DEFAULT_BOUND = 4;
    private int startX = 0;
    private int startY = 0;
    private char[][] map = new char[11][11];
    private char[][] itm = new char[11][11];
    private char[][] min = new char[11][11];
    private String warrior = "source/materials/warrior/1.png";
    private int[] pos = new int[2];
    private int[] size = {DEFAULT_WIDTH*DEFAULT_LENGTH+2*DEFAULT_BOUND,DEFAULT_HEIGHT*DEFAULT_LENGTH+2*DEFAULT_BOUND};
    private LinkedList<int[]> y;
    private LinkedList<int[]> b;
    private LinkedList<int[]> r;
    private LinkedList<int[]> gate;
    private LinkedList<int[]> f;
    private LinkedList<npc> npcList;
    private javax.swing.Timer t;
    
    private int counter = 0;
    private int warriorMotionCounter = -1;
    private int warriorStatus = 1;
    
    public map(game g){
        envF = new factoryProducer().getFactory("environment");
        itmF = new factoryProducer().getFactory("item");
        npcF = new factoryProducer().getFactory("npc");
        minF = new factoryProducer().getFactory("minions");
        myGame = g;
        map = myGame.getMap();
        itm = myGame.getItem();
        setSize(new Dimension(DEFAULT_WIDTH*DEFAULT_LENGTH+2*DEFAULT_BOUND,DEFAULT_HEIGHT*DEFAULT_LENGTH+2*DEFAULT_BOUND));
        setPreferredSize(new Dimension(DEFAULT_WIDTH*DEFAULT_LENGTH+2*DEFAULT_BOUND,DEFAULT_HEIGHT*DEFAULT_LENGTH+2*DEFAULT_BOUND));
        pos = myGame.getWarriorPos();
        
        y = myGame.getYellowDoor();
        b = myGame.getBlueDoor();
        r = myGame.getRedDoor();
        gate = myGame.getGate();
        f = myGame.getFence();
        npcList = myGame.getNPCList();
        t = new javax.swing.Timer(200,this);
        t.start();
        this.requestFocus();
        
        
        setLayout(null);
        
        
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        paintBound(g);
        paintAllElement(g);
        //paintEnvironment(g);
        paintWarrior(g);
        paintDoor(g);
        //paintItem(g);
        paintNPC(g);
        //paintMinions(g);
        repaint();
    }
    
    private void paintAllElement(Graphics g){
        min = myGame.getMinions();
        for (int i = 0; i < DEFAULT_WIDTH * DEFAULT_HEIGHT; i++){
            //environment
            environment e = envF.getEnv(String.valueOf(map[(i/DEFAULT_WIDTH)][i-(i/DEFAULT_WIDTH)*DEFAULT_HEIGHT]));
            e.setLocation((i/DEFAULT_WIDTH)*DEFAULT_LENGTH+DEFAULT_BOUND+startX,(i-(i/DEFAULT_WIDTH)*DEFAULT_HEIGHT)*DEFAULT_LENGTH+DEFAULT_BOUND+startY);
            e.show(g,(counter % 2));
            
            //item
            item it = itmF.getItems(String.valueOf(itm[(i/DEFAULT_WIDTH)][i-(i/DEFAULT_WIDTH)*DEFAULT_HEIGHT]));
            it.setLocation((i/DEFAULT_WIDTH)*DEFAULT_LENGTH+DEFAULT_BOUND+startX,(i-(i/DEFAULT_WIDTH)*DEFAULT_HEIGHT)*DEFAULT_LENGTH+DEFAULT_BOUND+startY);
            it.show(g);
            
            //minion
            minionsdis m = minF.getMin(String.valueOf(min[(i/DEFAULT_WIDTH)][i-(i/DEFAULT_WIDTH)*DEFAULT_HEIGHT]));
            m.setLocation((i/DEFAULT_WIDTH)*DEFAULT_LENGTH+DEFAULT_BOUND+startX,(i-(i/DEFAULT_WIDTH)*DEFAULT_HEIGHT)*DEFAULT_LENGTH+DEFAULT_BOUND+startY);
            m.show(g, (counter % 2));

            
                
        }
    }
    
    private void paintEnvironment(Graphics g){
        for (int i = 0; i < DEFAULT_WIDTH * DEFAULT_HEIGHT; i++){
            environment e = envF.getEnv(String.valueOf(map[(i/DEFAULT_WIDTH)][i-(i/DEFAULT_WIDTH)*DEFAULT_HEIGHT]));
            e.setLocation((i/DEFAULT_WIDTH)*DEFAULT_LENGTH+DEFAULT_BOUND+startX,(i-(i/DEFAULT_WIDTH)*DEFAULT_HEIGHT)*DEFAULT_LENGTH+DEFAULT_BOUND+startY);
            e.show(g,(counter % 2));
    }
        

    }
    
    private void paintItem(Graphics g){
        for (int i = 0; i < DEFAULT_WIDTH * DEFAULT_HEIGHT; i++){
            item it = itmF.getItems(String.valueOf(itm[(i/DEFAULT_WIDTH)][i-(i/DEFAULT_WIDTH)*DEFAULT_HEIGHT]));
            it.setLocation((i/DEFAULT_WIDTH)*DEFAULT_LENGTH+DEFAULT_BOUND+startX,(i-(i/DEFAULT_WIDTH)*DEFAULT_HEIGHT)*DEFAULT_LENGTH+DEFAULT_BOUND+startY);
            it.show(g);
        }
        
        
    }

    
    private void paintBound(Graphics g){
        g.setColor(new Color(189,95,34));
        int[] x1 = {startX,
                    startX+DEFAULT_WIDTH*DEFAULT_LENGTH+DEFAULT_BOUND*2,
                    startX+DEFAULT_WIDTH*DEFAULT_LENGTH+DEFAULT_BOUND*2,
                    startX+DEFAULT_WIDTH*DEFAULT_LENGTH+DEFAULT_BOUND,
                    startX+DEFAULT_WIDTH*DEFAULT_LENGTH+DEFAULT_BOUND,
                    startX+DEFAULT_BOUND};
        int[] y1 = {startY,
                    startY,
                    startY+DEFAULT_HEIGHT*DEFAULT_LENGTH+2*DEFAULT_BOUND,
                    startY+DEFAULT_HEIGHT*DEFAULT_LENGTH+DEFAULT_BOUND,
                    startY+DEFAULT_BOUND,
                    startY+DEFAULT_BOUND};
        
        int[] x2 = {startX,
                    startX,
                    startX+DEFAULT_WIDTH*DEFAULT_LENGTH+2*DEFAULT_BOUND,
                    startX+DEFAULT_WIDTH*DEFAULT_LENGTH+DEFAULT_BOUND,
                    startX+DEFAULT_BOUND,
                    startX+DEFAULT_BOUND};
        int[] y2 = {startY,
                    startY+DEFAULT_HEIGHT*DEFAULT_LENGTH+2*DEFAULT_BOUND,
                    startY+DEFAULT_HEIGHT*DEFAULT_LENGTH+2*DEFAULT_BOUND,
                    startY+DEFAULT_HEIGHT*DEFAULT_LENGTH+DEFAULT_BOUND,
                    startY+DEFAULT_HEIGHT*DEFAULT_LENGTH+DEFAULT_BOUND,
                    startY+DEFAULT_BOUND};
        g.fillPolygon(x1,y1,6);
        g.fillPolygon(x2,y2,6);
    }
    
    private void paintWarrior(Graphics g){
       // System.out.println(warriorStatus+" "+warriorMotionCounter);
        if(warriorMotionCounter == 1){
            warrior = "source/materials/warrior/"+warriorStatus+"1.png";
        }else if (warriorMotionCounter == 2){
            warrior = "source/materials/warrior/"+warriorStatus+"2.png";
        }else {
            warrior = "source/materials/warrior/"+warriorStatus+".png";
        }
        ImageIcon icon = new ImageIcon(warrior);
        
        g.drawImage(icon.getImage(),pos[0]*DEFAULT_LENGTH+startX+DEFAULT_BOUND,pos[1]*DEFAULT_LENGTH+startY+DEFAULT_BOUND,DEFAULT_LENGTH,DEFAULT_LENGTH,this);
    }
    
    private void paintDoor(Graphics g){
        if(!y.isEmpty()){
            for (int[] temp1: y){
                ImageIcon icon = new ImageIcon("source/materials/map/yellow.png");
                g.drawImage(icon.getImage(),temp1[0]*DEFAULT_LENGTH+startX+DEFAULT_BOUND,
                            temp1[1]*DEFAULT_LENGTH+startY+DEFAULT_BOUND,DEFAULT_LENGTH,DEFAULT_LENGTH,this);
            }
        }
        if(!b.isEmpty()){
            for (int[] temp2: b){
                ImageIcon icon = new ImageIcon("source/materials/map/blue.png");
                g.drawImage(icon.getImage(),temp2[0]*DEFAULT_LENGTH+startX+DEFAULT_BOUND,
                            temp2[1]*DEFAULT_LENGTH+startY+DEFAULT_BOUND,DEFAULT_LENGTH,DEFAULT_LENGTH,this);
            }
        }
        if(!r.isEmpty()){
            for (int[] temp3: r){
                ImageIcon icon = new ImageIcon("source/materials/map/red.png");
                g.drawImage(icon.getImage(),temp3[0]*DEFAULT_LENGTH+startX+DEFAULT_BOUND,
                            temp3[1]*DEFAULT_LENGTH+startY+DEFAULT_BOUND,DEFAULT_LENGTH,DEFAULT_LENGTH,this);
            }
        }
        if(!gate.isEmpty()){
            for (int[] temp4: gate){
                ImageIcon icon = new ImageIcon("source/materials/map/gate.png");
                g.drawImage(icon.getImage(),temp4[0]*DEFAULT_LENGTH+startX+DEFAULT_BOUND,
                            temp4[1]*DEFAULT_LENGTH+startY+DEFAULT_BOUND,DEFAULT_LENGTH,DEFAULT_LENGTH,this);
            }
        }
        if(!f.isEmpty()){
            for (int[] temp5: f){
                ImageIcon icon = new ImageIcon("source/materials/map/fence.png");
                g.drawImage(icon.getImage(),temp5[0]*DEFAULT_LENGTH+startX+DEFAULT_BOUND,
                            temp5[1]*DEFAULT_LENGTH+startY+DEFAULT_BOUND,DEFAULT_LENGTH,DEFAULT_LENGTH,this);
            }
        }
        
        
        
    }
    
    private void paintNPC(Graphics g){
        
        if(!npcList.isEmpty()){
            
            for(npc temp: npcList){
                
                npcdis n = npcF.getNpc(temp.getName());
                n.setLocation((temp.getPos()[0]*DEFAULT_LENGTH+DEFAULT_BOUND),
                              (temp.getPos()[1]*DEFAULT_LENGTH+DEFAULT_BOUND));
                n.show(g,(counter % 2));
            }
        }
    }
    
    private void paintMinions(Graphics g){
        min = myGame.getMinions();
        for (int i = 0; i < DEFAULT_WIDTH * DEFAULT_HEIGHT; i++){
            minionsdis m = minF.getMin(String.valueOf(min[(i/DEFAULT_WIDTH)][i-(i/DEFAULT_WIDTH)*DEFAULT_HEIGHT]));
            m.setLocation((i/DEFAULT_WIDTH)*DEFAULT_LENGTH+DEFAULT_BOUND+startX,(i-(i/DEFAULT_WIDTH)*DEFAULT_HEIGHT)*DEFAULT_LENGTH+DEFAULT_BOUND+startY);
            m.show(g, (counter % 2));
        }
    }
    
    public void updateWarrior(int x, int y){
        warriorMotionCounter ++;
        if(x == 0 && y == 1){
            myGame.setWarriorY(pos[1]-1);
            warriorStatus = 2;
        }
        else if(x == 0 && y == -1){
            
            myGame.setWarriorY(pos[1]+1);
            warriorStatus = 1;
           
        }
        else if(x == 1 && y == 0){
            myGame.setWarriorX(pos[0]+1);
            warriorStatus = 3;
         
        }
        else if(x == -1 && y == 0){
            myGame.setWarriorX(pos[0]-1);
            warriorStatus = 4;
        }
        
        repaint();
    }
    
    
    public int[] returnSize(){
        return size;
    }
    
    public void update(){
        warrior = "source/materials/warrior/1.png";
        pos = myGame.getWarriorPos();
        y = myGame.getYellowDoor();
        b = myGame.getBlueDoor();
        r = myGame.getRedDoor();
        gate = myGame.getGate();
        f = myGame.getFence();
       
        npcList = myGame.getNPCList();
        repaint();
    }
    
    public void actionPerformed(ActionEvent e){
        if (counter == 11){
            counter = 0;
        }else {
            counter ++;
        }
        if (warriorMotionCounter >= 0 && warriorMotionCounter < 2){
            warriorMotionCounter ++;
        }else if (warriorMotionCounter >= 2){
            warriorMotionCounter = -1;
        }
        
    }
    
    public void resetWarriorIcon(){
        warriorMotionCounter = -1;
        warriorStatus = 1;
    }

    
    
    
}