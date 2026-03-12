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


    // quantity dropdown
    @FindBy(xpath = "//div[contains(@class,'itemComponents-base-quantity')]")
    WebElement quantityDropdown;

    // quantity option 10
    @FindBy(xpath = "//li[text()='2']")
    WebElement quantity10;

    public void selectMaxQuantity() {

        quantityDropdown.click();
        quantity10.click();
    }

    public int getSelectedQuantity() {

        String qty = quantityDropdown.getText();
        return Integer.parseInt(qty);
    }
    public void enterInvalidCoupon(String coupon) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(couponInputField));

        couponInputField.clear();
        couponInputField.sendKeys(coupon);
    }

    public void applyTypedCoupon() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(applyTypedCouponButton));

        applyTypedCouponButton.click();
    }

    public String getInvalidCouponMessage() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(invalidCouponMessage));

        return invalidCouponMessage.getText();
    }

    @FindBy(xpath = "//div[@data-method='couponInputApply']")
    WebElement checkButton;

    public void clickCheckButton() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(checkButton));
        checkButton.click();
    }
}