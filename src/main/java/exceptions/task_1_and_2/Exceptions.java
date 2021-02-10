package exceptions.task_1_and_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Exceptions {
    public static void main(String[] args){

        //Task 1
        checked();
        unchecked();

        //Task 2
        resorceStatement();

    }

    private static void checked(){
        System.err.println("\n------Checked------\n");

        File file = new File("newfile.txt");
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                System.out.println(line);
            }
        }catch (FileNotFoundException fileExc){
            System.err.println("File name is incorrect\n");
            //fileExc.printStackTrace();
        }
        finally {
            if(scanner!=null) {
                scanner.close();
            }
        }
    }

    private static void unchecked(){
        System.err.println("\n------Unchecked------\n");

        int[] array = {0, 1, 2, 3};

        try{
            for (int i = 0; i <= array.length; i++) {
                System.out.print(array[i] + " ");
            }
        }catch (ArrayIndexOutOfBoundsException ae){
            System.err.println("\nArray index is out of boundaries.\n");
            //ae.printStackTrace();
        }
    }

    public static void resorceStatement(){
        System.err.println("\n------Try-with-resource statement------\n");

        File file = new File("newfile.txt");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (Exception e){
            System.err.println("File not found\n");
            //e.printStackTrace();
        }
    }
}
