package posmy.interview.qa.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.NoSuchElementException;

public class Steps {

    ChromeDriver driver = new ChromeDriver();
    String googleUrl = "https://www.google.com/";
    public static String COVID_19 = "covid-19 in Malaysia";

    @Given("^that I am on Google$")
    public void iAmOnGoogle(){
        driver.get(googleUrl);
    }

    @Then("^I want to search about Covid-19 in Malaysia$")
    public void iWantToSearchAboutCovid19InMalaysia(){
        driver.findElement(By.cssSelector("input[title='Search']"))
                .isDisplayed();

        assert driver.findElement(By.cssSelector("head > title")).equals("Google");
    }

    @Then("^I will key in covid 19 in Malaysia and click on Google Search button$")
    public void iWillKeyInCovid19InMalaysiaAndClickOnGoogleSearchButton() {
        driver.findElement(By.cssSelector("input[title='Search']"))
                .sendKeys(COVID_19);

       driver.findElement(By.name("btnK")).click();
    }

    @Then("^I will reach results page$")
    public void iWillReachResultsPage() {
        assert driver.getPageSource().contains(COVID_19);
    }

    @And("^I will see Top stories sections$")
    public void iWillseeTopStoriesSections() {
       String topStories = driver.findElement
               (By.cssSelector("a[class='a-no-hover-decoration T9EeC oRJe3d']"))
               .getText();
       assert topStories.equals("Top stories");
    }

    /*@And("^I will see Common Questions sections$")
    public void seeCommonQuestionsSections() {
        String commonQuestion = driver.findElement
                (By.cssSelector("a[class='LuVEUc']"))
                .getText();
        assert commonQuestion.equals("Common Questions");
    }*/

    @Then("^I will click on first result for Top result and will leave Google website$")
    public void clickFirstResultForTopResultAndWillLeaveGoogleWebsite() {
        driver.findElements(By.cssSelector("div[class='UDZeY OTFaAf'] div[class='yuRUbf']"))
                .stream()
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No such element"))
                .findElement(By.cssSelector("a"))
                .click();

        driver.quit();
    }
}