package main.java.util;

import main.java.util.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
public class minionsDataReader{
    private fileOperater myFile;
    private HashMap<String,int[]> data;
    public minionsDataReader(){
        data = new HashMap<String,int[]>();
        read();
    }
    
    private void read(){
        File f = new File("source/map/data.txt");
        String temp = "";
        try{
           temp = myFile.readTxtFile(f);
        }catch(IOException e){
            e.printStackTrace();
        }
        
        temp.replaceAll("\n","");
        char[] c = temp.toCharArray();
        int count = 0;
        int index = 0;
        String name = "";
        String value = "";
        int[] stats = new int[5];
        while(count<c.length-1){
            if(!Character.isDigit(c[count]) && String.valueOf(c[count+1]).equals(":")){
                name = String.valueOf(c[count]);
                
            }
            else if(Character.isDigit(c[count])){
                value += String.valueOf(c[count]);
                
            }
            else if(String.valueOf(c[count]).equals("|")){
                stats[index] = Integer.valueOf(value);
                //System.out.println(value);
                value = "";
                index ++;
                
            }
            else if (String.valueOf(c[count]).equals("&")){
                data.put(name,stats);
                name = "";
                stats = new int[5];
                index = 0;
            }
            
            count++;

        }
    }
    
    public int[] getData(String minion){
        return data.get(minion);
    }
    
    
}