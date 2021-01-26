
package posmy.interview.qa.TestRunner;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(snippets = SnippetType.CAMELCASE,
        features="src/test/java/posmy/interview/qa/Features/SearchForCovidCases.feature",
        plugin = {"pretty", "html:target/cucumber"})
public class Runner
{

}
