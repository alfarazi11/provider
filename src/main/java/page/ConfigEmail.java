package page;


import org.apache.commons.mail.*;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConfigEmail {

//    public void sendReportViaEmail1() throws EmailException {
//        try {
//            String pathPropertiesLive = System.getProperty("user.dir") + "/data/config-send-report.properties";
//            String pathEmailableLive = System.getProperty("user.dir") + "/target/surefire-reports/emailable-report.html";
//            EmailUtils emailUtils = new EmailUtils();
//            Properties prop = new Properties();
//            prop.load(new FileInputStream(pathPropertiesLive));
//            List<String> attachments = new ArrayList<>();
//            attachments.add(pathEmailableLive);
//            emailUtils.sendUsingGmail(prop, "Result automation New Provider", "Dear pak Arif\n" +
//                    "\n" +
//                    "Berikut hasil running automation hari ini\n" +
//                    "\n" +
//                    "\n" +
//                    "Warm Regards\n" +
//                    "Arrumi Alfarazi",attachments);
//        }
//        catch (NoSuchElementException e){
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//    }
    @Test
    public void sendReportViaEmail2(){
        try{
            String pathEmailableLive = System.getProperty("user.dir") + "/target/surefire-reports/Provider_Report.html";
            // Create the attachment
            EmailAttachment attachment = new EmailAttachment();
            attachment.setPath(pathEmailableLive);
            attachment.setDisposition(EmailAttachment.ATTACHMENT);
            attachment.setDescription("Report Automation X-Midd");
            attachment.setName("xmidd-report.html");

            // Create the email message
            MultiPartEmail email = new MultiPartEmail();
            email.setHostName("smtp.gmail.com");
//            email.setSmtpPort(587);
            email.setAuthenticator(new DefaultAuthenticator("arrumi.alfarazi@meditap.id", "hzwwrymyyfbkumuu"));
            email.setSSLOnConnect(true);
            email.setFrom("qameditap@gmail.com");
            email.setSubject("Result automation New Provider");
            email.setMsg("Dear pak Arif dan tim\n" +
                    "\n" +
                    "Berikut hasil running automation hari ini\n" +
                    "\n" +
                    "https://allure-dashboard.meditap.id/allure-docker-service/projects/dire-web-provider/reports/surefire-reports/Provider_Report.html\n"+
                    "\n" +
                    "Warm Regards\n" +
                    "Arrumi Alfarazi");
            email.addTo("arrumi.alfarazi@meditap.id");
            email.addTo("arif.wiwoho@meditap.id");
            email.addCc("ivan.lie@meditap.id");
            email.addCc("krista.natalia@meditap.id");
            email.addCc("rosa.pratama@meditap.id");
            email.addCc("rosyid.ridho@meditap.id");
            email.addCc("ninik.widyawati@meditap.id");
            email.attach(attachment);
            email.send();
        }
        catch (NoSuchElementException e){
        } catch (EmailException e) {
                    throw new RuntimeException(e);
                }
    }

}
