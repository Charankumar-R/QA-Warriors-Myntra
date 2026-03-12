package utils;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "productData")
    public static Object[][] productData() {
        return ExcelReader.readData("Sheet1");
    }
}