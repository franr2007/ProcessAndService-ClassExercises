
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class padre {

    public static void main(String[] args) {
        try {
            //crear un proceso, le pasamos la operacion y un argumento que el usuario quiera
            ProcessBuilder pb = new ProcessBuilder("java", args[0]);
            pb.redirectErrorStream(true);

            Process proceso = pb.start();

            BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()));

            String linea;

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            
            int resultado = proceso.waitFor();

            System.out.println("Proceso terminado con código: " + resultado);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
