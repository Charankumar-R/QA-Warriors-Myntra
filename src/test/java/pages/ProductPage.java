package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//p[text()='M']")
    WebElement sizeOption;

    @FindBy(xpath = "//div[text()='ADD TO BAG']")
    WebElement addToBagButton;

    @FindBy(xpath = "//span[text()='Bag']")
    WebElement bagButton;

    public void selectSize() {

        sizeOption.click();
    }

    public void addToBag() {

        addToBagButton.click();
    }

    public void openBag() {

        bagButton.click();
    }
}