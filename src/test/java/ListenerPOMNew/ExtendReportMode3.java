 package ListenerPOMNew;

 import com.aventstack.extentreports.ExtentReports;
 import com.aventstack.extentreports.Status;
 import com.aventstack.extentreports.reporter.ExtentSparkReporter;

 import java.awt.*;
 import java.io.File;
 import java.io.IOException;
 /*
 * Understand the log levels in extent report
 * Fail
 * Skip
 * Warning
 * Pass
 * Info
 * */

public class ExtendReportMode3 {
    public static void main(String[] args) throws IOException {
        ExtentReports extentReports = new ExtentReports();
        File file = new File("extentreports.html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extentreports.html");
        extentReports.attachReporter(sparkReporter);

        extentReports.createTest("Test1")
                .log(Status.INFO,"Info1")
                .log(Status.INFO,"Info2")
                .log(Status.PASS,"Info3")
                .log(Status.WARNING,"Warning")
                .log(Status.SKIP,"SKIP")
                //.log(Status.FAIL,"FAIL")
                .log(Status.PASS,"PASS");

        extentReports.flush();
        Desktop.getDesktop().browse(new File("extentreports.html").toURI());
    }
}
