package ru.easyum.selenium;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Driver initializer designed as singleton
 */
public class DriverInitializer {

    private static final Logger logger = LoggerFactory.getLogger(DriverInitializer.class);
    private static DriverInitializer instance;
    private WebDriver driver;

    private DriverInitializer() {
        String browser = System.getProperty("browser") != null ? System.getProperty("browser") : "chrome";
        Capabilities capabilities = null;
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", getClass().getResource("/chromedriver.exe").getPath());
                capabilities = DesiredCapabilities.chrome();
                driver = new ChromeDriver(capabilities);
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", getClass().getResource("/geckodriver.exe").getPath());
                capabilities = DesiredCapabilities.firefox();
                driver = new FirefoxDriver(capabilities);
                break;
            case "ie":
                System.setProperty("webdriver.ie.driver", getClass().getResource("/IEDriverServer.exe").getPath());
                driver = new InternetExplorerDriver();
                break;
            default:
                logger.error(String.format("Unknow browser option %s!", browser));
                throw new RuntimeException(String.format("Unknow browser option %s!", browser));
        }
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        driver.manage().window().maximize();
        logger.debug("Driver is successfully initialized!");
    }

    public static DriverInitializer getInstance() {
        if (instance == null) {
            instance = new DriverInitializer();
        }
        return instance;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
