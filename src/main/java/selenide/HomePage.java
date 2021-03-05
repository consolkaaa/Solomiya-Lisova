package selenide;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import javax.net.ssl.HostnameVerifier;

public class HomePage {

    public HomePage openPage(){
        open("http://automationpractice.com/index.php");
        return this;
    }

    public HomePage searchFor(String value){
        $("#search_query_top").setValue(value).pressEnter();
        return this;
    }

    public HomePage clickOnDress(String name){
        $(By.xpath("//a[@class = 'product-name' and @title='" + name + "']")).click();
        return this;
    }

    public boolean isAddToCartButtonDisplayed(){
        return $("#add_to_cart").isDisplayed();
    }

    public boolean isNameOfProductCorrect(String expectedName){
        return  $x("//h1[@itemprop='name']").getText().equals(expectedName);
    }

    public boolean isPriceOfProductCorrect(String expectedPrice){
        return $("#our_price_display").getText().equals(expectedPrice);
    }

    public boolean isQuantityDisplayed() {
        return $("#quantity_wanted_p").isDisplayed();
    }

    public boolean isSizeDisplayed() {
        return $x("//select[@id='group_1']").exists();
    }
}
