package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features/TaskManagemenEndtoEndFlow.feature",
glue = "Stepdefinitions",
        //dryRun = true,
        monochrome = true,
        plugin = {"pretty","html:test-output/index.html"},
        tags = "@Sanity"
)
public class Runner {

}
