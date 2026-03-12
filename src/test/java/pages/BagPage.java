package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BagPage extends BasePage {

    public BagPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[contains(@class,'price')]")
    WebElement priceBefore;

    @FindBy(xpath = "//button[contains(text(),'Apply')]")
    WebElement applyCouponButton;

    @FindBy(xpath = "//span[contains(@class,'discounted-price')]")
    WebElement priceAfter;

    public int getPriceBeforeCoupon() {

        String price = priceBefore.getText().replaceAll("[^0-9]", "");
        return Integer.parseInt(price);
    }

    public void applyCoupon() {

        applyCouponButton.click();
    }

    public int getPriceAfterCoupon() {

        String price = priceAfter.getText().replaceAll("[^0-9]", "");
        return Integer.parseInt(price);
    }
}