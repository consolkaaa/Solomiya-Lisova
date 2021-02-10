package exceptions;

public class Output_1 {

    public static void main(String[] args) {

        System.err.println("\n------Output1------\n");

        System.err.println("#1.in");
        try {
            f();
            g();
            h();
        }catch (Exception e){
            System.err.println("#1.CATCH");
        }
        finally {
            System.err.println("#1.out");
        }
    }

    public static void f(){
        try {
            System.err.println(".   #2.in");
        }catch(Exception e1){
            System.err.println(".   #2.CATCH");
            System.err.println(".   #2.out");
        }
    }

    public static void g() {
        try {
            System.err.println(".   .   #3.in");
        }catch(Exception e2){
            System.err.println(".   .   #3.CATCH");
            System.err.println(".   .   #3.out");
        }
    }

    public static void h() throws Exception{
        System.err.println(".   .   .   #4.in");
        System.err.println(".   .   .   #4.THROW");
        throw new Exception();
    }
}
