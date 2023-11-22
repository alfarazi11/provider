package page;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CSVUser;
import utils.Utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    WebElement userName;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(id = "kc-login")
    WebElement btnLgn;
    @FindBy(css = "#input-error")
    WebElement txtErrorLogin;
    @FindBy(xpath = "//a[.='Terms & Conditions']")
    WebElement txtBtnTermCondition;
    @FindBy(xpath = "//a[.='Privacy Policy']")
    WebElement txtBtnPolicy;

    @FindBy(xpath = "//div[@class='captcha-code-container']")
    WebElement imgCaptcha;

    @FindBy(id = "captcha-input")
    WebElement inptCaptcha;

    @FindBy(id = "input-error")
    WebElement txtErr;

    @FindBy(xpath = "//input[@id='captcha-input']")
    WebElement txtKodeVerifikasi;

    @FindBy(id = "captcha-input")
    WebElement capt;

    @FindBy(id = "invalid-captcha")
    WebElement invCaptcha;

    public LoginPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
        super(driver, explicitWait);
        PageFactory.initElements(driver.get(), this);
    }


    public void clickLoginButton() throws InterruptedException {
        doClick(btnLgn);
    }

    public void inputUserName(String uName) {
        clear(userName);
        doSetText(userName, uName);
    }

    public void inputPass(String pwd) {

        doSetText(password, pwd);
    }

    public void inputCaptcha(String captcha) {

        doSetText(capt, captcha);
    }

    public String getTxtErrorLogin() {
        return doGetText(txtErrorLogin);
    }

    public void clickTermCondition() throws InterruptedException {
        doClick(txtBtnTermCondition);
    }

    public void clickPolicy() throws InterruptedException {
        doClick(txtBtnPolicy);
    }

    public String getCaptcha() throws IOException, TesseractException {
        JavascriptExecutor jse = (JavascriptExecutor)driver.get();
        jse.executeScript("arguments[0].scrollIntoView(true)",txtKodeVerifikasi);
        Utility.hardWait(2);
        File src = imgCaptcha.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/captchaimage/captcha.png";
        FileHandler.copy(src, new File(path));
        Utility.hardWait(2);
        ITesseract image = new Tesseract();
        String imageText = image.doOCR(new File(path));
        System.out.println(imageText);
        return imageText;

    }

    public boolean verifyTxtErrIsDisplayed(){
        return waitForElementPresent(txtErr);
    }

    public boolean verifyTxtErrCaptchaIsDisplayed(){
        return waitForElementPresent(invCaptcha);
    }

    public void login() throws IOException, InterruptedException {
        CSVUser csvUser = new CSVUser();
        String uName = csvUser.getValidUser().getUserName();
        String pass = csvUser.getValidUser().getPassword();
        inputUserName(uName);
        inputPass(pass);
        inputCaptcha("5TGRVM");
        clickLoginButton();

    }

    public void loginMiya() throws IOException, InterruptedException {
        CSVUser csvUser = new CSVUser();
        String uName = csvUser.getValidUser().getUserName();
        String pass = csvUser.getValidUser().getPassword();
        inputUserName(uName);
        inputPass(pass);
        inputCaptcha("5TGRVM");
        clickLoginButton();
        CommonPage commonPage = new CommonPage(driver,explicitWait);
        commonPage.openURL("https://Tpa:Tpa@2023!@provider-advance.meditap.id/");

    }


}
