import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class P1 {

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            ProcessBuilder pb = new ProcessBuilder("java", "P2");
            Process proceso = pb.start();

            System.out.println("Escribe un numero");
            String numero = sc.next();

            try (OutputStreamWriter w = new OutputStreamWriter(proceso.getOutputStream())) {
                w.write(numero);
                w.flush();
            }

            try (BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()))) {

                String linea;
                while ((linea = br.readLine()) != null) {
                    System.out.println("Salida hijo: " + linea);
                }
            }

            proceso.waitFor();

            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
