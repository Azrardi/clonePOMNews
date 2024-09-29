package playwright.isqa.LearningTestNG;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Paths;

/*
* ---
* --- Whats is Dataprovider And How to use it in TestNG ---
* 1. What is Data Provider? Why we need to use it in TestNG
* 2. How to use the Dataprovider?
* 3, Whats happen if we dont prvide a name to DataProvider
* */


public class  DataProviderPartialTestNGOnExel {
    private static Locator canvas;
    public static Page page;

    @Test(dataProvider = "getData", dataProviderClass = DataProviderOnExel.class)
    public static void testNotMain(String userName, String password) throws Exception {
        // create playwright and browser instances
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("myvideos/")).setRecordVideoSize(640, 480));
        page = context.newPage();

        //navigate to application
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        page.getByPlaceholder("Username").fill(userName);
        page.getByPlaceholder("Password").fill(password);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
        String expectedTitle = "Dashboard";
        String actualTitle = page.textContent("//h6[normalize-space()='Dashboard']");
        Assert.assertEquals(expectedTitle, actualTitle, "Not Verify Assertion");
        page.close();

    }
}
