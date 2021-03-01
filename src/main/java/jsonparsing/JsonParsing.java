package jsonparsing;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jsonparsing.dataclasses.Standing;

import java.io.File;
import java.util.List;

public class JsonParsing {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        File file = new File("standing.json");

        try {
            List<Standing> standingList = mapper.readValue(file, new TypeReference<List<Standing>>(){});
            System.out.println(standingList);

        }catch (Exception e){
            System.out.println("Oops, something went wrong" + e);
        }
    }
}
