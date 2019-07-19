package ru.easyum.selenium.tests.TestOksana;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.easyum.selenium.DriverInitializer;

import java.util.ArrayList;
import java.util.List;

public class Lesson3 {

    private WebDriver driver;
    private JavascriptExecutor js;
    private static final Logger logger = LoggerFactory.getLogger(Lesson3.class);

    @Before
    public void before() {
        WebDriver driver = DriverInitializer.getInstance().getDriver();
        js = (JavascriptExecutor) driver;
    }

    @Test
    public void javaScript1() throws InterruptedException {

        logger.info("Using javaScript-1");
        driver.get("C:\\testProject\\src\\test\\resources\\test.html");
        Thread.sleep(2000);
        List<WebElement> elements = (ArrayList<WebElement>) ((JavascriptExecutor)driver).executeScript("return $('div')");
        js.executeScript("arguments[0].setAttribute('style', 'background-color: blue');" +
                "arguments[1].setAttribute('style', 'background-color: red');", elements.get(0), elements.get(1));
        Thread.sleep(2000);
    }

    @Test
    public void javaScript2() throws InterruptedException {
        WebDriver driver = DriverInitializer.getInstance().getDriver();
        logger.info("Using javaScript-2");
        driver.get("https://www.seleniumhq.org/");
        Thread.sleep(2000);
        js.executeScript("var ps = document.getElementsByTagName('p');" +
                "for (var i = 0; i < ps.length; i++) {" +
                "   ps[i].setAttribute('style', 'font-size: 14px')" +
                "}");
        Thread.sleep(2000);
    }

    @After
    public void after() {
        DriverInitializer.getInstance().getDriver().quit();
    }
}
