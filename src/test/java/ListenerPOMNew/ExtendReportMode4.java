 package ListenerPOMNew;

 import com.aventstack.extentreports.ExtentReports;
 import com.aventstack.extentreports.Status;
 import com.aventstack.extentreports.markuputils.ExtentColor;
 import com.aventstack.extentreports.markuputils.MarkupHelper;
 import com.aventstack.extentreports.reporter.ExtentSparkReporter;

 import java.awt.*;
 import java.io.File;
 import java.io.IOException;
 /*
 * Log Different Type of information to the extendt report
 * Test- BOld , italic
 * XML
 * JSON
 * Collection Data ( List, set and Map)
 * Highlight any message
 * exception
 * */

 public class ExtendReportMode4 {
     public static void main(String[] args) throws IOException {
         ExtentReports extentReports = new ExtentReports();
         File file = new File("extentreports.html");
         ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extentreports.html");
         extentReports.attachReporter(sparkReporter);

         extentReports.createTest("Text Baset For Testing")
                 .log(Status.INFO,"Info1")
                 .log(Status.INFO,"<b>Info2</b>")
                 .log(Status.INFO,"<i>Info3</i>");

         extentReports.createTest("Higlight Log Test")
                 .log(Status.INFO,"This in not a highlight message")
                         .info(MarkupHelper.createLabel("This is a highlight message", ExtentColor.RED));
         extentReports.flush();
         Desktop.getDesktop().browse(new File("extentreports.html").toURI());
     }
 }
