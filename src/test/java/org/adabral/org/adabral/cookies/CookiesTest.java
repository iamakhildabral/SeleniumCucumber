package org.adabral.org.adabral.cookies;

import org.adabral.util.DriverFactory;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;

public class CookiesTest {
    private String SITE = "https://www.saucedemo.com/v1/";

    private WebDriver driver;

    @BeforeTest
    void setUp(){
        driver = DriverFactory.createDriver(DriverFactory.BrowserType.CHROME);
    }
    @AfterTest
    void tearDown(){
        if (driver!=null){
            driver.quit();
        }
    }

    @Test
    public void checkCookies(){
        driver.get(SITE);
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println(cookies);

    }
}
