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
import utils.ExcelUtils;

@Feature("Quantity Validation")
public class DynamicQtyLimitTest extends BaseTest {

    @Test
    @Story("Validate maximum quantity selection")
    @Description("Verify that user can select maximum quantity available for a product")
    public void dynamicQtyLimit() {

        String product = ExcelUtils.getCellData(1,1);

        HomePage homePage = new HomePage(driver);

        Allure.step("Search product from Excel");
        homePage.searchProduct(product);

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

        int selectedQty = bagPage.getSelectedQuantity();

        System.out.println("Selected Quantity: " + selectedQty);

        Allure.step("Validate quantity is updated correctly");

        if(selectedQty == 10){
            ExcelUtils.setCellData(1,3,"PASS");
        }else{
            ExcelUtils.setCellData(1,3,"FAIL");
        }

        Assert.assertEquals(selectedQty,10,
                "Maximum quantity not selected correctly");
    }
}