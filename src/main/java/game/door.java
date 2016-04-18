package main.java.game;

import java.util.*;
import java.io.File;
import java.io.IOException;
import main.java.util.*;


public class door{

    private HashMap<String,LinkedList<int[]>> door;
    private File data;
    private fileOperater myFile;
    
    public door(String s){
        door = new HashMap<String,LinkedList<int[]>>();
        data = new File(s);
        load(data);
    }
    
    private void load(File f){
        String temp = "";
        char[] info;
        try{
            temp = myFile.readTxtFile(f);
        }catch(IOException e){
            e.printStackTrace();
        }
        
        
        temp = temp.replaceAll("\n","");
        info = temp.toCharArray();
        
        
        String name ="";
        String cor = "";
        LinkedList<int[]> pos = new LinkedList<int[]>();
        int[] tempPos = new int[2];
        int i = 0;
        while(i < info.length-1){
            
            if(!Character.isDigit(info[i]) && String.valueOf(info[i+1]).equals(":")){
                name = String.valueOf(info[i]);
                
            }
            else if(Character.isDigit(info[i])){
                cor += String.valueOf(info[i]);
                
            }
            else if(String.valueOf(info[i]).equals(",")){
                tempPos[0] = Integer.valueOf(cor);
                cor = "";
                
                
            }
            else if(String.valueOf(info[i]).equals("|")){
                tempPos[1] = Integer.valueOf(cor);
                
                pos.add(tempPos);
                
                
                cor = "";
                tempPos = new int[2];
                
            }
            else if (String.valueOf(info[i]).equals("&")){
                door.put(name,pos);
                name = "";
                pos = new LinkedList<int[]>();
            }
            
            i++;
        }
        
        
    }
    
    public LinkedList<int[]> getYellowDoor(){
        return door.get("y");
    }
    
    public LinkedList<int[]> getRedDoor(){
        return door.get("r");
    }
    
    public LinkedList<int[]> getBlueDoor(){
        return door.get("b");
    }
    
    public LinkedList<int[]> getGate(){
        return door.get("g");
    }
    
    public LinkedList<int[]> getFence(){
        return door.get("f");
    }
    
    public void open(String s, int x, int y){
        int[] pos = {x,y};
        LinkedList<int[]> temp = door.get(s);
        Iterator<int[]> itr = temp.iterator();
        while(itr.hasNext()){
            int[] i = itr.next();
            if(Arrays.equals(i,pos)){
                itr.remove();
            }
        }
        
    }
    
    public String toString(){
        LinkedList<int[]> y = door.get("y");
        LinkedList<int[]> r = door.get("r");
        LinkedList<int[]> b = door.get("b");
        LinkedList<int[]> g = door.get("g");
        LinkedList<int[]> f = door.get("f");
        String toReturn = "";
        toReturn += "y:";
        for (int[] temp: y){
            toReturn += temp[0]+","+temp[1]+"|";
        }
        toReturn += "&\nb:";
        for (int[] temp: b){
            toReturn += temp[0]+","+temp[1]+"|";
        }
        toReturn += "&\nr:";
        for (int[] temp: r){
            toReturn += temp[0]+","+temp[1]+"|";
        }
        toReturn += "&\ng:";
        for (int[] temp: g){
            toReturn += temp[0]+","+temp[1]+"|";
        }
        toReturn += "&\nf:";
        for (int[] temp: f){
            toReturn += temp[0]+","+temp[1]+"|";
        }
        toReturn += "&";
        return toReturn;
    }
    
    public void save(String p){
        File f = new File(p+"/door.txt");
        try{
            myFile.createFile(f);
            myFile.writeTxtFile(toString(),f);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}