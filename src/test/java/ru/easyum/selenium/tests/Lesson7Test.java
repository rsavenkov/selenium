package ru.easyum.selenium.tests;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Selenium RC call with legacy api
 */
public class Lesson7Test {

    private static final Logger logger = LoggerFactory.getLogger(Lesson7Test.class);

    private Selenium selenium;

    @Before
    public void bofore() {
        selenium = new DefaultSelenium("localhost", 4444,"*firefox", "http://www.google.com/");
        selenium.start();
    }

    @Test
    public void googleSearch() {
        selenium.open("http://www.google.com");
        selenium.type("q", "selenium rc");
        selenium.click("btnG");
        selenium.waitForPageToLoad("30000");
    }

    @After
    public void after() {
        selenium.stop();
    }

}
