package stepdefinitions;

//import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		glue = { "stepdefinitions" }, 
		plugin = {},
		features={"@target/rerun.txt","classpath:features"})
        //features={"@target/rerun.txt","classpath:features/QuizMe.feature"})
		//features={"@target/rerun.txt","classpath:features/Failure.feature"})
public class RunCucumberTestRerun extends AbstractTestNGCucumberTests {
}

//to run tests with a tag:
//mvn clean test -Dcucumber.filter.tags="@exampleFeature"

