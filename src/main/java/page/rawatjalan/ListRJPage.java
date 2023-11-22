package page.rawatjalan;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.BasePage;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class ListRJPage extends BasePage {
    public ListRJPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
        super(driver, explicitWait);
        PageFactory.initElements(driver.get(),this);
    }

    @FindAll({
            @FindBy(css = ".MuiButtonGroup-root > button:nth-of-type(2)"),
            @FindBy(css = ".MuiButton-sizeSmall[tabindex='0']")
    })
    WebElement btnNextPage;

    @FindAll({
            @FindBy(css = ".MuiButtonGroup-root > button:nth-of-type(1)"),
            @FindBy(css = ".MuiButton-sizeSmall[tabindex='0']")
    })
    WebElement btnPreviousPage;

    @FindBy(xpath = "//button[.='Pendaftaran Pasien']")
    WebElement btnPendafatranPasien;

    public void clickBtnPendaftaran() throws InterruptedException {
        waitForElementPresent(btnPendafatranPasien);
        doClick(btnPendafatranPasien);
    }

    @FindBy(xpath = "//div[@data-testid='btnShowFilter']")
    WebElement btnPencarian;

    public void clickPencarian() throws InterruptedException {
        doClick(btnPencarian);
    }

    @FindBy(xpath = "//img[@alt='Empty Image']")
    WebElement imgEmpty;

    public boolean imgEmptyIsDisplayed(){
        waitForElementPresent(imgEmpty);
        return imgEmpty.isDisplayed();
    }


    //Nomor Klaim
    @FindAll({@FindBy(xpath = "//table/tbody/tr/td[1]")})
    List<WebElement> txtNoKlaim;
    public void clickClaimNo() throws InterruptedException {
        waitForElementPresent(txtNoKlaim.get(0));
        Thread.sleep(2000);
        doClick(txtNoKlaim.get(0));
    }

    public String claimNo(){
        //return txtNoKlaim.getText();
        waitForElementPresent(txtNoKlaim.get(0));
        return doGetText(txtNoKlaim.get(0));
    }

    public boolean verifyFilterClaimNo(){
        for (int i=0; i<=txtNoKlaim.size()-1; i++) {
            waitForElementPresent(txtNoKlaim.get(i));
            if (doGetText(txtNoKlaim.get(i)).contains(claimNo())) {
                return true;
            }
        }return false;
    }

    @FindBy(xpath = "//input[@data-testid='colmnPenagihanKlaim']")
    WebElement colmnNoKlaim;

    public void fillNoKlaim(){
        doSetText(colmnNoKlaim,claimNo());
    }

    public void fillNoKlaimNeg(String numClaim){
        doSetText(colmnNoKlaim,numClaim);
    }

    public boolean claimNoIsCLear(){
        return colmnNoKlaim.isDisplayed();
    }

    //Waktu Pendaftaran
    @FindAll({@FindBy(xpath = "//table/tbody/tr/td[2]")})
    List<WebElement> txtRegDate;
    public String regDate(){
        waitForVisibility(txtRegDate.get(0));
        String date=  doGetText(txtRegDate.get(0));
//        String tgl = date.substring(0,2)+"-";
//        String bln = date.substring(3,5)+"-";
//        String thn = date.substring(6,10);
        String tgl = date.substring(0,3);
        String bln = date.substring(3,6);
        String thn = date.substring(6,10);
        String wktDaftar = tgl+bln+thn;
        return wktDaftar;
    }

    public boolean verifyTglPendaftaran(){
        for (int i=0; i<=txtRegDate.size()-1; i++) {
            waitForElementPresent(txtRegDate.get(i));
            if (doGetText(txtRegDate.get(i)).contains(regDate())) {
                return true;
            }
        }return false;
    }

    @FindBy(xpath = "//input[@value='' and @name='admissionDate'] ")
    WebElement colmRegDate;

    public void fillRegDate(){
        waitForElementPresent(colmRegDate);
        doSetText(colmRegDate,regDate());
    }

    public void fillRegDateNeg(String date){
        doSetText(colmRegDate,date);
    }

    public boolean RegDateIsCLear(){
        return colmRegDate.isDisplayed();
    }

    //No. Transaksi
    @FindAll({@FindBy(xpath = "//table/tbody/tr/td[3]")})
    List<WebElement> txtNoTransaksi;
    public String transactionNo(){
        waitForElementPresent(txtNoTransaksi.get(0));
        return doGetText(txtNoTransaksi.get(0));
    }

    public boolean verifyFilterTransaksiNo(){
        for (int i=0; i<=txtNoTransaksi.size()-1; i++){
            waitForVisibility(txtNoTransaksi.get(i));
            if(doGetText(txtNoTransaksi.get(i)).equalsIgnoreCase(transactionNo())){
                return true;
            }

        }
        return false;
    }

    @FindBy(xpath = "//input[@value='' and @name='transactionNo']")
    WebElement colmnNoTransaksi;

    public void fillNoTransaksi(){
        doSetText(colmnNoTransaksi,transactionNo());
    }

    public void fillNoTransaksiNeg(String noTrans){
        doSetText(colmnNoTransaksi,noTrans);
    }

    public boolean transNoIsCLear(){
        return colmnNoTransaksi.isDisplayed();
    }


    // Nomor Kartu
    @FindAll({@FindBy(xpath = "//table/tbody/tr/td[4]")})
    List<WebElement> txtNoKartu;
    public String cardNo(){
        waitForElementPresent(txtNoKartu.get(0));
        return doGetText(txtNoKartu.get(0));
    }

    public boolean verifyFilterCardNo(){
        for (int i=0; i<=txtNoKartu.size()-1; i++){
            waitForVisibility(txtNoKartu.get(i));
            if(doGetText(txtNoKartu.get(i)).equalsIgnoreCase(cardNo())){
                return true;
            }
        }   return false;
    }

    @FindBy(xpath = "//input[@value='' and @data-testid='colmnNoKartu']")
    WebElement colmNoKartu;

    public void fillNoKartu(){
        doSetText(colmNoKartu,cardNo());
    }

    public void fillNoKartuManual(String cardNo){
        waitForElementPresent(colmNoKartu);
        doSetText(colmNoKartu,cardNo);
    }
    public void fillNoKartuNeg(String cardNo){
        doSetText(colmNoKartu,cardNo);
    }

    public boolean cardNoIsCLear(){
        return colmNoKartu.isDisplayed();
    }

    //Nama Peserta
    @FindAll({@FindBy(xpath = "//table/tbody/tr/td[5]")})
    List<WebElement> txtNamaPeserta;

    public boolean verifyFilterPaticipateName(){
        for (int i=0; i<=txtNamaPeserta.size()-1; i++){
            waitForVisibility(txtNamaPeserta.get(i));
            if(doGetText(txtNamaPeserta.get(i)).equalsIgnoreCase(participantName())){
                return true;
            }
        }return false;
    }
    public String participantName(){
        waitForElementPresent(txtNamaPeserta.get(0));
        return doGetText(txtNamaPeserta.get(0));
    }

    @FindBy(xpath = "//input[@value=''and@name='memberName']")
    WebElement colmnNamaPeserta;
    public void fillNamaPeserta(){
        doSetText(colmnNamaPeserta,participantName());
    }

    public void fillNamaPesertaNeg(String name){
        doSetText(colmnNamaPeserta,name);
    }

    public boolean participateNameIsCLear(){
        return colmnNamaPeserta.isDisplayed();
    }

    @FindBy(xpath = "//button[@data-testid = 'btnCari']")
    WebElement btnCari;

    public void clickBtnCari() throws InterruptedException {
        doClick(btnCari);
    }

    @FindBy(xpath = "//button[(text() = 'Hapus')]")
    WebElement btnHapus;

    public void clickBtnHapus() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)driver.get();
        jse.executeScript("arguments[0].scrollIntoView(true)",btnPencarian);
        Thread.sleep(1000);
        doClick(btnHapus);
    }

    // Jenis Perawatan

    @FindBy(xpath = "//div[@data-testid='drpdownJenisPerawatan']")
    WebElement colmnPilihJenisPerawatan;

    public boolean jenisPerawatanIsCLear(){
        return colmnPilihJenisPerawatan.isDisplayed();
    }
    public void clickJenisPerawatan() throws InterruptedException {
        doClick(colmnPilihJenisPerawatan);
    }

    @FindBy(xpath = "//table/tbody/tr[1]/td[8]")
    WebElement txtBtnBatalkan;

    public void clickTxtBtnBatalkan() throws InterruptedException {
        doClick(txtBtnBatalkan);
    }

    public void scrollUntilTxtBtnBatalkan() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver.get();
        jse.executeScript("arguments[0].scrollIntoView(true)", txtBtnBatalkan);
        Thread.sleep(2000);
    }

    @FindBy(css = "[data-value='OP']")
    WebElement  dropDownRawatJalan;


    @FindBy(css = "[data-value='DT']")
    WebElement dropDownRawatGigi;

    @FindBy(css = "[data-value='GL']")
    WebElement dropDownKacamata;

    public void dropdownJenisPerawatan(JenisPerawatan jenisPerawatan) throws InterruptedException {
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
        }
    }

    @FindAll({@FindBy(xpath = "//table/tbody/tr/td[6]")})
    List<WebElement> txtJenisPerawatan;

    public boolean verifyFilterJenisPerawatanRJ(){
        for (int i=0; i<=txtJenisPerawatan.size()-1; i++){
            waitForVisibility(txtJenisPerawatan.get(i));
            if(doGetText(txtJenisPerawatan.get(i)).equalsIgnoreCase("Rawat Jalan")){
                return true;
            }
        }   return false;
    }

    public boolean verifyFilterJenisPerawatanKM(){
        for (int i=0; i<=txtJenisPerawatan.size()-1; i++){
            waitForVisibility(txtJenisPerawatan.get(i));
            if(doGetText(txtJenisPerawatan.get(i)).equalsIgnoreCase("kacamata")){
                return true;
            }
        }   return false;
    }

    public boolean verifyFilterJenisPerawatanRG(){
        for (int i=0; i<=txtJenisPerawatan.size()-1; i++){
            waitForVisibility(txtJenisPerawatan.get(i));
            if(doGetText(txtJenisPerawatan.get(i)).equalsIgnoreCase("Rawat Gigi")){
                return true;
            }
        }   return false;
    }

    // Status
    @FindBy(xpath = "//div[@data-testid='drpdownStatus']")
    WebElement colmnStatus;

    public boolean statusIsCLear(){
        return colmnStatus.isDisplayed();
    }
    public void clickStatus() throws InterruptedException {
        doClick(colmnStatus);
    }

    @FindBy(css = "[data-value='Pendaftaran Berhasil']")
    WebElement dropDownPendaftaranBerhasil;

    @FindBy(css = "[data-value='Pendaftaran Dibatalkan']")
    WebElement dropDownPendaftaranDibatalkan;

    @FindBy(css = "[data-value='Tagihan Selesai']")
    WebElement dropDownTagihanSelesai;
    public void dropdownStatus(Status status) throws InterruptedException {
        switch (status){
            case PENDAFTARANBERHASIL:
                doClick(dropDownPendaftaranBerhasil);
                break;
            case PENDAFTARANDIBATALKAN:
                doClick(dropDownPendaftaranDibatalkan);
                break;
            case TAGIHANSELESAI:
                doClick(dropDownTagihanSelesai);
                break;
        }
    }

    @FindAll({@FindBy(xpath = "//table/tbody/tr/td[7]")})
    List<WebElement> txtListStatus;

    public boolean verifyFilterStatusPendaftaranDibatalkan() {
        for (int i=0; i<=txtListStatus.size()-1; i++){
            waitForElementPresent(txtListStatus.get(i));
            if(doGetText(txtListStatus.get(i)).equalsIgnoreCase("Pendaftaran Dibatalkan")){
                return true;
            }

        }
        return false;
    }

    public boolean verifyFilterStatusPendaftaranBerhasil() {
        for (int i=0; i<=txtListStatus.size()-1; i++){
            waitForElementPresent(txtListStatus.get(i));
            if(doGetText(txtListStatus.get(i)).equalsIgnoreCase("Pendaftaran Berhasil")){
                return true;
            }

        }
        return false;
    }

    public boolean verifyFilterStatusTagihanSelesai() {
        for (int i=0; i<=txtListStatus.size()-1; i++){
            waitForElementPresent(txtListStatus.get(i));
            if(doGetText(txtListStatus.get(i)).equalsIgnoreCase("Tagihan Selesai")){
                return true;
            }
        }   return false;
    }

    @FindBy(xpath = "//table/tbody/tr[1]/td[7]")
    WebElement  txtStatus;

    public boolean verifyStatusPendaftaranBerhasil(){
            waitForElementPresent(txtStatus);
            if(doGetText(txtStatus).equalsIgnoreCase("Pendaftaran Berhasil")){
                return true;
            }

        return false;
    }

    public boolean verifyStatusTagihanSelesai(){
        waitForElementPresent(txtStatus);
        if(doGetText(txtStatus).contains("Tagihan Selesai")){
            return true;
        }

        return false;
    }

    public boolean verifyStatusPendaftaranDibatalkan(){
        if(doGetText(txtStatus).contains("Pendaftaran Dibatalkan")){
            return true;
        }

        return false;
    }

    public enum JenisPerawatan{
        RAWATJALAN,
        RAWATGIGI,
        KACAMATA,
    }

    public enum Status{
        PENDAFTARANBERHASIL,
        PENDAFTARANDIBATALKAN,
        TAGIHANSELESAI,
    }


}
