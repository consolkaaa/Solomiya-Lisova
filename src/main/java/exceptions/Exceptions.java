package exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Exceptions {
    public static void main(String[] args){

        unchecked();
        checked();

    }

    private static void unchecked(){
        int[] array = {0, 1, 2, 3};

        try{
            for (int i = 0; i <= array.length; i++) {
                System.out.println(array[i]);
            }
        }catch (ArrayIndexOutOfBoundsException ae){
            System.out.println("Array index is out of boundaries.");
            ae.printStackTrace();
        }
    }

    private static void checked(){
        File file = new File("newfile.txt");

        try {
            Scanner scanner = new Scanner(file);
        }catch (FileNotFoundException fileExc){
            System.out.println("File name is incorrect");
            fileExc.printStackTrace();
        }
    }
}
