package ru.easyum.selenium;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ru.easyum.selenium.tests.Lesson2Test;
import ru.easyum.selenium.tests.Lesson3Test;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    Lesson2Test.class,
    Lesson3Test.class,
})
public class MySuite {
}
