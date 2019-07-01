package ru.easyum.selenium.tests;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lesson2Test extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(Lesson2Test.class);

    @Test
    public void openSomeUrl() throws InterruptedException {
        logger.info("Open some url test");
        driver.get("https://www.seleniumhq.org/");
        //TODO rewrite with WebDriverWait
        Thread.sleep(3000);

        //find element by link text
        driver.findElement(By.linkText("Projects")).click();

        // Wait for the page to load, timeout after 10 seconds
        new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.xpath("(//div[@class='bigMenu']/h3/a)[1][@href='webdriver/'][contains(text(),'Selenium WebDriver')]")) != null;
            }
        });

    }

    @After
    public void after() {
        driver.quit();
    }
}
