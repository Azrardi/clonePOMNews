package playwright.isqa.LearningTestNG;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;

/*
* ---
* --- Inegration of Exel With Dataprovider ---
* Libraries available for reading rhe data from Exel File ( Apache POI, JXL )
* Downloading and Installation of Apachec POI Java Library
* How to Read the data from exel file dynamically?
* Hown to create the dataprovider by reading the data from exel file?
* How to maintain the dataprovider in a sperate class?
*
* Exel File -> xls,xlsx
* */


public class DataProviderOnExel {

    @DataProvider(parallel = true)
    public String[][] getData() throws Exception {
        //Open Exel
        File exelFile = new File("src/test/resources/exelSourcerTest.xlsx");

        //Check Value true Exel -> true
        //System.out.println(exelFile.exists());

        FileInputStream fis = new FileInputStream(exelFile);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        //System.out.println(sheet.getPhysicalNumberOfRows());
        int noOfRows = sheet.getPhysicalNumberOfRows();
        int noOfColumns = sheet.getRow(0).getLastCellNum();

        String[][] data = new String[noOfRows-1][noOfColumns];

        for (int i = 0; i < noOfRows-1 ; i++){
            for (int j=0; j< noOfColumns; j++){
                DataFormatter df = new DataFormatter();
                data[i][j] = df.formatCellValue(sheet.getRow(i+1).getCell(j));
            }
        }
        workbook.close();
        fis.close();
//        for (String[] dataArr : data){
//            System.out.println(Arrays.toString(dataArr));
//        }
        return data;

//        @DataProvider(parallel = true)
//        public Iterator<String> getData() throws Exception {
//            List<String> dataInput = new LinkedList<>();
//            Iterator<String> returIterator = null;
//            //Open Exel
//            File exelFile = new File("src/test/resources/exelSourcerTest.xlsx");
//
//            //Check Value true Exel -> true
//            //System.out.println(exelFile.exists());
//
//            dataInput.add("value1");
//            dataInput.add("value2");
//            dataInput.add("value3");
//
//
//            FileInputStream fis = new FileInputStream(exelFile);
//            XSSFWorkbook workbook = new XSSFWorkbook(fis);
//            XSSFSheet sheet = workbook.getSheet("Sheet1");
//            //System.out.println(sheet.getPhysicalNumberOfRows());
//            int noOfRows = sheet.getPhysicalNumberOfRows();
//            int noOfColumns = sheet.getRow(0).getLastCellNum();
//
//            String[][] data = new String[noOfRows-1][noOfColumns];
//
//            for (int i = 0; i < noOfRows-1 ; i++){
//                for (int j=0; j< noOfColumns; j++){
//                    DataFormatter df = new DataFormatter();
//                    data[i][j] = df.formatCellValue(sheet.getRow(i+1).getCell(j));
//                }
//            }
//            workbook.close();
//            fis.close();
////        for (String[] dataArr : data){
////            System.out.println(Arrays.toString(dataArr));
////        }
//
//            returIterator = dataInput.iterator();
//            return returIterator;





//        // create playwright and browser instances
//        Playwright playwright = Playwright.create();
//        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("myvideos/")).setRecordVideoSize(640, 480));
//        page = context.newPage();
//
//        //navigate to application
//        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//        page.getByPlaceholder("Username").fill(userName);
//        page.getByPlaceholder("Password").fill(password);
//        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
//
////        String actualText = page.textContent("//h6[normalize-space()='Dashboard']");
////        System.out.println(actualText);
//
//        String expectedTitle = "Dashboard";
//        String actualTitle = page.textContent("//h6[normalize-space()='Dashboard']");
//        Assert.assertEquals(expectedTitle, actualTitle, "Not Verify Assertion");
//
////        Assert.assertTrue(Boolean.parseBoolean("Dashboard"), actualText.);
//        //String expectedText = "Contact Center 0251 - 8318 456";
////        String expectedText = "Contact Center 0251 - 8318 456";
////        page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Dashboard")).click();
////        login("admin123","passwordnew");
////        login("admin123","password2");
////        login("admin123","password");
//
////    public void login(String userName, String password){
////        Playwright playwright = Playwright.create();
////        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
////        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("myvideos/")).setRecordVideoSize(640, 480));
////        page = context.newPage();
////
////        //navigate to application
////        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
////        page.getByPlaceholder("Username").fill("Admin");
////        page.getByPlaceholder("Password").fill("admin123");
////        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
////
////        String actualText = page.textContent("//input[@placeholder='Search']");
////        System.out.println(actualText);
//        page.close();

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
