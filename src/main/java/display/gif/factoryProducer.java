package main.java.display.gif;


public class factoryProducer {
    public static abstractFactory getFactory(String choice){
        if (choice.equals("environment")){
            return new environmentDisplayFactory();
        }
        else if(choice.equals("item")){
            return new itemDisplayFactory();
        }
        else if(choice.equals("npc")){
            return new npcDisplayFactory();
        }
        else if(choice.equals("minions")){
            return new minionsDisplayFactory();
        }
        else{ return null;}
    }
}
