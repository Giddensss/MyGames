package main.java.controllor;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.swing.JButton;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import main.java.game.*;

public class minesButton extends JButton{
    private static final int DEFAULT_WIDTH_PER_SIDE = 30;
    private static final int DEFAULT_GAP = 2;
    private int clickNum = 0;
    private boolean marked = false;
    private boolean click = false;
    private game myGame;
    
    public minesButton(String text,game g){
        super(text);
        myGame = g;
        setFocusPainted(false);
        setContentAreaFilled(false);
        
        setBackground(Color.gray);
        
        
        addMouseListener(new MouseListener(){
            public void mouseClicked(MouseEvent e){
                if (e.getButton() == MouseEvent.BUTTON3 && !myGame.isLose() && !myGame.isWin()){
                    click = true;
                    clickNum ++;
                   
                }
                else{
                    if(!marked){
                       // setVisible(false);
                        click = true;
                    }
                }
                repaint();
            }
            
            public void mouseEntered(MouseEvent e){
                
            }
            
            public void mouseExited(MouseEvent e){
                
            }
            
            public void mousePressed(MouseEvent e){
                
            }
            
            public void mouseReleased(MouseEvent e){
                
            }
        });
    }
    
    
    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g.create();
        super.paintComponent(g);
        
        if (clickNum % 3 == 1){
            paintMarker(g2d);
            marked = true;
            
        }
        else if(clickNum % 3 == 2){
            paintQuestion(g2d);
            marked = false;
        }
        paintBorder(g2d);
        g2d.dispose();
    }
    
    protected void paintBorder(Graphics2D g){
        int[] x1 = {0,DEFAULT_WIDTH_PER_SIDE,DEFAULT_WIDTH_PER_SIDE-DEFAULT_GAP,DEFAULT_GAP,DEFAULT_GAP,0};
        int[] y1 = {0,0,DEFAULT_GAP,DEFAULT_GAP,DEFAULT_WIDTH_PER_SIDE-DEFAULT_GAP,DEFAULT_WIDTH_PER_SIDE};
        int[] x2 = {DEFAULT_WIDTH_PER_SIDE-DEFAULT_GAP,DEFAULT_WIDTH_PER_SIDE,DEFAULT_WIDTH_PER_SIDE,0,DEFAULT_GAP,DEFAULT_WIDTH_PER_SIDE-DEFAULT_GAP};
        int[] y2 = {DEFAULT_GAP,0,DEFAULT_WIDTH_PER_SIDE,DEFAULT_WIDTH_PER_SIDE,DEFAULT_WIDTH_PER_SIDE-DEFAULT_GAP,DEFAULT_WIDTH_PER_SIDE-DEFAULT_GAP};
        
        
        g.setBackground(new Color(190,190,190));
        g.setColor(new Color(240,240,240));
        g.drawPolygon(x1,y1,6);
        g.fillPolygon(x1,y1,6);
        
        g.setColor(new Color(150,150,150));
        g.drawPolygon(x2,y2,6);
        g.fillPolygon(x2,y2,6);
    }
    
    protected void paintMarker(Graphics2D g){
        int[] x = {18,8,18};
        int[] y = {8,15,15};
        g.setColor(Color.black);
        g.drawPolyline(x,y,3);
        g.drawLine(18,8,18,22);
        g.setColor(Color.red);
        g.fillPolygon(x,y,3);
    }
    
    protected void paintQuestion(Graphics2D g){
        g.setColor(Color.red);
        g.drawString("?",DEFAULT_WIDTH_PER_SIDE/2-3,DEFAULT_GAP+17);
    }
    public void reset(){
       clickNum = 0;
        marked = false;
    }
    
    public void setEnable(boolean b){
        if (!b){
            addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if (e.getSource() == this){
                        System.out.println("e");
                        setEnable(false);
                    }
                }
            });
        }
        
    }
    
    
    public boolean isClicked(){
        if(click){
            click = false;
            return true;
        }
        return false;
    }
    
}