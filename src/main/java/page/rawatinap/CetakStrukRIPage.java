package page.rawatinap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.BasePage;

public class CetakStrukRIPage extends BasePage {
    public CetakStrukRIPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
        super(driver, explicitWait);
        PageFactory.initElements(driver.get(),this);
    }

    @FindBy(xpath = "//button[@data-testid='btnTutupCetakStruk']")
    WebElement btnTutup;

    public void clickBtnTutup() throws InterruptedException {
        doClick(btnTutup);
    }

    @FindBy(xpath = "//table[1]/tbody/tr[1]/td[3]")
    WebElement txtPayor;

    public String getTxtPayor(){
        return doGetText(txtPayor);
    }

    @FindBy(xpath = "//table[1]/tbody/tr[3]/td[3]")
    WebElement txtCardNumb;

    public String getTxtNoKartu(){
        return doGetText(txtCardNumb);
    }

    @FindBy(xpath = "//table[1]/tbody/tr[4]/td[3]")
    WebElement txtPeserta;

    public String getTxtNamaPeserta(){
        return doGetText(txtPeserta);
    }

    @FindBy(xpath = "//table[1]/tbody/tr[6]/td[3]")
    WebElement txtStatus;

    public String getTxtStatus(){
        return doGetText(txtStatus);
    }

    @FindBy(xpath = "//table[1]/tbody/tr[7]/td[3]")
    WebElement txtNoPolis;

    public String getTxtNoPolis(){
        return doGetText(txtNoPolis);
    }

    @FindBy(xpath = "//table[1]/tbody/tr[8]/td[3]")
    WebElement txtPemegangPolis;

    public String getTxtPemegangPolis(){
        return doGetText(txtPemegangPolis);
    }

    @FindBy(xpath = "//table[2]/tbody/tr[1]/td[3]")
    WebElement txtManfaat;

    public String getTxtManfaat(){
        return doGetText(txtManfaat);
    }

    @FindBy(xpath = "//table[2]/tbody/tr[2]/td[3]")
    WebElement txtInformasiBiaya1;

    public String getTxtInformBiaya1(){
        return doGetText(txtInformasiBiaya1);
    }

    @FindBy(xpath = "//table[2]/tbody/tr[3]/td[3]")
    WebElement txtInformasiBiaya2;

    public String getTxtInformBiaya2(){
        return doGetText(txtInformasiBiaya2);
    }

    @FindBy(xpath = "//table[2]/tbody/tr[4]/td[3]")
    WebElement txtInformasiBiaya3;

    public String getTxtInformBiaya3(){
        return doGetText(txtInformasiBiaya3);
    }
}
