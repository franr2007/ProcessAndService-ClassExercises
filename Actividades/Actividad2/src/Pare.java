
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pare {

    public static void main(String[] args) {

        try {
            ProcessBuilder pb = new ProcessBuilder("java","Fill.java");
            pb.redirectErrorStream(true);

            Process proceso = pb.start();
            long pidHijo = proceso.pid();
            System.out.println("PID del hijo: "+pidHijo);

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(proceso.getInputStream())
            );

            System.out.println("El padre espera 3 segundos...");
            Thread.sleep(3000);

            ProcessBuilder pb2 = new ProcessBuilder("kill","-ALRM" , String.valueOf(pidHijo));
            pb2.start();

            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
            proceso.waitFor();
            System.out.println("El proceso hijo a terminado");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException ex){
            ex.printStackTrace();
        }

    }
}
