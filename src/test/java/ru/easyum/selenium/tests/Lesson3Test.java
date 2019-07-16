package ru.easyum.selenium.tests;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Locating UI elements
 */
public class Lesson3Test extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(Lesson3Test.class);

    @Test
    public void byID() throws InterruptedException {
        logger.info("Selecting by id");
        driver.get("https://ya.ru/");
        driver.findElement(By.id("text")).sendKeys("Selenium - find by id");
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

    @Test
    public void byTagName() throws InterruptedException {
        logger.info("Selecting by tag name");
        driver.get("https://www.seleniumhq.org/");
        WebElement el = driver.findElement(By.tagName("img"));
        js.executeScript("arguments[0].setAttribute('style', 'display: none')", el);
        Thread.sleep(3000);
    }

    @Test
    public void byName() throws InterruptedException {
        logger.info("Selecting by name");
        driver.get("https://ya.ru/");
        driver.findElement(By.name("text")).sendKeys("Selenium - find by name");
        Thread.sleep(3000);
    }

    @Test
    public void byLinkTextAndPartialLinkText() throws InterruptedException {
        logger.info("Selecting by link text and partial link text");
        driver.get("https://www.seleniumhq.org/");
        driver.findElement(By.linkText("Projects")).click();
        Thread.sleep(3000);
        driver.findElement(By.partialLinkText("WebDriver")).click();
        Thread.sleep(3000);
    }

    @Test
    public void byCSS() throws InterruptedException {
        logger.info("Selecting by css");
        driver.get("https://www.seleniumhq.org/");
        List<WebElement> els = driver.findElements(By.cssSelector("#mainContent p"));
        for (WebElement el : els) {
            js.executeScript("arguments[0].setAttribute('style', 'background-color: red')", el);
            Thread.sleep(1000);
        }
    }

    @Test
    public void byXPath() throws InterruptedException {
        logger.info("Selecting by XPath");
        driver.get("https://www.seleniumhq.org/");
        List<WebElement> imgs = driver.findElements(By.xpath("(//div[@id='container']/div[@id='mBody']/div[@id='mainContent']/table[@id='choice']/tbody/tr/td)[1]/center/a/img"));
        for (WebElement img : imgs) {
            js.executeScript("arguments[0].setAttribute('style', 'width: 100%')", img);
            Thread.sleep(1000);
        }
    }

    @Test
    public void javaScript1() throws InterruptedException {
        logger.info("Using javaScript-1");
        driver.get("C:\\Users\\Ruslan\\Projects\\selenium\\selenium\\trunk\\src\\test\\resources\\test.html");
        Thread.sleep(2000);
        WebElement element = (WebElement) ((JavascriptExecutor) driver).executeScript("return $('.my-class')[0]");
        js.executeScript("arguments[0].setAttribute('style', 'background-color: blue')", element);
        Thread.sleep(2000);
    }

    @Test
    public void javaScript2() throws InterruptedException {
        logger.info("Using javaScript-2");
        driver.get("https://www.seleniumhq.org/");
        Thread.sleep(2000);
        js.executeScript("var ps = document.getElementsByTagName('p');" +
                "for (var i = 0; i < ps.length; i++) {" +
                "   ps[i].setAttribute('style', 'font-size: 14px')" +
                "}");
        Thread.sleep(2000);
    }


    /*@After
    public void after() {
        driver.quit();
    }*/
}
