package selenidetest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.*;
import selenide.HomePage;
import selenide.ProductPage;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertTrue;


public class SelenideTest {
    ProductPage productPage;

    @BeforeSuite
    public void setUp(){
        Configuration.driverManagerEnabled = true;
        Configuration.browser = "chrome";
    }

    @AfterSuite
    public void tearDown(){
        Selenide.closeWebDriver();
    }

    @BeforeClass
    public void openDressPageAndSelectDress(){
        HomePage homePage = new HomePage().openPage();
        homePage.searchFor("dress");

        productPage = homePage.clickOnDress("Blouse");
    }

    @Test
    public void verifyThatNameAndPriceAreCorrect(){
        assertTrue(productPage.isNameOfProductCorrect("Blouse")
                          & productPage.isPriceOfProductCorrect("$27.00"), "Name and price of the product are correct");
    }

    @Test
    public void addToCartButtonIsDisplayedTest(){
        assertTrue(productPage.isAddToCartButtonDisplayed(), "Add to cart button is displayed");
    }

    @Test
    public void quantityIsDisplayedTest(){
        assertTrue(productPage.isQuantityDisplayed(), "Quantity field is displayed");
    }

    @Test
    public void sizeIsDisplayedTest(){
        assertTrue(productPage.isSizeDisplayed(), "Size field is displayed");
    }



}
