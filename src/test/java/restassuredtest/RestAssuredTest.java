package restassuredtest;

import jsonparsing.dataclasses.Constructors;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class RestAssuredTest {
    private static final String URL = "http://ergast.com/api/f1/2010/constructors.json";

    @Test
    public void verifyThatNumberOfConstructorsISCorrect(){
        List<Constructors> constructorsList = given().when().get(URL).then().statusCode(200).extract().body()
                .jsonPath().getList("MRData.ConstructorTable.Constructors", Constructors.class);
        Assert.assertEquals(constructorsList.size(), 12, "The constructors number in response matches expected");
    }

    @Test
    public void verifyThatCompaniesNamesMatchExpected(){
        List<String> expectedCompanies = new ArrayList(
                Arrays.asList("Ferrari", "Force India", "HRT", "Lotus", "McLaren", "Mercedes", "Red Bull", "Renault", "Sauber", "Toro Rosso", "Virgin", "Williams"));

        List<String> companies = given().when().get(URL).then().statusCode(200)
                .extract().path("MRData.ConstructorTable.Constructors.name");

        Assert.assertTrue(companies.equals(expectedCompanies), "Companies mames match expected");
    }

    @Test
    public void verifyThatMercedesInfoIsCorrect(){

        List<Constructors> constructorsList = given().when().get(URL).then().statusCode(200).extract().body().jsonPath()
                .getList("MRData.ConstructorTable.Constructors", Constructors.class);

        Constructors mercedes = constructorsList.stream()
                .filter(el -> el.getName().equals("Mercedes"))
                .findAny().orElseThrow();

        Assert.assertTrue(mercedes.getName().equals("Mercedes")
                & mercedes.getUrl().equals("http://en.wikipedia.org/wiki/Mercedes-Benz_in_Formula_One")
                & mercedes.getNationality().equals("German")
                & mercedes.getConstructorId().equals("mercedes"), "Mercedes info is correct");

    }

    @Test
    public void verifyThatJsonSchemaIsCorrect(){

        given().get("http://ergast.com/api/f1/2010/constructors.json").then().assertThat()
                .body(matchesJsonSchemaInClasspath("schema.json"));

    }
}
