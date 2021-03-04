package pageObjectTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pageObjectHometask.data.PageData;
import pageObjectHometask.pages.HomePage;

import java.nio.file.Path;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TitleTest extends ParentTest{

    @Test
    public void titleTest(){
        HomePage homePage = new HomePage(driver);
        homePage.open();
        assertEquals(homePage.getTitle(), "My Store", "The title is 'My Store'");
    }

}




