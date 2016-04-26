package gameoflife;

public abstract class Table <T extends CloneableValue> {

    protected int size;
    protected int frame = 0;
    protected CloneableValue[][] table, temp_table;
    
    //setRuleValues
    protected int neighbours;
    protected T left, left_up, left_down, right, right_up, right_down, up, down;
    protected T current;

    public Table(int _size) {
        size = _size;
        table = new CloneableValue[size][size];
        temp_table = new CloneableValue[size][size];
    }

    public void printTable() {
        System.out.println(frame + ") ");
        for (Value[] y : table) {
            for (Value x : y){
                x = (T) x;
                System.out.print(x.getValue());
                System.out.print("\t");
            }
            System.out.print("\n\n");
        }
    }

    public void put(int x, int y, CloneableValue obj){
        table[y - 1][x - 1] = obj;
    }
    
    public void put(CloneableValue[] objs){
        int y, x;
        for (int i = 0; i < objs.length; i++) {
            x = i % size;
            y = Math.floorDiv(i, size);
            table[y][x] = objs[i];            
        }
    }

    public void checkNeighbour() {
        for (int y = 0; y < table.length; y++) {
            for (int x = 0; x < table.length; x++) {
                try {
                    rule(y, x);
                } catch (CloneNotSupportedException ex) {
                    System.out.println(ex.getCause());
                }
            }
        }
        for (int i = 0; i < table.length; i++) {
            System.arraycopy(temp_table[i], 0, table[i], 0, table.length);
        }
    }

    /**
     * @param y - the y co-ordinate of the current value
     * @param x - the x co-ordinate of the current value
     * @throws java.lang.CloneNotSupportedException
     */
    protected void rule(int y, int x) throws CloneNotSupportedException {
        
        setRuleValues(y, x);

//        // alive cell
//        if (current.isAlive()){
//            if (neighbours < 2) current = 0;
//            else if (neighbours == 2 || neighbours == 3) current = 1;
//            else if (neighbours > 3) current = 0;
//        // dead cell
//        } else {
//            if (neighbours == 3) current = 1;
//        }
        // run updateTable right after this function
    }
    
    private void setRuleValues(int y, int x) throws CloneNotSupportedException{
        current = null;
        
        current      = (T)table[y][x].clone();
        left         = checkLeft(y, x);
        left_up      = checkLeftUp(y, x);
        left_down    = checkLeftDown(y, x);
        right        = checkRight(y, x);
        right_up     = checkRightUp(y, x);
        right_down   = checkRightDown(y, x);
        up           = checkUp(y, x);
        down         = checkDown(y, x);
        
        neighbours = 0;
        {
            Value [] holder = new Value []{left, left_down, left_up, right, right_down, right_up, up, down};        
            for (int i = 0; i < holder.length; i++) {
                //if (holder[i] == -1) holder[i] = 0;
                //neighbours += holder[i];
                if (holder[i] != null)
                    if (holder[i].isAlive()) neighbours++;
            }
        }
    }
    
    protected void updateTable(int y, int x){
        temp_table[y][x] = current;
    }

    protected T checkLeft(int y, int x) {
        if (x != 0)
            return (T) table[y][x - 1];
        return null;
    }
    
    protected T checkLeftDown(int y, int x) {
        if ((x != 0) && (y != table.length - 1))
            return (T) table[y + 1][x - 1];
        return null;
    }
    
    protected T checkLeftUp(int y, int x) {
        if ((x != 0) && (y != 0))
            return (T) table[y - 1][x - 1];
        return null;
    }

    protected T checkRight(int y, int x) {
        if (x != table.length - 1)
            return (T) table[y][x + 1];
        return null;
    }
    
    protected T checkRightDown(int y, int x) {
        if ((x != table.length - 1) && (y != table.length - 1))
            return (T) table[y + 1][x + 1];
        return null;
    }
    
    protected T checkRightUp(int y, int x) {
        if ((x != table.length - 1) && (y != 0))
            return (T) table[y - 1][x + 1];
        return null;
    }

    protected T checkUp(int y, int x) {
        if (y != 0)
            return (T) table[y - 1][x];
        return null;
    }

    protected T checkDown(int y, int x) {
        if (y != table.length - 1)
            return (T) table[y + 1][x];
        return null;
    }
    
    public void nextFrame(){frame++;}
    
    public abstract boolean isDead();

    public boolean isAlive() {return !isDead();}


}
