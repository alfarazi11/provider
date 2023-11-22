package page.chiss;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.BasePage;

public class ChissHomePage extends BasePage {
    public ChissHomePage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
        super(driver, explicitWait);
        PageFactory.initElements(driver.get(),this);
    }

    @FindBy(xpath = "//a[.='Web Claim']")
    WebElement txtBtnWebClaim;

    @FindBy(xpath = "//a[.='Web Claim GL']")
    WebElement txtBtnWebClaimGL;

    public void clickWebClaim() throws InterruptedException {
        doClick(txtBtnWebClaim);
    }

    public void clickWebClaimGL() throws InterruptedException {
        doClick(txtBtnWebClaimGL);
    }


}
