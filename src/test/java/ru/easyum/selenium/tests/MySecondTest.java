package ru.easyum.selenium.tests;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MySecondTest {

    private static final Logger logger = LoggerFactory.getLogger(MySecondTest.class);

    @Test
    public void someTest() {
        logger.info("Second test!");
    }
}
