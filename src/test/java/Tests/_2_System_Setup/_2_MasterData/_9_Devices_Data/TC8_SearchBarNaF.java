package Tests._2_System_Setup._2_MasterData._9_Devices_Data;

import Listeners.IInvokedMethodListenerClass;
import Listeners.ITestResultListenerClass;
import Pages._0_Login.P01_LoginPage;
import Pages._2_System_Setup._2_MasterData._9_Devices_Data.P02_DashboardPage;
import Utilities.DataUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.getDriver;
import static DriverFactory.DriverFactory.setupDriver;
import static Utilities.DataUtils.getPropertyValue;

@Listeners({IInvokedMethodListenerClass.class, ITestResultListenerClass.class})
public class TC8_SearchBarNaF {
    private final String USERNAME = DataUtils.getJsonData("ValidLogin", "username");
    private final String PASSWORD = DataUtils.getJsonData("ValidLogin", "password");
    private final String deviceName = DataUtils.getJsonData("AddNewDevice", "deviceName");


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
    public void SearchBarNaf() throws InterruptedException {
        new P02_DashboardPage(getDriver()).ClickOnOpenSystemSetup().SearchBarNaf(deviceName);


    }

    @AfterMethod
    public void quit() {

        getDriver().quit();
    }

}