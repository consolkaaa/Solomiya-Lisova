package pageObjectTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjectHometask.pages.DressPage;

import static org.testng.Assert.assertTrue;

public class DressPriceTest extends ParentTest{

    @Test
    public void checkDressPriceTest(){
        DressPage dressPage = new DressPage(driver);
        dressPage.open();

        assertTrue(dressPage.hasDressWithPrice("Printed Dress", "$50.99"), "A dress has specified price");
    }
}
