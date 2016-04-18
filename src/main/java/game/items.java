package main.java.game;

import main.java.util.*;
import java.util.*;
import java.io.File;
import java.io.IOException;

public class items{
    private static final int DEFAULT_WIDTH = 11;
    private static final int DEFAULT_HEIGHT = 11;
    private char[][] myItem = new char[DEFAULT_HEIGHT][DEFAULT_WIDTH];
    private fileOperater myFile;
    private String path;
    
    public items(String s){
        path = s;
        loadItem(path);
    }
    
    public void loadItem(String s){
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
                myItem[j][i] = finalStr.charAt(j+(DEFAULT_WIDTH+1)*i);
            }
        }
    }
    
    public char[][] getItem(){
        return myItem;
    }
    
    public char getItem(int x, int y){
        return myItem[x][y];
    }
    
    public String toString(){
        String toReturn = "";
        for (int i = 0; i < DEFAULT_WIDTH; i++){
            for (int j = 0; j < DEFAULT_HEIGHT; j++){
                toReturn += myItem[j][i];
            }
            toReturn += "\n";
        }
        return toReturn;
    }
    
    public void removeItem(int x,int y){
        myItem[x][y] = '%';
    }
    
    public void save(String s){
        File f = new File(s+"/item.txt");
        try{
            myFile.createFile(f);
            myFile.writeTxtFile(toString(),f);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    
    
}