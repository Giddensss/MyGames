package main.java.game;
import java.util.*;

public class board{
    
    private int board_width;
    private int board_height;
    private int minesCounter;
    private int[][] board;
    private LinkedList<int[]> tempMinesLoc;
    
    public board(int width,int height,int mines){
        board_width = width;
        board_height = height;
        minesCounter = mines;
        board = new int[board_height][board_width];
        tempMinesLoc = new LinkedList<int[]>();
        setup();
        
       
    }

    private void place_mine(){
        
        for (int i = 0; i < minesCounter; i++){
            int[] temp_loc = createMine();
            while(!check(temp_loc,tempMinesLoc)){
                temp_loc = createMine();
            }
            board[temp_loc[1]][temp_loc[0]] = -1;
            tempMinesLoc.add(temp_loc);
        }
    }
    
    private void set_board(){
        for (int i = 0; i < board_width; i++){
            for (int j = 0; j < board_height; j++){
                if (board[j][i] != -1){
                    int counter = 0;
                    for (int m = i-1; m <= i+1; m++){
                        for(int n = j-1; n <= j+1; n++){
                            if(m >= 0 && n >= 0 && m < board_width && n < board_height){
                                if(board[n][m] == -1){
                                    counter++;
                                }
                            }
                        }
                    }
                    board[j][i] = counter;
                }
            }
        }
    }
    
    private int[] createMine(){
        int[] loc = new int[2]; //x is on index 0, y is on index 1
        loc[0] = (int)(Math.random()*board_width);
        loc[1] = (int)(Math.random()*board_height);
        return loc;
    }
    
    private void setup(){
        place_mine();
        set_board();
    }
    
    private boolean check(int[] a, LinkedList<int[]> b){
        boolean isCheck = true;
        for (int[] temp:b){
            if (Arrays.equals(a,temp)){
                isCheck = false;
            }
        }
        return isCheck;
    }
    
    public String toString(){
        String toPrint = "";
        for(int i = 0; i < board_height; i++){
            for(int j = 0; j < board_width; j++){
                if (board[i][j] == -1){
                    toPrint += "| " + "*" + " |";
                }
                else{
                    toPrint += "| " + board[i][j] + " |";
                }
            }
            toPrint += "\n";
        }
        return toPrint;
    }
    
    public int[] getSize(){
        int[] size = new int[2];
        size[0] = board_width;
        size[1] = board_height;
        return size;
    }
    
    public String getValue(int x,int y){
        if (board[y][x] == -1){
            return "M";
        }
        else{
            return String.valueOf(board[y][x]);
        }
    }
    
    public boolean isMine(int x, int y){
        return (board[y][x] == -1);
    }
    
    public LinkedList<int[]> getMines(){
        return tempMinesLoc;
    }
    
    
}