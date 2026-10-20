import java.util.Scanner;

public class Envia {
    public static void main(String[] args) throws Exception {
        Scanner sc= new Scanner(System.in);
        
        System.out.println("Introduce el PID: ");
        String pid = sc.nextLine();

        System.out.println("Introduce la señal (INT, HUP, TERM): ");
        String senal = sc.nextLine();

        ProcessBuilder pb = new ProcessBuilder("kill","-"+senal,pid);
        Process proceso = pb.start();
        int resultado = proceso.waitFor();

        if (resultado == 0) {
            System.out.println("Señal enviada");
        }
        else {
            System.out.println("Error al enviar la señal");
        }


        sc.close();
    }
}
