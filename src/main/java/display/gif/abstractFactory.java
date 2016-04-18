package main.java.display.gif;

public abstract class abstractFactory {
    abstract public environment getEnv(String e);
    abstract public item getItems(String i);
    abstract public npcdis getNpc(String n);
    abstract public minionsdis getMin(String m);
    
}
