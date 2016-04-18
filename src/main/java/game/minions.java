package main.java.game;

import main.java.util.*;
import java.util.LinkedList;
import java.io.File;
import java.io.IOException;

public class minions{
    private char[][] minions;
    private final static int DEFAULT_WIDTH = 11;
    private final static int DEFAULT_HEIGHT = 11;
    private fileOperater myFile;
   
    
    
    public minions(){
        minions = new char[DEFAULT_HEIGHT][DEFAULT_WIDTH];
    }
    
    public void load(String path){
        File f = new File(path + "/minions.txt");
        String s = "";
        try{
            s = myFile.readTxtFile(f);
        }catch(IOException e){
            e.printStackTrace();
        }
        String finalStr = s.replaceAll("\n","");
        
        for (int i = 0; i < DEFAULT_WIDTH; i++){
            for (int j = 0; j < DEFAULT_HEIGHT; j++ ){
                
                minions[j][i] = finalStr.charAt(j+(DEFAULT_WIDTH+1)*i);
            }
        }
        //System.out.println(getAllMin().toString());
        
    }
    
    public char[][] getMinions(){
        return minions;
    }
    
    public String getMinion(int x, int y){
        
        return String.valueOf(minions[x][y]);
    }
    
    public String toString(){
        String toReturn = "";
        for(int i = 0; i < DEFAULT_WIDTH; i++){
            for (int j = 0; j < DEFAULT_HEIGHT; j++){
                toReturn += String.valueOf(minions[j][i]);
                
            }
            toReturn += "\n";
        }
        return toReturn;
    }
    
    public void save(String path){
        
        File f = new File(path + "/minions.txt");
        try{
            myFile.createFile(f);
            myFile.writeTxtFile(toString(),f);
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
    public void removeMinion(int x, int y){
       
        minions[x][y] = '%';
        
    }
    
    public LinkedList<String> getAllMin(){
        LinkedList<String> allMinions = new LinkedList<String> ();
        for (int i = 0; i < DEFAULT_WIDTH; i++){
            for (int j = 0; j < DEFAULT_HEIGHT; j++ ){
                String temp = String.valueOf(minions[j][i]);
                if (!temp.equals("%")){
                    if (!allMinions.contains(temp)){
                        allMinions.add(temp);
                    }
                }
            }
        }
        return allMinions;
    }
}
