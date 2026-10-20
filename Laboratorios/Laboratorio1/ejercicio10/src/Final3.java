public class Final3 {
    public static void main(String[] args) throws Exception{
        String pidFinal = args[0];
        
        System.out.println("Enviando señal SIGINT...");

        ProcessBuilder pb = new ProcessBuilder("kill","-INT", pidFinal);
        Process proceso = pb.start();
        int resultado = proceso.waitFor();

        if (resultado != 0) {
            System.out.println("Error al enviar la señal");
        }
    }
}
