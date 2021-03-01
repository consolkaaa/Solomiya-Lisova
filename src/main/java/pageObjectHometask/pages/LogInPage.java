package pageObjectHometask.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjectHometask.data.PageData;

import java.util.concurrent.TimeUnit;

public class LogInPage {
    private WebDriver driver;

    public LogInPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    private WebElement emailAdressInput;

    @FindBy(id = "passwd")
    private WebElement passwordInput;

    public void open(){
        driver.get(PageData.logInPageUrl);
    }

    public void logIn(String email, String password){

        emailAdressInput.sendKeys(email);
        emailAdressInput.sendKeys(Keys.ENTER);

        passwordInput.sendKeys(password);
        passwordInput.sendKeys(Keys.ENTER);
    }

}
