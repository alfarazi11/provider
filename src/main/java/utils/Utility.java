package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static test.BaseWebTest.driver;


public class Utility {

    public static void hardWait(int second) {
        try {
            Thread.sleep(1000 * second);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void takeScreenShot(ITestResult result) throws IOException {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        String methodName = result.getName();

        String reportDirectory = new File(System.getProperty("user.dir")) + "/target/surefire-reports";
        File scrFile = ((TakesScreenshot) driver.get()).getScreenshotAs(OutputType.FILE);
        File destFile = new File((String) reportDirectory + "/screenshots/" + methodName + "_" + simpleDateFormat.format(calendar.getTime()) + ".png");
        FileUtils.copyFile(scrFile, destFile);
        Reporter.log("<a href='" + destFile + "'> <img src='" + destFile + "' height='320' width='180'/> </a>");

    }

    public static void takeScreenShot2(String filename) throws IOException {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

        String reportDirectory = new File(System.getProperty("user.dir")) + "/target/surefire-reports";
        File scrFile = ((TakesScreenshot) driver.get()).getScreenshotAs(OutputType.FILE);
        File destFile = new File((String) reportDirectory + "/screenshots/" + filename + "_" + simpleDateFormat.format(calendar.getTime()) + ".png");
        FileUtils.copyFile(scrFile, destFile);
        Reporter.log("<a href='" + destFile + "'> <img src='" + destFile + "' height='320' width='180'/> </a>");

    }

    public static String takeScreenshotAtEndOfTest(WebDriver driver, String result) throws IOException {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "/screenshots/" +  dateName
                + ".png";
        File finalDestination = new File(destination);
        FileHandler.copy(source, finalDestination);
        return destination;
    }

}
