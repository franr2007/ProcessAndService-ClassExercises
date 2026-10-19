
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class pD {
   public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       String texto = br.readLine();

       System.out.println(texto.toUpperCase());

       br.close();
   } 
}
