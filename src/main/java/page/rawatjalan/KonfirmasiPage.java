package page.rawatjalan;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.BasePage;

import java.util.List;

public class KonfirmasiPage extends BasePage {
    public KonfirmasiPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
        super(driver, explicitWait);
        PageFactory.initElements(driver.get(),this);
    }

    @FindBy(xpath = "//button[(@data-testid='btnKirim')]")
    WebElement btnKirimKonfirmasi;

    public void scrollUntilBtnKirim() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver.get();
        js.executeScript("arguments[0].scrollIntoView();",btnKirimKonfirmasi);
        Thread.sleep(2000);
    }

    public void clickBtnKirimKonfirmasi() throws InterruptedException {
        doClick(btnKirimKonfirmasi);
    }

    @FindBy(css = "//button[(@data-testid='btnKembali')]")
    WebElement btnKembaliKonfirmasi;

    public void clickBtnKembaliOnKonfirmasi() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver.get();
        js.executeScript("arguments[0].scrollIntoView();",btnKembaliKonfirmasi);
        Thread.sleep(2000);
        doClick(btnKembaliKonfirmasi);
    }

    @FindBy(xpath = "//*[(@data-testid='captcha-input')]")
    WebElement colmnCaptcha;

    public void inputCaptcha(String captcha)  {
        doSetText(colmnCaptcha, captcha);
    }

    @FindBy(xpath = "//button[.='Batalkan Perawatan']")
    WebElement btnBatalkanPerawatan;

    public void clickBtnBatalkanPerawatan() throws InterruptedException {
        doClick(btnBatalkanPerawatan);
    }

    public void scrollUntilBtnBatalkanPerawatan() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)driver.get();
        jse.executeScript("arguments[0].scrollIntoView(true)",btnBatalkanPerawatan);
        Thread.sleep(2000);
    }

    @FindBy(id = "alasanDibatalkanOutpatient")
    WebElement colmnAlasanDibatalkanOutpatient;

    public void inputAlasanDibatalkanOutpatient(String alasan){
        doSetText(colmnAlasanDibatalkanOutpatient,alasan);
        colmnAlasanDibatalkanOutpatient.sendKeys(Keys.ENTER);
    }

    @FindBy(xpath = "//div[(text() = 'No. Transaksi')]")
    WebElement txtNoTransaksi;

    public boolean verifyNoTransaksi(){
        waitForElementPresent(txtNoTransaksi);
        if(doGetText(txtNoTransaksi).contains("No")){
            return true;
        }return false;

    }

    @FindBy(xpath = "//input[@id='alasanDibatalkanInpatient']")
    WebElement colmnAlasanDibatalkanInpatient;

    public void inputAlasanDibatalkanInpatient(String alasan){
        waitForElementPresent(colmnAlasanDibatalkanInpatient);
        doSetText(colmnAlasanDibatalkanInpatient,alasan);
        colmnAlasanDibatalkanInpatient.sendKeys(Keys.ENTER);
    }

    @FindBy(xpath = "//button[.='Batalkan Transaksi']")
    WebElement btnBatalkanTransaksi;

    public void clickBtnBatalkanTransaksi() throws InterruptedException {
        doClick(btnBatalkanTransaksi);
    }

    @FindBy(xpath = "//div[.='Nama Peserta']")
    WebElement txtNamaPeserta;

    @FindBy(xpath = "//input[@data-testid='text-pic']")
    WebElement colmnPIC;

    public void inputColmnPIC(String PIC){
        waitForElementPresent(txtNamaPeserta);
        doSetText(colmnPIC,PIC);
    }

    @FindBy(xpath = "//input[@name='division']")
    WebElement colmnBagian;

    public void inputColmnBagian(String Bagian){
        doSetText(colmnBagian,Bagian);
    }

    @FindBy(xpath = "//textarea[@name='reasonOptional']")
    WebElement colmnAlasan;

    public void inputColmnAlasan(String Alasan){
        doSetText(colmnAlasan,Alasan);
    }

    @FindBy(xpath = "//*[(@data-testid='btnYaDaftarkanPasien')]")
    WebElement btnYa;

    public void scrollUntilBtnYa() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)driver.get();
        jse.executeScript("arguments[0].scrollIntoView(true)",btnYa);
        Thread.sleep(2000);
    }

    public void clickBtnYa() throws InterruptedException {
        doClick(btnYa);
    }

    @FindBy(xpath = "//*[(@data-testid='btnKembaliDaftarkanPasien')]")
    WebElement btnKembali;

    public void clickBtnKembali() throws InterruptedException {
        doClick(btnKembali);
    }

    @FindAll({@FindBy(xpath = "//div/div[contains(@class,'css-1d3bbye')]/div[contains(@class,'css-45ujxc')]/p")})
    List<WebElement> txtDataPasien;

    public String getTxtCardNo(){
        return doGetText(txtDataPasien.get(0));
    }

    public String getTxtNamaPeserta(){
        return doGetText(txtDataPasien.get(1));
    }

    public String getTxtTglLahir(){
        return doGetText(txtDataPasien.get(2));
    }

    public String getTxtNamaKaryawan(){
        return doGetText(txtDataPasien.get(3));
    }

    public String getTxtStatus(){
        return doGetText(txtDataPasien.get(4));
    }

    public String getTxtPemegangPolis(){
        return doGetText(txtDataPasien.get(5));
    }

    public String getTxtJnsPerawatan(){
        return doGetText(txtDataPasien.get(6));
    }


}
