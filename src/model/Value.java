package model;

public abstract interface Value{
    
    public abstract int getState();
    
    public abstract void setState(int s);
    
    public abstract int getNextState();
    
    public abstract void setNextState(int s);
    
    public abstract boolean isAlive();
    
}
