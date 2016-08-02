package gameoflife;

import model.*;

/**
 * Trying to implement the Game Of Life in java.
 *
 * @author Khan
 */
public class main {

    /**
     * derp
     *
     * @param args
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {

        int size = 3;
        PotatoTable table = new PotatoTable(size);
        
        Potato[] potato_array = new Potato[size*size];
        for (Potato p : potato_array) p = new Potato();
        for (int i = 0; i < potato_array.length; i++)
            potato_array[i] = new Potato();
        
        potato_array[2].setMouldy();
        
        table.put(potato_array);
        
        boolean prev_frame = true;
        boolean current_frame = true;
        
        while ((current_frame == table.isAlive()) && (prev_frame == table.isAlive())){
            current_frame = table.isAlive();
            table.printTable();
            table.nextFrame();
            table.checkNeighbour();
            prev_frame = current_frame;
            current_frame = table.isAlive();
            System.out.println("\n");
            Thread.sleep(500);
        }       
        
    }

}
