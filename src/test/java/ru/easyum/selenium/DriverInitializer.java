package ru.easyum.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        System.setProperty("webdriver.chrome.driver", getClass().getResource("/chromedriver.exe").getPath());
        driver = new ChromeDriver();
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
