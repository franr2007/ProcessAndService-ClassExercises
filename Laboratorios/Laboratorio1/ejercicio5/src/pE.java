import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class pE {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Pon algo: ");
        String texto = sc.nextLine();

        ProcessBuilder pb = new ProcessBuilder("java", "pF");

        Process proceso = pb.start();

        PrintWriter pw = new PrintWriter(proceso.getOutputStream(), true);
        pw.println(texto);
        pw.close();

        BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()));

        String linea;
        while ((linea = br.readLine()) != null) {
            System.out.println("Palabra invertida: " + linea);
        }

        proceso.waitFor();
        sc.close();
    }
}
