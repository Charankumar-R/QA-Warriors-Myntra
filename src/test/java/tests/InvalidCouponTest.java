package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class InvalidCouponTest extends BaseTest {

    @Test
    @Description("Validate that invalid coupon shows error message")
    public void invalidCouponTest() {

        HomePage homePage = new HomePage(driver);
        homePage.searchProduct("Men T-shirt");

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.selectFirstProduct();

        ProductPage productPage = new ProductPage(driver);
        productPage.selectSize();
        productPage.addToBag();
        productPage.openBag();

        BagPage bagPage = new BagPage(driver);
        bagPage.applyCoupon();
        bagPage.enterInvalidCoupon("FAKE123");

        // Wait is handled inside this method
        bagPage.clickCheckButton();

        // Get error message
        String errorMessage = bagPage.getInvalidCouponMessage();

        // Assertion
        Assert.assertEquals(
                errorMessage,
                "Coupon code is not valid",
                "Invalid coupon error message not displayed"
        );
    }
}