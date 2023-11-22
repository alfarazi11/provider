package test;

import net.sourceforge.tess4j.TesseractException;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CommonPage;
import page.LoginPage;
import utils.CSVUser;

import java.io.IOException;

public class LoginTest extends BaseWebTest{

    @Test(testName = "Login with valid username and password")
    public void validLogin() throws InterruptedException, TesseractException, IOException {
        LoginPage loginPage = new LoginPage(driver,explicitWait);
        loginPage.login();
    }

    @Test(testName = "Login with valid username and password")
    public void capthcha() throws InterruptedException, TesseractException, IOException {
        LoginPage loginPage = new LoginPage(driver,explicitWait);
        CommonPage commonPage = new CommonPage(driver,explicitWait);
        loginPage.inputUserName("test");
        commonPage.scrollDownByPixel();
        Thread.sleep(3000);
        loginPage.getCaptcha();
        Thread.sleep(3000);
    }

    @Test(testName = "Login with invalid username")
    public void invalidUserName() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver,explicitWait);
        CSVUser csvUser = new CSVUser();
        String uName = csvUser.getInValidUName().getUserName();
        String pass = csvUser.getInValidUName().getPassword();
        loginPage.inputUserName(uName);
        loginPage.inputPass(pass);
        loginPage.inputCaptcha("5TGRVM");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.verifyTxtErrIsDisplayed());
    }

    @Test(testName = "Login with invalid pass")
    public void invalidPass() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver,explicitWait);
        CSVUser csvUser = new CSVUser();
        String uName = csvUser.getInValidPass().getUserName();
        String pass = csvUser.getInValidPass().getPassword();
        loginPage.inputUserName(uName);
        loginPage.inputPass(pass);
        loginPage.inputCaptcha("5TGRVM");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.verifyTxtErrIsDisplayed());
    }

    @Test(testName = "Login with invalid pass")
    public void invalidCaptcha() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver,explicitWait);
        CSVUser csvUser = new CSVUser();
        String uName = csvUser.getInValidPass().getUserName();
        String pass = csvUser.getInValidPass().getPassword();
        loginPage.inputUserName(uName);
        loginPage.inputPass(pass);
        loginPage.inputCaptcha("6TGRVM");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.verifyTxtErrCaptchaIsDisplayed());
    }
}
