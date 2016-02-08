package gameoflife;

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

        Table table = new Table(6);

        String random = "";
        for(int i = 0; i < 9; i++){
            int a = (int)(Math.random() * 100);
            if(a % 2 == 0) random = random + "0";
                    else random = random + "1";
        }
        
        table.put(Table.DEAD);
        table.put(2, 2, 1);
        table.put(3, 2, 1);
        table.put(4, 2, 1);
        table.put(1, 3, 1);
        table.put(2, 3, 1);
        table.put(3, 3, 1);
        
        boolean prev_frame = true;
        boolean current_frame = true;
        
        while ((current_frame == table.isAlive()) && (prev_frame == table.isAlive())){
            current_frame = table.isAlive();
            table.printTable();
            table.checkNeighbour();
            prev_frame = current_frame;
            current_frame = table.isAlive();
            System.out.println("\n");
            Thread.sleep(500);
        }       
        
    }

}
