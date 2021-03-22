package posmy.interview.qa.glue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import posmy.interview.qa.cucumberTests.BaseTest;
import posmy.interview.qa.pages.GoogleHomePage;
import org.testng.Assert;
import posmy.interview.qa.pages.ResultsPage;

public class StepDefinition extends BaseTest {

    GoogleHomePage googleHomePage = GoogleHomePage.open();

    @Given("^I am on Google Search Page$")
    public void i_am_on_google_search_page() {
        Assert.assertEquals(googleHomePage.isSearchBoxDisplayed(),true);
    }

    @When("^I search for covid 19 in Malaysia$")
    public void i_search_for_covid_19_in_malaysia() {
        googleHomePage.setSearch("Covid-19 in Malaysia");
    }

    @Then("^top stories section is displayed in the results page$")
    public void top_stories_section_is_displayed_in_the_results_page() {
        Assert.assertEquals(new ResultsPage().isTopStoriesDisplayed(), true);
    }

    @And("^common questions section is displayed in the results page$")
    public void common_questions_section_is_displayed_in_the_results_page() {

    }

    @When("^I click on the MOH Website in the search result$")
    public void i_click_on_the_moh_website_in_the_search_result() {

    }

    @Then("^MOH website is displayed$")
    public void moh_website_is_displayed() {

    }
}
