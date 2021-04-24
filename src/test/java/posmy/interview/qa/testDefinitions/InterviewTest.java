package posmy.interview.qa.testDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.NoSuchSessionException;
import org.opentest4j.AssertionFailedError;
import posmy.interview.pages.GooglePage;
import posmy.interview.pages.MOHPage;
import posmy.interview.pages.SearchResultsPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class InterviewTest {
    private String searchParameter = "covid 19 in Malaysia";
    private GooglePage googlePage;
    private SearchResultsPage searchResultsPage;
    private MOHPage mohPage;

    @Given("Open Chrome and go to Google")
    public void open_chrome_and_go_to_google() {
        googlePage = GooglePage.open();
    }

    @Given("Input keywords in search field")
    public void input_keywords_in_search_field() {
        searchResultsPage = googlePage.search(searchParameter);
    }

    @When("Search results available")
    public void search_results_available() {
        assertTrue(searchResultsPage.searchResultsIsAvailable(), "No search result found");
    }

    @When("Top stories section available")
    public void top_stories_section_available() {
        assertTrue(searchResultsPage.topStoriesIsDisplayed(), "Top stories section not found");
    }

    @When("Common questions section available")
    public void common_questions_section_available() {
        assertTrue(searchResultsPage.commonQuestionsIsAvailable(), "People also ask section is not found");
    }

    @Then("Click MOH website")
    public void click_moh_website() {
        mohPage = searchResultsPage.clickMOHWebsiteLink();
    }

    @Then("Verify MOH website")
    public void verify_moh_website() {
        String currentUrl = mohPage.getCurrentUrl();
        assertTrue(currentUrl.equalsIgnoreCase(mohPage.mohUrl), "Didn't redirect to MOH Website");
    }

    @Then("Close Chrome")
    public void close_chrome() {
        googlePage.closeBrowser();
    }

    @After
    public void closeDriver() {
        // If test fails, close the browser
        try {
            googlePage.closeBrowser();
        } catch (NoSuchSessionException exception) {
            // Browser already closed. Do nothing.
        }
    }
}
