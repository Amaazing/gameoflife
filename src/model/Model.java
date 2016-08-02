package model;

public class Model extends Table<Cell> {

    public Model(int _size) {
        super(_size);
    }
   
    @Override
    protected void rule(int y, int x) {
        super.rule(y, x);
        
        int neighbourCount = getNeighbourCount();
        
            if(current.isAlive()){
                if(neighbourCount != 2 && neighbourCount != 3 ){
                    current.buffer_kill();
                    updateTempTableCell(y, x);
                }
            } else if (current.isDead() && neighbourCount == 3){
                current.buffer_ressurect();
                updateTempTableCell(y, x);
            }
        
    }

    @Override
    public boolean isDead() {
        for (Value[] y : getTable()) {
            for (Value v : y) 
                if(v.isAlive()) return false;
        }
        return true;
    }
    
}
