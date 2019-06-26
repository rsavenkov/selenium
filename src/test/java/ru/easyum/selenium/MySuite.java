package ru.easyum.selenium;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ru.easyum.selenium.tests.MyFirstTest;
import ru.easyum.selenium.tests.MySecondTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    MyFirstTest.class,
 //   MySecondTest.class,
})
public class MySuite {
}
