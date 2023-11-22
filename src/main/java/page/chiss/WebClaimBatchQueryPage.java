package page.chiss;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.BasePage;

public class WebClaimBatchQueryPage extends BasePage {
    public WebClaimBatchQueryPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
        super(driver, explicitWait);
        PageFactory.initElements(driver.get(),this);
    }

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_TxtClaimNo']")
    WebElement colmnClaimNo;

    @FindBy(css = "[value='Search Claim Batch']")
    WebElement btnSearchClaim;

    @FindBy(xpath = "//a[.='View']")
    WebElement txtBtnView;

    public void inputClaimNo(String claimNo){
        doSetText(colmnClaimNo,claimNo);
    }

    public void clickBtnSearchClaim() throws InterruptedException {
        doClick(btnSearchClaim);
    }

    public void clickView() throws InterruptedException {
        doClick(txtBtnView);
    }

}
