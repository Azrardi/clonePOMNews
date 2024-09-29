package ListenerPOMNew;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static PlaywrightFactoryPOM.PLaywrightFactory.takeScreenshot;
import static PlaywrightFactoryPOM.PLaywrightFactory.takeScreenshotFinal;


public class ExtentReportListener implements ITestListener {

    private static final String OUTPUT_FOLDER = "./build/";
    //private static final String FILE_NAME = "TestExecutionReport.html";
    private static ExtentReports extent = init();
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
    private static ExtentReports extentReports;

    private static ExtentReports init() {
        Path path = Paths.get(OUTPUT_FOLDER);
        // if directory exist?
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // Generate a unique file name based on the current date and time
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = "TestReport_" + timestamp + ".html";

        extentReports = new ExtentReports();
        ExtentSparkReporter reporter = new ExtentSparkReporter(OUTPUT_FOLDER + fileName);
        reporter.config().setReportName("Open Cart Automation Test Results");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("System", "Windows");
        extentReports.setSystemInfo("Author", "Azra Machine");
        extentReports.setSystemInfo("Build#", "1.1");
        extentReports.setSystemInfo("Team", "OMS");
        extentReports.setSystemInfo("Customer Name", "Manulife");

        return extentReports;

    }

    @Override
    public synchronized void onStart(ITestContext context) {
        System.out.println("Test Suite started!");
    }

    @Override
    public synchronized void onFinish(ITestContext context) {
        System.out.println("Test Suite is End!");
        extent.flush();
        test.remove();
    }

    @Override
    public synchronized void onTestStart(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        String qualifieName = result.getMethod().getQualifiedName();
        int last = qualifieName.lastIndexOf(".");
        int mid = qualifieName.substring(0, last).lastIndexOf(".");
        String className = qualifieName.substring(mid + 1, last);

//        System.out.println(methodName + " started!");
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),
                result.getMethod().getDescription());
        extentTest.assignCategory(result.getTestContext().getSuite().getName());
        /*
            methodName = StringUtils.capitalize(StringUtils.join(StringUtils.splitByCharacterTypeCamel
            Case(method), StringUtils.SPACE
         */
        extentTest.assignCategory(className);
        test.set(extentTest);
        test.get().getModel().setStartTime(getTime(result.getStartMillis()));

    }

    public synchronized void onTestSucces(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + "passed!"));
        test.get().pass("Test passed");
        //test.get().pass(result.getThrowable(), Media EnityBuilder.createScreenCaptureFromPath(result.get)
        test.get().getModel().setEndTime(getTime(result.getStartMillis()));
    }

    public static ExtentTest extentTest;

    public synchronized void onTestFailure(ITestResult result) {

        System.out.println((result.getMethod().getMethodName() + "failed!"));

        test.get().fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotFinal()).build());
        test.get().getModel().setEndTime(getTime(result.getEndMillis()));
//        CustomListeners.test.log(LogStatus.PASS, extentTest.addScreenCapture(screenshotName+".png"));

    }


    public synchronized void onTestSkipped(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " skipped!"));
        test.get().fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshot()).build());
        test.get().getModel().setEndTime(getTime(result.getEndMillis()));
    }

    public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println(("onTestFailedButWithinSuccesPercentage for " + result.getMethod().getMethodName()));
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }
}
