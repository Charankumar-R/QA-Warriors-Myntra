package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductsPage;
import pages.ProductPage;
import pages.BagPage;

import java.time.Duration;
public class ValidCouponWithSortingTest extends BaseTest {

    @Test
    public void validCouponTest() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

        // ⭐ Step 1 → Search Product
        HomePage home = new HomePage(driver);
        home.searchProduct("men t shirt under 300");

        // ⭐ Step 2 → Wait product grid
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//li[contains(@class,'product-base')]")
        ));
        // ⭐ Step 4 → Wait sorted results
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//li[contains(@class,'product-base')]")
        ));

        // ⭐ Step 5 → Select first product
        ProductsPage products = new ProductsPage(driver);
        products.sortByCustomerRating();
        products.selectFirstProduct();

        // ⭐ Step 8 → Product page actions
        ProductPage product = new ProductPage(driver);
        product.selectSize();
        product.addToBag();
        product.openBag();

        // ⭐ Step 9 → Coupon validation
        BagPage bag = new BagPage(driver);

        double beforePrice = bag.getPriceBeforeCoupon();
        bag.applyCoupon();
        double afterPrice = bag.getPriceAfterCoupon();

        Assert.assertTrue(afterPrice < beforePrice,
                "Coupon discount not applied correctly");
    }
}