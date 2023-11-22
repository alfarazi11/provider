package page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TxtErrorPage extends BasePage{
    public TxtErrorPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
        super(driver, explicitWait);
        PageFactory.initElements(driver.get(),this);
    }

    @FindBy(xpath = "//p[.='Kode verifikasi tidak boleh kosong']")
    WebElement txtErrKodeNotNull;

    public boolean txtErrCaptchaNotNull() throws InterruptedException {
        Thread.sleep(1000);
        return txtErrKodeNotNull.isDisplayed();
    }

    @FindBy(xpath = "//p[contains(text(),'Kode verifikasi salah')]")
    WebElement txtKodeSalah;

    public boolean txtKodeSalah() throws InterruptedException {
        Thread.sleep(1000);
        return txtKodeSalah.isDisplayed();
    }

    @FindBy(xpath = "//li[.='Polis tidak aktif']")
    WebElement txtErrPolisInactive;

    public boolean txtErrPolisTidakAktifIsDisplayed(){
        waitForElementPresent(txtErrPolisInactive);
        if(txtErrPolisInactive.getText().contains("Polis tidak aktif")){
            return true;
        }return false;
    }

    @FindBy(xpath = "//li[.='Kepersertaan tidak aktif']")
    WebElement txtErrPesertaInactive;

    public boolean txtErrKepesertaanTidakAktifIsDisplayed(){
        waitForElementPresent(txtErrPesertaInactive);
        if(txtErrPesertaInactive.getText().contains("Kepersertaan tidak aktif")){
            return true;
        }return false;
    }

    @FindBy(xpath = "//li[.='Peserta tidak memiliki manfaat tersebut']")
    WebElement txtErrNotHaveBenefit;

    public boolean txtErrTidakMemilikiBenefitIsDisplayed(){
        waitForElementPresent(txtErrNotHaveBenefit);
        return txtErrNotHaveBenefit.isDisplayed();
    }

    @FindBy(xpath = "//p[.='Silakan Peserta menghubungi HRD Perusahaan untuk informasi lebih lanjut']")
    WebElement txtErrUnderCorporate;

    public boolean txtErrPolicyUnderCorporateIsDisplayed(){
        try {
            waitForElementPresent(txtErrUnderCorporate);
            txtErrUnderCorporate.isDisplayed();
            return true;
        }
        catch (NoSuchElementException e){
        }
        return false;

    }

    @FindBy(xpath = "//p[.='Silakan Peserta menghubungi Pihak Asuransi untuk informasi lebih lanjut']")
    WebElement txtErrIndividual;

    public boolean txtErrPolicyIndividualIsDisplayed(){
        try {
            waitForElementPresent(txtErrIndividual);
            txtErrIndividual.isDisplayed();
            return true;
        }
        catch (NoSuchElementException e){
        }
        return false;

    }

    @FindBy(xpath = "//li[.='Manfaat berlaku reimbursement']")
    WebElement txtErrBerlakuReimburse;

    public boolean txtErrBerlakuReimburseDisplayed(){
        try{waitForElementPresent(txtErrBerlakuReimburse);
            txtErrBerlakuReimburse.isDisplayed();
            return true;
        }
        catch (NoSuchElementException e){

        }return false;
    }

    @FindBy(xpath = "//p[(text()='Tanggal Lahir tidak sesuai dengan nomor kartu')]")
    WebElement txtErrDOBNotMacth;

    public boolean txtErrDOBNotMatchDisplayed(){
        try{waitForElementPresent(txtErrDOBNotMacth);
            txtErrDOBNotMacth.isDisplayed();
            return true;
        }
        catch (NoSuchElementException e){

        }return false;
    }

    @FindBy(xpath = "//li[(text()='Kartu Anda tidak berlaku di provider ini')]")
    WebElement txtErrTidakSesuaiLevelProvider ;

    public boolean txtErrProviderTidakSesuaiDisplayed(){
        waitForElementPresent(txtErrTidakSesuaiLevelProvider);
        if(doGetText(txtErrTidakSesuaiLevelProvider).contains("tidak berlaku di provider ini")){
            return true;
        }return false;
    }

    @FindBy(xpath = "//p[(text() = 'Sedang dalam proses penyelesaian Administrasi, sementara berlaku mekanisme REIMBURSEMENT.')]")
    WebElement txtErrPolisDalamPenyelesaianAdministrasi;

    public boolean txtErrProsesAdministrasiDisplayed(){
        waitForElementPresent(txtErrPolisDalamPenyelesaianAdministrasi);
        if(doGetText(txtErrPolisDalamPenyelesaianAdministrasi).contains("Silakan Peserta menghubungi HRD Perusahaan")){
            return true;
        }
        return false;
    }

    public boolean txtErrProsesAdministrasiIndividuDisplayed(){
        waitForElementPresent(txtErrPolisDalamPenyelesaianAdministrasi);
//        String txtErr = doGetText(txtErrPolisDalamPenyelesaianAdministrasi);
//        System.out.println(txtErr);
        if(doGetText(txtErrPolisDalamPenyelesaianAdministrasi).contains("Silakan Peserta menghubungi Pihak Asuransi")){
            return true;
        }
        return false;
    }


    @FindBy(xpath = "//p[(text() = 'Peserta sudah terdaftar untuk jenis perawatan ini')]")
    WebElement txtErrPesertaSudahTerdaftar;

    public boolean txtErrPesertaSudahTerdaftar(){
        waitForElementPresent(txtErrPesertaSudahTerdaftar);
        if(doGetText(txtErrPesertaSudahTerdaftar).contains("Peserta sudah terdaftar untuk jenis perawatan ini")){
            return true;
        }
        return false;
    }

    @FindBy(css = ".sc-hCcNSO")
    WebElement popupErr;

    public boolean popupErrIsDisplayed(){
        try {
            waitForElementPresent(popupErr);
            popupErr.isDisplayed();
            return true;
        }
        catch (NoSuchElementException e){
        }
        return false;
    }

    @FindBy(css = ".css-1k33q06")
    WebElement btnClosePopup;

    public void clickBtnClosePopup() throws InterruptedException {
        doClick(btnClosePopup);
    }
}
