package Tests._2_System_Setup._2_MasterData._9_Devices_Data;

import Listeners.IInvokedMethodListenerClass;
import Listeners.ITestResultListenerClass;
import Pages._0_Login.P01_LoginPage;
import Pages._2_System_Setup._2_MasterData._9_Devices_Data.P02_DashboardPage;
import Utilities.DataUtils;
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

public class TC7_Activate {

    private final String USERNAME = DataUtils.getJsonData("ValidLogin", "username");
    private final String PASSWORD = DataUtils.getJsonData("ValidLogin", "password");

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
    public void activate() {

        new P02_DashboardPage(getDriver())
                .ClickOnOpenSystemSetup().activate();
        Assert.assertTrue(new P02_DashboardPage(getDriver()).assertSaved(getJsonData("Messages", "Saved_Message")));

    }

    @AfterMethod
    public void quit() {

        getDriver().quit();
    }
}


