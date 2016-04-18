package main.java.game;
import main.java.game.npc.*;

import main.java.util.*;
import java.util.*;
import java.io.File;
import java.io.IOException;


public class npcHandler{
    private fileOperater myFile;
    private game myGame;
    private LinkedList<npc> npcList;
    private abstractFac npcFac;

    
    public npcHandler(game g){
        myGame = g;
        npcFac = new npcfactoryProducer().getFactory("npc",myGame);
    }
    
    public void load(String path){
        npcList = new LinkedList<npc>();
        
        File f = new File(path);
        String temp = "";
        try{
            temp = myFile.readTxtFile(f);
        }catch(IOException e){
            e.printStackTrace();
        }
       
        
        
        String finalStr = temp.replaceAll("\n","");
        char[] tempC = finalStr.toCharArray();
        int counter = 0;
        String name = "";
        String status = "";
        while(counter < tempC.length - 1){
    
            if(!Character.isDigit(tempC[counter])
               && !String.valueOf(tempC[counter]).equals("&")
               && String.valueOf(tempC[counter+1]).equals(":")){
                name = String.valueOf(tempC[counter]);
            }
            else if(Character.isDigit(tempC[counter])){
                status += String.valueOf(tempC[counter]);
            }
            else if(String.valueOf(tempC[counter]).equals("&")){
                npc newNpc = npcFac.getNPC(name,Integer.valueOf(status));
                //newNpc.setStatus(Integer.valueOf(status));
                npcList.add(newNpc);
                name = "";
                status = "";
            }
            
            counter++;
            
        }
        
    }
    
    public LinkedList<npc> getNPCs(){
        return npcList;
    }
    
    public boolean isNPC(int x,int y){
        int[] pos = {x,y};
        for (npc temp: npcList){
            if(Arrays.equals(temp.getPos(),pos)){
                return true;
            }
        }
        return false;
    }
    
    public npc getOneNPC(int x, int y){
        int counter = 0;
        int[] pos = {x,y};
        while (counter < npcList.size()){
            if (Arrays.equals(npcList.get(counter).getPos(),pos)){
                return npcList.get(counter);
            }
            counter ++;
        }
        return null;
    }
    
    public String toString(){
        String toReturn = "";
        for (npc temp: npcList){
            toReturn += temp.getName() + ":" + temp.getStatus() + "&\n";
        }
        return toReturn;
    }
    
    public void save(String path){
        File f = new File(path + "/npc.txt");
        try{
            myFile.createFile(f);
            myFile.writeTxtFile(toString(),f);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void removeNPC(npc n){
        npcList.remove(n);
    }

}