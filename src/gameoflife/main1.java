package gameoflife;

public class main1 {

    public static void main(String[] args) {
        
        //http://stackoverflow.com/q/13575224/
        System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
        
        controller.RunMVC mvc = new controller.RunMVC();
        try {
            mvc.start();
        } catch (InterruptedException ex) {}
    }

}
