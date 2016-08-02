package model;

public class Cell implements Value {

    private int state = 0;
    private int next_state;

    @Override
    public int getState() {
        return state;
    }
    
    @Override
    public void setState(int s) {
        state = s;
    }
    
    @Override
    public int getNextState(){
        return next_state;
    };
    
    @Override
    public void setNextState(int s){
        next_state = s;
    }

    @Override
    public boolean isAlive() {
        return state == 1;
    }

    public boolean isDead() {
        return state == 0;
    }

    public void buffer_kill() {
        next_state = 0;
    }

    public void kill() {
        state = 0;
    }

    public void buffer_ressurect() {
        next_state = 1;
    }

    public void ressurect() {
        state = 1;
    }
}
