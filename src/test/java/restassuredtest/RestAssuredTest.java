package restassuredtest;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import jsonparsing.dataclasses.Constructors;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
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
    private ValidatableResponse response;

    @BeforeClass
    public void beforeResponse(){
        response = given().when().get(URL).then();
    }

    @Test
    public void verifyThatNumberOfConstructorsISCorrect(){
        List<Constructors> constructorsList = response.statusCode(200).extract().body()
                .jsonPath().getList("MRData.ConstructorTable.Constructors", Constructors.class);
        Assert.assertEquals(constructorsList.size(), 12, "The constructors number in response matches expected");
    }

    @Test
    public void verifyThatCompaniesNamesMatchExpected(){
        List<String> expectedCompanies = new ArrayList(
                Arrays.asList("Ferrari", "Force India", "HRT", "Lotus", "McLaren", "Mercedes", "Red Bull", "Renault", "Sauber", "Toro Rosso", "Virgin", "Williams"));

        List<String> companies = response.statusCode(200)
                .extract().path("MRData.ConstructorTable.Constructors.name");

        Assert.assertTrue(companies.equals(expectedCompanies), "Companies mames match expected");
    }

    @Test
    public void verifyThatMercedesInfoIsCorrect(){

        List<Constructors> constructorsList = response.statusCode(200).extract().body().jsonPath()
                .getList("MRData.ConstructorTable.Constructors", Constructors.class);

        Constructors mercedes = constructorsList.stream()
                .filter(el -> el.getName().equals("Mercedes"))
                .findAny().orElseThrow();

        Constructors expected = new Constructors();
        expected.setName("Mercedes");
        expected.setUrl("http://en.wikipedia.org/wiki/Mercedes-Benz_in_Formula_One");
        expected.setNationality("German");
        expected.setConstructorId("mercedes");

        Assert.assertTrue(mercedes.equals(expected), "Mercedes info is correct");

    }

    @Test
    public void verifyThatJsonSchemaIsCorrect(){
        response.assertThat().body(matchesJsonSchemaInClasspath("schema.json"));
    }
}
