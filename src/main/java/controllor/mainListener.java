package main.java.controllor;

import main.java.game.*;
import main.java.util.*;
import main.java.display.*;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
public class mainListener implements AWTEventListener{
    private game myGame;
    private clientUI ui;
    private itemRule itmR;
    private minionsDataReader myReader;
    private static final int DEFAULT_WIDTH = 11;
    private static final int DEFAULT_HEIGHT = 11;
    
    private npcPerformance myNpc;
    
    public mainListener(game g,clientUI c){
        myGame = g;
        ui = c;
        itmR = new itemRule(myGame,this,ui);
        myReader = new minionsDataReader();
        myNpc = new npcPerformance(myGame,ui);
    }
    
    public void eventDispatched(AWTEvent event) {
        int[] pos = myGame.getWarriorPos();
        int[] entry = myGame.getEntry();
        int[] exit = myGame.getExit();
        int x = pos[0];
        int y = pos[1];
        if (event.getClass() == KeyEvent.class) {
            KeyEvent keyEvent = (KeyEvent) event;
            if (keyEvent.getID() == KeyEvent.KEY_PRESSED) {
               // System.out.println(keyEvent.getKeyCode());
                if(keyEvent.getKeyCode()==37){
                    //left arrow
                    if (x-1 >= 0 && myGame.checkRoad(x-1,y)){
                        checkItem(x-1,y);
                        if (!checkDoor(x-1,y)){
                            if(entry[0] == x-1 && entry[1] == y){
                                myGame.levelDown();
                                //ui.setBGM(myGame.getLevel());
                                ui.resetWarriorIcon();
                                ui.update();
                            }
                            else if (exit[0] == x-1 && exit[1] == y){
                                myGame.levelUp();
                                //ui.setBGM(myGame.getLevel());
                                ui.resetWarriorIcon();
                                ui.update();
                            }
                            else if (checkNPC(x-1,y)){
                                Toolkit.getDefaultToolkit().removeAWTEventListener(this);
                                myNpc.perform(x-1,y);
                                ui.update();
                                
                            }
                            else if (checkMinion(x-1,y)){
                                fight(x-1,y);
                            }
                            else{
                                ui.updateWarrior(-1,0);
                            }
                        }
                        
                    }
                    else if (x-1 >= 0){
                        checkShop(x-1,y);
                    }
                    
                }
                else if(keyEvent.getKeyCode()==38){
                    //up arrow
                    if(y-1 >= 0 && myGame.checkRoad(x,y-1)){
                        if(!checkDoor(x,y-1)){
                            checkItem(x,y-1);
                            
                            if(entry[0] == x && entry[1] == y-1){
                                myGame.levelDown();
                                //ui.setBGM(myGame.getLevel());
                                ui.resetWarriorIcon();
                                ui.update();
                            }
                            else if (exit[0] == x && exit[1] == y-1){
                                myGame.levelUp();
                                //ui.setBGM(myGame.getLevel());
                                ui.resetWarriorIcon();
                                ui.update();
                            }
                            else if (checkNPC(x,y-1)){
                                Toolkit.getDefaultToolkit().removeAWTEventListener(this);
                                myNpc.perform(x,y-1);
                                ui.update();
                            }
                            else if (checkMinion(x,y-1)){
                                fight(x,y-1);
                            }
                            else{
                                ui.updateWarrior(0,1);
                            }
                            
                        }
                        
                    }
                    else if (y-1 >= 0){
                        checkShop(x,y-1);
                    }
                    
                }
                else if(keyEvent.getKeyCode()==39){
                    //right arrow
                    if(x+1 < DEFAULT_WIDTH && myGame.checkRoad(x+1,y)){
                        if(!checkDoor(x+1,y)){
                            checkItem(x+1,y);
                            
                            if(entry[0] == x+1 && entry[1] == y){
                                myGame.levelDown();
                               // ui.setBGM(myGame.getLevel());
                                ui.resetWarriorIcon();
                                ui.update();
                            }
                            else if (exit[0] == x+1 && exit[1] == y){
                                myGame.levelUp();
                                ui.setBGM(myGame.getLevel());
                                ui.resetWarriorIcon();
                                ui.update();
                            }
                            else if (checkNPC(x+1,y)){
                                myNpc.perform(x+1,y);
                                Toolkit.getDefaultToolkit().removeAWTEventListener(this);
                                ui.update();
                            }
                            else if (checkMinion(x+1,y)){
                                fight(x+1,y);
                            }
                            else{
                                ui.updateWarrior(1,0);
                            }
                            
                        }
                        
                    }
                    else if (x+1 < DEFAULT_WIDTH){
                        checkShop(x+1,y);
                    }
                }
                else if(keyEvent.getKeyCode()==40){
                    //down arrow
                    if(y+1 < DEFAULT_HEIGHT && myGame.checkRoad(x,y+1)){
                        if(!checkDoor(x,y+1)){
                            checkItem(x,y+1);
                            
                            if(entry[0] == x && entry[1] == y+1){
                                myGame.levelDown();
                                ui.setBGM(myGame.getLevel());
                                ui.resetWarriorIcon();
                                ui.update();
                            }
                            else if (exit[0] == x && exit[1] == y+1){
                                myGame.levelUp();
                            //    ui.setBGM(myGame.getLevel());
                                ui.resetWarriorIcon();
                                ui.update();
                            }
                            else if (checkNPC(x,y+1)){
                                myNpc.perform(x,y+1);
                                Toolkit.getDefaultToolkit().removeAWTEventListener(this);
                                ui.update();
                            }
                            else if (checkMinion(x,y+1)){
                                fight(x,y+1);
                            }
                            else{
                                ui.updateWarrior(0,-1);
                            }
                        }
                        
                    }
                    else if (y+1 < DEFAULT_HEIGHT){
                        checkShop(x,y+1);
                    }
                    
                }
                else if (keyEvent.getKeyCode()==76){
                    if (myGame.hasItem("L")){
                        Toolkit.getDefaultToolkit().removeAWTEventListener(this);
                        ui.showCheckBoard();
                    }
                    
                }
                else if (keyEvent.getKeyCode() ==74){
                    if (myGame.hasItem("J")){
                        Toolkit.getDefaultToolkit().removeAWTEventListener(this);
                        ui.showChooseFloor();
                    }
                }
                
              
                
            } else if (keyEvent.getID() == KeyEvent.KEY_RELEASED) {
                KeyEvent keyEvent2 = (KeyEvent) event;
                
                

            }
        }
        
    }
    
    private boolean checkDoor(int x,int y){
        String door = myGame.checkDoor(x,y);
        if(door.equals("y")){
            if(myGame.getYellowKey() > 0){
                myGame.open("y",x,y);
                myGame.setYellowKey(-1);
                return true;
            }
            return true;
        }
        else if(door.equals("b")){
            if(myGame.getBlueKey() > 0){
                myGame.open("b",x,y);
                myGame.setBlueKey(-1);
                return true;
            }
            return true;
        }
        else if(door.equals("r")){
            if (myGame.getRedKey() > 0){
                myGame.open("r",x,y);
                myGame.setRedKey(-1);
                return true;
            }
            return true;
        }
        else if (door.equals("f")){
            if(myGame.getLevel() == 7){
                if(!myGame.getAllMin().contains("Y")){
                    myGame.open("f",x,y);
                    return true;
                }
                else{
                    return true;
                }
            }
            else if (myGame.getLevel() == 13){
                if( (x == 3 && myGame.getMinion(x,y-1).equals("%")) || (x == 4 && myGame.getMinion(x-1,y).equals("%"))){
                    myGame.open("f",x,y);
                    return true;
                }
                else{
                    return true;
                }
            }
            else if (myGame.getLevel() == 21){
                if (myGame.getAllMin().size() == 0){
                    myGame.open("f",x,y);
                    return true;
                }
                else {
                    return true;
                }
            }
            else {
                myGame.open("f",x,y);
                return true;
            }
        }
        else if (door.equals("g")){
            return true;
        }
        else {return false;}
    }
    
    private void checkItem(int x, int y){
        String it = String.valueOf(myGame.getItem(x,y));
        if(!it.equals("%")){
            itmR.apply(it,x,y);
        }
        
        ui.update();
    }
    
    private void checkShop(int x, int y){
        if (String.valueOf(myGame.getMap()[x][y]).equals("s")){
            ui.showShop();
            Toolkit.getDefaultToolkit().removeAWTEventListener(this);
        }
        
        
    }
    
    private boolean checkNPC(int x, int y){
        if (myGame.isNPC(x,y)){
            
            return true;
        }
        return false;
    }
    
    private boolean checkMinion(int x, int y){
        
        return (!myGame.getMinion(x,y).equals("%"));
    }
    
    private void fight(int x, int y){
        String min = myGame.getMinion(x,y);
        //System.out.println(min);
        int[] minData = myReader.getData(min);
        /*for(int i = 0; i < minData.length;i++){
            System.out.println(minData[i]);
        }*/
        int warDam = myGame.getWarriorAttack() - minData[2];
        int minDam = minData[1] - myGame.getWarriorDefense();
        if (minDam <= 0 && warDam > 0){
            int warRound = minData[0]/(warDam);
            int[] mininfo = {minData[0],minData[1],minData[2],myGame.getWarriorAttack(),myGame.getWarriorDefense(),warDam,0,warRound,x,y,minData[3],minData[4]};
            Toolkit.getDefaultToolkit().removeAWTEventListener(this);
            ui.showFight(mininfo,min);
        }else if(minDam > 0 && warDam != 0){
            int minRound = myGame.getWarriorHealth()/(minDam);
            int warRound = minData[0]/(warDam);
            int cost = myGame.getWarriorHealth() - minRound * minDam;
            if (minRound < 0 && warRound >= 0){
                int[] mininfo = {minData[0],minData[1],minData[2],myGame.getWarriorAttack(),myGame.getWarriorDefense(),warDam,0,warRound,x,y,minData[3],minData[4]};
                Toolkit.getDefaultToolkit().removeAWTEventListener(this);
                ui.showFight(mininfo,min);
                //System.out.println(minRound + "0");
            }
            else if (warRound < minRound && warRound >= 0){
                int[] mininfo = {minData[0],minData[1],minData[2],myGame.getWarriorAttack(),myGame.getWarriorDefense(),warDam,minDam,warRound,x,y,minData[3],minData[4]};
                
                Toolkit.getDefaultToolkit().removeAWTEventListener(this);
                ui.showFight(mininfo,min);
                //System.out.println(minRound + "1");
                
            }
            else if (warRound == minRound && warRound >= 0){
                if (cost < myGame.getWarriorHealth()){
                    int[] mininfo = {minData[0],minData[1],minData[2],myGame.getWarriorAttack(),myGame.getWarriorDefense(),warDam,minDam,warRound,x,y,minData[3],minData[4]};
                    
                    Toolkit.getDefaultToolkit().removeAWTEventListener(this);
                    ui.showFight(mininfo,min);
                }
            }
        }
        
        
        
    }
    
    public void removeMainListener(){
        Toolkit.getDefaultToolkit().removeAWTEventListener(this);
    }

}

