package main.java.display.abstractFactory;

import java.awt.Graphics2D;

public interface numberDisplay{
    
    public void show(Graphics2D g);
    
    public void setLocation(int x, int Y);
    
}
