package main.java.game;

import main.java.game.npc.*;
import java.util.*;
import main.java.util.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

public class game{
    private final static int DEFAULT_TOTAL_LEVEL = 22;
    private gameMap myMap = new gameMap();
    private warrior myWar = new warrior();
    private door myDoor;
    private key myKey;
    private items myItem;
    private minions myMin;
    private int level;
   // private boolean isNewGame;
    private boolean[] isChange = new boolean[DEFAULT_TOTAL_LEVEL];
    private String path = "";
    private LinkedList<int[]> yellow;
    private LinkedList<int[]> red;
    private LinkedList<int[]> blue;
    private LinkedList<int[]> gate;
    private LinkedList<int[]> fence;
    private LinkedList<String> specialItem;
    private fileOperater myFile;
    private npcHandler myNPC;
    public game(boolean newGame, int l){
        yellow = new LinkedList<int[]>();
        red = new LinkedList<int[]>();
        blue = new LinkedList<int[]>();
        gate = new LinkedList<int[]>();
        fence = new LinkedList<int[]>();
        specialItem = new LinkedList<String>();
       // isNewGame = newGame;
        level = l;
        for(int i =0; i < DEFAULT_TOTAL_LEVEL;i++){
            isChange[i] = false;
        }
    
        path = "source/map/level"+level;
        String mapPath = "source/map/level"+level+"/map.txt";
        
        loadMap(mapPath);
        myDoor = new door(path+"/door.txt");
        myKey = new key();
        myItem = new items(path+"/item.txt");
        myMin = new minions();
        myMin.load(path);
        myWar.setPos(myMap.startPos());
        yellow = myDoor.getYellowDoor();
        red = myDoor.getRedDoor();
        blue = myDoor.getBlueDoor();
        gate = myDoor.getGate();
        fence = myDoor.getFence();
        myNPC = new npcHandler(this);
        myNPC.load(path+"/npc.txt");
        
        
       
    }
    
    public void loadMap(String m){
        String mapName = m;
        myMap.loadMap(mapName);
    }
    
    public char[][] getMap(){
        return myMap.getMap();
    }
    
    public int[] getExit(){
        return myMap.getExit();
    }
    
    public int[] getEntry(){
        return myMap.getEntry();
    }
    
   /* public String printMap(){
        return myMap.toString();
    }*/
    
   /* public String printWarrior(){
        return myWar.toString();
    }*/
    
    public int getWarriorHealth(){
        return myWar.getInfo()[0];
    }
    
    public int getWarriorAttack(){
        return myWar.getInfo()[1];
    }
    
    public int getWarriorDefense(){
        return myWar.getInfo()[2];
    }
    
    public int getWarriorLevel(){
        return myWar.getInfo()[3];
    }
    
    public int getWarriorGold(){
        return myWar.getInfo()[4];
    }
    
    public int getWarriorExp(){
        return myWar.getInfo()[5];
    }
    
    public int[] getWarriorPos(){
        return myWar.getPos();
    }
    
    public void setWarriorX(int x){
        myWar.setX(x);
    }
    
    public void setWarriorY(int y){
        myWar.setY(y);
    }
    
    /**
     *@param h is the amount of health changed
     **/
    public void setWarriorHealth(int h){
        myWar.setHealth(h);
    }
    
    public void setWarriorAttack(int a){
        myWar.setAttack(a);
    }
    
    
    public void setWarriorDefense(int d){
        myWar.setDefense(d);
    }
    
    public void setWarriorLevel(int l){
        myWar.setLevel(l);
    }
    
    public void setWarriorGold(int g){
        myWar.setGold(g);
    }
    
    public void setWarriorExp(int e){
        myWar.setExp(e);
    }
    
    public boolean checkRoad(int x, int y){
        return myMap.checkRoad(x,y);
    }
    
    public LinkedList<int[]> getYellowDoor(){
        return yellow;
    }
    
    public LinkedList<int[]> getRedDoor(){
        return red;
    }
    
    public LinkedList<int[]> getBlueDoor(){
        return blue;
    }
    
    public LinkedList<int[]> getGate(){
        return gate;
    }
    
    public LinkedList<int[]> getFence(){
        return fence;
    }
    
    
    public String checkDoor(int x, int y){
        int[] pos = {x,y};
        if (contains(yellow,pos)){
            return "y";
        }
        else if (contains(red, pos)){
            return "r";
        }
        else if (contains(blue,pos)){
            return "b";
        }
        else if (contains(gate,pos)){
            return "g";
        }
        else if (contains(fence,pos)){
            return "f";
        }
        else{
            return "";
        }
    }
    
    public void open(String s, int x, int y){
        myDoor.open(s,x,y);
    }
    
    private boolean contains(LinkedList<int[]> l, int[] i){
        for (int[] temp:l){
            if (Arrays.equals(temp,i)){
                return true;
            }
        }
        return false;
    }
    
    public int getYellowKey(){
        return myKey.getYellow();
    }
    
    public int getBlueKey(){
        return myKey.getBlue();
    }
    
    public int getRedKey(){
        return myKey.getRed();
    }
    
    public void setYellowKey(int x){
        myKey.setYellow(x);
    }
    
    public void setBlueKey(int x){
        myKey.setBlue(x);
    }
    
    public void setRedKey(int x){
        myKey.setRed(x);
    }
    
    public char[][] getItem(){
        return myItem.getItem();
    }
    
    public void removeItem(int x, int y){
        myItem.removeItem(x,y);
    }
    
    public char getItem(int x, int y){
        return myItem.getItem(x,y);
    }
    
    /*public String itemToString(){
        return myItem.toString();
    }*/
    
    public char[][] getMinions(){
        return myMin.getMinions();
    }
    
    public LinkedList<String> getAllMin(){
        return myMin.getAllMin();
    }
    
    public String getMinion(int x, int y){
        return myMin.getMinion(x,y);
    }
    
    public void removeMin(int x, int y){
        myMin.removeMinion(x,y);
    }
    
    public void changeMap(){
        String p = "source/map/level"+level+"/temp";
        isChange[level] = true;
        myDoor.save(p);
        myItem.save(p);
        myNPC.save(p);
        myMin.save(p);
    }
    
    public void reload(String p){
        String mapPath = "";
        if (level == 18 && specialItem.contains("P") && !specialItem.contains("R")){
            mapPath = "source/map/level18/mapAlt.txt";
        }
        else if (level == 18 && specialItem.contains("R")){
            mapPath = "source/map/level18/mapAlt2.txt";
        }else{
            mapPath = "source/map/level"+level+"/map.txt";
        }
        loadMap(mapPath);
        myDoor = new door(p+"/door.txt");
        myItem.loadItem(p+"/item.txt");
        myNPC.load(p+"/npc.txt");
        myMin.load(p);
        yellow = myDoor.getYellowDoor();
        red = myDoor.getRedDoor();
        blue = myDoor.getBlueDoor();
        if(this.level == 2 && this.specialItem.contains("T")){
            myDoor.open("g",1,6);
        }
        gate = myDoor.getGate();
        fence = myDoor.getFence();
    }

    
    public void levelUp(){
        
        changeMap();
        level = level+1;
        if(isChange[level]){
            path = "source/map/level"+level+"/temp";
        }
        else{
            path = "source/map/level"+level;
        }
        reload(path);
        myWar.setPos(myMap.startPos());
        
       
    }
    
    public void levelDown(){
        changeMap();
        level = level-1;
        
        if(isChange[level]){
            path = "source/map/level"+level+"/temp";
        }
        else{
            path = "source/map/level"+level;
        }
        reload(path);
        myWar.setPos(myMap.backPos());
        
        
        
    }
    
    
    public int getLevel(){
        return level;
    }
    
    public LinkedList<npc> getNPCList(){
        return myNPC.getNPCs();
    }
    
    public boolean isNPC(int x, int y){
        return myNPC.isNPC(x,y);
    }
    
    public npc getNpc(int x, int y){
        return myNPC.getOneNPC(x,y);
    }
    
    public void removeNPC(npc n){
        myNPC.removeNPC(n);
    }
    
    public void addSpecialItem(String s){
        specialItem.add(s);
    }
    
    public boolean hasItem(String s){
        return specialItem.contains(s);
    }
    
    private void saveLevelChanged(){
        String toString = "";
        for(boolean b: isChange){
            if(b){
                toString += "t";
            }
            else{
                toString += "f";
            }
        }
        File f = new File("source/map/isChange.txt");
        try{
            myFile.createFile(f);
            myFile.writeTxtFile(toString,f);
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
    private void loadIschange(){
        String s = "";
        File f = new File("source/map/isChange.txt");
        try{
            s = myFile.readTxtFile(f);
        }catch(IOException e){
            e.printStackTrace();
        }
        char[] temp = s.toCharArray();
        for(int i = 0; i < DEFAULT_TOTAL_LEVEL; i++){
            if(String.valueOf(temp[i]).equals("f")){
                isChange[i] = false;
            }
            else if (String.valueOf(temp[i]).equals("t")){
                isChange[i] = true;
            }
        }
    }
    
    private void saveSpeceialItem(){
        String toSave = "";
        File f = new File("source/map/specialItem.txt");
        for(String temp : specialItem){
            toSave += temp;
        }
        try{
            myFile.createFile(f);
            myFile.writeTxtFile(toSave,f);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    private void loadSpecialItem(){
        File f = new File("source/map/specialItem.txt");
        String s = "";
        try{
            s = myFile.readTxtFile(f);
        }catch(IOException e){
            e.printStackTrace();
        }
        char[] temp = s.toCharArray();
        for(char c: temp){
            specialItem.add(String.valueOf(c));
        }
    }
    
    public void restart(){
        yellow = new LinkedList<int[]>();
        red = new LinkedList<int[]>();
        blue = new LinkedList<int[]>();
        fence = new LinkedList<int[]> ();
        gate = new LinkedList<int[]> ();
       // isNewGame = true;
        level = 0;
        for(int i =0; i < 22;i++){
            isChange[i] = false;
        }
        
        path = "source/map/level"+level;
        
        String mapPath = "source/map/level"+level+"/map.txt";
        loadMap(mapPath);
        myItem.loadItem(path+"/item.txt");
        myDoor = new door(path+"/door.txt");
        myMin.load(path);
        myKey = new key();
        myWar = new warrior();
        yellow = myDoor.getYellowDoor();
        red = myDoor.getRedDoor();
        blue = myDoor.getBlueDoor();
        fence = myDoor.getFence();
        gate = myDoor.getGate();
        specialItem = new LinkedList<String>();
        myNPC.load(path+"/npc.txt");
    }
    
    public void save(){
        try{
            myFile.createFile(new File("source/map/level.txt"));
            myFile.writeTxtFile(String.valueOf(level),new File("source/map/level.txt"));
        }catch(IOException e){
            e.printStackTrace();
        }
        changeMap();
        myKey.save();
        myWar.save();
        saveLevelChanged();
        saveSpeceialItem();
       
    }
    
    public void load(){
        File f = new File("source/map/level.txt");
        String data = "";
        String temp = "";
        try{
            data = myFile.readTxtFile(f);
        }catch(IOException e){
            
        }
        if(!data.equals("")){
                
            for(char c:data.toCharArray()){
                if(Character.isDigit(c)){
                    temp+= String.valueOf(c);
                }
            }
            level = Integer.valueOf(temp);
            path = "source/map/level"+level+"/temp";
            
            isChange = new boolean[DEFAULT_TOTAL_LEVEL];
            loadIschange();
            specialItem = new LinkedList<String>();
            loadSpecialItem();
            reload(path);
            myWar.load();
            myKey.load();
            
            
        }else{
            JPanel tempP = new JPanel();
            tempP.setVisible(true);
            JOptionPane.showMessageDialog(tempP,"Nothing has been saved!");
        }
        
    }
    
  /*  public boolean getIsNew(){
        return isNewGame;
    }*/
    
    /*public String getSavePath(){
        return "source/mapl/"+level+"/temp";
    }*/
    
   

    public void chooseFloor(int l){
       
        if(isChange[l]){
            changeMap();
            this.level = l;
            String newPath = "source/map/level"+l+"/temp";
            
            reload(newPath);
            myWar.setPos(myMap.startPos());
            
        }else{
            myWar.setPos(myMap.startPos());
        }
    }
}