package page.penagihanklaim;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.BasePage;
import page.pengesahantagihan.ListPengesahanTagihanPage;
import utils.Utility;

public class PenagihanKlaimPage extends BasePage {
    private String pathUploadStg = System.getProperty("user.dir") + "\\data\\DOC_CLAIM.pdf";
    private String pathUploadLive = System.getProperty("user.dir") + "/data/DOC_CLAIM.pdf";
    public PenagihanKlaimPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
        super(driver, explicitWait);
        PageFactory.initElements(driver.get(),this);
    }




    @FindBy(xpath = "//button[(@data-testid='btnKembali')]")
    WebElement btnKembali;

    public void clickBtnKembali() throws InterruptedException {
        doClick(btnKembali);
    }

    @FindBy(xpath = "//button[(@data-testid='btnBulkUpload')]")
    WebElement btnBulkUpload;

    public void clickBtnBulkUpload() throws InterruptedException {
        doClick(btnBulkUpload);
    }

    @FindBy(xpath = "//div[(@data-testid='btnShowFilter')]")
    WebElement btnShowFilter;

    public void clickBtnPencarian() throws InterruptedException {
//        waitForElementPresent(btnShowFilter);
        doClick(btnShowFilter);
    }

    @FindBy(xpath = "//input[(@data-testid='colmnNoKartu')]")
    WebElement colmnNoKartu;

    public void inputNomorKartu(String noKartu){
        waitForElementPresent(colmnNoKartu);
        doSetText(colmnNoKartu,noKartu);
    }

    @FindBy(xpath = "//button[@data-testid='btnCari']")
    WebElement btnCari;

    public void clickBtnCari() throws InterruptedException {
        doClick(btnCari);
    }

    @FindBy(xpath = "//table/tbody/tr[1]/td[1]/span/input")
    WebElement checkList;

    public void clickChekclist() {
//        doClick(checkList);
        Utility.hardWait(2);
        checkList.click();
    }

    @FindBy(xpath = "//button[(@data-testid='btnLengkapiKlaim')]")
    WebElement btnLengkapiKlaim;


    public void clickBtnLengkapiKlaim() throws InterruptedException {
        doClick(btnLengkapiKlaim);
    }

    @FindBy(xpath = "//input[(@data-testid='colmnNoInvoice')]")
    WebElement colmnNoInvoice;

    public void inputNoInvoice(String noInvoice){
        doSetText(colmnNoInvoice,noInvoice);
    }

    @FindBy(name = "amount")
    WebElement colmnNominalInvoice;

    public void inputNominalInvoice(String nominalInvoice){
        doSetText(colmnNominalInvoice,nominalInvoice);
    }

    @FindBy(name = "picEmail")
    WebElement colmnEmailPIC;
    public void inputEmailPIC(String email){
        doSetText(colmnEmailPIC,email);
        colmnEmailPIC.sendKeys(Keys.SPACE);
    }

    @FindBy(xpath = "//input[@type='file']")
    WebElement btnUploadFile;

    public void uploadDoc() {
        btnUploadFile.sendKeys(pathUploadLive);
    }

    @FindBy(xpath = "//button[(@data-testid='btnKirim')]")
    WebElement btnKirim;
    public void clickBtnKirim() throws InterruptedException {
        doClick(btnKirim);
    }

    @FindBy(xpath = "//button[(text()='Proses')]")
    WebElement btnProses;

    public void clickBtnProses() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver.get();
        js.executeScript("arguments[0].scrollIntoView(true)",btnProses);
        Utility.hardWait(2);
        doClick(btnProses);
    }

    @FindBy(xpath = "//table/tbody/tr[1]/td[8]")
    WebElement txtStatusDoc;

    public Boolean verifyStatusDokumen(){
        String status = doGetText(txtStatusDoc);
        System.out.println(status);
        if(doGetText(txtStatusDoc).equalsIgnoreCase("Dokumen Terkirim")){

            return true;
        }
        return false;
    }

    @FindBy(xpath = "//div[@data-testid='drpdownJenisPerawatan']")
    WebElement colmnPilihJenisPerawatan;

    public void clickJenisPerawatan() throws InterruptedException {
        doClick(colmnPilihJenisPerawatan);
    }

    @FindBy(css = "[data-value='MA']")
    WebElement dropDownRawatBersalin;

    @FindBy(css = "[data-value='IP']")
    WebElement dropDownRawatInap;

    @FindBy(css = "[data-value='GL']")
    WebElement dropDownKacamata;

    @FindBy(css = "[data-value='OP']")
    WebElement  dropDownRawatJalan;

    @FindBy(css = "[data-value='DT']")
    WebElement dropDownRawatGigi;

    public void dropdownJenisPerawatan(PenagihanKlaimPage.JenisPerawatan jenisPerawatan) throws InterruptedException {
        switch (jenisPerawatan){
            case RAWATJALAN:
                doClick(dropDownRawatJalan);
                break;
            case RAWATGIGI:
                doClick(dropDownRawatGigi);
                break;
            case KACAMATA:
                doClick(dropDownKacamata);
                break;
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

        RAWATJALAN,
        RAWATGIGI,
        KACAMATA,
    }

}
