package selenidetest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.*;
import selenide.HomePage;

import static org.testng.Assert.assertTrue;


public class SelenideTest {
    HomePage homePage;
    private static final String EXPECTED_NAME = "Blouse";
    private static final String EXPECTED_PRICE = "$27.00";
    private static final String CATEGORY = "dress";
    private static final String NAME = EXPECTED_NAME;

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
        homePage = new HomePage()
                .openPage()
                .searchFor(CATEGORY)
                .clickOnDress(NAME);
    }

    @Test
    public void verifyThatNameAndPriceAreCorrect(){
        assertTrue(homePage.isNameOfProductCorrect(EXPECTED_NAME)
                          & homePage.isPriceOfProductCorrect(EXPECTED_PRICE),
                   "Name and price of the product are correct");
    }

    @Test
    public void addToCartButtonIsDisplayedTest(){
        assertTrue(homePage.isAddToCartButtonDisplayed(), "Add to cart button is displayed");
    }

    @Test
    public void quantityIsDisplayedTest(){
        assertTrue(homePage.isQuantityDisplayed(), "Quantity field is displayed");
    }

    @Test
    public void sizeIsDisplayedTest(){
        assertTrue(homePage.isSizeDisplayed(), "Size field is displayed");
    }

}
