import sun.misc.Signal;

public class Receptor {
    public static void main(String[] args) throws Exception {
        long pid = ProcessHandle.current().pid();
        System.out.println("El meu PID és: " + pid);

        Signal.handle(new Signal("TERM"), signal -> {
            System.out.println("He rebut SIGTERM");
        });

        Signal.handle(new Signal("HUP"), signal -> {
            System.out.println("He rebut SIGHUP");
        });

        Signal.handle(new Signal("INT"), signal -> {
            System.out.println("He rebut SIGINT");
        });

        while (true) {
            
        }
    }
}
