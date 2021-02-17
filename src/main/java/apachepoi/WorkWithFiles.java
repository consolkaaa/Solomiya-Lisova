package apachepoi;

import com.github.javafaker.Faker;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
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

        Path csvPath = Paths.get(System.getProperty("user.home"), "IdeaProjects",
                "Solomiya-Lisova", "src", "main", "resources", "file.csv");

        Path xlsxPath = Paths.get(System.getProperty("user.home"), "IdeaProjects",
                "Solomiya-Lisova", "src", "main", "resources", "file.xlsx");

        File csv = new File(String.valueOf(csvPath));
        File xlsx = new File(String.valueOf(xlsxPath));

        BufferedWriter bufferedWriter;
        BufferedReader bufferedReader;
        FileOutputStream fos;
        String line;
        String[] values = new String[10];

        try {
            bufferedWriter = new BufferedWriter(new FileWriter(csv));
            bufferedWriter.write(convertedToCsv);
            bufferedWriter.close();

            bufferedReader = new BufferedReader(new FileReader(csv));
            while((line = bufferedReader.readLine()) != null){
                values = line.split(",");
            }

            xlsx.createNewFile();
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Names");

            int i = 0;
            while(i < values.length){
                Row row = sheet.createRow(i);
                Cell cell = row.createCell(0);
                cell.setCellValue(values[i]);
                i++;
            }

            fos = new FileOutputStream(xlsx);
            workbook.write(fos);
            fos.close();
            System.out.println(xlsx + " written successfully");

        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
