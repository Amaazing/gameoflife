package gameoflife;

import java.util.Arrays;

/**
 * Table class for gameoflife, the grid is represent by a 2D array
 *
 * @author Khan
 */
public class Table {
    static final int ALIVE = 1;
    static final int DEAD = 0;
    int frame = 0;
    int[][] table, temp_table;
    int size;

    /**
     * Initialise the Table object, and make the 2D array. Size is the dimension
     * of the gird. e.g. Table t = new Table(3, 3); 3 x 3 grid
     *
     * @param size - dimension of the gird
     */
    public Table(int _size) {
        size = _size;
        table = new int[size][size];
        temp_table = new int[size][size];        
    }

    /**
     * Prints the table like so: [ 0, 0, 0 ] y = 0 [ 0, 0, 0 ] y = 1 [ 0, 0, 0 ]
     * y = 2
     *
     * assuming it's a 3 x 3
     */
    public void printTable() {
        System.out.println(frame+") ");
        for (int y = 0; y < table.length; y++) {
            System.out.println(Arrays.toString(table[y]));
        }
        frame++;
    }

    /**
     * Inserts a value at a specific position in the grid.
     *
     * @param x - the x co-ordinate
     * @param y - the y co-ordinate
     * @param value - the value that's to be inserted
     */
    public void put(int x, int y, int value) {
        table[y - 1][x - 1] = value;
    }

    /**
     * Another way to put in values; instead of putting values in one by one you
     * can pass the function string of values. The length of the passed string
     * should be the same as the size of the grid (size ^ 2)
     *
     * @param serial - passed string of single digit values which is converted to
     * an array
     *
     */
    public void put(String serial) {
        int[] s = stringToArray(serial);
        if (s.length == Math.pow(table.length, 2)) {
            int n = 0;
            for (int[] y : table) {
                for (int x = 0; x < y.length; x++) {
                    n++;
                    y[x] = s[n - 1];
                }
            }
        } else {
            // what if insert < 9 values           
        }
    }
    
    public void put (int state){
        if (state == ALIVE || state == DEAD)
            for (int[] y : table) Arrays.fill(y, state);        
    }

    /**
     * Does the function of checking the neighbouring cells.
     */
    public void checkNeighbour() {
        for (int y = 0; y < table.length; y++){
            for (int x = 0; x < table.length; x++){
                if(frame == 1){}
                rule(y, x);
            }
        }
        for (int i = 0; i < table.length; i++)
            System.arraycopy(temp_table[i], 0, table[i], 0, table.length);
    }

    private void rule(int y, int x) {

        /**
         * @param y - the y co-ordinate of the current value
         * @param x - the x co-ordinate of the current value
         */

        int left, left_up, left_down, right, right_up, right_down, up, down;
        left = checkLeft(y, x);
        left_up = checkLeftUp(y, x);
        left_down = checkLeftDown(y, x);
        right = checkRight(y, x);
        right_up = checkRightUp(y, x);
        right_down = checkRightDown(y, x);
        up = checkUp(y, x);
        down = checkDown(y, x);

        int neighbours = 0;
        int current = table[y][x];
        {
            int [] holder = new int []{left, left_down, left_up, right, right_down, right_up, up, down};        
            for (int i = 0; i < holder.length; i++) {
                if (holder[i] == -1) holder[i] = 0;
                neighbours += holder[i];
            }
        }

        // alive cell
        if (current == 1){
            if (neighbours < 2) current = 0;
            else if (neighbours == 2 || neighbours == 3) current = 1;
            else if (neighbours > 3) current = 0;
        // dead cell
        } else {
            if (neighbours == 3) current = 1;
        }
                
        temp_table[y][x] = current;
        
    }

    private int checkLeft(int y, int x) {
        if (x != 0)
            return table[y][x - 1] == 1 ? 1 : 0;
        return -1 ;
    }
    
    private int checkLeftDown(int y, int x) {
        if ((x != 0) && (y != table.length - 1))
            return table[y + 1][x - 1] == 1 ? 1 : 0;
        return -1 ;
    }
    
    private int checkLeftUp(int y, int x) {
        if ((x != 0) && (y != 0))
            return table[y - 1][x - 1] == 1 ? 1 : 0;
        return -1 ;
    }

    private int checkRight(int y, int x) {
        if (x != table.length - 1)
            return table[y][x + 1] == 1 ? 1 : 0;
        return -1;
    }
    
    private int checkRightDown(int y, int x) {
        if ((x != table.length - 1) && (y != table.length - 1))
            return table[y + 1][x + 1] == 1 ? 1 : 0;
        return -1;
    }
    
    private int checkRightUp(int y, int x) {
        if ((x != table.length - 1) && (y != 0))
            return table[y - 1][x + 1] == 1 ? 1 : 0;
        return -1;
    }

    private int checkUp(int y, int x) {
        if (y != 0)
            return table[y - 1][x] == 1 ? 1 : 0;
        return -1;
    }

    private int checkDown(int y, int x) {
        if (y != table.length - 1)
            return table[y + 1][x] == 1 ? 1 : 0;
        return -1;
    }
    
    public boolean isDead(){
        int sum = 0;
        for (int[] t:  table)
            for (int i = 0; i < t.length; i++)
                sum += t[i];
                
        return sum == 0;
    }
    
    public boolean isAlive(){
        return !isDead();
    }
    
    private int[] stringToArray(String s){
        int[] array = new int[s.length()];
        
        for (int i = 0; i < s.length(); i++)
            array[i] = Integer.valueOf(String.valueOf(s.charAt(i)));
        
        return array;
    }

}
