package Pages._0_Login;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_LoginPage {
    private final WebDriver driver;
    private final By username = By.id("usrCode");
    private final By password = By.id("usrPswrd");
    private final By loginButton = By.xpath("//button[@type='submit']");

    public P01_LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    public P01_LoginPage enterUsername(String usernameText) {
        Utility.sendData(driver, username, usernameText);
        return this;

    }

    public P01_LoginPage enterPassword(String passwordText) {

        Utility.sendData(driver, password, passwordText);
        return this;
    }

    public P01_LoginPage ClickOnLoginButton() {
        Utility.clickingOnElement(driver, loginButton);
        return this;
    }

    public boolean assertLoginTC(String expectedValue) {
        return driver.getCurrentUrl().equals(expectedValue);
    }


}
