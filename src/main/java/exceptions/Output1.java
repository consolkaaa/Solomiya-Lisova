package exceptions;

public class Output1 {


    public static void main(String[] args) {

//        System.err.println("#1.in");
//        try {
//            f();
//            g();
//            h();
//        }catch (Exception e){
//            System.err.println("#1.CATCH");
//        }
//        finally {
//            System.err.println("#1.out");
//        }

//        System.err.println("#1.in");
//        try {
//            f();
//            g();
//            h();
//        }catch (RuntimeException e){
//            System.err.print("RUNTIME EXCEPTION: ");
//            e.printStackTrace();
//        }

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
            //throw new Exception();
        }catch(Exception e1){
            System.err.println(".   #2.CATCH");
            System.err.println(".   #2.out");
        }

    }

    public static void g() {
        try {
            System.err.println(".   .   #3.in");
            //throw new Exception();
        }catch(Exception e2){
            System.err.println(".   .   #3.CATCH");
            System.err.println(".   .   #3.out");
        }

    }

    public static void h() throws RuntimeException{
//        try {
            System.err.println(".   .   .   #4.in");
            System.err.println(".   .   .   #4.THROW");
            throw new RuntimeException();
//        }catch (Exception e3) {
//            System.err.println(".   .   .   #4.CATCH");
//        }
        //System.err.println(".   .   .   #4.out");
    }

}
