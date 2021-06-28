package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class stepsSearchNavigation {

    private WebDriver driver;

    @Given("^user search \"([^\"]*)\" in \"([^\"]*)\"$")
    public void userSearchIn(String searchTopic, String searchEngine) {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.google.com");

        driver.findElement(By.cssSelector("input[title=\"Search\"]")).sendKeys(searchTopic, Keys.ENTER);

        System.out.println("User searched "+ searchTopic +".");
    }

    @And("section \"([^\"]*)\" is visible")
    public void googleSectionVisible(String section){

        List<WebElement> element = driver.findElements(By.cssSelector("div.HnYYW"));

        for (WebElement eachelement : element)
        {
            if(eachelement.getText().contentEquals(section)){
                System.out.println("Sections "+ section +" available");
            }else
            {
                System.out.println("Sections "+ section +" not available");
            }
            break;
        }
    }

    @When("user click on found link \"([^\"]*)\"")
    public void clickLink(String url){

        WebElement element = driver.findElement(By.cssSelector("div.yuRUbf > a[href=\""+ url +"\"]"));
        System.out.println("Link found.");
        element.click();
    }

    @Then("^user will navigated to official MOH website$")
    public void userWillNavigatedToOfficialMOHWebsite() {
       String pageURL = driver.getCurrentUrl();

        if(pageURL.contains("moh.gov.my"))
        {
            System.out.println("User landed in expected page");
        }else
            System.out.println("User landed in unexpected page");

    }


}
