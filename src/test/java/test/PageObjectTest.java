package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.DressPage;
import pages.HomePage;

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
        assertEquals(driver.getTitle(), "My Store");
    }

    @Test(dependsOnMethods = "titleTest")
    public void priceTest(){

        DressPage dressPage = new DressPage(driver);
        dressPage.open();

        try {
            assertTrue(dressPage.checkPrice("Chiffon", "$16.40"));
        }catch (Exception e){
            assert false;
        }
    }

    @Test(dependsOnMethods = {"priceTest", "titleTest"})
    public void addToCartTest(){
        CartPage cart = new CartPage(driver);

        try {
            cart.addItemToCart("Chiffon");
            cart.proceedToCheckout();
            assertTrue(cart.checkIfAddedToCart("Chiffon"));
        }catch (Exception e){
            assert false;
        }
    }
}




