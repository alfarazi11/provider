package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utility;

public class MailCatcherPage extends BasePage{
    public MailCatcherPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
        super(driver, explicitWait);
        PageFactory.initElements(driver.get(),this);
    }

    @FindBy(xpath = "//table/tbody/tr[1]/td[2]")
    WebElement txtToEmail;

    @FindBy(xpath = "//table/tbody/tr[1]/td[3]")
    WebElement txtSubjectEmail;

    @FindBy(xpath = "//iframe[@src='messages/90.html']")
    WebElement frameEmail;

    @FindBy(xpath = "//span[contains(.,'JUMAT/SORE/001')]")
    WebElement txtBodyEMail;

    @FindBy(xpath = "//span[.='Hello, sign in']")
    WebElement txtBtnInquiry;

    public void testMouseOver() throws InterruptedException {
        Actions act = new Actions(driver.get());
        act.moveToElement(txtBtnInquiry).perform();
        Utility.hardWait(3);

    }

    public boolean verifyToEmail(){
        if(doGetText(txtToEmail).contains("arrumi.alfarazi@meditap.id")){
            return true;
        }
        return false;
    }

    public boolean verifySubjectEmail(){
        if(doGetText(txtSubjectEmail).contains("INVOICE/TEST/001")){
            return true;
        }
        return false;
    }

    public void clickEmail() throws InterruptedException {
        doClick(txtSubjectEmail);
    }

    public boolean verifyBodyEmail(){
//        driver.get().switchTo().frame("//iframe[@src='messages/90.html']");
        if(doGetText(txtBodyEMail).contains("INVOICE/TEST/001")){
            return true;
        }
        return false;
    }

}
