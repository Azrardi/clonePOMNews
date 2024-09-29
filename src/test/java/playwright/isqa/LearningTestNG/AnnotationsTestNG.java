package playwright.isqa.LearningTestNG;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.nio.file.Paths;

/*
* Parameter In TensNG
* --------------------------------
* What is the use of TesNG parameters?
* How to use the TestNG parameters?
* --------------------------------
* */


public class AnnotationsTestNG {
    private static Locator canvas;
    public static Page page;

    @Test
    public static void testNotMain(){
        // create playwright and browser instances
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("myvideos/")).setRecordVideoSize(640, 480));
        page = context.newPage();

        //navigate to application
        page.navigate("https://google.com/");
        page.getByLabel("Cari").fill("azra");
        page.getByText("azra", new Page.GetByTextOptions().setExact(true)).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Rumah Sakit Azra Rumah Sakit Azra https://rsazra.co.id")).click();

        //Soft Assertion
        SoftAssert softAssertion = new SoftAssert();

        //Tittle Assertions
        String expectedTitle = " Rumah Sakit Azra";
        String actualTitle = page.title();
        System.out.println(page.title());
        softAssertion.assertEquals(expectedTitle, actualTitle, "Not Verify Assertion");

        //URL Asserion
        String actualUrl = page.url();
        String expectedUrl = "https://rsazra.co.id/";
        softAssertion.assertEquals(expectedUrl, actualUrl, "Title is mismatched");
        System.out.println(page.url());

        //Text Asserion
        String actualText = page.textContent("//span[normalize-space()='Contact Center 0251 - 8318 456']");
        String expectedText = "Contact Center 0251 - 8318 456";
        softAssertion.assertEquals(expectedText, actualText, "Not Appear From Login Page");
        System.out.println(actualText);

        page.close();
        softAssertion.assertAll();


    }
}
