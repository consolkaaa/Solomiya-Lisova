package jsonparsing;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import jsonparsing.dataclasses.Driver;
import jsonparsing.dataclasses.Standing;

import java.io.File;
import java.util.List;


public class JsonParsing {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        File file = new File("standing.json");

        try {

//            Standing standing = mapper.readValue(file, Standing.class);
//            System.out.println(standing);


            List<Standing> standingList = mapper.readValue(file, new TypeReference<List<Standing>>(){});
            //standingList.stream().forEach(el -> System.out.println(el));
            System.out.println(standingList);


        }catch (Exception e){
           e.printStackTrace();
        }

    }






}
