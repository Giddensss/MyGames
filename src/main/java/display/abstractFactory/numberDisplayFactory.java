package main.java.display.abstractFactory;

import main.java.display.*;

public class numberDisplayFactory extends abstractFactory{

    public numberDisplay getNumber(int num){
        if (num == 0){
            return new paintZero();
        }
        else if(num == 1){
            return new paintOne();
        }
        else if(num == 2){
            return new paintTwo();
        }
        else if(num == 3){
            return new paintThree();
        }
        else if(num == 4){
            return new paintFour();
        }
        else if(num == 5){
            return new paintFive();
        }
        else if(num == 6){
            return new paintSix();
        }
        else if(num == 7){
            return new paintSeven();
        }
        else if(num == 8){
            return new paintEight();
        }
        else if(num == 9){
            return new paintNine();
        }
        else{ return null;}
    }
    
    public numberDisplay getSymbol(int index){
        if (index == 10){
            return new paintMinus();
        }
        else{
            return null;
        }
    }
}
