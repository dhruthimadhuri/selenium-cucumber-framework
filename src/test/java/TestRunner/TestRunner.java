package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/product.feature",
        glue = {"StepDefinitions","ApplicationHooks"},
        plugin = {"pretty", "html:target/cucumber-report.html",
        		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true
       // tags = "@smoke"
)

public class TestRunner extends AbstractTestNGCucumberTests {
	

}


