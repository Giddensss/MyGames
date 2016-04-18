package main.java.display.infoPanel;



public class infoPanelFactory extends panelAbstractFactory{
    public infoPanel getPanel(String n){
        if (n.equals("L")){
           
            return new paintCheckinfo();
        }
        else if (n.equals("J")){
            
            return new paintChooseFloorPan();
        }
        else if (n.equals("C")){
            return new paintCrossPan();
        }
        else if (n.equals("P")){
            return new paintPickaxePan();
        }
        else if (n.equals("*")){
            return new paintBossFight();
        }
        else if (n.equals("~")){
            return new paintBossFight2();
        }
        else{
            
            return null;
        }
    }
    
}