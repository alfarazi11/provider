package test.rawatjalan;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.CommonPage;
import page.HomePage;
import page.LoginPage;
import page.TxtErrorPage;
import page.rawatjalan.*;
import test.BaseWebTest;
import utils.Utility;

import java.io.IOException;

public class PendaftaranRawatGigiTest extends BaseWebTest {
    @BeforeMethod
    public void login() throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage(driver,explicitWait);
        loginPage.login();
    }

    @Test()
    public void cancelRegistFromDetail() throws InterruptedException {
        HomePage homePage = new HomePage(driver, explicitWait);
        ListRJPage rjPage = new ListRJPage(driver, explicitWait);
        PendaftaranRJPage daftar = new PendaftaranRJPage(driver,explicitWait);
        CommonPage commonPage = new CommonPage(driver,explicitWait);
        KonfirmasiPage confirmasiPage = new KonfirmasiPage(driver,explicitWait);
        CetakStrukPage struk = new CetakStrukPage(driver,explicitWait);
        DetailPerawatanPage detail = new DetailPerawatanPage(driver,explicitWait);
        TxtErrorPage errorPage = new TxtErrorPage(driver,explicitWait);
        commonPage.openURL(urlAfterLogin);
        homePage.clickRawatJalan();
        rjPage.clickBtnPendaftaran();
        Thread.sleep(3000);
        daftar.inputCardNum("7901072300000007");
        daftar.inputDOB("06081989");
        daftar.clickJenisPerawatan();
        daftar.fillJenisPerawatan(PendaftaranRJPage.JenisPerawatan.RAWATJALAN);
        daftar.clickBtnCariDataPasien();
        Utility.hardWait(45);
        daftar.scrollUntilBtnDaftarkan();
        daftar.clickBtnDaftarkan();
        confirmasiPage.inputCaptcha("999");
        confirmasiPage.scrollUntilBtnYa();
        confirmasiPage.clickBtnYa();
        Thread.sleep(15000);
        struk.clickBtnTutup();
        commonPage.openURL(urlAfterLogin);
        homePage.clickRawatJalan();
        rjPage.clickPencarian();
        rjPage.fillNoKartuManual("7901072300000007");
        rjPage.clickBtnCari();
        Utility.hardWait(5);
        commonPage.scrollDownByPixel();
        rjPage.clickClaimNo();
        detail.clickBtnBatalkan();
        Thread.sleep(2000);
        confirmasiPage.inputAlasanDibatalkanOutpatient("SALAH MANFAAT");
        confirmasiPage.scrollUntilBtnBatalkanPerawatan();
        confirmasiPage.inputCaptcha("999");
        confirmasiPage.clickBtnBatalkanPerawatan();
        commonPage.openURL(urlAfterLogin);
        homePage.clickRawatJalan();
        rjPage.clickPencarian();
        rjPage.fillNoKartuManual("7901072300000007");
        rjPage.clickBtnCari();
        Utility.hardWait(5);
        rjPage.fillNoKlaim();
        rjPage.dropdownStatus(ListRJPage.Status.PENDAFTARANDIBATALKAN);
        rjPage.clickBtnCari();
        Utility.hardWait(5);
        commonPage.scrollDownByPixel();
        rjPage.verifyStatusPendaftaranDibatalkan();
        rjPage.clickClaimNo();
        Assert.assertTrue(detail.verifyTxtProviderBatalkanPerawatan());
        commonPage.scrollDownByPixel();
        Assert.assertTrue(detail.verifyTxtPendaftaranDibatalkan());

    }

}
