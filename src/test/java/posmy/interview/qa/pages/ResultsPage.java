package posmy.interview.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class ResultsPage {

    
    @FindBy(css = "#kp-wp-tab-overview div.TzHB6b.cLjAic.LMRCfc > div")
    private WebElement topStoriesSection;

    @Step
    public boolean isTopStoriesDisplayed() {
        topStoriesSection.isDisplayed();
            return true;
    }
}