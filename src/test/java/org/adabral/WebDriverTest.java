package org.adabral;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class WebDriverTest {
    @Test
    public void navigateToChrome(){
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.msn.com");
    }
    @Test
    public void navigateToFireFox(){
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://duckduckgo.com/");
    }
}
