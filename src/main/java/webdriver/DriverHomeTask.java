package webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DriverHomeTask {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement searchInput, searchButton, dress, checkout;

        driver.get("http://automationpractice.com/index.php");
        searchInput = driver.findElement(By.id("search_query_top"));
        searchInput.sendKeys("dress");

        searchButton = driver.findElement(By.name("submit_search"));
        searchButton.click();

        dress = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Faded')]" +
                "/ancestor::div[@class = 'right-block']/div[@class = 'button-container']")));
        dress.click();

        checkout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Proceed to checkout']")));
        checkout.click();

        driver.quit();
    }
}
