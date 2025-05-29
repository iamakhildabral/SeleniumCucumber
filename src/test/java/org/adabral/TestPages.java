package org.adabral;

import org.adabral.util.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class TestPages {
    private WebDriver driver;
    private static String SITE = "https://testpages.eviltester.com/styled/index.html";

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

    private static void delay() throws InterruptedException {
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            throw  new RuntimeException();
        }
    }

    @Test
    public void relativeLocators() throws InterruptedException {
        driver.get(SITE);
        WebElement basicHTMLForm = driver.findElement(By.linkText("HTML Form Example"));
        basicHTMLForm.click();
//        delay();
        WebElement username = driver.findElement(By.name("username"));
                username.sendKeys("testuserakki");
        driver.findElement(RelativeLocator.with(By.tagName("input")).below(username)).sendKeys("akkipass");

        driver.findElement(By.name("comments")).sendKeys("your very first comments");
        driver.findElement(By.cssSelector("input[value='submit']")).submit();

        // using relative for password

        Assert.assertEquals(driver.getCurrentUrl(),"https://testpages.eviltester.com/styled/the_form_processor.php");




    }
}
