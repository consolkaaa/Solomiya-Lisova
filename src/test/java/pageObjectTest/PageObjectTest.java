package pageObjectTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjectHometask.CartPage;
import pageObjectHometask.DressPage;
import pageObjectHometask.HomePage;

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

//    @Test(dependsOnMethods = "titleTest")
//    public void checkDressPriceTest(){
//
//        DressPage dressPage = new DressPage(driver);
//        dressPage.open();
//
//        try {
//            assertTrue(dressPage.checkPrice("Chiffon", "$16.40"));
//        }catch (Exception e){
//            assert false;
//        }
//    }

//    @Test(dependsOnMethods = {"priceTest", "titleTest"})
//    public void addToCartTest(){
//        CartPage cart = new CartPage(driver);
//
//        try {
//            cart.addItemToCart("7");
//            cart.proceedToCheckout();
//            assertTrue(cart.checkIfAddedToCart("Chiffon"));
//
//        }catch (Exception e){
//            assert false;
//        }
//    }
}




