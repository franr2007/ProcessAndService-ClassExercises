public class Fill {
    public static void main(String[] args) {

        //Con ProcessHandle.current.pid coje el pid del proceso del hijo
        Long pid= ProcessHandle.current().pid();
        System.out.println("PID del hijo: "+ pid);

        System.err.println("Soy el hijo y estoy vivo");

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Soy el hijo, he terminado mi espera");
    }
}
