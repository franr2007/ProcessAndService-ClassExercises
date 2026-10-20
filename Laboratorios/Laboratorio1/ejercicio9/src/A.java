import sun.misc.Signal;

public class A {
    public static void main(String[] args) throws Exception {
        long pid = ProcessHandle.current().pid();
        System.out.println("PID: " + pid);

        Signal.handle(new Signal("ALRM"), signal -> {
            System.out.println("Señal ALRM");
        });

        Signal.handle(new Signal("HUP"), signal -> {
            System.out.println("Señal Hup");
        });

        while (true) {
        }
    }
}
