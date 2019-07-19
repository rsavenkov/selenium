package ru.easyum.selenium;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ru.easyum.selenium.tests.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        Lesson2Test.class,
        Lesson3Test.class,
      //  Lesson4Test.class,
      //  Lesson5Test.class,
      //  Lesson6Test.class,
        RestAssuredTest.class
})
public class TestSuite {

    @BeforeClass
    public static void before() {
    }

    @AfterClass
    public static void afterAllTests() {
        DriverInitializer.getInstance().getDriver().quit();
    }
}
