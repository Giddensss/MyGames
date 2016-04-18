package main.java.display;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

import main.java.game.*;
import main.java.util.*;
import main.java.controllor.*;

public class minionCheckPanel extends JPanel{
    private static final int DEFAULT_WIDTH = 668;
    private static final int DEFAULT_HEIGHT = 668;
    private static final int DEFAULT_BOUND = 4;
    private static final int DEFAULT_GAP = 20;
    
    private clientUI cui;
    private game myGame;
    private minionsDataReader myReader = new minionsDataReader();
    
    public minionCheckPanel(game g, clientUI c){
        myGame = g;
        cui = c;
        
        
        setSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT));
        setPreferredSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT));
        setVisible(true);
        setLayout(null);
        
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.fillRect(0,0,DEFAULT_WIDTH,DEFAULT_HEIGHT);
        paintBound(g,DEFAULT_WIDTH,DEFAULT_HEIGHT,DEFAULT_BOUND,0,0);
        paintMin(g);
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
    
    private void paintMin(Graphics g){
        LinkedList<String> allMins = myGame.getAllMin();
        int gapPerColumn = 20;
        for (int i = 0; i < allMins.size();i++){
            String name = allMins.get(i);
            ImageIcon icon = new ImageIcon("source/materials/minions/"+name+".png");
            g.drawImage(icon.getImage(),gapPerColumn+DEFAULT_BOUND,DEFAULT_BOUND+DEFAULT_GAP+(DEFAULT_GAP+60)*i,60,60,this);
            paintBound(g,60+DEFAULT_BOUND*2,60+DEFAULT_BOUND*2,DEFAULT_BOUND,gapPerColumn+DEFAULT_BOUND-DEFAULT_BOUND,DEFAULT_BOUND+DEFAULT_GAP+(DEFAULT_GAP+60)*i-DEFAULT_BOUND);
            
            
            //health label
            JLabel health = new JLabel("<html><Font size='6', Color='white'>HP:"+myReader.getData(name)[0]+
                                       "</Font></html>");
            health.setVisible(true);
            health.setBounds(gapPerColumn*2+DEFAULT_BOUND+60,DEFAULT_BOUND+DEFAULT_GAP+(DEFAULT_GAP+60)*i-4,150,30);
            this.add(health);
            
            
            //attack label
            JLabel attack = new JLabel("<html><Font size='6', Color='white'>Att.: " + myReader.getData(name)[1]+"</Font></html>");
            attack.setVisible(true);
            attack.setBounds(gapPerColumn*2+DEFAULT_BOUND+60,DEFAULT_BOUND+DEFAULT_GAP+(DEFAULT_GAP+60)*i-4+35,150,30);
            this.add(attack);
            
            
            //defence label
            JLabel def = new JLabel("<html><Font size='6', Color='white'>Def.: " + myReader.getData(name)[2]+"</Font></html>");
            def.setVisible(true);
            def.setBounds(gapPerColumn*3+DEFAULT_BOUND+60 + 150,DEFAULT_BOUND+DEFAULT_GAP+(DEFAULT_GAP+60)*i-4,150,30);
            this.add(def);
            
            
            //gold label
            JLabel gold = new JLabel("<html><Font size='6', Color='white'>Gold: " + myReader.getData(name)[3]+"</Font></html>");
            gold.setVisible(true);
            gold.setBounds(gapPerColumn*3+DEFAULT_BOUND+60 + 150,DEFAULT_BOUND+DEFAULT_GAP+(DEFAULT_GAP+60)*i-4+35,150,30);
            this.add(gold);
            
            //exp label
            JLabel exp = new JLabel("<html><Font size='6', Color='white'>Exp.: " + myReader.getData(name)[4]+"</Font></html>");
            exp.setVisible(true);
            exp.setBounds(gapPerColumn*4+DEFAULT_BOUND+60 + 350,DEFAULT_BOUND+DEFAULT_GAP+(DEFAULT_GAP+60)*i-4,150,30);
            this.add(exp);
            
            //damage label
            JLabel damage = new JLabel();
            int warAtt = myGame.getWarriorAttack();
            int warDef = myGame.getWarriorDefense();
            int minDam = myReader.getData(name)[1] - warDef;
            int warDam = warAtt - myReader.getData(name)[2];
            int minHealth = myReader.getData(name)[0];
            
            //System.out.println(name + " " + warDam + " " + minDam);
            if (warDam <= 0 ){
                damage.setText("<html><Font size='5', Color='white'>Cost: ???? </Font></html>");
            }
            else if (minDam <= 0){
                damage.setText("<html><Font size='5', Color='white'>Cost: 0 </Font></html>");
            }
            else {
                int round = minHealth/warDam;
                int cost = minDam * round;
                damage.setText("<html><Font size='5', Color='white'>Cost: "+cost+" </Font></html>");
            }
            damage.setVisible(true);
            damage.setBounds(gapPerColumn*4+DEFAULT_BOUND+60 + 350,DEFAULT_BOUND+DEFAULT_GAP+(DEFAULT_GAP+60)*i-4+35,150,30);
            this.add(damage);
        }
        
       
        
    }
    public void enableListener(){
        Toolkit.getDefaultToolkit().addAWTEventListener(new checkBoardListener(cui),AWTEvent.KEY_EVENT_MASK);
    }
}