package ru.easyum.selenium.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import ru.easyum.selenium.DriverInitializer;

/**
 * Base test with common resources
 */
public class BaseTest {

    protected WebDriver driver = DriverInitializer.getInstance().getDriver();
    protected JavascriptExecutor js = (JavascriptExecutor) driver;

}
