package ru.easyum.selenium.tests;

import org.junit.After;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.easyum.selenium.pages.HomePage;
import ru.easyum.selenium.pages.LoginPage;

import static org.junit.Assert.*;

/**
 * Page object model pattern
 */
public class Lesson6Test extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(Lesson6Test.class);

    @Test
    public void invalidLoginPasswordTest() {
        driver.get("https://mail.ru/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setLogin("lubajnka@mail.ru");
        loginPage.setPassword("123456");
        loginPage.clickLogin();

        assertEquals("Неверное имя или пароль", loginPage.getErrorMessage().getText());
    }

    @Test
    public void emptyLoginPasswordTest() {
        driver.get("https://mail.ru/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setLogin("");
        loginPage.clickLogin();

        loginPage.checkEmptyLoginPasswordErrorMessage();
    }

    @Test
    public void homePageTest() {
        driver.get("https://mail.ru/");

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.successLogin();

        assertNotNull(homePage.getLogout());
    }

    @Test
    public void loginLogoutTest() {
        driver.get("https://mail.ru/");

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.successLogin();
        LoginPage loginPage1 = homePage.logout();

        assertNotNull(loginPage.getCheckIn());
    }

    @After
    public void after() {
        driver.quit();
    }
}
