package step;

import io.cucumber.java.en.*;
import org.openqa.selenium.JavascriptExecutor;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;

public class searchSteps {

    WebDriver driver;

    @Given("I launch the browser")
    public void i_launch_the_browser() {
        System.setProperty("webdriver.chrome.driver" ,  "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
    }

    @When("I search the covid {int} news")
    public void i_search_the_covid_news(Integer int1) {
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        WebElement searchbox =driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
        searchbox.sendKeys("covid 19 in Malaysia");
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]")).click();
    }

    @Then("I verify top stories and common questions section")
    public void i_verify_top_stories_and_common_questions_section() {
        Boolean topStories=driver.findElement(By.xpath("//div[contains(text(),'Top stories')]")).isDisplayed();
        Assert.assertEquals(true,topStories);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.findElement(By.xpath("//*[@class=\"FZzi2e MjJo9\" and @title=\"Prevention\"]")).click();
        js.executeScript("javascript:window.scrollBy(0,700)");
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Common questions')]")));
        Boolean commonQuestions=driver.findElement(By.xpath("//*[contains(text(),'Common questions')]")).isDisplayed();
        Assert.assertEquals(true,commonQuestions);

    }
    @Then("I verify MOH site and Navigate to the site")
    public void i_verify_moh_site_and_navigate_to_the_site() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.findElement(By.xpath("//*[@class=\"FZzi2e MjJo9\" and @title=\"Overview\"]")).click();
        js.executeScript("javascript:window.scrollBy(0,600)");
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Local and national resource')]")));
        Boolean MOHSite=driver.findElement(By.xpath("//A[@href='http://covid-19.moh.gov.my/'][text()='COVID-19 MALAYSIA: Home']")).isDisplayed();
        Assert.assertEquals(true,MOHSite);
        driver.findElement(By.xpath("//A[@href='http://covid-19.moh.gov.my/'][text()='COVID-19 MALAYSIA: Home']")).click();
        String strUrl = driver.getCurrentUrl();
        Assert.assertEquals("http://covid-19.moh.gov.my/",strUrl);
    }

    @And("I close browser")
    public void i_close_browser() {
        driver.quit();
    }

}
