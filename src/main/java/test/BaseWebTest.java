package test;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.Utility;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseWebTest {

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    public static ThreadLocal<WebDriverWait> explicitWait = new ThreadLocal<WebDriverWait>();

    //url Staging
//    public String urlLogin = "https://iam.meditap.xyz/auth/realms/provider/protocol/openid-connect/auth?client_id=dire-web-provider&redirect_uri=https%3A%2F%2Fprovider-staging.meditap.id%2F&state=69afbe58-6806-4c45-bcc1-22be44423d29&response_mode=fragment&response_type=code&scope=openid&nonce=7805f0c5-5d03-482f-af3d-2105beaaecee&12f5Vfx9iMR5yo=8381949d-87d4-4a3c-9a29-e4c3b3650b24";
//    public String urlAfterLogin = "https://provider-staging.meditap.id/?12f5Vfx9iMR5yo=8381949d-87d4-4a3c-9a29-e4c3b3650b24";

    //url UAT
    public String urlLogin = "https://iam-uat.meditap.id/auth/realms/provider/protocol/openid-connect/auth?client_id=dire-web-provider&redirect_uri=https%3A%2F%2Fprovider-uat.meditap.id%2F&state=39f8268e-de41-437f-86ef-78408716ac4f&response_mode=fragment&response_type=code&scope=openid&nonce=51707a38-daa8-4e30-aabc-de052684af1b&12f5Vfx9iMR5yo=8381949d-87d4-4a3c-9a29-e4c3b3650b24";
    public String urlAfterLogin = "https://provider-uat.meditap.id/?12f5Vfx9iMR5yo=8381949d-87d4-4a3c-9a29-e4c3b3650b24";

    //urlLive
//    public String urlLogin = "https://iam.meditap.id/auth/realms/provider/protocol/openid-connect/auth?client_id=dire-web-provider&redirect_uri=https%3A%2F%2Fprovider2.meditap.id%2Foutpatient&state=aafdb66e-3e6a-48cb-8716-0da097acf02c&response_mode=fragment&response_type=code&scope=openid&nonce=d85a61bf-3380-4d76-b317-c90e9aeabf44&12f5Vfx9iMR5yo=8381949d-87d4-4a3c-9a29-e4c3b3650b24";
//    public String urlAfterLogin = "https://provider2.meditap.id/?12f5Vfx9iMR5yo=8381949d-87d4-4a3c-9a29-e4c3b3650b24";

    //Url Miya
//    public String urlLoginLiveMiya = "https://Tpa:Tpa@2023!@iam.meditap.id/auth/realms/provider/protocol/openid-connect/auth?client_id=dire-web-provider&redirect_uri=https%3A%2F%2Fprovider-advance.meditap.id%2F&state=4489e4dd-53d3-4d92-8599-388f1201689d&response_mode=fragment&response_type=code&scope=openid&nonce=247d9c50-a1f6-4eb9-8b03-cbfadc9183c6&12f5Vfx9iMR5yo=8381949d-87d4-4a3c-9a29-e4c3b3650b24";
//    public String urlLiveMiya = "https://provider-advance.meditap.id/?12f5Vfx9iMR5yo=8381949d-87d4-4a3c-9a29-e4c3b3650b24";
    @BeforeMethod
    public void createChromeDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments();
//        options.addArguments("--headless", "--disable-gpu", "--ignore-certificate-error",
//                "--disable-extensions", "--no-sandbox", "--disable-dev-shm-usage");
        driver.set(new FirefoxDriver(options));
        driver.get().manage().window().maximize();
//        driver.get().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//        driver.get().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get().get(urlLogin);
        explicitWait.set(new WebDriverWait(driver.get(), Duration.ofSeconds(10)));
    }

    @AfterMethod
    public void quitChromeDriver(ITestResult result) throws Exception {
//        if(result.getStatus()==result.FAILURE || result.getStatus()==result.SKIP) {
//            String screenshotPath = Utility.takeScreenshotAtEndOfTest(driver.get(), result.getName());
//            result.setAttribute("screenshotPath", screenshotPath); //sets the value the variable/attribute screenshotPath as the path of the sceenshot
//        }

        if(ITestResult.FAILURE== result.getStatus()){
            Utility.takeScreenShot2(result.getName());
        }
        driver.get().quit();
    }

}
