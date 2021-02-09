package exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Exceptions {
    public static void main(String[] args){

        checked();
        unchecked();

        resorceStatement();

    }

    private static void unchecked(){
        int[] array = {0, 1, 2, 3};

        try{
            for (int i = 0; i <= array.length; i++) {
                System.out.print(array[i] + " ");
            }
        }catch (ArrayIndexOutOfBoundsException ae){
            System.out.println("\nArray index is out of boundaries.");
            ae.printStackTrace();
        }
    }

    private static void checked(){
        File file = new File("newfile.txt");
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
        }catch (FileNotFoundException fileExc){
            System.out.println("File name is incorrect\n");
            fileExc.printStackTrace();
        }
        finally {
            if(scanner!=null) {
                scanner.close();
            }
        }
    }

    public static void resorceStatement(){
        File file = new File("newfile.txt");

        try(Scanner scanner = new Scanner(file)){

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
