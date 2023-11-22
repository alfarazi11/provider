package page.pengesahantagihan;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.BasePage;

public class DetailPengesahanPage extends BasePage {
    public DetailPengesahanPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
        super(driver, explicitWait);
        PageFactory.initElements(driver.get(),this);
    }

    @FindBy(xpath = "//p[contains(.,'Provider melakukan pembatalan')]")
    WebElement txtTagihanDibatalkan;

    public boolean verifyPendaftaranDibatalkan(){
        if(doGetText(txtTagihanDibatalkan).contains("SALAH MANFAAT")){
            return true;
        }return false;
    }

    public boolean verifyTagihanDibatalkan(){
        System.out.println("alasan "+doGetText(txtTagihanDibatalkan));
        if(doGetText(txtTagihanDibatalkan).contains("Testing Automation")){
            return true;
        }return false;
    }

    @FindBy(xpath = "//p[.='Tagihan Dibatalkan']")
    WebElement txtStatusDibatalkan;

    public boolean verifyStatusDibatalkan(){
        if(doGetText(txtStatusDibatalkan).contains("Tagihan Dibatalkan")){
            return true;
        }return false;
    }

    @FindBy(xpath = "//div[1]/div[contains(@class,'css-1cmy3f0')]/div[1]/p[2]")
    WebElement txtNoKartu;

    public String getTxtNoKartu(){
       return doGetText(txtNoKartu);
    }

    @FindBy(xpath = "//div[1]/div[1]/div[2]/p[2]")
    WebElement txtNama;

    public String getTxtNama(){
        return doGetText(txtNama);
    }

    @FindBy(xpath = "//div[1]/div[1]/div[3]/p[2]")
    WebElement txtJnsKelamin;

    public String getTxtJnsKelamin(){
        return doGetText(txtJnsKelamin);
    }

    @FindBy(xpath = "//div[1]/div[1]/div[5]/p[2]")
    WebElement txtKaryawan;

    public String getTxtKaryawan(){
        return doGetText(txtKaryawan);
    }

    @FindBy(xpath = "//div[1]/div[2]/div[5]/p[2]")
    WebElement txtPayor;

    public String getTxtPayor(){
        JavascriptExecutor jse = (JavascriptExecutor)driver.get();
        jse.executeScript("arguments[0].scrollIntoView(true)",btnLngkpTghan);
        return doGetText(txtPayor);
    }

    @FindBy(xpath = "//div/p[contains(@class,'css-1stj5os')]")
    WebElement txtStatusTagihan;

    public String getTxtStatusTagihan(){
        return doGetText(txtStatusTagihan);
    }

    @FindBy(xpath = "//button[(text() = 'Lengkapi Tagihan')]")
    WebElement btnLngkpTghan;

    public void clickBtnLngkpTagihan() throws InterruptedException {
        doClick(btnLngkpTghan);
    }

}
