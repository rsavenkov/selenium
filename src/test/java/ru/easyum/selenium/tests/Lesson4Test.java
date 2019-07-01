package ru.easyum.selenium.tests;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Get values, filling form, popups and etc.
 */
public class Lesson4Test extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(Lesson4Test.class);

    @Test
    public void gettingTextValues() throws InterruptedException {
        logger.info("Getting text values");
        driver.get("https://www.seleniumhq.org/");
        WebElement h2 = driver.findElement(By.xpath("//div[@id='mainContent']/h2"));
        String value = h2.getText();
        driver.findElement(By.id("q")).sendKeys(value);
        driver.findElement(By.id("submit")).click();
        Thread.sleep(3000);
    }

    @Test
    public void fillingForms() throws InterruptedException {
        logger.info("Filling forms");
        driver.get("C:\\Users\\Ruslan\\Projects\\selenium\\selenium\\trunk\\src\\test\\resources\\form.html");
        driver.findElement(By.id("email")).sendKeys("email@email.ru");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("country")).sendKeys("Russia");
        driver.findElement(By.id("city")).sendKeys("Moscow");
        Thread.sleep(3000);
        WebElement select = driver.findElement(By.id("sex"));
        List<WebElement> options = select.findElements(By.tagName("option"));
        for (WebElement option : options) {
            if (option.getText().equals("Male")) {
                option.click();
            }
        }
        Thread.sleep(3000);
        Select select1 = new Select(driver.findElement(By.tagName("select")));
        select1.selectByVisibleText("Female");
        driver.findElement(By.id("gridCheck")).click();
        Thread.sleep(3000);
    }

    @Test
    public void movingBetweenWindowsAndFrames() throws InterruptedException {
        logger.info("moving between windows and frames");
        driver.get("https://ya.ru/");
        driver.findElement(By.id("text")).sendKeys("selenium");
        driver.findElement(By.className("search2__button")).findElement(By.tagName("button")).click();
        Thread.sleep(3000);
        driver.findElement(By.tagName("ul")).findElement(By.tagName("li")).findElement(By.tagName("a")).click();
        List<String> handlers = new ArrayList<>();
        for (String handle : driver.getWindowHandles()) {
            logger.info(handle);
            handlers.add(handle);
        }
        handlers.addAll(handlers);
        handlers.addAll(handlers);
        for (String handle: handlers) {
            driver.switchTo().window(handle);
            Thread.sleep(1000);
        }
    }

    @Test
    public void popup() throws InterruptedException {
        logger.info("popup");
        driver.get("C:\\Users\\Ruslan\\Projects\\selenium\\selenium\\trunk\\src\\test\\resources\\alert.html");
        driver.findElement(By.id("modal-button")).click();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        logger.info(alert.getText());
        alert.accept();
        Thread.sleep(2000);
    }

    @Test
    public void historyAndLocation() throws InterruptedException {
        logger.info("history and location");
        driver.navigate().to("https://ya.ru/");
        Thread.sleep(1000);
        driver.navigate().to("https://www.google.com/");
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);
        driver.navigate().forward();
        Thread.sleep(3000);
    }

    @Test
    public void cookies() throws InterruptedException {
        logger.info("cookies");
        driver.get("http://www.example.com");

        Cookie cookie = new Cookie("key", "value");
        driver.manage().addCookie(cookie);

        Set<Cookie> allCookies = driver.manage().getCookies();
        for (Cookie loadedCookie : allCookies) {
            logger.info(String.format("%s -> %s", loadedCookie.getName(), loadedCookie.getValue()));
        }

        driver.manage().deleteCookieNamed("CookieName");
        driver.manage().deleteAllCookies();
    }

    @Test
    public void gragAndDrop() throws InterruptedException {
        logger.info("grag and drop");
        driver.get("C:\\Users\\Ruslan\\Projects\\selenium\\selenium" +
                "\\trunk\\src\\test\\resources\\dragAndDrop.html");
        WebElement drag = driver.findElement(By.id("drag"));
        WebElement drop = driver.findElement(By.id("drop"));
        Thread.sleep(3000);
//        (new Actions(driver)).dragAndDrop(drag, drop).build().perform();
        new Actions(driver).clickAndHold(drag).moveToElement(drop).release().build().perform();
        Thread.sleep(3000);
    }

    @After
    public void after() {
        driver.quit();
    }
}
