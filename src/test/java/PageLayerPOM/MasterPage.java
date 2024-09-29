//package PageLayerPOM;
//
//import com.microsoft.playwright.Page;
//
//public class MasterPage {
//    private Page page;
//
//    //1. String Locators - OR ( Obeject Repository)
//    private String search = "//input[@placeholder='Search']";
//    private String searchIcon = "//button[@class='btn btn-default btn-lg']";
//    private String searchPageHeader = "div#content h1";
//
//
//    //2. Page Contructur
//    public MasterPage(Page page){
//        this.page = page;
//    }
//    //3. page action/ Method:
//    public String getHomePagetitle(){
//        String title = page.title();
//        System.out.println("Page title: " + title);
//        return title;
//    }
//}
