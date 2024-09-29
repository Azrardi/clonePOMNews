package playwright.isqa.LearningTestNG;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/*
* ---
* --- Whats is Dataprovider And How to use it in TestNG ---
* 1. What is Data Provider? Why we need to use it in TestNG
* 2. How to use the Dataprovider?
* 3, Whats happen if we dont prvide a name to DataProvider
* */


public class DataProviderPartialTestNG {
    private static Locator canvas;
    public static Page page;

    @Test(dataProvider = "dp1")
    public static void testNotMain(String s) throws Exception {
//        // create playwright and browser instances
//        Playwright playwright = Playwright.create();
//        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("myvideos/")).setRecordVideoSize(640, 480));
//        page = context.newPage();
//
//        //navigate to application
//        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//        page.getByPlaceholder("Username").fill("Admin");
//        page.getByPlaceholder("Password").fill("admin123");
//        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
//
//        String actualText = page.textContent("//input[@placeholder='Search']");
//        System.out.println(actualText);
//        //String expectedText = "Contact Center 0251 - 8318 456";
////        String expectedText = "Contact Center 0251 - 8318 456";
////        page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Dashboard")).click();

        System.out.println(s);

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
