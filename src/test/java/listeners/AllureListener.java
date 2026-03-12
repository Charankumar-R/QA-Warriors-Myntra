package listeners;

import base.DriverFactory;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class AllureListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("STARTED: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        System.out.println("PASSED: " + result.getName());

        WebDriver driver = DriverFactory.getDriver();

        if (driver != null) {
            attachScreenshot(driver, "Success Screenshot");
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("FAILED: " + result.getName());

        WebDriver driver = DriverFactory.getDriver();

        if (driver != null) {
            attachScreenshot(driver, "Failure Screenshot");
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("SKIPPED: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Execution Started");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Execution Finished");
    }

    private void attachScreenshot(WebDriver driver, String name) {

        byte[] screenshot =
                ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment(
                name,
                new ByteArrayInputStream(screenshot)
        );
    }
}