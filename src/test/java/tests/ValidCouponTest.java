package tests;

import base.BaseTest;
import io.qameta.allure.Allure;
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
        Allure.step("Search Product");
        homePage.searchProduct("Men T-shirt");

        ProductsPage productsPage = new ProductsPage(driver);
        Allure.step("Select Product");
        productsPage.selectFirstProduct();

        ProductPage productPage = new ProductPage(driver);

        Allure.step("Select size");
        productPage.selectSize();

        Allure.step("Add product to bag");
        productPage.addToBag();

        Allure.step("Open bag page");
        productPage.openBag();

        BagPage bagPage = new BagPage(driver);

        Allure.step("Capture price before coupon");
        int priceBefore = bagPage.getPriceBeforeCoupon();

        Allure.step("Apply coupon");
        bagPage.applyCoupon();

        Allure.step("Capture price after coupon");
        int priceAfter = bagPage.getPriceAfterCoupon();

        Allure.step("Validate discount applied");

        Assert.assertTrue(priceAfter < priceBefore,
                "Coupon discount not applied. Price before: " + priceBefore + " Price after: " + priceAfter);

    }
}