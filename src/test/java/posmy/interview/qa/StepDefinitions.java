package posmy.interview.qa;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepDefinitions {

    WebDriver driver = null;

    @Given("user navigates to Google search page")
    public void navigates_to_Google() {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/java/posmy/interview/qa/driver/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
    }

    @When("user search for {string}")
    public void user_search_for(String query) {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(query);
        searchBox.submit();
    }

    @Then("user sees {string} search result page")
    public void user_sees_search_result_page(String result) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        assertTrue(driver.getTitle().contains(result));
    }

    @And("user sees the Top stories section appear in the search result page")
    public void user_sees_top_stories_section_in_serp() {
        WebElement topStories = driver.findElement(By.xpath("//*[text()='Top stories']"));
        assertTrue(topStories.getText().equals("Top stories"));
    }

    @And("user sees the Common questions sections appear in the search result page")
    public void user_sees_common_question_section_in_serp() {
        //scroll down so that the common question section is visible
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("window.scrollTo(0, 3500)");
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement commonQuestion = driver.findElement(By.xpath("//*[text()='Common questions']"));
        assertTrue(commonQuestion.getText().equals("Common questions"));
    }

    @And("user click the MOH website link from the search result page")
    public void user_click_MOH_website_link() {
        WebElement mohLink = driver.findElement(By.linkText("COVID-19 MALAYSIA: Home"));
        mohLink.click();
    }

    @Then("user is redirected to MOH website")
    public void user_is_redirected_to_MOH(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        assertTrue(driver.getTitle().contains("Home | COVID-19 MALAYSIA"));
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

}
