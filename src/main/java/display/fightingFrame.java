package main.java.display;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import main.java.controllor.*;
import main.java.game.*;

public class fightingFrame extends JPanel implements ActionListener{

    private static final int DEFAULT_WIDTH = 668;
    private static final int DEFAULT_HEIGHT = 338;
    private static final int DEFAULT_BOUND = 4;
    private game myGame;
    private clientUI cui;
    private String min;
    private int[] info;
    private JLabel minHealth = new JLabel();
    private JLabel mHealth = new JLabel();
    private JLabel minAttack = new JLabel();
    private JLabel mAttack = new JLabel();
    private JLabel minDefence = new JLabel();
    private JLabel mDefence = new JLabel();
    private JLabel warHealth = new JLabel();
    private JLabel wHealth = new JLabel();
    private JLabel warAttack = new JLabel();
    private JLabel wAttack = new JLabel();
    private JLabel warDefence = new JLabel();
    private JLabel wDefence = new JLabel();
    private int round = 0;
    
    private Timer t;
    
    public fightingFrame(game g, clientUI c, String m, int[] i){
        myGame = g;
        cui = c;
        min = m;
        //info is an integer array which contains the minH, minA, minD, warA, warD, warDam, minDam, warRound, X, Y, gold, exp
        info = i;
       
        t = new Timer(300,this);
        t.start();
        
        round = info[7];
        
        
        setSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT));
        setPreferredSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT));
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.fillRect(DEFAULT_BOUND,DEFAULT_BOUND,DEFAULT_WIDTH-DEFAULT_BOUND,DEFAULT_HEIGHT-DEFAULT_BOUND);
        paintBound(g);
        paintIcon(g);
        paintLabel(g);
    }
    
    public void paintBound(Graphics g){
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
        ImageIcon minIcon = new ImageIcon("source/materials/minions/"+min+".png");
        ImageIcon warIcon = new ImageIcon("source/materials/warrior/1.png");
        int gap = 15;
        g.drawImage(minIcon.getImage(),gap,50,70,70,this);
        g.drawImage(warIcon.getImage(),DEFAULT_WIDTH-gap-70,50,70,70,this);
    }
    
    private void paintLabel(Graphics g){
        Font a = new Font("a",Font.BOLD,6);
        
        minHealth.setText("<html><font color='white',size='6'>Health:</html></font>");
        minHealth.setBounds(95,40,100,50);
        minHealth.setVisible(true);
        minHealth.setFont(a);
        this.add(minHealth);
        
        mHealth.setText("<html><font color='white',size='6'>"+info[0]+"</html></font>");
        mHealth.setBounds(95,80,100,50);
        mHealth.setVisible(true);
        mHealth.setFont(a);
        this.add(mHealth);
        
        minAttack.setText("<html><font color='white',size='6'>Attack:</html></font>");
        minAttack.setBounds(95,120,100,50);
        minAttack.setVisible(true);
        minAttack.setFont(a);
        this.add(minAttack);
        
        mAttack.setText("<html><font color='white',size='6'>"+info[1]+"</html></font>");
        mAttack.setBounds(95,160,100,50);
        mAttack.setVisible(true);
        mAttack.setFont(a);
        this.add(mAttack);
        

        minDefence.setText("<html><font color='white',size='6'>Defence:</html></font>");
        minDefence.setBounds(95,200,150,50);
        minDefence.setVisible(true);
        minDefence.setFont(a);
        this.add(minDefence);
        
        mDefence.setText("<html><font color='white',size='6'>"+info[2]+"</html></font>");
        mDefence.setBounds(95,240,100,50);
        mDefence.setVisible(true);
        mDefence.setFont(a);
        this.add(mDefence);
        
        warHealth.setText("<html><font color='white',size='6'>Health:</html></font>");
        warHealth.setBounds(DEFAULT_WIDTH-DEFAULT_BOUND-180,40,100,50);
        warHealth.setVisible(true);
        warHealth.setFont(a);
        this.add(warHealth);
        
        wHealth.setText("<html><font color='white',size='6'>"+myGame.getWarriorHealth()+"</html></font>");
        wHealth.setBounds(DEFAULT_WIDTH-DEFAULT_BOUND-180,80,100,50);
        wHealth.setVisible(true);
        wHealth.setFont(a);
        this.add(wHealth);
        
        warAttack.setText("<html><font color='white',size='6'>Attack:</html></font>");
        warAttack.setBounds(DEFAULT_WIDTH-DEFAULT_BOUND-180,120,100,50);
        warAttack.setVisible(true);
        warAttack.setFont(a);
        this.add(warAttack);
        
        wAttack.setText("<html><font color='white',size='6'>"+info[3]+"</html></font>");
        wAttack.setBounds(DEFAULT_WIDTH-DEFAULT_BOUND-180,160,100,50);
        wAttack.setVisible(true);
        wAttack.setFont(a);
        this.add(wAttack);
        
        warDefence.setText("<html><font color='white',size='6'>Defence:</html></font>");
        warDefence.setBounds(DEFAULT_WIDTH-DEFAULT_BOUND-200,200,150,50);
        warDefence.setVisible(true);
        warDefence.setFont(a);
        this.add(warDefence);
        
        wDefence.setText("<html><font color='white',size='6'>"+info[4]+"</html></font>");
        wDefence.setBounds(DEFAULT_WIDTH-DEFAULT_BOUND-180,240,100,50);
        wDefence.setVisible(true);
        wDefence.setFont(a);
        this.add(wDefence);
        
        ImageIcon vs = new ImageIcon("source/materials/vs.png");
        g.drawImage(vs.getImage(),DEFAULT_WIDTH/2-100,50,200,208,this);

    }
    
  
    public void actionPerformed(ActionEvent e){
        
        if(round > 0){
            info[0] = info[0] - info[5];
            myGame.setWarriorHealth(-info[6]);
            cui.update();
            repaint();
            round -= 1;
        }else if (round == 0){
            info[0] = 0;
            cui.update();
            repaint();
            round -= 1;
            
        }else if (round == -1){
            this.setVisible(false);
            myGame.removeMin(info[8],info[9]);
            myGame.setWarriorGold(info[10]);
            myGame.setWarriorExp(info[11]);
            if(myGame.getLevel() == 19 && min.equals("*")){
                cui.showInfoPan("*");
            }
            else if (myGame.getLevel() == 21 && min.equals("~")){
                cui.showInfoPan("~");
            }
            else{
                cui.addFrameListener();
            }
            cui.setFightFrameVisibility(false);
            t.stop();

        }
        //close();
        
        
    }

    
    public int getWidth(){
        return DEFAULT_WIDTH;
    }
    
    public int getHeight(){
        return DEFAULT_HEIGHT;
    }
    
    
    
}