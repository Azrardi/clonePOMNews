package playwright.isqa.LearningTestNG;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/*
* ---
* --- WParameter of Test Method and Return Types Of Dataprovider ---
* Is it Mandatory to retrun Obeject[][] from Data Provider?
* What are the return types of data provider
* How do we scpecify the parametesrs in method ssignature of a test method?
*
* Obejct [] ( Single dimensional Array)
* Obejct[][]( Multiple dimensional Array0
* Iterator <Object>
* Iterator<Object[]>
* */


public class ParameterAndReturnDataProviderTestNG {
    private static Locator canvas;
    public static Page page;

    @Test(dataProvider = "dp1")
    public static void testNotMain(String s) {
        System.out.println(s);

    }
    @Test(dataProvider = "dp2")
    public static void testInteger(Integer s) {
        System.out.println(s);

    }
    @Test(dataProvider = "dp3")
    public static void TestObject(Object s) {
        System.out.println(s);

    }
    @Test(dataProvider = "dp4")
    public static void TestLogin(String userName, String password) throws Exception {

    }

    //Strinh[] - String, String, String
    @DataProvider
    public String[] dp1() {
        String[] data = new String[]{
                "abc",
                "def",
                "Pqr"
        };

        return data;
    }

    //Integer[] - integer, Integer, Integer
    @DataProvider
    public Integer[] dp2() {
        Integer[] data = new Integer[]{
               1, 2, 3
        };

        return data;
    }
    @DataProvider
    public Object[] dp3() {
        Object[] data = new Object[]{
               1,
                "Hello",
                3
        };

        return data;
    }
    @DataProvider
    public String [][] dp4() {
        String[][] data = new String[][]{
                {"abc", "asd"},
                {"def", "ASd"}
        };
        return data;
    }
}
