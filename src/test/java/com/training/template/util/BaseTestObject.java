package com.training.template.util;

import com.training.template.constants.Constants;
import com.training.template.enums.Browser;
import com.training.template.listeners.TestListener;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import java.net.URL;
import java.time.Duration;
import java.util.TreeMap;

@Listeners(TestListener.class)
public abstract class BaseTestObject {

    public static WebDriver driver;
    public static TreeMap<String, String> testData = null;
    public static final String ENVIRONMENT;
    public static final Browser BROWSER;
    protected Logger log = Logger.getLogger(BaseTestObject.class);

    static {
        Config.setConfigFilePath(Constants.DEFAULT_CONFIG_LOCATION);
        DOMConfigurator.configure(Config.getProperty("logFileOutputPath"));
        ENVIRONMENT = (System.getProperty("environment") == null)? Config.getProperty("environment") : System.getProperty("environment");
        BROWSER = Browser.valueOf(System.getProperty("browser").toUpperCase());
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void refreshPage() {
        getDriver().navigate().refresh();
    }

    @BeforeSuite
    public void loadEnvironmentData() throws Exception {

        try {
            String path = "/testdata/" + ENVIRONMENT.toLowerCase() + "_data.properties";
            log.info("Loading environment data from " + path);
            testData = new LoadDataProperties().getWebDataMapping(path);

        } catch (Exception e) {
            throw new Exception("Failed : getWebDataMapping()" + e.getLocalizedMessage());
        }
    }

    @BeforeTest
    public void createBrowser() throws Exception {

        try {
            log.info("Creating browser");
            setDriver(BROWSER);
            log.info("Driver was set");
            WebObject.setDriver(driver);

            // Timeouts
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(Config.getProperty("implicitWait"))));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(Config.getProperty("pageLoadTimeout"))));
            driver.manage().window().maximize();
            log.info("Browser was created");

        } catch (Exception e) {
            throw new Exception("Failed : createBrowser()" + e.getLocalizedMessage());
        }
    }

    @AfterTest
    public void closeBrowser() throws Exception {

        try {
            log.info("closing browser");
            if (driver != null) driver.quit();

        } catch (Exception e) {
            throw new Exception("Failed : closeBrowser()" + e.getLocalizedMessage());
        }
    }

    private void setDriver(Browser browser) throws Exception {

        try {
            log.info("Setting web driver");
            switch (browser) {
                case CHROME -> driver = new ChromeDriver();
                case FIREFOX -> driver = new FirefoxDriver();
            }

        } catch (Exception e) {
            throw new Exception("Failed : setDriver()" + e.getLocalizedMessage());
        }
    }
}
