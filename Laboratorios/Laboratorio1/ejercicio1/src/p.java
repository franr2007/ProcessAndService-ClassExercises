public class p {
    public static void main(String[] args) throws Exception {
        System.out.println("PID : "+ ProcessHandle.current().pid());

        Thread.sleep(10000);

        System.out.println("Proceso acabado");
    }
}
