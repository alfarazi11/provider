package page.chiss;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.BasePage;

public class ChissLoginPage extends BasePage {
    public ChissLoginPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
        super(driver, explicitWait);
        PageFactory.initElements(driver.get(),this);
    }

    @FindBy(id = "TxtUserID")
    WebElement colmnUserID;

    @FindBy(id = "TxtUserPassWd")
    WebElement colmnPass;

    @FindBy(id = "BtnSignOn")
    WebElement btnLogin;

    public void inputUserID(String uID){
        doSetText(colmnUserID,uID);
    }

    public void inputPass(String pass){
        doSetText(colmnPass,pass);
    }

    public void clickBtnLogin() throws InterruptedException {
        doClick(btnLogin);
    }



}
