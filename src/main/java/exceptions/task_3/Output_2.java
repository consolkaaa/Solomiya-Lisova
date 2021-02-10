package exceptions.task_3;

public class Output_2 extends Output_1 {

    public static void main(String[] args) {
        System.err.println("\n------Output2------\n");

        System.err.println("#1.in");
        f();
        g();
        h();
        System.err.println("#1.out");
    }

    public static void h() throws Error{
        System.err.println(".   .   .   #4.in");
        System.err.println(".   .   .   #4.THROW");
        System.err.print("RUNTIME EXCEPTION: ");
        throw new Error();
    }
}
