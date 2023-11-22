package test.rawatjalan;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.*;
import page.rawatjalan.CetakStrukPage;
import page.rawatjalan.KonfirmasiPage;
import page.rawatinap.ListRIPage;
import page.rawatjalan.*;
import test.BaseWebTest;
import utils.Utility;

import java.io.IOException;

public class NegativeRJTest extends BaseWebTest {

    @BeforeMethod
    public void login() throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage(driver,explicitWait);
        loginPage.login();
    }

    @Test(testName = "Policy inactive, member inactive, tidak memiliki benefit under Corporate (Negative Case) DXM-10")
    public void policyInactiveUnderCorporate() throws InterruptedException, IOException {
        HomePage homePage = new HomePage(driver,explicitWait);
        ListRJPage rjPage = new ListRJPage(driver,explicitWait);
        PendaftaranRJPage daftar = new PendaftaranRJPage(driver,explicitWait);
        TxtErrorPage txtError = new TxtErrorPage(driver,explicitWait);
        homePage.clickRawatJalan();
        rjPage.clickBtnPendaftaran();
        daftar.inputCardNum("7901072200000001");
        daftar.inputDOB("15051990");
        daftar.clickJenisPerawatan();
        daftar.fillJenisPerawatan(PendaftaranRJPage.JenisPerawatan.RAWATJALAN);
        daftar.clickBtnCariDataPasien();
        Utility.hardWait(5);
        Assert.assertTrue(txtError.txtErrPolisTidakAktifIsDisplayed());
        Assert.assertTrue(txtError.txtErrKepesertaanTidakAktifIsDisplayed());
        Assert.assertTrue(txtError.txtErrTidakMemilikiBenefitIsDisplayed());
        Assert.assertTrue(txtError.txtErrPolicyUnderCorporateIsDisplayed());
        txtError.clickBtnClosePopup();
        Assert.assertFalse(txtError.txtErrPolicyUnderCorporateIsDisplayed());
    }

    @Test(testName = "Policy inactive, member inactive, tidak memiliki benefit Individual(Negative Case) DXM-10")
    public void policyInactiveIndividual() throws InterruptedException {
        HomePage homePage = new HomePage(driver,explicitWait);
        ListRJPage rjPage = new ListRJPage(driver,explicitWait);
        PendaftaranRJPage daftar = new PendaftaranRJPage(driver,explicitWait);
        TxtErrorPage txtError = new TxtErrorPage(driver,explicitWait);
        homePage.clickRawatJalan();
        rjPage.clickBtnPendaftaran();
        daftar.inputCardNum("9999202390000100");
        daftar.inputDOB("08041975");
        daftar.clickJenisPerawatan();
        daftar.fillJenisPerawatan(PendaftaranRJPage.JenisPerawatan.RAWATJALAN);
        daftar.clickBtnCariDataPasien();
        Utility.hardWait(5);
        Assert.assertTrue(txtError.txtErrPolisTidakAktifIsDisplayed());
        Assert.assertTrue(txtError.txtErrKepesertaanTidakAktifIsDisplayed());
        Assert.assertTrue(txtError.txtErrTidakMemilikiBenefitIsDisplayed());
        Assert.assertTrue(txtError.txtErrPolicyIndividualIsDisplayed());
    }

    @Test(testName = "Manfaat berlaku reimbursement (Negative Case)")
    public void manfaatBerlakuReimbursement() throws InterruptedException {
        HomePage homePage = new HomePage(driver,explicitWait);
        ListRJPage rjPage = new ListRJPage(driver,explicitWait);
        PendaftaranRJPage daftar = new PendaftaranRJPage(driver,explicitWait);
        TxtErrorPage txtError = new TxtErrorPage(driver,explicitWait);
        homePage.clickRawatJalan();
        rjPage.clickBtnPendaftaran();
        daftar.inputCardNum("1310202300640473");
        daftar.inputDOB("31012023");
        daftar.clickJenisPerawatan();
        daftar.fillJenisPerawatan(PendaftaranRJPage.JenisPerawatan.RAWATGIGI);
        daftar.clickBtnCariDataPasien();
        Utility.hardWait(5);
        Assert.assertTrue(txtError.txtErrBerlakuReimburseDisplayed());
    }

    @Test(testName = "Nomor kartu dan dob tidak sesuai (Negative Case)")
    public void dobNotMatch() throws InterruptedException {
        HomePage homePage = new HomePage(driver,explicitWait);
        ListRJPage rjPage = new ListRJPage(driver,explicitWait);
        PendaftaranRJPage daftar = new PendaftaranRJPage(driver,explicitWait);
        TxtErrorPage txtError = new TxtErrorPage(driver,explicitWait);
        homePage.clickRawatJalan();
        rjPage.clickBtnPendaftaran();
        daftar.inputCardNum("1310 2022 0050 8759");
        daftar.inputDOB("16041982");
        daftar.clickJenisPerawatan();
        daftar.fillJenisPerawatan(PendaftaranRJPage.JenisPerawatan.RAWATGIGI);
        daftar.clickBtnCariDataPasien();
        Utility.hardWait(5);
        Assert.assertTrue(txtError.txtErrDOBNotMatchDisplayed());
    }

    @Test(testName = "Pendaftaran member tidak sesuai level provider  (Negative Case)")
    public void invalidLevelProvider() throws InterruptedException {
        HomePage homePage = new HomePage(driver,explicitWait);
        ListRIPage riPage = new ListRIPage(driver,explicitWait);
        PendaftaranRJPage daftar = new PendaftaranRJPage(driver,explicitWait);
        TxtErrorPage txtError = new TxtErrorPage(driver,explicitWait);
        homePage.clickRawatJalan();
        riPage.clickBtnPendaftaran();
        daftar.inputCardNum("9999202000000001");
        daftar.inputDOB("01111994");
        daftar.clickJenisPerawatan();
        daftar.fillJenisPerawatan(PendaftaranRJPage.JenisPerawatan.RAWATJALAN);
        daftar.clickBtnCariDataPasien();
        Utility.hardWait(2);
        Assert.assertTrue(txtError.txtErrProviderTidakSesuaiDisplayed());
    }

    @Test(testName = "Polis dalam penyelesaian administrasi under corporate (Negative Case)")
    public void prosesAdministrasiUnderCorporate() throws InterruptedException {
        HomePage homePage = new HomePage(driver,explicitWait);
        ListRJPage rjPage = new ListRJPage(driver,explicitWait);
        PendaftaranRJPage daftar = new PendaftaranRJPage(driver,explicitWait);
        TxtErrorPage txtError = new TxtErrorPage(driver,explicitWait);
        homePage.clickRawatJalan();
        rjPage.clickBtnPendaftaran();
        daftar.inputCardNum("");
        daftar.inputDOB("");
        daftar.clickJenisPerawatan();
        daftar.fillJenisPerawatan(PendaftaranRJPage.JenisPerawatan.RAWATJALAN);
        daftar.clickBtnCariDataPasien();
        Utility.hardWait(5);
        Assert.assertTrue(txtError.txtErrProsesAdministrasiDisplayed());
    }

    @Test(testName = "Polis dalam penyelesaian administrasi individual (Negative Case)")
    public void prosesAdministrasiIndividual() throws InterruptedException, IOException {
        HomePage homePage = new HomePage(driver,explicitWait);
        ListRJPage rjPage = new ListRJPage(driver,explicitWait);
        PendaftaranRJPage daftar = new PendaftaranRJPage(driver,explicitWait);
        TxtErrorPage txtError = new TxtErrorPage(driver,explicitWait);
        homePage.clickRawatJalan();
        rjPage.clickBtnPendaftaran();
        daftar.inputCardNum("7901072300000001");
        daftar.inputDOB("09051990");
        daftar.clickJenisPerawatan();
        daftar.fillJenisPerawatan(PendaftaranRJPage.JenisPerawatan.RAWATJALAN);
        daftar.clickBtnCariDataPasien();
        Utility.hardWait(5);
        Assert.assertTrue(txtError.txtErrProsesAdministrasiIndividuDisplayed());
    }

    @Test(testName = "Pendaftaran member currency USD DXM-12 (Negative Case)")
    public void memberCurrencyUSD() throws InterruptedException {
        HomePage homePage = new HomePage(driver,explicitWait);
        ListRJPage rjPage = new ListRJPage(driver,explicitWait);
        PendaftaranRJPage daftar = new PendaftaranRJPage(driver,explicitWait);
        homePage.clickRawatJalan();
        rjPage.clickBtnPendaftaran();
        daftar.inputCardNum("1310202100453425");
        daftar.inputDOB("12111977");
        daftar.clickJenisPerawatan();
        daftar.fillJenisPerawatan(PendaftaranRJPage.JenisPerawatan.RAWATJALAN);
        daftar.clickBtnCariDataPasien();
//        Thread.sleep(5000);
        daftar.scrollUntilBtnDaftarkan();
//        Thread.sleep(5000);
        Assert.assertTrue(daftar.verifyTxtUSD());
    }

    @Test(testName = "Melakukan pendaftaran peserta yang sama dengan treatment yang sama DXM-67 (Negative Case)")
    public void regisSamePatientWithSameTreatment() throws InterruptedException {
        HomePage homePage = new HomePage(driver, explicitWait);
        ListRJPage rjPage = new ListRJPage(driver, explicitWait);
        PendaftaranRJPage daftar = new PendaftaranRJPage(driver, explicitWait);
        CommonPage commonPage = new CommonPage(driver, explicitWait);
        KonfirmasiPage konfirmasi = new KonfirmasiPage(driver, explicitWait);
        CetakStrukPage struk = new CetakStrukPage(driver, explicitWait);
        TxtErrorPage txtError = new TxtErrorPage(driver,explicitWait);
        commonPage.openURL(urlAfterLogin);
        homePage.clickRawatJalan();
        rjPage.clickBtnPendaftaran();
        daftar.inputCardNum("9999202000000004");
        daftar.inputDOB("13121995");
        daftar.clickJenisPerawatan();
        daftar.fillJenisPerawatan(PendaftaranRJPage.JenisPerawatan.RAWATJALAN);
        daftar.clickBtnCariDataPasien();
        Utility.hardWait(5);
        daftar.scrollUntilBtnDaftarkan();
        daftar.clickBtnDaftarkan();
        konfirmasi.inputCaptcha("999");
        konfirmasi.scrollUntilBtnYa();
        konfirmasi.clickBtnYa();
        struk.clickBtnTutup();
        Utility.hardWait(10);
//        commonPage.openURL(urlLive);
//        homePage.clickRawatJalan();
        rjPage.verifyStatusPendaftaranBerhasil();
        rjPage.clickBtnPendaftaran();
        daftar.inputCardNum("7901072300000011");
        daftar.inputDOB("12061986");
        daftar.clickJenisPerawatan();
        daftar.fillJenisPerawatan(PendaftaranRJPage.JenisPerawatan.RAWATJALAN);
        daftar.clickBtnCariDataPasien();
        Utility.hardWait(5);
        Assert.assertTrue(txtError.txtErrPesertaSudahTerdaftar());
//        commonPage.openURL(urlLive);
        homePage.clickRawatJalan();
        rjPage.clickPencarian();
        rjPage.fillNoKartuManual("7901072300000011");
        rjPage.clickStatus();
        rjPage.dropdownStatus(ListRJPage.Status.PENDAFTARANBERHASIL);
        rjPage.clickBtnCari();
        Utility.hardWait(5);
        rjPage.fillNoKlaim();
        rjPage.clickBtnCari();
        Thread.sleep(5000);
        rjPage.scrollUntilTxtBtnBatalkan();
        rjPage.clickTxtBtnBatalkan();
        Utility.hardWait(3);
        konfirmasi.inputAlasanDibatalkanOutpatient("SALAH MANFAAT");
        konfirmasi.inputCaptcha("999");
        konfirmasi.scrollUntilBtnBatalkanPerawatan();
        Utility.hardWait(2);
        konfirmasi.clickBtnBatalkanPerawatan();
        Utility.hardWait(20);
        commonPage.openURL(urlAfterLogin);
        homePage.clickRawatJalan();
        rjPage.clickPencarian();
        rjPage.fillNoKartuManual("7901072300000011");
        rjPage.clickBtnCari();
        Utility.hardWait(5);
        rjPage.fillNoKlaim();
        rjPage.clickBtnCari();
        Utility.hardWait(5);
        rjPage.verifyStatusPendaftaranDibatalkan();
    }


    @Test(testName = "Pendaftaran Rawat Jalan member inner limit (Positive Case)")
    public void memberInnerLimit() throws InterruptedException {
        HomePage homePage = new HomePage(driver, explicitWait);
        ListRJPage rjPage = new ListRJPage(driver, explicitWait);
        PendaftaranRJPage daftar = new PendaftaranRJPage(driver,explicitWait);
        homePage.clickRawatJalan();
        rjPage.clickBtnPendaftaran();
        daftar.inputCardNum("7901072300000009");
        daftar.inputDOB("18031985");
        daftar.clickJenisPerawatan();
        daftar.fillJenisPerawatan(PendaftaranRJPage.JenisPerawatan.RAWATJALAN);
        daftar.clickBtnCariDataPasien();
        Utility.hardWait(5);
        Assert.assertTrue(daftar.memberInnerLimitIsDisplayed());
    }

    @Test(testName = "Pendaftaran Rawat Jalan member As Charge (Positive Case)")
    public void memberAsCharge() throws InterruptedException {
        HomePage homePage = new HomePage(driver, explicitWait);
        ListRJPage rjPage = new ListRJPage(driver, explicitWait);
        CommonPage commonPage = new CommonPage(driver,explicitWait);
        PendaftaranRJPage daftar = new PendaftaranRJPage(driver,explicitWait);
        homePage.clickRawatJalan();
        rjPage.clickBtnPendaftaran();
        daftar.inputCardNum("7899062200000003");
        daftar.inputDOB("31031993");
        daftar.clickJenisPerawatan();
        daftar.fillJenisPerawatan(PendaftaranRJPage.JenisPerawatan.RAWATJALAN);
        daftar.clickBtnCariDataPasien();
        Assert.assertTrue(daftar.memberAsCharge());
    }

}
