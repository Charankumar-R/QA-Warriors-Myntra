package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//li[contains(@class,'product-base')])[1]")
    WebElement firstProduct;

    public void selectFirstProduct() {

        wait.until(ExpectedConditions.elementToBeClickable(firstProduct));
        firstProduct.click();
        for (String tab : driver.getWindowHandles()) {
        driver.switchTo().window(tab);
    }
    }
}