package page.rawatinap;

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

public class KonfirmasiRIPage extends BasePage {
    public KonfirmasiRIPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
        super(driver, explicitWait);
        PageFactory.initElements(driver.get(),this);
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

    @FindBy(xpath = "//input[@id='alasanDibatalkanInpatient']")
    WebElement colmnAlasanDibatalkanInpatient;

    public void inputAlasanDibatalkanInpatient(String alasan){
        doSetText(colmnAlasanDibatalkanInpatient,alasan);
        colmnAlasanDibatalkanInpatient.sendKeys(Keys.ENTER);
    }

    @FindBy(xpath = "//div[(text() = 'No. Transaksi')]")
    WebElement txtNoTransaksi;

    public boolean verifyNoTransaksi(){
        waitForElementPresent(txtNoTransaksi);
        if(doGetText(txtNoTransaksi).contains("No")){
            return true;
        }return false;

    }

    @FindBy(xpath = "//*[(@data-testid='captcha-input')]")
    WebElement colmnCaptcha;
    public void inputCaptcha(String captcha)  {
        doSetText(colmnCaptcha, captcha);
    }

    @FindBy(xpath = "//div[contains(@class,'css-1d3bbye')]//div/p[.='7901072300000007']")
    WebElement txtNoKartu;

    public boolean verifyNoKartu(){
        if(doGetText(txtNoKartu).equalsIgnoreCase("7901072300000007")){
            return true;
        }return false;
    }

    @FindBy(xpath = "//div[contains(@class,'css-1d3bbye')]//div/p[.='06-08-1989']")
    WebElement txtTglLahir;

    public boolean verifyTglLahir(){
        if(doGetText(txtTglLahir).equalsIgnoreCase("06-08-1989")){
            return true;
        }return false;
    }

    @FindAll({@FindBy(xpath = "//div[contains(@class,'css-1d3bbye')]//div/p[contains(text(),'TESTING TPA INDIVIDU 130723')]")})
    List<WebElement> txtNama;

    public boolean verifyNamaPeserta(){
        if(doGetText(txtNama.get(0)).equalsIgnoreCase("TESTING TPA INDIVIDU 130723E")){
            return true;
        }return false;
    }

    public boolean verifyNamaKaryawan(){
        if(doGetText(txtNama.get(1)).equalsIgnoreCase("TESTING TPA INDIVIDU 130723E")){
            return true;
        }return false;
    }

    public boolean verifyNamaPemegangPolis(){
        if(doGetText(txtNama.get(2)).equalsIgnoreCase("TESTING TPA INDIVIDU 130723")){
            return true;
        }return false;
    }

    @FindBy(xpath = "//div[contains(@class,'css-1d3bbye')]//div/p[.='KARYAWAN']")
    WebElement txtStatus;

    public boolean verifyStatus(){
        if(doGetText(txtStatus).equalsIgnoreCase("KARYAWAN")){
            return true;
        }return false;
    }

    @FindBy(xpath = "//div[contains(@class,'css-1d3bbye')]//div/p[.='Rawat Inap']")
    WebElement txtJnsPerwtan;

    public boolean verifyJnsPerwtan(){
        if(doGetText(txtJnsPerwtan).equalsIgnoreCase("Rawat Inap")){
            return true;
        }return false;
    }

}
