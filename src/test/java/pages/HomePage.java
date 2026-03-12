package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends pages.BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@placeholder='Search for products, brands and more']")
    WebElement searchBox;

    public void searchProduct(String product) {

        searchBox.sendKeys(product);
        searchBox.submit();
    }
}