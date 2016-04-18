package main.java.display.infoPanel;

import java.awt.*;
import javax.swing.*;
import main.java.display.*;


public interface infoPanel{
    public void paintComponent(Graphics g);
    public int getWidth();
    public int getHeight();
    public void setClientUI(clientUI c);
}