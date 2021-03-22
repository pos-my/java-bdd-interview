package posmy.interview.qa.glue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import posmy.interview.qa.pages.GoogleHomePage;
import org.testng.Assert;
import posmy.interview.qa.pages.ResultsPage;

public class StepDefinition {

    WebDriver driver;
    String mohUrl = "http://covid-19.moh.gov.my/";

    @Given("^I am on Google Search Page$")
    public void i_am_on_google_search_page() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        GoogleHomePage googleHomePage = new GoogleHomePage(driver);
        Assert.assertEquals(googleHomePage.isSearchBoxDisplayed(),true);
    }

    @When("^I search for covid 19 in Malaysia$")
    public void i_search_for_covid_19_in_malaysia() {
        GoogleHomePage googleHomePage = new GoogleHomePage(driver);
        googleHomePage.setSearch("Covid-19 in Malaysia");
    }

    @Then("^top stories section is displayed in the results page$")
    public void top_stories_section_is_displayed_in_the_results_page() {
        ResultsPage resultsPage = new ResultsPage(driver);
        Assert.assertEquals(resultsPage.isTopStoriesDisplayed(), true);
    }

    @And("^common questions section is displayed in the results page$")
    public void common_questions_section_is_displayed_in_the_results_page() {

    }

    @When("^I click on the MOH Website in the search result$")
    public void i_click_on_the_moh_website_in_the_search_result() {
        ResultsPage resultsPage = new ResultsPage(driver);
        resultsPage.selectFirstResult();
    }

    @Then("^MOH website is displayed$")
    public void moh_website_is_displayed() {
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains(mohUrl));
    }
}
