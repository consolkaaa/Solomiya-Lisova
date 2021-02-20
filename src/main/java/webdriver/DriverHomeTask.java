package webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.jsoup.nodes.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.*;

import java.util.List;

public class DriverHomeTask {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement searchInput, searchButton, addToCart, dressBox, checkout;

        driver.get("http://automationpractice.com/index.php");

        searchInput = driver.findElement(By.id("search_query_top"));
        searchInput.sendKeys("dress");

        searchButton = driver.findElement(By.name("submit_search"));
        searchButton.click();

        //Driver finds the dressBox element so that "Add to cart" button is visible and clickable
        dressBox = driver.findElement(By.xpath("//a[contains(text(), 'Faded')]/ancestor::div[@class = 'right-block']"));
        dressBox.click();

        addToCart = driver.findElement(By.xpath("//a[@title = 'Add to cart' and @data-id-product = '1']"));
        addToCart.click();

        checkout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Proceed to checkout']")));
        checkout.click();

        driver.quit();
    }
}
