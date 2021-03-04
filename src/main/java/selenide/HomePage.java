package selenide;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class HomePage {

    private SelenideElement searchInput = $("#search_query_top");

    public HomePage openPage(){
        open("http://automationpractice.com/index.php");
        return this;
    }

    public void searchFor(String string){
        searchInput.setValue("dress").pressEnter();
    }

    public ProductPage clickOnDress(String name){
        $(By.xpath("//a[@class = 'product-name' and @title='" + name + "']")).click();
        return new ProductPage();
    }
}
