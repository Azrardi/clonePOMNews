package UtilsBasePOM;

import PageLayerPOM.HomePage;
import PageLayerPOM.LoginPage;
import PlaywrightFactoryPOM.PLaywrightFactory;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {
    PLaywrightFactory pf;
    public Page page;
    protected Properties prop;
    protected HomePage homePage;
    protected LoginPage loginPage;

    @BeforeTest
    public void setup() throws Exception {
        pf = new PLaywrightFactory();
        prop = pf.init_prop();
        page = pf.initBrowser(prop);
        homePage = new HomePage(page);

    }

    @AfterTest
    public void tearDown() throws Exception {
        //page.context().browser().close();
    }

}
