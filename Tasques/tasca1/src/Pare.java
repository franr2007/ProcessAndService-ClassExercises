
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class Pare {

    public static void main(String[] args) {
        try {

            System.out.println("PID del padre: " + ProcessHandle.current().pid());

            ProcessBuilder pb = new ProcessBuilder("java", "Fill.java");
            pb.redirectErrorStream(true);

            Process proceso = pb.start();

            BufferedReader bReader = new BufferedReader(
                    new InputStreamReader(proceso.getInputStream())
            );

            String line;
            while ((line = bReader.readLine()) != null) {
                System.out.println(line);
            }

            boolean fin = proceso.waitFor(15, TimeUnit.SECONDS);

            if (!fin) {
                proceso.destroyForcibly();

                System.out.println("El padre ha matado al hijo");
            }

        } catch (IOException ex) {
            System.err.println("Excepcion de I/O!");
        } catch (InterruptedException ex) {
            System.err.println("El proceso hijo ha finalizado de forma incorrecta");
        }

    }
}
