package pageObjectTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjectHometask.data.PageData;
import pageObjectHometask.pages.LogInPage;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LogInTest {
    WebDriver driver;
    PageData pageData;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        pageData = new PageData();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void logInTest(){
        LogInPage logInPage = new LogInPage(driver);
        logInPage.open();

        logInPage.logIn("o19lisova@gmail.com", "lalala111");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertEquals(driver.getCurrentUrl(), PageData.myAccountUrl);
    }

}
