package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//span[@class='title-page']")
    WebElement titlePage;
    @FindBy(xpath = "//div[(text() = 'Terminal ID: WEB02865008')]")
    WebElement txtTerminalId;
    @FindBy(xpath = "//p[@class='sc-dPqGIC klyCBb']")
    WebElement txtUserName;
    @FindBy(xpath = "//*[@data-testid='LogoutIcon']")
    WebElement btnLogout;

    @FindBy(xpath = "//button[(text() = 'Ya')]")
    WebElement btnYaPopupConfirm;

    @FindBy(xpath = "//div[@class='logo-header']")
    WebElement imgMeditap;
    @FindBy(xpath = "//div[@data-testid='btnRawatJalan']")
    WebElement txtBtnRawatJalan;
    @FindBy(xpath = "//div[@data-testid='btnRawatInap']")
    WebElement txtBtnRawatInap;
    @FindBy(xpath = "//div[@data-testid='btnPengesahanTagihan']")
    WebElement txtBtnPengesahanTagihan;
     @FindBy(xpath = "//p[normalize-space()='Penagihan Klaim']")
    WebElement txtBtnPenagihanKlaim;
    @FindBy(xpath = "//p[normalize-space()='Panduan']")
    WebElement txtBtnPanduan;
    @FindBy(xpath = "//span[@aria-label='Video Panduan']")
    WebElement txtBtnVideoPanduan;
    @FindBy(xpath = "//span[@aria-label='Document Panduan']")
    WebElement txtBtnDocPanduan;
    @FindBy(xpath = "//p[normalize-space()='Hubungi kami']")
    WebElement txtBtnHubKami;
    @FindBy(xpath = "//p[normalize-space()='Pengaturan']")
    WebElement txtBtnPengaturan;

    public HomePage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
        super(driver, explicitWait);
        PageFactory.initElements(driver.get(),this);
    }

    public boolean getTitleHomePage(){
        if(doGetText(titlePage).contains("Selamat Datang")){
            return true;
        }return false;
    }

    public void clickLogout() throws InterruptedException {
        doClick(btnLogout);
    }

    public void clickYaOnPopupConfirm() throws InterruptedException {
        doClick(btnYaPopupConfirm);
    }

    public boolean logoMeditapIsDisplayed(){
        waitForElementPresent(imgMeditap);
        return imgMeditap.isDisplayed();
    }

    public String getTerminalID(){
        return doGetText(txtTerminalId);
    }

    public String getUserName(){
        return doGetText(txtUserName);
    }

    public void clickRawatJalan() throws InterruptedException {
        waitForElementPresent(txtBtnRawatJalan);
        doClick(txtBtnRawatJalan);
    }

    public void clickRawatInap() throws InterruptedException {
        doClick(txtBtnRawatInap);

    }

    public void clickPengesahanTagihan() throws InterruptedException {
        try {
            doClick(txtBtnPengesahanTagihan);
        } catch (UnhandledAlertException f) {
            try {
                Alert alert = driver.get().switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }
        }
    }

    public void clickPenagihanKlaim() throws InterruptedException {
        doClick(txtBtnPenagihanKlaim);
    }

    public void scrollUntilBtnPenagihanKlaim() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)driver.get();
        jse.executeScript("arguments[0].scrollIntoView(true)",txtBtnPenagihanKlaim);
        Thread.sleep(2000);
    }

    public void clickPanduan() throws InterruptedException {
        doClick(txtBtnPanduan);
    }

    public void clickVideoPanduan() throws InterruptedException {
        doClick(txtBtnVideoPanduan);
    }

    public void clickDocPanduan() throws InterruptedException {
        doClick(txtBtnDocPanduan);
    }

    public void clickHubKami() throws InterruptedException {
        doClick(txtBtnHubKami);
    }

    public void clickPengaturan() throws InterruptedException {
        doClick(txtBtnPengaturan);
    }


}
