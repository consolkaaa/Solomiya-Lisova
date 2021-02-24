package pageObjectHometask;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DressPage {
    private WebDriver driver;

    public DressPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open(){
        driver.get("http://automationpractice.com/index.php?id_category=8&controller=category");
    }

    @FindBy(xpath = "//li[contains(@class, 'ajax_block_product')]")
    List<WebElement> elementList;

    public boolean checkPrice(String dressToCheck, String price) throws Exception{
        try {
            elementList.stream()
                    .filter(element -> element.getText().contains(dressToCheck) & element.getText().contains(price))
                    .findAny()
                    .orElseThrow();
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
