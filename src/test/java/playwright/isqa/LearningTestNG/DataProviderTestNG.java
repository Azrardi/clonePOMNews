package playwright.isqa.LearningTestNG;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.nio.file.Paths;

/*
* ---
* --- Whats is Dataprovider And How to use it in TestNG ---
* 1. What is Data Provider? Why we need to use it in TestNG
* 2. How to use the Dataprovider?
* 3, Whats happen if we dont prvide a name to DataProvider
* */


public class DataProviderTestNG {
    private static Locator canvas;
    public static Page page;

    @Test(dataProvider = "loginData")
    public static void testNotMain(String userName, String password) {
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

//        String actualText = page.textContent("//h6[normalize-space()='Dashboard']");
//        System.out.println(actualText);

        String expectedTitle = "Dashboard";
        String actualTitle = page.textContent("//h6[normalize-space()='Dashboard']");
        Assert.assertEquals(expectedTitle, actualTitle, "Not Verify Assertion");

//        Assert.assertTrue(Boolean.parseBoolean("Dashboard"), actualText.);
        //String expectedText = "Contact Center 0251 - 8318 456";
//        String expectedText = "Contact Center 0251 - 8318 456";
//        page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Dashboard")).click();
//        login("admin123","passwordnew");
//        login("admin123","password2");
//        login("admin123","password");

//    public void login(String userName, String password){
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
        page.close();

    }
        @DataProvider
        public Object[][] loginData() {
            Object[][] data = new Object[2][2];
            data[0][0] = "admin";
            data[0][1] = "admin123";

            data[1][0] ="Admin";
            data[1][1]="test123";

            return data;
        }

}
