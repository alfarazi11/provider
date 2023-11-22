package page.pengesahantagihan;

import org.checkerframework.checker.formatter.qual.Format;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.BasePage;

import java.util.List;

public class CetakStrukTagihanPage extends BasePage {
    public CetakStrukTagihanPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
        super(driver, explicitWait);
        PageFactory.initElements(driver.get(),this);
    }

    @FindBy(xpath = "//button[(@data-testid='btnTutupCetakStruk')]")
    WebElement btnTutup;

    public void clickBtnTutup() throws InterruptedException {
        doClick(btnTutup);
    }

    @FindBy (xpath = "//div[contains(@class,'css-1d3bbye')]/table[1]/tbody[1]/tr[1]/td[3]")
    WebElement txtPayor;

    public String getTxtPayor(){
        return doGetText(txtPayor);
    }

    @FindBy(xpath = "//div[contains(@class,'css-1d3bbye')]/table[1]/tbody[1]/tr[2]/td[3]")
    WebElement txtNoTransaksi;

    public String getTxtNoTransaksi(){
        String noTransaksi = " "+doGetText(txtNoTransaksi);
        return noTransaksi;
    }

    @FindBy(xpath = "//div[contains(@class,'css-1d3bbye')]/table[1]/tbody[1]/tr[3]/td[3]")
    WebElement txtNmrKartu;

    public String getTxtNmrKartu(){
        return doGetText(txtNmrKartu);
    }

    @FindBy(xpath = "//div[contains(@class,'css-1d3bbye')]/table[1]/tbody[1]/tr[4]/td[3]")
    WebElement txtNama;

    public String getTxtNama(){
        return doGetText(txtNama);
    }

    @FindBy(xpath = "//div[contains(@class,'css-1d3bbye')]/table[1]/tbody[1]/tr[6]/td[3]")
    WebElement txtKaryawan;

    public String getTxtKaryawan(){
        return doGetText(txtKaryawan);
    }

    @FindBy(xpath = "//div[contains(@class,'css-1d3bbye')]/table[1]/tbody[1]/tr[7]/td[3]")
    WebElement txtNoPolis;

    public String getTxtNoPolis(){
        return doGetText(txtNoPolis);
    }

    @FindBy(xpath = "//div[contains(@class,'css-1d3bbye')]/table[1]/tbody[1]/tr[8]/td[3]")
    WebElement txtPemegangPolis;

    public String getTxtPemegangPolis(){
        return doGetText(txtPemegangPolis);
    }

    @FindBy(xpath = "//div[contains(@class,'css-1d3bbye')]/table[1]/tbody[1]/tr[9]/td[3]")
    WebElement txtNoKlaim;

    public String getTxtNoKlaim(){
        return doGetText(txtNoKlaim);
    }

    @FindBy(xpath = "//div[contains(@class,'css-1d3bbye')]/table[2]/tbody[1]/tr[2]/td[3]")
    WebElement txtManfaat;

    public String getTxtManfaat(){
        return doGetText(txtManfaat);
    }

    @FindBy (xpath = "//div[contains(@class,'css-1d3bbye')]/table[2]/tbody[1]/tr[3]/td[3]")
    WebElement tagihan1;

    public Integer getTagihan1(){
        String benefit = doGetText(tagihan1).replaceAll("[a-zA-Z,.* ]","");
        int benefit5Sub2 = Integer.parseInt(benefit);
        return benefit5Sub2;
    }

    @FindBy(xpath = "//div[contains(@class,'css-1d3bbye')]/table[2]/tbody[1]/tr[4]/td[3]")
    WebElement tagihan2;

    public Integer getTagihan2(){
        String benefit = doGetText(tagihan2).replaceAll("[a-zA-Z,.* ]","");
        int benefit5Sub2 = Integer.parseInt(benefit);
        return benefit5Sub2;
    }

    @FindBy(xpath = "//div[contains(@class,'css-1d3bbye')]/table[2]/tbody[1]/tr[5]/td[3]")
    WebElement tagihan3;

    public Integer getTagihan3(){
        String benefit = doGetText(tagihan3).replaceAll("[a-zA-Z,.* ]","");
        int benefit5Sub2 = Integer.parseInt(benefit);
        return benefit5Sub2;
    }

    @FindBy(xpath = "//div[contains(@class,'css-1d3bbye')]/table[2]/tbody[1]/tr[6]/td[3]")
    WebElement tagihan4;

    public Integer getTagihan4(){
        String benefit = doGetText(tagihan4).replaceAll("[a-zA-Z,.* ]","");
        int benefit5Sub2 = Integer.parseInt(benefit);
        return benefit5Sub2;
    }

    @FindBy(xpath = "//div[contains(@class,'css-1d3bbye')]/table[2]/tbody[1]/tr[7]/td[3]")
    WebElement tagihan5;

    public Integer getTagihan5(){
        String benefit = doGetText(tagihan5).replaceAll("[a-zA-Z,.* ]","");
        int benefit5Sub2 = Integer.parseInt(benefit);
        return benefit5Sub2;
    }

    @FindBy(xpath = "//div[contains(@class,'css-1d3bbye')]/table[2]/tbody[1]/tr[8]/td[3]")
    WebElement tagihan6;

    public Integer getTagihan6(){
        String benefit = doGetText(tagihan6).replaceAll("[a-zA-Z,.* ]","");
        int benefit5Sub2 = Integer.parseInt(benefit);
        return benefit5Sub2;
    }

    @FindBy(xpath = "//div[contains(@class,'css-1d3bbye')]/table[2]/tbody[1]/tr[9]/td[3]")
    WebElement tagihan7;

    public Integer getTagihan7(){
        String benefit = doGetText(tagihan7).replaceAll("[a-zA-Z,.* ]","");
        int benefit5Sub2 = Integer.parseInt(benefit);
        return benefit5Sub2;
    }

    @FindBy(xpath = "//div[contains(@class,'css-1d3bbye')]/table[2]/tbody[1]/tr[10]/td[3]")
    WebElement tagihan8;

    public Integer getTagihan8(){
        String benefit = doGetText(tagihan8).replaceAll("[a-zA-Z,.* ]","");
        int benefit5Sub2 = Integer.parseInt(benefit);
        return benefit5Sub2;
    }

    @FindBy(xpath = "//div[contains(@class,'css-1d3bbye')]/table[2]/tbody[1]/tr[11]/td[3]")
    WebElement tagihan9;

    public Integer getTagihan9(){
        String benefit = doGetText(tagihan9).replaceAll("[a-zA-Z,.* ]","");
        int benefit5Sub2 = Integer.parseInt(benefit);
        return benefit5Sub2;
    }

    @FindBy(xpath = "//div[contains(@class,'css-1d3bbye')]/table[2]/tbody[1]/tr[12]/td[3]")
    WebElement tagihan10;

    public Integer getTagihan10(){
        String benefit = doGetText(tagihan10).replaceAll("[a-zA-Z,.* ]","");
        int benefit5Sub2 = Integer.parseInt(benefit);
        return benefit5Sub2;
    }

    @FindBy(xpath = "//div[contains(@class,'css-1d3bbye')]/table[2]/tbody[1]/tr[13]/td[3]")
    WebElement tagihan11;

    public Integer getTagihan11(){
        String benefit = doGetText(tagihan11).replaceAll("[a-zA-Z,.* ]","");
        int benefit5Sub2 = Integer.parseInt(benefit);
        return benefit5Sub2;
    }

    @FindBy(xpath = "//div[contains(@class,'css-1d3bbye')]/table[2]/tbody[1]/tr[14]/td[3]")
    WebElement tagihan12;

    public Integer getTagihan12(){
        String benefit = doGetText(tagihan12).replaceAll("[a-zA-Z,.* ]","");
        int benefit5Sub2 = Integer.parseInt(benefit);
        return benefit5Sub2;
    }

    @FindBy(xpath = "//div[contains(@class,'css-1d3bbye')]/table[2]/tbody[1]/tr[15]/td[3]")
    WebElement tagihan13;

    public Integer getTagihan13(){
        String benefit = doGetText(tagihan13).replaceAll("[a-zA-Z,.* ]","");
        int benefit5Sub2 = Integer.parseInt(benefit);
        return benefit5Sub2;
    }


}
