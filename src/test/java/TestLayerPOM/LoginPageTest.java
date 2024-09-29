package TestLayerPOM;

import ConstansPOM.AppConstants;
import UtilsBasePOM.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test(priority = 1, enabled = true)
    public void LoginPageNavigationTest() throws Exception {
        loginPage = homePage.navigateToLogin();
        String actLoginPageTitle = loginPage.getLoginPageTitle();
        System.out.println("Page Title: " + actLoginPageTitle);
        Assert.assertEquals(actLoginPageTitle, AppConstants.HOME_PAGE_TITLE);
    }
    @Test (priority = 2, description = "New Description")
    public void forgotPassTest(){
        Assert.assertTrue(loginPage.isForgotPwdLinkExist());
    }
    @Test(priority = 3)
    public void appLoginTest() throws Exception {
        Assert.assertTrue(loginPage.doLogin(prop.getProperty("email").trim(),
                prop.getProperty("password").trim() ));
    }


}
