package main.java.display;

import javax.swing.*;
import java.awt.*;

public class optButton extends JButton{

    public optButton(String s){
        super(s);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);
        //this.setBorderPainted(false);
        this.setBorder(BorderFactory.createRaisedBevelBorder());
    }
    
}