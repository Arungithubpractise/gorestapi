package TestcaseRunner;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/java/Features",
                 glue = { "Stepdefinitions" }, 
                 publish = true, 
                 plugin = { "pretty" , "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" })

public class TestRunner {
//tags= {"@DeletePlace"}  compile test verify
}
