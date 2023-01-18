package stepdefinitions;

import org.junit.runner.RunWith;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	  plugin = {"pretty",
              "html:target/cucumber-reports/cucumber-pretty",
              "json:target/cucumber-reports/CucumberTestReport.json",
              "junit:target/cucumber-reports/CucumberTestReport.xml",
              "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
              "rerun:target/rerun.txt"},
	  dryRun = false,
	  features={"classpath:features"})
      //features={"classpath:features/QuizMe.feature"})
	  //  features={"classpath:features/Failure.feature"})
public class RunCucumberTest extends AbstractTestNGCucumberTests  {

	
}



//to run tests with a tag:
//mvn clean test -Dcucumber.filter.tags="@exampleFeature"


