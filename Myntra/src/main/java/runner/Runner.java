package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "featurefiles/Myntra.feature",
		glue={"stepdefinitions","hooks"},
		dryRun = false,
		monochrome = true,//To make it human understandable
		plugin = {"html:test-output/report.html","json:test-output/report.json"}
		//		tags = "@Invalid"
		)
public class Runner extends AbstractTestNGCucumberTests {
}
