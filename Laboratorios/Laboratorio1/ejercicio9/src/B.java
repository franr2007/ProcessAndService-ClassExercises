import java.util.Scanner;

public class B {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el PID de A.java: ");
        String pid = sc.nextLine();
        
        ProcessBuilder pb = new ProcessBuilder("kill","-ALRM", pid);
        Process proceso = pb.start();
        proceso.waitFor();

        System.out.println("Señal ALRM enviada");

        Thread.sleep(2000);

        ProcessBuilder pb2 = new ProcessBuilder("kill","-HUP",pid);
        Process proceso2 = pb2.start();
        proceso2.waitFor();

        System.out.println("Señal HUP enviada");

        sc.close();
    }
}
