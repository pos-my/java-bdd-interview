package posmy.interview.qa.step_defs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import posmy.interview.qa.page_objects.GoogleHomepage;
import posmy.interview.qa.page_objects.GoogleSearchResultPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchCovidViaGoogle {

    public static WebDriver driver;
    protected static GoogleHomepage googling;
    protected static GoogleSearchResultPage searchResult;

    @Before
    public static void setTest() {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/java/posmy/interview/qa/driver/chromedriver.exe");

        driver = new ChromeDriver();
        googling = new GoogleHomepage();
        searchResult = new GoogleSearchResultPage();
        googling.setWebDriver(driver);
    }

    @Given("user navigates to Google search page")
    public void navigates_to_Google() {
        googling.openSearchPage();
    }

    @When("user search for {string}")
    public void user_search_for(String query) {
        googling.enterKeywordsToSearch(query);
    }

    @Then("user sees {string} search result page")
    public void user_sees_search_result_page(String result) {
        searchResult.getSerpTitle();
        assertTrue(searchResult.getSerpTitle().contains(result));
    }

    @And("user sees the Top stories section appear in the search result page")
    public void user_sees_top_stories_section_in_serp() {
        assertEquals(searchResult.getSection("Top stories"), "Top stories");
    }

    @And("user sees the Common questions sections appear in the search result page")
    public void user_sees_common_question_section_in_serp() {
        assertEquals(searchResult.getSection("Common questions"), "Common questions");
    }

    @And("user click the MOH website link from the search result page")
    public void user_click_MOH_website_link() {
        searchResult.clickMOHResult();
    }

    @Then("user is redirected to MOH website")
    public void user_is_redirected_to_MOH() {
        searchResult.getSerpTitle();
        assertTrue(searchResult.getSerpTitle().contains("Home | COVID-19 MALAYSIA"));
    }

    @After
    public static void closeBrowser() {
        driver.quit();
    }

}
