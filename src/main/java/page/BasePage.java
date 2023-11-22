package page;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    public ThreadLocal<WebDriverWait> explicitWait = new ThreadLocal<WebDriverWait>();

    public BasePage(ThreadLocal<WebDriver> driver,ThreadLocal<WebDriverWait> explicitWait) {
        this.driver = driver;
        this.explicitWait = explicitWait;
    }

    public void doClick(WebElement element) throws InterruptedException{
        waitForClickable(element);
        Thread.sleep(100);
        element.click();

    }

    public void doSetText(WebElement element, String text) {
        waitForVisibility(element);
        element.sendKeys(text);
    }

    protected final String doGetText(WebElement element) {
        waitForVisibility(element);
        String actualText = element.getText();
        return actualText;
    }

    public void clear(WebElement element) {
        waitForVisibility(element);
        element.clear();
    }

    public void SelectOption(By combobox, String option) {
        WebElement element = explicitWait.get().until(ExpectedConditions.elementToBeClickable(combobox));
        Select select = new Select(element);
        select.selectByVisibleText(option);
    }

    public void waitForVisibility(WebElement element) {
        explicitWait.get().until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForClickable(WebElement element) {

        try {
            explicitWait.get().until(ExpectedConditions.elementToBeClickable(element));
        } catch (NoSuchElementException e) {
        }

    }

    public boolean waitForElementPresent(WebElement element) {
        try {
            driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }

    }

}
