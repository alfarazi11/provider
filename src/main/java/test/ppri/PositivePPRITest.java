package test.ppri;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.CommonPage;
import page.HomePage;
import page.LoginPage;
import page.TxtErrorPage;
import page.pengesahantagihan.CetakStrukTagihanPage;
import page.pengesahantagihan.DetailPengesahanPage;
import page.pengesahantagihan.FormTagihanPage;
import page.pengesahantagihan.ListPengesahanTagihanPage;
import page.rawatjalan.*;
import test.BaseWebTest;
import utils.Utility;

import java.io.IOException;

public class PositivePPRITest extends BaseWebTest {

    @BeforeMethod
    public void login() throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage(driver,explicitWait);
        loginPage.login();
    }


    @Test(testName = "User provider melakukan perawatan dirumah sakit lain, dan kondisi post RI masih berlaku DXM-506 ")
    public void registerRJWithConditionPostRIStillActive() throws InterruptedException {
        HomePage homePage = new HomePage(driver, explicitWait);
        ListRJPage rjPage = new ListRJPage(driver, explicitWait);
        PendaftaranRJPage daftar = new PendaftaranRJPage(driver, explicitWait);
        CommonPage commonPage = new CommonPage(driver, explicitWait);
        KonfirmasiPage konfirmasi = new KonfirmasiPage(driver, explicitWait);
        CetakStrukPage struk = new CetakStrukPage(driver, explicitWait);
        DetailPerawatanPage detail = new DetailPerawatanPage(driver, explicitWait);
        ListPengesahanTagihanPage pengesahanPage = new ListPengesahanTagihanPage(driver, explicitWait);
        FormTagihanPage tagihanPage = new FormTagihanPage(driver, explicitWait);
        DetailPengesahanPage detailPengesahanPage = new DetailPengesahanPage(driver,explicitWait);
        CetakStrukTagihanPage strukTagihan = new CetakStrukTagihanPage(driver,explicitWait);
        TxtErrorPage errorPage = new TxtErrorPage(driver, explicitWait);
        Utility.hardWait(3);
        commonPage.openURL(urlAfterLogin);
        homePage.clickRawatJalan();
        rjPage.clickBtnPendaftaran();
        daftar.clickBtnCariDataPasien();
        Assert.assertTrue(daftar.verifyColmnNoCardMandatory());
        daftar.inputCardNum("'9999202000000001"); // 9999202000000001 01111994
        daftar.clickBtnCariDataPasien();
        Assert.assertTrue(daftar.verifyColmnTglLhrMandatory());
        daftar.inputDOB("01111994");
        daftar.clickBtnCariDataPasien();
        Assert.assertTrue(daftar.verifyColmnJnsPrwtanMandatory());
        daftar.clickJenisPerawatan();
        daftar.fillJenisPerawatan(PendaftaranRJPage.JenisPerawatan.RAWATJALAN);
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
        String manfaat = daftar.getTxtInformManfaat();
        daftar.scrollUntilBtnDaftarkan();
        daftar.clickBtnDaftarkan();
        Thread.sleep(5000);
        konfirmasi.inputCaptcha("999");
        konfirmasi.scrollUntilBtnYa();
        konfirmasi.clickBtnYa();

        //Informasi Cetak Struk
        String strukPayor = struk.getTxtPayor();
        String strukNmrKartu = struk.getTxtNoKartu();
        String strukNama = struk.getTxtNamaPeserta();
        String strukStatus = struk.getTxtStatus();
        String strukNoPolis = struk.getTxtNoPolis();
        String strukPemegangPolis = struk.getTxtPemegangPolis();

        Assert.assertEquals(payor,strukPayor);
        Assert.assertEquals(nama,strukNama);
        Assert.assertEquals(nmrKartu,strukNmrKartu);
        Assert.assertEquals(status,strukStatus);
        Assert.assertEquals(nama,strukNama);
        Assert.assertEquals(noPolis,strukNoPolis);
        Assert.assertEquals(pemegangPolis,strukPemegangPolis);
        struk.clickBtnTutup();
        Utility.hardWait(10);
        rjPage.clickPencarian();
        rjPage.fillNoKartuManual("9999202000000001");
        rjPage.clickJenisPerawatan();
        rjPage.dropdownJenisPerawatan(ListRJPage.JenisPerawatan.RAWATJALAN);
        rjPage.clickBtnCari();
        commonPage.scrollDownByPixel();
        rjPage.verifyStatusPendaftaranBerhasil();
        rjPage.clickClaimNo();
        String detailManfaat = detail.getTxtManfaat();
        String detailNama = detail.getTxtNama();
        String detailNmrKartu = detail.getTxtNmrKartu();
        String detailJnsKelamin = detail.getTxtJnsKelamin();
        String detailPayor = detail.getTxtPayor();
        String detailStatus = detail.getTxtStatus();

        Assert.assertEquals(manfaat,detailManfaat);
        Assert.assertEquals(nama,detailNama);
        Assert.assertEquals(nmrKartu,detailNmrKartu);
        Assert.assertEquals(jnsKelamin,detailJnsKelamin);
        Assert.assertEquals(payor,detailPayor);
        Assert.assertEquals("Pendaftaran Berhasil",detailStatus);

        homePage.clickPengesahanTagihan();
        pengesahanPage.clickPencarian();
        pengesahanPage.fillNoKartuManual("7901072300000007");
        pengesahanPage.clickJenisPerawatan();
        pengesahanPage.dropdownJenisPerawatan(ListPengesahanTagihanPage.JenisPerawatan.RAWATJALAN);
        //Detail Tagihan
        pengesahanPage.clickClaimNo();
        String noKartu = detailPengesahanPage.getTxtNoKartu();
        String namaPP = detailPengesahanPage.getTxtNama();
        String jnsKelaminPP = detailPengesahanPage.getTxtJnsKelamin();
        String karyawan = detailPengesahanPage.getTxtKaryawan();
        String statusTagihan = detailPengesahanPage.getTxtStatusTagihan();
        String payorPP = detailPengesahanPage.getTxtPayor();

        Assert.assertEquals(detailNmrKartu,noKartu);
        Assert.assertEquals(detailNama,namaPP);
        Assert.assertEquals(detailJnsKelamin,jnsKelaminPP);
        Assert.assertEquals("Menunggu Tagihan",statusTagihan);
        Assert.assertEquals(detailPayor,payorPP);

        detailPengesahanPage.clickBtnLngkpTagihan();
        Thread.sleep(5000);
        tagihanPage.clickPilihDiagnosis();
        tagihanPage.inputKodeDiagnosa("A15");
        Utility.hardWait(3);
        tagihanPage.clickCheckbox1();
        tagihanPage.clearColmKodeDiagnosa();
        tagihanPage.inputKodeDiagnosa("A03");
        Utility.hardWait(3);
        tagihanPage.clickCheckbox1();
        tagihanPage.clearColmKodeDiagnosa();
        tagihanPage.inputKodeDiagnosa("O24");
        Utility.hardWait(3);
        tagihanPage.clickCheckbox1();
        tagihanPage.clickBtnKirim();
        tagihanPage.inputBiayaFisioterapi("10");
        tagihanPage.inputBiayaLabDiagnos("230");
        tagihanPage.scrollUntilBtnProsesTagihan();
        tagihanPage.clickProsesTagihan();
        konfirmasi.scrollUntilBtnKirim();
        konfirmasi.clickBtnKirimKonfirmasi();
        errorPage.txtErrCaptchaNotNull();
        konfirmasi.inputCaptcha("999");
        konfirmasi.scrollUntilBtnKirim();
        konfirmasi.clickBtnKirimKonfirmasi();

        String tagihanPayor = strukTagihan.getTxtPayor();
        String tagihanNmrKartu = strukTagihan.getTxtNmrKartu();
        String tagihanNama = strukTagihan.getTxtNama();
        String tagihanKaryawan = strukTagihan.getTxtKaryawan();

        Assert.assertEquals(payor,tagihanPayor);
        Assert.assertEquals(noKartu,tagihanNmrKartu);
        Assert.assertEquals(nama,tagihanNama);
        Assert.assertEquals(karyawan,tagihanKaryawan);

        strukTagihan.clickBtnTutup();
        Utility.hardWait(5);

    }
}
