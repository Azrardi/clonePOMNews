 package ListenerPOMNew;

 import com.aventstack.extentreports.ExtentReports;
 import com.aventstack.extentreports.MediaEntityBuilder;
 import com.aventstack.extentreports.Status;
 import com.aventstack.extentreports.reporter.ExtentSparkReporter;
 import com.microsoft.playwright.*;
 import org.testng.annotations.AfterTest;
 import org.testng.annotations.BeforeTest;

 import java.awt.*;
 import java.io.File;
 import java.io.IOException;
 import java.nio.file.Paths;

 import static PlaywrightFactoryPOM.PLaywrightFactory.encodeFileToBase64Binary;
 /*
 *Integration with TestNG
 * Annotations Level
 * Listener Level
 * */

 public class ExtendReportTestNG {
     public static Page page;


     @BeforeTest
     public void SetUp(){
         Playwright playwright = Playwright.create();
         Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
         BrowserContext context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("myvideos/")).setRecordVideoSize(640, 480));
         page = context.newPage();
         //navigate to application
         page.navigate("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

     }

     @AfterTest
     public void TearDown(){
         page.close();
     }

     public static void main(String[] args) throws IOException {
         ExtentReports extentReports = new ExtentReports();
         File file = new File("extentreports.html");
         ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extentreports.html");
         extentReports.attachReporter(sparkReporter);


         String takeScreenshot = takeScreenshot();
         System.out.println(takeScreenshot);

         String base64COde = takeScreenshotBase64();
         String path = takeScreenshot();


         //Log Ekstend Report
         extentReports
                 .createTest("Screenhots Tests 1","This is for attaching the screenshot to the test at test level")
                 .log(Status.INFO,"This is a info msg")
                         .addScreenCaptureFromBase64String(base64COde);

         extentReports
                 .createTest("Screenhots Tests 2","This is for attaching the screenshot to the test at test level")
                 .log(Status.INFO,"This is a info msg")
                         .addScreenCaptureFromBase64String(base64COde,"Google Home");
         extentReports
                 .createTest("Screenhots Tests 3","This is for attaching the screenshot to the test at test level")
                 .log(Status.INFO,"This is a info msg")
                         .addScreenCaptureFromPath(path);

         extentReports
                 .createTest("Screenhots Tests 4","This is for attaching the screenshot to the test at test level")
                 .log(Status.INFO,"This is a info msg")
                         .addScreenCaptureFromPath(path,"Google From Path");
         extentReports
                 .createTest("Screenhots Tests 5","This is for attaching the screenshot to the test at test level")
                 .log(Status.INFO,"This is a info msg")
                         .addScreenCaptureFromPath(path,"Google From Path1")
                         .addScreenCaptureFromPath(path,"Google From Path2")
                         .addScreenCaptureFromPath(path,"Google From Path3");
         extentReports
                 .createTest("Screenhots Tests 6","This is for attaching the screenshot to the test at test level")
                 .log(Status.INFO,"This is a info msg")
                         .fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64COde,"Basecode").build())
                                 .fail(MediaEntityBuilder.createScreenCaptureFromPath(path,"Path").build());

         Throwable t = new Throwable("This is Throwable Exeption");
         extentReports
                 .createTest("Screenhots Tests 7","This is for attaching the screenshot to the test at log level")
                 .log(Status.INFO,"This is a info msg")
                         .fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64COde,"Basecode").build())
                                 .fail(MediaEntityBuilder.createScreenCaptureFromPath(path,"Path").build())
                                         .fail(t, MediaEntityBuilder.createScreenCaptureFromBase64String(base64COde,"Basecode").build());


         extentReports.flush();
         Desktop.getDesktop().browse(new File("extentreports.html").toURI());
     }
     public static String takeScreenshotBase64(){
         File f = new File(takeScreenshot());
         String encodstring = encodeFileToBase64Binary(f);
         //System.out.println(encodstring);

         return encodstring;
     }

     public static String takeScreenshot() {
         // Get the current working directory
         String systemDir = System.getProperty("user.dir");

         // Define the path for the screenshot
         String path = systemDir + "/screenshots/" + System.currentTimeMillis() + ".png";
         //System.out.println("location : " + Paths.get(path));

         try {
             // Take a screenshot and save it to the specified path
             page.screenshot(new Page.ScreenshotOptions()
                     .setPath(Paths.get(path))
                     .setFullPage(true));
             System.out.println("Screenshot taken successfully.");
         } catch (Exception e) {
             System.err.println("Failed to take screenshot: " + e.getMessage());
         }

         //System.out.println("location : " + Paths.get(path));
         return path;
     }
 }
