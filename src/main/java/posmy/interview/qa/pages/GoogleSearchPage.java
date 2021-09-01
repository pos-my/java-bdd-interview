package posmy.interview.qa.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchContextException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GoogleSearchPage {
    private final static String HEADING_CSS = "div[role='heading']";
    private final static String SEARCH_TEXTBOX_CSS = "input[aria-label='Search']";
    private final static String TOP_STORIES_HEADING_CSS = "a[role='heading link']";
    private WebElement topResultHeading;
    private RemoteWebDriver driver;

    public void initDriver(RemoteWebDriver driver) {
        this.driver = driver;
    }

    @Step("Input value into Google Search text box")
    public GoogleSearchPage inputSearchText(String searchText) {
        WebElement searchTextbox = driver.findElement(By.cssSelector(SEARCH_TEXTBOX_CSS));
        searchTextbox.clear();
        searchTextbox.sendKeys(searchText);
        searchTextbox.sendKeys(Keys.ENTER);
        return this;
    }

    @Step("Verify Top Stories Section")
    public boolean verifyTopStoriesSection() {
        WebElement topStoriesHeading = driver.findElement(By.cssSelector(TOP_STORIES_HEADING_CSS));
        return topStoriesHeading.isDisplayed();
    }

    @Step("Get Top Results Heading")
    public WebElement getTopResultElement() {
        topResultHeading =
                driver.findElements(By.cssSelector(HEADING_CSS))
                        .stream()
                        .filter(webElement -> webElement.getText().equals("Top results"))
                        .findFirst()
                        .orElseThrow(() -> new NoSuchContextException("Top Result Heading does not exist"));
        return topResultHeading;
    }
}
