package posmy.interview.qa.glue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import posmy.interview.qa.pages.GoogleLandingPage;
import posmy.interview.qa.pages.NewsPage;
import posmy.interview.qa.pages.ResultPage;
import ru.yandex.qatools.allure.annotations.Step;

import static com.google.common.truth.Truth.assertThat;

public class StepDefinition {
    @Step
    @Given("that I am on Google")
    public void open() {
        GoogleLandingPage.open();
    }

    @Step
    @Then("I want to search about {word} in Malaysia")
    public boolean iWantToSearchAboutCovid19InMalaysia(){
       new GoogleLandingPage().searchboxIsDisplayed();
       return true;
    }

    @Step
    @Then("I will key in covid {int} in Malaysia")
    public void iWillKeyInCovid19InMalaysia(String cases) {
        String COVID_19 = "covid 19 in Malaysia";
        new GoogleLandingPage()
                .setSearch(COVID_19);
    }

    @Step
    @And("click on Google Search button")
    public void andClickOnGoogleSearchButton(){
        new GoogleLandingPage().clickGoogleSearchButton();
    }

    @Step
    @Then("I will reach results page")
    public boolean iWillReachResultsPage(){
        new ResultPage().totalMatchingResultsIsDisplayed();
        return true;
    }

    @Step
    @Then("I will see Top stories section")
    public boolean iWillSeeTopStoriesSection(){
        new ResultPage().topStoriesSectionIsDisplayed();
        return true;
    }

    @Step
    @Then("I will see Common questions section")
    public void iWillSeeCommonQuestionsSection(){
       String commonQuestion = new ResultPage().getCommonQuestionHeader();
        assertThat(commonQuestion).isEqualTo("Common Questions");
    }

    @Step
    @Then("I will click on first result for Top results")
    public void iWillClickFirstResultForTopResult(){
        //Get title for first story
        String firstStory = new ResultPage().getFirstStoryTitle();
      //Click first Story
      new ResultPage().selectFirstStory();

      String headerTitle =  new NewsPage().getNewsTitle();
      assertThat(headerTitle).isEqualTo(firstStory);
    }

    @Step
    @Then("will leave Google website")
    public void andWillLeaveGoogleWebsite(){
        new NewsPage().closeBrowser();
    }
}
