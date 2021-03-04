package selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProductPage {

    public boolean isAddToCartButtonDisplayed(){
        return $("#add_to_cart").isDisplayed();
    }

    public boolean isNameOfProductCorrect(String expectedName){
       return $x("//h1[contains(text(), '" + expectedName + "')]").isDisplayed();
    }

    public boolean isPriceOfProductCorrect(String price){
        return $("#our_price_display").getText().equals(price);
    }

    public boolean isQuantityDisplayed() {
        return $("#quantity_wanted_p").isDisplayed();
    }

    public boolean isSizeDisplayed() {
        return $x("//select[@id='group_1']").isDisplayed();
    }
}
