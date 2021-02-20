package exceptions.task_3;

public class Output_4 {

    public static void main(String[] args) {
        System.err.println("#1.in");
        f();
        System.err.println("#1.out");
    }

    public static void f() {
        System.err.println(".   #2.in");
        g();
        System.err.println(".   #2.out");
    }

    public static void g() {
        System.err.println(".   .   #3.in");
        try {
            h();
        } catch (Error e) {
            System.err.println(".   .   #3.CATCH");
        }
        System.err.println(".   .   #3.out");
    }

    public static void h() throws Error {
        System.err.println(".   .   .   #4.in");
        System.err.println(".   .   .   #4.THROW");
        if (true) {
            throw new Error();
        }
        System.err.println(".   .   .   #4.out");
    }
}
