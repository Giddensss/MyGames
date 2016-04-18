package main.java.controllor;

import main.java.game.*;
import main.java.display.*;;

public class itemRule{
    private game myGame;
    private mainListener ml;
    private clientUI cui;
    public itemRule(game g,mainListener m, clientUI c){
        myGame = g;
        ml =m;
        cui = c;
        
    }
    
    public void apply(String i, int x, int y){
        myGame.removeItem(x,y);
        switch(i){
            case "y":
                myGame.setYellowKey(1);
                break;
            case "b":
                myGame.setBlueKey(1);
                break;
            case "r":
                myGame.setRedKey(1);
                break;
            case "B":
                myGame.setWarriorHealth(500);
                break;
            case "S":
                myGame.setWarriorHealth(200);
                break;
            case "D":
                myGame.setWarriorDefense(3);
                break;
            case "A":
                myGame.setWarriorAttack(3);
                break;
            case "c":
                myGame.setWarriorGold(300);
                break;
                
            case "L":
                myGame.addSpecialItem("L");
                cui.showInfoPan("L");
                ml.removeMainListener();
                break;
            
            case "w":
                myGame.setWarriorLevel(1);
                myGame.setWarriorHealth(1000);
                myGame.setWarriorAttack(7);
                myGame.setWarriorDefense(7);
                break;
            
            case "W":
                myGame.setWarriorLevel(3);
                myGame.setWarriorHealth(3000);
                myGame.setWarriorAttack(21);
                myGame.setWarriorDefense(21);
                break;
                
            case "J":
                myGame.addSpecialItem("J");
                cui.showInfoPan("J");
                ml.removeMainListener();
                break;
                
            case "C":
                myGame.addSpecialItem("C");
                cui.showInfoPan("C");
                ml.removeMainListener();
                break;
                
            case "P":
                myGame.addSpecialItem("P");
                cui.showInfoPan("P");
                ml.removeMainListener();
                break;
                
            case "1":
                myGame.setWarriorAttack(10);
                break;
            case "2":
                myGame.setWarriorAttack(70);
                break;
                
            case "3":
                myGame.setWarriorAttack(150);
                break;
                
            case "4":
                myGame.setWarriorDefense(10);
                break;
            
            case "5":
                myGame.setWarriorDefense(85);
                break;
                
            case "6":
                myGame.setWarriorDefense(190);
                break;
                
            case "k":
                myGame.setYellowKey(1);
                myGame.setBlueKey(1);
                myGame.setRedKey(1);
                break;
                
            case "h":
                myGame.setWarriorHealth(myGame.getWarriorHealth());
                break;
                
            default:
        }
    }
}