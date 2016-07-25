package utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.data.PropertiesHolder;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * A Singlenton container for WebDriver object.
 * Initialize driver depending on selected browser
 */
public class Browser {

    private static final Logger logger = LoggerFactory.getLogger(Browser.class);
    private static Browser browser;
    private static WebDriver driver;

    private Browser(){
        Properties properties = PropertiesHolder.getProperties();
        String browserToUse = properties.getProperty("browser");

        switch (browserToUse) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("profile.default_content_setting_values.notifications", 2);
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", prefs);
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "ie":
                System.setProperty("webdriver.ie.driver", "drivers/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                break;
            default:
                //if the browser property was not set
                driver = new FirefoxDriver();
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(properties.getProperty("baseURL"));

        Dimension dimension = new Dimension(1920, 1200);
        driver.manage().window().setSize(dimension);
    }

    public static Browser getBrowser() {
        if (null == browser){
            logger.info("Initializing new browser.");
            browser = new Browser();
        }
        return browser;
    }

    /**
     * Gets the "driver" object. Not the best idea to expose WebDriver object here, but need this to illustrate how PageFactory pattern works.
     *
     * @return the "driver" object.
     */
    public static WebDriver getDriver() {
        return driver;
    }

    /**
     * Gets title of the current page.
     *
     * @return title of the current page.
     */
    public static String getPageTitle(){
        return driver.getTitle();
    }

    /**
     * Gets URL of the current page.
     *
     * @return URL of the current page.
     */
    public static String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    /**
     * Close the browser.
     *
     */
    public static void quit() {
        logger.info("Closing the browser.");
        getDriver().quit();
    }
}
