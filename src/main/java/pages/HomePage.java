package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "search_query_top")
    private WebElement searchInput;

    public void open(){
        driver.get("http://automationpractice.com/index.php");
    }

    public boolean checkTitle(){
        if (driver.getTitle().equals("My Store")){
            return true;
        }
        return false;
    }

    public void searchFor(String word){
        searchInput.sendKeys(word);
        searchInput.sendKeys(Keys.ENTER);
    }
}
