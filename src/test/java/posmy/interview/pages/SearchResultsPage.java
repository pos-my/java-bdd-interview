package posmy.interview.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage extends InterviewMainPage {
    @FindBy(xpath = "//a[@role='heading link']//div[text()='Top stories']")
    public WebElement topStoriesLink;

    @FindBy(id = "result-stats")
    public WebElement resultsCount;

    @FindBy(xpath = "//h2[text()='People also ask']")
    public WebElement commonQuestions;

    @FindBy(xpath = "//a[@href='http://covid-19.moh.gov.my/' and text()='COVID-19 MALAYSIA: Home']")
    public WebElement MOHWebsiteLink;

    public boolean topStoriesIsDisplayed() {
        try {
            return topStoriesLink.isDisplayed();
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public boolean searchResultsIsAvailable() {
        try {
            return resultsCount.isDisplayed();
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public boolean commonQuestionsIsAvailable() {
        try {
            return commonQuestions.isDisplayed();
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public MOHPage clickMOHWebsiteLink() {
        MOHWebsiteLink.click();
        return PageFactory.initElements(InterviewMainPage.driver, MOHPage.class);
    }
}
