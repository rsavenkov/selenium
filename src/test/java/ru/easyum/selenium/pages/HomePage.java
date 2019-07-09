package ru.easyum.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Home page POM
 */
public class HomePage {

    private WebDriver driver;

    @FindBy(id = "PH_logoutLink")
    private WebElement logout;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getLogout() {
        return logout;
    }

    public LoginPage logout() {
        this.logout.click();
        return new LoginPage(driver);
    }
}
