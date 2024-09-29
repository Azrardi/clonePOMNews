//package PageLayerPOM;
//
//import com.microsoft.playwright.Page;
//import com.microsoft.playwright.options.AriaRole;
//
//public class LoginPageLayer {
//    private Page page;
//
//    //1. String Locators - OR ( Obeject Repository)
//    private String inputEmailLogin = "//input[@id='input-email']";
//    private String searchIcon = "//input[@id='input-password']";
//    private String LoginBtn = "//input[@value='Login']";
//
//    private String LogoutBtn= "Logout";
//    private String ContinouBtn= "Continue";
//
//
//    //2. Page Contructur
//    public LoginPageLayer(Page page){
//        this.page = page;
//    }
//    //3. page action/ Method:
//    public String getHomePagetitle(){
//        String title = page.title();
//        System.out.println("Page title: " + title);
//        return title;
//    }
//    public String doLoginUser(String appUserName, String appPassword){
//        System.out.println("App creds: " + appUserName + ":" + appPassword);
//        page.fill(inputEmailLogin, appUserName);
//        page.fill(inputEmailLogin, appPassword);
//        page.click(LoginBtn);
//        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(LogoutBtn)).click();
//        return null;
//    }
//}
