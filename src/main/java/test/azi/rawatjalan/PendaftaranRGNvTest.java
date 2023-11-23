package test.azi.rawatjalan;

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

public class PendaftaranRGNvTest extends BaseWebTest {
    @BeforeMethod
    public void login() throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage(driver,explicitWait);
        loginPage.login();
    }

    @Test()
    public void userAlreadyRegisterWithSameTreatmentDT() throws InterruptedException {
        HomePage homePage = new HomePage(driver, explicitWait);
        ListRJPage rjPage = new ListRJPage(driver, explicitWait);
        PendaftaranRJPage daftar = new PendaftaranRJPage(driver,explicitWait);
        CommonPage commonPage = new CommonPage(driver,explicitWait);
        KonfirmasiPage confirmasiPage = new KonfirmasiPage(driver,explicitWait);
        CetakStrukPage struk = new CetakStrukPage(driver,explicitWait);
        KonfirmasiPage konfirmasi = new KonfirmasiPage(driver, explicitWait);
        TxtErrorPage txtError = new TxtErrorPage(driver,explicitWait);
        commonPage.openURL(urlAfterLogin);
        homePage.clickRawatJalan();
        rjPage.clickBtnPendaftaran();
        Thread.sleep(3000);
        daftar.inputCardNum("9999202000000004");
        daftar.inputDOB("13121995");
        daftar.clickJenisPerawatan();
        daftar.fillJenisPerawatan(PendaftaranRJPage.JenisPerawatan.RAWATGIGI);
        daftar.clickBtnCariDataPasien();

        //Informasi Manfaat Peserta
        String nama = daftar.getTxtNama();
        String jnsKelamin = daftar.getTxtJnsKlmn();
        String tglLahir = daftar.getTxtTglLhr();
        String status = daftar.getTxtStatus();
        String nmrKartu = daftar.getTxtNmrKart();
        String noPolis = daftar.getTxtNmrPolis();
        String pemegangPolis = daftar.getTxtNamaPemegangPolis();
        String payor = daftar.getTxtPayor();

        Assert.assertEquals("DUMMY 4",nama);
        Assert.assertEquals("Perempuan",jnsKelamin);
        Assert.assertEquals("13-12-1995",tglLahir);
        Assert.assertEquals("KARYAWAN",status);
        Assert.assertEquals("9999202000000004",nmrKartu);
        Assert.assertEquals("POLISSATU14072023",noPolis);
        Assert.assertEquals("DUMMY TESTING JUNI",pemegangPolis);
        Assert.assertEquals("PT Teknologi Pamadya Analitika (MEDITAP)",payor);

        daftar.scrollUntilBtnDaftarkan();
        daftar.clickBtnDaftarkan();
        confirmasiPage.inputCaptcha("999");
        confirmasiPage.scrollUntilBtnYa();
        confirmasiPage.clickBtnYa();
        Thread.sleep(15000);
        struk.clickBtnTutup();
        Utility.hardWait(10);
        rjPage.verifyStatusPendaftaranBerhasil();

        rjPage.clickBtnPendaftaran();
        daftar.inputCardNum("9999202000000004");
        daftar.inputDOB("13121995");
        daftar.clickJenisPerawatan();
        daftar.fillJenisPerawatan(PendaftaranRJPage.JenisPerawatan.RAWATGIGI);
        daftar.clickBtnCariDataPasien();
        Utility.hardWait(5);
        Assert.assertTrue(txtError.txtErrPesertaSudahTerdaftar());
//        commonPage.openURL(urlLive);
        homePage.clickRawatJalan();
        rjPage.clickPencarian();
        rjPage.fillNoKartuManual("9999202000000004");
        rjPage.clickStatus();
        rjPage.dropdownStatus(ListRJPage.Status.PENDAFTARANBERHASIL);
        rjPage.clickBtnCari();
        Utility.hardWait(5);
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
        rjPage.fillNoKartuManual("9999202000000004");
        rjPage.clickBtnCari();
        Utility.hardWait(5);
        rjPage.fillNoKlaim();
        rjPage.clickBtnCari();
        Utility.hardWait(5);
        rjPage.verifyStatusPendaftaranDibatalkan();
    }

}
