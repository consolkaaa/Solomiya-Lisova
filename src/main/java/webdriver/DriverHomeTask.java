package webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DriverHomeTask {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebElement searchInput, searchButton, dress;

        driver.get("http://automationpractice.com/index.php");
        searchInput = driver.findElement(By.id("search_query_top"));
        searchInput.sendKeys("dress");

        searchButton = driver.findElement(By.name("submit_search"));
        searchButton.click();

        driver.quit();

    }
}
