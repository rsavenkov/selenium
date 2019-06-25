package ru.easyum.selenium.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.easyum.selenium.DriverInitializer;

/**
 * Locating UI elements
 */
public class Lesson3Test {

    private static final Logger logger = LoggerFactory.getLogger(Lesson3Test.class);
    private WebDriver driver;
    private JavascriptExecutor js;

    @Before
    public void before() {
        driver = DriverInitializer.getInstance().getDriver();
        js = (JavascriptExecutor) driver;
    }

    @Test
    public void byID() throws InterruptedException {
        logger.info("Selecting by id");
        driver.get("https://ya.ru/");
        driver.findElement(By.id("text")).sendKeys("Test");
        Thread.sleep(3000);
    }

    @Test
    public void byClassName() throws InterruptedException {
        logger.info("Selecting by class name");
        driver.get("https://ya.ru/");
        WebElement el = driver.findElement(By.className("b-table__cell"));
        js.executeScript("arguments[0].setAttribute('style', 'background-color: green')", el);
        Thread.sleep(3000);
    }

    @After
    public void after() {
        driver.quit();
    }
}
