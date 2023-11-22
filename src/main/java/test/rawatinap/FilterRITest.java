package test.rawatinap;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.CommonPage;
import page.HomePage;
import page.LoginPage;
import page.rawatinap.ListRIPage;
import test.BaseWebTest;
import utils.Utility;

import java.io.IOException;

public class FilterRITest extends BaseWebTest {

    @BeforeMethod
    public void login() throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage(driver,explicitWait);
        loginPage.login();
    }


    @Test(testName = "List Rawat Jalan Filter Baseon No Klaim (Positive) DXM-22")
    public void verifyFilterNoKlaimListRI() throws InterruptedException {
        HomePage homePage = new HomePage(driver,explicitWait);
        ListRIPage rawatInapPage = new ListRIPage(driver,explicitWait);
        CommonPage commonPage = new CommonPage(driver,explicitWait);
        commonPage.openURL(urlAfterLogin);
        homePage.clickRawatInap();
        Utility.hardWait(5);
        rawatInapPage.clickPencarian();
        rawatInapPage.fillNoKlaim();
        rawatInapPage.clickBtnCari();
        Utility.hardWait(5);
        commonPage.scrollDownByPixel();
        Assert.assertTrue(rawatInapPage.verifyFilterClaimNo());
        rawatInapPage.clickBtnHapus();
        Assert.assertTrue(rawatInapPage.claimNoIsCLear());
    }

    @Test(testName = "List Rawat Jalan Filter Baseon No Klaim (Negative) DXM-6")
    public void verifyFilterNoKlaimNegListRI() throws InterruptedException {
        HomePage homePage = new HomePage(driver,explicitWait);
        ListRIPage rawatInapPage = new ListRIPage(driver,explicitWait);
        CommonPage commonPage = new CommonPage(driver,explicitWait);
        commonPage.openURL(urlAfterLogin);
        homePage.clickRawatInap();
        Utility.hardWait(5);
        rawatInapPage.clickPencarian();
        rawatInapPage.fillNoKlaimNeg("232123432");
        rawatInapPage.clickBtnCari();
        commonPage.scrollDownByPixel();
        Utility.hardWait(5);
        Assert.assertTrue(rawatInapPage.imgEmptyIsDisplayed());
    }

    @Test(testName = "List Rawat Jalan Filter Baseon Waktu Pendaftaran (Positive) DXM-6")
    public void verifyFilterRegDateListRI() throws InterruptedException {
        HomePage homePage = new HomePage(driver,explicitWait);
        ListRIPage rawatInapPage = new ListRIPage(driver,explicitWait);
        CommonPage commonPage = new CommonPage(driver,explicitWait);
        commonPage.openURL(urlAfterLogin);
        homePage.clickRawatInap();
        Utility.hardWait(5);
        rawatInapPage.clickPencarian();
        rawatInapPage.fillRegDate();
        rawatInapPage.clickBtnCari();
//        commonPage.scrollDownByPixel();
        Utility.hardWait(5);
        Assert.assertTrue(rawatInapPage.verifyTglPendaftaran());
        rawatInapPage.clickBtnHapus();
        Assert.assertTrue(rawatInapPage.RegDateIsCLear());
    }

    @Test(testName = "List Rawat Jalan Filter Baseon Waktu Pendaftaran (Negative) DXM-6")
    public void verifyFilterRegDateNegListRI() throws InterruptedException {
        HomePage homePage = new HomePage(driver,explicitWait);
        ListRIPage rawatInapPage = new ListRIPage(driver,explicitWait);
        CommonPage commonPage = new CommonPage(driver,explicitWait);
        commonPage.openURL(urlAfterLogin);
        homePage.clickRawatInap();
        Utility.hardWait(5);
        rawatInapPage.clickPencarian();
        rawatInapPage.fillRegDateNeg("13082022");
        rawatInapPage.clickBtnCari();
        commonPage.scrollDownByPixel();
        Utility.hardWait(5);
        Assert.assertTrue(rawatInapPage.imgEmptyIsDisplayed());
    }

    @Test(testName = "List Rawat Jalan Filter Baseon No Transaksi (Positive)DXM-6")
    public void verifyFilterTransNoListRI() throws InterruptedException {
        HomePage homePage = new HomePage(driver,explicitWait);
        ListRIPage rawatInapPage = new ListRIPage(driver,explicitWait);
        CommonPage commonPage = new CommonPage(driver,explicitWait);
        commonPage.openURL(urlAfterLogin);
        homePage.clickRawatInap();
        Utility.hardWait(5);
        rawatInapPage.clickPencarian();
        rawatInapPage.fillNoTransaksi();
        rawatInapPage.clickBtnCari();
        commonPage.scrollDownByPixel();
        Utility.hardWait(5);
        Assert.assertTrue(rawatInapPage.verifyFilterTransaksiNo());
        rawatInapPage.clickBtnHapus();
        Assert.assertTrue(rawatInapPage.transNoIsCLear());
    }

    @Test(testName = "List Rawat Jalan Filter Baseon No Transaksi (Negative)DXM-6")
    public void verifyFilterTransNoNegListRI() throws InterruptedException {
        HomePage homePage = new HomePage(driver,explicitWait);
        ListRIPage rawatInapPage = new ListRIPage(driver,explicitWait);
        CommonPage commonPage = new CommonPage(driver,explicitWait);
        commonPage.openURL(urlAfterLogin);
        homePage.clickRawatInap();
        Utility.hardWait(5);
        rawatInapPage.clickPencarian();
        rawatInapPage.fillNoTransaksiNeg("999999");
        rawatInapPage.clickBtnCari();
        commonPage.scrollDownByPixel();
        Utility.hardWait(5);
        Assert.assertTrue(rawatInapPage.imgEmptyIsDisplayed());
    }

    @Test(testName = "List Rawat Jalan Filter Baseon No Kartu (Positive)DXM-6")
    public void verifyFilterCardNoListRI() throws InterruptedException {
        HomePage homePage = new HomePage(driver,explicitWait);
        ListRIPage rawatInapPage = new ListRIPage(driver,explicitWait);
        CommonPage commonPage = new CommonPage(driver,explicitWait);
        commonPage.openURL(urlAfterLogin);
        homePage.clickRawatInap();
        Utility.hardWait(5);
        rawatInapPage.clickPencarian();
        rawatInapPage.fillNoKartu();
        rawatInapPage.clickBtnCari();
        Utility.hardWait(5);
        Assert.assertTrue(rawatInapPage.verifyFilterCardNo());
        rawatInapPage.clickBtnHapus();
        Assert.assertTrue(rawatInapPage.cardNoIsCLear());
    }

    @Test(testName = "List Rawat Jalan Filter Baseon No Kartu (Negative)DXM-6")
    public void verifyFilterCardNoNegListRI() throws InterruptedException {
        HomePage homePage = new HomePage(driver,explicitWait);
        ListRIPage rawatInapPage = new ListRIPage(driver,explicitWait);
        CommonPage commonPage = new CommonPage(driver,explicitWait);
        commonPage.openURL(urlAfterLogin);
        homePage.clickRawatInap();
        Utility.hardWait(5);
        rawatInapPage.clickPencarian();
        rawatInapPage.fillNoKartuNeg("999999");
        rawatInapPage.clickBtnCari();
//        commonPage.scrollDownByPixel();
        Utility.hardWait(5);
        Assert.assertTrue(rawatInapPage.imgEmptyIsDisplayed());
    }

    @Test(testName = "List Rawat Jalan Filter Baseon Nama Peserta (Positive)DXM-6")
    public void verifyFilterParticipantNameListRI() throws InterruptedException {
        HomePage homePage = new HomePage(driver,explicitWait);
        ListRIPage rawatInapPage = new ListRIPage(driver,explicitWait);
        CommonPage commonPage = new CommonPage(driver,explicitWait);
        commonPage.openURL(urlAfterLogin);
        homePage.clickRawatInap();
        Utility.hardWait(5);
        rawatInapPage.clickPencarian();
        rawatInapPage.fillNamaPeserta();
        rawatInapPage.clickBtnCari();
        Utility.hardWait(5);
        Assert.assertTrue(rawatInapPage.verifyFilterPaticipateName());
        rawatInapPage.clickBtnHapus();
        Assert.assertTrue(rawatInapPage.participateNameIsCLear());
    }

    @Test(testName = "List Rawat Jalan Filter Baseon Nama Peserta (Negative)DXM-6")
    public void verifyFilterParticipantNameNegListRI() throws InterruptedException {
        HomePage homePage = new HomePage(driver,explicitWait);
        ListRIPage rawatInapPage = new ListRIPage(driver,explicitWait);
        CommonPage commonPage = new CommonPage(driver,explicitWait);
        commonPage.openURL(urlAfterLogin);
        homePage.clickRawatInap();
        Utility.hardWait(5);
        rawatInapPage.clickPencarian();
        rawatInapPage.fillNamaPesertaNeg("Dudung bin maun");
        rawatInapPage.clickBtnCari();
        commonPage.scrollDownByPixel();
        Utility.hardWait(5);
        Assert.assertTrue(rawatInapPage.imgEmptyIsDisplayed());
    }

    @Test(testName = "List Rawat Jalan Filter Baseon Jenis Perawatan (Positive)DXM-6")
    public void verifyFilterTypeTreatmentListRI() throws InterruptedException {
        HomePage homePage = new HomePage(driver,explicitWait);
        ListRIPage rawatInapPage = new ListRIPage(driver,explicitWait);
        CommonPage commonPage = new CommonPage(driver,explicitWait);
        commonPage.openURL(urlAfterLogin);
        homePage.clickRawatInap();
        Utility.hardWait(5);
        rawatInapPage.clickPencarian();
        rawatInapPage.clickJenisPerawatan();
        rawatInapPage.dropdownJenisPerawatan(ListRIPage.JenisPerawatan.RAWATINAP);
        rawatInapPage.clickBtnCari();
        Utility.hardWait(5);
        Assert.assertTrue(rawatInapPage.verifyFilterJenisPerawatanRI());
        rawatInapPage.clickJenisPerawatan();
        rawatInapPage.dropdownJenisPerawatan(ListRIPage.JenisPerawatan.RAWATBERSALIN);
        rawatInapPage.clickBtnCari();
        Utility.hardWait(5);
        Assert.assertTrue(rawatInapPage.verifyFilterJenisPerawatanRB());
        commonPage.scrollUpByPixel();
        rawatInapPage.clickBtnHapus();
        rawatInapPage.jenisPerawatanIsCLear();
    }

    @Test(testName = "List Rawat Jalan Filter Baseon Status (Positive)DXM-6")
    public void verifyFilterStatusListRI() throws InterruptedException {
        HomePage homePage = new HomePage(driver,explicitWait);
        ListRIPage rawatInapPage = new ListRIPage(driver,explicitWait);
        CommonPage commonPage = new CommonPage(driver,explicitWait);
        commonPage.openURL(urlAfterLogin);
        homePage.clickRawatInap();
        Utility.hardWait(5);
        rawatInapPage.clickPencarian();
        rawatInapPage.clickStatus();
        rawatInapPage.dropdownStatus(ListRIPage.Status.PENDAFTARANBERHASIL);
        rawatInapPage.clickBtnCari();
        Utility.hardWait(5);
        Assert.assertTrue(rawatInapPage.verifyStatusPendaftaranBerhasil());
        rawatInapPage.clickStatus();
        rawatInapPage.dropdownStatus(ListRIPage.Status.PENDAFTARANDIBATALKAN);
        rawatInapPage.clickBtnCari();
        Utility.hardWait(5);
        Assert.assertTrue(rawatInapPage.verifyStatusPendaftaranDibatalkan());
        rawatInapPage.clickStatus();
        rawatInapPage.dropdownStatus(ListRIPage.Status.PERAWATANSELESAI);
        rawatInapPage.clickBtnCari();
        Utility.hardWait(5);
        Assert.assertTrue(rawatInapPage.verifyFilterStatusPerawatanSelesai());
        commonPage.scrollUpByPixel();
        rawatInapPage.clickBtnHapus();
        rawatInapPage.statusIsCLear();
    }

    @Test(testName = "List Rawat Jalan Multiple Filter  (Positive)DXM-6")
    public void verifyMultipleFilterListRI() throws InterruptedException {
        HomePage homePage = new HomePage(driver,explicitWait);
        ListRIPage rawatInapPage = new ListRIPage(driver,explicitWait);
        CommonPage commonPage = new CommonPage(driver,explicitWait);
        commonPage.openURL(urlAfterLogin);
        homePage.clickRawatInap();
        Utility.hardWait(5);
        rawatInapPage.clickPencarian();
        rawatInapPage.fillNoKlaim();
        rawatInapPage.fillRegDate();
        rawatInapPage.fillNoTransaksi();
        rawatInapPage.fillNoKartu();
        rawatInapPage.fillNamaPeserta();
        rawatInapPage.clickBtnCari();
        Utility.hardWait(5);
        Assert.assertTrue(rawatInapPage.verifyFilterClaimNo());
        Assert.assertTrue(rawatInapPage.verifyTglPendaftaran());
        Assert.assertTrue(rawatInapPage.verifyFilterTransaksiNo());
        Assert.assertTrue(rawatInapPage.verifyFilterCardNo());
        Assert.assertTrue(rawatInapPage.verifyFilterPaticipateName());
        rawatInapPage.clickBtnHapus();
        Assert.assertTrue(rawatInapPage.claimNoIsCLear());
        Assert.assertTrue(rawatInapPage.RegDateIsCLear());
        Assert.assertTrue(rawatInapPage.transNoIsCLear());
        Assert.assertTrue(rawatInapPage.cardNoIsCLear());
        Assert.assertTrue(rawatInapPage.participateNameIsCLear());
    }

}
