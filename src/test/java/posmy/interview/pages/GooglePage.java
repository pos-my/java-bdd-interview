package posmy.interview.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage extends InterviewMainPage{
    @FindBy(xpath = "//input[@aria-label='Search']")
    private WebElement searchInput;

    public static GooglePage open() {
        InterviewMainPage.driver.get("http://www.google.com");
        return PageFactory.initElements(InterviewMainPage.driver, GooglePage.class);
    }

    public SearchResultsPage search(String value) {
        searchInput.sendKeys(value, Keys.ENTER);
        return PageFactory.initElements(InterviewMainPage.driver, SearchResultsPage.class);
    }
}
