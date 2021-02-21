package testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;

public class WebStoreTest {
    WebDriver driver;

    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
    }

    @AfterTest
    public void teardown(){
        driver.quit();
    }

    @Test
    public void titleTest(){
       assertTrue(driver.getTitle().equals("My Store"));
    }

    @Test
    public void addToCartTest(){
        WebElement searchInput, searchButton;

        searchInput = driver.findElement(By.id("search_query_top"));
        searchInput.sendKeys("dress");

        searchButton = driver.findElement(By.name("submit_search"));
        searchButton.click();

        //assertTrue();
    }


}
