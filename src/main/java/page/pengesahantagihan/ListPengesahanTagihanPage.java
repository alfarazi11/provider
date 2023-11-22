package page.pengesahantagihan;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.BasePage;
import page.CommonPage;

import java.util.List;

public class ListPengesahanTagihanPage extends BasePage {

    CommonPage commonPage = new CommonPage(driver,explicitWait);
    public ListPengesahanTagihanPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
        super(driver, explicitWait);
        PageFactory.initElements(driver.get(),this);
    }

    @FindBy(xpath = "//table/tbody/tr[1]/td[8]")
    WebElement txtBtnLengkapi;

    @FindBy(xpath = "//table/tbody/tr[1]/td[1]")
    WebElement txtClaimNo;

    @FindBy(xpath = "//div[@data-testid='btnShowFilter']")
    WebElement btnPencarian;

    @FindBy(xpath = "//input[@data-testid='colmnPenagihanKlaim']")
    WebElement colmnNoKlaim;

    @FindBy(xpath = "//input[@value='' and @name='admissionDate'] ")
    WebElement colmRegDate;

    @FindBy(css = "[data-testid='CalendarTodayOutlinedIcon']")
    WebElement iconCalender;

    @FindBy(xpath = "//button[@aria-current='date']")
    WebElement dateToday;

    @FindBy(xpath = "//input[@value='' and @name='transactionNo']")
    WebElement colmnNoTransaksi;

    @FindBy(xpath = "//input[@data-testid='colmnNoKartu']")
    WebElement colmNoKartu;

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

    @FindBy(xpath = "//table/tbody/tr[1]/td[1]")
    WebElement txtNoKlaim;

    @FindBy(xpath = "//table/tbody/tr[1]/td[2]")
    WebElement txtRegDate;

    @FindBy(xpath = "//table/tbody/tr[1]/td[3]")
    WebElement txtNoTransaksi;

    @FindBy(xpath = "//table/tbody/tr[1]/td[4]")
    WebElement txtNoKartu;

    @FindBy(xpath = "//img[@alt='Empty Image']")
    WebElement imgEmpty;

    public void clickLengkapi() throws InterruptedException {
        doClick(txtBtnLengkapi);
    }

    public void scrollUntilBtnLengkapi() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)driver.get();
        jse.executeScript("arguments[0].scrollIntoView(true)",txtBtnLengkapi);
        Thread.sleep(2000);
    }

    public boolean statusTagihanSelesai(){
        waitForElementPresent(txtStatus);
        if(doGetText(txtStatus).contains("Tagihan Selesai")){
            return true;
        }
        return false;
    }

    public boolean statusTagihanDibatalkan(){
        waitForElementPresent(txtStatus);
        if(doGetText(txtStatus).contains("Tagihan Dibatalkan")){
            return true;
        }
        return false;
    }

    public void clickPencarian() throws InterruptedException {
        waitForVisibility(btnPencarian);
        doClick(btnPencarian);
    }

    public boolean imgEmptyIsDisplayed(){
        waitForElementPresent(imgEmpty);
        return imgEmpty.isDisplayed();
    }


    //Nomor Klaim
    public void clickClaimNo() throws InterruptedException {
        waitForElementPresent(txtNoKlaim);
        doClick(txtNoKlaim);
    }

    public String claimNo(){
        //return txtNoKlaim.getText();
        waitForElementPresent(txtNoKlaim);
        return doGetText(txtNoKlaim);
    }

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
    public String regDate(){
        waitForVisibility(txtRegDate);
        String date=  doGetText(txtRegDate);
        String tgl = date.substring(0,2)+"-";
        String bln = date.substring(3,5)+"-";
        String thn = date.substring(6,10);
        String wktDaftar = tgl+bln+thn;
        return wktDaftar;
    }

    public boolean verifyTglPendaftaran(){
        waitForElementPresent(txtRegDate);
        if(doGetText(txtRegDate).contains(regDate())){
            return true;
        }return false;
    }


    public void fillRegDate(){
        doSetText(colmRegDate,regDate());
    }

    public void fillRegDateNeg(String date){
        doSetText(colmRegDate,date);
    }

    public boolean RegDateIsCLear(){
        return colmRegDate.isDisplayed();
    }

    public void clickRegDate() throws InterruptedException {
        doClick(iconCalender);
    }

    public void clickDateToday() throws InterruptedException {
        doClick(dateToday);
    }

    //No. Transaksi
    public String transactionNo(){
        waitForElementPresent(txtNoTransaksi);
        return doGetText(txtNoTransaksi);
    }

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
    public String cardNo(){
        waitForElementPresent(txtNoKartu);
        return doGetText(txtNoKartu);
    }

    public void fillNoKartu(){
        doSetText(colmNoKartu,cardNo());
    }

    public void fillNoKartuManual(String cardNo){
//        waitForElementPresent(colmNoKartu);
        doSetText(colmNoKartu,cardNo);
    }

    @FindBy(xpath = "//input[@value='' and @data-testid='colmnNoKartu']")
    WebElement colmNoKartuDisplayed;
    public void fillNoKartuNeg(String cardNo){
        doSetText(colmNoKartuDisplayed,cardNo);
    }

    public boolean cardNoIsCLear(){
        return colmNoKartuDisplayed.isDisplayed();
    }

    //Nama Peserta
    @FindBy(xpath = "//table/tbody/tr[1]/td[5]")
    WebElement txtNamaPeserta;

    public String participantName(){
        waitForElementPresent(txtNamaPeserta);
        return doGetText(txtNamaPeserta);
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

    @FindBy(xpath = "//button[@data-testid='btnCari']")
    WebElement btnCari;

    public void clickBtnCari() throws InterruptedException {
        doClick(btnCari);
    }

    public void scrollUntilBtnCari() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)driver.get();
        jse.executeScript("arguments[0].scrollIntoView(true)",btnCari);
        Thread.sleep(2000);
    }

    @FindBy(xpath = "//button[(text() = 'Hapus')]")
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

    @FindBy(css = "[data-value='OP']")
    WebElement  dropDownRawatJalan;


    @FindBy(css = "[data-value='DT']")
    WebElement dropDownRawatGigi;

    @FindBy(css = "[data-value='GL']")
    WebElement dropDownKacamata;

    public void dropdownJenisPerawatan(ListPengesahanTagihanPage.JenisPerawatan jenisPerawatan) throws InterruptedException {
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

    public boolean verifyFilterJenisPerawatan(){
        for (int i=0; i<=txtJenisPerawatan.size()-1; i++){
            waitForVisibility(txtJenisPerawatan.get(i));
            if(doGetText(txtJenisPerawatan.get(i)).equalsIgnoreCase("Rawat Jalan")){
                return true;
            }

        }
        return false;
    }

    // Status
    @FindBy(xpath = "//div[@data-testid='drpdownStatus']")
    WebElement colmnStatus;

    public void clickStatusTagihanSelesai() throws InterruptedException {
        doClick(colmnStatus);
        fillStatus(Status.TAGIHANSELESAI);
    }

    public void clickStatusTagihanDibatalkan() throws InterruptedException {
        doClick(colmnStatus);
        fillStatus(Status.TAGIHANDIBATALKAN);
    }

    @FindBy(css = "[data-value='Menunggu Tagihan']")
    WebElement dropDownMenungguTagihan;

    @FindBy(css = "[data-value='Pendaftaran Dibatalkan']")
    WebElement dropDownPendaftaranDibatalkan;

    @FindBy(css = "[data-value='Tagihan Selesai']")
    WebElement dropDownTagihanSelesai;

    @FindBy(css = "[data-value='Tagihan Dibatalkan']")
    WebElement dropDownTagihanDibatalkan;
    public void fillStatus(ListPengesahanTagihanPage.Status status) throws InterruptedException {
        switch (status) {
            case MENUNGGUTAGIHAN:
                Thread.sleep(1000);
                doClick(dropDownMenungguTagihan);
                dropDownMenungguTagihan.sendKeys(Keys.ENTER);
                break;
            case PENDAFTARANDIBATALKAN:
                Thread.sleep(1000);
                doClick(dropDownPendaftaranDibatalkan);
                dropDownPendaftaranDibatalkan.sendKeys(Keys.ENTER);
                break;
            case TAGIHANSELESAI:
                Thread.sleep(1000);
                doClick(dropDownTagihanSelesai);
                dropDownTagihanSelesai.sendKeys(Keys.ENTER);
                break;
            case TAGIHANDIBATALKAN:
                Thread.sleep(1000);
                doClick(dropDownTagihanDibatalkan);
                dropDownTagihanDibatalkan.sendKeys(Keys.ENTER);
                break;
        }
    }

    @FindAll({@FindBy(xpath = "//table/tbody/tr/td[7]")})
    List<WebElement> txtListStatus;

    public boolean verifyFilterStatus() throws InterruptedException {
        Thread.sleep(2000);
        for (int i=0; i<=txtListStatus.size()-1; i++){
            waitForElementPresent(txtListStatus.get(i));
            if(doGetText(txtListStatus.get(i)).contains("Pendaftaran Dibatalkan")){
                return true;
            }

        }
        return false;
    }



    @FindBy(xpath = "//table/tbody/tr[1]/td[7]")
    WebElement txtStatus;

    public boolean verifyStatusMenungguTagihan(){
        waitForElementPresent(txtStatus);
        if(doGetText(txtStatus).equalsIgnoreCase("Menunggu Tagihan")){
            return true;
        }

        return false;
    }

    public boolean verifyStatusPendaftaranDibatalkan(){
        waitForElementPresent(txtStatus);
        if(doGetText(txtStatus).equalsIgnoreCase("Pendaftaran Dibatalkan")){
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

    public boolean verifyStatusTagihanDibatalkan(){
        waitForElementPresent(txtStatus);
        if(doGetText(txtStatus).contains("Tagihan Dibatalkan")){
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
        MENUNGGUTAGIHAN,
        PENDAFTARANDIBATALKAN,
        TAGIHANSELESAI,
        TAGIHANDIBATALKAN,
    }


}
