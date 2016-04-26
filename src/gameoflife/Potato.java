package gameoflife;

public class Potato extends CloneableValue {
    
    boolean mouldy = false;
    boolean baby = true;
    
    
    Potato(){};
    
    @Override
    public int getValue() {
        if (isMouldy()) return 0;
        if (isAdult()) return 3;
        if (isBaby()) return 2;
        return -1;
    }

    @Override
    public boolean isAlive() {
        return isFresh();
    }
    
    public void setMouldy()     {mouldy = true;}
    
    public void setFresh()      {mouldy = false;}
    
    public void setAdult()      {baby = false;}
    
    public void setBaby()       {baby = true;}
    
    public boolean isMouldy()   {return mouldy;}
    
    public boolean isFresh()    {return !mouldy;}
    
    public boolean isAdult()    {return !baby;}
    
    public boolean isBaby()     {return baby;}
    
}
