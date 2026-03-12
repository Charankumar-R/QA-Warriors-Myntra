package tests;

import base.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductsPage;
import pages.ProductPage;

@Feature("Negative Test Cases")
public class AddToBagWithoutSizeTest extends BaseTest {

    @Test
    @Story("Add product to bag without selecting size")
    @Description("Verify that the product cannot be added to the bag when size is not selected")
    public void addToBagWithoutSelectingSizeTest() {

        HomePage homePage = new HomePage(driver);

        Allure.step("Search for product: Men T-shirt");
        homePage.searchProduct("Men T-shirt");

        ProductsPage productsPage = new ProductsPage(driver);

        Allure.step("Select first product from search results");
        productsPage.selectFirstProduct();

        ProductPage productPage = new ProductPage(driver);

        Allure.step("Click Add To Bag without selecting size");
        productPage.clickAddToBagWithoutSize();

        Allure.step("Capture error message for size selection");

        String errorMessage = productPage.getSizeErrorMessage();

        System.out.println("Error Message: " + errorMessage);

        Allure.step("Validate error message displayed for missing size");

        Assert.assertTrue(
                errorMessage.toLowerCase().contains("select"),
                "Expected size selection error not displayed. Actual message: " + errorMessage
        );
    }
}