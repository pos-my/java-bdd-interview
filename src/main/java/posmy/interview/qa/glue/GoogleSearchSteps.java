package posmy.interview.qa.glue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import posmy.interview.qa.pages.GoogleSearchPage;
import posmy.interview.qa.pages.MOHPage;
import posmy.interview.qa.util.CommonServices;

import static com.google.common.truth.Truth.assertWithMessage;

public class GoogleSearchSteps {
    private WebDriver driver;
    private GoogleSearchPage googleSearchPage = new GoogleSearchPage().get();
    private String urlLinkText;

    @Step
    @Given("I navigate to Google Search Page")
    public void navigateToDefaultBrowser() {
        //open browser and go to google search
        driver = googleSearchPage.navigateToGoogleSearch();
    }

    @Step
    @And("I search on the Google Search Textbox: {string}")
    public void inputSearchTextBox(String searchText) {
        //open browser and go to google search
        googleSearchPage.inputSearchText(searchText);
    }

    @Step
    @Then("I verify the Top Stories Section on Google Result Page")
    public void verifyTopStoriesSection() {
        //Verify Top Stories section exist
        assertWithMessage("Top Stories Section not available")
                .that(googleSearchPage.verifyTopStoriesSection())
                .isTrue();
    }

    @Step
    @And("I verify the Top Result Section on Google Result Page")
    public void verifyTopResultSection() {
        //Verify Top Result section exist
        assertWithMessage("Failed to locate Top Result heading on Result page")
                .that(googleSearchPage.getTopResultElement())
                .isNotNull();
    }

    @Step
    @And("I verify the Link Text is on Google Result Page: {string}")
    public void verifyLinkTextOnResultPage(String linktext) {
        //Verify the search result contain MOH Website link
        assertWithMessage("Link Text: " + linktext + " does not exist on Search Result page.")
                .that(CommonServices.getLinkText(driver, linktext).isDisplayed())
                .isTrue();
    }

    @Step
    @And("I click on the MOH Link Text on Google Result Page: {string}")
    public void clickOnMOHLinkText(String linktext) {
        //Click on MOH's website url link and navigate to MOH's home page
        CommonServices.clickOnLinkText(driver, MOHPage.class, linktext);
        urlLinkText = linktext;
    }

    @Step
    @Then("I verify current URL: {string}")
    public void verifyCurrentURL(String url) {
        assertWithMessage("Link Text: " + urlLinkText + " does not exist on Search Result page.")
                .that(driver.getCurrentUrl())
                .ignoringCase()
                .equals(url);
    }

    @Step
    @And("I verify the current Page Title: {string}")
    public void verifyCurrentPageTitle(String pageTitle) {
        //verify MOH Page title
        assertWithMessage("Current page title is not " + pageTitle)
                .that(CommonServices.getBrowserTitle(driver))
                .ignoringCase()
                .equals(pageTitle);
    }

}
