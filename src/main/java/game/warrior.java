package main.java.game;

import java.util.*;
import java.io.File;
import java.io.IOException;
import main.java.util.*;

public class warrior{
    // The info array contains Health|Attack|Defense|Level|Gold|Exp
    private int[] info = {1000,10,10,1,0,0};
    private int[] pos = {5,9};
    private fileOperater myFile;
    public warrior(){
        
    }
    
    public int[] getPos(){
        return pos;
    }
    
    public int[] getInfo(){
        return info;
    }
    
    public void setX(int x){
        pos[0] = x;
    }
    
    public void setY(int y){
        pos[1] = y;
    }
    
    public void setHealth(int h){
        info[0] += h;
    }
    
    public void setAttack(int a){
        info[1] += a;
    }
    
    public void setDefense(int d){
        info[2] += d;
    }
    
    public void setLevel(int l){
        info[3] += l;
    }
    
    public void setGold(int g){
        info[4] += g;
    }
    
    public void setExp(int e){
        info[5] += e;
    }
    
    public String toString(){
        String toReturn = "";
        for(int i:info){
            toReturn += i + ",";
        }
        for (int i:pos){
            toReturn += i + ",";
        }
        return toReturn.substring(0,toReturn.length());
    }
    
    public void setPos(int[] i){
        pos = i;
    }
    
    public void save(){
        File f = new File("source/map/warrior.txt");
        try{
            myFile.createFile(f);
            myFile.writeTxtFile(toString(),f);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void load(){
        File f = new File("source/map/warrior.txt");
        String temp = "";
        try{
            temp = myFile.readTxtFile(f);
        }catch(IOException e){
            e.printStackTrace();
        }
        char[] c = temp.toCharArray();
        int i = 0;
        String data = "";
        int counter = 0;
        while(i < c.length -1){
            if(Character.isDigit(c[i])){
                data += String.valueOf(c[i]);
            }
            else if (String.valueOf(c[i]).equals(",")){
                if(counter < 6){
                    info[counter] = Integer.valueOf(data);
                }
                else{
                    pos[counter-6] = Integer.valueOf(data);
                }
                counter ++;
                data = "";
            }
            i++;
        }
        
    }
}