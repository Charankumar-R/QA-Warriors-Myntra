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
import pages.BagPage;

@Feature("Quantity Validation")
public class DynamicQtyLimitTest extends BaseTest {

    @Test
    @Story("Validate maximum quantity selection")
    @Description("Verify that user can select maximum quantity available for a product")
    public void dynamicQtyLimit() {

        HomePage homePage = new HomePage(driver);

        Allure.step("Search product: Men T-shirt");
        homePage.searchProduct("Men T-shirt");

        ProductsPage productsPage = new ProductsPage(driver);

        Allure.step("Select first product from results");
        productsPage.selectFirstProduct();

        ProductPage productPage = new ProductPage(driver);

        Allure.step("Select product size");
        productPage.selectSize();

        Allure.step("Add product to bag");
        productPage.addToBag();

        Allure.step("Open bag page");
        productPage.openBag();

        BagPage bagPage = new BagPage(driver);

        Allure.step("Select maximum quantity (10)");
        bagPage.selectMaxQuantity();

        Allure.step("Capture selected quantity");
        int selectedQty = bagPage.getSelectedQuantity();

        System.out.println("Selected Quantity: " + selectedQty);

        Allure.step("Validate quantity is updated correctly");

        Assert.assertEquals(selectedQty, 10,
                "Maximum quantity not selected correctly");
    }
}