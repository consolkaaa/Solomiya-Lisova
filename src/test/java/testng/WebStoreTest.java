package testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class WebStoreTest {
    WebDriver driver;

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
       assertTrue(driver.getTitle().equals("My Store"));
    }

    @Test(dependsOnMethods = "titleTest")
    public void checkPrice(){
        WebElement dress;

        List<WebElement> elementList = driver.findElements(By.xpath("//li[contains(@class, 'ajax_block_product')]"));
        dress = elementList.stream().filter(element -> element.getText().contains("Chiffon")).findAny().orElseThrow();

        assertTrue(dress.getText().contains("$16.40"));
    }

    @Test(dependsOnMethods = {"checkPrice","titleTest"})
    public void addToCartTest(){
        WebElement dressBox, addToCart, checkout, dress;

        dressBox = driver.findElement(By.xpath("//a[contains(text(), 'Chiffon')]/ancestor::div[@class = 'right-block']"));
        dressBox.click();

        addToCart = driver.findElement(By.xpath("//a[@title = 'Add to cart' and @data-id-product = '7']"));
        addToCart.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        checkout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Proceed to checkout']")));
        checkout.click();

        List<WebElement> elementList = driver.findElements(By.xpath("//tr[contains(@class,'cart_item')]"));
        dress = elementList.stream().filter(element -> element.getText().contains("Chiffon")).findAny().orElseThrow();

        assert dress != null;
    }

}
