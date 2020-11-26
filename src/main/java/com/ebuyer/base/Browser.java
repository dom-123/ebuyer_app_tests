package com.ebuyer.base;

import com.ebuyer.config.ConfigReader;
import io.cucumber.java.Before;
import org.junit.After;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.ebuyer.base.DriverContext.driver;

public class Browser extends Base {

    private static final String CHROME_EXECUTABLE_PATH = "src//main//resources//executables//chromedriver.exe";
    private static final String FIREFOX_EXECUTABLE_PATH = "scr//main//resources//executables//geckodriver.exe";
    private static final String IE_EXECUTABLE_PATH = "src//main//resources//executables//IEDriverServer.exe";
    private static final String GLOBAL_PROPERTIES_PATH = "src//main//java//com//ebuyer//config//global.properties";

    @Before
    public static void startBrowserSession () throws IOException {

        ConfigReader.populateSettings();

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(GLOBAL_PROPERTIES_PATH);
        prop.load(fis);
        prop.getProperty("browser");

        if (prop.getProperty("browser").contains("chrome")) {
            System.setProperty("webdriver.chrome.driver", CHROME_EXECUTABLE_PATH);
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver();

        } else if (prop.getProperty("browser").contains("firefox")) {
            System.setProperty("webdriver.geckodriver", FIREFOX_EXECUTABLE_PATH);
            driver = new FirefoxDriver();

        } else if (prop.getProperty("browser").contains("ie")) {
            System.setProperty("webdriver.ie.driver", IE_EXECUTABLE_PATH);
            driver = new InternetExplorerDriver();
        }
    }

    @After
    public void closeBrowserSession () {
        driver.quit();
    }
}