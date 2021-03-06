package jsonparsing;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jsonparsing.dataclasses.Standing;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonParsing {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        File file = new File("standing.json");

        List<Standing> standingList = mapper.readValue(file, new TypeReference<List<Standing>>(){});
        System.out.println(standingList);

    }
}
