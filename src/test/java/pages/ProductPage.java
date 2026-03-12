package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//p[text()='S']")
    WebElement sizeOption;

    @FindBy(xpath = "//div[text()='ADD TO BAG']")
    WebElement addToBagButton;

    @FindBy(xpath = "//span[text()='Bag']")
    WebElement bagButton;

    @FindBy(xpath = "//span[contains(text(),'select')]")
    WebElement sizeErrorMessage;

    public void selectSize() {

        wait.until(ExpectedConditions.elementToBeClickable(sizeOption));
        sizeOption.click();
    }

    public void addToBag() {

        wait.until(ExpectedConditions.elementToBeClickable(addToBagButton));
        addToBagButton.click();
    }

    public void openBag() {

        wait.until(ExpectedConditions.elementToBeClickable(bagButton));
        bagButton.click();
    }
        public void clickAddToBagWithoutSize() {

        addToBagButton.click();
    }

    public String getSizeErrorMessage() {

        return sizeErrorMessage.getText();
    }
}