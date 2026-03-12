package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductsPage;
import pages.ProductPage;
import pages.BagPage;

public class ValidCouponTest extends BaseTest {

    @Test
    @Description("Validate that a valid coupon reduces the product price")
    public void validCouponTest() {

        HomePage homePage = new HomePage(driver);
        homePage.searchProduct("Men T-shirt");

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.selectFirstProduct();

        ProductPage productPage = new ProductPage(driver);
        productPage.selectSize();
        productPage.addToBag();
        productPage.openBag();

        BagPage bagPage = new BagPage(driver);

        int priceBefore = bagPage.getPriceBeforeCoupon();

        bagPage.applyCoupon();

        int priceAfter = bagPage.getPriceAfterCoupon();

        Assert.assertTrue(priceAfter < priceBefore, "Coupon discount not applied");
    }
}