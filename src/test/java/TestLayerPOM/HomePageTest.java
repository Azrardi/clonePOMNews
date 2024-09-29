package TestLayerPOM;

import ConstansPOM.AppConstants;
import UtilsBasePOM.BaseTest;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {


    @Test(testName="homePage")
    public void homePageTitleTest() throws Exception {
        String actualTitle = homePage.getHomePagetitle();
        Assert.assertEquals(actualTitle, AppConstants.LOGIN_PAGE_TITLE);
    }
    @Test
    public void homePageURLTest() throws Exception {
        String actualURL = homePage.getHomePageURL();
        Assert.assertEquals(actualURL,prop.getProperty("url"));
        //String actualSearch = homePage.doSearch("Macbook");
      }
    @Test(dataProvider = "getProductData")
    public void searchTest(String productName) throws Exception {
        String actualSearch = homePage.doSearch(productName);
        Assert.assertEquals(actualSearch,"Search - "+ productName);
    }

    @DataProvider
    public Object[][] getProductData(){
        return new Object[][]{
                {"Macbook"},
                {"iMac"},
                {"Samsung"}
        };
    }
}
