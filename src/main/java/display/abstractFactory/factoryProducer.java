package main.java.display.abstractFactory;


public class factoryProducer {
    public static abstractFactory getFactory(String choice){
        if (choice.equals("number")){
            return new numberDisplayFactory();
        }
        else{ return null;}
    }
}
