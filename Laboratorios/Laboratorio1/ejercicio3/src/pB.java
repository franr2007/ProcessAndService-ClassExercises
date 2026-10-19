
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class pB {

    public static void main(String[] args) throws Exception {
        ProcessBuilder pb = new ProcessBuilder("java", "p2");

        Process proceso = pb.start();

        String linea;

        BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()));

        while ((linea = br.readLine()) != null) {
            System.out.println("'Salida del Hijo:' " + linea);
        }
    }
}
