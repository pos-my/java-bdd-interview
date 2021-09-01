package posmy.interview.qa.pages;

import com.frameworkium.core.ui.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import posmy.interview.qa.util.CommonServices;
import ru.yandex.qatools.htmlelements.annotations.Name;

import static posmy.interview.qa.util.constants.genericConstants.defaultGoogleSearchURL;

public class GoogleSearchPage extends BasePage<GoogleSearchPage> {
    private final static String HEADING_CSS = "div[role='heading']";
    private WebElement topResultHeading;

    @Name("Google Search Text box")
    @FindBy(css = "input[aria-label='Search']")
    private WebElement googleSearchTextBox;

    @Name("Top Stories Heading")
    @FindBy(css = "a[role='heading link']")
    private WebElement topStoriesHeading;


    @Step("Open Google URL")
    public WebDriver navigateToGoogleSearch() {
        CommonServices.navigateToURL(GoogleSearchPage.class, defaultGoogleSearchURL);
        CommonServices.maximizeBrowser(driver);
        return driver;
    }

    @Step("Input value into Google Search text box")
    public GoogleSearchPage inputSearchText(String searchText) {
        googleSearchTextBox.clear();
        googleSearchTextBox.sendKeys(searchText);
        googleSearchTextBox.sendKeys(Keys.ENTER);
        return this;
    }

    @Step("Verify Top Stories Section")
    public boolean verifyTopStoriesSection() {
        logger.info("Top Stories Section is displayed: " + topStoriesHeading.isDisplayed());
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
        logger.info("Top Result heading is displayed: " + topResultHeading.isDisplayed());
        return topResultHeading;
    }
}
