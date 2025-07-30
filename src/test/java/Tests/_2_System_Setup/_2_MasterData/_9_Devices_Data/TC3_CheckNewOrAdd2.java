package Tests._2_System_Setup._2_MasterData._9_Devices_Data;

import Listeners.IInvokedMethodListenerClass;
import Listeners.ITestResultListenerClass;
import Pages._0_Login.P01_LoginPage;
import Pages._2_System_Setup._2_MasterData._9_Devices_Data.P02_DashboardPage;
import Utilities.DataUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.getDriver;
import static DriverFactory.DriverFactory.setupDriver;
import static Utilities.DataUtils.getJsonData;
import static Utilities.DataUtils.getPropertyValue;

@Listeners({IInvokedMethodListenerClass.class, ITestResultListenerClass.class})
public class TC3_CheckNewOrAdd2 {
    final String seqNum2 = DataUtils.getJsonData("AddNewDevice2", "seqNum2");
    private final String USERNAME = DataUtils.getJsonData("ValidLogin", "username");
    private final String PASSWORD = DataUtils.getJsonData("ValidLogin", "password");
    private final String deviceName2 = DataUtils.getJsonData("AddNewDevice2", "deviceName2");
    private final String IDName2 = getJsonData("AddNewDevice2", "IDName2");
    private final String Version2 = getJsonData("AddNewDevice2", "Version2");
    private final String companyName2 = DataUtils.getJsonData("AddNewDevice2", "CompanyName2");

    @BeforeMethod
    public void setup() throws IOException {
        setupDriver(getPropertyValue("environment", "Browser"));
        getDriver().get(getPropertyValue("environment", "BASE_URL"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        new P01_LoginPage(getDriver())
                .enterUsername(USERNAME)
                .enterPassword(PASSWORD)
                .ClickOnLoginButton();
    }

    @Test
    public void CheckOnAddButton2() throws InterruptedException {
        new P02_DashboardPage(getDriver())
                .ClickOnOpenSystemSetup()
                .AddOnDeviceDataScreen2(getDriver(), companyName2, IDName2, Version2, deviceName2, seqNum2);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='e-input-group-icon e-ddl-icon e-search-icon'][1]")));
        Assert.assertTrue(new P02_DashboardPage(getDriver()).assertSaved(getJsonData("Messages", "Saved_Message")));
    }

    @AfterMethod
    public void quit() {

        getDriver().quit();
    }
}



