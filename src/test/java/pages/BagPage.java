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

    // Qty button (opens quantity list)
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]/div[2]")
    WebElement quantityButton;


    @FindBy(xpath="//div[contains(@class,'dialogs-base-display') and text()='10']")
    WebElement qtyTen;

    // DONE button
    @FindBy(xpath="//div[normalize-space()='DONE']")
    WebElement doneButton;

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

    public void selectMaxQuantity() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open quantity popup
        wait.until(ExpectedConditions.elementToBeClickable(quantityButton));
        quantityButton.click();

        // click quantity 10
        wait.until(ExpectedConditions.elementToBeClickable(qtyTen)).click();

        // click DONE
        wait.until(ExpectedConditions.elementToBeClickable(doneButton)).click();

    }
}