package playwright.isqa.LearningTestNG;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Paths;

/*
* What us meant by anssertion By TESTNG
* How To perform the assertions?
* assertEquals
* assertNotEquals
* assertTrue
* assertFalse
* assertNull
* assertNotNull
* */


public class AssetionsInTestNG {
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
        String expectedTitle = "Rumah Sakit Azra1";
        String actualTitle = page.title();
        System.out.println(page.title());
        Assert.assertEquals(expectedTitle, actualTitle, "Not Verify Assertion");
        page.close();
    }
}
