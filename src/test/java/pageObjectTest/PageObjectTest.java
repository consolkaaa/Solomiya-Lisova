package pageObjectTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjectHometask.data.PageData;
import pageObjectHometask.pages.HomePage;

import java.nio.file.Path;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PageObjectTest {
    WebDriver driver;
    HomePage homePage;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void titleTest(){
        homePage = new HomePage(driver);
        homePage.open();
        assertTrue(homePage.checkTitle());
    }

}




