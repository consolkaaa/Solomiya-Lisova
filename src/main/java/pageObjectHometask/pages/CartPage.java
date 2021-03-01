package pageObjectHometask.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjectHometask.data.PageData;

import java.util.List;
import java.util.Optional;

public class CartPage {
    WebDriver driver;
    PageData pageData;

    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        pageData = new PageData();
    }

    public void open(){
        driver.get(PageData.cartUrl);
    }

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    private WebElement checkoutButton;

    @FindBy(xpath = "//tr[contains(@class,'cart_item')]")
    private List<WebElement> elementsInTheCart;

    private String getWayToDressBox(String id) {
        return "//a[@data-id-product = \'" + id + "\']/ancestor::div[@class = 'right-block']";
    }

    private String getWayToDress(String id) {
        return "//a[@data-id-product = \'" + id + "\' and @title = 'Add to cart']";
    }

    public void addItemToCart(String id) {
        //Driver clicks on the dressBox in order for the button to be visible

        driver.findElement(By.xpath(getWayToDressBox(id))).click();
        driver.findElement(By.xpath(getWayToDress(id))).click();
    }

    public void proceedToCheckout(){
        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
    }

    private Optional findInTheCart(String dressName) {
        return elementsInTheCart.stream()
                .filter(element -> element.getText().contains(dressName))
                .findAny();
    }

    public boolean isAddedToCart(String dressName) {
        return findInTheCart(dressName).isPresent();
    }

}
