package pageObjectHometask.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjectHometask.data.PageData;

import java.util.List;
import java.util.Optional;

public class DressPage {
    private WebDriver driver;
    private PageData pageData;

    public DressPage(WebDriver driver){
        this.driver = driver;
    }

    public void open(){
        driver.get(PageData.dressPageUrl);
    }

    @FindBy(xpath = "//li[contains(@class, 'ajax_block_product')]")
    List<WebElement> elementList;

    public boolean hasDressWithPrice(String dressToCheck, String price){
         return elementList.stream()
                    .filter(element -> element.getText().contains(dressToCheck) & element.getText().contains(price))
                    .findAny()
                    .isPresent();
    }
}
