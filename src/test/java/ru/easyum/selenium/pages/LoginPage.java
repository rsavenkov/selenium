package ru.easyum.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

/**
 * Login page POM
 */
public class LoginPage {

    private WebDriver driver;

    @FindBy(id = "mailbox:login")
    private WebElement login;

    @FindBy(id = "mailbox:password")
    private WebElement password;

    @FindBy(id = "mailbox:submit")
    private WebElement checkIn;

    @FindBy(id = "mailbox:error")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public HomePage successLogin() {
        //TODO replace correct authorities
        login.sendKeys("my_mail@mail.ru");
        password.sendKeys("123456");
        checkIn.findElement(By.tagName("input")).click();
        return new HomePage(driver);
    }

    public void setLogin(String login) {
        this.login.sendKeys(login);
    }

    public void setPassword(String password) {
        this.password.sendKeys(password);
    }

    public WebElement getCheckIn() {
        return checkIn;
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    public void clickLogin() {
        checkIn.findElement(By.tagName("input")).click();
    }

    /**
     * Check for label of empty login or password error message
     *
     * @return
     */
    public void checkEmptyLoginPasswordErrorMessage() {
        assertEquals("Введите имя ящика и пароль", this.errorMessage.getText());
    }
}
