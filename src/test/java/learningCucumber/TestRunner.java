package learningCucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources",
        glue = "learningCucumber",
        plugin = {"pretty","html:target/cucumber-reports"},
        monochrome = true

)

public class TestRunner extends AbstractTestNGCucumberTests{

}
