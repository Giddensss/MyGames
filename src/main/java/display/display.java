package main.java.display;
import java.util.LinkedList;
import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;

import main.java.game.*;

public class display extends JComponent{
    private static final int DEFAULT_WIDTH_PER_SIDE = 30;
    private static final int DEFAULT_MARGINE = 10;
    private game myGame;
    private int[] size = new int[2];
    private int width = 0;
    private int height = 0;
    private int fillRow = 0;
    private int fillColmn = 0;
    private LinkedList<int[]> wrong = new LinkedList<int[]>();
    public display(game g){
        myGame = g;
        size = myGame.getSize();
        width = size[0]*DEFAULT_WIDTH_PER_SIDE;
        height = size[1]*DEFAULT_WIDTH_PER_SIDE;
        fillRow = size[1] + 1;
        fillColmn = size[0] + 1;
        setSize(new Dimension(width+DEFAULT_MARGINE,height+DEFAULT_MARGINE));
        setPreferredSize(new Dimension(width+DEFAULT_MARGINE,height+DEFAULT_MARGINE));
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //g.setBackground(new Color(100,100,100));
        drawLines(g);
        drawStrings(g);
        markWrong(g);
    }
    
    private void drawLines(Graphics g){
        g.setColor(new Color(210,210,210));
        g.fillRect(DEFAULT_MARGINE/2,DEFAULT_MARGINE/2,width,height);
        g.setColor(Color.black);
        for (int i = 0; i <= size[0]; i++){
            g.drawLine(DEFAULT_WIDTH_PER_SIDE*i+DEFAULT_MARGINE/2,DEFAULT_MARGINE/2,
                       DEFAULT_WIDTH_PER_SIDE*i+DEFAULT_MARGINE/2,size[1]*DEFAULT_WIDTH_PER_SIDE+DEFAULT_MARGINE/2);
        }
        for (int j = 0; j <= size[1]; j++){
            g.drawLine(DEFAULT_MARGINE/2,DEFAULT_WIDTH_PER_SIDE*j+DEFAULT_MARGINE/2,
                       size[0]*DEFAULT_WIDTH_PER_SIDE+DEFAULT_MARGINE/2,DEFAULT_WIDTH_PER_SIDE*j+DEFAULT_MARGINE/2);
        }
        if (fillRow <= size[1] && fillRow >= 0 && fillColmn <= size[0] && fillColmn >= 0 ){
            g.setColor(Color.red);
            g.fillRect(DEFAULT_WIDTH_PER_SIDE*fillColmn+DEFAULT_MARGINE/2,DEFAULT_WIDTH_PER_SIDE*fillRow+DEFAULT_MARGINE/2,DEFAULT_WIDTH_PER_SIDE,DEFAULT_WIDTH_PER_SIDE);
        }
        
    }
    
    private void drawStrings(Graphics g){
        Font f = g.getFont();
        
        g.setFont(new Font("Msyh",Font.BOLD,f.getSize()+2));
        
        Color[] stringC = {Color.BLACK,Color.BLUE,Color.GREEN.darker().darker(),Color.RED.darker().darker(),Color.BLUE.darker().darker(),Color.YELLOW.darker().darker(),Color.CYAN,Color.ORANGE,Color.PINK,Color.MAGENTA};
        for (int i = 0; i < size[0]; i++){
            for (int j = 0; j < size[1]; j++){
                String value = myGame.getValue(i,j);
                g.setColor(Color.black);
                if (value.equals("M")){
                    drawMine(g,j,i);
                }
                else if(!value.equals("0")){
                    int num = (int)(Integer.valueOf(value));
                    g.setColor(stringC[num]);
                    g.drawString(value,i*(DEFAULT_WIDTH_PER_SIDE)+DEFAULT_MARGINE/2+DEFAULT_WIDTH_PER_SIDE/2-5,j*(DEFAULT_WIDTH_PER_SIDE)+DEFAULT_WIDTH_PER_SIDE/2+5+DEFAULT_MARGINE/2);
                }
            }
        }
        
    }
    
    private void drawMine(Graphics g, int row, int colmn){
        int startX = colmn*DEFAULT_WIDTH_PER_SIDE+DEFAULT_MARGINE/2;
        int startY = row*DEFAULT_WIDTH_PER_SIDE+DEFAULT_MARGINE/2;
        
        int cirX = startX + 6;
        int cirY = startY + 6;
        int d = 18;
        
        int[] line1 = {startX + DEFAULT_WIDTH_PER_SIDE/2,startY + 4, startY + DEFAULT_WIDTH_PER_SIDE - 4 };
        int[] line2 = {startX + 4, startY+DEFAULT_WIDTH_PER_SIDE/2,startX + DEFAULT_WIDTH_PER_SIDE - 4};
        int[] line3 = {startX +7, startY+7, startX + DEFAULT_WIDTH_PER_SIDE - 7,startY +DEFAULT_WIDTH_PER_SIDE - 7};
        int[] line4 = {startX + DEFAULT_WIDTH_PER_SIDE - 7, startY+7,startX+7,startY +DEFAULT_WIDTH_PER_SIDE - 7};
        g.setColor(Color.black);
        g.drawOval(cirX,cirY,d,d);
        g.drawLine(line1[0],line1[1],line1[0],line1[2]);
        g.drawLine(line2[0],line2[1],line2[2],line2[1]);
        g.drawLine(line3[0],line3[1],line3[2],line3[3]);
        g.drawLine(line4[0],line4[1],line4[2],line4[3]);
        g.fillOval(cirX,cirY,d,d);
        
        int rectWidth = (int)(Math.sqrt(d/2)+1);
        int rectX = startX + DEFAULT_WIDTH_PER_SIDE/2 - rectWidth;
        int rectY = startY + DEFAULT_WIDTH_PER_SIDE/2 - rectWidth;
        g.setColor(Color.white);
        g.drawRect(rectX,rectY,rectWidth,rectWidth);
        g.fillRect(rectX,rectY,rectWidth,rectWidth);
        
    }
    
    private void markWrong(Graphics g){
        if (!wrong.isEmpty()){
            for (int[] temp : wrong){
                int startX = temp[0]*DEFAULT_WIDTH_PER_SIDE+DEFAULT_MARGINE/2;
                int startY = temp[1]*DEFAULT_WIDTH_PER_SIDE+DEFAULT_MARGINE/2;
                g.setColor(Color.RED);
                g.drawLine(startX,startY,startX+DEFAULT_WIDTH_PER_SIDE,startY+DEFAULT_WIDTH_PER_SIDE);
                g.drawLine(startX+DEFAULT_WIDTH_PER_SIDE,startY,startX,startY+DEFAULT_WIDTH_PER_SIDE);
            }
            
        }
    }
    
    public int getWidth(){
        return width+DEFAULT_MARGINE;
    }
    
    public int getHeight(){
        return height+DEFAULT_MARGINE;
    }
    
    public void setMarkArea(int row, int colmn){
        fillRow = row;
        fillColmn = colmn;
    }
    
    public void markWrong(LinkedList<int[]> locs){
        wrong = locs;
    }
    
    public void reset(){
        fillRow = size[1] + 1;
        fillColmn = size[0] + 1;
        wrong = new LinkedList<int[]>();
    }
}