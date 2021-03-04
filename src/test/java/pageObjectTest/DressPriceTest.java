package pageObjectTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjectHometask.pages.DressPage;

import static org.testng.Assert.assertTrue;

public class DressPriceTest {

    WebDriver driver;

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
    public void checkDressPriceTest(){
        DressPage dressPage = new DressPage(driver);
        dressPage.open();

        assertTrue(dressPage.hasDressWithPrice("Printed", "$50.99"), "A dress has specifies price");
    }
}
