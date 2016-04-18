package main.java.controllor;

import main.java.display.*;
import main.java.game.*;

import java.util.*;
import java.awt.*;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import javax.swing.*;


public class mainControllor extends JComponent implements MouseListener{
    private static final int DEFAULT_WIDTH_PER_SIDE = 30;
    private static final int DEFAULT_MARGINE = 10;
    private game myGame;
    private display myDis;
    private int[] size = new int[2];
    private int width = 0;
    private int height = 0;
    private minesButton[][] buttons;
    private LinkedList<int[]> minesList;
    private LinkedList<int[]> q;
   // private gameControllor myGC;
    private boolean isSaved = false;
    
    public mainControllor(game g,display dis){
        myGame = g;
        myDis = dis;
        
        size = myGame.getSize();
        width = size[0];
        height = size[1];
        buttons = new minesButton[height][width];
        minesList = new LinkedList<int[]>();
        q = new LinkedList<int[]>();
        for (int i = 0; i < width; i++){
            for (int j = 0; j < height; j++){
                minesButton temp = new minesButton("",myGame);
                temp.setVisible(true);
                temp.setBounds(DEFAULT_WIDTH_PER_SIDE*i+DEFAULT_MARGINE/2,DEFAULT_WIDTH_PER_SIDE*j+DEFAULT_MARGINE/2,DEFAULT_WIDTH_PER_SIDE,DEFAULT_WIDTH_PER_SIDE);
                temp.addMouseListener(this);
                myDis.addMouseListener(this);
                buttons[j][i] = temp;
                myDis.add(temp);
            }
        }
        
    }
    
    public void mouseClicked(MouseEvent e) {
        int x;
        int y;
        int[] loc = new int[2];
        if(!e.getSource().equals(myDis)){
            int[] buttonLoc = new int[2];
            for (int i = 0; i < width; i++){
                for (int j = 0; j < height; j++){
                    if (buttons[j][i].isClicked()){
                        buttonLoc[0] = i;
                        buttonLoc[1] = j;
                    }
                    
                }
            }
            x = buttonLoc[0];
            y = buttonLoc[1];
            loc[0] = x;
            loc[1] = y;
        }
        else{
            Point screenLoc = myDis.getLocationOnScreen();
            int sx = (int)(screenLoc.getX());
            int sy = (int)(screenLoc.getY());
            x = getButtonCor(e.getXOnScreen()-sx);
            y = getButtonCor(e.getYOnScreen()-sy);
            
            loc[0] = x;
            loc[1] = y;
        }
        
        myGame.start();
        
        //System.out.println("m: " + minesList.size());
        if (!checkMarker(loc) && e.getSource().equals(buttons[y][x]) &&  e.getButton() != MouseEvent.BUTTON3){
            buttons[y][x].setVisible(false);
            if (myGame.getValue(x,y).equals("0")){
                shortcut(x,y);
            }
            else{
                check(x,y);
            }
        }
        
        else if(e.getSource().equals(myDis)){
            shortcut(x,y);
        }
        if (e.getButton() == MouseEvent.BUTTON3 && e.getSource().equals(buttons[y][x])) {
            
            
            
            if (!checkMarker(loc) && !contains(loc,q)){
                minesList.add(loc);
            }
            else if(checkMarker(loc)){
                for (int[] temploc:minesList){
                    if(Arrays.equals(temploc,loc)){
                        minesList.remove(temploc);
                    }
                }
                q.add(loc);
            }
            else if(!checkMarker(loc) && contains(loc,q)){
                for (int[] temploc:q){
                    if(Arrays.equals(temploc,loc)){
                        q.remove(temploc);
                    }
                }
            }
            
            myGame.mark(minesList.size());
            
        }
        
        isWin();
        
    }
    
    public void mouseEntered(MouseEvent e) {
    }
    
    public void mouseExited(MouseEvent e) {
    }
    
    public void mousePressed(MouseEvent e) {
        
    }
    
    public void mouseReleased(MouseEvent e) {
    }
    
    
    public void repaintButtons(){
        this.repaint();
        for (int i = 0; i < width; i++){
            for (int j = 0; j < height; j++){
                buttons[j][i].setVisible(true);
                buttons[j][i].enable(true);
                buttons[j][i].setLabel("");
                buttons[j][i].addMouseListener(this);
                buttons[j][i].reset();
            }
        }
        minesList = new LinkedList<int[]>();
        q = new LinkedList<int[]>();
        myDis.reset();
        myDis.repaint();
        isSaved = false;
        
    }
    
    private int getButtonCor(int x){
        int i = 0;
        while(DEFAULT_WIDTH_PER_SIDE*i+DEFAULT_MARGINE/2 < x){
            i++;
        }
        return i-1;
    }
    
    private boolean shortcut(int x, int y){
        for (int i = x-1; i <= x+1; i++){
            for (int j = y -1; j <= y+1; j++){
                if(i >=0 && j >= 0 && i <= width-1 && j <= height-1 && buttons[j][i].isVisible() ){
                    String temp = myGame.getValue(i,j);
                    String current = myGame.getValue(x,y);
                    int[] loc = {i,j};
                    if((current.equals("0") || countMines(x,y) == Integer.valueOf(current)) && !checkMarker(loc) && buttons[j][i].isVisible()){
                        buttons[j][i].setVisible(false);
                        if (!check(i,j)){
                            shortcut(i,j);
                        }
                        else{
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    
    private int countMines(int x, int y){
        int counter = 0;
        for (int i = x-1; i <= x+1; i++){
            for (int j = y -1; j <= y+1; j++){
                if(i >=0 && j >= 0 && i <= width-1 && j <= height-1 && buttons[j][i].isVisible() ){
                    int[] temp = {i,j};
                    if(checkMarker(temp)){
                        counter ++;
                    }
                }
            }
        }
        return counter;
    }
    
    private boolean check(int x, int y){
        if (myGame.isMine(x,y)){
            
            LinkedList<int[]> mines = myGame.getMines();
            showMines(mines);
            disableButtons();
            checkWrongMark();
            myDis.setMarkArea(y,x);
            myDis.repaint();
            myGame.stop();
            return true;
        }
        return false;
    }
    
    private void disableButtons(){
        for (int i = 0; i < width; i++){
            for (int j = 0; j < height; j++){
                buttons[j][i].removeMouseListener(this);
                
            }
        }
    }
    
    private void showMines(LinkedList<int[]> mines){
        for(int[] m: mines){
            if (!contains(m,minesList)){
                buttons[m[1]][m[0]].setVisible(false);
            }
        }
    }
    
    private void showAll(){
        for (int i = 0; i < width; i++){
            for (int j = 0; j < height; j++){
                int[] temp = {i,j};
                if(!checkMarker(temp)){
                    buttons[j][i].setVisible(false);
                }
            }
        }
    }
    
    private void isWin(){
        
        if (myGame.isWin(minesList)){
            disableButtons();
            showAll();
            myGame.stop();
            if(!isSaved){
                int type = myGame.getType();
                String record = myGame.loadRecord(type);
                if (!record.equals("")){
                    int index = record.indexOf("\n");
                    int oldRecord = (int)(Integer.valueOf(record.substring(index+1,record.length()-2))); // there're three space at the end of the string
                   
                    if (oldRecord > myGame.getTime()){
                        saveRecord popWin = new saveRecord(myGame);
                    }
                }
                else{
                   saveRecord popWin = new saveRecord(myGame);
                }
                
                isSaved = true;
            }
            
        }
    }
    
    private boolean checkMarker(int[] loc){
        for(int[] temp:minesList){
            if(Arrays.equals(loc,temp)){
                return true;
            }
        }
        return false;
    }
    
    private boolean contains(int[] a,LinkedList<int[]> l){
        boolean b = false;
        if (l.isEmpty()){
            return false;
        }
        for (int[] temp:l){
            if (Arrays.equals(a,temp)){
                b = true;
            }
        }
        return b;
    }
    
    private LinkedList<int[]> difference(LinkedList<int[]> a, LinkedList<int[]> b){
        LinkedList<int[]> toReturn = new LinkedList<int[]>();
        boolean checker = false;
        for (int[] tempB: b){
            for(int[] tempA :a){
                if(Arrays.equals(tempA,tempB)){
                    checker = true;
                }
            }
            if (!checker){
                toReturn.add(tempB);
            }
            checker = false;
        }
        return toReturn;
    }
    
    private void checkWrongMark(){
        LinkedList<int[]> temp = difference(myGame.getMines(),minesList);
        myDis.markWrong(temp);
        for(int[] loc:temp){
            buttons[loc[1]][loc[0]].setVisible(false);
        }
    }

}
