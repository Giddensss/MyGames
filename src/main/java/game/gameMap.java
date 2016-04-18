package main.java.game;

import main.java.util.*;
import java.util.*;
import java.io.File;
import java.io.IOException;

public class gameMap{
    private static final int DEFAULT_WIDTH = 11;
    private static final int DEFAULT_HEIGHT = 11;
    private char[][] myMap = new char[DEFAULT_HEIGHT][DEFAULT_WIDTH];
    private fileOperater myFile;
    
    public gameMap(){
        
    }
    
    public void loadMap(String s){
        File f = new File(s);
        String temp = "";
        try{
            temp = myFile.readTxtFile(f);
        }catch(IOException e){
            e.printStackTrace();
        }
        
        String finalStr = temp.replaceAll("\n","");
        for (int i = 0; i < DEFAULT_WIDTH; i++){
            for (int j = 0; j < DEFAULT_HEIGHT; j++ ){
                myMap[j][i] = finalStr.charAt(j+(DEFAULT_WIDTH+1)*i);
            }
        }
    }
    
    public char[][] getMap(){
        return myMap;
    }
    
    public boolean checkRoad(int x, int y){
        return String.valueOf(myMap[x][y]).equals("R")||String.valueOf(myMap[x][y]).equals("D")||String.valueOf(myMap[x][y]).equals("U")||String.valueOf(myMap[x][y]).equals("S")||String.valueOf(myMap[x][y]).equals("B");
    }
    
    public String toString(){
        String toReturn = "";
        for (int i = 0; i < DEFAULT_WIDTH; i++){
            for (int j = 0; j < DEFAULT_HEIGHT; j++){
                toReturn += myMap[j][i];
            }
            toReturn += "\n";
        }
        return toReturn;
    }
    
    public int[] getEntry(){
        int[] pos = {-1,-1};
        for (int i = 0; i < DEFAULT_WIDTH;i++){
            for (int j = 0; j<DEFAULT_HEIGHT; j++){
                if (String.valueOf(myMap[j][i]).equals("D")){
                    pos[0] = j;
                    pos[1] = i;
                }
            }
        }
        return pos;
    }
    
    public int[] getExit(){
        int[] pos = {-1,-1};
        for (int i = 0; i < DEFAULT_WIDTH;i++){
            for (int j = 0; j<DEFAULT_HEIGHT; j++){
                if (String.valueOf(myMap[j][i]).equals("U")){
                    pos[0] = j;
                    pos[1] = i;
                }
            }
        }
        return pos;
    }
    
    public int[] startPos(){
        int[] pos = {-1,-1};
        for (int i = 0; i < DEFAULT_WIDTH;i++){
            for (int j = 0; j<DEFAULT_HEIGHT; j++){
                if (String.valueOf(myMap[j][i]).equals("S")){
                    pos[0] = j;
                    pos[1] = i;
                }
            }
        }
        return pos;
    }
    
    public int[] backPos(){
        int[] pos = {-1,-1};
        for (int i = 0; i < DEFAULT_WIDTH;i++){
            for (int j = 0; j<DEFAULT_HEIGHT; j++){
                if (String.valueOf(myMap[j][i]).equals("B")){
                    pos[0] = j;
                    pos[1] = i;
                }
            }
        }
        return pos;
    }
    
    
}