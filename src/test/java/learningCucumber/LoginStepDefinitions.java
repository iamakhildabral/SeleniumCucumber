package learningCucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginStepDefinitions {
    private WebDriver driver;

    public final static String SITE = "https://www.saucedemo.com/v1/";

    @Before
    public void setup(){
        driver = DriverFactory.createDriver(DriverFactory.BrowserType.CHROME);
    }

    @After
    public void tearDown(){
        if(driver!= null){
            driver.quit();
        }
    }

    @Given("User is on Login Page")
    public void user_in_on_login_page(){
        driver.get(SITE);
    }


    @When("User enter valid username")
    public void user_enter_username(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @When("User enter valid password")
    public void user_enter_valid_password() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }
    @When("User click on Login button")
    public void user_click_on_login_button() {
        driver.findElement(By.id("login-button")).click();
    }
    @Then("User navigate to homepage")
    public void user_navigate_to_homepage() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.urlContains("inventory.html"));

        Assert.assertTrue(driver.getCurrentUrl().contains("/inventory"), "url does not contain the inventory");
    }


    @When("User click on Menu Button")
    public void user_click_on_menu_button() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath(".//button[text()='Open Menu']")).click();
    }

    @When("User click on Logout Button")
    public void user_click_on_logout_button() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath(".//a[text()='Logout']")).click();
    }

    @Then("User sees Login Page")
    public void user_sees_login_page() {
        // Write code here that turns the phrase above into concrete actions
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.isDisplayed();
        loginButton.isEnabled();

    }


}
