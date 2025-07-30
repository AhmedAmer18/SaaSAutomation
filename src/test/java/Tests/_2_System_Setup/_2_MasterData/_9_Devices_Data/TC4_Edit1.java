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
public class TC4_Edit1 {
    private final String USERNAME = DataUtils.getJsonData("ValidLogin", "username");
    private final String PASSWORD = DataUtils.getJsonData("ValidLogin", "password");
    private final String accountNum1 = DataUtils.getJsonData("EditDeviceData", "accountNum1");
    private final String NumberOfDevice1 = DataUtils.getJsonData("EditDeviceData", "NumberOfDevice1");
    private final String companyName1 = DataUtils.getJsonData("EditDeviceData", "companyName1");
    private final String deviceName1 = DataUtils.getJsonData("EditDeviceData", "deviceName1");
    private final String seqNum1 = DataUtils.getJsonData("EditDeviceData", "seqNum1");
    private final String bankOptionText1 = DataUtils.getJsonData("EditDeviceData", "bankOptionText1");

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
    public void CheckEditOnDeviceDataScreen1() throws InterruptedException {
        new P02_DashboardPage(getDriver())
                .ClickOnOpenSystemSetup()
                .EditOnDeviceDataScreen1(getDriver(), NumberOfDevice1, companyName1, deviceName1, seqNum1, bankOptionText1, accountNum1);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='e-input-group-icon e-ddl-icon e-search-icon'][1]")));
        Assert.assertTrue(new P02_DashboardPage(getDriver()).assertEdited(getJsonData("Messages", "Edited_Message")));
    }

    @AfterMethod
    public void quit() {

        getDriver().quit();
    }

}
