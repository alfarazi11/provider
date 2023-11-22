package page.rawatjalan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.BasePage;


public class CetakStrukPage extends BasePage {
    public CetakStrukPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
        super(driver, explicitWait);
        PageFactory.initElements(driver.get(),this);;
    }

    @FindBy(xpath = "//table[1]/tbody/tr[2]/td[3]")
    WebElement txtNoTransaksi;

    public String getTxtNoTransaksi(){
        return doGetText(txtNoTransaksi);
    }

    @FindBy(xpath = "//table[1]/tbody/tr[3]/td[3]")
    WebElement txtCardNumb;

    public String getTxtNoKartu(){
        return doGetText(txtCardNumb);
    }

    @FindBy(xpath = "//table[2]/tbody/tr[2]/td[3]")
    WebElement benefit1;

    public String getTxtBenefit1(){
        return doGetText(benefit1);
    }

    public int getBenefit1(){
        String benefit = doGetText(benefit1).replaceAll("[a-zA-Z,.* ]","");
        int benefit1 = Integer.parseInt(benefit);
        return benefit1;
    }

    @FindBy(xpath = "//table[2]/tbody/tr[3]/td[3]")
    WebElement benefit2;

    public String getTxtBenefit2(){
        return doGetText(benefit2);
    }

    public int getBenefit2(){
        String benefit = doGetText(benefit2).replaceAll("[a-zA-Z,.* ]","");
        int benefit1 = Integer.parseInt(benefit);
        return benefit1;
    }

    @FindBy(xpath = "//table[2]/tbody/tr[4]/td[3]")
    WebElement benefit3;

    public String getTxtBenefit3(){
        return doGetText(benefit3);
    }

    public int getBenefit3(){
        String benefit = doGetText(benefit3).replaceAll("[a-zA-Z,.* ]","");
        int benefit1 = Integer.parseInt(benefit);
        return benefit1;
    }

    @FindBy(xpath = "//table[2]/tbody/tr[5]/td[3]")
    WebElement benefit4;

    public String getTxtBenefit4(){
        return doGetText(benefit4);
    }

    public int getBenefit4(){
        String benefit = doGetText(benefit4).replaceAll("[a-zA-Z,.* ]","");
        int benefit1 = Integer.parseInt(benefit);
        return benefit1;
    }

    @FindBy(xpath = "//table[2]/tbody/tr[6]/td[3]")
    WebElement benefit5;

    public String getTxtBenefit5(){
        return doGetText(benefit5);
    }

    public int getBenefit5(){
        String benefit = doGetText(benefit5).replaceAll("[a-zA-Z,.* ]","");
        int benefit1 = Integer.parseInt(benefit);
        return benefit1;
    }

    @FindBy(xpath = "//table[2]/tbody/tr[7]/td[3]")
    WebElement benefit6;

    public String getTxtBenefit6(){
        return doGetText(benefit6);
    }

    public int getBenefit6(){
        String benefit = doGetText(benefit6).replaceAll("[a-zA-Z,.* ]","");
        int benefit1 = Integer.parseInt(benefit);
        return benefit1;
    }

    @FindBy(xpath = "//table[2]/tbody/tr[8]/td[3]")
    WebElement benefit7;

    public String getTxtBenefit7(){
        return doGetText(benefit7);
    }

    public int getBenefit7(){
        String benefit = doGetText(benefit7).replaceAll("[a-zA-Z,.* ]","");
        int benefit1 = Integer.parseInt(benefit);
        return benefit1;
    }

    @FindBy(xpath = "//table[2]/tbody/tr[9]/td[3]")
    WebElement benefit8;

    public String getTxtBenefit8(){
        return doGetText(benefit8);
    }

    public int getBenefit8(){
        String benefit = doGetText(benefit8).replaceAll("[a-zA-Z,.* ]","");
        int benefit1 = Integer.parseInt(benefit);
        return benefit1;
    }

    @FindBy(xpath = "//table[2]/tbody/tr[10]/td[3]")
    WebElement benefit9;

    public String getTxtBenefit9(){
        return doGetText(benefit9);
    }

    public int getBenefit9(){
        String benefit = doGetText(benefit9).replaceAll("[a-zA-Z,.* ]","");
        int benefit1 = Integer.parseInt(benefit);
        return benefit1;
    }

    @FindBy(xpath = "//table[2]/tbody/tr[11]/td[3]")
    WebElement benefit10;

    public String getTxtBenefit10(){
        return doGetText(benefit10);
    }

    public int getBenefit10(){
        String benefit = doGetText(benefit10).replaceAll("[a-zA-Z,.* ]","");
        int benefit1 = Integer.parseInt(benefit);
        return benefit1;
    }

    @FindBy(xpath = "//table[2]/tbody/tr[12]/td[3]")
    WebElement benefit11;

    public String getTxtBenefit11(){
        return doGetText(benefit11);
    }

    public int getBenefit11(){
        String benefit = doGetText(benefit11).replaceAll("[a-zA-Z,.* ]","");
        int benefit1 = Integer.parseInt(benefit);
        return benefit1;
    }

    @FindBy(xpath = "//table[2]/tbody/tr[13]/td[3]")
    WebElement benefit12;

    public String getTxtBenefit12(){
        return doGetText(benefit12);
    }

    public int getBenefit12(){
        String benefit = doGetText(benefit12).replaceAll("[a-zA-Z,.* ]","");
        int benefit1 = Integer.parseInt(benefit);
        return benefit1;
    }

    @FindBy(xpath = "//table[2]/tbody/tr[1]/td[3]")
    WebElement txtManfaat;

    public String getTxtManfaat(){
        return doGetText(txtManfaat);
    }

    @FindBy(xpath = "//table[1]/tbody/tr[1]/td[3]")
    WebElement txtPayor;

    public String getTxtPayor(){
        return doGetText(txtPayor);
    }

    @FindBy(xpath = "//table[1]/tbody/tr[4]/td[3]")
    WebElement txtPeserta;

    public String getTxtNamaPeserta(){
        return doGetText(txtPeserta);
    }

    @FindBy(xpath = "//table[1]/tbody/tr[6]/td[3]")
    WebElement txtStatus;

    public String getTxtStatus(){
        return doGetText(txtStatus);
    }

    @FindBy(xpath = "//table[1]/tbody/tr[7]/td[3]")
    WebElement txtNoPolis;

    public String getTxtNoPolis(){
        return doGetText(txtNoPolis);
    }

    @FindBy(xpath = "//table[1]/tbody/tr[8]/td[3]")
    WebElement txtPemegangPolis;

    public String getTxtPemegangPolis(){
        return doGetText(txtPemegangPolis);
    }

    @FindBy(xpath = "//button[@data-testid='btnTutupCetakStruk']")
    WebElement btnTutup;

    public void clickBtnTutup() throws InterruptedException {
        doClick(btnTutup);
    }

    @FindBy(xpath = "//p[.='PRIORITY MEMBER']")
    WebElement txtPriorityMember;

    public boolean verifyPriorityMember(){
        waitForElementPresent(txtPriorityMember);
        if(doGetText(txtPriorityMember).contains("PRIORITY MEMBER")){
            return true;
        }return false;
    }


}
