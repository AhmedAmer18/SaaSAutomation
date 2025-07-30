package Pages._2_System_Setup._2_MasterData._9_Devices_Data;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class P02_DashboardPage {
    private final WebDriver driver;
    //open system and show Girdlist
    private final By OpenSystemSetup = By.xpath("//span[contains(text(),'تهيئة النظام')]");
    private final By OpenMainData = By.xpath("//ul[@class='sidebar-submenu menu-open']//span[contains(text(),'البيانات الأساسية')]");
    private final By OpenDevicesData = By.xpath("(//i[@class='fa-users fas'])[1]");
    private final By AddButton = By.xpath("//i[@class='fal fa-plus fa-lg grid-add']");
    private final By ClickOnDeviceTypeDropDownList = By.xpath("//span[@class='e-input-group-icon e-ddl-icon e-search-icon'][1]");
    private final By ChoiceCompanyMade = By.xpath("//input[@placeholder='الشركة المصنعة']");
    private final By ChoiceNameOfDevice = By.xpath("//input[@placeholder='اسم الجهاز']");
    private final By ChoiceSequenceNumber = By.xpath("//input[@placeholder='رقم التسلسل']");
    //span[contains(@class,'e-input-group-icon') and contains(@class,'e-ddl-icon') and contains(@class,'e-search-icon') and contains(@class,'e-input-btn-ripple')]
    private final By ClickOnNumberOfBankComboBox = By.xpath("//input[@placeholder='رقم البنك']");
    private final By ChoiceAccountNumberOfBankComboBox = By.xpath("//input[@placeholder='رقم الحساب البنكي']");
    //Edit1
    private final By ClickOnIDName = By.xpath("//input[@placeholder='الاسم التعريفي']");
    private final By ClickOnVersion = By.xpath("//input[@placeholder='الإصدار']");
    private final By ClickOperationSystemTypeDropDownList = By.xpath("//span[@class='e-input-group-icon e-ddl-icon e-search-icon'][1]");
    private final By ClickonSaveButton = By.xpath("//i[@class='fas fa-save faa-shake animated']");
    //massage
    private final By saveMessage = By.xpath("//div[@aria-label='تمت العملية بنجاح']");
    private final By editMessage = By.xpath("//div[@aria-label='تمت عملية التعديل بنجاح']");
    private final By removeMessage = By.xpath("//div[@aria-label='تمت عملية الحذف بنجاح']");
    //Delete
    private final By ClickOnDelete = By.xpath("//button[@title='حذف']");
    private final By confirmButtonToDeleted = By.xpath("//button[contains(text(),'تأكيد')]");
    //Delete2
    private final By ClickOnDelete2 = By.xpath("//i[@class='fal fa-trash-alt fa-lg grid-remove']");
    private final By confirmButtonToDeleted2 = By.xpath("//button[contains(text(),'تأكيد')]");
    //DeleteAfter
    private final By ClickOnDeleteButton2 = By.xpath("//i[@class='fal fa-trash-alt fa-lg grid-remove']");
    //AddNew2
    private final By ClickOnDropDownListOperationSystem = By.xpath("//span[@class='e-input-group e-control-wrapper e-ddl e-lib e-keyboard e-input-focus e-icon-anim']//span[@class='e-input-group-icon e-ddl-icon e-search-icon']");
    private final By BackToAllGrirdList = By.xpath("//a[contains(text(),'الكل')]");
    private final By ClickOnDiveNameAboutGridList = By.xpath("//td[@role='gridcell' and text()='Laptop X']");
    private final By ClickOnDiveNameAboutGridList10 = By.xpath("//td[@role='gridcell' and text()='Laptop X10']");

    private final By ClickOnDiveNameViewing = By.xpath("//i[@class='fas fa-eye fa-lg grid-view']");
    private final By ClickOnEditingButton = By.xpath("//i[@class='fal fa-user-edit fa-lg grid-edit']");
    private final By ClickOnNumberOfDivce = By.xpath("input[placeholder='رقم الجهاز']");
    private final By ClickOnDiveNameAboutGridList2 = By.xpath("//td[@role='gridcell' and text()='Laptop X2']");
    //Deactivate
    private final By deactivateButton = By.xpath("//i[@class='fad fa-lock-alt']");
    private final By deactivate = By.xpath("//label[@class='switch-box-slider']");
    private final By deactivateReason = By.xpath("//textarea[@id='inactvDsc']");
    private final By deactivateSave = By.xpath("//span[contains(text(),'حفظ')]");
    private final By deactivateMessage = By.xpath("//h6[@class='ribbon__content ribbon__content--color--inactive']");
    //SearchBar
    private final By SearchBarNaf = By.xpath("//input[@id='stpTrmnl31_searchbar']");
    //preAddUsingQuery
    private final By ClickOnPreAddQuery = By.xpath("//a[contains(text(),'بيانات الأجهزة')]");
    private final By ClickOnAddOrNewQuery = By.xpath("//button[@title='جديد']");
    //EidtQuery1
    private final By ClickOnEditQuery = By.xpath("//i[@class='fas fa-edit faa-shake animated']");
    //print
    private final By ClickOnPrintButton = By.xpath("//button[@title='طباعة']");
    private final By ClickOnAfterPrintButton = By.xpath("//button[contains(text(),'تنفيذ')]");
    private final By ClosePrint = By.xpath("//i[@class='fas fa-times closeReportBtn']");
    //Monitoring
    private final By ClickOnMonitoring = By.xpath("//i[@class='fas fa-user']");
    private final By ClickAfterMonitoring = By.xpath("//i[@class='fas fa-times']");

    //class="ribbon__content ribbon__content--color--inactive ng-star-inserted"
    //select[@id='ej2_dropdownlist_18_hidden']/option[@value='2' and text()='جوال']
    public P02_DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public P02_DashboardPage ClickOnOpenSystemSetup() {
        Utility.clickingOnElement(driver, OpenSystemSetup);
        Utility.clickingOnElement(driver, OpenMainData);
        Utility.clickingOnElement(driver, OpenDevicesData);
        return this;
    }

    public P02_DashboardPage AddOnDeviceDataScreen1(WebDriver driver, String CompanyName, String deviceName, String seqNum, String bankOptionText, String accountNum) throws InterruptedException {
        Utility.clickingOnElement(driver, AddButton);
        Thread.sleep(1000);
        Utility.selectFromCustomDropdown(driver, ClickOnDeviceTypeDropDownList, "آلة البنك"); // أو "آلة البنك"
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ChoiceCompanyMade));
        Utility.sendData(driver, ChoiceCompanyMade, CompanyName);
        Utility.sendData(driver, ChoiceNameOfDevice, deviceName);
        Utility.sendData(driver, ChoiceSequenceNumber, seqNum);
        WebElement bankInput = wait.until(ExpectedConditions.elementToBeClickable(ClickOnNumberOfBankComboBox));
        bankInput.click();
        bankInput.sendKeys(Keys.CONTROL + "a"); // تحديد النص القديم
        bankInput.sendKeys(Keys.BACK_SPACE);    // مسح النص القديم
        bankInput.sendKeys(bankOptionText);     // إدخال النص الجديد
        WebElement optionToSelect = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[contains(text(),'" + bankOptionText + "')]")));
        optionToSelect.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(ChoiceAccountNumberOfBankComboBox));
        Thread.sleep(1000);
        WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(ClickonSaveButton));
        saveBtn.click();
        Utility.clickingOnElement(driver, BackToAllGrirdList);
        return this;

    }

    public P02_DashboardPage AddOnDeviceDataScreenQuery1(WebDriver driver, String CompanyName, String deviceName, String seqNum, String bankOptionText, String accountNum) throws InterruptedException {
        Utility.clickingOnElement(driver, ClickOnPreAddQuery);
        Utility.clickingOnElement(driver, ClickOnAddOrNewQuery);
//Utility.clickingOnElement(driver, AddButton);
        Thread.sleep(1000);
        Utility.selectFromCustomDropdown(driver, ClickOnDeviceTypeDropDownList, "آلة البنك"); // أو "آلة البنك"
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ChoiceCompanyMade));
        Utility.sendData(driver, ChoiceCompanyMade, CompanyName);
        Utility.sendData(driver, ChoiceNameOfDevice, deviceName);
        Utility.sendData(driver, ChoiceSequenceNumber, seqNum);
        WebElement bankInput = wait.until(ExpectedConditions.elementToBeClickable(ClickOnNumberOfBankComboBox));
        bankInput.click();
        bankInput.sendKeys(Keys.CONTROL + "a"); // تحديد النص القديم
        bankInput.sendKeys(Keys.BACK_SPACE);    // مسح النص القديم
        bankInput.sendKeys(bankOptionText);     // إدخال النص الجديد
        WebElement optionToSelect = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[contains(text(),'" + bankOptionText + "')]")));
        optionToSelect.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(ChoiceAccountNumberOfBankComboBox));
        Thread.sleep(1000);
        WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(ClickonSaveButton));
        saveBtn.click();
        Utility.clickingOnElement(driver, BackToAllGrirdList);
        return this;

    }

    public P02_DashboardPage EditOnDeviceDataScreen1(WebDriver driver, String NumberOfDevice1, String CompanyName1, String deviceName1, String seqNum1, String bankOptionText1, String accountNum1) throws InterruptedException {
        // Utility.clickingOnElement(driver, AddButton);
        //  Utility.clickingOnElement(driver, ClickOnPreAddQuery);
        Utility.clickingOnElement(driver, ClickOnDiveNameAboutGridList);
        Utility.clickingOnElement(driver, ClickOnDiveNameViewing);
        Utility.clickingOnElement(driver, BackToAllGrirdList);
        Utility.clickingOnElement(driver, ClickOnDiveNameAboutGridList);
        Utility.clickingOnElement(driver, ClickOnEditingButton);

        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement deviceInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='رقم الجهاز']")));
        deviceInput.click();
        deviceInput.sendKeys(Keys.CONTROL + "a");
        deviceInput.sendKeys(Keys.DELETE);
        deviceInput.sendKeys(String.valueOf(NumberOfDevice1));
        Utility.selectFromCustomDropdown(driver, ClickOnDeviceTypeDropDownList, "آلة البنك"); // أو "آلة البنك"
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ChoiceCompanyMade));
        Utility.clear(driver, ChoiceCompanyMade);
        Utility.sendData(driver, ChoiceCompanyMade, CompanyName1);
        Utility.clear(driver, ChoiceNameOfDevice);
        Utility.sendData(driver, ChoiceNameOfDevice, deviceName1);
        Utility.clear(driver, ChoiceSequenceNumber);
        Utility.sendData(driver, ChoiceSequenceNumber, seqNum1);
        WebElement bankInput = driver.findElement(ClickOnNumberOfBankComboBox);
        bankInput.click();
        bankInput.sendKeys(Keys.CONTROL + "a");
        bankInput.sendKeys(Keys.BACK_SPACE);
        bankInput.sendKeys(bankOptionText1);
        WebElement optionToSelect = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[contains(text(),'" + bankOptionText1 + "')]")));
        optionToSelect.click();
        bankInput.sendKeys(Keys.TAB);
        Thread.sleep(500);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(ClickonSaveButton));
        saveBtn.click();
        Utility.clickingOnElement(driver, BackToAllGrirdList);
        Utility.clickingOnElement(driver, ClickOnDiveNameAboutGridList2);
        Utility.clickingOnElement(driver, ClickOnDeleteButton2);
        Utility.clickingOnElement(driver, confirmButtonToDeleted);

        return this;
    }

    public P02_DashboardPage EditOnDeviceDataScreenQuery1(WebDriver driver, String NumberOfDevice1, String CompanyName1, String deviceName1, String seqNum1, String bankOptionText1, String accountNum1) throws InterruptedException {
        // Utility.clickingOnElement(driver, AddButton);
        //  Utility.clickingOnElement(driver, ClickOnPreAddQuery);

        // Utility.clickingOnElement(driver, BackToAllGrirdList);
        // Utility.clickingOnElement(driver, ClickOnDiveNameAboutGridList);
        //Utility.clickingOnElement(driver, ClickOnEditingButton);
        Utility.clickingOnElement(driver, ClickOnDiveNameAboutGridList2);
        Utility.clickingOnElement(driver, ClickOnDiveNameViewing);
        Utility.clickingOnElement(driver, ClickOnEditQuery);
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement deviceInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='رقم الجهاز']")));
        deviceInput.click();
        deviceInput.sendKeys(Keys.CONTROL + "a");
        deviceInput.sendKeys(Keys.DELETE);
        deviceInput.sendKeys(String.valueOf(NumberOfDevice1));
        Utility.selectFromCustomDropdown(driver, ClickOnDeviceTypeDropDownList, "آلة البنك"); // أو "آلة البنك"
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ChoiceCompanyMade));
        Utility.clear(driver, ChoiceCompanyMade);
        Utility.sendData(driver, ChoiceCompanyMade, CompanyName1);
        Utility.clear(driver, ChoiceNameOfDevice);
        Utility.sendData(driver, ChoiceNameOfDevice, deviceName1);
        Utility.clear(driver, ChoiceSequenceNumber);
        Utility.sendData(driver, ChoiceSequenceNumber, seqNum1);
        WebElement bankInput = driver.findElement(ClickOnNumberOfBankComboBox);
        bankInput.click();
        bankInput.sendKeys(Keys.CONTROL + "a");
        bankInput.sendKeys(Keys.BACK_SPACE);
        bankInput.sendKeys(bankOptionText1);
        WebElement optionToSelect = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[contains(text(),'" + bankOptionText1 + "')]")));
        optionToSelect.click();
        bankInput.sendKeys(Keys.TAB);
        Thread.sleep(500);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(ClickonSaveButton));
        saveBtn.click();
        Utility.clickingOnElement(driver, BackToAllGrirdList);
        Utility.clickingOnElement(driver, ClickOnDiveNameAboutGridList10);
        Utility.clickingOnElement(driver, ClickOnDelete);
        Utility.clickingOnElement(driver, confirmButtonToDeleted);

        return this;
    }

    public P02_DashboardPage Delete1() {
        Utility.doubleClick(driver, ClickOnDiveNameAboutGridList);
        Utility.clickingOnElement(driver, ClickOnDelete);
        Utility.clickingOnElement(driver, confirmButtonToDeleted);
        return this;
    }

    public P02_DashboardPage AddOnDeviceDataScreen2(WebDriver driver, String CompanyName2, String IDName2, String Version2, String deviceName2, String seqNum2) throws InterruptedException {
        Utility.clickingOnElement(driver, AddButton);
        Thread.sleep(1000);
        Utility.selectFromCustomDropdown(driver, ClickOnDeviceTypeDropDownList, "جوال");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ChoiceCompanyMade));
        Utility.sendData(driver, ChoiceCompanyMade, CompanyName2);
        Utility.sendData(driver, ClickOnIDName, IDName2);
        Utility.sendData(driver, ClickOnVersion, Version2);
        driver.findElement(By.xpath("(//span[@class='e-input-group-icon e-ddl-icon e-search-icon'])[2]")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//ul[contains(@class,'e-ul')]/li")));
        for (WebElement option : options) {
            if (option.getText().trim().contains("أبل")) { // استخدم contains بدلاً من equalsIgnoreCase لتفادي مشاكل الفراغات أو اللهجات
                option.click();
                break;
            }
        }
        Utility.sendData(driver, ChoiceNameOfDevice, deviceName2);
        Utility.sendData(driver, ChoiceSequenceNumber, seqNum2);
        WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(ClickonSaveButton));
        saveBtn.click();
        Utility.clickingOnElement(driver, BackToAllGrirdList);

        Utility.clickingOnElement(driver, ClickOnDiveNameAboutGridList10);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement deleteBtn = wait.until(ExpectedConditions.elementToBeClickable(ClickOnDeleteButton2));
        deleteBtn.click();
        //  Utility.clickingOnElement(driver, ClickOnDelete);
        WebElement confirmDeleteBtn = wait.until(ExpectedConditions.elementToBeClickable(confirmButtonToDeleted));
        confirmDeleteBtn.click();
//Utility.clickingOnElement(driver, confirmButtonToDeleted);

        return this;

    }

    public P02_DashboardPage AddOnDeviceDataQuery2(WebDriver driver, String CompanyName2, String IDName2, String Version2, String deviceName2, String seqNum2) throws InterruptedException {
        //  Utility.clickingOnElement(driver, AddButton);
        Utility.clickingOnElement(driver, ClickOnPreAddQuery);
        Utility.clickingOnElement(driver, ClickOnAddOrNewQuery);
        Thread.sleep(1000);
        Utility.selectFromCustomDropdown(driver, ClickOnDeviceTypeDropDownList, "جوال");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ChoiceCompanyMade));
        Utility.sendData(driver, ChoiceCompanyMade, CompanyName2);
        Utility.sendData(driver, ClickOnIDName, IDName2);
        Utility.sendData(driver, ClickOnVersion, Version2);
        driver.findElement(By.xpath("(//span[@class='e-input-group-icon e-ddl-icon e-search-icon'])[2]")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//ul[contains(@class,'e-ul')]/li")));
        for (WebElement option : options) {
            if (option.getText().trim().contains("أبل")) { // استخدم contains بدلاً من equalsIgnoreCase لتفادي مشاكل الفراغات أو اللهجات
                option.click();
                break;
            }
        }
        Utility.sendData(driver, ChoiceNameOfDevice, deviceName2);
        Utility.sendData(driver, ChoiceSequenceNumber, seqNum2);
        WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(ClickonSaveButton));
        saveBtn.click();
        Utility.clickingOnElement(driver, BackToAllGrirdList);
        Utility.clickingOnElement(driver, ClickOnDiveNameAboutGridList10);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement deleteBtn = wait.until(ExpectedConditions.elementToBeClickable(ClickOnDelete2));
        deleteBtn.click();
//Utility.clickingOnElement(driver, ClickOnDelete);
        WebElement confirmDeleteBtn = wait.until(ExpectedConditions.elementToBeClickable(confirmButtonToDeleted));
        confirmDeleteBtn.click();
//Utility.clickingOnElement(driver, confirmButtonToDeleted);

        return this;

    }

    public P02_DashboardPage Print() throws InterruptedException {

        //  Utility.doubleClick(driver, ClickOnDiveNameAboutGridList);
        Utility.doubleClick(driver, ClickOnDiveNameAboutGridList);
//Utility.clickingOnElement(driver, ClickOnDiveNameViewing);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(ClickOnPrintButton));
        Utility.clickingOnElement(driver, ClickOnPrintButton);
        wait.until(ExpectedConditions.presenceOfElementLocated(ClickOnAfterPrintButton));
        wait.until(ExpectedConditions.elementToBeClickable(ClickOnAfterPrintButton));
        Utility.clickingOnElement(driver, ClickOnAfterPrintButton);
        By spinner = By.xpath("//div[contains(@class,'spinner-in-page') and contains(@style,'display: block')]");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(spinner));
        wait.until(ExpectedConditions.elementToBeClickable(ClosePrint));
        Utility.clickingOnElement(driver, ClosePrint);

        return this;
    }

    public P02_DashboardPage Monitoring() throws InterruptedException {

        Utility.doubleClick(driver, ClickOnDiveNameAboutGridList);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(ClickOnMonitoring));
        Utility.clickingOnElement(driver, ClickOnMonitoring);
        wait.until(ExpectedConditions.elementToBeClickable(ClickAfterMonitoring));
        Utility.clickingOnElement(driver, ClickAfterMonitoring);

        return this;
    }

    public P02_DashboardPage Deactivate(String nameText) {

        Utility.doubleClick(driver, ClickOnDiveNameAboutGridList);
        Utility.clickingOnElement(driver, deactivateButton);
        Utility.clickingOnElement(driver, deactivate);
        Utility.sendData(driver, deactivateReason, nameText);
        Utility.clickingOnElement(driver, deactivateSave);
        return this;
    }

    public P02_DashboardPage activate() {

        Utility.doubleClick(driver, ClickOnDiveNameAboutGridList);
        Utility.clickingOnElement(driver, deactivateButton);
        Utility.clickingOnElement(driver, deactivate);
        Utility.clickingOnElement(driver, deactivateSave);
        return this;
    }

    public P02_DashboardPage SearchBarNaf(String ChoiceNameOfDevice) throws InterruptedException {

        Utility.clickingOnElement(driver, SearchBarNaf);
        Utility.sendData(driver, SearchBarNaf, ChoiceNameOfDevice);
        driver.findElement(SearchBarNaf).sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement deviceNameElement = wait.until(ExpectedConditions.elementToBeClickable(ClickOnDiveNameAboutGridList));
        // دلوقتي اعمل دبل كليك
        Utility.clickingOnElement(driver, ClickOnDiveNameAboutGridList);
        Utility.doubleClick(driver, ClickOnDiveNameAboutGridList);


        return this;
    }


    public By getOpenDevicesData() {
        return OpenDevicesData;

    }

    public boolean assertDeviceDataTC(String expectedValue) {
        return driver.getCurrentUrl().equals(expectedValue);
    }

    public boolean assertSaved(String expectedValue) {
        return Utility.getText(driver, saveMessage).equals(expectedValue);
    }

    public boolean assertEdited(String expectedValue) {
        return Utility.getText(driver, editMessage).equals(expectedValue);
    }

    public boolean assertRemoved(String expectedValue) {
        return Utility.getText(driver, removeMessage).equals(expectedValue);
    }

    public boolean assertDeactivate(String expectedValue) {
        return Utility.getText(driver, deactivateMessage).equals(expectedValue);
    }
}