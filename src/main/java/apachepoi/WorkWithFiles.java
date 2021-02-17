package apachepoi;

import com.github.javafaker.Faker;
import com.opencsv.CSVParser;
import com.opencsv.CSVReader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class WorkWithFiles {
    static List<String> csvData = new ArrayList<>();
    static String convertedToCsv = "";

    public static List<String> initialize(List<String> dataList){
        Faker faker = new Faker();
        for (int i = 0; i < 10; i++){
            dataList.add(faker.name().firstName());
        }
        return dataList;
    }

    public static String dataToCsvType (List<String> dataList){
        return (String) dataList.stream().collect(Collectors.joining(","));
    }

    public static void main(String[] args) {
        csvData = initialize(csvData);
        convertedToCsv = dataToCsvType(csvData);

        System.out.println(convertedToCsv);

        Path csvPath = Paths.get(System.getProperty("user.home"), "IdeaProjects",
                "Solomiya-Lisova", "src", "main", "resources", "file.csv");

        Path xlsxPath = Paths.get(System.getProperty("user.home"), "IdeaProjects",
                "Solomiya-Lisova", "src", "main", "resources", "file.xlsx");

        File xlsx = new File(String.valueOf(xlsxPath));

        BufferedWriter bufferedWriter;
        FileInputStream fis;

        try {
            bufferedWriter = new BufferedWriter(new FileWriter(String.valueOf(csvPath)));
            bufferedWriter.write(convertedToCsv);
            bufferedWriter.close();

//            xlsx.createNewFile();
//            fis = new FileInputStream(xlsx);
//            Workbook workbook = new XSSFWorkbook(fis);


        }catch (IOException ex){
            ex.printStackTrace();
        }



    }

}
