package main.java;

import javax.swing.*;
import java.awt.*;
import main.java.display.*;
import main.java.game.*;
import main.java.controllor.*;

public class client
{
    public static void main(String[] args)
    {
        game myGame = new game(true,0);
        clientUI ui = new clientUI(myGame);
        mainControllor myCon = new mainControllor(myGame,ui);
        //preface p = new preface();
        //p.setVisible(true);
        
    }
}