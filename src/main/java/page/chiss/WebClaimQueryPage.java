package page.chiss;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.BasePage;
import utils.Utility;

public class WebClaimQueryPage extends BasePage {
    public WebClaimQueryPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
        super(driver, explicitWait);
        PageFactory.initElements(driver.get(),this);
    }

    @FindBy(css = "[src='Icons/Inquiry.png']")
    WebElement txtBtnInquiry;

    @FindBy(xpath = "//a[.='Claim Query / Monitoring Claim']")
    WebElement txtBtnClaimQuery;

    @FindBy(xpath = "(//input[@id='ctl00_ContentPlaceHolder1_TxtCardNo'])[1]")
    WebElement colmCardNoWebClaim;

    @FindBy(css = "[value='Retrieve Claim Data']")
    WebElement btnRetriveClaim;

    @FindBy(xpath = "//table/tbody/tr[2]/td[4]")
    WebElement txtClaimNumWebClaim;

    @FindBy(xpath = "//form[@id='aspnetForm']//div[2]//tr[2]//input[1]")
    WebElement checkBox;

    @FindBy(xpath = "//input[@value='Create GL']")
    WebElement btnCreateGL;

    @FindBy(xpath = "//span[@class='MasterTextMessage']]")
    WebElement txtSuccessfullyCreateGL;

    public void overMouseAction() throws InterruptedException {
        waitForElementPresent(txtBtnInquiry);
        Actions act = new Actions(driver.get());
        act.moveToElement(txtBtnInquiry).perform();
        Utility.hardWait(5);
    }

    public void clickClaimQuery() throws InterruptedException {
        doClick(txtBtnClaimQuery);
    }

    public void inputCardNumbWebClaim(String cardNum){
        doSetText(colmCardNoWebClaim,cardNum);
    }

    public void clickBtnRetrieveClaim() throws InterruptedException {
        doClick(btnRetriveClaim);
    }

    public String claimNumWebClaim(){
        return doGetText(txtClaimNumWebClaim);
    }

    public void clickCheckBox() throws InterruptedException {
        doClick(checkBox);
    }

    public void clickBtnCreateGL() throws InterruptedException {
        doClick(btnCreateGL);
    }

    public boolean verifyTxtCreateGL(){
        if(doGetText(txtSuccessfullyCreateGL).contains("succesfully")){
            return true;
        }return false;
    }

}
