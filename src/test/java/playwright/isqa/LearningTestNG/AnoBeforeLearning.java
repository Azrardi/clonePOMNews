package playwright.isqa.LearningTestNG;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class AnoBeforeLearning {
    @BeforeSuite
    public void setup() {
        System.out.println("Setup for the tests");
    }

    @BeforeClass
    public void launcBrowser() {
        System.out.println("Launch Chrome browser");
    }

    @BeforeMethod
    public void openPage() {
        System.out.println("Open the webpage");
    }
    //@BeforeTest
    

}