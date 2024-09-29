package PageLayerPOM;

import com.microsoft.playwright.Page;

public class HomePage {
    private Page page;

    //1. String Locators - OR ( Obeject Repository)
    private String search = "//input[@placeholder='Search']";
    private String searchIcon = "//button[@class='btn btn-default btn-lg']";
    private String searchPageHeader = "div#content h1";

    //Locator Pointer New
    private String loginBtn = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']";
    private String myAccounBtn= "//span[normalize-space()='My Account']";




//    private String clickRegisterNew = "Continue";
//    private String inputFirstName = "First Name";
//    private String inputLastName = "Last Name";
//    private String inputEmailRegist = "E-Mail";
//    private String inputPhone = "Telephone";
//    private String inputPass="Password";
//    private String inputPassConfirm ="Password Confirm";
//    private String submitRegist ="Continue";
//
//    private String inputEmailLogin = "//input[@id='input-email']";
//    private String searchIconSearch = "//input[@id='input-password']";
//    private String LoginBtn = "//input[@value='Login']";
//
//    private String LogoutBtn= "Logout";
//    private String ContinouBtn= "Continue";

    //2. Page Contructur
    public HomePage(Page page){

        this.page = page;
    }
    //3. page action/ Method:
    public String getHomePagetitle(){
        String title = page.title();
        System.out.println("Page title: " + title);
        return title;
    }
    public String getHomePageURL(){
        String url = page.url();
        System.out.println("Page URL: " + url);
        return url;
    }
    public String doSearch(String productName){
        page.fill(search,productName);
        page.click(searchIcon);
        String header = page.textContent(searchPageHeader);
        System.out.println("search header: " + header);
        return header;
    }
    public LoginPage navigateToLogin(){
        page.click(myAccounBtn);
        page.click(loginBtn);
        return new LoginPage(page);
    }
//    public String registerNewMember(){
//        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(clickRegisterNew)).click();
//        page.getByPlaceholder(inputFirstName).fill("Azra21");
//        page.getByPlaceholder(inputLastName).fill("test1");
//        page.getByPlaceholder(inputEmailRegist).fill("zr212a@gmail.com");
//        page.getByPlaceholder(inputPhone).fill("085655202969");
//        page.getByPlaceholder(inputPass, new Page.GetByPlaceholderOptions().setExact(true)).fill("test123");
//        page.getByPlaceholder(inputPassConfirm).fill("test123");
//        page.getByRole(AriaRole.CHECKBOX).check();
//        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(submitRegist)).click();
//        page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Your Account Has Been Created!")).click();
//        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(submitRegist)).click();
//        return null;
//    }
//
//    public String doLoginUserFinal(String appUserName, String appPassword) {
//        System.out.println("App creds: " + appUserName + ":" + appPassword);
//        page.fill(inputEmailLogin, "zr212a@gmail.com");
//        page.fill(inputEmailLogin, "test123");
//        page.click(LoginBtn);
//        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(LogoutBtn)).click();
//        return null;
    }
