package posmy.interview.qa.steps;

import org.junit.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import posmy.interview.qa.util.TestBase;


public class CovidSearchSteps extends TestBase{
	
	@Before
	public void user_opens_browser_launch_google() throws Throwable{
		initialization();
	}

	@Given("User is on Google page")
	public void validate_homepage_title() {
		Assert.assertEquals("Google", hp.validateGooglePageTitle());
	}
	
	@When("user enters covid 19 in Malaysia into search box")
	public void user_enter_text_in_searchbox() {
		hp.EnterSearchkeyword("covid 19 in Malaysia");
	}
	
	@And("user clicks Google Search button")
	public void user_clicks_Google_Search_btn() {
		hp.clickGoogleSearchButton();
	}
	
	@Then("validate Top Stories section is shown")
	public void validate_top_stories_section() {
		Assert.assertEquals("Top stories",srp.validateTopStoriesLabel());
	}
	
	@When("user clicks on Testing menu on sidebar")
	public void user_clicks_testing_menu_sidebar() {
		srp.clickSidebar_Testing();
	}
	
	@Then("Validate Common Question Labels shown")
	public void validate_common_question_section_shown() {
		Assert.assertEquals("Common questions",srp.validateCommonQuestionsLabel());
	}
	
	@When("user clicks on Overview menu on sidebar")
	public void user_clicks_overview_menu_sidebar() {
		srp.clickSidebar_Overview();
	}
	
	@Then("user clicks on MOH link from results page")
	public void user_clicks_MOH_link() {
		srp.clickMOHLink();
		Assert.assertEquals("http://covid-19.moh.gov.my/",mp.get_MOHPageURL());
		
	}
	
	@After
	public void endTest() {
	    tearDown();
	}
	
}
