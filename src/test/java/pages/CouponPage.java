package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

public class CouponPage {

    WebDriver driver;

    public CouponPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locator for error message
    @FindBy(xpath="//div[@class='couponsForm-base-errorMessage']")
    WebElement couponErrorMessage;

    // Method to get error message
    public String getCouponErrorMessage() {
        return couponErrorMessage.getText();
    }
}