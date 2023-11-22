package page.rawatjalan;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.BasePage;
import utils.Utility;

import java.util.List;

public class DetailPerawatanPage extends BasePage {
    public DetailPerawatanPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
        super(driver, explicitWait);
        PageFactory.initElements(driver.get(),this);
    }

    @FindAll({@FindBy(xpath = "//div[contains(@class,'css-1cmy3f0')]/div[contains(@class,'css-15j76c0')]/p[2]")})
    List<WebElement> txtPendaftaran;

    public String getCreateBy(){
        return doGetText(txtPendaftaran.get(1));
    }

    public String getCreateVia(){
        return doGetText(txtPendaftaran.get(2));
    }

    public String getNoKlaim(){
        String[] txtNoKlaim = txtPendaftaran.get(3).getText().split("/");
        return txtNoKlaim[0];
    }

    public String getNoTransaksi(){
        String[] txtNoKlaim = txtPendaftaran.get(3).getText().split("/");
        return txtNoKlaim[1];
    }

    public String getTxtManfaat(){
        return doGetText(txtPendaftaran.get(4));
    }

    public String getTxtStatus(){
        return doGetText(txtPendaftaran.get(5));
    }

    @FindBy(xpath = "//div[2]/div[1]/div[1]/p[2]")
    WebElement txtNama;

    public String getTxtNama(){
        return doGetText(txtNama);
    }

    @FindBy(xpath = "//div[2]/div[1]/div[2]/p[2]")
    WebElement txtPayor;

    public String getTxtPayor(){
        return doGetText(txtPayor);
    }

    @FindBy(xpath = "//div[2]/div[1]/div[3]/p[2]")
    WebElement txtJnsKlmin;

    public String getTxtJnsKelamin(){
        return doGetText(txtJnsKlmin);
    }

    @FindBy(xpath = "//div[2]/div[1]/div[4]/p[2]")
    WebElement txtNmrKartu;

    public String getTxtNmrKartu(){
        return doGetText(txtNmrKartu);
    }

    @FindBy(xpath = "//button[(text()='Batalkan')]")
    WebElement btnBatalkan;

    public void clickBtnBatalkan() throws InterruptedException {
        doClick(btnBatalkan);
    }

    @FindBy(xpath = "//p[contains(.,'tagihan Anda dibatalkan')]")
    WebElement txtTagihanDibatalkan;

    public boolean verifyTagihanDibatalkan(){
        Utility.hardWait(5);
        if(doGetText(txtTagihanDibatalkan).contains("Testing Automation")){
            return true;
        }return false;
    }

    @FindBy(xpath = "//p[.='Pendaftaran Dibatalkan']")
    WebElement txtPendaftaranDibatalkan;

    public boolean verifyTxtPendaftaranDibatalkan(){
        if(doGetText(txtPendaftaranDibatalkan).contains("Pendaftaran Dibatalkan")){
            return true;
        }return false;
    }

    @FindBy(xpath = "//p[contains(text(),'Provider melakukan pembatalan perawatan dengan alasan')]")
    WebElement txtProviderBatalkanPerawatan;

    public boolean verifyTxtProviderBatalkanPerawatan(){
        if(doGetText(txtProviderBatalkanPerawatan).contains("Provider melakukan pembatalan perawatan dengan alasan")){
            return true;
        }return false;
    }


}
