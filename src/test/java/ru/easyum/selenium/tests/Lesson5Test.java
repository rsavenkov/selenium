package ru.easyum.selenium.tests;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertNotNull;

/**
 * Explicit and implicit waits
 */
public class Lesson5Test extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(Lesson5Test.class);

    @Test
    public void threadWait() throws InterruptedException {
        logger.info("Waiting with thread sleep");
        driver.get("https://ya.ru/");
        driver.findElement(By.id("text")).sendKeys("selenium");
        driver.findElement(By.className("search2__button")).findElement(By.tagName("button")).click();
        Thread.sleep(3000);
        WebElement ul = driver.findElement(By.tagName("ul"));

        assertNotNull("Container element is null!", ul);
    }

    @Test
    public void webDriverWait() {
        logger.info("Explicit waiting with selenium WebDriverWait");
        driver.get("https://ya.ru/");
        driver.findElement(By.id("text")).sendKeys("selenium");
        driver.findElement(By.className("search2__button")).findElement(By.tagName("button")).click();

        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.tagName("ul")));

        WebElement ul = driver.findElement(By.tagName("ul"));

        assertNotNull("Container element is null!", ul);
    }

    @Test
    public void fluentWait() {
        logger.info("Explicit waiting with selenium FluentWait");

        /*Wait wait = new FluentWait(driver).withTimeout(30, SECONDS)
                .pollingEvery(5, SECONDS).ignoring(NoSuchElementException.class);


        WebElement foo = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("foo"));
            }
        });*/

    }

    @Test
    public void implicitWait() {
        logger.info("Implicit wait");

        driver.manage().timeouts().implicitlyWait(10, SECONDS);

        driver.get("https://ya.ru/");
        driver.findElement(By.id("text")).sendKeys("selenium");
        driver.findElement(By.className("search2__button")).findElement(By.tagName("button")).click();

        WebElement ul = driver.findElement(By.tagName("ul"));

        assertNotNull("Container element is null!", ul);
    }

    @Test
    public void remoteWebDriver() {
        logger.info("Selenium remote web driver");
    }

    @After
    public void after() {
        driver.quit();
    }
}
