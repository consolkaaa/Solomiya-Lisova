package restassuredtest;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.sun.xml.bind.v2.runtime.reflect.opt.Const;
import io.restassured.module.jsv.JsonSchemaValidator;
import jsonparsing.dataclasses.Constructors;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class RestAssuredTest {
    private static final String URL = "http://ergast.com/api/f1/2010/constructors.json";

    @Test
    public void isNumberOfConstructorsInResponseCorrect(){
        List<Constructors> constructorsList = given().when().get(URL).then().statusCode(200).extract().body()
                .jsonPath().getList("MRData.ConstructorTable.Constructors", Constructors.class);
        Assert.assertEquals(constructorsList.size(), 12);
    }

    @Test
    public void doesCompaniesNamesMatchExpected(){
        List<String> expectedCompanies = new ArrayList(
                Arrays.asList("Ferrari", "Force India", "HRT", "Lotus", "McLaren", "Mercedes", "Red Bull", "Renault", "Sauber", "Toro Rosso", "Virgin", "Williams"));

        List<String> companies = given().when().get(URL).then().statusCode(200)
                .extract().path("MRData.ConstructorTable.Constructors.name");

        Assert.assertTrue(expectedCompanies.equals(companies));
    }

    @Test
    public void isMercedesInfoCorrect(){

        List<Constructors> constructorsList = given().when().get(URL).then().statusCode(200).extract().body().jsonPath()
                .getList("MRData.ConstructorTable.Constructors", Constructors.class);

        Constructors mercedes = constructorsList.stream().filter(el -> el.getName().equals("Mercedes")).findAny().orElseThrow();

        Assert.assertTrue(mercedes.getName().equals("Mercedes")
                & mercedes.getUrl().equals("http://en.wikipedia.org/wiki/Mercedes-Benz_in_Formula_One")
                & mercedes.getNationality().equals("German")
                & mercedes.getConstructorId().equals("mercedes"));

    }

    @Test
    public void isJsonSchemaCorrect() {

        given().when().get("http://ergast.com/api/f1/2010/constructors").then().assertThat()
                .body(matchesJsonSchemaInClasspath("./src/test/resources/schema.json"));

    }
}
