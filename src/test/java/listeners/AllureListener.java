package listeners;

import base.DriverFactory;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class AllureListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("=== TEST EXECUTION STARTED ===");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("=== TEST EXECUTION FINISHED ===");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("STARTED: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        System.out.println("PASSED: " + result.getMethod().getMethodName());

        WebDriver driver = DriverFactory.getDriver();

        if (driver != null) {
            attachScreenshot(driver, result.getMethod().getMethodName() + "_PASS");
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("FAILED: " + result.getMethod().getMethodName());

        WebDriver driver = DriverFactory.getDriver();

        if (driver != null) {
            attachScreenshot(driver, result.getMethod().getMethodName() + "_FAIL");
        }

        // Attach failure reason to Allure
        if (result.getThrowable() != null) {
            Allure.addAttachment(
                    "Exception",
                    result.getThrowable().toString()
            );
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("SKIPPED: " + result.getMethod().getMethodName());
    }

    private void attachScreenshot(WebDriver driver, String name) {

        try {

            byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);

            Allure.addAttachment(
                    name,
                    "image/png",
                    new ByteArrayInputStream(screenshot),
                    ".png"
            );

        } catch (Exception e) {
            System.out.println("Screenshot capture failed: " + e.getMessage());
        }
    }
}