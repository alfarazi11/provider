package page.chiss;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.BasePage;
import page.rawatjalan.ListRJPage;

import java.util.List;

public class WebClaimGLPage extends BasePage {
    public WebClaimGLPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
        super(driver, explicitWait);
        PageFactory.initElements(driver.get(),this);
    }

    @FindBy(xpath = "//a[.='Web Claim GL']")
    WebElement txtBtnWebClaimGL;

    @FindBy(xpath = "//td[.='Inquiry']")
    WebElement btnInquiry;

    @FindBy(xpath = "//td[.='Query']")
    WebElement btnQuery;

    @FindBy(xpath = "//select[@class='ListBox']")
    WebElement dropdownGLStatus;

    @FindBy(xpath = "//option[.='All GL Status']")
    WebElement all;

    @FindBy(xpath = "//option[.='Open']")
    WebElement open;

    @FindBy(xpath = "//option[.='Released']")
    WebElement released;

    @FindBy(xpath = "//option[.='Approved']")
    WebElement approved;

    @FindBy(xpath = "//option[.='Closed']")
    WebElement closed;

    @FindBy(xpath = "//option[.='Hold/Pending']")
    WebElement hold;

    @FindBy(xpath = "//option[.='Reject']")
    WebElement reject;

    @FindBy(xpath = "//input[@value='Retrieve Claim GL Data']")
    WebElement btnRetrieveClaimGL;

//    @FindAll({@FindBy(xpath = "//a[@id=' ']")})
//    List<WebElement> btnView;
//    @FindBy(xpath = "//a[@id='ctl00_ContentPlaceHolder1_DataGrid_ctl02_LnkBtnView']")
//    WebElement btnView;
    //table/tbody/tr[2]/td[2]/div/a[(text() = 'View')]

    @FindBy(xpath = "//table/tbody/tr[2]/td[4]")
    WebElement txtGLID;
    @FindBy(xpath = "//form[@id='aspnetForm']//tr[3]//input[@class='TextBox']")
    WebElement colmnReportDate;

    @FindBy(xpath = "//input[@value='IP']")
    WebElement colmnClaimType;

    @FindBy(xpath = "//td[.='IP']")
    WebElement claimTypeIP;

    @FindBy(xpath = "//form[@id='aspnetForm']//td[1]//td[1]//tr[19]//input[1]")
    WebElement colmnGuaranteeAmount;

    @FindBy(xpath = "//form[@id='aspnetForm']//td[1]//td[1]//tr[21]//input[2]")
    WebElement colmnRNBAmountTreatment;

    @FindBy(xpath = "//input[@title='Save GL Data']")
    WebElement btnSaveGLData;

    @FindBy(xpath = "//a[.='Add New Pre Diagnosis']")
    WebElement btnAddNewPreDiagnosis;

//    iframe[id='dialog-body']

    @FindBy(xpath = "//input[@class='F2Items']")
    WebElement colmnDiagnosisID;

    @FindBy(xpath = "//td[.='A.15']")
    WebElement diagnosisA15;

    @FindBy(xpath = "//input[@value='Save Pre-Diagnosis']")
    WebElement btnSavePreDiagnosis;

    @FindBy(xpath = "//span[(text() = 'Data is saved successfully')]")
    WebElement txtSaveSuccessfully;

    @FindBy(css = "[type='checkbox']")
    WebElement checkboxFinalDiagnosis;

    @FindBy(xpath = "//a[.='Close This Page']")
    WebElement txtBtnCloseThisPage;

    @FindBy(xpath = "//input[@title='Release GL']")
    WebElement btnReleaseGL;

    @FindBy(xpath = "//input[@class='Button']")
    WebElement btnReleaseThisClaimGL;


    public void clickBtnWebClaimGL() throws InterruptedException {
        doClick(txtBtnWebClaimGL);
    }

    public void clickBtnQueryClaimGL() throws InterruptedException {
        Actions act = new Actions(driver.get());
        act.moveToElement(btnInquiry).perform();
        doClick(btnQuery);
    }

    public void dropdownGLStatus(WebClaimGLPage.StatusGL statusGL) throws InterruptedException {
        switch (statusGL){
            case ALL:
                doClick(all);
                break;
            case OPEN:
                doClick(open);
                break;
            case RELEASED:
                doClick(released);
                break;
            case APPROVED:
                doClick(approved);
                break;
            case CLOSED:
                doClick(closed);
                break;
            case HOLD:
                doClick(hold);
                break;
            case REJECT:
                doClick(reject);
                break;
        }
    }

    public enum StatusGL{
        ALL,
        OPEN,
        RELEASED,
        APPROVED,
        CLOSED,
        HOLD,
        REJECT
    }

    public void clickBtnRetrieveClaimGL() throws InterruptedException {
        doClick(btnRetrieveClaimGL);
    }

    public void clickBtnView() throws InterruptedException {
        WebElement btnView = driver.get().findElement(By.xpath("//a[@id='ctl00_ContentPlaceHolder1_DataGrid_ctl02_LnkBtnView']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", btnView);
    }

    public String txtGLID(){
        return txtGLID.getText();
    }

    public void inputColmnReportDate (String date){
        doSetText(colmnReportDate,date);
    }

    public void f2ClaimType(){
        colmnClaimType.sendKeys(Keys.F2);
    }

    public void chooseClaimTypeIP() throws InterruptedException {
        doClick(claimTypeIP);
    }

    public void inputGuaranteeAmount(String amount){
        clear(colmnGuaranteeAmount);
        doSetText(colmnGuaranteeAmount,amount);
    }

    public void inputRNBAmountTreatment(String amount){
        clear(colmnRNBAmountTreatment);
        doSetText(colmnRNBAmountTreatment,amount);
    }

    public void clickBtnSaveGLData() throws InterruptedException {
        doClick(btnSaveGLData);
    }

    public void clickAddNewPreDiagnosis() throws InterruptedException {
        doClick(btnAddNewPreDiagnosis);
    }

    public void f2DiagnosisID(){
        colmnDiagnosisID.sendKeys(Keys.F2);
    }

    public void chooseDiagnosisA15() throws InterruptedException {
        doClick(diagnosisA15);
    }

    public void clickCheckboxFinalDiagnosis() throws InterruptedException {
        doClick(checkboxFinalDiagnosis);
    }

    public void clickBtnSavePreDiagnosis() throws InterruptedException {
        doClick(btnSavePreDiagnosis);
    }



    public boolean verifyTxtSavedSuccessfully(){
        if(doGetText(txtSaveSuccessfully).contains("successfully")){
            return true;
        }return false;
    }

    public void clickCLoseThisPage() throws InterruptedException {
        doClick(txtBtnCloseThisPage);
    }

    public void clickBtnReleaseGL() throws InterruptedException {
        doClick(btnReleaseGL);
    }

    public void clickBtnReleaseThisClaimGL() throws InterruptedException {
        doClick(btnReleaseThisClaimGL);
    }

}
