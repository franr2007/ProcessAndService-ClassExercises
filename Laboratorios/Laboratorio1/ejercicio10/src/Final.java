import sun.misc.Signal;

public class Final {
    public static void main(String[] args) throws Exception {
        long pid = ProcessHandle.current().pid();
        System.out.println("PID Final.java: "+pid);

        Signal.handle(new Signal("INT"), signal -> {
            System.out.println("Señal SIGINT recibida");
            System.exit(0);
        });

        ProcessBuilder pb = new ProcessBuilder("java", "Final2", String.valueOf(pid));

        pb.inheritIO().start();

        while (true) {
            
        }
    }
}
