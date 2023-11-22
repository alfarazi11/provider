package page.rawatinap;

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

public class PendaftaranRIPage extends BasePage {
    public PendaftaranRIPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
        super(driver, explicitWait);
        PageFactory.initElements(driver.get(),this);
    }

    @FindBy(xpath = "//input[@data-testid='colmnKartuPeserta']")
    WebElement colmNoKartu;

    @FindBy(name = "dob")
    WebElement colmDOB;

    @FindBy(css = ".MuiSelect-select")
    WebElement colmnJenisPerawatan;

    @FindBy(css = "[data-value='IP']")
    WebElement dropDownRawatInap;

    @FindBy(css = "[data-value='MA']")
    WebElement dropDownRawatBersalin;

    @FindBy(xpath = "//button[@data-testid = 'btnCariDataPasien']")
    WebElement btnCari;

    @FindBy(xpath = "//button[@data-testid='btnDaftarkanPasien']")
    WebElement btnDaftarkan;

    @FindBy(xpath = "//button[@data-testid='btnTutupCetakStruk']")
    WebElement btnTutup;

    @FindAll({@FindBy(xpath = "//p[contains(text(),'USD')]")})
    List<WebElement> txtContainUSD;

    @FindBy(xpath = "//*[(@data-testid='btnYaDaftarkanPasien')]")
    WebElement btnYa;

    @FindBy(css = "[aria-labelledby=':r99:'] .MuiButton-outlined")
    WebElement btnKembali;

    @FindBy(xpath = "//p[contains(text(),'Silakan isi kolom wajib ini')]")
    WebElement txtColmNoKartuMandatory;

    @FindBy(xpath = "//span[contains(text(),'Silakan isi kolom wajib ini')]")
    WebElement txtColmTglLhirMandatory;

    @FindBy(xpath = "//p[contains(text(),'Silakan pilih item dalam daftar')]")
    WebElement txtColmJnsPerwtanMandatory;

    @FindAll({@FindBy(xpath = "//div[contains(@class,'css-1t9m8lh')]/div[1]/div[1]/div[3]")})
    List<WebElement> txtNama;

    @FindAll({@FindBy(xpath = "//div[contains(@class,'css-1t9m8lh')]/div[1]/div[2]/div[3]")})
    List<WebElement> txtJnsKelmin;

    @FindBy(xpath = "//div[1]/div[1]/div[1]/div[3]/div[3]")
    WebElement txtTglLhr;

    @FindBy(xpath = "//div[1]/div[1]/div[1]/div[5]/div[3]")
    WebElement txtStatus;

    @FindBy(xpath = "//div[1]/div[1]/div[2]/div[1]/div[3]")
    WebElement txtNmrKrt;

    @FindBy(xpath = "//div[1]/div[1]/div[2]/div[2]/div[3]")
    WebElement txtNmrPolis;

    @FindBy(xpath = "//div[1]/div[1]/div[2]/div[3]/div[3]")
    WebElement txtNamaPemegangPolis;

    @FindBy(xpath = "//div[1]/div[1]/div[2]/div[4]/div[3]")
    WebElement txtPayor;

    @FindBy(xpath = "//div[2]/div[1]/div[1]/div[1]/div[3]")
    WebElement txtInformManfaat;

    @FindBy(xpath = "//div[2]/div[1]/div[1]/div[2]/div[3]")
    WebElement txtInformBiaya1;

    @FindBy(xpath = "//div[2]/div[1]/div[1]/div[3]/div[3]")
    WebElement txtInformBiaya2;

    @FindBy(xpath = "//div[2]/div[1]/div[1]/div[4]/div[3]")
    WebElement txtInformBiaya3;

    @FindBy(xpath = "//div[2]/div[1]/div[1]/div[5]/div[3]")
    WebElement txtInformBiaya4;

    @FindBy(xpath = "//div[2]/div[1]/div[1]/div[6]/div[3]")
    WebElement txtInformBiaya5;

    @FindBy(xpath = "//div[2]/div[1]/div[2]/div[1]/div[3]")
    WebElement txtInformBiaya6;

    @FindBy(xpath = "//div[2]/div[1]/div[2]/div[2]/div[3]")
    WebElement txtInformBiaya7;

    @FindBy(xpath = "//div[2]/div[1]/div[2]/div[3]/div[3]")
    WebElement txtInformBiaya8;

    @FindBy(xpath = "//div[2]/div[1]/div[2]/div[4]/div[3]")
    WebElement txtInformBiaya9;

    @FindBy(xpath = "//div[2]/div[1]/div[2]/div[5]/div[3]")
    WebElement txtInformBiaya10;

    @FindAll({@FindBy(xpath = "//div[contains(text(),'USD')]")})
    List<WebElement> txtUSD;

    public boolean verifyTxtUSD(){
        for (int i = 0; i < txtUSD.size(); i++) {
            if (txtUSD.get(i).getText().contains("USD")) {
                return true;
            }
        }return false;
    }


    public String getTxtInformBiaya1(){
        return doGetText(txtInformBiaya1);
    }

    public String getTxtInformBiaya2(){
        return doGetText(txtInformBiaya2);
    }

    public String getTxtInformBiaya3(){
        return doGetText(txtInformBiaya3).replaceAll("[*]","");
    }

    public String getTxtInformManfaat(){
        return doGetText(txtInformManfaat);
    }

    public String getTxtNama(){
        return doGetText(txtNama.get(0));
    }

    public String getTxtJnsKlmn(){
        return doGetText(txtJnsKelmin.get(0));
    }

    public String getTxtTglLhr() {
        return doGetText(txtTglLhr);
    }

    public String getTxtStatus(){
        return doGetText(txtStatus);
    }

    public String getTxtNmrKart(){
        return doGetText(txtNmrKrt);
    }

    public String getTxtNmrPolis(){
        return doGetText(txtNmrPolis);
    }

    public String getTxtNamaPemegangPolis(){
        return doGetText(txtNamaPemegangPolis);
    }

    public String getTxtPayor(){
        return doGetText(txtPayor);
    }

    public void inputCardNum(String cardNum) {
        doSetText(colmNoKartu,cardNum);
    }

    public void inputDOB(String dob){
        doSetText(colmDOB,dob);
    }

    public void clickJenisPerawatan() throws InterruptedException {
        doClick(colmnJenisPerawatan);
    }

    public void clickBtnCariDataPasien() throws InterruptedException {
        doClick(btnCari);
    }

    public boolean verifyColmnNoCardMandatory(){
        if(doGetText(txtColmNoKartuMandatory).equalsIgnoreCase("Silakan isi kolom wajib ini")){
            return true;
        }return false;
    }

    public boolean verifyColmnTglLhrMandatory(){
        if(doGetText(txtColmTglLhirMandatory).equalsIgnoreCase("Silakan isi kolom wajib ini")){
            return true;
        }return false;
    }

    public boolean verifyColmnJnsPrwtanMandatory(){
        if(doGetText(txtColmJnsPerwtanMandatory).equalsIgnoreCase("Silakan pilih item dalam daftar")){
            return true;
        }return false;
    }

    public void fillJenisPerawatan(PendaftaranRIPage.JenisPerawatan jenisPerawatan) throws InterruptedException {
        switch (jenisPerawatan){
            case RAWATINAP:
                doClick(dropDownRawatInap);
                break;
            case RAWATBERSALIN:
                doClick(dropDownRawatBersalin);
                break;
        }
    }

    public enum JenisPerawatan{
        RAWATINAP,
        RAWATBERSALIN,
    }

    public void scrollUntilBtnDaftarkan()  {
        try {
            JavascriptExecutor jse = (JavascriptExecutor)driver.get();
            jse.executeScript("arguments[0].scrollIntoView(true)",btnDaftarkan);
            Utility.hardWait(2);
        }catch (Exception e){}
    }

    public void clickBtnDaftarkan() throws InterruptedException {
        doClick(btnDaftarkan);
//        try {
//            doClick(btnDaftarkan);
//        }catch (Exception e){
//            JavascriptExecutor executor = (JavascriptExecutor) driver.get();
//            executor.executeScript("arguments[0].click();", btnDaftarkan);
//        }
    }

    public void clickBtnTutup() throws InterruptedException {
        doClick(btnTutup);
    }

    public boolean verifyTxtUsd(){
        for(int i=0; i<=txtContainUSD.size(); i++){
            waitForElementPresent(txtContainUSD.get(i));
            if(doGetText(txtContainUSD.get(i)).contains("USD")){
                return true;
            }
        }return false;
    }

    public void clickBtnYa() throws InterruptedException {
        doClick(btnYa);
    }

    public void scroolUntilBtnYa()  {
        JavascriptExecutor jse = (JavascriptExecutor)driver.get();
        jse.executeScript("arguments[0].scrollIntoView(true)",btnYa);
        Utility.hardWait(2);
    }

}

