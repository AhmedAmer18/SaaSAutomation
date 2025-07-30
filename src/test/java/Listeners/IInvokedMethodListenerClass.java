package Listeners;

import Pages._2_System_Setup._2_MasterData._9_Devices_Data.P02_DashboardPage;
import Utilities.LogsUtils;
import Utilities.Utility;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.time.Duration;

import static DriverFactory.DriverFactory.getDriver;

public class IInvokedMethodListenerClass implements IInvokedMethodListener {
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {

    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        String testName = testResult.getName();

        if (testResult.getStatus() == ITestResult.FAILURE) {
            LogsUtils.info("❌ Test Case " + testName + " failed");
        } else if (testResult.getStatus() == ITestResult.SUCCESS) {
            LogsUtils.info("✅ Test Case " + testName + " passed");
        } else {
            return; // skip الحاجات التانية
        }

        // دايمًا خُد Screenshot سواء في النجاح أو الفشل
        Utility.takeScreenshot(getDriver(), testName);

        try {
            new WebDriverWait(getDriver(), Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOfElementLocated(new P02_DashboardPage(getDriver()).getOpenDevicesData()));

            Utility.takeFullScreenshot(getDriver(), new P02_DashboardPage(getDriver()).getOpenDevicesData());
        } catch (Exception e) {
            LogsUtils.info("⚠️ Couldn't capture full screenshot: " + e.getMessage());
        }
    }

    //public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
    // if (testResult.getStatus() == ITestResult.FAILURE) {
    //     LogsUtils.info("Test Case " + testResult.getName() + " failed");
    //     Utility.takeScreenshot(getDriver(), testResult.getName());
    //   try {
    //      Utility.takeFullScreenshot(getDriver(), new P02_DashboardPage(getDriver()).getOpenDevicesData());
    // } catch (InterruptedException e) {
    //   throw new RuntimeException(e);
}



