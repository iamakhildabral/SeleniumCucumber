package org.adabral.actions;

import org.adabral.util.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

public class DoubleClick {
    private WebDriver driver;
    private static String SITE = "https://demoqa.com/buttons";

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

    @Test(testName = "Double Click and Verify Message")
    public void doubleClick(){
        driver.get(SITE);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement buttonDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//h1[text()='Buttons']")));
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight/2");
        WebElement doubleClick = driver.findElement(By.id("doubleClickBtn"));
        new Actions(driver)
                .doubleClick(doubleClick)
                .perform();
        WebElement doubelClickMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("doubleClickMessage")));
        String doubleClickMessageText = doubelClickMessage.getText();
        Assert.assertEquals(doubleClickMessageText,"You have done a double click");
    }
}
