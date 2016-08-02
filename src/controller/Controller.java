package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import view.View;
import model.*;
import javax.swing.Timer;

public class Controller {
    
    view.View view;
    model.Model model;
    int frame_number = 0;
    int SIZE;
    int DELAY = 0;
    
    public Controller(){}
    
    public void populateModel(){
        Random r = new Random();
        Cell[] array = new Cell[(int)Math.pow(SIZE, 2)];
        for (int i = 0; i < array.length; i++){
            array[i] = new Cell();
            if(i > 2 && i < 6) array[i].ressurect();
        }        
        
//        for (int i = 0; i < SIZE*5.5; i++) {
//            array[r.nextInt(SIZE*SIZE)].ressurect();
////            array[rand_pos].ressurect();
////            array[rand_pos+SIZE].ressurect();
////            array[rand_pos+(SIZE*2)].ressurect();
////            array[rand_pos+(SIZE*2) - 1].ressurect();
////            array[(rand_pos+SIZE) - 2].ressurect();            
//        }
        
        model.put(array); 
    }
    
    public void setSpeed(int speed){
        this.DELAY = speed;
    }
    
    public void begin(){
        long b = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        view.fill();
        System.out.println(a());
        view.setVisible(true);
        System.out.println(a());
        Timer timer = new Timer(DELAY, new Table_listener());
        System.out.println(a());
        timer.setInitialDelay(0);
        System.out.println(a());
        timer.start();
        System.out.println(a());
        long a = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        System.out.println("Took: " + (a-b) + "milliseconds");
    }
    
    public long a(){
        return TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
    }
        
    class Table_listener implements ActionListener{
                
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(frame_number);
            view.update();
            model.nextFrame();
            frame_number++;
            if(model.getChangedCells().isEmpty()) {
               ((Timer)e.getSource()).stop();
                System.out.println("END");
            }
        }
    }
    
    public void setView(View view){
        this.view = view;
    }
    
    public View getView(){
        return view;
    }
    
    public void setModel(Model model){
        this.model = model;
        SIZE = model.getSize();
    }
    
    public Model getModel(){
        return model;
    }
    
    public Value[][] getTable(){
        return model.getTable();
    }
    
    public ArrayList<Object> getChangedCells(){
        return model.getChangedCells();
    }
    
    public int getTableSize(){
        return model.getSize();
    }
    
    public int[][] getTableArray(){
        return model.getTableArray();
    }
    
}