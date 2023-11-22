package test.rawatjalan;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.CommonPage;
import page.HomePage;
import page.LoginPage;
import page.rawatjalan.ListRJPage;
import test.BaseWebTest;
import utils.Utility;

import java.io.IOException;

public class FilterRJTest extends BaseWebTest {

    @BeforeMethod
    public void login() throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage(driver,explicitWait);
        loginPage.login();
    }


    @Test(testName = "List Rawat Jalan Filter Baseon No Klaim (Positive) DXM-6")
    public void verifyFilterNoKlaimListRJ() throws InterruptedException {
        HomePage homePage = new HomePage(driver,explicitWait);
        ListRJPage rawatJalanPage = new ListRJPage(driver,explicitWait);
        CommonPage commonPage = new CommonPage(driver,explicitWait);
        Utility.hardWait(2);
        homePage.clickRawatJalan();
        rawatJalanPage.clickPencarian();
        Utility.hardWait(2);
        rawatJalanPage.fillNoKlaim();
        rawatJalanPage.clickBtnCari();
        Utility.hardWait(5);
        commonPage.scrollDownByPixel();
        Assert.assertTrue(rawatJalanPage.verifyFilterClaimNo());
        rawatJalanPage.clickBtnHapus();
        Assert.assertTrue(rawatJalanPage.claimNoIsCLear());
    }

    @Test(testName = "List Rawat Jalan Filter Baseon No Klaim (Negative) DXM-6")
    public void verifyFilterNoKlaimNegListRJ() throws InterruptedException {
        HomePage homePage = new HomePage(driver,explicitWait);
        ListRJPage rawatJalanPage = new ListRJPage(driver,explicitWait);
        CommonPage commonPage = new CommonPage(driver,explicitWait);
        Utility.hardWait(2);
        homePage.clickRawatJalan();
        rawatJalanPage.clickPencarian();
        Utility.hardWait(2);
        rawatJalanPage.fillNoKlaimNeg("232123432");
        rawatJalanPage.clickBtnCari();
        commonPage.scrollDownByPixel();
        Utility.hardWait(5);
        Assert.assertTrue(rawatJalanPage.imgEmptyIsDisplayed());
    }

    @Test(testName = "List Rawat Jalan Filter Baseon Waktu Pendaftaran (Positive) DXM-6")
    public void verifyFilterRegDateListRJ() throws InterruptedException {
        HomePage homePage = new HomePage(driver,explicitWait);
        ListRJPage rawatJalanPage = new ListRJPage(driver,explicitWait);
        CommonPage commonPage = new CommonPage(driver,explicitWait);
        Utility.hardWait(2);
        homePage.clickRawatJalan();
        rawatJalanPage.clickPencarian();
        Utility.hardWait(2);
        rawatJalanPage.fillRegDate();
        rawatJalanPage.clickBtnCari();
        commonPage.scrollDownByPixel();
        Utility.hardWait(5);
        Assert.assertTrue(rawatJalanPage.verifyTglPendaftaran());
        rawatJalanPage.clickBtnHapus();
        Assert.assertTrue(rawatJalanPage.RegDateIsCLear());
    }

    @Test(testName = "List Rawat Jalan Filter Baseon Waktu Pendaftaran (Negative) DXM-6")
    public void verifyFilterRegDateNegListRJ() throws InterruptedException {
        HomePage homePage = new HomePage(driver,explicitWait);
        ListRJPage rawatJalanPage = new ListRJPage(driver,explicitWait);
        CommonPage commonPage = new CommonPage(driver,explicitWait);
        Utility.hardWait(2);
        homePage.clickRawatJalan();
        rawatJalanPage.clickPencarian();
        Utility.hardWait(2);
        rawatJalanPage.fillRegDateNeg("13082022");
        rawatJalanPage.clickBtnCari();
        commonPage.scrollDownByPixel();
        Utility.hardWait(5);
        Assert.assertTrue(rawatJalanPage.imgEmptyIsDisplayed());
    }

    @Test(testName = "List Rawat Jalan Filter Baseon No Transaksi (Positive)DXM-6")
    public void verifyFilterTransNoListRJ() throws InterruptedException {
        HomePage homePage = new HomePage(driver,explicitWait);
        ListRJPage rawatJalanPage = new ListRJPage(driver,explicitWait);
        CommonPage commonPage = new CommonPage(driver,explicitWait);
        Utility.hardWait(2);
        homePage.clickRawatJalan();
        rawatJalanPage.clickPencarian();
        Utility.hardWait(2);
        rawatJalanPage.fillNoTransaksi();
        rawatJalanPage.clickBtnCari();
        commonPage.scrollDownByPixel();
        Utility.hardWait(5);
        Assert.assertTrue(rawatJalanPage.verifyFilterTransaksiNo());
        rawatJalanPage.clickBtnHapus();
        Assert.assertTrue(rawatJalanPage.transNoIsCLear());
    }

    @Test(testName = "List Rawat Jalan Filter Baseon No Transaksi (Negative)DXM-6")
    public void verifyFilterTransNoNegListRJ() throws InterruptedException {
        HomePage homePage = new HomePage(driver,explicitWait);
        ListRJPage rawatJalanPage = new ListRJPage(driver,explicitWait);
        CommonPage commonPage = new CommonPage(driver,explicitWait);
        Utility.hardWait(2);
        homePage.clickRawatJalan();
        rawatJalanPage.clickPencarian();
        Utility.hardWait(2);
        rawatJalanPage.fillNoTransaksiNeg("999999");
        rawatJalanPage.clickBtnCari();
        commonPage.scrollDownByPixel();
        Utility.hardWait(3);
        Assert.assertTrue(rawatJalanPage.imgEmptyIsDisplayed());
    }

    @Test(testName = "List Rawat Jalan Filter Baseon No Kartu (Positive)DXM-6")
    public void verifyFilterCardNoListRJ() throws InterruptedException {
        HomePage homePage = new HomePage(driver,explicitWait);
        ListRJPage rawatJalanPage = new ListRJPage(driver,explicitWait);
        CommonPage commonPage = new CommonPage(driver,explicitWait);
        Utility.hardWait(2);
        homePage.clickRawatJalan();
        rawatJalanPage.clickPencarian();
        Utility.hardWait(2);
        rawatJalanPage.fillNoKartu();
        rawatJalanPage.clickBtnCari();
        commonPage.scrollDownByPixel();
        Utility.hardWait(5);
        Assert.assertTrue(rawatJalanPage.verifyFilterCardNo());
        rawatJalanPage.clickBtnHapus();
        Assert.assertTrue(rawatJalanPage.cardNoIsCLear());
    }

    @Test(testName = "List Rawat Jalan Filter Baseon No Kartu (Negative)DXM-6")
    public void verifyFilterCardNoNegListRJ() throws InterruptedException {
        HomePage homePage = new HomePage(driver,explicitWait);
        ListRJPage rawatJalanPage = new ListRJPage(driver,explicitWait);
        CommonPage commonPage = new CommonPage(driver,explicitWait);
        Utility.hardWait(2);
        homePage.clickRawatJalan();
        rawatJalanPage.clickPencarian();
        Utility.hardWait(2);
        rawatJalanPage.fillNoKartuNeg("91278473");
        rawatJalanPage.clickBtnCari();
        commonPage.scrollDownByPixel();
        Utility.hardWait(5);
        Assert.assertTrue(rawatJalanPage.imgEmptyIsDisplayed());
    }

    @Test(testName = "List Rawat Jalan Filter Baseon Nama Peserta (Positive)DXM-6")
    public void verifyFilterParticipantNameListRJ() throws InterruptedException {
        HomePage homePage = new HomePage(driver,explicitWait);
        ListRJPage rawatJalanPage = new ListRJPage(driver,explicitWait);
        Utility.hardWait(2);
        homePage.clickRawatJalan();
        rawatJalanPage.clickPencarian();
        Utility.hardWait(2);
        rawatJalanPage.fillNamaPeserta();
        rawatJalanPage.clickBtnCari();
        Utility.hardWait(5);
        Assert.assertTrue(rawatJalanPage.verifyFilterPaticipateName());
        rawatJalanPage.clickBtnHapus();
        Assert.assertTrue(rawatJalanPage.participateNameIsCLear());
    }

    @Test(testName = "List Rawat Jalan Filter Baseon Nama Peserta (Negative)DXM-6")
    public void verifyFilterParticipantNameNegListRJ() throws InterruptedException {
        HomePage homePage = new HomePage(driver,explicitWait);
        ListRJPage rawatJalanPage = new ListRJPage(driver,explicitWait);
        CommonPage commonPage = new CommonPage(driver,explicitWait);
        Utility.hardWait(2);
        homePage.clickRawatJalan();
        rawatJalanPage.clickPencarian();
        Utility.hardWait(2);
        rawatJalanPage.fillNamaPesertaNeg("Dudung bin maun");
        rawatJalanPage.clickBtnCari();
        commonPage.scrollDownByPixel();
        Utility.hardWait(5);
        Assert.assertTrue(rawatJalanPage.imgEmptyIsDisplayed());
    }

    @Test(testName = "List Rawat Jalan Filter Baseon Jenis Perawatan (Positive)DXM-6")
    public void verifyFilterTypeTreatmentListRJ() throws InterruptedException {
        HomePage homePage = new HomePage(driver,explicitWait);
        ListRJPage rawatJalanPage = new ListRJPage(driver,explicitWait);
        Utility.hardWait(2);
        homePage.clickRawatJalan();
        rawatJalanPage.clickPencarian();
        Utility.hardWait(2);
        rawatJalanPage.clickJenisPerawatan();
        rawatJalanPage.dropdownJenisPerawatan(ListRJPage.JenisPerawatan.RAWATJALAN);
        rawatJalanPage.clickBtnCari();
        Utility.hardWait(5);
        Assert.assertTrue(rawatJalanPage.verifyFilterJenisPerawatanRJ());
        rawatJalanPage.clickJenisPerawatan();
        rawatJalanPage.dropdownJenisPerawatan(ListRJPage.JenisPerawatan.RAWATGIGI);
        rawatJalanPage.clickBtnCari();
        Utility.hardWait(5);
        Assert.assertTrue(rawatJalanPage.verifyFilterJenisPerawatanRG());
        rawatJalanPage.clickJenisPerawatan();
        rawatJalanPage.dropdownJenisPerawatan(ListRJPage.JenisPerawatan.KACAMATA);
        rawatJalanPage.clickBtnCari();
        Utility.hardWait(5);
        Assert.assertTrue(rawatJalanPage.verifyFilterJenisPerawatanKM());
        rawatJalanPage.clickBtnHapus();
        rawatJalanPage.jenisPerawatanIsCLear();
    }

    @Test(testName = "List Rawat Jalan Filter Baseon Status (Positive)DXM-6")
    public void verifyFilterStatusListRJ() throws InterruptedException {
        HomePage homePage = new HomePage(driver,explicitWait);
        ListRJPage rawatJalanPage = new ListRJPage(driver,explicitWait);
        Utility.hardWait(2);
        homePage.clickRawatJalan();
        rawatJalanPage.clickPencarian();
        Utility.hardWait(2);
        rawatJalanPage.clickStatus();
        rawatJalanPage.dropdownStatus(ListRJPage.Status.PENDAFTARANBERHASIL);
        rawatJalanPage.clickBtnCari();
        Utility.hardWait(5);
        Assert.assertTrue(rawatJalanPage.verifyFilterStatusPendaftaranBerhasil());
        rawatJalanPage.clickStatus();
        rawatJalanPage.dropdownStatus(ListRJPage.Status.PENDAFTARANDIBATALKAN);
        rawatJalanPage.clickBtnCari();
        Utility.hardWait(5);
        Assert.assertTrue(rawatJalanPage.verifyFilterStatusPendaftaranDibatalkan());
        rawatJalanPage.clickStatus();
        rawatJalanPage.dropdownStatus(ListRJPage.Status.TAGIHANSELESAI);
        rawatJalanPage.clickBtnCari();
        Utility.hardWait(5);
        Assert.assertTrue(rawatJalanPage.verifyFilterStatusTagihanSelesai());
        rawatJalanPage.clickBtnHapus();
        rawatJalanPage.statusIsCLear();
    }

    @Test(testName = "List Rawat Jalan Multiple Filter  (Positive)DXM-6")
    public void verifyMultipleFilterListRJ() throws InterruptedException {
        HomePage homePage = new HomePage(driver,explicitWait);
        ListRJPage rawatJalanPage = new ListRJPage(driver,explicitWait);
        Utility.hardWait(2);
        homePage.clickRawatJalan();
        rawatJalanPage.clickPencarian();
        Utility.hardWait(2);
        String expectedParticipateName = rawatJalanPage.participantName();
        rawatJalanPage.fillNoKlaim();
        rawatJalanPage.fillRegDate();
        rawatJalanPage.fillNoTransaksi();
        rawatJalanPage.fillNoKartu();
        rawatJalanPage.fillNamaPeserta();
        rawatJalanPage.clickBtnCari();
        Utility.hardWait(5);
        Assert.assertTrue(rawatJalanPage.verifyFilterClaimNo());
        Assert.assertTrue(rawatJalanPage.verifyTglPendaftaran());
        Assert.assertTrue(rawatJalanPage.verifyFilterTransaksiNo());
        Assert.assertTrue(rawatJalanPage.verifyFilterCardNo());
        Assert.assertTrue(rawatJalanPage.verifyFilterPaticipateName());
        rawatJalanPage.clickBtnHapus();
        Assert.assertTrue(rawatJalanPage.claimNoIsCLear());
        Assert.assertTrue(rawatJalanPage.RegDateIsCLear());
        Assert.assertTrue(rawatJalanPage.transNoIsCLear());
        Assert.assertTrue(rawatJalanPage.cardNoIsCLear());
        Assert.assertTrue(rawatJalanPage.participateNameIsCLear());

    }

    @Test(testName = "List Rawat Jalan Multiple Filter  Negative(Positive)DXM-6")
    public void verifyMultipleFilterListRJNegative() throws InterruptedException {
        HomePage homePage = new HomePage(driver,explicitWait);
        ListRJPage rawatJalanPage = new ListRJPage(driver,explicitWait);
        Utility.hardWait(2);
        homePage.clickRawatJalan();
        rawatJalanPage.clickPencarian();
        Utility.hardWait(2);
        String expectedParticipateName = rawatJalanPage.participantName();
        rawatJalanPage.fillNoKlaimNeg("82934329847");
        rawatJalanPage.fillRegDate();
        rawatJalanPage.fillNoTransaksiNeg("732643246");
        rawatJalanPage.fillNoKartuNeg("324834832");
        rawatJalanPage.fillNamaPesertaNeg("Indun");
        rawatJalanPage.clickBtnCari();
        Utility.hardWait(5);
        Assert.assertTrue(rawatJalanPage.imgEmptyIsDisplayed());
        rawatJalanPage.clickBtnHapus();
        Assert.assertTrue(rawatJalanPage.claimNoIsCLear());
        Assert.assertTrue(rawatJalanPage.RegDateIsCLear());
        Assert.assertTrue(rawatJalanPage.transNoIsCLear());
        Assert.assertTrue(rawatJalanPage.cardNoIsCLear());
        Assert.assertTrue(rawatJalanPage.participateNameIsCLear());

    }
}
