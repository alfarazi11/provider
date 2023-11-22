package page.pengesahantagihan;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.BasePage;

public class FormTagihanPage extends BasePage {
    public FormTagihanPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
        super(driver, explicitWait);
        PageFactory.initElements(driver.get(),this);
    }
    //Rawat Jalan
    @FindBy(xpath = "//input[@placeholder = 'Dr.Umum + Tindakan + Admin (Rp)']")
    WebElement colmnDrUmumTindakanAdmin;

    public void inputDrUmumTindakanAdmin(String drUmumTindakanAdmin){
        doSetText(colmnDrUmumTindakanAdmin,drUmumTindakanAdmin);
    }

    public boolean colmnDrUmumTindakanAdminIsDisplayed(){
        try{
            if(colmnDrUmumTindakanAdmin.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    @FindBy(xpath = "//input[@placeholder = 'Dr.Spec + Tindakan + Admin (Rp)']")
    WebElement colmnDrSpcTindakanAdmin;

    public void inputDrSpcTindakanAdmin(String drUmumTindakanAdmin){
        doSetText(colmnDrSpcTindakanAdmin,drUmumTindakanAdmin);
    }

    public boolean colmnDrSpcTindakanAdminIsDisplayed(){
        try{
            if(colmnDrSpcTindakanAdmin.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    @FindBy(xpath = "//input[@placeholder = 'Pengobatan Tradisional Cina (Rp)']")
    WebElement colmnPengobatanTradisionalCina;

    public void inputPengobatanTradisionalCina(String drUmumTindakanAdmin){
        doSetText(colmnPengobatanTradisionalCina,drUmumTindakanAdmin);
    }

    public boolean colmnPengobatanTradisionalCinaIsDisplayed(){
        try{
            if(colmnPengobatanTradisionalCina.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    @FindBy(xpath = "//input[@placeholder = 'Hemo/Kemo (Rp)']")
    WebElement colmnHemoKemo;

    public void inputHemoKemo(String drUmumTindakanAdmin){
        doSetText(colmnHemoKemo,drUmumTindakanAdmin);
    }

    public boolean colmnHemoKemoIsDisplayed(){
        try{
            if(colmnHemoKemo.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    @FindBy(xpath = "//input[@placeholder = 'Perawatan Tumbuh Kembang (Rp)']")
    WebElement colmnTumbuhKembang;

    public void inputBiayaTumbuhKembang(String tumbuhKembang){
        doSetText(colmnTumbuhKembang,tumbuhKembang);
    }

    public boolean colmnTumbuhKembangIsDisplayed(){
        try{
            if(colmnTumbuhKembang.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    @FindBy(xpath = "//input[@placeholder = 'Pre & Post MT (Rp)']")
    WebElement colmnPrePost;

    public void inputBiayaPrePostMT(String prePost){
        doSetText(colmnPrePost,prePost);
    }

    public boolean colmnPrePostMTIsDisplayed(){
        try{
            if(colmnPrePost.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    @FindBy(xpath = "//input[@placeholder = 'MCU (Rp)']")
    WebElement colmnMCU;

    public void inputBiayaMCU(String mcu){
        doSetText(colmnMCU,mcu);
    }

    public boolean colmnMCUIsDisplayed(){
        try{
            if(colmnMCU.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }


    @FindBy(xpath = "//input[@placeholder = 'Imunisasi (Rp)']")
    WebElement colmnImunisasi;

    public void inputBiayaImunisasi(String imunisasi){
        doSetText(colmnImunisasi,imunisasi);
    }

    public boolean colmnImunisasiIsDisplayed(){
        try{
            if(colmnImunisasi.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    @FindBy(xpath = "//input[@placeholder = 'Dokter Umum (Rp)']")
    WebElement colmnDokterUmum;

    public void inputBiayaDokterUmum(String biayaDrUmum){
        doSetText(colmnDokterUmum,biayaDrUmum);
    }

    public boolean colmnDokterUmumIsDisplayed(){
        try{
            if(colmnDokterUmum.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    @FindBy(xpath = "//input[@placeholder = 'Dokter Specialist (Rp)']")
    WebElement colmnDokterSpecialis;

    public void inputBiayaDokterSpec(String biayaDrSpec){
        doSetText(colmnDokterSpecialis,biayaDrSpec);
    }

    public boolean colmnDokterSpecIsDisplayed(){
        try{
            if(colmnDokterSpecialis.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    @FindBy(xpath = "//input[@placeholder = 'Fisioterapi (Rp)']")
    WebElement colmnFisioterapi;

    public void inputBiayaFisioterapi(String biayaFisioterapi){
        doSetText(colmnFisioterapi,biayaFisioterapi);
    }

    public boolean colmnFisioterapiIsDisplayed(){
        try{
            if(colmnFisioterapi.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    @FindBy(xpath = "//input[@placeholder = 'Lab/Pemerik.Diagnostik (Rp)']")
    WebElement colmnLabDiagnos;

    public void inputBiayaLabDiagnos(String biayaLab){
        doSetText(colmnLabDiagnos,biayaLab);
    }

    public boolean colmnLabDiagnosIsDisplayed(){
        try{
            if(colmnLabDiagnos.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    @FindBy(xpath = "//input[@placeholder = 'Administrasi (Rp)']")
    WebElement colmnAdmin;

    public void inputBiayaAdmin(String biayaAdmin){
        doSetText(colmnAdmin,biayaAdmin);
    }

    public boolean colmnAdminIsDisplayed(){
        try{
            if(colmnAdmin.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    @FindBy(xpath = "//input[@placeholder = 'KB (Rp)']")
    WebElement colmnKB;

    public void inputBiayaKB(String biayaKB){
        doSetText(colmnKB,biayaKB);
    }

    public boolean colmnKBIsDisplayed(){
        try{
            if(colmnKB.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    @FindBy(xpath = "//input[@placeholder = 'Post RI (Rp)']")
    WebElement colmnPostRI;

    public void inputBiayaPostRI(String biayaPostRI){
        doSetText(colmnPostRI,biayaPostRI);
    }

    public boolean colmnPostRIIsDisplayed(){
        try{
            if(colmnPostRI.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    @FindBy(xpath = "//input[@placeholder = 'Obat + Tindakan (Rp)']")
    WebElement colmnObatTindakan;

    public void inputBiayaObatTindakan(String biayaObat){
        doSetText(colmnObatTindakan,biayaObat);
    }

    public boolean colmnObatTindakanIsDisplayed(){
        try{
            if(colmnObatTindakan.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    @FindBy(xpath = "//input[@placeholder = 'Imunisasi Anak (Rp)']")
    WebElement colmnImunisasiAnak;

    public void inputBiayaImunisasiAnak(String biayaImunisasi){
        doSetText(colmnImunisasiAnak,biayaImunisasi);
    }

    public boolean colmnImunisasiAnakIsDisplayed(){
        try{
            if(colmnImunisasiAnak.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    @FindBy(xpath = "//input[@placeholder = 'Biaya Lain2 (APD) (Rp)']")
    WebElement colmnBiayaLainLain;

    public void inputBiayaLain2(String biayaLain){
        doSetText(colmnBiayaLainLain,biayaLain);
    }

    public boolean colmnBiayaLain2IsDisplayed(){
        try{
            if(colmnBiayaLainLain.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    @FindBy(xpath = "//input[@placeholder = 'Dokter & Obat (Rp)']")
    WebElement colmnDokterObat;

    public void inputBiayaDokterObat(String biayaDokterObat){
        doSetText(colmnDokterObat,biayaDokterObat);
    }

    public boolean colmnDokterObatIsDisplayed(){
        try{
            if(colmnDokterObat.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    @FindBy(xpath = "//input[@placeholder = 'Obat & Alat Kes. (Rp)']")
    WebElement colmnObatAlkes;

    public void inputBiayaObatAlkes(String biayaObatAlkes){
        doSetText(colmnObatAlkes,biayaObatAlkes);
    }

    public boolean colmnObatAlkesIsDisplayed(){
        try{
            if(colmnObatAlkes.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    //Rawat Gigi
    @FindBy(xpath = "//input[@placeholder = 'Rawat Gigi (Rp)']")
    WebElement colmnRawatGigi;

    public void inputBiayaRawatGigi(String biayaObatAlkes){
        doSetText(colmnRawatGigi,biayaObatAlkes);
    }

    public boolean colmnRawatGigiIsDisplayed(){
        try{
            if(colmnRawatGigi.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    @FindBy(xpath = "//input[@placeholder = 'Gigi Umum (Rp)']")
    WebElement colmnGigiUmum;

    public void inputBiayaGigiUmum(String biayaObatAlkes){
        doSetText(colmnGigiUmum,biayaObatAlkes);
    }

    public boolean colmnGigiUmumIsDisplayed(){
        try{
            if(colmnGigiUmum.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    @FindBy(xpath = "//input[@placeholder = 'Pencegahan (Rp)']")
    WebElement colmnPencegahan;

    public void inputBiayaPencegahan(String biayaObatAlkes){
        doSetText(colmnPencegahan,biayaObatAlkes);
    }

    public boolean colmnPencegahanIsDisplayed(){
        try{
            if(colmnPencegahan.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    @FindBy(css = ".MuiButton-text")
    WebElement txtBtnPilihDiagnosis;


    public void clickPilihDiagnosis() throws InterruptedException {
        waitForElementPresent(txtBtnPilihDiagnosis);
        doClick(txtBtnPilihDiagnosis);
    }

    @FindBy(css = "[name='searchKey']")
    WebElement colmnCodeDiagnosis;

    public void inputKodeDiagnosa(String kodeDiagnosa){
        clear(colmnCodeDiagnosis);
        doSetText(colmnCodeDiagnosis,kodeDiagnosa);
    }

    public void clearColmKodeDiagnosa(){
        colmnCodeDiagnosis.clear();
    }

    @FindBy(xpath = "//div[contains(@class,'css-8atqhb')]//tr[1]/td[1]/span")
    WebElement checkboxDiagnosa1;

    public void clickCheckbox1() throws InterruptedException {
        waitForElementPresent(checkboxDiagnosa1);
        doClick(checkboxDiagnosa1);
    }

    @FindBy(xpath = "//div[contains(@class,'css-8atqhb')]//tr[2]/td[1]/span")
    WebElement checkboxDiagnosa2;

    public void clickCheckbox2() throws InterruptedException {
        waitForElementPresent(checkboxDiagnosa2);
        doClick(checkboxDiagnosa2);
    }

    @FindBy(xpath = "//div[contains(@class,'css-8atqhb')]//tr[3]/td[1]/span")
    WebElement checkboxDiagnosa3;

    public void clickCheckbox3() throws InterruptedException {
        doClick(checkboxDiagnosa3);
    }

    @FindBy(xpath = "//div[@class='MuiBox-root css-8atqhb']//tr[4]/td[1]")
    WebElement checkboxDiagnosa4;

    public void clickCheckbox4() throws InterruptedException {
        doClick(checkboxDiagnosa4);
    }

    @FindBy(xpath = "//table[contains(@class,'css-7upgu4')]/tbody/tr[1]/td[2]")
    WebElement txtKodeDiagnose1;

    @FindBy(xpath = "//table[contains(@class,'css-7upgu4')]/tbody/tr[1]/td[3]")
    WebElement txtDiagnose1;

    public String getTxtDiagnose1(){
         String diagnose1 = doGetText(txtDiagnose1);
        String kodeDiagnose1 = doGetText(txtKodeDiagnose1);
        String diagnosa = kodeDiagnose1 + " - " + diagnose1;
        return diagnosa;
    }

    @FindBy(xpath = "//table[contains(@class,'css-7upgu4')]/tbody/tr[2]/td[2]")
    WebElement txtKodeDiagnose2;

    @FindBy(xpath = "//table[contains(@class,'css-7upgu4')]/tbody/tr[2]/td[3]")
    WebElement txtDiagnose2;

    public String getTxtDiagnose2(){
        String diagnose1 = doGetText(txtDiagnose2);
        String kodeDiagnose1 = doGetText(txtKodeDiagnose2);
        String diagnosa = diagnose1 + " - " + kodeDiagnose1;
        return diagnosa;
    }

    @FindBy(xpath = "//table[contains(@class,'css-7upgu4')]/tbody/tr[3]/td[3]")
    WebElement txtDiagnose3;

    @FindBy(xpath = "//table[contains(@class,'css-7upgu4')]/tbody/tr[3]/td[2]")
    WebElement txtKodeDiagnose3;

    public String getTxtDiagnose3(){
        String diagnose1 = doGetText(txtDiagnose3);
        String kodeDiagnose1 = doGetText(txtKodeDiagnose3);
        String diagnosa = diagnose1 + " - " + kodeDiagnose1;
        return diagnosa;
    }

    @FindBy(xpath = "//button[(@data-testid='btnKirimPilihDiagnosa')]")
    WebElement btnKirim;

    public void clickBtnKirim() throws InterruptedException {
        doClick(btnKirim);
    }

    @FindBy(xpath = "//button[(@data-testid='btnBatalPilihDiagnosa')]")
    WebElement btnBatal;

    public void clickBtnBatal() throws InterruptedException {
        doClick(btnBatal);
    }

    @FindBy(xpath = "//button[(@data-testid='btnProsesTagihan')]")
    WebElement btnProsesTagian;


    public void scrollUntilBtnProsesTagihan() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver.get();
        js.executeScript("arguments[0].scrollIntoView();",btnProsesTagian);
        Thread.sleep(2000);
    }

    public void clickProsesTagihan() throws InterruptedException {
        doClick(btnProsesTagian);
    }

    @FindBy(xpath = "//button[(text()='Ya, keluar')]")
    WebElement btnYaKeluar;


    public void clickBtnYaKeluar() throws InterruptedException {
        doClick(btnYaKeluar);
    }

    @FindBy(xpath = "//button[(text()='Kembali ke Form')]")
    WebElement btnKembaliKeForm;

    public void clickBtnKembaliKeForm() throws InterruptedException {
        doClick(btnKembaliKeForm);
    }

}
