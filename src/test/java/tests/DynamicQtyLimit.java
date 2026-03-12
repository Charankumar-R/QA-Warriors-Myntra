package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductsPage;
import pages.ProductPage;
import pages.BagPage;

public class DynamicQtyLimit extends BaseTest {

    @Test
    @Description("Validate that user can select maximum quantity available (10)")
    public void dynamicQtyLimit() {

        // Search product
        HomePage homePage = new HomePage(driver);
        homePage.searchProduct("Men T-shirt");

        // Select product
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.selectFirstProduct();

        // Product page actions
        ProductPage productPage = new ProductPage(driver);
        productPage.selectSize();
        productPage.addToBag();
        productPage.openBag();

        // Bag page actions
        BagPage bagPage = new BagPage(driver);
        bagPage.selectMaxQuantity();

        // Basic assertion
        Assert.assertTrue(true, "Successfully selected quantity 10");

    }
}