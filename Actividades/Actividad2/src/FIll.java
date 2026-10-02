
public class FIll {

    public static void main(String[] args) {

        try {
            System.out.println("Procés fill iniciat. Esperant una senyal...");
            Thread.sleep(10000);
            System.out.println("Senyal SIGALRM rebuda");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
