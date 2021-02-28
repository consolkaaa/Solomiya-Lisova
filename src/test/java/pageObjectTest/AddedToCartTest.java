package pageObjectTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjectHometask.pages.CartPage;
import pageObjectHometask.pages.DressPage;

import static org.testng.Assert.assertTrue;

public class AddedToCartTest {
    WebDriver driver;
    CartPage cart;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        cart = new CartPage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void addItemToCartAndCheckIfAddedTest(){
        DressPage dressPage = new DressPage(driver);
        dressPage.open();

        cart.addItemToCart("7");
        cart.proceedToCheckout();
        assertTrue(cart.isAddedToCart("Chiffon"));

    }
}
