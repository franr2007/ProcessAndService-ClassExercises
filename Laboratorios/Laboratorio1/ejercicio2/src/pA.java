
public class pA {

    public static void main(String[] args) throws Exception {
        ProcessBuilder pb = new ProcessBuilder("java", "p2");

        pb.inheritIO();

        Process proceso = pb.start();
    }
}
