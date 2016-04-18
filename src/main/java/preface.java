package main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;


import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class preface extends JFrame{
    private AudioClip bgm;
    public preface(){
        
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        gd.setFullScreenWindow(this);
        this.setVisible(true);
        this.setLayout(null);
        this.addKeyListener(new skipListener(this));
        setBGM();
        
    }
    
    public void paint(Graphics g){
        super.paint(g);
        g.fillRect(0,0,this.getWidth(),this.getHeight());
        repaint();
    }
    
    
    private void setBGM(){
        try{
            File f = new File("source/BGM/1.wav");
            URL cb;
            cb = f.toURL();
            bgm = Applet.newAudioClip(cb);
            bgm.play();
            
        }catch(MalformedURLException e){
            e.printStackTrace();
        }
    }
    
    public void BGMStop(){
        bgm.stop();
    }
   
    
}
