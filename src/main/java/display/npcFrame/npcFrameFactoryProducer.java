package main.java.display.npcFrame;


public class npcFrameFactoryProducer {
    public static npcFrameAbstractFactory getFactory(String choice){
        if (choice.equals("frame")){
            return new npcFrameFactory();
        }
        else{ return null;}
    }
}
