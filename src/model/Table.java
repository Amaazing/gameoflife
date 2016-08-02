package model;

import java.util.ArrayList;

public abstract class Table <T extends Value> {

    private int size;
    private int frame = 0;
    private Value[][] table;
    private ArrayList<Object> changed_cells = new ArrayList<>();
    
    //setRuleValues
    private int neighbours = 0;
    protected T left, left_up, left_down, right, right_up, right_down, up, down;
    protected T current;
    
    
    public Table(int _size) {
        size = _size;
        table = new Value[size][size];
    }
    
    public void put(int x, int y, Value value){
        table[y - 1][x - 1] = value;
        
        if (value.isAlive()){
            changed_cells.add(y);
            changed_cells.add(x);
            changed_cells.add(value);
        }
    }
    
    public void put(Value[] values){
        int y, x;
        for (int i = 0; i < values.length; i++) {
            x = i % size;
            y = Math.floorDiv(i, size);
            table[y][x] = values[i]; 
            if (values[i].isAlive()){
                changed_cells.add(y);
                changed_cells.add(x);
                changed_cells.add(values[i]);
            }
        }
    }

    public void nextFrame(){
        frame++;
        checkNeighbour();
    }
    
    private void checkNeighbour() {

        changed_cells.clear();
        for (int y = 0; y < table.length; y++)
            for (int x = 0; x < table.length; x++)
                rule(y, x);

        for (int i = 0; i < changed_cells.size(); i+=3) {
            int y = (int) changed_cells.get(i);
            int x = (int) changed_cells.get(i+1);
            T cell = (T) changed_cells.get(i+2);
            
            table[y][x].setState(cell.getNextState());
            
        }
    }

    /**
     * @param y - the y co-ordinate of the current value
     * @param x - the x co-ordinate of the current value
     */
    protected void rule(int y, int x) {        
        setRuleValues(y, x);
    }
    
    private void setRuleValues(int y, int x) {
        
        current      =      (T)table[y][x];
        left         =      getLeft(y, x);
        left_up      =      getLeftUp(y, x);
        left_down    =      getLeftDown(y, x);
        right        =      getRight(y, x);
        right_up     =      getRightUp(y, x);
        right_down   =      getRightDown(y, x);
        up           =      getUp(y, x);
        down         =      getDown(y, x);
        
        {
            Value [] holder = new Value []
            {left, left_down, left_up, right, right_down, right_up, up, down};
            
            for (Value v : holder) if (v != null && v.isAlive())
                neighbours++;
        }
    }
    
    protected void updateTempTableCell(int y, int x){
        changed_cells.add(y);
        changed_cells.add(x);
        changed_cells.add(current);
    }

    private T getLeft(int y, int x) {
        if (x != 0)
            return (T) table[y][x - 1];
        return null;
    }
    
    private T getLeftDown(int y, int x) {
        if ((x != 0) && (y != table.length - 1))
            return (T) table[y + 1][x - 1];
        return null;
    }
    
    private T getLeftUp(int y, int x) {
        if ((x != 0) && (y != 0))
            return (T) table[y - 1][x - 1];
        return null;
    }

    private T getRight(int y, int x) {
        if (x != table.length - 1)
            return (T) table[y][x + 1];
        return null;
    }
    
    private T getRightDown(int y, int x) {
        if ((x != table.length - 1) && (y != table.length - 1))
            return (T) table[y + 1][x + 1];
        return null;
    }
    
    private T getRightUp(int y, int x) {
        if ((x != table.length - 1) && (y != 0))
            return (T) table[y - 1][x + 1];
        return null;
    }

    private T getUp(int y, int x) {
        if (y != 0)
            return (T) table[y - 1][x];
        return null;
    }

    private T getDown(int y, int x) {
        if (y != table.length - 1)
            return (T) table[y + 1][x];
        return null;
    }
       
    public abstract boolean isDead();

    public boolean isAlive() {return !isDead();}
    
    public int getNeighbourCount(){
        return neighbours;
    }
    
    public int[][] getTableArray(){
        int [][] table_array = new int[size][size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                table_array[i][j] = table[i][j].isAlive() ? 1 : 0;
            }
        }
        return table_array;
    }
    
    public Value[][] getTable(){
        return table;
    }
    
    public ArrayList<Object> getChangedCells(){
        return changed_cells;
    }

    public int getSize(){
        return size;
    }
    
    public void printTable() {
        System.out.println(frame + ") ");
        for (Value[] y : table) {
            for (Value x : y){
                x = (T) x;
                System.out.print(x.getState());
                System.out.print("\t");
            }
            System.out.print("\n\n");
        }
    }

}
