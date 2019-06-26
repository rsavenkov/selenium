package ru.easyum.selenium.tests;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.easyum.selenium.DriverInitializer;

public class MyFirstTest {

    private static final Logger logger = LoggerFactory.getLogger(MyFirstTest.class);
//    private WebDriver driver;

    @BeforeClass
    public static void before() {

    }

    @Test
    public void searchGoogle () {
        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
        WebDriver driver = DriverInitializer.getInstance().getDriver();
        // And now use this to visit Google
        driver.get("http://www.google.com");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        element.sendKeys("Cheese!");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });

        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());
    }

    @Test
    public void openSomeUrl() throws InterruptedException {
       WebDriver driver = DriverInitializer.getInstance().getDriver();
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

    @AfterClass
    public static void after() {
        DriverInitializer.getInstance().getDriver().quit();
    }
}
