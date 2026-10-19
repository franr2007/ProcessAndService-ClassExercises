import sun.misc.Signal;

public class Captura {
    public static void main(String[] args) throws Exception {
        Signal.handle(new Signal("INT"), signal -> {
            System.out.println("Se ha recibido la señal SIGINIT");
        });

        while (true) {
            
        }
    }
}
