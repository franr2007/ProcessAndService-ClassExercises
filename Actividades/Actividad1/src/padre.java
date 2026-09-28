
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class padre {

    public static void main(String[] args) {
        try {
            //crear un proceso, le pasamos la operacion y un argumento que el usuario quiera
            ProcessBuilder pb = new ProcessBuilder("java", args[0]);
            pb.redirectErrorStream(true);

            //ejecuta el proceso
            Process proceso = pb.start();

            //BufferedReader lee cada linea del texto que le proporciona InputStreamReader
            //Y InputStreamReader pasa los datos del proceso a texto 
            BufferedReader bReader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));

            String linea;

            //mientras haya lineas se imprimiran
            while ((linea = bReader.readLine()) != null) {
                System.out.println(linea);
            }

            //espera a que el hijo termine
            int resultado = proceso.waitFor();

            System.out.println("Proceso terminado con código: " + resultado);

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            System.exit(-1);
        }
    }
}
