package posmy.interview.qa.cucumberTests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features= "features",glue="posmy.interview.qa.glue")
public class TestRunner {

}
