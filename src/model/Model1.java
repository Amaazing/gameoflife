//package model;
//
//public class Model extends Table<Potato>{
//
//    public Model(int _size) {
//        super(_size);
//    }
//   
//    @Override
//    protected void rule(int y, int x) throws CloneNotSupportedException {
//        super.rule(y, x);
//                
//        Potato[] neighbour = new Potato[]{left, left_down, left_up, right,
//            right_down, right_up, up, down};
//        
//        if(current.isFresh()){
//            for (Potato p : neighbour) {
//                if(p != null){
//                    if (p.isMouldy()){
//                        current.setMouldy();
//                        break;
//                    }
//                }
//            }
//            if (current.isFresh() && current.isBaby())current.setAdult();
//        }
//        updateTable(y, x);
//    }
//
//    @Override
//    public boolean isDead() {
//        for (Value[] y : table) {
//            for (Value v : y) 
//                if(v.isAlive()) return false;
//        }
//        return true;
//    }
//    
//}
