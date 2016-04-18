package main.java.controllor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.io.File;

import main.java.game.*;
import main.java.display.*;
import main.java.util.*;

public class menuControllor extends JComponent implements ActionListener{
    private clientUI myUI;
    private game myGame;
    private display myDis;
    private JMenuBar myBar;
    private int width =0;
    private static final int DEFAULT_HEIGHT = 10;
    private JMenu gameMenu,aboutMenue,leaderBoard;
    private JMenuItem beginner,intermedium,expert,custom,showR,deleteR,myRule,acknowledge;
    private JTextField text01,text02,text03;
    private fileOperater myOperater;
    
    public menuControllor(clientUI c, game g,display d){
        myUI = c;
        myGame = g;
        myDis = d;
        width = myDis.getWidth();
        
        
        myBar = new JMenuBar();
        Container content = myUI.getContentPane();
        
        beginner = new JMenuItem("Beginner");
        beginner.addActionListener(this);
        intermedium = new JMenuItem("Intermedium");
        intermedium.addActionListener(this);
        expert = new JMenuItem("Expert");
        expert.addActionListener(this);
        custom = new JMenuItem("Custom");
        custom.addActionListener(this);
        showR = new JMenuItem("Show Record");
        showR.addActionListener(this);
        deleteR = new JMenuItem("Delete Record");
        deleteR.addActionListener(this);
        myRule = new JMenuItem("Rules");
        myRule.addActionListener(this);
        acknowledge = new JMenuItem("Acknowlege");
        acknowledge.addActionListener(this);
        
        gameMenu = new JMenu("Game");
        gameMenu.add(beginner);
        gameMenu.add(intermedium);
        gameMenu.add(expert);
        gameMenu.add(custom);
        gameMenu.setVisible(true);
        
        leaderBoard = new JMenu("Record");
        leaderBoard.add(showR);
        leaderBoard.add(deleteR);
        
    
        aboutMenue = new JMenu("About");
        aboutMenue.add(myRule);
        aboutMenue.add(acknowledge);
        
        
        
        myBar.add(gameMenu);
        myBar.add(leaderBoard);
        myBar.add(aboutMenue);
        
        
        content.add(myBar,BorderLayout.NORTH);
        
    }
    
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(beginner)){
            myGame.setEasy();
            myUI.repaint();
            
        }
        else if (e.getSource().equals(intermedium)){
            myGame.setMedium();
            myUI.repaint();
        }
        else if (e.getSource().equals(expert)){
            myGame.setHard();
            myUI.repaint();
        }
        else if (e.getSource().equals(custom)){
            int tempW = 280;
            int tempH = 200;
            Point start = new Point((Toolkit.getDefaultToolkit().getScreenSize().width-tempW)/2,
            (Toolkit.getDefaultToolkit().getScreenSize().height-tempH)/2);
            //start.translate(myDis.getWidth()/2-tempW/2,50);
            JFrame popWin = new JFrame("Custom");
            popWin.setSize(new Dimension(tempW,tempH));
            popWin.setPreferredSize(new Dimension(tempW,tempH));
            popWin.setVisible(true);
            
            Container content01 = popWin.getContentPane();
            JPanel panel = new JPanel();
            JPanel panel01 = new JPanel();
            JPanel panel02 = new JPanel();
            JPanel panel03 = new JPanel();
            JPanel panel04 = new JPanel();
            JLabel label01 = new JLabel("Width:    ");
            JLabel label02 = new JLabel("Height:   ");
            JLabel label03 = new JLabel("Mines:    ");
            text01 = new JTextField(10);
            text01.addKeyListener(new KeyAdapter(){
                public void keyTyped(KeyEvent e) {
                    int keyChar = e.getKeyChar();
                    if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){
                        
                    }else{
                        e.consume(); //avoid invalid input
                    }
                }
            });
            text02 = new JTextField(10);
            text02.addKeyListener(new KeyAdapter(){
                public void keyTyped(KeyEvent e) {
                    int keyChar = e.getKeyChar();
                    if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){
                        
                    }else{
                        e.consume(); //avoid invalid input
                    }
                }
            });
            text03 = new JTextField(10);
            text03.addKeyListener(new KeyAdapter(){
                public void keyTyped(KeyEvent e) {
                    int keyChar = e.getKeyChar();
                    if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){
                        
                    }else{
                        e.consume(); //avoid invalid input
                    }
                }
            });
            JButton confirm = new JButton("Comfirm");
            confirm.addMouseListener(new MouseAdapter(){
                public void mousePressed(MouseEvent ae)
                {
                    String temp1 = text01.getText();
                    String temp2 = text02.getText();
                    String temp3 = text03.getText();
                    if(temp1.equals("") || temp2.equals("") || temp2.equals("") ){
                        JOptionPane.showMessageDialog(popWin,"Information Missing!");
                    }
                    else if(Integer.valueOf(temp1)>=9 && Integer.valueOf(temp1) <= 35 &&
                       Integer.valueOf(temp2)>=9 && Integer.valueOf(temp2) <= 25 &&
                       Integer.valueOf(temp3) < Integer.valueOf(temp1)*Integer.valueOf(temp2) &&
                       Integer.valueOf(temp3) >0){
                        popWin.dispose();
                        myGame.custom((int)(Integer.valueOf(temp1)),(int)(Integer.valueOf(temp2)),(int)(Integer.valueOf(temp3)));
                        myUI.repaint();
                        
                    }
                    else{
                        JOptionPane.showMessageDialog(popWin,"9 <= Width <= 35; 9 <= Height <= 25");
                    }
                    
                }
            });
            JButton cancel = new JButton("Cancel");
            cancel.addMouseListener(new MouseAdapter(){
                public void mousePressed(MouseEvent ae)
                {
                    popWin.dispose();
                }
            });
            panel01.add(label01);
            panel01.add(text01);
            panel02.add(label02);
            panel02.add(text02);
            panel03.add(label03);
            panel03.add(text03);
            panel04.add(confirm);
            panel04.add(cancel);
            panel.add(panel01);
            panel.add(panel02);
            panel.add(panel03);
            panel.add(panel04);
            content01.add(panel,BorderLayout.CENTER);
            
            popWin.pack();
            popWin.setLocation(start);
            
        }
        
        else if (e.getSource().equals(showR)){
            int tempW = 280;
            int tempH = 200;
            Point start = myUI.getStartPoint();
            start.translate(myDis.getWidth()/2-tempW/2,50);
            JFrame popWin = new JFrame("Custom");
            popWin.setSize(new Dimension(tempW,tempH));
            popWin.setPreferredSize(new Dimension(tempW,tempH));
            popWin.setVisible(true);
            
            Container content01 = popWin.getContentPane();
            
            String[] records = myGame.loadRecord();
            JLabel label01 = new JLabel("<html><br/>Beginner:    "+records[0]+"<br/><br/>"
                                        +"<html>Intermedium: "+records[1]+"<br/><br/>"
                                        +"Expert:      "+records[2]+"<br/><br/>"
                                        +"Custom:      "+records[3]+"</html>",JLabel.CENTER);
            JPanel panel = new JPanel();
            panel.add(label01);
            content01.add(panel);
            popWin.pack();
            popWin.setLocation(start);
            
            
        }
        else if (e.getSource().equals(deleteR)){
            myGame.deleteRecord();
            JOptionPane.showMessageDialog(myUI,"Record deleted!");
        }
        
        else if (e.getSource().equals(myRule)){
            JOptionPane.showMessageDialog(myUI,rules());
        }
        else if (e.getSource().equals(acknowledge)){
            JOptionPane.showMessageDialog(myUI,acknowledge());
        }
    }
    
    private String rules(){
        String rule = "";
        try{
            rule = myOperater.readTxtFile(new File("source/rules.txt"));
            
        }catch(IOException e){
            e.printStackTrace();
        }
        return rule;
    }
    
    private String acknowledge(){
        String ack = "";
        try{
            ack = myOperater.readTxtFile(new File("source/acknowledge.txt"));
            
        }catch(IOException e){
            e.printStackTrace();
        }
        return ack;
    }
}