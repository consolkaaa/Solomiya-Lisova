package pageObjectHometask.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjectHometask.data.PageData;

import java.util.List;

public class DressPage {
    private WebDriver driver;
    private PageData pageData;

    public DressPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        pageData = new PageData();
    }

    public void open(){
        driver.get(PageData.dressPageUrl);
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
