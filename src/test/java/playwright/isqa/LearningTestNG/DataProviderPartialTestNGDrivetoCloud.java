package playwright.isqa.LearningTestNG;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.util.regex.Pattern;

/*
* ---
* --- Whats is Dataprovider And How to use it in TestNG ---
* 1. What is Data Provider? Why we need to use it in TestNG
* 2. How to use the Dataprovider?
* 3, Whats happen if we dont prvide a name to DataProvider
* */


public class DataProviderPartialTestNGDrivetoCloud {
    public static Page page;

    @Test()
    public static void testNotMain() throws Exception {
        // create playwright and browser instances
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("myvideos/")).setRecordVideoSize(640, 480));
        page = context.newPage();

        //navigate to application
        page.navigate("http://idwidmswebd01.mfcgd.com:8080/poc-edb/");
        page.getByText("You are running a demo version. Session will close in 15 minutes.Close").press("Enter");
        page.getByRole(AriaRole.TEXTBOX).nth(3).fill("meliana");
        page.locator("input[type=\"password\"]").click();
        page.locator("input[type=\"password\"]").click();
        page.locator("input[type=\"password\"]").fill("ManulifeUser#2024");
        page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Logon$"))).click();
        page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^CAS-02007: Your last log in was AUG 23, 2024; 03:08$"))).nth(2).press("Enter");
        page.locator("[id=\"CLIENT_CONNECT\\.PAIR\\.CODE\\.0\"]").getByRole(AriaRole.TEXTBOX).fill("8946");
        page.locator("[id=\"CLIENT_CONNECT\\.PAIR\\.OK_BUTTON\\.0\"]").click();
        page.locator("[id=\"CLIENT_CONNECT\\.PAIR\\.OK_BUTTON\\.0\"]").press("Enter");
        page.keyboard().press("Enter");

        page.locator("[id=\"WORKBENCH\\.BK_CONTROL\\.LAST_POLICY\\.0\"]").getByRole(AriaRole.TEXTBOX).fill("1000469955");
        page.getByText("Financial Activities").click();
        page.locator("rf-menu-item").filter(new Locator.FilterOptions().setHasText("Bulk Payment")).click();




        System.out.println();

    }

    @DataProvider
    public String[] dp1(){
        String[] data= new String[]{
                "Test",
                "Contact",
                "Smits"
        };
        return data;
    }
}
