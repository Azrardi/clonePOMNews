package ApachePOI;

import TestUtil.testUtil;
import com.microsoft.playwright.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

public class HalfEbdTest {
    public static Page page;
    private testUtil TestsUtils;

    @BeforeMethod
    public void setUp() {
        System.out.println("Setting up HalfEbdTest");
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("myvideos/")).setRecordVideoSize(640, 480));
        page = context.newPage();

        //navigate to application
        page.navigate("https://parabank.parasoft.com/parabank/register.htm;jsessionid=D0FC2F5FE11A06749CC36EED49B8DA01");
    }

    @Test(testName = "Azraproses" ,dataProvider ="getTestsData" )
    public void halEbayRegPage(String firstName, String lastName, String address, String state , String zipCode, String phone,
                               String ssn, String username, String password, String passwordConfirm) throws Exception {
        //enterdata
        page.locator("[id=\"customer\\.firstName\"]").fill(firstName);
        page.locator("[id=\"customer\\.lastName\"]").fill(lastName);
        page.locator("[id=\"customer\\.address\\.street\"]").fill(address);
        page.locator("[id=\"customer\\.address\\.city\"]").fill(address);
        page.locator("[id=\"customer\\.address\\.state\"]").fill(state);
        page.locator("[id=\"customer\\.address\\.zipCode\"]").fill(zipCode);
        page.locator("[id=\"customer\\.phoneNumber\"]").fill(phone);
        page.locator("[id=\"customer\\.ssn\"]").fill(ssn);
        page.locator("[id=\"customer\\.username\"]").fill(username);
        page.locator("[id=\"customer\\.password\"]").fill(password);
        page.locator("#repeatedPassword").fill(passwordConfirm);
        page.close();

    }

    @BeforeMethod
    public void tearDown() {
//        page.close();

    }

    @DataProvider ()
    public Iterator<Object[]> getTestsData(){
        ArrayList<Object[]> testData = TestsUtils.getDataFromExel();
        return testData.iterator();

    }


}
