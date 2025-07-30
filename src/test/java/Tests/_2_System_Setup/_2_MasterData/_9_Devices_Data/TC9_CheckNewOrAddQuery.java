package Tests._2_System_Setup._2_MasterData._9_Devices_Data;

import Listeners.IInvokedMethodListenerClass;
import Listeners.ITestResultListenerClass;
import Pages._0_Login.P01_LoginPage;
import Pages._2_System_Setup._2_MasterData._9_Devices_Data.P02_DashboardPage;
import Tests._0_Login.TC01_LoginTest;
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
public class TC9_CheckNewOrAddQuery extends TC01_LoginTest {
    //final String seqNum2 = DataUtils.getJsonData("AddNewDevice2", "seqNum2");
    private final String USERNAME = DataUtils.getJsonData("ValidLogin", "username");
    private final String PASSWORD = DataUtils.getJsonData("ValidLogin", "password");
    //private final String PASSWORD = DataUtils.getJsonData("ValidLogin", "password");
    private final String companyName = DataUtils.getJsonData("AddNewDevice", "companyName");
    private final String deviceName = DataUtils.getJsonData("AddNewDevice", "deviceName");
    //private final String foreignName = DataUtils.getJsonData("AddNewDevice", "foreignName");
    private final String seqNum = DataUtils.getJsonData("AddNewDevice", "seqNum");
    private final String bankOptionText = DataUtils.getJsonData("AddNewDevice", "bankOptionText");
    private final String accountNum = DataUtils.getJsonData("AddNewDevice", "accountNum");


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
    public void CheckOnAddButton() throws InterruptedException, IOException {
        new P02_DashboardPage(getDriver())
                .ClickOnOpenSystemSetup()
                .AddOnDeviceDataScreenQuery1(getDriver(), companyName, deviceName, seqNum, bankOptionText, accountNum);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='e-input-group-icon e-ddl-icon e-search-icon'][1]")));
        Assert.assertTrue(new P02_DashboardPage(getDriver()).assertSaved(getJsonData("Messages", "Saved_Message")));
        Assert.assertTrue(new P02_DashboardPage(getDriver()).assertDeviceDataTC(getPropertyValue("environment", "DevicesDataList_URL")));
    }

    @AfterMethod
    public void quit() {

        getDriver().quit();
    }
}


