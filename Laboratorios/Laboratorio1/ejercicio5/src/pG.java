import java.io.BufferedReader;
import java.io.InputStreamReader;

public class pG {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String texto = br.readLine();
        String textoReves="";

        for(int i=texto.length()-1; i>=0; i--){
            textoReves += texto.charAt(i);
        }

        System.out.println(textoReves);

        br.close();
    }
}
