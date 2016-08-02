package controller;

import model.Model;
import view.View;

public class RunMVC {
    
    final int SIZE = 200;
    final int WINDOW_SIZE = 600;
    final int DELAY = 1000;
    Model model;
    View view;
    Controller controller;
    
    public RunMVC(){};
    
    public void start() throws InterruptedException{
    
        model = new Model(SIZE);
        view = new View(WINDOW_SIZE);
        controller = new Controller();
        
        controller.setModel(model);
        controller.setView(view);
        view.setController(controller);
        view.setup();
        
        controller.setSpeed(DELAY);
        controller.populateModel();
        controller.begin();
        
    };
    
}
