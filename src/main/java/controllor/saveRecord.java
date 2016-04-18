package main.java.controllor;

import main.java.game.*;

import java.util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class saveRecord extends JFrame{

    private static final int DEFAULT_WIDTH = 280;
    private static final int DEFAULT_HEIGHT = 200;
    private Point start = new Point((Toolkit.getDefaultToolkit().getScreenSize().width-DEFAULT_WIDTH)/2,
                                    (Toolkit.getDefaultToolkit().getScreenSize().height-DEFAULT_HEIGHT)/2);
    private game myGame;
    private JTextField text01;
    
    public saveRecord(game g){
        myGame = g;
        setSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT));
        setPreferredSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT));
        setVisible(true);
        setUp();
        pack();
        setLocation(start);
    }
    
    private void setUp(){
        Container content01 = this.getContentPane();
        JPanel panel = new JPanel();
        JPanel panel01 = new JPanel();
        JPanel panel02 = new JPanel();
        JPanel panel03 = new JPanel();
        JLabel label01 = new JLabel("<html><font size='6' color='red'>New Record!</font></html>",JLabel.CENTER);
        JLabel label02 = new JLabel("Player's Name:   ");
        text01 = new JTextField(10);
        JButton confirm = new JButton("Save");
        confirm.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent ae)
            {
                String name = text01.getText()+"\n";
                myGame.saveRecord(name);
                JOptionPane.showMessageDialog(content01,"Saved!");
                dispose();
            }
        });
        panel01.add(label01);
        panel02.add(label02);
        panel02.add(text01);
        panel03.add(confirm);
        panel.add(panel01);
        panel.add(panel02);
        panel.add(panel03);
        content01.add(panel,BorderLayout.CENTER);
        

    }
}