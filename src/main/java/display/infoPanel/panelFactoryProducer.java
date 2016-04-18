package main.java.display.infoPanel;


public class panelFactoryProducer {
    public static panelAbstractFactory getFactory(String choice){
        if (choice.equals("info")){
            return new infoPanelFactory();
        }
        else{ return null;}
    }
}
