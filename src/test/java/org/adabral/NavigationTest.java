package org.adabral;

import org.adabral.util.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NavigationTest {
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
    public void navigateToChrome(){
        driver.get("https://www.msn.com");
    }
    @Test
    public void navigateToFireFox(){
        driver.get("https://duckduckgo.com/");
    }
}
