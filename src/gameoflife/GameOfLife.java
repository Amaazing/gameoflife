package gameoflife;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Trying to implement the Game Of Life in java.
 *
 * @author Khan
 */
public class GameOfLife {

    /**
     * derp
     *
     * @param args
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {

        Table table = new Table(3);

        table.put(101011101);

        table.printTable();

        ActionListener time = (ActionEvent awt) -> {
            table.checkNeighbour();
            System.out.println("\n");
            table.printTable();
        };

        Timer t = new Timer(1000, time);
        t.setRepeats(true);
        t.start();
        
        Thread.sleep(10000);
        
    }

}
