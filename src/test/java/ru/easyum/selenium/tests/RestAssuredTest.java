package ru.easyum.selenium.tests;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;

/**
 * Rest-Assured tests
 */
public class RestAssuredTest {

    private static final Logger logger = LoggerFactory.getLogger(Lesson6Test.class);

    @Test
    public void getCountry() {
        get("https://restcountries.eu/rest/v2/capital/Moscow")
                .then().body("nativeName", hasItems("Россия"));
    }

    @Test
    public void googleSearch() {
        Response response = get("https://www.google.com/search?q=rest-assured");
        response.then().assertThat().statusCode(200);
        InputStream is = response.asInputStream();
        XmlPath path = new XmlPath(XmlPath.CompatibilityMode.HTML, is);
        logger.info(path.getString("html.head.body"));
    }

    @Test
    public void mailAuthentication() {
        given().auth().preemptive().basic("lubajnka@mail.ru", "123456")
                .when().get("https://mail.ru/auth.mail.ru/cgi-bin/auth?from=splash")
                .then().statusCode(200);
    }
}
