package test.azi.rawatjalan;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.*;
import page.pengesahantagihan.CetakStrukTagihanPage;
import page.rawatjalan.CetakStrukPage;
import page.rawatjalan.DetailPerawatanPage;
import page.rawatjalan.KonfirmasiPage;
import page.pengesahantagihan.DetailPengesahanPage;
import page.pengesahantagihan.FormTagihanPage;
import page.pengesahantagihan.ListPengesahanTagihanPage;
import page.rawatjalan.*;
import test.BaseWebTest;
import utils.Utility;

import java.io.IOException;

public class PembatalanRJTest extends BaseWebTest {

    @BeforeMethod
    public void login() throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage(driver,explicitWait);
        loginPage.login();
    }
    // harus ditambahkan param captcha saat masuk ke detail perawatan
    @Test(testName = "Pembatalan Rawat Jalan dari detail rawat jalan(Positive Case)",priority = 1)
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

        @Test(testName = "Pembatalan Rawat Jalan dari listing rawat jalan(Positive Case)")
    public void cancelRegistFromListing() throws InterruptedException {
        HomePage homePage = new HomePage(driver, explicitWait);
        ListRJPage rjPage = new ListRJPage(driver, explicitWait);
        PendaftaranRJPage daftar = new PendaftaranRJPage(driver,explicitWait);
        CommonPage commonPage = new CommonPage(driver,explicitWait);
        KonfirmasiPage confirmasiPage = new KonfirmasiPage(driver,explicitWait);
        CetakStrukPage struk = new CetakStrukPage(driver,explicitWait);
        commonPage.openURL(urlAfterLogin);
        homePage.clickRawatJalan();
        rjPage.clickBtnPendaftaran();
        daftar.inputCardNum("7899062200000003");
        daftar.inputDOB("31031993");
        daftar.clickJenisPerawatan();
        daftar.fillJenisPerawatan(PendaftaranRJPage.JenisPerawatan.RAWATGIGI);
        daftar.clickBtnCariDataPasien();
        Utility.hardWait(15);
        daftar.scrollUntilBtnDaftarkan();
        daftar.clickBtnDaftarkan();
        confirmasiPage.inputCaptcha("999");
        confirmasiPage.scrollUntilBtnYa();
        confirmasiPage.clickBtnYa();
        struk.clickBtnTutup();
        rjPage.verifyStatusPendaftaranBerhasil();
//        commonPage.openURL(urlLive);
        homePage.clickRawatJalan();
        rjPage.clickPencarian();
        rjPage.fillNoKartuManual("7899062200000003");
        rjPage.clickJenisPerawatan();
        rjPage.dropdownJenisPerawatan(ListRJPage.JenisPerawatan.RAWATGIGI);
        rjPage.clickBtnCari();
        Utility.hardWait(5);
        rjPage.fillNoKlaim();
        rjPage.clickBtnCari();
        Utility.hardWait(5);
        rjPage.scrollUntilTxtBtnBatalkan();
        rjPage.clickTxtBtnBatalkan();
        Utility.hardWait(5);
        confirmasiPage.inputAlasanDibatalkanOutpatient("SALAH MANFAAT");
        confirmasiPage.inputCaptcha("999");
        confirmasiPage.scrollUntilBtnBatalkanPerawatan();
        Utility.hardWait(3);
        confirmasiPage.clickBtnBatalkanPerawatan();
        Utility.hardWait(45);
        commonPage.openURL(urlAfterLogin);
//        homePage.clickPengesahanTagihan();
        homePage.clickRawatJalan();
        rjPage.clickPencarian();
        rjPage.fillNoKartuManual("7899062200000003");
        rjPage.clickJenisPerawatan();
        rjPage.dropdownJenisPerawatan(ListRJPage.JenisPerawatan.RAWATGIGI);
        rjPage.clickBtnCari();
//        commonPage.scrollDownByPixel();
        Utility.hardWait(10);
        Assert.assertTrue(rjPage.verifyStatusPendaftaranDibatalkan());

    }

    @Test(testName = "Cancel registration process with completed Pengesahan Tagihan DXM-99(Negative Case)")
    public void CancelRegisWithCompletedPengesahanTagihan() throws InterruptedException {
        HomePage homePage = new HomePage(driver, explicitWait);
        ListRJPage rjPage = new ListRJPage(driver, explicitWait);
        PendaftaranRJPage daftar = new PendaftaranRJPage(driver, explicitWait);
        CommonPage commonPage = new CommonPage(driver, explicitWait);
        KonfirmasiPage konfirmasi = new KonfirmasiPage(driver, explicitWait);
        CetakStrukPage struk = new CetakStrukPage(driver, explicitWait);
        ListPengesahanTagihanPage pengesahanPage = new ListPengesahanTagihanPage(driver,explicitWait);
        FormTagihanPage tagihanPage = new FormTagihanPage(driver,explicitWait);
        TxtErrorPage txtError = new TxtErrorPage(driver,explicitWait);
        DetailPerawatanPage detailPerawatanPage = new DetailPerawatanPage(driver,explicitWait);
        DetailPengesahanPage detailPengesahanPage = new DetailPengesahanPage(driver,explicitWait);
        CetakStrukTagihanPage strukTagihan = new CetakStrukTagihanPage(driver,explicitWait);
        commonPage.openURL(urlAfterLogin);
        homePage.clickRawatJalan();
        rjPage.clickBtnPendaftaran();
        daftar.inputCardNum("7901072300000009");
        daftar.inputDOB("18031985");
        daftar.clickJenisPerawatan();
        daftar.fillJenisPerawatan(PendaftaranRJPage.JenisPerawatan.RAWATJALAN);
        daftar.clickBtnCariDataPasien();
        Utility.hardWait(5);
        daftar.scrollUntilBtnDaftarkan();
        daftar.clickBtnDaftarkan();
        konfirmasi.inputCaptcha("999");
        konfirmasi.scrollUntilBtnYa();
        konfirmasi.clickBtnYa();
//        Thread.sleep(15000);
        struk.clickBtnTutup();
//        Thread.sleep(5000);
        rjPage.clickPencarian();
        rjPage.fillNoKartuManual("7901072300000009");
        rjPage.clickBtnCari();
        Utility.hardWait(5);
        commonPage.scrollDownByPixel();
        Assert.assertTrue(rjPage.verifyStatusPendaftaranBerhasil());


        //Pengesahan Tagihan
        commonPage.openURL(urlAfterLogin);
        homePage.clickPengesahanTagihan();
        Thread.sleep(3000);
        pengesahanPage.clickPencarian();
        pengesahanPage.fillNoKartuManual("7901072300000009");
//        pengesahanPage.scrollUntilBtnCari();
        pengesahanPage.clickBtnCari();
        Utility.hardWait(5);
        pengesahanPage.scrollUntilBtnLengkapi();
        pengesahanPage.clickLengkapi();
        Thread.sleep(5000);
        tagihanPage.clickPilihDiagnosis();
        tagihanPage.inputKodeDiagnosa("A15");
        tagihanPage.clickCheckbox1();
        tagihanPage.clickCheckbox2();
        tagihanPage.clickBtnKirim();
        tagihanPage.inputBiayaFisioterapi("220");
        tagihanPage.inputBiayaLabDiagnos("230");
        tagihanPage.scrollUntilBtnProsesTagihan();
        tagihanPage.clickProsesTagihan();
        konfirmasi.inputCaptcha("999");
        konfirmasi.scrollUntilBtnKirim();
        konfirmasi.clickBtnKirimKonfirmasi();
        Thread.sleep(15000);
        strukTagihan.clickBtnTutup();
        Thread.sleep(5000);
        pengesahanPage.clickPencarian();
        pengesahanPage.clickStatusTagihanSelesai();
        pengesahanPage.clickBtnCari();
        Utility.hardWait(5);
        pengesahanPage.fillNoKartuManual("7901072300000009");
        pengesahanPage.clickBtnCari();
        Utility.hardWait(5);
        commonPage.scrollDownByPixel();
        Assert.assertTrue(pengesahanPage.statusTagihanSelesai());
//
//        //cancel regis
        commonPage.openURL(urlAfterLogin);
        homePage.clickRawatJalan();
        rjPage.clickBtnPendaftaran();
        daftar.inputCardNum("7901072300000009");
        daftar.inputDOB("18031985");
        daftar.clickJenisPerawatan();
        daftar.fillJenisPerawatan(PendaftaranRJPage.JenisPerawatan.RAWATJALAN);
        daftar.clickBtnCariDataPasien();
        Utility.hardWait(15);
        daftar.scrollUntilBtnDaftarkan();
        daftar.clickBtnDaftarkan();
//        Thread.sleep(5000);
        konfirmasi.clickBtnBatalkanTransaksi();
        konfirmasi.inputColmnPIC("Automation");
        konfirmasi.inputColmnBagian("Divisi Testing Automation");
        konfirmasi.inputColmnAlasan("Testing Automation");
        konfirmasi.scrollUntilBtnBatalkanPerawatan();
        konfirmasi.clickBtnBatalkanPerawatan();
        Assert.assertTrue(txtError.txtErrCaptchaNotNull());
        konfirmasi.inputCaptcha("999");
        konfirmasi.scrollUntilBtnBatalkanPerawatan();
        konfirmasi.clickBtnBatalkanPerawatan();
        Utility.hardWait(45); //wait untuk handle agar void settlement reason tidak  undefined
        homePage.clickRawatJalan();
        rjPage.clickPencarian();
        rjPage.fillNoKartuManual("7901072300000009");
        rjPage.clickBtnCari();
        Thread.sleep(5000);
        commonPage.scrollDownByPixel();
        Assert.assertTrue(rjPage.verifyStatusPendaftaranDibatalkan());
        rjPage.clickClaimNo();
        Assert.assertTrue(detailPerawatanPage.verifyTagihanDibatalkan());
        homePage.clickPengesahanTagihan();
        pengesahanPage.clickPencarian();
        pengesahanPage.clickStatusTagihanDibatalkan();
        pengesahanPage.clickBtnCari();
        commonPage.scrollDownByPixel();
        Assert.assertTrue(pengesahanPage.statusTagihanDibatalkan());
        pengesahanPage.clickClaimNo();
        Assert.assertTrue(detailPengesahanPage.verifyTagihanDibatalkan());
        Assert.assertTrue(detailPengesahanPage.verifyStatusDibatalkan());

    }

    //    Menunggu perbaikan parameter captcha
//    @Test(testName = "Pendaftaran Priority Member dan Cancel Registrasi dari Detail")
    public void priorityMemberAndCancelRegisFromDetail() throws InterruptedException {
        HomePage homePage = new HomePage(driver,explicitWait);
        ListRJPage rjPage = new ListRJPage(driver,explicitWait);
        PendaftaranRJPage daftar = new PendaftaranRJPage(driver,explicitWait);
        KonfirmasiPage konfirmasi = new KonfirmasiPage(driver,explicitWait);
        CetakStrukPage struk = new CetakStrukPage(driver,explicitWait);
        DetailPerawatanPage detailPerawatanPage = new DetailPerawatanPage(driver,explicitWait);
        CommonPage commonPage = new CommonPage(driver,explicitWait);
        commonPage.openURL(urlAfterLogin);
        homePage.clickRawatJalan();
        rjPage.clickBtnPendaftaran();
        daftar.inputCardNum("7901072300000008");
        daftar.inputDOB("02021980");
        daftar.clickJenisPerawatan();
        daftar.fillJenisPerawatan(PendaftaranRJPage.JenisPerawatan.RAWATJALAN);
        daftar.clickBtnCariDataPasien();
        Utility.hardWait(2);
        daftar.scrollUntilBtnDaftarkan();
        Utility.hardWait(2);
        daftar.clickBtnDaftarkan();
        konfirmasi.inputCaptcha("999");
        konfirmasi.scrollUntilBtnYa();
        konfirmasi.clickBtnYa();
        Thread.sleep(15000);
        Assert.assertTrue(struk.verifyPriorityMember());
        struk.clickBtnTutup();
        Thread.sleep(10000);
        rjPage.clickPencarian();
        rjPage.fillNoKlaim();
        rjPage.clickBtnCari();
        commonPage.scrollDownByPixel();
        rjPage.clickClaimNo();
        detailPerawatanPage.clickBtnBatalkan();
        konfirmasi.inputAlasanDibatalkanOutpatient("SALAH MANFAAT");
        konfirmasi.inputCaptcha("999");
        konfirmasi.clickBtnBatalkanPerawatan();
        Utility.hardWait(10);
        rjPage.verifyStatusPendaftaranDibatalkan();

    }



    //    @Test(testName = "Batalkan Pengesahan tagihan DXM-98 (Negative Case)")//pada new provider belum ada cancel pengesahan tagihan
    public void cancelPengesahanTagihan() throws InterruptedException {
        HomePage homePage = new HomePage(driver, explicitWait);
        ListRJPage rjPage = new ListRJPage(driver, explicitWait);
        PendaftaranRJPage daftar = new PendaftaranRJPage(driver, explicitWait);
        CommonPage commonPage = new CommonPage(driver, explicitWait);
        KonfirmasiPage konfirmasi = new KonfirmasiPage(driver, explicitWait);
        CetakStrukPage struk = new CetakStrukPage(driver, explicitWait);
        ListPengesahanTagihanPage pengesahanPage = new ListPengesahanTagihanPage(driver,explicitWait);
        FormTagihanPage tagihanPage = new FormTagihanPage(driver,explicitWait);
        CetakStrukTagihanPage strukTagihan = new CetakStrukTagihanPage(driver,explicitWait);
        commonPage.openURL(urlAfterLogin);
        homePage.clickRawatJalan();
        rjPage.clickBtnPendaftaran();
        daftar.inputCardNum("7901072300000011");
        daftar.inputDOB("12061986");
        daftar.clickJenisPerawatan();
        daftar.fillJenisPerawatan(PendaftaranRJPage.JenisPerawatan.RAWATJALAN);
        daftar.clickBtnCariDataPasien();
        Utility.hardWait(45);
        daftar.scrollUntilBtnDaftarkan();
        daftar.clickBtnDaftarkan();
        konfirmasi.inputCaptcha("999");
        konfirmasi.scrollUntilBtnYa();
        konfirmasi.clickBtnYa();
//        Utility.hardWait(15);
        struk.clickBtnTutup();
        rjPage.verifyStatusPendaftaranBerhasil();

        //Pengesahan Tagihan
        homePage.clickPengesahanTagihan();
//        Utility.hardWait(2);
        pengesahanPage.clickLengkapi();
        Utility.hardWait(3);
        tagihanPage.clickPilihDiagnosis();
        tagihanPage.inputKodeDiagnosa("A15");
        tagihanPage.clickCheckbox1();
        tagihanPage.clickCheckbox2();
        tagihanPage.clickBtnKirim();
        tagihanPage.inputBiayaFisioterapi("220");
        tagihanPage.inputBiayaLabDiagnos("230");
        tagihanPage.scrollUntilBtnProsesTagihan();
        tagihanPage.clickProsesTagihan();
        konfirmasi.inputCaptcha("999");
        konfirmasi.clickBtnKirimKonfirmasi();
//        Utility.hardWait(15);
        strukTagihan.clickBtnTutup();
        Assert.assertTrue(pengesahanPage.statusTagihanSelesai());
//        commonPage.openURL("");
    }
}
