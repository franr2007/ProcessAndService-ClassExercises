import sun.misc.Signal;
import sun.misc.SignalHandler;

public class Receptor {
    public static void main(String[] args) {
            Signal.handle(new Signal("INT"), new SignalHandler() {
                @Override 
                public void handle(Signal s){
                    System.out.println("He recibido SIGINIT");
                    System.exit(0);
                }
            });

            System.out.println(ProcessHandle.current().pid());

        while (true) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
