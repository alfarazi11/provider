package page.rawatjalan;

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

public class PendaftaranRJPage extends BasePage {
    public PendaftaranRJPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
        super(driver, explicitWait);
        PageFactory.initElements(driver.get(),this);
    }
    // Rawat Jalan
    @FindBy(xpath = "//div[.='Perawatan Tumbuh Kembang']")
    WebElement txtPerawatanTumbuhKembang;

    public boolean txtPerawatanTmbhKmbangIsDisplayed(){
        try{
            if(txtPerawatanTumbuhKembang.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    @FindBy(xpath = "//div[.='Dr.Spec + Tindakan + Admin']")
    WebElement txtSpecTindakanAdmin;

    public boolean txtDrSpecTindakanAdminIsDisplayed(){
        try{
            if(txtSpecTindakanAdmin.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    @FindBy(xpath = "//div[.='Dr.Umum + Tindakan + Admin']")
    WebElement txtUmumTindakanAdmin;

    public boolean txtDrUmumTindakanAdminIsDisplayed(){
        try{
            if(txtUmumTindakanAdmin.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    @FindBy(xpath = "//div[.='Dokter & Obat']")
    WebElement txtDokterObat;

    public boolean txtDokterObatIsDisplayed(){
        try{
            if(txtDokterObat.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    @FindBy(xpath = "//div[.='Post RI']")
    WebElement txtPostRI;

    public boolean txtPostRIIsDisplayed(){
        try {
            if(txtPostRI.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    @FindBy(xpath = "//div[.='Keguguran']")
    WebElement txtKeguguran;

    public boolean txtKeguguranIsDisplayed(){
        try{
            if(txtKeguguran.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    @FindBy(xpath = "//div[.='Biaya Lain2 (APD)']")
    WebElement txtBiayaLain2;

    public boolean txtBiayaLain2IsDisplayed(){
        try {
            if(txtBiayaLain2.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    @FindBy(xpath = "//div[.='Administrasi']")
    WebElement txtAdministrasi;

    public boolean txtAdministrasiIsDisplayed(){
        try{
            if(txtAdministrasi.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    @FindBy(xpath = "//div[.='Dokter Umum']")
    WebElement txtDokterUmum;

    public boolean txtDokterUmumIsDisplayed(){
        try{
            if(txtDokterUmum.isDisplayed()){
                return true;
            }
        }catch (Exception e){
        }return false;
    }

    @FindBy(xpath = "//div[.='Dokter Specialist']")
    WebElement txtDokterSpecialist;

    public boolean txtDokterSpecialistIsDisplayed(){
        try{
            if(txtDokterSpecialist.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    @FindBy(xpath = "//div[.='Obat & Alat Kes.']")
    WebElement txtObatAlatKes;

    public boolean txtObatAlkesIsDisplayed(){
        try {
            if(txtObatAlatKes.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    @FindBy(xpath = "//div[.='Lab/Pemerik.Diagnostik']")
    WebElement txtLabPemerikDiagnostik;

    public boolean txtLabDiagnoseIsDisplayed(){
        try {
            if(txtLabPemerikDiagnostik.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    @FindBy(xpath = "//div[.='Imunisasi']")
    WebElement txtImunisasi;

    public boolean txtImunisasiIsDisplayed(){
        try {
            if(txtImunisasi.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    @FindBy(xpath = "//div[.='Fisioterapi']")
    WebElement txtFisioterapi;

    public boolean txtFisioterapiIsDisplayed(){
        try {
            if(txtFisioterapi.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    @FindBy(xpath ="//div[.='KB']")
    WebElement txtKB;

    public boolean txtKBIsDisplayed(){
        try {
            if(txtKB.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    @FindBy(xpath = "//div[.='Pre & Post MT']")
    WebElement txtPrePostMT;

    public boolean txtPrePostMTIsDisplayed(){
        try {
            if(txtPrePostMT.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    @FindBy(xpath = "//div[.='MCU']")
    WebElement txtMCU;

    public boolean txtMCUIsDisplayed(){
        try {
            if(txtMCU.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    @FindBy(xpath = "//div[.='Imunisasi Anak']")
    WebElement txtImunisasiAnak;

    public boolean txtImunisasiAnakIsDisplayed(){
        try{
            if(txtImunisasiAnak.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    @FindBy(xpath = "//div[.='Hemo/Kemo']")
    WebElement txtHemoKemo;

    public boolean txtHemoKemoIsDisplayed(){
        try{
            if(txtHemoKemo.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    @FindBy(xpath = "//div[.='Obat + Tindakan']")
    WebElement txtObatTindakan;

    public boolean txtObatTindakanIsDisplayed(){
        try{
            if(txtObatTindakan.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    @FindBy(xpath = "//div[.='Pengobatan Tradisional Cina']")
    WebElement txtPengobatanTradisionalChina;

    public boolean txtPengobatanTradisionalChinaIsDisplayed(){
        try{
            if(txtPengobatanTradisionalChina.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    // Rawat Gigi
    @FindBy(xpath = "//div[2]/div[1]/div[1]/div[2]/div[1]")
    WebElement txtRawatGigi;

    public boolean txtRawatGigiIsDisplayed(){
        try{
            if(txtRawatGigi.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    @FindBy(xpath = "//div[.='Gigi Umum']")
    WebElement txtGigiUmum;

    public boolean txtGigiUmumIsDisplayed(){
        try{
            if(txtGigiUmum.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    @FindBy(xpath = "//div[.='Pencegahan']")
    WebElement txtPencegahan;

    public boolean txtPencegahanIsDisplayed(){
        try{
            if(txtPencegahan.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    @FindBy(xpath = "//div[.='Gigi Khusus']")
    WebElement txtGigiKhusus;

    public boolean txtGigiKhususIsDisplayed(){
        try{
            if(txtGigiKhusus.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    @FindBy(xpath = "//div[.='Gigi Palsu']")
    WebElement txtGigiPalsu;

    public boolean txtGigiPalsuIsDisplayed(){
        try{
            if(txtGigiPalsu.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }



    // Kacamata

    @FindBy(xpath = "//button[(text() = 'Kembali')]")
    WebElement btnKembali;

    public void clickBtnKembali() throws InterruptedException {
        doClick(btnKembali);
    }

    @FindBy (xpath = "//div[2]/div[1]/div[1]/div[2]/div[3]")
    WebElement benefit1Sub1;


    public String getTxtBenefit1Sub1(){
        return doGetText(benefit1Sub1);
    }
    public Integer getBenefit1Sub1(){
        String benefit = doGetText(benefit1Sub1).replaceAll("[a-zA-Z,.* ]","");
        int benefit1Sub1 = Integer.parseInt(benefit);
         return benefit1Sub1;
    }

    @FindBy(xpath = "//div[2]/div[1]/div[1]/div[3]/div[3]")
    WebElement benefit2Sub1;

    public String getTxtBenefit2Sub1(){
        return doGetText(benefit2Sub1);
    }

    public Integer getBenefit2Sub1(){
        String benefit = doGetText(benefit2Sub1).replaceAll("[a-zA-Z,.* ]","");
        int benefit2Sub1 = Integer.parseInt(benefit);
        return benefit2Sub1;
    }

    @FindBy(xpath = "//div[2]/div[1]/div[1]/div[4]/div[3]")
    WebElement benefit3Sub1;

    public String getTxtBenefit3Sub1(){
        return doGetText(benefit3Sub1);
    }

    public Integer getBenefit3Sub1(){
        String benefit = doGetText(benefit3Sub1).replaceAll("[a-zA-Z,.* ]","");
        int benefit3Sub1 = Integer.parseInt(benefit);
        return benefit3Sub1;
    }

    @FindBy(xpath = "//div[2]/div[1]/div[1]/div[5]/div[3]")
    WebElement benefit4Sub1;

    public String getTxtBenefit4Sub1(){
        return doGetText(benefit4Sub1);
    }

    public Integer getBenefit4Sub1(){
        String benefit = doGetText(benefit4Sub1).replaceAll("[a-zA-Z,.* ]","");
        int benefit4Sub1 = Integer.parseInt(benefit);
        return benefit4Sub1;
    }

    @FindBy(xpath = "//div[2]/div[1]/div[1]/div[6]/div[3]")
    WebElement benefit5Sub1;

    public String getTxtBenefit5Sub1(){
        return doGetText(benefit5Sub1);
    }

    public Integer getBenefit5Sub1(){
        String benefit = doGetText(benefit5Sub1).replaceAll("[a-zA-Z,.* ]","");
        int benefit5Sub1 = Integer.parseInt(benefit);
        return benefit5Sub1;
    }

    @FindBy(xpath = "//div[2]/div[1]/div[1]/div[7]/div[3]")
    WebElement benefit6Sub1;

    public String getTxtBenefit6Sub1(){
        return doGetText(benefit6Sub1);
    }

    public Integer getBenefit6Sub1(){
        String benefit = doGetText(benefit6Sub1).replaceAll("[a-zA-Z,.* ]","");
        int benefit6Sub1 = Integer.parseInt(benefit);
        return benefit6Sub1;
    }

    @FindBy(xpath = "//div[2]/div[1]/div[1]/div[8]/div[3]")
    WebElement benefit7Sub1;

    public String getTxtBenefit7Sub1(){
        return doGetText(benefit7Sub1);
    }

    public Integer getBenefit7Sub1(){
        String benefit = doGetText(benefit7Sub1).replaceAll("[a-zA-Z,.* ]","");
        int benefit7Sub1 = Integer.parseInt(benefit);
        return benefit7Sub1;
    }

    @FindBy (xpath = "//div[2]/div[1]/div[2]/div[1]/div[3]")
    WebElement benefit1Sub2;

    public String getTxtBenefit1Sub2(){
        return doGetText(benefit1Sub2);
    }

    public Integer getBenefit1Sub2(){
        String benefit = doGetText(benefit1Sub2).replaceAll("[a-zA-Z,.* ]","");
        int benefit1Sub2 = Integer.parseInt(benefit);
        return benefit1Sub2;
    }

    @FindBy(xpath = "//div[2]/div[1]/div[2]/div[2]/div[3]")
    WebElement benefit2Sub2;

    public String getTxtBenefit2Sub2(){
        return doGetText(benefit2Sub2);
    }

    public Integer getBenefit2Sub2(){
        String benefit = doGetText(benefit2Sub2).replaceAll("[a-zA-Z,.* ]","");
        int benefit2Sub2 = Integer.parseInt(benefit);
        return benefit2Sub2;
    }

    @FindBy(xpath = "//div[2]/div[1]/div[2]/div[3]/div[3]")
    WebElement benefit3Sub2;

    public String getTxtBenefit3Sub2(){
        return doGetText(benefit3Sub2);
    }

    public Integer getBenefit3Sub2(){
        String benefit = doGetText(benefit3Sub2).replaceAll("[a-zA-Z,.* ]","");
        int benefit3Sub2 = Integer.parseInt(benefit);
        return benefit3Sub2;
    }

    @FindBy(xpath = "//div[2]/div[1]/div[2]/div[4]/div[3]")
    WebElement benefit4Sub2;

    public String getTxtBenefit4Sub2(){
        return doGetText(benefit4Sub2);
    }

    public Integer getBenefit4Sub2(){
        String benefit = doGetText(benefit4Sub2).replaceAll("[a-zA-Z,.* ]","");
        int benefit4Sub2 = Integer.parseInt(benefit);
        return benefit4Sub2;
    }

    @FindBy(xpath = "//div[2]/div[1]/div[2]/div[5]/div[3]")
    WebElement benefit5Sub2;

    public String getTxtBenefit5Sub2(){
        return doGetText(benefit5Sub2);
    }

    public Integer getBenefit5Sub2(){
        String benefit = doGetText(benefit5Sub2).replaceAll("[a-zA-Z,.* ]","");
        int benefit5Sub2 = Integer.parseInt(benefit);
        return benefit5Sub2;
    }

    @FindBy(xpath = "//div[2]/div[1]/div[2]/div[6]/div[3]")
    WebElement benefit6Sub2;

    public String getTxtBenefit6Sub2(){
        return doGetText(benefit6Sub2);
    }

    public Integer getBenefit6Sub2(){
        String benefit = doGetText(benefit6Sub2).replaceAll("[a-zA-Z,.* ]","");
        int benefit6Sub2 = Integer.parseInt(benefit);
        return benefit6Sub2;
    }

    @FindBy(xpath = "//div[2]/div[1]/div[2]/div[7]/div[3]")
    WebElement benefit7Sub2;

    public String getTxtBenefit7Sub2(){
        return doGetText(benefit7Sub2);
    }

    public Integer getBenefit7Sub2(){
        String benefit = doGetText(benefit7Sub2).replaceAll("[a-zA-Z,.* ]","");
        int benefit7Sub2 = Integer.parseInt(benefit);
        return benefit7Sub2;
    }

    @FindBy(xpath = "//div[2]/div[1]/div[1]/div[1]/div[3]")
    WebElement txtInformManfaat;

    public String getTxtInformManfaat(){
        return doGetText(txtInformManfaat);
    }

    @FindAll({@FindBy(xpath = "//div[contains(@class,'css-1t9m8lh')]/div[1]/div[1]/div[3]")})
    List<WebElement> txtNama;

    public String getTxtNama(){
        return doGetText(txtNama.get(0));
    }

    @FindAll({@FindBy(xpath = "//div[contains(@class,'css-1t9m8lh')]/div[1]/div[2]/div[3]")})
    List<WebElement> txtJnsKelmin;

    public String getTxtJnsKlmn(){
        return doGetText(txtJnsKelmin.get(0));
    }

    @FindBy(xpath = "//div[1]/div[1]/div[1]/div[3]/div[3]")
    WebElement txtTglLhr;

    public String getTxtTglLhr() {
        return doGetText(txtTglLhr);
    }

    @FindBy(xpath = "//div[1]/div[1]/div[1]/div[5]/div[3]")
    WebElement txtStatus;

    public String getTxtStatus(){
        return doGetText(txtStatus);
    }

    @FindBy(xpath = "//div[1]/div[1]/div[2]/div[1]/div[3]")
    WebElement txtNmrKrt;

    public String getTxtNmrKart(){
        return doGetText(txtNmrKrt);
    }

    @FindBy(xpath = "//div[1]/div[1]/div[2]/div[2]/div[3]")
    WebElement txtNmrPolis;

    public String getTxtNmrPolis(){
        return doGetText(txtNmrPolis);
    }

    @FindBy(xpath = "//div[1]/div[1]/div[2]/div[3]/div[3]")
    WebElement txtNamaPemegangPolis;

    public String getTxtNamaPemegangPolis(){
        return doGetText(txtNamaPemegangPolis);
    }

    @FindBy(xpath = "//div[1]/div[1]/div[2]/div[4]/div[3]")
    WebElement txtPayor;

    public String getTxtPayor(){
        return doGetText(txtPayor);
    }

    @FindBy(xpath = "//button[@fdprocessedid='bcziiu']")
    WebElement btnTidakKodeRujukan;

    public void clickBtnTidak() throws InterruptedException {
        doClick(btnTidakKodeRujukan);
    }

    @FindBy(xpath = "//button[(text()='Gunakan')]")
    WebElement btnGunakanKodeRujukan;

    public void clickBtnGunakanKodeRujukan() throws InterruptedException {
        doClick(btnGunakanKodeRujukan);
    }

    @FindBy(css = "[placeholder='No. Kartu Peserta *']")
    WebElement colmNoKartu;

    public void inputCardNum(String cardNum){
        doSetText(colmNoKartu,cardNum);
    }

    @FindBy(name = "dob")
    WebElement colmDOB;

    public void inputDOB(String dob){
        doSetText(colmDOB,dob);
    }

    @FindBy(css = ".MuiSelect-select")
    WebElement colmnJenisPerawatan;

    public void clickJenisPerawatan() throws InterruptedException {
        doClick(colmnJenisPerawatan);
    }

    @FindBy(xpath = "//button[@data-testid = 'btnCariDataPasien']")
    WebElement btnCariDataPasien;

    public void clickBtnCariDataPasien() throws InterruptedException {
        doClick(btnCariDataPasien);
    }

    @FindBy(xpath = "//button[@data-testid='btnDaftarkanPasien']")
    WebElement btnDaftarkan;


    public void scrollUntilBtnDaftarkan() {
        try {
            JavascriptExecutor jse = (JavascriptExecutor)driver.get();
            jse.executeScript("arguments[0].scrollIntoView(true)",btnDaftarkan);
            Utility.hardWait(2);
        }catch (Exception e){}
    }

    public void clickBtnDaftarkan() throws InterruptedException {
        doClick(btnDaftarkan);
    }

    @FindBy(xpath = "//p[(text() = 'MANFAAT PESERTA')]")
    WebElement txtManfataPeserta;

    public boolean manfaatPesertaIsDisplayed(){
        waitForElementPresent(txtManfataPeserta);
        return txtManfataPeserta.isDisplayed();
    }

    @FindBy(css = "div:nth-of-type(9) > .MuiGrid-grid-xs-7")
    WebElement txtMemberInnerLimit;

    public boolean memberInnerLimitIsDisplayed(){
        waitForElementPresent(txtMemberInnerLimit);
        if(doGetText(txtMemberInnerLimit).contains("USD")){
            return true;
        }return false;
    }

    @FindBy(xpath = "//div[.='Fisioterapi:Sesuai Tagihan']")
    WebElement txtMemberAsCharge;

    public boolean memberAsCharge(){
        waitForElementPresent(txtMemberAsCharge);
        return txtMemberAsCharge.isDisplayed();
    }

    @FindAll({@FindBy(xpath = "//div[contains(text(),'USD')]")})
    List<WebElement> txtUSD;

    public boolean verifyTxtUSD(){
            for (int i = 0; i < txtUSD.size(); i++) {
                if (txtUSD.get(i).getText().contains("USD")) {
                    return true;
                }
        }return false;
    }

    @FindBy(xpath = "//p[contains(text(),'Silakan isi kolom wajib ini')]")
    WebElement txtColmNoKartuMandatory;

    public boolean verifyColmnNoCardMandatory(){
        if(doGetText(txtColmNoKartuMandatory).equalsIgnoreCase("Silakan isi kolom wajib ini")){
            return true;
        }return false;
    }

    @FindBy(xpath = "//span[contains(text(),'Silakan isi kolom wajib ini')]")
    WebElement txtColmTglLhirMandatory;

    public boolean verifyColmnTglLhrMandatory(){
        if(doGetText(txtColmTglLhirMandatory).equalsIgnoreCase("Silakan isi kolom wajib ini")){
            return true;
        }return false;
    }

    @FindBy(xpath = "//p[contains(text(),'Silakan pilih item dalam daftar')]")
    WebElement txtColmJnsPerwtanMandatory;

    public boolean verifyColmnJnsPrwtanMandatory(){
        if(doGetText(txtColmJnsPerwtanMandatory).equalsIgnoreCase("Silakan pilih item dalam daftar")){
            return true;
        }return false;
    }

    @FindBy(css = "[data-value='GL']")
    WebElement dropDownKacamata;

    @FindBy(css = "[data-value='DT']")
    WebElement dropDownRawatGigi;

    @FindBy(css = "[data-value='OP']")
    WebElement dropDownRawatJalan;

    public void fillJenisPerawatan(PendaftaranRJPage.JenisPerawatan jenisPerawatan) throws InterruptedException {
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

    public enum JenisPerawatan{
        RAWATJALAN,
        RAWATGIGI,
        KACAMATA,
    }
}
