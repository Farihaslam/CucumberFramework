package TestRun;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/Features",glue= "StepDefinition",monochrome = true,tags = "@Smoketest",
plugin = {"html:target/HtmlReports/index.html",
		  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		  "rerun:target/failed_scenarios.txt"})
public class TestRunner extends AbstractTestNGCucumberTests {

}
