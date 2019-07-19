package ru.easyum.selenium.tests.TestOksana;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.easyum.selenium.DriverInitializer;
import ru.easyum.selenium.tests.Lesson4Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Lesson4 {

    private static final Logger logger = LoggerFactory.getLogger(Lesson4Test.class);
    private WebDriver driver;
    private JavascriptExecutor js;

    @Before
    public void before() {
        driver = DriverInitializer.getInstance().getDriver();
        js = (JavascriptExecutor) driver;
    }

    @Test
    public void fillingMail() throws InterruptedException {
        driver.get("https://mail.ru/");
        WebElement registration = driver.findElement(By.id("signup"));
        registration.click();
        Thread.sleep(3000);
        WebElement div = driver.findElement(By.className("b-dropdown__list"));  //разобраться, не находит элемент
        div.click();
        List<WebElement> a = div.findElements(By.tagName("a"));
        for (WebElement i : a) {
            if(i.getText() == "25") {
                i.click();
            }
        }
        Thread.sleep(3000);
    }

    @Test
    public void betweenWindows () throws InterruptedException {
        driver.get("https://ya.ru/");
        driver.findElement(By.id("text")).sendKeys("selenium");
        driver.findElement(By.className("search2__button")).findElement(By.tagName("button")).click();
        Thread.sleep(3000);
        WebElement a = driver.findElement(By.xpath("//ul[@class='serp-list_left_yes']/li/a[position()<4]")); // дописать тест с переключением между 4 вкладками
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


    @After
    public void after() {
        driver.quit();
    }

}
