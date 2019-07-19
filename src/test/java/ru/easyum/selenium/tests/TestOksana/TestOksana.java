package ru.easyum.selenium.tests.TestOksana;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.easyum.selenium.DriverInitializer;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestOksana {

    @BeforeClass
    public static void before() {
    }

    @Test
    public void searchGoogle () throws InterruptedException {
        // Создаем экземпляр WebDriver
        // Следует отметить что скрипт работает с интерфейсом,
        // а не с реализацией.
        WebDriver driver = DriverInitializer.getInstance().getDriver();

        // Открываем гугл, используя драйвер
        driver.get("http://www.google.com");
        // По-другому это можно сделать так:
        // driver.navigate().to("http://www.google.com");

        // Находим элемент по атрибуту name
        WebElement element = driver.findElement(By.name("q"));

        // Вводим текст
        element.sendKeys("Wikipedia");

        // Отправляем форму, при этом дравер сам определит как отправить форму по элементу
        element.submit();

        // Проверяем тайтл страницы
        System.out.println("Page title is: " + driver.getTitle());
        Thread.sleep(3000);

        // Ищем первую строку в поисковике
        List<WebElement> findElements = driver.findElements(By.partialLinkText("Википедия — свободная энциклопедия"));

        if (!findElements.isEmpty()) {
            findElements.get(0).click();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        /*(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.linkText("Википедия — свободная энциклопедия")) != null;
            }
        });*/
        // Ожидаем увидеть: "Wikipedia - поиск в Google"
        System.out.println("Page title is: " + driver.getTitle());
    }



    @AfterClass
    public static void after() {
        DriverInitializer.getInstance().getDriver().quit();
    }
}
