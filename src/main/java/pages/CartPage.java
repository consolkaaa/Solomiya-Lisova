package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    WebElement checkoutButton;

    @FindBy(xpath = "//tr[contains(@class,'cart_item')]")
    List<WebElement> elementsInTheCart;

    private String findWayToDressBox(String uniqueDressName) {
        return "//a[contains(text(),\'" + uniqueDressName + "\')]/ancestor::div[@class = 'right-block']";
    }

    private String findWayToDress(String uniqueDressName) {
        return findWayToDressBox(uniqueDressName) + "/div[@class = 'button-container']/a[@title = 'Add to cart']";
    }

    public void addItemToCart(String uniqueDressName) throws Exception{
        //Driver clicks on the dressBox in order for the button to be visible
        driver.findElement(By.xpath(findWayToDressBox(uniqueDressName))).click();
        driver.findElement(By.xpath(findWayToDress(uniqueDressName))).click();
    }

    public void proceedToCheckout(){
        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
    }

    private WebElement findInTheCart(String uniqueDressName) throws Exception{
        return elementsInTheCart.stream()
                .filter(element -> element.getText().contains(uniqueDressName))
                .findAny()
                .orElseThrow();
    }

    public boolean checkIfAddedToCart(String uniqueDressName) throws Exception{
        WebElement dress = findInTheCart(uniqueDressName);
        return true;
    }
}
