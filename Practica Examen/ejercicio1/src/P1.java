import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class P1 {

    public static void main(String[] args) throws Exception {
        try {
            Scanner sc= new Scanner(System.in);
            ProcessBuilder pb = new ProcessBuilder("java","P2");
            Process proceso = pb.start();

            BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()));

            System.out.println("Escribe un numero");
            String numero = sc.next();

            PrintWriter pw = new PrintWriter(proceso.getOutputStream(), true);
            pw.write(numero);
            pw.close();

            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println("Salida hijo: "+linea);
            }

            proceso.waitFor();

            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
