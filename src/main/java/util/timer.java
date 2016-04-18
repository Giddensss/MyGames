package main.java.util;

public class timer{
    private long startT = 0;
    private long endT = 0;
    private int time = 0;
    private boolean startSwitch  = false;
    private boolean stopSwitch = false;
    
    public timer(){
        
    }
    
    public void start(){
        if(!startSwitch){
            startT = System.currentTimeMillis();
            startSwitch = true;
        }
        
    }
    
    public void stop(){
        if(!stopSwitch){
            endT = System.currentTimeMillis();
            stopSwitch = true;
        }
       
    }
    
    public int getTime(){
        if(!startSwitch){
            return 0;
        }
        if(!stopSwitch){
            long currentTime = System.currentTimeMillis();
            time = (int)(currentTime - startT)/1000;

        }
        else if(stopSwitch){
            time = (int)(endT - startT)/1000;
        }
        return time;
    }
    
    public void reset(){
        startSwitch  = false;
        stopSwitch = false;
        startT = 0;
        endT = 0;
    }
    
}