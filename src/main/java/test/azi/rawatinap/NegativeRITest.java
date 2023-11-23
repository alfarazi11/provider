package test.azi.rawatinap;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.CommonPage;
import page.HomePage;
import page.LoginPage;
import page.TxtErrorPage;
import page.rawatinap.CetakStrukRIPage;
import page.rawatinap.KonfirmasiRIPage;
import page.rawatinap.ListRIPage;
import page.rawatinap.PendaftaranRIPage;
import test.BaseWebTest;
import utils.Utility;

import java.io.IOException;

public class  NegativeRITest extends BaseWebTest {
    @BeforeMethod
    public void login() throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage(driver,explicitWait);
        loginPage.login();
    }

    @Test(testName = "Pendaftaran member tidak sesuai level provider  (Negative Case)")
    public void invalidLevelProviderRI() throws InterruptedException {
        HomePage homePage = new HomePage(driver,explicitWait);
        ListRIPage riPage = new ListRIPage(driver,explicitWait);
        PendaftaranRIPage daftarRI = new PendaftaranRIPage(driver,explicitWait);
        TxtErrorPage txtError = new TxtErrorPage(driver,explicitWait);
        homePage.clickRawatInap();
        Utility.hardWait(2);
        riPage.clickBtnPendaftaran();
        daftarRI.inputCardNum("7901072300000020");
        daftarRI.inputDOB("20011977");
        daftarRI.clickJenisPerawatan();
        daftarRI.fillJenisPerawatan(PendaftaranRIPage.JenisPerawatan.RAWATINAP);
        daftarRI.clickBtnCariDataPasien();
        Utility.hardWait(5);
        Assert.assertTrue(txtError.txtErrProviderTidakSesuaiDisplayed());
    }

    @Test(testName = "Policy inactive, member inactive, tidak memiliki benefit under Corporate (Negative Case) DXM-10")
    public void policyInactiveUnderCorporateRI() throws InterruptedException, IOException {
        HomePage homePage = new HomePage(driver,explicitWait);
        ListRIPage riPage = new ListRIPage(driver,explicitWait);
        PendaftaranRIPage daftarRI = new PendaftaranRIPage(driver,explicitWait);
        TxtErrorPage txtError = new TxtErrorPage(driver,explicitWait);
        homePage.clickRawatInap();
        riPage.clickBtnPendaftaran();
        daftarRI.inputCardNum("7901072200000001");
        daftarRI.inputDOB("15051990");
        daftarRI.clickJenisPerawatan();
        daftarRI.fillJenisPerawatan(PendaftaranRIPage.JenisPerawatan.RAWATINAP);
        daftarRI.clickBtnCariDataPasien();
        Utility.hardWait(5);
        Assert.assertTrue(txtError.txtErrPolisTidakAktifIsDisplayed());
        Assert.assertTrue(txtError.txtErrKepesertaanTidakAktifIsDisplayed());
        Assert.assertTrue(txtError.txtErrTidakMemilikiBenefitIsDisplayed());
        Assert.assertTrue(txtError.txtErrPolicyUnderCorporateIsDisplayed());
        txtError.clickBtnClosePopup();
        Assert.assertFalse(txtError.txtErrPolicyUnderCorporateIsDisplayed());
    }

    @Test(testName = "Policy inactive, member inactive, tidak memiliki benefit Individual(Negative Case) DXM-10")
    public void policyInactiveIndividualRI() throws InterruptedException {
        HomePage homePage = new HomePage(driver,explicitWait);
        ListRIPage riPage = new ListRIPage(driver,explicitWait);
        PendaftaranRIPage daftarRI = new PendaftaranRIPage(driver,explicitWait);
        TxtErrorPage txtError = new TxtErrorPage(driver,explicitWait);
        homePage.clickRawatInap();
        riPage.clickBtnPendaftaran();
        daftarRI.inputCardNum("9999202390000100");
        daftarRI.inputDOB("08041975");
        daftarRI.clickJenisPerawatan();
        daftarRI.fillJenisPerawatan(PendaftaranRIPage.JenisPerawatan.RAWATINAP);
        daftarRI.clickBtnCariDataPasien();
        Utility.hardWait(5);
        Assert.assertTrue(txtError.txtErrPolisTidakAktifIsDisplayed());
        Assert.assertTrue(txtError.txtErrKepesertaanTidakAktifIsDisplayed());
        Assert.assertTrue(txtError.txtErrTidakMemilikiBenefitIsDisplayed());
        Assert.assertTrue(txtError.txtErrPolicyIndividualIsDisplayed());
    }

    @Test(testName = "Manfaat berlaku reimbursement (Negative Case)")
    public void manfaatBerlakuReimbursementRI() throws InterruptedException {
        HomePage homePage = new HomePage(driver,explicitWait);
        ListRIPage riPage = new ListRIPage(driver,explicitWait);
        PendaftaranRIPage daftarRI = new PendaftaranRIPage(driver,explicitWait);
        TxtErrorPage txtError = new TxtErrorPage(driver,explicitWait);
        Utility.hardWait(3);
        homePage.clickRawatInap();
        riPage.clickBtnPendaftaran();
        daftarRI.inputCardNum("1310202300640473");
        daftarRI.inputDOB("31012023");
        daftarRI.clickJenisPerawatan();
        daftarRI.fillJenisPerawatan(PendaftaranRIPage.JenisPerawatan.RAWATINAP);
        daftarRI.clickBtnCariDataPasien();
        Utility.hardWait(5);
        Assert.assertTrue(txtError.txtErrBerlakuReimburseDisplayed());
    }

    @Test(testName = "Nomor kartu dan dob tidak sesuai (Negative Case)")
    public void dobNotMatchRI() throws InterruptedException {
        HomePage homePage = new HomePage(driver,explicitWait);
        ListRIPage riPage = new ListRIPage(driver,explicitWait);
        PendaftaranRIPage daftarRI = new PendaftaranRIPage(driver,explicitWait);
        TxtErrorPage txtError = new TxtErrorPage(driver,explicitWait);
        homePage.clickRawatInap();
        riPage.clickBtnPendaftaran();
        daftarRI.inputCardNum("1310 2022 0050 8759");
        daftarRI.inputDOB("16041982");
        daftarRI.clickJenisPerawatan();
        daftarRI.fillJenisPerawatan(PendaftaranRIPage.JenisPerawatan.RAWATINAP);
        daftarRI.clickBtnCariDataPasien();
        Utility.hardWait(5);
        Assert.assertTrue(txtError.txtErrDOBNotMatchDisplayed());
    }

    @Test(testName = "Pendaftaran member currency USD DXM-12 (Negative Case)")
    public void memberCurrencyUSDRI() throws InterruptedException {
        HomePage homePage = new HomePage(driver,explicitWait);
        ListRIPage riPage = new ListRIPage(driver,explicitWait);
        PendaftaranRIPage daftarRI = new PendaftaranRIPage(driver,explicitWait);
        homePage.clickRawatInap();
        riPage.clickBtnPendaftaran();
        daftarRI.inputCardNum("1310202100453425");
        daftarRI.inputDOB("12111977");
        daftarRI.clickJenisPerawatan();
        daftarRI.fillJenisPerawatan(PendaftaranRIPage.JenisPerawatan.RAWATINAP);
        daftarRI.clickBtnCariDataPasien();
//        Thread.sleep(5000);
        daftarRI.scrollUntilBtnDaftarkan();
//        Thread.sleep(5000);
        Assert.assertTrue(daftarRI.verifyTxtUSD());
    }

    @Test(testName = "Melakukan pendaftaran peserta yang sama dengan treatment yang sama DXM-67 (Negative Case)")
    public void regisSamePatientWithSameTreatmentRI() throws InterruptedException {
        HomePage homePage = new HomePage(driver, explicitWait);
        ListRIPage riPage = new ListRIPage(driver, explicitWait);
        PendaftaranRIPage daftar = new PendaftaranRIPage(driver, explicitWait);
        CommonPage commonPage = new CommonPage(driver, explicitWait);
        KonfirmasiRIPage konfirmasi = new KonfirmasiRIPage(driver, explicitWait);
        CetakStrukRIPage struk = new CetakStrukRIPage(driver, explicitWait);
        TxtErrorPage txtError = new TxtErrorPage(driver,explicitWait);
        commonPage.openURL(urlAfterLogin);
        homePage.clickRawatInap();
        riPage.clickBtnPendaftaran();
        daftar.inputCardNum("7901072300000011");
        daftar.inputDOB("12061986");
        daftar.clickJenisPerawatan();
        daftar.fillJenisPerawatan(PendaftaranRIPage.JenisPerawatan.RAWATINAP);
        daftar.clickBtnCariDataPasien();
        Utility.hardWait(5);
        daftar.scrollUntilBtnDaftarkan();
        daftar.clickBtnDaftarkan();
        konfirmasi.inputCaptcha("999");
        konfirmasi.scrollUntilBtnYa();
        konfirmasi.clickBtnYa();
        Utility.hardWait(20);
        struk.clickBtnTutup();
        Utility.hardWait(10);
//        commonPage.openURL(urlLive);
//        homePage.clickRawatInap();
        riPage.verifyStatusPendaftaranBerhasil();
        riPage.clickBtnPendaftaran();
        daftar.inputCardNum("7901072300000011");
        daftar.inputDOB("12061986");
        daftar.clickJenisPerawatan();
        daftar.fillJenisPerawatan(PendaftaranRIPage.JenisPerawatan.RAWATINAP);
        daftar.clickBtnCariDataPasien();
        Utility.hardWait(5);
        Assert.assertTrue(txtError.txtErrPesertaSudahTerdaftar());
        homePage.clickRawatInap();
        riPage.clickPencarian();
        riPage.fillNoKartuManual("7901072300000011");
        riPage.clickStatus();
        riPage.dropdownStatus(ListRIPage.Status.PENDAFTARANBERHASIL);
        riPage.clickBtnCari();
        Utility.hardWait(5);
        riPage.fillNoKlaim();
        riPage.clickBtnCari();
        Thread.sleep(5000);
        riPage.scrollUntilTxtBtnBatalkan();
        riPage.clickTxtBtnBatalkan();
        Utility.hardWait(3);
        konfirmasi.inputAlasanDibatalkanInpatient("SALAH MANFAAT");
        konfirmasi.inputCaptcha("999");
        konfirmasi.scrollUntilBtnBatalkanPerawatan();
        Utility.hardWait(2);
        konfirmasi.clickBtnBatalkanPerawatan();
        Utility.hardWait(20);
        commonPage.openURL(urlAfterLogin);
        homePage.clickRawatInap();
        riPage.clickPencarian();
        riPage.fillNoKartuManual("7901072300000011");
        riPage.clickBtnCari();
        Utility.hardWait(5);
        riPage.fillNoKlaim();
        riPage.clickBtnCari();
        Utility.hardWait(5);
        riPage.verifyStatusPendaftaranDibatalkan();
    }

}
