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
    static BufferedWriter bufferedWriter;
    static BufferedReader bufferedReader;

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

    public static void writeToCsv(String data, File file) throws IOException {
        bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write(data);
        bufferedWriter.close();
    }

    public static List<String> readFromCsv(File file) throws IOException {
        String line;
        List<String> valuesList = new ArrayList<>();
        bufferedReader = new BufferedReader(new FileReader(file));
        while((line = bufferedReader.readLine()) != null){
            valuesList = Arrays.asList(line.split(","));
        }
        return valuesList;
    }

    public static void writeCsvToXlsx(File csv, File xlsx) throws IOException {
        List <String> valuesList= new ArrayList<>();
        valuesList = readFromCsv(csv);

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Names");

        int i = 0;
        while(i < valuesList.size()){
            Row row = sheet.createRow(i);
            Cell cell = row.createCell(0);
            cell.setCellValue(valuesList.get(i));
            i++;
        }

        FileOutputStream fos = new FileOutputStream(xlsx);
        workbook.write(fos);
        fos.close();
        System.out.println(xlsx + " written successfully");
    }

    public static void main(String[] args) {

        Path csvPath = Paths.get(System.getProperty("user.home"), "IdeaProjects",
                "Solomiya-Lisova", "src", "main", "resources", "file.csv");

        Path xlsxPath = Paths.get(System.getProperty("user.home"), "IdeaProjects",
                "Solomiya-Lisova", "src", "main", "resources", "file.xlsx");

        File csv = new File(String.valueOf(csvPath));
        File xlsx = new File(String.valueOf(xlsxPath));

        csvData = initialize(csvData);            //creating list of random names
        convertedToCsv = dataToCsvType(csvData);  //converting list to csv string type

        try {
            writeToCsv(convertedToCsv, csv);      // writing data to csv
            writeCsvToXlsx(csv, xlsx);            // writing from csv to xlsx

        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
