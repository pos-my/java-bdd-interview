package posmy.interview.qa.pages;

import io.qameta.allure.Step;
import org.coronium.page.AutoPage;
import org.coronium.page.core.ui.annotations.Visible;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import posmy.interview.qa.util.typifiedelement.WebElement;
import ru.yandex.qatools.htmlelements.annotations.Name;

import java.util.List;

public class ResultPage extends AutoPage<ResultPage> {

    @Visible
    @Name("Result Page - Total matching results")
    @FindBy(css = "div#result-stats")
    private WebElement totalMatchingResults;

    @Name("Top Stories Section")
    @FindBy(css = "[data-hveid='CAQQAA']")
    private WebElement topStoriesSection;

    @Name("Common Question Section")
    @FindBy(css = "#kp-wp-tab-HealthStats div.ifM9O h2")
    private WebElement commonQuestionSect;

    @Name("Top Stories")
    @FindBy(css = "a[role='heading link']")
    private WebElement topStoriesLink;

    @Name("List of Covid 19 Stories")
    @FindBy(css = "[decode-data-ved='1'] g-card")
    private List<WebElement> listCovidStories;

    @Name("List of Covid 19 Stories Title ")
    @FindBy(css = "[decode-data-ved='1'] g-card div[role='heading']")
    private List<WebElement> listCovidStoriesTitle;

    @Step("Total matching result is displayed")
    public boolean totalMatchingResultsIsDisplayed(){
        return totalMatchingResults.isDisplayed();
    }

    @Step("Top Stories Section is displayed")
    public boolean topStoriesSectionIsDisplayed(){
        return topStoriesSection.isDisplayed();
    }

   @Step("Get common question header")
    public String getCommonQuestionHeader(){
        //Common Question header
       return commonQuestionSect.getText();
    }

    @Step("Click Top Stories Link")
    public void clickTopStoriesLink(){
        topStoriesLink.click();
    }

    @Step("Get First Story title")
    public String getFirstStoryTitle(){
       String title =  listCovidStoriesTitle.stream()
               .map(e->e.getText())
               .findFirst()
               .orElseThrow(()-> new NoSuchElementException("Element not found"));

       return title;
    }

    @Step("Select first story")
    public void selectFirstStory(){
        listCovidStories.stream()
                .findFirst()
                .orElseThrow(()-> new NoSuchElementException("No matching found"))
                .click();
    }
}
