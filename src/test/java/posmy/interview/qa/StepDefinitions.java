package posmy.interview.qa;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

    @Given("user navigates to Google search page")
    public void navigates_to_Google() {
        throw new io.cucumber.java.PendingException();
    }

    @When("user search for {string}")
    public void user_search_for(String query) {
        throw new io.cucumber.java.PendingException();
    }

    @Then("user sees {string} search result page")
    public void user_sees_search_result_page(String result) {
        throw new io.cucumber.java.PendingException();
    }

    @And("user sees the Top stories section appear in the search result page")
    public void user_sees_top_stories_section_in_serp() {
        throw new io.cucumber.java.PendingException();
    }

    @And("user sees the Common questions sections appear in the search result page")
    public void user_sees_common_question_section_in_serp() {
        throw new io.cucumber.java.PendingException();
    }

    @When("user click the MOH website link from the search result page")
    public void user_click_MOH_website_link() {
        throw new io.cucumber.java.PendingException();
    }

    @Then("user is redirected to MOH website")
    public void user_is_redirected_to_MOH(){
        throw new io.cucumber.java.PendingException();
    }

}
