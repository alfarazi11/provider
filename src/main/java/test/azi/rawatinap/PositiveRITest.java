package test.azi.rawatinap;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.*;
import page.rawatinap.*;
import page.rawatjalan.DetailPerawatanPage;
import page.rawatjalan.KonfirmasiPage;
import test.BaseWebTest;
import utils.Utility;

import java.io.IOException;

public class PositiveRITest extends BaseWebTest {

    @BeforeMethod
    public void login() throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage(driver,explicitWait);
        loginPage.login();
    }

    @Test(testName = "Pendaftaran Rawat Inap (Positive Case)",priority = 1)
    public void positiveRegisterInPatient() throws InterruptedException {
        HomePage homePage = new HomePage(driver,explicitWait);
        ListRIPage riPage = new ListRIPage(driver,explicitWait);
        PendaftaranRIPage daftarRI = new PendaftaranRIPage(driver,explicitWait);
        CommonPage commonPage = new CommonPage(driver,explicitWait);
        KonfirmasiRIPage konfirmasi = new KonfirmasiRIPage(driver,explicitWait);
        CetakStrukRIPage strukPage = new CetakStrukRIPage(driver,explicitWait);
        DetailPerawatanRIPage detailPage = new DetailPerawatanRIPage(driver,explicitWait);
        commonPage.openURL(urlAfterLogin);
        homePage.clickRawatInap();
        riPage.clickBtnPendaftaran();
        daftarRI.clickBtnCariDataPasien();
        Assert.assertTrue(daftarRI.verifyColmnNoCardMandatory());
        daftarRI.inputCardNum("7901072300000007");
        daftarRI.clickBtnCariDataPasien();
        Assert.assertTrue(daftarRI.verifyColmnTglLhrMandatory());
        daftarRI.inputDOB("06081989");
        daftarRI.clickBtnCariDataPasien();
        Assert.assertTrue(daftarRI.verifyColmnJnsPrwtanMandatory());
        daftarRI.clickJenisPerawatan();
        daftarRI.fillJenisPerawatan(PendaftaranRIPage.JenisPerawatan.RAWATINAP);
        daftarRI.clickBtnCariDataPasien();
//        String jnsKelamin = daftarRI.getTxtJnsKlmn();
        String nama = daftarRI.getTxtNama();
        String payor = daftarRI.getTxtPayor();
        String nmrKartu = daftarRI.getTxtNmrKart();
        String status = daftarRI.getTxtStatus();
        String noPolis = daftarRI.getTxtNmrPolis();
        String pemegangPolis = daftarRI.getTxtNamaPemegangPolis();
        String manfaat = daftarRI.getTxtInformManfaat();
        String kamar = daftarRI.getTxtInformBiaya1();
        String ICU = daftarRI.getTxtInformBiaya2();
        String limit = daftarRI.getTxtInformBiaya3();

//        Utility.hardWait(45);
        daftarRI.scrollUntilBtnDaftarkan();
        daftarRI.clickBtnDaftarkan();
        Assert.assertTrue(konfirmasi.verifyNoKartu());
        Assert.assertTrue(konfirmasi.verifyNamaPeserta());
        Assert.assertTrue(konfirmasi.verifyTglLahir());
        Assert.assertTrue(konfirmasi.verifyNamaKaryawan());
        Assert.assertTrue(konfirmasi.verifyStatus());
        Assert.assertTrue(konfirmasi.verifyNamaPemegangPolis());
        Assert.assertTrue(konfirmasi.verifyJnsPerwtan());
        konfirmasi.inputCaptcha("999");
        daftarRI.scroolUntilBtnYa();
        daftarRI.clickBtnYa();
        String strukPayor = strukPage.getTxtPayor();
        String strukNmrKartu = strukPage.getTxtNoKartu();
        String strukNama = strukPage.getTxtNamaPeserta();
        String strukStatus = strukPage.getTxtStatus();
        String strukNoPolis = strukPage.getTxtNoPolis();
        String strukPemegangPolis = strukPage.getTxtPemegangPolis();
        String strukManfaat = strukPage.getTxtManfaat();
        String strukICU = strukPage.getTxtInformBiaya1();
        String strukKamar = strukPage.getTxtInformBiaya2();
        String strukLimit = strukPage.getTxtInformBiaya3();
        Assert.assertEquals(payor,strukPayor);
        Assert.assertEquals(nama,strukNama);
        Assert.assertEquals(nmrKartu,strukNmrKartu);
        Assert.assertEquals(status,strukStatus);
        Assert.assertEquals(nama,strukNama);
        Assert.assertEquals(noPolis,strukNoPolis);
        Assert.assertEquals(pemegangPolis,strukPemegangPolis);
        Assert.assertEquals(manfaat,strukManfaat);
        Assert.assertEquals(ICU,strukICU);
        Assert.assertEquals(kamar,strukKamar);
//        Assert.assertEquals(limit,strukLimit);
        daftarRI.clickBtnTutup();
        Thread.sleep(5000);
        riPage.verifyStatusPendaftaranBerhasil();
        riPage.clickClaimNo();
        String detailManfaat = detailPage.getTxtManfaat();
        String detailNama = detailPage.getTxtNama();
        String detailNmrKartu = detailPage.getTxtNmrKartu();
        String detailJnsKelamin = detailPage.getTxtJnsKelamin();
        String detailPayor = detailPage.getTxtPayor();
        String detailStatus = detailPage.getTxtStatus();

        Assert.assertEquals(manfaat,detailManfaat);
        Assert.assertEquals(nama,detailNama);
        Assert.assertEquals(nmrKartu,detailNmrKartu);
//        Assert.assertEquals(jnsKelamin,detailJnsKelamin);
        Assert.assertEquals(payor,detailPayor);
        Assert.assertEquals("Pendaftaran Berhasil",detailStatus);


//        String noKlaim = riPage.claimNo();
        commonPage.openURL(urlAfterLogin);
        homePage.clickRawatInap();
        riPage.verifyStatusPendaftaranBerhasil();
        riPage.clickPencarian();
        riPage.fillNoKartuManual("7901072300000007");
        riPage.clickStatus();
        riPage.dropdownStatus(ListRIPage.Status.PENDAFTARANBERHASIL);
        riPage.fillNoKlaim();
        riPage.clickBtnCari();
        Utility.hardWait(5);
        riPage.scrollUntilTxtBtnBatalkan();
        riPage.clickTxtBtnBatalkan();
        Utility.hardWait(5);
        Assert.assertTrue(konfirmasi.verifyNoTransaksi());
        konfirmasi.inputAlasanDibatalkanInpatient("SALAH MANFAAT");
        konfirmasi.inputCaptcha("999");
        konfirmasi.scrollUntilBtnBatalkanPerawatan();
        konfirmasi.clickBtnBatalkanPerawatan();
        Utility.hardWait(30);
        //menunggu perbaikan cancel dari list dinaikan ke live
        commonPage.openURL(urlAfterLogin);
        Thread.sleep(2000);
        homePage.clickRawatInap();
        riPage.clickPencarian();
        riPage.fillNoKartuManual("7901072300000007");
        riPage.clickStatus();
        riPage.dropdownStatus(ListRIPage.Status.PENDAFTARANDIBATALKAN);
        riPage.fillNoKlaim();
        riPage.clickBtnCari();
        Thread.sleep(5000);
        riPage.verifyStatusPendaftaranDibatalkan();
        riPage.clickClaimNo();
        Utility.hardWait(5);
        Assert.assertTrue(detailPage.verifyTxtProviderBatalkanPerawatan());
        Assert.assertTrue(detailPage.verifyTxtReason());
        Assert.assertTrue(detailPage.verifyTxtPendaftaranDibatalkan());



        //Process pada web Chiss
//        commonPage.openNewTab();
//        commonPage.openURL("https://demo-tpa.meditap.id/carewebapplication/WebSignOn.aspx");
//        loginChiss.inputUserID("itadmin");
//        loginChiss.inputPass("IT@dmin2023");
//        loginChiss.clickBtnLogin();
//        homeChiss.clickWebClaim();
//        commonPage.openNewTab();
//        commonPage.openURL("https://demo-tpa.meditap.id/CareWebApplication/CHISSWEBMODULE/WEBCLAIMHealth/CHPostClaimBatchFrm.aspx");
//        batchQuery.inputClaimNo("2307000864");
//        batchQuery.clickBtnSearchClaim();
//        batchQuery.clickView();
//        Thread.sleep(3000);
//        commonPage.openNewTab();
//        commonPage.openURL("https://demo-tpa.meditap.id/CareWebApplication/CHISSWEBMODULE/WEBCLAIMHealth/CHClaimInqFrm.aspx");
////        Thread.sleep(3000);
////        claimChiss.inputCardNumbWebClaim("1310101331100031");
////        claimChiss.clickBtnRetrieveClaim();
////        commonPage.scrollDownByPixel();
////        Assert.assertEquals(noKlaim,claimChiss.claimNumWebClaim());
////        claimChiss.clickCheckBox();
////        claimChiss.clickBtnCreateGL();
////        commonPage.switchFrameByID("dialog-body");
////        claimChiss.clickBtnCreateGL();
////        commonPage.acceptAlert();
////        Thread.sleep(3000);
////        Assert.assertTrue(claimChiss.verifyTxtCreateGL());
//        commonPage.switchWindow(1);
//        claimGLPage.clickBtnWebClaimGL();
////        claimGLPage.clickBtnQueryClaimGL();
//        commonPage.openNewTab();
//        commonPage.openURL("https://demo-tpa.meditap.id/CareWebApplication/CHISSWEBMODULE/WEBCLAIMGLHealth/CHClaimGLFrm.aspx");
//        claimGLPage.dropdownGLStatus(WebClaimGLPage.StatusGL.OPEN);
//        claimGLPage.clickBtnRetrieveClaimGL();
//        Thread.sleep(3000);
//        String idGL = claimGLPage.txtGLID();
//        commonPage.openNewTab();
//        commonPage.openURL("https://demo-tpa.meditap.id/CareWebApplication/CHISSWEBMODULE/WEBCLAIMGLHealth/CHClaimGLEntry.aspx?mode=EDIT&PreRegID="+idGL);
////        claimGLPage.clickBtnView();
//        claimGLPage.inputColmnReportDate("14:30");
//        claimGLPage.f2ClaimType();
//        commonPage.switchFrameByID("dialog-body");
//        claimGLPage.chooseClaimTypeIP();
//        claimGLPage.inputGuaranteeAmount("1000000");
//        claimGLPage.inputRNBAmountTreatment("1000000");
//        claimGLPage.clickBtnSaveGLData();
//        claimGLPage.clickAddNewPreDiagnosis();
//        claimGLPage.f2DiagnosisID();
//        commonPage.switchFrameByID("dialog-body");
//        claimGLPage.chooseDiagnosisA15();
//        claimGLPage.clickCheckboxFinalDiagnosis();
//        claimGLPage.clickBtnSavePreDiagnosis();
//        commonPage.acceptAlert();
//        Assert.assertTrue(claimGLPage.verifyTxtSavedSuccessfully());
//        claimGLPage.clickCLoseThisPage();
//        commonPage.scrollUpByPixel();
//        claimGLPage.clickBtnSaveGLData();
//        commonPage.acceptAlert();
//        claimGLPage.clickBtnReleaseGL();
//        commonPage.switchFrameByID("dialog-body");
//        claimGLPage.clickBtnReleaseThisClaimGL();
//        commonPage.acceptAlert();
//        commonPage.switchFrameByID("dialog-body");
//        claimGLPage.clickCLoseThisPage();
    }

    @Test(testName = "Pendaftaran Rawat Bersalin (Positive Case)",priority = 2)
    public void positiveRegisterMaternity() throws InterruptedException {
        HomePage homePage = new HomePage(driver, explicitWait);
        ListRIPage riPage = new ListRIPage(driver, explicitWait);
        PendaftaranRIPage daftarRI = new PendaftaranRIPage(driver, explicitWait);
        CommonPage commonPage = new CommonPage(driver, explicitWait);
        KonfirmasiPage konfirmasi = new KonfirmasiPage(driver, explicitWait);
        DetailPerawatanPage detailPerawatanPage = new DetailPerawatanPage(driver,explicitWait);
        commonPage.openURL(urlAfterLogin);
        homePage.clickRawatInap();
        riPage.clickBtnPendaftaran();
        daftarRI.inputCardNum("7901072300000007");
        daftarRI.inputDOB("06081989");
        daftarRI.clickJenisPerawatan();
        daftarRI.fillJenisPerawatan(PendaftaranRIPage.JenisPerawatan.RAWATBERSALIN);
        daftarRI.clickBtnCariDataPasien();
        daftarRI.scrollUntilBtnDaftarkan();
        daftarRI.clickBtnDaftarkan();
        konfirmasi.inputCaptcha("999");
        daftarRI.scroolUntilBtnYa();
        daftarRI.clickBtnYa();
        Thread.sleep(10000);
        daftarRI.clickBtnTutup();
        Thread.sleep(5000);
//        String noKlaim = riPage.claimNo();
        riPage.verifyStatusPendaftaranBerhasil();
        riPage.clickPencarian();
        riPage.fillNoKlaim();
        riPage.clickBtnCari();
        riPage.clickClaimNo();
        detailPerawatanPage.clickBtnBatalkan();
        Assert.assertTrue(konfirmasi.verifyNoTransaksi());
        konfirmasi.inputAlasanDibatalkanInpatient("SALAH MANFAAT");
        konfirmasi.inputCaptcha("999");
        konfirmasi.scrollUntilBtnBatalkanPerawatan();
        konfirmasi.clickBtnBatalkanPerawatan();
        commonPage.openURL(urlAfterLogin);
        Thread.sleep(5000);
        homePage.clickRawatInap();
        Thread.sleep(5000);
        riPage.clickClaimNo();
        detailPerawatanPage.verifyTagihanDibatalkan();
    }
}
