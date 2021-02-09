package exceptions;

import java.sql.SQLOutput;

public class App {


    public static void main(String[] args) {

        System.err.println("#1.in");
        try {
            f();

            g();
            h();
        }catch (Exception e){



        }
        //put code here
        finally {
            System.err.println("#1.out");
        }

    }

    public static void f() {
        try {
            System.err.println(".   #2.in");
            //throw new Exception();
        }catch(Exception e1){
            System.out.println("CATCH");
            System.err.println(".   #2.out");
        }

    }

    public static void g() {
        try {
            System.err.println(".   .   #3.in");
            //throw new Exception();
        }catch(Exception e2){
            System.out.println("CATCH");
            System.err.println(".   .   #3.out");
        }

    }

    public static void h() {
        try {
            System.err.println(".   .   .   #4.in");
            System.err.println(".   .   .   #4.THROW");
            //throw new Exception();
        }catch (Exception e3) {
            System.err.println(".   .   .   #4.out");
        }

    }

}
