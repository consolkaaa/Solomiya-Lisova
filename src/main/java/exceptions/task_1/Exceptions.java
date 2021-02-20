package exceptions.task_1;

public class Exceptions {
    public static void main(String[] args){
        checked();
        unchecked();
    }

    private static void checked(){
        System.err.println("\n------Checked------\n");

        try {
            checkedDivision(5, 0);
        }catch (Checked myCheckedException){
            System.err.println(myCheckedException.description);
        }
    }

    private static int checkedDivision(int arg1, int arg2) throws Checked{
        if (arg2 == 0) {
            throw new Checked();
        }
        int result = arg1 / arg2;
        return result;
    }

    private static void unchecked(){
        System.err.println("\n------Unchecked handled------\n");
        try{
            uncheckedDivision(5, 0);
        }catch (Unchecked e){
            System.err.println(e.description);
        }

        System.err.println("\n------Unchecked unhandled------\n");
        uncheckedDivision(5, 0);
    }

    private static int uncheckedDivision(int arg1, int arg2){
        if (arg2 == 0) {
            throw new Unchecked();
        }
        int result = arg1 / arg2;
        return result;
    }
}
