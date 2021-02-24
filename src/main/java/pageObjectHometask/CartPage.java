package pageObjectHometask;

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
    private WebElement checkoutButton;

    @FindBy(xpath = "//tr[contains(@class,'cart_item')]")
    private List<WebElement> elementsInTheCart;

    private String findWayToDressBox(String id) {
        return "//a[@data-id-product = \'" + id + "\']/ancestor::div[@class = 'right-block']";
    }

    private String findWayToDress(String id) {
        return "//a[@data-id-product = \'" + id + "\' and @title = 'Add to cart']";
    }

    public void addItemToCart(String id) throws Exception{
        //Driver clicks on the dressBox in order for the button to be visible
        driver.findElement(By.xpath(findWayToDressBox(id))).click();
        driver.findElement(By.xpath(findWayToDress(id))).click();
    }

    public void proceedToCheckout(){
        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
    }

    private WebElement findInTheCart(String dressName) throws Exception{
        return elementsInTheCart.stream()
                .filter(element -> element.getText().contains(dressName))
                .findAny()
                .orElseThrow();
    }

    public boolean checkIfAddedToCart(String dressName) throws Exception{
        WebElement dress = findInTheCart(dressName);
        return true;
    }

}
