/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

/**
 *
 * @author Desktop
 */
public class PotatoTable extends Table<Potato>{

    public PotatoTable(int _size) {
        super(_size);
    }

    @Override
    protected void rule(int y, int x) throws CloneNotSupportedException {
        super.rule(y, x);
                
        Potato[] neighbour = new Potato[]{left, left_down, left_up, right,
            right_down, right_up, up, down};
        
        if(current.isFresh()){
            for (Potato p : neighbour) {
                if(p != null){
                    if (p.isMouldy()){
                        current.setMouldy();
                        break;
                    }
                }
            }
            if (current.isFresh() && current.isBaby())current.setAdult();
        }
        updateTable(y, x);
    }

    @Override
    public boolean isDead() {
        for (Value[] y : table) {
            for (Value v : y) 
                if(v.isAlive()) return false;
        }
        return true;
    }
    
    
    
}
