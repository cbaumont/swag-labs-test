package base;

import com.aventstack.extentreports.service.ExtentTestManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ReportListener implements ITestListener {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void onTestSuccess(ITestResult result) {
        reportPrint("Test passed!");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        reportPrint("Test failed.");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        reportPrint("Test skipped.");
    }

    private void reportPrint(String log) {
        LOGGER.info(log);
        ExtentTestManager.getTest().addScreenCaptureFromBase64String(takeScreenshot());
    }

    private String takeScreenshot() {
        return ((TakesScreenshot) BaseTest.getDriver()).getScreenshotAs(OutputType.BASE64);
    }

}
