import sun.misc.Signal;

public class CapturaB {
    public static void main(String[] args) throws Exception {
        Signal.handle(new Signal("INT"), signal ->{
            System.out.println("Se ha recibido la señal SIGINIT");
        });

        Signal.handle(new Signal("ALRM"), signal ->{
            System.out.println("He recibido una alarma");
        });

        Signal.handle(new Signal("TERM"), signal ->{
            System.out.println("Proceso finalizado");
        });

        Signal.handle(new Signal("HUP"), signal ->{
            System.out.println("señal ignorada");
        });

        System.out.println(ProcessHandle.current().pid());

        while (true){

        }
    }
}
