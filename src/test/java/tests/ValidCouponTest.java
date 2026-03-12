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
import utils.ExcelUtils;

public class ValidCouponTest extends BaseTest {

    @Test
    @Description("Validate that a valid coupon reduces the product price")
    public void validCouponTest() {

        String product = ExcelUtils.getCellData(1,1);

        HomePage homePage = new HomePage(driver);

        Allure.step("Search Product from Excel");
        homePage.searchProduct(product);

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

        Allure.step("Write values to Excel");

        ExcelUtils.setCellData(1,2, product); // Name
        ExcelUtils.setCellData(1,3, String.valueOf(priceBefore));
        ExcelUtils.setCellData(1,4, String.valueOf(priceAfter));

        if(priceAfter < priceBefore){
            ExcelUtils.setCellData(1,5,"PASS");
        }else{
            ExcelUtils.setCellData(1,5,"FAIL");
        }

        Assert.assertTrue(priceAfter < priceBefore,
                "Coupon discount not applied. Price before: " + priceBefore + " Price after: " + priceAfter);
    }
}