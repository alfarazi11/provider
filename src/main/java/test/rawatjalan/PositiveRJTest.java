package test.rawatjalan;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.*;
import page.pengesahantagihan.*;
import page.rawatjalan.CetakStrukPage;
import page.rawatjalan.DetailPerawatanPage;
import page.rawatjalan.KonfirmasiPage;
import page.rawatjalan.*;
import test.BaseWebTest;
import utils.Utility;

import java.io.IOException;

public class PositiveRJTest extends BaseWebTest {

    @BeforeMethod
    public void login() throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage(driver,explicitWait);
        loginPage.login();
    }

    @Test(testName = "Pendaftaran Rawat Jalan Data Miya(Positive Case)",priority = 1)
    public void regisRawatJalanMemberMiya() throws InterruptedException {
        HomePage homePage = new HomePage(driver, explicitWait);
        ListRJPage rjPage = new ListRJPage(driver, explicitWait);
        PendaftaranRJPage daftar = new PendaftaranRJPage(driver, explicitWait);
        CommonPage commonPage = new CommonPage(driver, explicitWait);
        KonfirmasiPage konfirmasi = new KonfirmasiPage(driver, explicitWait);
        CetakStrukPage struk = new CetakStrukPage(driver, explicitWait);
        DetailPerawatanPage detail = new DetailPerawatanPage(driver, explicitWait);
        ListPengesahanTagihanPage pengesahanPage = new ListPengesahanTagihanPage(driver, explicitWait);
        FormTagihanPage tagihanPage = new FormTagihanPage(driver, explicitWait);
        TxtErrorPage errorPage = new TxtErrorPage(driver, explicitWait);
        DetailPengesahanPage detailPengesahanPage = new DetailPengesahanPage(driver,explicitWait);
        CetakStrukTagihanPage strukTagihan = new CetakStrukTagihanPage(driver,explicitWait);
        KonfirmasiTagihanPage konfirmasiTagihan = new KonfirmasiTagihanPage(driver,explicitWait);
        commonPage.openURL(urlAfterLogin);
        Utility.hardWait(3);
        homePage.clickRawatJalan();
        rjPage.clickBtnPendaftaran();
        daftar.clickBtnCariDataPasien();
        Assert.assertTrue(daftar.verifyColmnNoCardMandatory());
        daftar.inputCardNum("'9999202300000001");
        daftar.clickBtnCariDataPasien();
        Assert.assertTrue(daftar.verifyColmnTglLhrMandatory());
        daftar.inputDOB("01081988");
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

        Assert.assertEquals("Tomi Sudibyo",nama);
        Assert.assertEquals("Laki-Laki",jnsKelamin);
        Assert.assertEquals("01-08-1988",tglLahir);
        Assert.assertEquals("KARYAWAN",status);
        Assert.assertEquals("9999202300000001",nmrKartu);
        Assert.assertEquals("PL19092023-00",noPolis);
        Assert.assertEquals("PT. Deepwater Horizon",pemegangPolis);
        Assert.assertEquals("AIA",payor);

        //Cek Informasi Benefit
//        Assert.assertTrue(daftar.txtDokterUmumIsDisplayed());
//        Assert.assertTrue(daftar.txtDokterSpecialistIsDisplayed());
//        Assert.assertTrue(daftar.txtObatAlkesIsDisplayed());
//        Assert.assertTrue(daftar.txtLabDiagnoseIsDisplayed());
//        Assert.assertTrue(daftar.txtFisioterapiIsDisplayed());
//        Assert.assertTrue(daftar.txtKBIsDisplayed());
//        Assert.assertTrue(daftar.txtImunisasiIsDisplayed());
//        Assert.assertTrue(daftar.txtPerawatanTmbhKmbangIsDisplayed());
//        Assert.assertTrue(daftar.txtPrePostMTIsDisplayed());
//        Assert.assertTrue(daftar.txtMCUIsDisplayed());
//        Assert.assertFalse(daftar.txtDrSpecTindakanAdminIsDisplayed());
//        Assert.assertFalse(daftar.txtDrUmumTindakanAdminIsDisplayed());
//        Assert.assertFalse(daftar.txtImunisasiAnakIsDisplayed());
//        Assert.assertFalse(daftar.txtDokterObatIsDisplayed());
//        Assert.assertFalse(daftar.txtPostRIIsDisplayed());
//        Assert.assertFalse(daftar.txtKeguguranIsDisplayed());
//        Assert.assertFalse(daftar.txtBiayaLain2IsDisplayed());
//        Assert.assertFalse(daftar.txtAdministrasiIsDisplayed());
//        Assert.assertFalse(daftar.txtPengobatanTradisionalChinaIsDisplayed());
//        Assert.assertFalse(daftar.txtObatTindakanIsDisplayed());
//        Assert.assertFalse(daftar.txtHemoKemoIsDisplayed());

        //Informasi Benefit Sub 1
        String manfaat = daftar.getTxtInformManfaat();
        int dokterUmum = daftar.getBenefit1Sub1();
        int dokterSpc = daftar.getBenefit2Sub1();
        String obatALkes = daftar.getTxtBenefit3Sub1();
        String labDiagnose = daftar.getTxtBenefit4Sub1();
        String fisioterapi = daftar.getTxtBenefit5Sub1();
        //informasi benefit sub2
        String kb = daftar.getTxtBenefit1Sub2();
        String imunisasi = daftar.getTxtBenefit2Sub2();
        String tumbuhKembang = daftar.getTxtBenefit3Sub2();
        String prePostMT = daftar.getTxtBenefit4Sub2();
        String mcu = daftar.getTxtBenefit5Sub2();
        int limitTersedia = daftar.getBenefit6Sub2();

        Assert.assertEquals("Rawat Jalan",manfaat);
        Assert.assertEquals(200000,dokterUmum);
        Assert.assertEquals(300000,dokterSpc);
        Assert.assertEquals("Sesuai Tagihan",obatALkes);
        Assert.assertEquals("Sesuai Tagihan",labDiagnose);
        Assert.assertEquals("Sesuai Tagihan",fisioterapi);
        Assert.assertEquals("Sesuai Tagihan",kb);
        Assert.assertEquals("Sesuai Tagihan",imunisasi);
        Assert.assertEquals("Sesuai Tagihan",tumbuhKembang);
        Assert.assertEquals("Sesuai Tagihan",prePostMT);
        Assert.assertEquals("Sesuai Tagihan",mcu);
//        Assert.assertEquals(7405000,limitTersedia);

        daftar.scrollUntilBtnDaftarkan();
        daftar.clickBtnDaftarkan();

        //informasi halaman popup konfirmasi
        String nmrKartuKonfrm = konfirmasi.getTxtCardNo();
        String namaKonfrm = konfirmasi.getTxtNamaPeserta();
        String tglLahirKonfrm = konfirmasi.getTxtTglLahir();
        String nmKaryawanKonfirm = konfirmasi.getTxtNamaKaryawan();
        String statusKonfirm = konfirmasi.getTxtStatus();
        String pemegangPolisKonfrm = konfirmasi.getTxtPemegangPolis();
        String jnsPerawatanKonfrm = konfirmasi.getTxtJnsPerawatan();

        Assert.assertEquals(nmrKartu,nmrKartuKonfrm);
        Assert.assertEquals(nama,namaKonfrm);
        Assert.assertEquals(tglLahir,tglLahirKonfrm);
        Assert.assertEquals(nmKaryawanKonfirm,"Tomi Sudibyo");
        Assert.assertEquals(status,statusKonfirm);
        Assert.assertEquals(pemegangPolis,pemegangPolisKonfrm);
        Assert.assertEquals(manfaat,jnsPerawatanKonfrm);

//        Thread.sleep(5000);
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
        String strukManfaat = struk.getTxtManfaat();

        int strukDokterUmum = struk.getBenefit1();
        int strukDokterSpc = struk.getBenefit2();
        String strukObatAlkes =  struk.getTxtBenefit3();
        String strukLabDiagnose = struk.getTxtBenefit4();
        String strukFisioterapi = struk.getTxtBenefit5();
        String strukKb = struk.getTxtBenefit6();
        String strukImunisasi = struk.getTxtBenefit7();
        String strukTumbuhKembang = struk.getTxtBenefit8();
        String strukPrePost = struk.getTxtBenefit9();
        String strukMCU = struk.getTxtBenefit10();
        int strukLimitTersedia = struk.getBenefit11();


        Assert.assertEquals(payor,strukPayor);
        Assert.assertEquals(nama,strukNama);
        Assert.assertEquals(nmrKartu,strukNmrKartu);
        Assert.assertEquals(status,strukStatus); //having bugs in preview cetak struk
        Assert.assertEquals(nama,strukNama);
        Assert.assertEquals(noPolis,strukNoPolis);
        Assert.assertEquals(pemegangPolis,strukPemegangPolis); //having bugs in register
        Assert.assertEquals(manfaat,strukManfaat);

        Assert.assertEquals(dokterUmum,strukDokterUmum);
        Assert.assertEquals(dokterSpc,strukDokterSpc);
        Assert.assertEquals(obatALkes,strukObatAlkes);
        Assert.assertEquals(labDiagnose,strukLabDiagnose);
        Assert.assertEquals(fisioterapi,strukFisioterapi);
        Assert.assertEquals(kb,strukKb);
        Assert.assertEquals(imunisasi,strukImunisasi);
        Assert.assertEquals(tumbuhKembang,strukTumbuhKembang);
        Assert.assertEquals(prePostMT,strukPrePost);
        Assert.assertEquals(mcu,strukMCU);
        Assert.assertEquals(limitTersedia,strukLimitTersedia);

        struk.clickBtnTutup();
        Utility.hardWait(5);

        rjPage.clickPencarian();
        rjPage.fillNoKartu();
        rjPage.fillNoKartuManual("9999202300000001");
        rjPage.clickJenisPerawatan();
        rjPage.dropdownJenisPerawatan(ListRJPage.JenisPerawatan.RAWATJALAN);
        rjPage.clickBtnCari();
        commonPage.scrollDownByPixel();
        rjPage.verifyStatusPendaftaranBerhasil();
        rjPage.clickClaimNo();

        String dibuatOleh = detail.getCreateBy();
        String dibuatVia = detail.getCreateVia();
        String noKlaim = detail.getNoKlaim();
        String noTransaksi = detail.getNoTransaksi();
        String detailStatus = detail.getTxtStatus();
        String detailManfaat = detail.getTxtManfaat();
        String detailNama = detail.getTxtNama();
        String detailNmrKartu = detail.getTxtNmrKartu();
        String detailJnsKelamin = detail.getTxtJnsKelamin();
        String detailPayor = detail.getTxtPayor();

        Assert.assertEquals("adminrsmiya8",dibuatOleh);
        Assert.assertEquals("Meditap",dibuatVia);
        Assert.assertEquals(manfaat,detailManfaat);
        Assert.assertEquals(nama,detailNama);
        Assert.assertEquals(nmrKartu,detailNmrKartu);
        Assert.assertEquals(jnsKelamin,detailJnsKelamin);
        Assert.assertEquals(payor,detailPayor);
        Assert.assertEquals("Pendaftaran Berhasil",detailStatus);

        //Pengesahan
//        commonPage.openURL(urlAfterLogin);
        homePage.clickPengesahanTagihan();
        pengesahanPage.clickPencarian();
        pengesahanPage.fillNoKartuManual("9999202300000001");
        pengesahanPage.clickJenisPerawatan();
        pengesahanPage.dropdownJenisPerawatan(ListPengesahanTagihanPage.JenisPerawatan.RAWATJALAN);
        //Detail Tagihan
        pengesahanPage.clickClaimNo();
        String pengesahanNmrKartu = detailPengesahanPage.getTxtNoKartu();
        String pengesahanNama = detailPengesahanPage.getTxtNama();
        String pengesahanJnsKelamin = detailPengesahanPage.getTxtJnsKelamin();
        String pengesahanStatus = detailPengesahanPage.getTxtKaryawan();
        String statusTagihan = detailPengesahanPage.getTxtStatusTagihan();
        String pengesahanPayor = detailPengesahanPage.getTxtPayor();

        Assert.assertEquals(nmrKartu,pengesahanNmrKartu);
        Assert.assertEquals(nama,pengesahanNama);
        Assert.assertEquals(jnsKelamin,pengesahanJnsKelamin);
        Assert.assertEquals(status,pengesahanStatus);
        Assert.assertEquals("Menunggu Tagihan",statusTagihan);
        Assert.assertEquals(payor,pengesahanPayor);

        detailPengesahanPage.clickBtnLngkpTagihan();
        Thread.sleep(5000);
        tagihanPage.clickPilihDiagnosis();
        tagihanPage.inputKodeDiagnosa("A15");
        Utility.hardWait(2);
        tagihanPage.clickCheckbox1();
        tagihanPage.clickCheckbox2();
        tagihanPage.clickBtnKirim();
        String diagnose1 = tagihanPage.getTxtDiagnose1();
        //Tampil
        Assert.assertTrue(tagihanPage.colmnDokterUmumIsDisplayed());
        Assert.assertTrue(tagihanPage.colmnDokterSpecIsDisplayed());
        Assert.assertTrue(tagihanPage.colmnObatAlkesIsDisplayed());
        Assert.assertTrue(tagihanPage.colmnFisioterapiIsDisplayed());
        Assert.assertTrue(tagihanPage.colmnMCUIsDisplayed());
        Assert.assertTrue(tagihanPage.colmnLabDiagnosIsDisplayed());
        Assert.assertTrue(tagihanPage.colmnImunisasiIsDisplayed());
        Assert.assertTrue(tagihanPage.colmnKBIsDisplayed());
        Assert.assertTrue(tagihanPage.colmnPrePostMTIsDisplayed());
        Assert.assertTrue(tagihanPage.colmnTumbuhKembangIsDisplayed());
        //tidak tampil
        Assert.assertFalse(tagihanPage.colmnDrUmumTindakanAdminIsDisplayed());
        Assert.assertFalse(tagihanPage.colmnDrSpcTindakanAdminIsDisplayed());
        Assert.assertFalse(tagihanPage.colmnPengobatanTradisionalCinaIsDisplayed());
        Assert.assertFalse(tagihanPage.colmnHemoKemoIsDisplayed());
        Assert.assertFalse(tagihanPage.colmnAdminIsDisplayed());
        Assert.assertFalse(tagihanPage.colmnPostRIIsDisplayed());
        Assert.assertFalse(tagihanPage.colmnObatTindakanIsDisplayed());
        Assert.assertFalse(tagihanPage.colmnImunisasiAnakIsDisplayed());
        Assert.assertFalse(tagihanPage.colmnBiayaLain2IsDisplayed());
        Assert.assertFalse(tagihanPage.colmnDokterObatIsDisplayed());


        tagihanPage.inputBiayaDokterUmum("250000");
        tagihanPage.inputBiayaDokterSpec("350000");
        tagihanPage.inputBiayaObatAlkes("50000");
        tagihanPage.inputBiayaFisioterapi("100000");
        tagihanPage.inputBiayaMCU("150000");
        tagihanPage.inputBiayaLabDiagnos("50000");
        tagihanPage.inputBiayaImunisasi("100000");
        tagihanPage.inputBiayaKB("150000");
        tagihanPage.inputBiayaPrePostMT("100000");
        tagihanPage.inputBiayaTumbuhKembang("500000");
        tagihanPage.scrollUntilBtnProsesTagihan();
        tagihanPage.clickProsesTagihan();

        //informasi pasien Konfirmasi Proses Tagihan
        String tagihanNama = konfirmasiTagihan.getTxtNama();
        String tagihanNmrKartu = konfirmasiTagihan.getTxtNmrKartu();
        String tagihanStatus = konfirmasiTagihan.getTxtStatus();
        String tagihanJnsPerawatan = konfirmasiTagihan.getTxtJnsPerawatan();
        //informasi diagnosa
        String tagihanDiagnose1 = konfirmasiTagihan.getTxtDiagnose1();
        int tagihanDokterUmum = konfirmasiTagihan.getTagihan1();
        int tagihanDokterSpc = konfirmasiTagihan.getTagihan2();
        int tagihanObatAlkes = konfirmasiTagihan.getTagihan3();
        int tagihanFisioterapi = konfirmasiTagihan.getTagihan4();
        int tagihanMCU = konfirmasiTagihan.getTagihan5();
        int tagihanLabDiagnose = konfirmasiTagihan.getTagihan6();
        int tagihanImunisasi = konfirmasiTagihan.getTagihan7();
        int tagihanKB = konfirmasiTagihan.getTagihan8();
        int tagihanPrePostMT = konfirmasiTagihan.getTagihan9();
        int tagihanTumbuhKembang = konfirmasiTagihan.getTagihan10();
        int totalTagihanActual = tagihanDokterUmum+tagihanDokterSpc+tagihanObatAlkes+tagihanFisioterapi+
                tagihanMCU+tagihanLabDiagnose+tagihanImunisasi+tagihanKB+tagihanPrePostMT+tagihanTumbuhKembang;
        int totalTagihanExpected = konfirmasiTagihan.getTagihan11();

        Assert.assertEquals(nama,tagihanNama);
        Assert.assertEquals(nmrKartu,tagihanNmrKartu);
        Assert.assertEquals(status,tagihanStatus);
        Assert.assertEquals(manfaat,tagihanJnsPerawatan);
        Assert.assertEquals(diagnose1,tagihanDiagnose1);
        Assert.assertEquals(250000,tagihanDokterUmum);
        Assert.assertEquals(350000,tagihanDokterSpc);
        Assert.assertEquals(50000,tagihanObatAlkes);
        Assert.assertEquals(100000,tagihanFisioterapi);
        Assert.assertEquals(150000,tagihanMCU);
        Assert.assertEquals(50000,tagihanLabDiagnose);
        Assert.assertEquals(100000,tagihanImunisasi);
        Assert.assertEquals(150000,tagihanKB);
        Assert.assertEquals(100000,tagihanPrePostMT);
        Assert.assertEquals(500000,tagihanTumbuhKembang);
        Assert.assertEquals(totalTagihanActual,totalTagihanExpected);

        konfirmasiTagihan.scrollUntilBtnKirim();
        konfirmasiTagihan.clickBtnKirimKonfirmasi();
        errorPage.txtErrCaptchaNotNull();
        konfirmasiTagihan.inputCaptcha("888");
        konfirmasi.scrollUntilBtnKirim();
        konfirmasi.clickBtnKirimKonfirmasi();
        errorPage.txtKodeSalah();
        konfirmasiTagihan.inputCaptcha("999");
        konfirmasi.scrollUntilBtnKirim();
        konfirmasi.clickBtnKirimKonfirmasi();


        String strukTagihanPayor = strukTagihan.getTxtPayor();
        String strukTagihanNoTransaksi = strukTagihan.getTxtNoTransaksi();
        String strukTagihanNmrKartu = strukTagihan.getTxtNmrKartu();
        String strukTagihanNama = strukTagihan.getTxtNama();
        String strukTagihanStatus = strukTagihan.getTxtKaryawan();
        String strukTagihanNoPolis = strukTagihan.getTxtNoPolis();
        String strukTagihanPemegangPolis = strukTagihan.getTxtPemegangPolis();
        String strukTagihanManfaat = strukTagihan.getTxtManfaat();
//        int strukTagihanDokterSpc = strukTagihan.getTagihan1();
//        int strukTagihanDokterUmum = strukTagihan.getTagihan2();
//        int strukTagihanObatAlkes = strukTagihan.getTagihan3();
//        int strukTagihanLabDiagnose = strukTagihan.getTagihan4();
//        int strukTagihanFisioterapi = strukTagihan.getTagihan5();
//        int strukTagihanKb = strukTagihan.getTagihan6();
//        int strukTagihanImunisasi = strukTagihan.getTagihan7();
//        int strukTagihanTumbuhKembang = strukTagihan.getTagihan8();
//        int strukTagihanPrePostMT = strukTagihan.getTagihan9();
//        int strukTagihanMcu = strukTagihan.getTagihan10();
        int strukTagihanTotalBiaya = strukTagihan.getTagihan11();
        int strukTagihanExcess = strukTagihan.getTagihan12();


        Assert.assertEquals(payor,strukTagihanPayor);
        Assert.assertEquals(noTransaksi,strukTagihanNoTransaksi);
        Assert.assertEquals(nmrKartu,strukTagihanNmrKartu);
        Assert.assertEquals(nama,strukTagihanNama);
        Assert.assertEquals(status,tagihanStatus);
        Assert.assertEquals(status,strukTagihanStatus);
        Assert.assertEquals(noPolis,strukTagihanNoPolis);
        Assert.assertEquals(pemegangPolis,strukTagihanPemegangPolis);
        Assert.assertEquals(manfaat,strukTagihanManfaat);
//        Assert.assertEquals(tagihanDokterUmum,strukTagihanDokterUmum);
//        Assert.assertEquals(tagihanDokterSpc,strukTagihanDokterSpc);
//        Assert.assertEquals(tag);
        Assert.assertEquals(totalTagihanActual,strukTagihanTotalBiaya);
        Assert.assertEquals(850000,strukTagihanExcess);

        strukTagihan.clickBtnTutup();
        Utility.hardWait(10);

        pengesahanPage.clickPencarian();
        pengesahanPage.clickStatusTagihanSelesai();
        pengesahanPage.fillNoKartuManual("9999202300000001");
        pengesahanPage.clickJenisPerawatan();
        pengesahanPage.dropdownJenisPerawatan(ListPengesahanTagihanPage.JenisPerawatan.RAWATJALAN);
        pengesahanPage.clickRegDate();
        pengesahanPage.clickDateToday();
        pengesahanPage.clickBtnCari();
        Utility.hardWait(10);
//        commonPage.scrollDownByPixel();
        Assert.assertTrue(pengesahanPage.statusTagihanSelesai());
//        commonPage.openURL(urlAfterLogin);
//        Thread.sleep(2000);
        homePage.clickRawatJalan();
        rjPage.clickPencarian();
        rjPage.fillNoKartuManual("9999202300000001");
        rjPage.clickBtnCari();
        commonPage.scrollDownByPixel();
        rjPage.verifyStatusTagihanSelesai();

        homePage.clickRawatJalan();
        rjPage.clickBtnPendaftaran();
        daftar.clickBtnCariDataPasien();
        Assert.assertTrue(daftar.verifyColmnNoCardMandatory());
        daftar.inputCardNum("'9999202300000001");
        daftar.clickBtnCariDataPasien();
        Assert.assertTrue(daftar.verifyColmnTglLhrMandatory());
        daftar.inputDOB("01081988");
        daftar.clickBtnCariDataPasien();
        Assert.assertTrue(daftar.verifyColmnJnsPrwtanMandatory());
        daftar.clickJenisPerawatan();
        daftar.fillJenisPerawatan(PendaftaranRJPage.JenisPerawatan.RAWATJALAN);
        daftar.clickBtnCariDataPasien();

        int actualSisaLimitTersedia = limitTersedia-(strukTagihanTotalBiaya-strukTagihanExcess);
        int expectedSisaLimitTersedia = daftar.getBenefit6Sub2();
        Assert.assertEquals(actualSisaLimitTersedia,expectedSisaLimitTersedia);

        //cek limit setelah dibatalkan perawatan
        daftar.scrollUntilBtnDaftarkan();
        daftar.clickBtnDaftarkan();
        konfirmasi.clickBtnBatalkanTransaksi();
        konfirmasi.inputColmnPIC("Automation");
        konfirmasi.inputColmnBagian("Divisi Testing Automation");
        konfirmasi.inputColmnAlasan("Testing Automation");
        konfirmasi.scrollUntilBtnBatalkanPerawatan();
        konfirmasi.inputCaptcha("999");
        konfirmasi.scrollUntilBtnBatalkanPerawatan();
        konfirmasi.clickBtnBatalkanPerawatan();
        Utility.hardWait(45); //wait untuk handle agar void settlement reason tidak  undefined
        commonPage.openURL(urlAfterLogin);
        homePage.clickRawatJalan();
        rjPage.clickBtnPendaftaran();
//        Utility.hardWait(3);
        daftar.inputCardNum("9999202300000001");
        daftar.inputDOB("01081988");
        daftar.clickJenisPerawatan();
        daftar.fillJenisPerawatan(PendaftaranRJPage.JenisPerawatan.RAWATJALAN);
        daftar.clickBtnCariDataPasien();
        Utility.hardWait(5);
        int limitAfterCancel = daftar.getBenefit6Sub2();
        Assert.assertEquals(limitAfterCancel,limitTersedia);

    }

    @Test(testName = "Pendaftaran Rawat Jalan Data Miya(Positive Case)",priority = 1)
    public void regisRawatGigiMemberMiya() throws InterruptedException {
        HomePage homePage = new HomePage(driver, explicitWait);
        ListRJPage rjPage = new ListRJPage(driver, explicitWait);
        PendaftaranRJPage daftar = new PendaftaranRJPage(driver, explicitWait);
        CommonPage commonPage = new CommonPage(driver, explicitWait);
        KonfirmasiPage konfirmasi = new KonfirmasiPage(driver, explicitWait);
        CetakStrukPage struk = new CetakStrukPage(driver, explicitWait);
        DetailPerawatanPage detail = new DetailPerawatanPage(driver, explicitWait);
        ListPengesahanTagihanPage pengesahanPage = new ListPengesahanTagihanPage(driver, explicitWait);
        FormTagihanPage tagihanPage = new FormTagihanPage(driver, explicitWait);
        TxtErrorPage errorPage = new TxtErrorPage(driver, explicitWait);
        DetailPengesahanPage detailPengesahanPage = new DetailPengesahanPage(driver,explicitWait);
        CetakStrukTagihanPage strukTagihan = new CetakStrukTagihanPage(driver,explicitWait);
        KonfirmasiTagihanPage konfirmasiTagihan = new KonfirmasiTagihanPage(driver,explicitWait);
        commonPage.openURL(urlAfterLogin);
        Utility.hardWait(3);
        homePage.clickRawatJalan();
        rjPage.clickBtnPendaftaran();
        daftar.clickBtnCariDataPasien();
        Assert.assertTrue(daftar.verifyColmnNoCardMandatory());
        daftar.inputCardNum("'9999202300000001");
        daftar.clickBtnCariDataPasien();
        Assert.assertTrue(daftar.verifyColmnTglLhrMandatory());
        daftar.inputDOB("01081988");
        daftar.clickBtnCariDataPasien();
        Assert.assertTrue(daftar.verifyColmnJnsPrwtanMandatory());
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

        Assert.assertEquals("Tomi Sudibyo",nama);
        Assert.assertEquals("Laki-Laki",jnsKelamin);
        Assert.assertEquals("01-08-1988",tglLahir);
        Assert.assertEquals("KARYAWAN",status);
        Assert.assertEquals("9999202300000001",nmrKartu);
        Assert.assertEquals("PL19092023-00",noPolis);
        Assert.assertEquals("PT. Deepwater Horizon",pemegangPolis);
        Assert.assertEquals("AIA",payor);

        //Cek Informasi Benefit
        Assert.assertTrue(daftar.txtRawatGigiIsDisplayed());
        Assert.assertFalse(daftar.txtGigiUmumIsDisplayed());
        Assert.assertFalse(daftar.txtPencegahanIsDisplayed());
        Assert.assertFalse(daftar.txtGigiKhususIsDisplayed());
        Assert.assertFalse(daftar.txtGigiPalsuIsDisplayed());

        //Informasi Benefit Sub 1
        String manfaat = daftar.getTxtInformManfaat();
        String rawatGigi = daftar.getTxtBenefit1Sub1();
        int limitTersedia = daftar.getBenefit2Sub1();


        Assert.assertEquals("Rawat Jalan",manfaat);
        Assert.assertEquals("Sesuai Tagihan",rawatGigi);
//        Assert.assertEquals(7405000,limitTersedia);

        daftar.scrollUntilBtnDaftarkan();
        daftar.clickBtnDaftarkan();

        //informasi halaman popup konfirmasi
        String nmrKartuKonfrm = konfirmasi.getTxtCardNo();
        String namaKonfrm = konfirmasi.getTxtNamaPeserta();
        String tglLahirKonfrm = konfirmasi.getTxtTglLahir();
        String nmKaryawanKonfirm = konfirmasi.getTxtNamaKaryawan();
        String statusKonfirm = konfirmasi.getTxtStatus();
        String pemegangPolisKonfrm = konfirmasi.getTxtPemegangPolis();
        String jnsPerawatanKonfrm = konfirmasi.getTxtJnsPerawatan();

        Assert.assertEquals(nmrKartu,nmrKartuKonfrm);
        Assert.assertEquals(nama,namaKonfrm);
        Assert.assertEquals(tglLahir,tglLahirKonfrm);
        Assert.assertEquals(nmKaryawanKonfirm,"Tomi Sudibyo");
        Assert.assertEquals(status,statusKonfirm);
        Assert.assertEquals(pemegangPolis,pemegangPolisKonfrm);
        Assert.assertEquals(manfaat,jnsPerawatanKonfrm);

//        Thread.sleep(5000);
        konfirmasi.inputCaptcha("999");
        konfirmasi.scrollUntilBtnYa();
        konfirmasi.clickBtnYa();

        //Informasi Cetak Struk
        String strukPayor = struk.getTxtPayor();
        String strukNoTransaksi = struk.getTxtNoTransaksi();
        String strukNmrKartu = struk.getTxtNoKartu();
        String strukNama = struk.getTxtNamaPeserta();
        String strukStatus = struk.getTxtStatus();
        String strukNoPolis = struk.getTxtNoPolis();
        String strukPemegangPolis = struk.getTxtPemegangPolis();

        String strukManfaat = struk.getTxtManfaat();
        String strukRawatGigi = struk.getTxtBenefit1();
        int strukLimitTersedia = struk.getBenefit2();


        Assert.assertEquals(payor,strukPayor);
        Assert.assertEquals(nama,strukNama);
        Assert.assertEquals(nmrKartu,strukNmrKartu);
        Assert.assertEquals(status,strukStatus); //having bugs in preview cetak struk
        Assert.assertEquals(nama,strukNama);
        Assert.assertEquals(noPolis,strukNoPolis);
        Assert.assertEquals(pemegangPolis,strukPemegangPolis); //having bugs in register

        Assert.assertEquals(manfaat,strukManfaat);
        Assert.assertEquals(rawatGigi,strukRawatGigi);
        Assert.assertEquals(limitTersedia,strukLimitTersedia);

        struk.clickBtnTutup();
        Utility.hardWait(5);

        rjPage.clickPencarian();
        rjPage.fillNoKartu();
        rjPage.fillNoKartuManual("9999202300000001");
        rjPage.clickJenisPerawatan();
        rjPage.dropdownJenisPerawatan(ListRJPage.JenisPerawatan.RAWATJALAN);
        rjPage.clickBtnCari();
        commonPage.scrollDownByPixel();
        rjPage.verifyStatusPendaftaranBerhasil();
        rjPage.clickClaimNo();

        String detailDibuatOleh = detail.getCreateBy();
        String detailDibuatVia = detail.getCreateVia();
//        String detailNoKlaim = detail.getNoKlaim();
        String detailNoTransaksi = detail.getNoTransaksi();
        String detailStatus = detail.getTxtStatus();
        String detailManfaat = detail.getTxtManfaat();
        String detailNama = detail.getTxtNama();
        String detailNmrKartu = detail.getTxtNmrKartu();
        String detailJnsKelamin = detail.getTxtJnsKelamin();
        String detailPayor = detail.getTxtPayor();

        Assert.assertEquals("adminrsmiya8",detailDibuatOleh);
        Assert.assertEquals("Meditap",detailDibuatVia);
        Assert.assertEquals(strukNoTransaksi,detailNoTransaksi);
        Assert.assertEquals(manfaat,detailManfaat);
        Assert.assertEquals(nama,detailNama);
        Assert.assertEquals(nmrKartu,detailNmrKartu);
        Assert.assertEquals(jnsKelamin,detailJnsKelamin);
        Assert.assertEquals(payor,detailPayor);
        Assert.assertEquals("Pendaftaran Berhasil",detailStatus);

        //Pengesahan
//        commonPage.openURL(urlAfterLogin);
        homePage.clickPengesahanTagihan();
        pengesahanPage.clickPencarian();
        pengesahanPage.fillNoKartuManual("9999202300000001");
        pengesahanPage.clickJenisPerawatan();
        pengesahanPage.dropdownJenisPerawatan(ListPengesahanTagihanPage.JenisPerawatan.RAWATGIGI);
        //Detail Tagihan
        pengesahanPage.clickClaimNo();
        String pengesahanNmrKartu = detailPengesahanPage.getTxtNoKartu();
        String pengesahanNama = detailPengesahanPage.getTxtNama();
        String pengesahanJnsKelamin = detailPengesahanPage.getTxtJnsKelamin();
        String pengesahanStatus = detailPengesahanPage.getTxtKaryawan();
        String statusTagihan = detailPengesahanPage.getTxtStatusTagihan();
        String pengesahanPayor = detailPengesahanPage.getTxtPayor();

        Assert.assertEquals(nmrKartu,pengesahanNmrKartu);
        Assert.assertEquals(nama,pengesahanNama);
        Assert.assertEquals(jnsKelamin,pengesahanJnsKelamin);
        Assert.assertEquals(status,pengesahanStatus);
        Assert.assertEquals("Menunggu Tagihan",statusTagihan);
        Assert.assertEquals(payor,pengesahanPayor);

        detailPengesahanPage.clickBtnLngkpTagihan();
        Thread.sleep(5000);
        tagihanPage.clickPilihDiagnosis();
        tagihanPage.inputKodeDiagnosa("K05");
        Utility.hardWait(2);
        tagihanPage.clickCheckbox1();
        tagihanPage.clickCheckbox2();
        tagihanPage.clickBtnKirim();
        String diagnose1 = tagihanPage.getTxtDiagnose1();
        //Tampil
        Assert.assertTrue(tagihanPage.colmnDokterUmumIsDisplayed());
        Assert.assertTrue(tagihanPage.colmnDokterSpecIsDisplayed());
        Assert.assertTrue(tagihanPage.colmnObatAlkesIsDisplayed());
        Assert.assertTrue(tagihanPage.colmnFisioterapiIsDisplayed());
        Assert.assertTrue(tagihanPage.colmnMCUIsDisplayed());
        Assert.assertTrue(tagihanPage.colmnLabDiagnosIsDisplayed());
        Assert.assertTrue(tagihanPage.colmnImunisasiIsDisplayed());
        Assert.assertTrue(tagihanPage.colmnKBIsDisplayed());
        Assert.assertTrue(tagihanPage.colmnPrePostMTIsDisplayed());
        Assert.assertTrue(tagihanPage.colmnTumbuhKembangIsDisplayed());
        //tidak tampil
        Assert.assertFalse(tagihanPage.colmnDrUmumTindakanAdminIsDisplayed());
        Assert.assertFalse(tagihanPage.colmnDrSpcTindakanAdminIsDisplayed());
        Assert.assertFalse(tagihanPage.colmnPengobatanTradisionalCinaIsDisplayed());
        Assert.assertFalse(tagihanPage.colmnHemoKemoIsDisplayed());
        Assert.assertFalse(tagihanPage.colmnAdminIsDisplayed());
        Assert.assertFalse(tagihanPage.colmnPostRIIsDisplayed());
        Assert.assertFalse(tagihanPage.colmnObatTindakanIsDisplayed());
        Assert.assertFalse(tagihanPage.colmnImunisasiAnakIsDisplayed());
        Assert.assertFalse(tagihanPage.colmnBiayaLain2IsDisplayed());
        Assert.assertFalse(tagihanPage.colmnDokterObatIsDisplayed());


        tagihanPage.inputBiayaDokterUmum("250000");
        tagihanPage.inputBiayaDokterSpec("350000");
        tagihanPage.inputBiayaObatAlkes("50000");
        tagihanPage.inputBiayaFisioterapi("100000");
        tagihanPage.inputBiayaMCU("150000");
        tagihanPage.inputBiayaLabDiagnos("50000");
        tagihanPage.inputBiayaImunisasi("100000");
        tagihanPage.inputBiayaKB("150000");
        tagihanPage.inputBiayaPrePostMT("100000");
        tagihanPage.inputBiayaTumbuhKembang("500000");
        tagihanPage.scrollUntilBtnProsesTagihan();
        tagihanPage.clickProsesTagihan();

        //informasi pasien Konfirmasi Proses Tagihan
        String tagihanNama = konfirmasiTagihan.getTxtNama();
        String tagihanNmrKartu = konfirmasiTagihan.getTxtNmrKartu();
        String tagihanStatus = konfirmasiTagihan.getTxtStatus();
        String tagihanJnsPerawatan = konfirmasiTagihan.getTxtJnsPerawatan();
        //informasi diagnosa
        String tagihanDiagnose1 = konfirmasiTagihan.getTxtDiagnose1();
        int tagihanDokterUmum = konfirmasiTagihan.getTagihan1();
        int tagihanDokterSpc = konfirmasiTagihan.getTagihan2();
        int tagihanObatAlkes = konfirmasiTagihan.getTagihan3();
        int tagihanFisioterapi = konfirmasiTagihan.getTagihan4();
        int tagihanMCU = konfirmasiTagihan.getTagihan5();
        int tagihanLabDiagnose = konfirmasiTagihan.getTagihan6();
        int tagihanImunisasi = konfirmasiTagihan.getTagihan7();
        int tagihanKB = konfirmasiTagihan.getTagihan8();
        int tagihanPrePostMT = konfirmasiTagihan.getTagihan9();
        int tagihanTumbuhKembang = konfirmasiTagihan.getTagihan10();
        int totalTagihanActual = tagihanDokterUmum+tagihanDokterSpc+tagihanObatAlkes+tagihanFisioterapi+
                tagihanMCU+tagihanLabDiagnose+tagihanImunisasi+tagihanKB+tagihanPrePostMT+tagihanTumbuhKembang;
        int totalTagihanExpected = konfirmasiTagihan.getTagihan11();

        Assert.assertEquals(nama,tagihanNama);
        Assert.assertEquals(nmrKartu,tagihanNmrKartu);
        Assert.assertEquals(status,tagihanStatus);
        Assert.assertEquals(manfaat,tagihanJnsPerawatan);
        Assert.assertEquals(diagnose1,tagihanDiagnose1);
        Assert.assertEquals(250000,tagihanDokterUmum);
        Assert.assertEquals(350000,tagihanDokterSpc);
        Assert.assertEquals(50000,tagihanObatAlkes);
        Assert.assertEquals(100000,tagihanFisioterapi);
        Assert.assertEquals(150000,tagihanMCU);
        Assert.assertEquals(50000,tagihanLabDiagnose);
        Assert.assertEquals(100000,tagihanImunisasi);
        Assert.assertEquals(150000,tagihanKB);
        Assert.assertEquals(100000,tagihanPrePostMT);
        Assert.assertEquals(500000,tagihanTumbuhKembang);
        Assert.assertEquals(totalTagihanActual,totalTagihanExpected);

        konfirmasiTagihan.scrollUntilBtnKirim();
        konfirmasiTagihan.clickBtnKirimKonfirmasi();
        errorPage.txtErrCaptchaNotNull();
        konfirmasiTagihan.inputCaptcha("888");
        konfirmasi.scrollUntilBtnKirim();
        konfirmasi.clickBtnKirimKonfirmasi();
        errorPage.txtKodeSalah();
        konfirmasiTagihan.inputCaptcha("999");
        konfirmasi.scrollUntilBtnKirim();
        konfirmasi.clickBtnKirimKonfirmasi();


        String strukTagihanPayor = strukTagihan.getTxtPayor();
        String strukTagihanNoTransaksi = strukTagihan.getTxtNoTransaksi();
        String strukTagihanNmrKartu = strukTagihan.getTxtNmrKartu();
        String strukTagihanNama = strukTagihan.getTxtNama();
        String strukTagihanStatus = strukTagihan.getTxtKaryawan();
        String strukTagihanNoPolis = strukTagihan.getTxtNoPolis();
        String strukTagihanPemegangPolis = strukTagihan.getTxtPemegangPolis();
        String strukTagihanManfaat = strukTagihan.getTxtManfaat();
//        int strukTagihanDokterSpc = strukTagihan.getTagihan1();
//        int strukTagihanDokterUmum = strukTagihan.getTagihan2();
//        int strukTagihanObatAlkes = strukTagihan.getTagihan3();
//        int strukTagihanLabDiagnose = strukTagihan.getTagihan4();
//        int strukTagihanFisioterapi = strukTagihan.getTagihan5();
//        int strukTagihanKb = strukTagihan.getTagihan6();
//        int strukTagihanImunisasi = strukTagihan.getTagihan7();
//        int strukTagihanTumbuhKembang = strukTagihan.getTagihan8();
//        int strukTagihanPrePostMT = strukTagihan.getTagihan9();
//        int strukTagihanMcu = strukTagihan.getTagihan10();
        int strukTagihanTotalBiaya = strukTagihan.getTagihan11();
        int strukTagihanExcess = strukTagihan.getTagihan12();


        Assert.assertEquals(payor,strukTagihanPayor);
        Assert.assertEquals(strukNoTransaksi,strukTagihanNoTransaksi);
        Assert.assertEquals(nmrKartu,strukTagihanNmrKartu);
        Assert.assertEquals(nama,strukTagihanNama);
        Assert.assertEquals(status,tagihanStatus);
        Assert.assertEquals(status,strukTagihanStatus);
        Assert.assertEquals(noPolis,strukTagihanNoPolis);
        Assert.assertEquals(pemegangPolis,strukTagihanPemegangPolis);
        Assert.assertEquals(manfaat,strukTagihanManfaat);
//        Assert.assertEquals(tagihanDokterUmum,strukTagihanDokterUmum);
//        Assert.assertEquals(tagihanDokterSpc,strukTagihanDokterSpc);
//        Assert.assertEquals(tag);
        Assert.assertEquals(totalTagihanActual,strukTagihanTotalBiaya);
        Assert.assertEquals(850000,strukTagihanExcess);

        strukTagihan.clickBtnTutup();
        Utility.hardWait(10);

        pengesahanPage.clickPencarian();
        pengesahanPage.clickStatusTagihanSelesai();
        pengesahanPage.fillNoKartuManual("9999202300000001");
        pengesahanPage.clickJenisPerawatan();
        pengesahanPage.dropdownJenisPerawatan(ListPengesahanTagihanPage.JenisPerawatan.RAWATJALAN);
        pengesahanPage.clickRegDate();
        pengesahanPage.clickDateToday();
        pengesahanPage.clickBtnCari();
        Utility.hardWait(10);
//        commonPage.scrollDownByPixel();
        Assert.assertTrue(pengesahanPage.statusTagihanSelesai());
//        commonPage.openURL(urlAfterLogin);
//        Thread.sleep(2000);
        homePage.clickRawatJalan();
        rjPage.clickPencarian();
        rjPage.fillNoKartuManual("9999202300000001");
        rjPage.clickBtnCari();
        commonPage.scrollDownByPixel();
        rjPage.verifyStatusTagihanSelesai();

        homePage.clickRawatJalan();
        rjPage.clickBtnPendaftaran();
        daftar.clickBtnCariDataPasien();
        Assert.assertTrue(daftar.verifyColmnNoCardMandatory());
        daftar.inputCardNum("'9999202300000001");
        daftar.clickBtnCariDataPasien();
        Assert.assertTrue(daftar.verifyColmnTglLhrMandatory());
        daftar.inputDOB("01081988");
        daftar.clickBtnCariDataPasien();
        Assert.assertTrue(daftar.verifyColmnJnsPrwtanMandatory());
        daftar.clickJenisPerawatan();
        daftar.fillJenisPerawatan(PendaftaranRJPage.JenisPerawatan.RAWATJALAN);
        daftar.clickBtnCariDataPasien();

        int actualSisaLimitTersedia = limitTersedia-(strukTagihanTotalBiaya-strukTagihanExcess);
        int expectedSisaLimitTersedia = daftar.getBenefit6Sub2();
        Assert.assertEquals(actualSisaLimitTersedia,expectedSisaLimitTersedia);

        //cek limit setelah dibatalkan perawatan
        daftar.scrollUntilBtnDaftarkan();
        daftar.clickBtnDaftarkan();
        konfirmasi.clickBtnBatalkanTransaksi();
        konfirmasi.inputColmnPIC("Automation");
        konfirmasi.inputColmnBagian("Divisi Testing Automation");
        konfirmasi.inputColmnAlasan("Testing Automation");
        konfirmasi.scrollUntilBtnBatalkanPerawatan();
        konfirmasi.inputCaptcha("999");
        konfirmasi.scrollUntilBtnBatalkanPerawatan();
        konfirmasi.clickBtnBatalkanPerawatan();
        Utility.hardWait(45); //wait untuk handle agar void settlement reason tidak  undefined
        commonPage.openURL(urlAfterLogin);
        homePage.clickRawatJalan();
        rjPage.clickBtnPendaftaran();
//        Utility.hardWait(3);
        daftar.inputCardNum("9999202300000001");
        daftar.inputDOB("01081988");
        daftar.clickJenisPerawatan();
        daftar.fillJenisPerawatan(PendaftaranRJPage.JenisPerawatan.RAWATJALAN);
        daftar.clickBtnCariDataPasien();
        Utility.hardWait(5);
        int limitAfterCancel = daftar.getBenefit6Sub2();
        Assert.assertEquals(limitAfterCancel,limitTersedia);

    }

    @Test(testName = "Pendaftaran Rawat Jalan Data Miya(Positive Case)",priority = 1)
    public void regisRawatJalanMemberChissCIMB() throws InterruptedException {
        HomePage homePage = new HomePage(driver, explicitWait);
        ListRJPage rjPage = new ListRJPage(driver, explicitWait);
        PendaftaranRJPage daftar = new PendaftaranRJPage(driver, explicitWait);
        CommonPage commonPage = new CommonPage(driver, explicitWait);
        KonfirmasiPage konfirmasi = new KonfirmasiPage(driver, explicitWait);
        CetakStrukPage struk = new CetakStrukPage(driver, explicitWait);
        DetailPerawatanPage detail = new DetailPerawatanPage(driver, explicitWait);
        ListPengesahanTagihanPage pengesahanPage = new ListPengesahanTagihanPage(driver, explicitWait);
        FormTagihanPage tagihanPage = new FormTagihanPage(driver, explicitWait);
        TxtErrorPage errorPage = new TxtErrorPage(driver, explicitWait);
        DetailPengesahanPage detailPengesahanPage = new DetailPengesahanPage(driver,explicitWait);
        CetakStrukTagihanPage strukTagihan = new CetakStrukTagihanPage(driver,explicitWait);
        KonfirmasiTagihanPage konfirmasiTagihan = new KonfirmasiTagihanPage(driver,explicitWait);
        commonPage.openURL(urlAfterLogin);
        Utility.hardWait(3);
        homePage.clickRawatJalan();
        rjPage.clickBtnPendaftaran();
        daftar.clickBtnCariDataPasien();
        Assert.assertTrue(daftar.verifyColmnNoCardMandatory());
        daftar.inputCardNum("'9999202000000004");
        daftar.clickBtnCariDataPasien();
        Assert.assertTrue(daftar.verifyColmnTglLhrMandatory());
        daftar.inputDOB("13/12/1995");
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

        Assert.assertEquals("DUMMY 4",nama);
        Assert.assertEquals("Perempuan",jnsKelamin);
        Assert.assertEquals("13-12-1995",tglLahir);
        Assert.assertEquals("KARYAWAN",status);
        Assert.assertEquals("9999202000000004",nmrKartu);
        Assert.assertEquals("POLISSATU14072023",noPolis);
        Assert.assertEquals("DUMMY TESTING JUNI",pemegangPolis);
        Assert.assertEquals("PT Teknologi Pamadya Analitika (MEDITAP)",payor);

        //Cek Informasi Benefit
        Assert.assertTrue(daftar.txtDokterUmumIsDisplayed());
        Assert.assertTrue(daftar.txtDokterSpecialistIsDisplayed());
        Assert.assertTrue(daftar.txtObatAlkesIsDisplayed());
        Assert.assertTrue(daftar.txtFisioterapiIsDisplayed());
        Assert.assertTrue(daftar.txtLabDiagnoseIsDisplayed());
        Assert.assertFalse(daftar.txtKBIsDisplayed());
        Assert.assertFalse(daftar.txtImunisasiIsDisplayed());
        Assert.assertFalse(daftar.txtPerawatanTmbhKmbangIsDisplayed());
        Assert.assertFalse(daftar.txtPrePostMTIsDisplayed());
        Assert.assertFalse(daftar.txtMCUIsDisplayed());
        Assert.assertFalse(daftar.txtDrSpecTindakanAdminIsDisplayed());
        Assert.assertFalse(daftar.txtDrUmumTindakanAdminIsDisplayed());
        Assert.assertTrue(daftar.txtImunisasiAnakIsDisplayed());
        Assert.assertTrue(daftar.txtDokterObatIsDisplayed());
        Assert.assertTrue(daftar.txtPostRIIsDisplayed());
        Assert.assertFalse(daftar.txtKeguguranIsDisplayed());
        Assert.assertTrue(daftar.txtBiayaLain2IsDisplayed());
        Assert.assertTrue(daftar.txtAdministrasiIsDisplayed());
        Assert.assertFalse(daftar.txtPengobatanTradisionalChinaIsDisplayed());
        Assert.assertFalse(daftar.txtObatTindakanIsDisplayed());
        Assert.assertFalse(daftar.txtHemoKemoIsDisplayed());

        //Informasi Benefit Sub 1
        String manfaat = daftar.getTxtInformManfaat();
        String dokterUmum = daftar.getTxtBenefit1Sub1();
        int dokterSpc = daftar.getBenefit2Sub1();
        String obatALkes = daftar.getTxtBenefit3Sub1();
        String labDiagnose = daftar.getTxtBenefit4Sub1();
        String fisioterapi = daftar.getTxtBenefit5Sub1();
        //informasi benefit sub2
        String kb = daftar.getTxtBenefit1Sub2();
        String imunisasi = daftar.getTxtBenefit2Sub2();
        String tumbuhKembang = daftar.getTxtBenefit3Sub2();
        String prePostMT = daftar.getTxtBenefit4Sub2();
        String mcu = daftar.getTxtBenefit5Sub2();
        int limitTersedia = daftar.getBenefit6Sub2();

        Assert.assertEquals("Rawat Jalan",manfaat);
        Assert.assertEquals(200000,dokterUmum);
        Assert.assertEquals(300000,dokterSpc);
        Assert.assertEquals("Sesuai Tagihan",obatALkes);
        Assert.assertEquals("Sesuai Tagihan",labDiagnose);
        Assert.assertEquals("Sesuai Tagihan",fisioterapi);
        Assert.assertEquals("Sesuai Tagihan",kb);
        Assert.assertEquals("Sesuai Tagihan",imunisasi);
        Assert.assertEquals("Sesuai Tagihan",tumbuhKembang);
        Assert.assertEquals("Sesuai Tagihan",prePostMT);
        Assert.assertEquals("Sesuai Tagihan",mcu);
//        Assert.assertEquals(7405000,limitTersedia);

        daftar.scrollUntilBtnDaftarkan();
        daftar.clickBtnDaftarkan();

        //informasi halaman popup konfirmasi
        String nmrKartuKonfrm = konfirmasi.getTxtCardNo();
        String namaKonfrm = konfirmasi.getTxtNamaPeserta();
        String tglLahirKonfrm = konfirmasi.getTxtTglLahir();
        String nmKaryawanKonfirm = konfirmasi.getTxtNamaKaryawan();
        String statusKonfirm = konfirmasi.getTxtStatus();
        String pemegangPolisKonfrm = konfirmasi.getTxtPemegangPolis();
        String jnsPerawatanKonfrm = konfirmasi.getTxtJnsPerawatan();

        Assert.assertEquals(nmrKartu,nmrKartuKonfrm);
        Assert.assertEquals(nama,namaKonfrm);
        Assert.assertEquals(tglLahir,tglLahirKonfrm);
        Assert.assertEquals(nmKaryawanKonfirm,"Tomi Sudibyo");
        Assert.assertEquals(status,statusKonfirm);
        Assert.assertEquals(pemegangPolis,pemegangPolisKonfrm);
        Assert.assertEquals(manfaat,jnsPerawatanKonfrm);

//        Thread.sleep(5000);
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
        String strukManfaat = struk.getTxtManfaat();

        int strukDokterUmum = struk.getBenefit1();
        int strukDokterSpc = struk.getBenefit2();
        String strukObatAlkes =  struk.getTxtBenefit3();
        String strukLabDiagnose = struk.getTxtBenefit4();
        String strukFisioterapi = struk.getTxtBenefit5();
        String strukKb = struk.getTxtBenefit6();
        String strukImunisasi = struk.getTxtBenefit7();
        String strukTumbuhKembang = struk.getTxtBenefit8();
        String strukPrePost = struk.getTxtBenefit9();
        String strukMCU = struk.getTxtBenefit10();
        int strukLimitTersedia = struk.getBenefit11();


        Assert.assertEquals(payor,strukPayor);
        Assert.assertEquals(nama,strukNama);
        Assert.assertEquals(nmrKartu,strukNmrKartu);
        Assert.assertEquals(status,strukStatus); //having bugs in preview cetak struk
        Assert.assertEquals(nama,strukNama);
        Assert.assertEquals(noPolis,strukNoPolis);
        Assert.assertEquals(pemegangPolis,strukPemegangPolis); //having bugs in register
        Assert.assertEquals(manfaat,strukManfaat);

        Assert.assertEquals(dokterUmum,strukDokterUmum);
        Assert.assertEquals(dokterSpc,strukDokterSpc);
        Assert.assertEquals(obatALkes,strukObatAlkes);
        Assert.assertEquals(labDiagnose,strukLabDiagnose);
        Assert.assertEquals(fisioterapi,strukFisioterapi);
        Assert.assertEquals(kb,strukKb);
        Assert.assertEquals(imunisasi,strukImunisasi);
        Assert.assertEquals(tumbuhKembang,strukTumbuhKembang);
        Assert.assertEquals(prePostMT,strukPrePost);
        Assert.assertEquals(mcu,strukMCU);
        Assert.assertEquals(limitTersedia,strukLimitTersedia);

        struk.clickBtnTutup();
        Utility.hardWait(5);

        rjPage.clickPencarian();
        rjPage.fillNoKartu();
        rjPage.fillNoKartuManual("9999202300000001");
        rjPage.clickJenisPerawatan();
        rjPage.dropdownJenisPerawatan(ListRJPage.JenisPerawatan.RAWATJALAN);
        rjPage.clickBtnCari();
        commonPage.scrollDownByPixel();
        rjPage.verifyStatusPendaftaranBerhasil();
        rjPage.clickClaimNo();

        String dibuatOleh = detail.getCreateBy();
        String dibuatVia = detail.getCreateVia();
        String noKlaim = detail.getNoKlaim();
        String noTransaksi = detail.getNoTransaksi();
        String detailStatus = detail.getTxtStatus();
        String detailManfaat = detail.getTxtManfaat();
        String detailNama = detail.getTxtNama();
        String detailNmrKartu = detail.getTxtNmrKartu();
        String detailJnsKelamin = detail.getTxtJnsKelamin();
        String detailPayor = detail.getTxtPayor();

        Assert.assertEquals("adminrsmiya8",dibuatOleh);
        Assert.assertEquals("Meditap",dibuatVia);
        Assert.assertEquals(manfaat,detailManfaat);
        Assert.assertEquals(nama,detailNama);
        Assert.assertEquals(nmrKartu,detailNmrKartu);
        Assert.assertEquals(jnsKelamin,detailJnsKelamin);
        Assert.assertEquals(payor,detailPayor);
        Assert.assertEquals("Pendaftaran Berhasil",detailStatus);

        //Pengesahan
//        commonPage.openURL(urlAfterLogin);
        homePage.clickPengesahanTagihan();
        pengesahanPage.clickPencarian();
        pengesahanPage.fillNoKartuManual("9999202300000001");
        pengesahanPage.clickJenisPerawatan();
        pengesahanPage.dropdownJenisPerawatan(ListPengesahanTagihanPage.JenisPerawatan.RAWATJALAN);
        //Detail Tagihan
        pengesahanPage.clickClaimNo();
        String pengesahanNmrKartu = detailPengesahanPage.getTxtNoKartu();
        String pengesahanNama = detailPengesahanPage.getTxtNama();
        String pengesahanJnsKelamin = detailPengesahanPage.getTxtJnsKelamin();
        String pengesahanStatus = detailPengesahanPage.getTxtKaryawan();
        String statusTagihan = detailPengesahanPage.getTxtStatusTagihan();
        String pengesahanPayor = detailPengesahanPage.getTxtPayor();

        Assert.assertEquals(nmrKartu,pengesahanNmrKartu);
        Assert.assertEquals(nama,pengesahanNama);
        Assert.assertEquals(jnsKelamin,pengesahanJnsKelamin);
        Assert.assertEquals(status,pengesahanStatus);
        Assert.assertEquals("Menunggu Tagihan",statusTagihan);
        Assert.assertEquals(payor,pengesahanPayor);

        detailPengesahanPage.clickBtnLngkpTagihan();
        Thread.sleep(5000);
        tagihanPage.clickPilihDiagnosis();
        tagihanPage.inputKodeDiagnosa("A15");
        Utility.hardWait(2);
        tagihanPage.clickCheckbox1();
        tagihanPage.clickCheckbox2();
        tagihanPage.clickBtnKirim();
        String diagnose1 = tagihanPage.getTxtDiagnose1();
        //Tampil
        Assert.assertTrue(tagihanPage.colmnDokterUmumIsDisplayed());
        Assert.assertTrue(tagihanPage.colmnDokterSpecIsDisplayed());
        Assert.assertTrue(tagihanPage.colmnObatAlkesIsDisplayed());
        Assert.assertTrue(tagihanPage.colmnFisioterapiIsDisplayed());
        Assert.assertTrue(tagihanPage.colmnMCUIsDisplayed());
        Assert.assertTrue(tagihanPage.colmnLabDiagnosIsDisplayed());
        Assert.assertTrue(tagihanPage.colmnImunisasiIsDisplayed());
        Assert.assertTrue(tagihanPage.colmnKBIsDisplayed());
        Assert.assertTrue(tagihanPage.colmnPrePostMTIsDisplayed());
        Assert.assertTrue(tagihanPage.colmnTumbuhKembangIsDisplayed());
        //tidak tampil
        Assert.assertFalse(tagihanPage.colmnDrUmumTindakanAdminIsDisplayed());
        Assert.assertFalse(tagihanPage.colmnDrSpcTindakanAdminIsDisplayed());
        Assert.assertFalse(tagihanPage.colmnPengobatanTradisionalCinaIsDisplayed());
        Assert.assertFalse(tagihanPage.colmnHemoKemoIsDisplayed());
        Assert.assertFalse(tagihanPage.colmnAdminIsDisplayed());
        Assert.assertFalse(tagihanPage.colmnPostRIIsDisplayed());
        Assert.assertFalse(tagihanPage.colmnObatTindakanIsDisplayed());
        Assert.assertFalse(tagihanPage.colmnImunisasiAnakIsDisplayed());
        Assert.assertFalse(tagihanPage.colmnBiayaLain2IsDisplayed());
        Assert.assertFalse(tagihanPage.colmnDokterObatIsDisplayed());


        tagihanPage.inputBiayaDokterUmum("250000");
        tagihanPage.inputBiayaDokterSpec("350000");
        tagihanPage.inputBiayaObatAlkes("50000");
        tagihanPage.inputBiayaFisioterapi("100000");
        tagihanPage.inputBiayaMCU("150000");
        tagihanPage.inputBiayaLabDiagnos("50000");
        tagihanPage.inputBiayaImunisasi("100000");
        tagihanPage.inputBiayaKB("150000");
        tagihanPage.inputBiayaPrePostMT("100000");
        tagihanPage.inputBiayaTumbuhKembang("500000");
        tagihanPage.scrollUntilBtnProsesTagihan();
        tagihanPage.clickProsesTagihan();

        //informasi pasien Konfirmasi Proses Tagihan
        String tagihanNama = konfirmasiTagihan.getTxtNama();
        String tagihanNmrKartu = konfirmasiTagihan.getTxtNmrKartu();
        String tagihanStatus = konfirmasiTagihan.getTxtStatus();
        String tagihanJnsPerawatan = konfirmasiTagihan.getTxtJnsPerawatan();
        //informasi diagnosa
        String tagihanDiagnose1 = konfirmasiTagihan.getTxtDiagnose1();
        int tagihanDokterUmum = konfirmasiTagihan.getTagihan1();
        int tagihanDokterSpc = konfirmasiTagihan.getTagihan2();
        int tagihanObatAlkes = konfirmasiTagihan.getTagihan3();
        int tagihanFisioterapi = konfirmasiTagihan.getTagihan4();
        int tagihanMCU = konfirmasiTagihan.getTagihan5();
        int tagihanLabDiagnose = konfirmasiTagihan.getTagihan6();
        int tagihanImunisasi = konfirmasiTagihan.getTagihan7();
        int tagihanKB = konfirmasiTagihan.getTagihan8();
        int tagihanPrePostMT = konfirmasiTagihan.getTagihan9();
        int tagihanTumbuhKembang = konfirmasiTagihan.getTagihan10();
        int totalTagihanActual = tagihanDokterUmum+tagihanDokterSpc+tagihanObatAlkes+tagihanFisioterapi+
                tagihanMCU+tagihanLabDiagnose+tagihanImunisasi+tagihanKB+tagihanPrePostMT+tagihanTumbuhKembang;
        int totalTagihanExpected = konfirmasiTagihan.getTagihan11();

        Assert.assertEquals(nama,tagihanNama);
        Assert.assertEquals(nmrKartu,tagihanNmrKartu);
        Assert.assertEquals(status,tagihanStatus);
        Assert.assertEquals(manfaat,tagihanJnsPerawatan);
        Assert.assertEquals(diagnose1,tagihanDiagnose1);
        Assert.assertEquals(250000,tagihanDokterUmum);
        Assert.assertEquals(350000,tagihanDokterSpc);
        Assert.assertEquals(50000,tagihanObatAlkes);
        Assert.assertEquals(100000,tagihanFisioterapi);
        Assert.assertEquals(150000,tagihanMCU);
        Assert.assertEquals(50000,tagihanLabDiagnose);
        Assert.assertEquals(100000,tagihanImunisasi);
        Assert.assertEquals(150000,tagihanKB);
        Assert.assertEquals(100000,tagihanPrePostMT);
        Assert.assertEquals(500000,tagihanTumbuhKembang);
        Assert.assertEquals(totalTagihanActual,totalTagihanExpected);

        konfirmasiTagihan.scrollUntilBtnKirim();
        konfirmasiTagihan.clickBtnKirimKonfirmasi();
        errorPage.txtErrCaptchaNotNull();
        konfirmasiTagihan.inputCaptcha("888");
        konfirmasi.scrollUntilBtnKirim();
        konfirmasi.clickBtnKirimKonfirmasi();
        errorPage.txtKodeSalah();
        konfirmasiTagihan.inputCaptcha("999");
        konfirmasi.scrollUntilBtnKirim();
        konfirmasi.clickBtnKirimKonfirmasi();


        String strukTagihanPayor = strukTagihan.getTxtPayor();
        String strukTagihanNoTransaksi = strukTagihan.getTxtNoTransaksi();
        String strukTagihanNmrKartu = strukTagihan.getTxtNmrKartu();
        String strukTagihanNama = strukTagihan.getTxtNama();
        String strukTagihanStatus = strukTagihan.getTxtKaryawan();
        String strukTagihanNoPolis = strukTagihan.getTxtNoPolis();
        String strukTagihanPemegangPolis = strukTagihan.getTxtPemegangPolis();
        String strukTagihanManfaat = strukTagihan.getTxtManfaat();
//        int strukTagihanDokterSpc = strukTagihan.getTagihan1();
//        int strukTagihanDokterUmum = strukTagihan.getTagihan2();
//        int strukTagihanObatAlkes = strukTagihan.getTagihan3();
//        int strukTagihanLabDiagnose = strukTagihan.getTagihan4();
//        int strukTagihanFisioterapi = strukTagihan.getTagihan5();
//        int strukTagihanKb = strukTagihan.getTagihan6();
//        int strukTagihanImunisasi = strukTagihan.getTagihan7();
//        int strukTagihanTumbuhKembang = strukTagihan.getTagihan8();
//        int strukTagihanPrePostMT = strukTagihan.getTagihan9();
//        int strukTagihanMcu = strukTagihan.getTagihan10();
        int strukTagihanTotalBiaya = strukTagihan.getTagihan11();
        int strukTagihanExcess = strukTagihan.getTagihan12();


        Assert.assertEquals(payor,strukTagihanPayor);
        Assert.assertEquals(noTransaksi,strukTagihanNoTransaksi);
        Assert.assertEquals(nmrKartu,strukTagihanNmrKartu);
        Assert.assertEquals(nama,strukTagihanNama);
        Assert.assertEquals(status,tagihanStatus);
        Assert.assertEquals(status,strukTagihanStatus);
        Assert.assertEquals(noPolis,strukTagihanNoPolis);
        Assert.assertEquals(pemegangPolis,strukTagihanPemegangPolis);
        Assert.assertEquals(manfaat,strukTagihanManfaat);
//        Assert.assertEquals(tagihanDokterUmum,strukTagihanDokterUmum);
//        Assert.assertEquals(tagihanDokterSpc,strukTagihanDokterSpc);
//        Assert.assertEquals(tag);
        Assert.assertEquals(totalTagihanActual,strukTagihanTotalBiaya);
        Assert.assertEquals(850000,strukTagihanExcess);

        strukTagihan.clickBtnTutup();
        Utility.hardWait(10);

        pengesahanPage.clickPencarian();
        pengesahanPage.clickStatusTagihanSelesai();
        pengesahanPage.fillNoKartuManual("9999202300000001");
        pengesahanPage.clickJenisPerawatan();
        pengesahanPage.dropdownJenisPerawatan(ListPengesahanTagihanPage.JenisPerawatan.RAWATJALAN);
        pengesahanPage.clickRegDate();
        pengesahanPage.clickDateToday();
        pengesahanPage.clickBtnCari();
        Utility.hardWait(10);
//        commonPage.scrollDownByPixel();
        Assert.assertTrue(pengesahanPage.statusTagihanSelesai());
//        commonPage.openURL(urlAfterLogin);
//        Thread.sleep(2000);
        homePage.clickRawatJalan();
        rjPage.clickPencarian();
        rjPage.fillNoKartuManual("9999202300000001");
        rjPage.clickBtnCari();
        commonPage.scrollDownByPixel();
        rjPage.verifyStatusTagihanSelesai();

        homePage.clickRawatJalan();
        rjPage.clickBtnPendaftaran();
        daftar.clickBtnCariDataPasien();
        Assert.assertTrue(daftar.verifyColmnNoCardMandatory());
        daftar.inputCardNum("'9999202300000001");
        daftar.clickBtnCariDataPasien();
        Assert.assertTrue(daftar.verifyColmnTglLhrMandatory());
        daftar.inputDOB("01081988");
        daftar.clickBtnCariDataPasien();
        Assert.assertTrue(daftar.verifyColmnJnsPrwtanMandatory());
        daftar.clickJenisPerawatan();
        daftar.fillJenisPerawatan(PendaftaranRJPage.JenisPerawatan.RAWATJALAN);
        daftar.clickBtnCariDataPasien();

        int actualSisaLimitTersedia = limitTersedia-(strukTagihanTotalBiaya-strukTagihanExcess);
        int expectedSisaLimitTersedia = daftar.getBenefit6Sub2();
        Assert.assertEquals(actualSisaLimitTersedia,expectedSisaLimitTersedia);

        //cek limit setelah dibatalkan perawatan
        daftar.scrollUntilBtnDaftarkan();
        daftar.clickBtnDaftarkan();
        konfirmasi.clickBtnBatalkanTransaksi();
        konfirmasi.inputColmnPIC("Automation");
        konfirmasi.inputColmnBagian("Divisi Testing Automation");
        konfirmasi.inputColmnAlasan("Testing Automation");
        konfirmasi.scrollUntilBtnBatalkanPerawatan();
        konfirmasi.inputCaptcha("999");
        konfirmasi.scrollUntilBtnBatalkanPerawatan();
        konfirmasi.clickBtnBatalkanPerawatan();
        Utility.hardWait(45); //wait untuk handle agar void settlement reason tidak  undefined
        commonPage.openURL(urlAfterLogin);
        homePage.clickRawatJalan();
        rjPage.clickBtnPendaftaran();
//        Utility.hardWait(3);
        daftar.inputCardNum("9999202300000001");
        daftar.inputDOB("01081988");
        daftar.clickJenisPerawatan();
        daftar.fillJenisPerawatan(PendaftaranRJPage.JenisPerawatan.RAWATJALAN);
        daftar.clickBtnCariDataPasien();
        Utility.hardWait(5);
        int limitAfterCancel = daftar.getBenefit6Sub2();
        Assert.assertEquals(limitAfterCancel,limitTersedia);

    }

}
