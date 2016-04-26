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

        int size = 6;
        Table_old table = new Table_old(size);

        String random = "";
        for(int i = 0; i < Math.pow(size, 2); i++){
            int a = (int)(Math.random() * 100);
            if(a % 2 == 0) random = random + "0";
                    else random = random + "1";
        }
        
        table.put(random);
        
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
