package PlaywrightFactoryPOM;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.*;
import org.apache.commons.codec.binary.Base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

public class PLaywrightFactory {
    Playwright playwright;
    Browser browser;

    BrowserContext browserContext;

    Page page;
    Properties prop;

    private static final ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
    private static final ThreadLocal<BrowserContext> tlBrowserContext = new ThreadLocal<>();
    private static final ThreadLocal<Page> tlPage = new ThreadLocal<>();
    private static final ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();

    public static Playwright getPlaywright() {
        return tlPlaywright.get();
    }

    public static Browser getBrower() {
        return tlBrowser.get();
    }

    public static BrowserContext getBrowserContext() {
        return tlBrowserContext.get();
    }

    public static Page getPage() {
        return tlPage.get();
    }

    public static ExtentReports rep;
    //    CommonDriver commonDriver;
    private Properties env_properties;
    public static ExtentTest test;
    //    private GenLib genLib;
    public static String systemDir = System.getProperty("user.dir");

    public Page initBrowser(Properties prop) {
        String browserName = prop.getProperty("browser").trim();
        System.out.println("browser name is: " + browserName);
        //Playwright playwright = Playwright.create();
        tlPlaywright.set(Playwright.create());
        switch (browserName.toLowerCase()) {
            case "chronium":
                //browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                break;
            case "firefox":
                //browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                tlBrowser.set(getPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                break;
            case "safari":
                //browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                tlBrowser.set(getPlaywright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                break;
            case "chrome":
                //browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                //tlBrowser.set(playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false)));
                tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false)));
                break;
            default:
                System.out.println("please pass the right browser name ................");
                break;
        }
//        browserContext = browser.newContext();
//        page = browserContext.newPage();
//        page.navigate(prop.getProperty("url").trim());
//        return page;
        tlBrowserContext.set(getBrower().newContext());
        tlPage.set(getBrowserContext().newPage());
        getPage().navigate(prop.getProperty("url").trim());
        //getPage.navigate(prop.getProperty("url").trim());
        return getPage();
    }

    /**
     * This Method is used to initlalze the properties from config file
     *
     * @return
     */
    public Properties init_prop() {
        try {
            FileInputStream ip = new FileInputStream("src/test/ResourcesPOM/Propeties/config.properties");
            prop = new Properties();
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    public static String takeScreenshot() {
        //C:\Users\azrmuha\Documents\Final\playwright-example-POM-Exercise/screenshot/12345678900.png
        //C:\Users\azrmuha\Documents\Final\playwright-example-POM-Exercise\null1721725537573.png

        String systemDir = System.getProperty("user.dir");

        //String path = System.getProperty("user.dir") + "/screenshots/"+ System.currentTimeMillis()+".png";
        String path = systemDir + "/" + System.currentTimeMillis() + ".png";
        System.out.println("location : " + Paths.get(path));
        getPage().screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get(path))
                .setFullPage(true));

        System.out.println("location : " + Paths.get(path));

//        System.out.println("location : " + path);
//        getPage().screenshot(new Page.ScreenshotOptions()
//                        .setPath(Paths.get(path))
//                .setFullPage(true));
        return path;
    }

    public static ThreadLocal<BrowserContext> getTlBrowserContext() {
        return tlBrowserContext;
    }

    public static String encodeFileToBase64Binary(File file) {
        String encodedfile = null;
        try {
            FileInputStream fileInputStreamReader = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            fileInputStreamReader.read(bytes);
            encodedfile = new String(Base64.encodeBase64(bytes), "UTF-8");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return encodedfile;
    }

    public static String takeScreenshotFinal() {
        File f = new File(takeScreenshot());
        String encodstring = encodeFileToBase64Binary(f);
        System.out.println(encodstring);

        return encodstring;
    }


}
