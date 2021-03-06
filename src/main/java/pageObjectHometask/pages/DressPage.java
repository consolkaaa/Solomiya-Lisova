package pageObjectHometask.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjectHometask.data.PageData;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class DressPage {
    private WebDriver driver;
    private PageData pageData;
    private List<WebElement> elementList;

    public DressPage(WebDriver driver){
        this.driver = driver;
        elementList = driver.findElements(By.xpath("//div[@class='product-container']"));
    }

    public void open(){
        driver.get(PageData.dressPageUrl);
    }

    public boolean hasDressWithPrice(String dressToCheck, String price){
         return elementList.stream()
                    .filter(element -> element.getText().contains(dressToCheck) & element.getText().contains(price))
                    .findAny()
                    .isPresent();
    }
}
