import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Emissor {
    public static void main(String[] args) {
        try {
            ProcessBuilder pb = new ProcessBuilder("java", "Receptor");
            Process proceso = pb.start();

            BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()));

            String primeraLinea = br.readLine();
            long pid = Long.parseLong(primeraLinea);

            System.out.println("PID del receptor: "+pid);

            new ProcessBuilder("kill","-INT", String.valueOf(pid)).start();

            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println("Salida hijo: "+linea);
            }

            proceso.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }
}
