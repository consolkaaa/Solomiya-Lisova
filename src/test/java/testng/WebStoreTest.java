package testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class WebStoreTest {
    WebDriver driver;

    String uniqueDressName = "Chiffon";
    String price = "$16.40";

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }

    @Test
    public void titleTest(){
        assertEquals(driver.getTitle(), "My Store");
    }

    @Test(dependsOnMethods = "titleTest")
    public void checkPrice(){
        WebElement dress;

        searchFor("dress");

        List<WebElement> elementList = driver.findElements(By.xpath("//li[contains(@class, 'ajax_block_product')]"));

        try {
            dress = elementList.stream()
                    .filter(element -> element.getText().contains(uniqueDressName))
                    .findAny()
                    .orElseThrow();
            assertTrue(dress.getText().contains(price));
        }catch (Exception e){
            assert false;
        }
    }

    private void searchFor(String word){
        WebElement searchInput = driver.findElement(By.id("search_query_top"));
        searchInput.sendKeys(word);
        searchInput.sendKeys(Keys.ENTER);
    }

    @Test(dependsOnMethods = {"checkPrice","titleTest"})
    public void addToCartTest(){
        WebElement dressBox, addToCart, checkout, dress;

        try {
            addItemToCart(uniqueDressName);

            List<WebElement> elementList = driver.findElements(By.xpath("//tr[contains(@class,'cart_item')]"));
            dress = elementList.stream()
                    .filter(element -> element.getText().contains(uniqueDressName))
                    .findAny()
                    .orElseThrow();

            assert dress != null & driver.getTitle().equals("Order - My Store");

        }catch (Exception e){
            assert false;
        }
    }

    private void addItemToCart(String uniqueDressName) throws Exception{
        WebElement dressBox, addToCart, checkout;
        String wayToDressBox = "//a[contains(text(),\'" + uniqueDressName + "\')]/ancestor::div[@class = 'right-block']";
        dressBox = driver.findElement(By.xpath(wayToDressBox));
        dressBox.click();

        addToCart = driver.findElement(By.xpath(wayToDressBox + "/div[@class = 'button-container']/a[@title = 'Add to cart']"));
        addToCart.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        checkout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Proceed to checkout']")));
        checkout.click();

    }
}
