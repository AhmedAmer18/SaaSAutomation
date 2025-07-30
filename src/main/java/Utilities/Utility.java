package Utilities;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Utility {
    private static final String SCREENSHOTS_PATH = "Test-outputs/Screenshots/ ";

    public static void clickingOnElement(WebDriver driver, By Locator) {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(Locator));
        driver.findElement(Locator).click();
    }

    public static void doubleClick(WebDriver driver, By Locator) {
        new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(Locator));
        new Actions(driver).doubleClick(driver.findElement(Locator)).build().perform();
    }

    public static void sendData(WebDriver driver, By locator, String data) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click(); // تأكد إن الفوكس على العنصر
        element.clear();// نظف الداتا القديمة إن وجدت
        element.sendKeys(data);
    }

   /* public static void sendData(WebDriver driver, By Locator, String data) {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(Locator));
        driver.findElement(Locator).sendKeys(data);
    }*/

    public static void clear(WebDriver driver, By Locator) {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(Locator));
        driver.findElement(Locator).clear();
    }

    public static String getText(WebDriver driver, By Locator) {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(Locator));
        return driver.findElement(Locator).getText();
    }

    public static WebDriverWait generalWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public static void scrolling(WebDriver driver, By Locator) {
        ((JavascriptExecutor) driver).executeScript("argument[0].scrollIntoView();", findWebElement(driver, Locator));
    }

    public static WebElement findWebElement(WebDriver driver, By Locator) {
        return driver.findElement(Locator);
    }

    public static void selectFromCustomDropdown(WebDriver driver, By dropdownIcon, String optionText) {
        clickingOnElement(driver, dropdownIcon);

        By optionLocator = By.xpath("//li[contains(text(),'" + optionText + "')]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.presenceOfElementLocated(optionLocator));
        WebElement option = driver.findElement(optionLocator);

        // Scroll لضمان إنه ظاهر
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);

        // اضغط عليه
        wait.until(ExpectedConditions.elementToBeClickable(option)).click();

    }

    public static void selectingFromDropDown(WebDriver driver, By locator, String option) {
        new Select(findWebElement(driver, locator)).selectByVisibleText(option);
    }

    public static String getTimeStamp() {
        return new SimpleDateFormat("yyyy-MM-dd-h-m-ssa").format(new Date());
    }

    public static void takeScreenshot(WebDriver driver, String screenshotName) {
        try {
            Thread.sleep(1000);
            // Capture screenshot using TakesScreenshot
            File screenshotSrc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Save screenshot to a file if needed
            File screenshotFile = new File(SCREENSHOTS_PATH + screenshotName + "-" + getTimeStamp() + ".png");
            FileUtils.copyFile(screenshotSrc, screenshotFile);

            // Attach the screenshot to Allure
            Allure.addAttachment(screenshotName, Files.newInputStream(Path.of(screenshotFile.getPath())));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void takeFullScreenshot(WebDriver driver, By locator) throws InterruptedException {
        Shutterbug.shootPage(driver, Capture.FULL_SCROLL).highlight(findWebElement(driver, locator))
                .save(SCREENSHOTS_PATH);
    }

}
