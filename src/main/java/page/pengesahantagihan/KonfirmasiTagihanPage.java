package page.pengesahantagihan;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.BasePage;

public class KonfirmasiTagihanPage extends BasePage {
    public KonfirmasiTagihanPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
        super(driver, explicitWait);
        PageFactory.initElements(driver.get(),this);
    }

    @FindBy(xpath = "//div[1]/div[3]/div[3]")
    WebElement txtNama;

    public String getTxtNama(){
        return doGetText(txtNama);
    }

    @FindBy(xpath = "//div[1]/div[4]/div[3]")
    WebElement txtNmrKartu;

    public String getTxtNmrKartu(){
        return doGetText(txtNmrKartu);
    }

    @FindBy(xpath = "//div[1]/div[5]/div[3]")
    WebElement txtStatus;

    public String getTxtStatus(){
        return doGetText(txtStatus);
    }

    @FindBy(xpath = "//div[1]/div[6]/div[3]")
    WebElement txtJnsPerawatan;

    public String getTxtJnsPerawatan(){
        return doGetText(txtJnsPerawatan);
    }

    @FindBy(xpath = "//div/div[2]/div[2]/div[2]/div[3]")
    WebElement txtDiagnose1;

    public String getTxtDiagnose1(){
        return doGetText(txtDiagnose1);
    }

    @FindBy(xpath = "//div/div[2]/div[2]/div[3]/div[3]")
    WebElement txtDiagnose2;

    public String getTxtDiagnose2(){
        return doGetText(txtDiagnose2);
    }

    @FindBy(xpath = "//div/div[2]/div[2]/div[4]/div[3]")
    WebElement txtDiagnose3;

    public String getTxtDiagnose3(){
        return doGetText(txtDiagnose3);
    }

    @FindBy(xpath = "//div/div[2]/div[3]/div[2]/div[3]")
    WebElement tagihan1;

    public Integer getTagihan1(){
        String benefit = doGetText(tagihan1).replaceAll("[a-zA-Z,.* ]","");
        int benefit5Sub2 = Integer.parseInt(benefit);
        return benefit5Sub2;
    }

    @FindBy(xpath = "//div/div[2]/div[3]/div[3]/div[3]")
    WebElement tagihan2;

    public Integer getTagihan2(){
        String benefit = doGetText(tagihan2).replaceAll("[a-zA-Z,.* ]","");
        int benefit5Sub2 = Integer.parseInt(benefit);
        return benefit5Sub2;
    }

    @FindBy(xpath = "//div/div[2]/div[3]/div[4]/div[3]")
    WebElement tagihan3;

    public Integer getTagihan3(){
        String benefit = doGetText(tagihan3).replaceAll("[a-zA-Z,.* ]","");
        int benefit5Sub2 = Integer.parseInt(benefit);
        return benefit5Sub2;
    }

    @FindBy(xpath = "//div/div[2]/div[3]/div[5]/div[3]")
    WebElement tagihan4;

    public Integer getTagihan4(){
        String benefit = doGetText(tagihan4).replaceAll("[a-zA-Z,.* ]","");
        int benefit5Sub2 = Integer.parseInt(benefit);
        return benefit5Sub2;
    }

    @FindBy(xpath = "//div/div[2]/div[3]/div[6]/div[3]")
    WebElement tagihan5;

    public Integer getTagihan5(){
        String benefit = doGetText(tagihan5).replaceAll("[a-zA-Z,.* ]","");
        int benefit5Sub2 = Integer.parseInt(benefit);
        return benefit5Sub2;
    }

    @FindBy(xpath = "//div/div[2]/div[3]/div[7]/div[3]")
    WebElement tagihan6;

    public Integer getTagihan6(){
        String benefit = doGetText(tagihan6).replaceAll("[a-zA-Z,.* ]","");
        int benefit5Sub2 = Integer.parseInt(benefit);
        return benefit5Sub2;
    }

    @FindBy(xpath = "//div/div[2]/div[3]/div[8]/div[3]")
    WebElement tagihan7;

    public Integer getTagihan7(){
        String benefit = doGetText(tagihan7).replaceAll("[a-zA-Z,.* ]","");
        int benefit5Sub2 = Integer.parseInt(benefit);
        return benefit5Sub2;
    }

    @FindBy(xpath = "//div/div[2]/div[3]/div[9]/div[3]")
    WebElement tagihan8;

    public Integer getTagihan8(){
        String benefit = doGetText(tagihan8).replaceAll("[a-zA-Z,.* ]","");
        int benefit5Sub2 = Integer.parseInt(benefit);
        return benefit5Sub2;
    }

    @FindBy(xpath = "//div/div[2]/div[3]/div[10]/div[3]")
    WebElement tagihan9;

    public Integer getTagihan9(){
        String benefit = doGetText(tagihan9).replaceAll("[a-zA-Z,.* ]","");
        int benefit5Sub2 = Integer.parseInt(benefit);
        return benefit5Sub2;
    }

    @FindBy(xpath = "//div/div[2]/div[3]/div[11]/div[3]")
    WebElement tagihan10;

    public Integer getTagihan10(){
        String benefit = doGetText(tagihan10).replaceAll("[a-zA-Z,.* ]","");
        int benefit5Sub2 = Integer.parseInt(benefit);
        return benefit5Sub2;
    }

    @FindBy(xpath = "//div/div[2]/div[3]/div[12]/div[3]")
    WebElement tagihan11;

    public Integer getTagihan11(){
        String benefit = doGetText(tagihan11).replaceAll("[a-zA-Z,.* ]","");
        int benefit5Sub2 = Integer.parseInt(benefit);
        return benefit5Sub2;
    }

    @FindBy(xpath = "//div/div[2]/div[3]/div[13]/div[3]")
    WebElement tagihan12;

    public Integer getTagihan12(){
        String benefit = doGetText(tagihan12).replaceAll("[a-zA-Z,.* ]","");
        int benefit5Sub2 = Integer.parseInt(benefit);
        return benefit5Sub2;
    }

    @FindBy(xpath = "//*[(@data-testid='captcha-input')]")
    WebElement colmnCaptcha;

    public void inputCaptcha(String captcha)  {
        clear(colmnCaptcha);
        doSetText(colmnCaptcha, captcha);
    }

    @FindBy(xpath = "//button[(@data-testid='btnKirim')]")
    WebElement btnKirimKonfirmasi;

    public void scrollUntilBtnKirim() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver.get();
        js.executeScript("arguments[0].scrollIntoView();",btnKirimKonfirmasi);
        Thread.sleep(2000);
    }

    public void clickBtnKirimKonfirmasi() throws InterruptedException {
        doClick(btnKirimKonfirmasi);
    }

}
