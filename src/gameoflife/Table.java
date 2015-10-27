package gameoflife;

import java.util.Arrays;

/**
 * Table class for gameoflife, the grid is represent by a 2D array
 *
 * @author Khan
 */
public class Table {

    int[][] table;
    int size;

    /**
     * Initialise the Table object, and make the 2D array. Size is the dimension
     * of the gird. e.g. Table t = new Table(3, 3); 3 x 3 grid
     *
     * @param size - dimension of the gird
     */
    public Table(int size) {
        this.size = size;
        table = new int[size][size];
    }

    /**
     * Prints the table like so: 
     * [ 0, 0, 0 ] y = 0
     * [ 0, 0, 0 ] y = 1
     * [ 0, 0, 0 ] y = 2
     *
     * assuming it's a 3 x 3
     */
    public void printTable() {
        for (int y = 0; y < table.length; y++) {
            System.out.println(Arrays.toString(table[y]));
        }
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
     * can pass the function an array of values. The length of the passed array
     * should be the same as the size of the grid (size ^ 2)
     *
     * @param serial - passed int of single digit values which is converted to
     * an array
     * 
     */
    public void put(int serial) {
        int [] s = intToArray(serial);
        if (s.length != Math.pow(table.length, 2)) { // what if insert <9 values
        } else {
            int n = 0;
            for (int y = 0; y < table.length; y++) {
                for (int x = 0; x < table[y].length; x++) {
                    n++;
                    table[y][x] = s[n - 1];
                }

            }
        }
    }

    /**
     * Does the function of checking the neighbouring cells.
     */
    public void checkNeighbour() {

        for (int y = 0; y < table.length; y++) {
            for (int x = 0; x < table[0].length; x++) {
                rule(y, x);
            }
        }

    }

    private void rule(int y, int x) {

        /**
         * Rule: If there exists a 1 to the right of a 0, it becomes a 1. If
         * there exists a 0 to the right of a 1, it becomes a 0.
         *
         * @param y - the y co-ordinate of the current value
         * @param x - the x co-ordinate of the current value
         */
        if (table[y][x] == 0 && checkRight(y, x)) {
            table[y][x] = 1;
        } else if (table[y][x] == 1 && !checkRight(y, x)) {
            table[y][x] = 0;
        }

    }

    private boolean checkLeft(int y, int x) {
        if (x != 0) {
            return table[y][x - 1] == 1;
        }
        return table[y][x] == 1;
    }

    private boolean checkRight(int y, int x) {
        if (x != table.length - 1) {
            return table[y][x + 1] == 1;
        }
        return table[y][x] == 1;
    }

    private boolean checkAbove(int y, int x) {
        if (y != 0) {
            return table[y - 1][x] == 1;
        }
        return table[y][x] == 1;
    }

    private boolean checkBelow(int y, int x) {
        if (y != table.length - 1) {
            return table[y + 1][x] == 1;
        }
        return table[y][x] == 1;
    }

    private int[] intToArray(int x) {
        int length = (int) (Math.log10(x) + 1);        
        //int length = String.valueOf(x).length();
        
        int[] array = new int[length];

        for (int i = 0; i < length; i++) {
            array[i] = (int) (x / Math.pow(10, length - (i+1)) % 10);
        }
        
        return array;
    }

}
