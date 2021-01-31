package posmy.interview.qa.glue;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import posmy.interview.qa.pages.GoogleLandingPage;
import posmy.interview.qa.pages.NewsPage;
import posmy.interview.qa.pages.ResultPage;

public class StepDefinition {

    WebDriver driver;

   @Before("@browser")
    public void createDriver() {
        driver = new ChromeDriver();
    }

    @Given("that I am on Google")
    public void thatIamOnGoogle(){
        driver.get("https://www.google.com/");
    }

    @Then("I want to search about {word} in Malaysia")
    public boolean iWantToSearchAboutCovid19InMalaysia(String word){
       return new GoogleLandingPage().searchboxIsDisplayed();
    }

    @Then("I will key in covid {int} in Malaysia")
    public void iWillKeyInCovid19InMalaysia(int number) {
        String COVID_19 = "covid 19 in Malaysia";
        new GoogleLandingPage()
                .setSearch(COVID_19);
    }

    @And("click on Google Search button")
    public void andClickOnGoogleSearchButton(){
        new GoogleLandingPage().clickGoogleSearchButton();
    }

    @Then("I will reach results page")
    public void iWillReachResultsPage(){
        new ResultPage().totalMatchingResultsIsDisplayed();
    }

    @Then("I will see Top stories section")
    public void iWillSeeTopStoriesSection(){
        new ResultPage().topStoriesSectionIsDisplayed();
    }

    @Then("I will see Common questions section")
    public String iWillSeeCommonQuestionsSection(){
       return new ResultPage().getCommonQuestionHeader();
    }

    @Then("I will click on first result for Top results")
    public void iWillClickFirstResultForTopResult(){
        new ResultPage().selectFirstStory();
    }

    @And("will leave Google Website")
    public void andWillLeaveGoogleWebsite(){
        new NewsPage().closeBrowser();
    }
}
