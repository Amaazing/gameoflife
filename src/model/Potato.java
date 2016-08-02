package model;

public class Potato implements Value {
    
    boolean mouldy = false;
    boolean baby = true;
    
    
    public Potato(){};
    
    @Override
    public int getState() {
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

    @Override
    public void setState(int s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNextState() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNextState(int s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
