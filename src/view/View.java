package view;

import controller.Controller;
import java.awt.GridLayout;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.util.HashMap;
import java.util.Random;
import java.awt.Color;
import model.Value;

public class View extends JFrame {

    JLabel[][] labels;
    Controller controller;
    int SIZE;
    int WINDOW_SIZE;
    HashMap<Integer, Color> COLOURS = new HashMap<>();
    Random rand = new Random();
    int r, g, b;

    public View(int window_size) {
        this.WINDOW_SIZE = window_size;
//        COLOURS.put(0, random_color(255, 0, 0));
//        COLOURS.put(1, random_color(0, 0, 255));
    };
    
    public void setController(Controller controller){
        this.controller = controller;
    }
    
    public void setup() {
        SIZE = controller.getTableSize();
        labels = new JLabel[SIZE][SIZE];
        for (JLabel[] label : labels) {
            for (int j = 0; j < labels.length; j++) {
                label[j] = new JLabel();
                label[j].setHorizontalAlignment(SwingConstants.CENTER);
                label[j].setVerticalAlignment(SwingConstants.CENTER);
                //labels[i][j].setText("0");
                label[j].setOpaque(true);
                this.add(label[j]);
            }
        }
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GridLayout grid = new GridLayout(SIZE, SIZE);
        setLayout(grid);
        setSize(WINDOW_SIZE, WINDOW_SIZE);
    }
    
    public void update(){
        fill();
    }
    
    public void fill() {
//        for (Integer[] key : controller.getChangedCells().keySet()){
////            labels[key[0]][key[1]].setText(String.valueOf(controller.getChangedCells().get(key).getState());
//            labels[key[0]][key[1]].setBackground(
//                    random_color(
//                        controller.getChangedCells().get(key).getState()
//                    )
//            );
//        }
        for (int i = 0; i < controller.getChangedCells().size(); i+=3) {
            int x = (int) controller.getChangedCells().get(i);
            int y = (int) controller.getChangedCells().get(i+1);
            Value cell = (Value) controller.getChangedCells().get(i+2);
            
            labels[x][y].setBackground(random_color(cell.getState()));
        }
   }
    
    private Color random_color(int state){
        if (state == 1){
//            r = rand.nextInt(128) + 127;
//            g = r - (127/5);
//            b = g - (127/5);
            r = g = b = 0;
        } else {
            b = rand.nextInt(128) + 127; 
            r = rand.nextInt(128) + 127; 
            g = rand.nextInt(128) + 127; 
        }
        return new Color(r,g,b);
    }
    
}
