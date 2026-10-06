import sun.misc.Signal;

public class App {

    public static void main(String[] args){
        Signal.handle(new Signal("INT"), signal -> {
            System.out.println("He rebut SIGINT");
            System.out.println("Res mes");
            System.exit(0);
        });

        Signal.handle(new Signal("HUP"), signal -> {
            System.out.println("He rebut SIGHUP");
            System.out.println("Res mes");
        });

        System.out.println("Esperant senyals...");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
