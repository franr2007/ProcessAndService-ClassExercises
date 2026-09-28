public class hijo {
    public static void main(String[] args) {
        System.out.println("Processing");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finished");
    }
}
