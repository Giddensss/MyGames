package main.java.game;

import java.util.*;
import java.io.IOException;
import java.io.File;
import main.java.util.*;

public class game{
    private board myBoard;
    private int width;
    private int height;
    private int mines;
    private int marked;
    private boolean win = false;
    private boolean lose = false;
    private timer t;
    private String type = "";
    private fileOperater myOperater;
    
    public game(){
        width = 9;
        height = 9;
        mines = 10;
        marked = 0;
        myBoard = new board(width,height,mines);
        t = new timer();
        type = "beginner";
        
    }
    
    public int[] getSize(){
        return myBoard.getSize();
    }
    
    public String getValue(int x,int y){
        return myBoard.getValue(x,y);
    }
    
    public boolean isMine(int x, int y){
        if(myBoard.isMine(x,y)){
            lose = true;
        }
        return myBoard.isMine(x,y);
    }
    
    public LinkedList<int[]> getMines(){
        return myBoard.getMines();
    }
    
    public boolean isWin(LinkedList<int[]> minesList){
        LinkedList<int[]> mn = this.getMines();
        int counter = 0;
        if (minesList.size() == mines){
            for (int[] m: minesList){
                
                for (int[] n: mn){
                    
                    if (Arrays.equals(m,n)){
                        
                        counter++;
                       
                    }

                }
            }
            if (counter == mines){
                win = true;
                return true;
            }
        }
        return false;
    }
    
    public boolean isWin(int x){
        if (x == width*height-mines){
            return true;
        }
        return false;
    }
    

    
    public int minesLeft(LinkedList<int[]> minesList){
        return mines-minesList.size();
    }
    
    public void setWidth(int w)
    {
        width = w;
    }
    
    public void setHeight(int h){
        height = h;
    }
    
    public void setMines(int m){
        mines = m;
    }
    
    public void setEasy(){
        width = 9;
        height = 9;
        mines = 10;
        myBoard = new board(width,height,mines);
        type = "beginner";
    }
    
    public void setMedium(){
        width = 16;
        height = 15;
        mines = 40;
        myBoard = new board(width,height,mines);
        type = "intermedium";
    }
    
    public void setHard(){
        width =32;
        height = 16;
        mines = 99;
        myBoard = new board(width,height,mines);
        type = "expert";
    }
    
    public void custom(int w,int h,int m){
        width = w;
        height = h;
        mines = m;
        myBoard = new board(w,h,m);
        type = "custom";
    }
    
    public void reset(){
        win = false;
        lose = false;
        myBoard = new board(width,height,mines);
        t.reset();
        marked = 0;
        
    }
    
    public String toString(){
        return myBoard.toString();
    }
    
    
    public boolean isWin(){
        return win;
    }
    
    public boolean isLose(){
        return lose;
    }
    
    public void start(){
        t.start();
    }
    
    public void stop(){
        t.stop();
    }
    
    public int getTime(){
        return t.getTime();
    }
    
    public void mark(int m){
        marked = m;
    }
    
    public int minesLeft(){
        return mines - marked;
    }
    
    public void saveRecord(String name){
        String toWrite = name + this.getTime();
        try{
            myOperater.createFile(new File("source/"+this.type+".txt"));
            myOperater.writeTxtFile(toWrite,new File("source/"+this.type+".txt"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public String[] loadRecord(){
        String[] toReturn = {"","","",""};
        try{
            toReturn[0] = myOperater.readTxtFile(new File("source/beginner.txt"));
            toReturn[1] = myOperater.readTxtFile(new File("source/intermedium.txt"));
            toReturn[2] = myOperater.readTxtFile(new File("source/expert.txt"));
            toReturn[3] = myOperater.readTxtFile(new File("source/custom.txt"));
        }catch(IOException e){
            e.printStackTrace();
        }
        return toReturn;
    }
    
    public String loadRecord(int index){
        String toReturn = "";
        if (index == 0){
            try{
                toReturn = myOperater.readTxtFile(new File("source/beginner.txt"));
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        else if (index == 1){
            try{
                toReturn = myOperater.readTxtFile(new File("source/intermedium.txt"));
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        else if (index == 2){
            try{
                toReturn = myOperater.readTxtFile(new File("source/expert.txt"));
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        else if (index == 3){
            try{
                toReturn = myOperater.readTxtFile(new File("source/custom.txt"));
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        return toReturn;
    }
    
    public int getType(){
        if (type.equals("beginner")){
            return 0;
        }
        else if(type.equals("intermedium")){
            return 1;
        }
        else if(type.equals("expert")){
            return 2;
        }
        else if(type.equals("custom")){
            return 3;
        }
        else{
            return 100;
        }
    }
    
    public void deleteRecord(){
        try{
            myOperater.writeTxtFile("",new File("source/beginner.txt"));
            myOperater.writeTxtFile("",new File("source/intermedium.txt"));
            myOperater.writeTxtFile("",new File("source/expert.txt"));
            myOperater.writeTxtFile("",new File("source/custom.txt"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    
}
