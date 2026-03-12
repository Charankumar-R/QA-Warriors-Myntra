package tests;

import base.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductsPage;
import pages.ProductPage;
import pages.BagPage;

import java.time.Duration;

@Feature("Coupon Validation")
public class ValidCouponWithSortingTest extends BaseTest {

    @Test
    @Story("Apply coupon after sorting products by customer rating")
    @Description("Search product → Sort by rating → Add product to bag → Apply coupon → Validate price difference")
    public void validCouponTest() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

        HomePage home = new HomePage(driver);

        Allure.step("Search for product: men t shirt under 300");
        home.searchProduct("men t shirt under 300");

        ProductsPage products = new ProductsPage(driver);

        Allure.step("Sort products by customer rating");
        products.sortByCustomerRating();

        Allure.step("Select first product from sorted results");
        products.selectFirstProduct();

        ProductPage product = new ProductPage(driver);

        Allure.step("Select product size");
        product.selectSize();

        Allure.step("Add product to bag");
        product.addToBag();

        Allure.step("Open shopping bag");
        product.openBag();

        BagPage bag = new BagPage(driver);

        Allure.step("Capture price before applying coupon");
        double beforePrice = bag.getPriceBeforeCoupon();

        Allure.step("Apply available coupon");
        bag.applyCoupon();

        Allure.step("Capture price after applying coupon");
        double afterPrice = bag.getPriceAfterCoupon();

        System.out.println("Price before coupon: " + beforePrice);
        System.out.println("Price after coupon: " + afterPrice);

        Allure.step("Validate that coupon discount is applied");

        Assert.assertTrue(afterPrice < beforePrice,
                "Coupon discount not applied correctly");
    }
}