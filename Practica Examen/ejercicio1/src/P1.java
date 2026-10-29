
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class P1 {

    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(System.in);) {
            String entrada;

            ProcessBuilder pb = new ProcessBuilder("java", "P2");
            

            Process p = pb.start();

            System.out.println("Pon un numero: ");
            entrada = sc.nextLine();

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
            bw.write(entrada);
            bw.flush();
            bw.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));

            int resultado = p.waitFor();

            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

            if (resultado == 0) {
                System.out.println("El programa a terminado correctamente");
            } else System.out.println("El programa a terminado de forma erronea");

            br.close();
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
