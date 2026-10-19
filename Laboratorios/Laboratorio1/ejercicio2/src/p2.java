
public class p2 {

    public static void main(String[] args) {
        System.out.println("PID HIJO : " + ProcessHandle.current().pid());

        System.out.println("PID PADRE :" + ProcessHandle.current().parent().get().pid());
    }
}
