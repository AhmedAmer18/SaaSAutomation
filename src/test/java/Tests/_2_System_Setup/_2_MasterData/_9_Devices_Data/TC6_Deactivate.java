package Tests._2_System_Setup._2_MasterData._9_Devices_Data;

import Listeners.IInvokedMethodListenerClass;
import Listeners.ITestResultListenerClass;
import Pages._0_Login.P01_LoginPage;
import Pages._2_System_Setup._2_MasterData._9_Devices_Data.P02_DashboardPage;
import Utilities.DataUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
public class TC6_Deactivate {

    private final String USERNAME = DataUtils.getJsonData("ValidLogin", "username");
    private final String PASSWORD = DataUtils.getJsonData("ValidLogin", "password");
    private final String nameText = DataUtils.getJsonData("Deactavite", "nameText");

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
    public void Deactivate() {

        new P02_DashboardPage(getDriver())
                .ClickOnOpenSystemSetup().Deactivate(nameText);
        Assert.assertTrue(new P02_DashboardPage(getDriver()).assertSaved(getJsonData("Messages", "Saved_Message")));
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        WebElement stopElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h6[contains(@class,'ribbon__content') and contains(text(),'التوقيف')]")));
        Assert.assertTrue(stopElement.getText().contains("توقيف"), "الكلمة غير موجودة داخل النص");
    }

    @AfterMethod
    public void quit() {

        getDriver().quit();
    }
}

