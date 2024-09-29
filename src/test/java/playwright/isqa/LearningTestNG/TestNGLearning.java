package playwright.isqa.LearningTestNG;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;


public class TestNGLearning {
    private static Locator canvas;
    public static Page page;

    public static void main(String[] args) throws InterruptedException {
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
    }
}
