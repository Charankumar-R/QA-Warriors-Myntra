package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//li[contains(@class,'product-base')])[1]")
    WebElement firstProduct;

    public void selectFirstProduct() {

        firstProduct.click();
        for (String tab : driver.getWindowHandles()) {
        driver.switchTo().window(tab);
    }
    }
}