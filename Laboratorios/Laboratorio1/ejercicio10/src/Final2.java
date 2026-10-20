public class Final2 {
    public static void main(String[] args) throws Exception{
        String pidFinal = args[0];

        System.out.println("He recibido PID de final.java: "+pidFinal);

        ProcessBuilder pb = new ProcessBuilder("java","Final3", pidFinal);

        pb.inheritIO().start();
    }
}
