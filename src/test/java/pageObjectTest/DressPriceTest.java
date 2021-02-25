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

    //@Test(dependsOnGroups = "PageObjectTest.titleTest")
    @Test
    public void checkDressPriceTest(){

        DressPage dressPage = new DressPage(driver);
        dressPage.open();

        try {
            assertTrue(dressPage.checkPrice("Chiffon", "$16.40"));
        }catch (Exception e){
            assert false;
        }
    }
}
