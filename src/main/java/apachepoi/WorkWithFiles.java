package apachepoi;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class WorkWithFiles {
    static List<Integer> csvData = new ArrayList<>();

    public static void main(String[] args) {
       // int n = ThreadLocalRandom.current().nextInt(1, 10);
        csvData = new Random().ints(10, 1, 1000).boxed().collect(Collectors.toList());
        csvData.stream().forEach(number -> System.out.print(number + " "));

        System.out.println();

        csvData.stream().map(number -> number.toString()).collect(Collectors.joining(","));
        System.out.println(csvData);


        File csvFile = new File("/src/main/java/resources/file.csv");

        WorkWithFiles work = new WorkWithFiles();
        work.newnew();

    }

    public void newnew(){
        Path source = Paths.get(this.getClass().getResource("/").getPath());
        Path newFolder = Paths.get(source.toAbsolutePath() + "/csv/");
        try {
            Files.createDirectories(newFolder);
        } catch (Exception e){

        }

    }
}
