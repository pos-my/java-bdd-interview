package posmy.interview.qa;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import io.cucumber.junit.platform.engine.Cucumber;

import org.junit.runner.RunWith;

/**
 * Hello world!
 *
 */
@CucumberOptions(snippets = SnippetType.CAMELCASE,
        features="src/test/java/posmy/interview/qa/Features/SearchForCovidCases.feature",
        plugin = {"pretty", "html:target/cucumber"})
class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

}
