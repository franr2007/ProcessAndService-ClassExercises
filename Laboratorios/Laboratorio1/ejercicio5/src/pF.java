
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class pF {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        String texto = br.readLine();

        ProcessBuilder pb = new ProcessBuilder("java", "pG");
        pb.redirectErrorStream(true);
        Process proceso = pb.start();

        PrintWriter pw = new PrintWriter(
            proceso.getOutputStream(), true
        );

        pw.println(texto);
        pw.close();

        BufferedReader br2 = new BufferedReader(
            new InputStreamReader(proceso.getInputStream())
        );

        String linea;
        while ((linea = br2.readLine()) != null) {
            System.out.println(linea);
        }

        proceso.waitFor();
        br.close();
        br2.close();
    }
}
