package pageObjectTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjectHometask.CartPage;
import pageObjectHometask.HomePage;

import static org.testng.Assert.assertTrue;

public class AddedToCartTest {

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

   // @Test(dependsOnMethods = {"priceTest", "titleTest"})
    @Test
    public void addToCartTest(){
        CartPage cart = new CartPage(driver);

        try {
            cart.addItemToCart("7");
            cart.proceedToCheckout();
            assertTrue(cart.checkIfAddedToCart("Chiffon"));

        }catch (Exception e){
            assert false;
        }
    }
}
