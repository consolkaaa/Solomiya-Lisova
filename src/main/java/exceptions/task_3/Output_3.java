package exceptions.task_3;

public class Output_3 extends Output_1 {
    public static void main(String[] args) {

        System.err.println("\n------Output3------\n");

        System.err.println("#1.in");
        try {
            f();
        }catch (RuntimeException e){
            System.err.print("#1.CATCH");
        }
        finally {
            System.err.println("#1.out");
        }
    }

    public static void f(){
        try {
            System.err.println(".   #2.in");
            g();
            h();
        }catch(Exception e1){
            System.err.println(".   #2.CATCH");
        }finally {
            System.err.println(".   #2.out");
        }
    }

}
