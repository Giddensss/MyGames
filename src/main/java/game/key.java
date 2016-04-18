package main.java.game;

import main.java.util.*;
import java.io.File;
import java.io.IOException;

public class key{
    private int y = 0;
    private int r = 0;
    private int b = 0;
    private fileOperater myFile;
    public key(){
        
    }
    
    public void setYellow(int x){
        y = y+x;
        
    }
    
    public void setRed(int x){
        r = r+x;
        
    }
    
    public void setBlue(int x){
        b = b+x;
        
    }
    
    public int getYellow(){
        return y;
    }
    
    public int getBlue(){
        return b;
    }
    
    public int getRed(){
        return r;
    }
    
    /*
     * the output string will be a chain of number, which contains the number of 
     * yellow, blue, red keys, respectly.
     */
    public String toString(){
        String s = "";
        s += y+","+b+","+r+",";
        return s;
    }
    
    public void save(){
        try{
            myFile.createFile(new File("source/map/key.txt"));
            myFile.writeTxtFile(toString(),new File("source/map/key.txt"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void load(){
        File f = new File("source/map/key.txt");
        String data = "";
        try{
            data = myFile.readTxtFile(f);
        }catch(IOException e){
            e.printStackTrace();
        }
        
        char[] c = data.toCharArray();
        int[] keys = new int[3];
        String temp = "";
        int i = 0;
        int counter = 0;
        while(i<c.length-1){
            if(Character.isDigit(c[i])){
                temp += String.valueOf(c[i]);
            }
            else if(String.valueOf(c[i]).equals(",")){
                keys[counter] = Integer.valueOf(temp);
                temp = "";
                counter ++;
            }
            i++;
        }
        y = keys[0];
        b = keys[1];
        r = keys[2];
    }
}