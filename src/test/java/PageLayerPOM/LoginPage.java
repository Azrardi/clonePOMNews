package PageLayerPOM;

import UtilsBasePOM.BaseTest;
import com.microsoft.playwright.Page;

public class LoginPage extends BaseTest {
//    private Page page;

    //1. String Locators - OR ( Obeject Repository)
    private String emailId = "//input[@id='input-email']";
    private String passId = "//input[@id='input-password']";
    private String loginBtn = "//input[@value='Login']";
    private String forgotPass = "//div[@class='form-group']//a[normalize-space()='Forgotten Password11']";
    private String logoutBtn = "//a[@class='list-group-item'][normalize-space()='Logout']";
    private String continueBtn = "//a[normalize-space()='Continue']";


    //2. Page Constructors - OR ( Obeject Repository)

    public LoginPage(Page page){
        this.page = page;
    }

    //3. Page Actions   - OR ( Obeject Repository)


    public String getLoginPageTitle(){
        return page.title();
    }
    public boolean isForgotPwdLinkExist(){
        return page.isVisible(forgotPass);
    }
    public boolean doLogin(String appUsername, String appPassword){
        System.out.println("App creds:" + appUsername + ":" + appPassword);
        page.fill(emailId, appUsername);
        page.fill(passId, appPassword);
        page.click(loginBtn);
        if(page.isVisible(logoutBtn)){
            System.out.println("user is logged in successfully...");
            page.click(logoutBtn);
            page.click(continueBtn);
            return true;
        }
        return false;
    }
}
