import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int numero = Integer.parseInt(br.readLine());

            System.out.println("Valor recibido: "+numero);
            System.out.println("Numero multiplicado x2: "+(numero*2));

            long pid = ProcessHandle.current().pid();
            System.out.println("PID del hijo: "+pid);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
