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

public class ListRIPage extends BasePage {
    public ListRIPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
        super(driver, explicitWait);
        PageFactory.initElements(driver.get(), this);
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

    @FindBy(xpath = "//button[@data-testid='btnPendaftaranPasien']")
    WebElement btnPendafatranPasien;

    public void clickBtnPendaftaran() throws InterruptedException {
        doClick(btnPendafatranPasien);
    }

    @FindBy(xpath = "//div[@data-testid='btnShowFilter']")
    WebElement btnPencarian;

    public void clickPencarian() throws InterruptedException {
        waitForElementPresent(btnPencarian);
        doClick(btnPencarian);
    }

    @FindBy(xpath = "//img[@alt='Empty Image']")
    WebElement imgEmpty;

    public boolean imgEmptyIsDisplayed(){
        waitForElementPresent(imgEmpty);
        return imgEmpty.isDisplayed();
    }


    //Nomor Klaim
    @FindAll({@FindBy(xpath = "//button[contains (@data-testid,'claimNumbOnTable')]")})
    List<WebElement> txtNoKlaim;
    public void clickClaimNo() throws InterruptedException {
        doClick(txtNoKlaim.get(0));
    }

    public boolean verifyFilterClaimNo(){
        for (int i=0; i<=txtNoKlaim.size()-1; i++) {
            waitForElementPresent(txtNoKlaim.get(i));
            if (doGetText(txtNoKlaim.get(i)).contains(claimNo())) {
                return true;
            }
        }return false;
    }

    public String claimNo(){
        waitForElementPresent(txtNoKlaim.get(0));
        return doGetText(txtNoKlaim.get(0));
    }

    @FindBy(xpath = "//input[@data-testid='colmnPenagihanKlaim']")
    WebElement colmnNoKlaim;

    public void fillNoKlaim(){
        waitForElementPresent(colmnNoKlaim);
        doSetText(colmnNoKlaim,claimNo());
    }

    public void fillNoKlaimNeg(String numClaim){
        doSetText(colmnNoKlaim,numClaim);
    }

    public boolean claimNoIsCLear(){
        return colmnNoKlaim.isDisplayed();
    }

    //Waktu Pendaftaran
    @FindAll({@FindBy(xpath = "//table/tbody/tr/td[2][contains(@class,'css-1pmp1kq')]")})
    List<WebElement> txtRegDate;
    public String regDate(){
        waitForVisibility(txtRegDate.get(0));
        String date=  doGetText(txtRegDate.get(0));
        String tgl = date.substring(0,2)+"-";
        String bln = date.substring(3,5)+"-";
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
        doSetText(colmRegDate,regDate());
    }

    public void fillRegDateNeg(String date){
        waitForElementPresent(colmRegDate);
        doSetText(colmRegDate,date);
    }

    public boolean RegDateIsCLear(){
        return colmRegDate.isDisplayed();
    }

    //No. Transaksi
    @FindAll({@FindBy(xpath = "//table/tbody/tr/td[3][contains(@class,'css-1pmp1kq')]")})
    List<WebElement> txtNoTransaksi;
    public String transactionNo(){
        return doGetText(txtNoTransaksi.get(0));
    }

    public boolean verifyFilterTransaksiNo(){
        for (int i=0; i<=txtNoTransaksi.size()-1; i++){
            waitForVisibility(txtNoTransaksi.get(i));
            if(doGetText(txtNoTransaksi.get(i)).equalsIgnoreCase(transactionNo())){
                return true;
            }
        }   return false;
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
    @FindAll({@FindBy(xpath = "//table/tbody/tr/td[4][contains(@class,'css-1pmp1kq')]")})
    List<WebElement> txtNoKartu;
    public String cardNo(){
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

    @FindBy(xpath = "//input[@value='' and @placeholder='No. Kartu']")
    WebElement colmNoKartu;

    public void fillNoKartuManual(String cardNo){
        waitForElementPresent(colmNoKartu);
        doSetText(colmNoKartu,cardNo);
    }

    public void fillNoKartu(){
        doSetText(colmNoKartu,cardNo());
    }
    public void fillNoKartuNeg(String cardNo){
        doSetText(colmNoKartu,cardNo);
    }

    public boolean cardNoIsCLear(){
        return colmNoKartu.isDisplayed();
    }

    //Nama Peserta

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

    @FindAll({@FindBy(xpath = "//table/tbody/tr/td[5][contains(@class,'css-1pmp1kq')]")})
    List<WebElement> txtNamaPeserta;
    public String participantName(){
        return doGetText(txtNamaPeserta.get(0));
    }

    public boolean verifyFilterPaticipateName(){
        for (int i=0; i<=txtNamaPeserta.size()-1; i++){
            waitForVisibility(txtNamaPeserta.get(i));
            if(doGetText(txtNamaPeserta.get(i)).equalsIgnoreCase(participantName())){
                return true;
            }
        }return false;
    }

    @FindBy(xpath = "//button[(@data-testid = 'btnCari')]")
    WebElement btnCari;

    public void clickBtnCari() throws InterruptedException {
        doClick(btnCari);
    }

    @FindBy(xpath = "//button[(@data-testid = 'btnHapus')]")
    WebElement btnHapus;

    public void clickBtnHapus() throws InterruptedException {
        doClick(btnHapus);
    }

    // Jenis Perawatan

    @FindBy(xpath = "//div[@data-testid='drpdownJenisPerawatan']")
    WebElement colmnPilihJenisPerawatan;
    public void clickJenisPerawatan() throws InterruptedException {
        doClick(colmnPilihJenisPerawatan);
    }

    public boolean jenisPerawatanIsCLear(){
        return colmnPilihJenisPerawatan.isDisplayed();
    }

    @FindBy(xpath = "//table/tbody/tr[1]/td[8]")
    WebElement txtBtnBatalkan;

    public void clickTxtBtnBatalkan() throws InterruptedException {
        doClick(txtBtnBatalkan);
    }

    public void scrollUntilTxtBtnBatalkan() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)driver.get();
        jse.executeScript("arguments[0].scrollIntoView(true)",txtBtnBatalkan);
        Thread.sleep(2000);
    }

    @FindBy(css = ".css-19bb58m")
    WebElement colmnAlasanDibatalkan;

    public void inputAlasanDibatalkan(String alasan){
        doSetText(colmnAlasanDibatalkan,alasan);
        colmnAlasanDibatalkan.sendKeys(Keys.ENTER);
    }

    @FindBy(xpath = "//table/tbody/tr[1]/td[8]")
    WebElement btnBatalkanOnTable;

    public void clickBtnBatalkanPerawatan() throws InterruptedException {
        doClick(btnBatalkanOnTable);
    }

    @FindBy(xpath = "//table/tbody/tr[1]/td[7]")
    WebElement txtStatusPendaftaran;

    public String actualTxtStatusPendaftaran(){
        return doGetText(txtStatusPendaftaran);
    }

    @FindBy(css = "[data-value='IP']")
    WebElement  dropDownRawatInap;

    @FindBy(css = "[data-value='MA']")
    WebElement dropDownRawatBersalin;
    public void dropdownJenisPerawatan(ListRIPage.JenisPerawatan jenisPerawatan) throws InterruptedException {
        switch (jenisPerawatan) {
            case RAWATINAP:
                doClick(dropDownRawatInap);
                break;
            case RAWATBERSALIN:
                doClick(dropDownRawatBersalin);
                break;
        }
    }

    @FindAll({@FindBy(xpath = "//table[@class='MuiTable-root css-7upgu4']//tr/td[.='Rawat Inap']")})
    List<WebElement> txtJenisPerawatanRI;

    public boolean verifyFilterJenisPerawatanRI(){
        for (int i = 0; i<= txtJenisPerawatanRI.size(); i++){
            waitForVisibility(txtJenisPerawatanRI.get(i));
            if(doGetText(txtJenisPerawatanRI.get(i)).equalsIgnoreCase("Rawat Inap")){
                return true;
            }
        }   return false;
    }

    @FindAll({@FindBy(xpath = "//table[@class='MuiTable-root css-7upgu4']//tr/td[.='Rawat Bersalin']")})
    List<WebElement> txtJenisPerawatanRB;

    public boolean verifyFilterJenisPerawatanRB(){
        for (int i = 0; i<= txtJenisPerawatanRB.size(); i++){
            waitForVisibility(txtJenisPerawatanRB.get(i));
            if(doGetText(txtJenisPerawatanRB.get(i)).equalsIgnoreCase("Rawat Bersalin")){
                return true;
            }
        }   return false;
    }

    // Status

    @FindBy(xpath = "//div[@data-testid='drpdownStatus']")
    WebElement colmnStatus;
    public void clickStatus() throws InterruptedException {
        doClick(colmnStatus);
    }

    public boolean statusIsCLear(){
        return colmnStatus.isDisplayed();
    }

    @FindBy(css = "[data-value='Pendaftaran Berhasil']")
    WebElement dropDownPendaftaranBerhasil;

    @FindBy(css = "[data-value='Pendaftaran Dibatalkan']")
    WebElement dropDownPendaftaranDibatalkan;

    @FindBy(css = "[data-value='Perawatan Selesai']")
    WebElement dropDownTagihanSelesai;
    public void dropdownStatus(ListRIPage.Status status) throws InterruptedException {
        switch (status){
            case PENDAFTARANBERHASIL:
                doClick(dropDownPendaftaranBerhasil);
                break;
            case PENDAFTARANDIBATALKAN:
                doClick(dropDownPendaftaranDibatalkan);
                break;
            case PERAWATANSELESAI:
                doClick(dropDownTagihanSelesai);
                break;
        }
    }

    @FindBy(xpath = "//table/tbody/tr[1]/td[7][contains(@class,'css-1pmp1kq')]")
    WebElement  txtStatus;

    public boolean verifyStatusPendaftaranBerhasil(){
        waitForElementPresent(txtStatus);
        if(doGetText(txtStatus).equalsIgnoreCase("Pendaftaran Berhasil")){
            return true;
        }

        return false;
    }

    @FindAll({@FindBy(xpath = "//table/tbody/tr/td[7]")})
    List<WebElement> txtListStatus;

    public boolean verifyFilterStatus(){
        for (int i=0; i<=txtListStatus.size()-1; i++){
            waitForElementPresent(txtListStatus.get(i));
            if(doGetText(txtListStatus.get(i)).equalsIgnoreCase("Pendaftaran Berhasil")){
                return true;
            }

        }
        return false;
    }

    public boolean verifyStatusPendaftaranDibatalkan(){
        for (int i=0; i<=txtListStatus.size()-1; i++){
            waitForElementPresent(txtListStatus.get(i));
            if(doGetText(txtListStatus.get(i)).equalsIgnoreCase("Pendaftaran Dibatalkan")){
                return true;
            }
        } return false;
    }

    public boolean verifyFilterStatusPendaftaranBerhasil() {
        for (int i=0; i<=txtListStatus.size()-1; i++){
            waitForElementPresent(txtListStatus.get(i));
            if(doGetText(txtListStatus.get(i)).equalsIgnoreCase("Pendaftaran Berhasil")){
                return true;
            }
        }   return false;
    }

    public boolean verifyFilterStatusPerawatanSelesai() {
        for (int i=0; i<=txtListStatus.size()-1; i++){
            waitForElementPresent(txtListStatus.get(i));
            if(doGetText(txtListStatus.get(i)).equalsIgnoreCase("Perawatan Selesai")){
                return true;
            }
        }   return false;
    }

    public enum JenisPerawatan{
        RAWATINAP,
        RAWATBERSALIN,
    }

    public enum Status{
        PENDAFTARANBERHASIL,
        PENDAFTARANDIBATALKAN,
        PERAWATANSELESAI,
    }
}
