package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DressPage;
import pages.HomePage;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PageObjectTest {
    WebDriver driver;
    HomePage homePage;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        homePage.open();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void titleTest(){
        assertEquals(driver.getTitle(), "My Store");
    }

    @Test
    public void priceTest(){

        homePage.searchFor("dress");

        DressPage dressPage = new DressPage(driver);

        try {
            assertTrue(dressPage.checkPrice("Chiffon", "$16.40"));
        }catch (Exception e){
            assert false;
        }
    }

    @Test
    public void addToCartTest(){


    }
}




