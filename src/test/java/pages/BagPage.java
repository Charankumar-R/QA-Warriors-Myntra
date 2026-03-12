package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BagPage extends BasePage {

    public BagPage(WebDriver driver) {
        super(driver);
    }

    // price before coupon
    @FindBy(xpath = "//span[contains(@class,'price')]")
    WebElement priceBefore;

    // APPLY coupon button
    @FindBy(xpath = "//div[text()='APPLY']/parent::button")
    WebElement applyCouponButton;

    // discounted price
    @FindBy(xpath = "//span[contains(@class,'discount')]")
    WebElement priceAfter;

    public int getPriceBeforeCoupon() {

        String price = priceBefore.getText().replaceAll("[^0-9]", "");
        return Integer.parseInt(price);
    }

    public void applyCoupon() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(applyCouponButton));
        applyCouponButton.click();
    }

    public int getPriceAfterCoupon() {

        String price = priceAfter.getText().replaceAll("[^0-9]", "");
        return Integer.parseInt(price);
    }
}