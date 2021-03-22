package posmy.interview.qa.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class ResultsPage {

    public ResultsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#kp-wp-tab-overview div.TzHB6b.cLjAic.LMRCfc > div")
    private WebElement topStoriesSection;

    @FindBy(css = "cite[class='iUh30 Zu0yb qLRx3b tjvcx']")
    private List<WebElement> topResults;

    @Step
    public boolean isTopStoriesDisplayed() {
        topStoriesSection.isDisplayed();
            return true;
    }
    @Step("Select first result")
    public void selectFirstResult(){
        topResults.stream()
                .filter(e -> e.getAttribute("innerHTML").contains("moh.gov.my"))
                .findFirst()
                .orElseThrow(()-> new NoSuchElementException("No matching found"))
                .click();
    }
}