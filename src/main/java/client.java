package main.java;
import main.java.game.*;
import main.java.display.*;
import main.java.controllor.*;

import java.awt.Component;
import java.awt.Point;
import javax.swing.JFrame;



public class client
{
    public static void main(String[] args)
    {
        game myGame = new game();
       
        display myDis = new display(myGame);
        
        mainControllor myCon = new mainControllor(myGame,myDis);
        
        
        clientUI ui = new clientUI(myGame,myDis,myCon);
        
       
    }
}