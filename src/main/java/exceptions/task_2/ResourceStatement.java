package exceptions.task_2;

import java.io.File;

public class ResourceStatement {
    public static void main(String[] args) {
        System.err.println("\n------Try-with-resource statement------\n");

        File file = new File("file.txt");

        try(MyFileReader fileReader = new MyFileReader(file)){
            fileReader.readFile();
        } catch (Exception e){
            System.err.println("File doesn't exist");
        }
    }
}
