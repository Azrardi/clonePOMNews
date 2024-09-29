package playwright.isqa.LearningTestNG;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;

import java.nio.file.Paths;


public class TestNGLerningNew {
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
        page.close();
    }

    @Test
    public static void testParalel() throws Exception{
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("myvideos/")).setRecordVideoSize(640, 480));
        page = context.newPage();

        //navigate to application
        page.navigate("https://www.facebook.com/login/?next=https%3A%2F%2Fwww.facebook.com%2F/");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Forgotten account?")).click();
        page.getByPlaceholder("Email address or mobile number").fill("cobadulu@gmail.com");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search")).click();
        page.locator("#login_form").getByText("You must log in to continue.");
    }
}
