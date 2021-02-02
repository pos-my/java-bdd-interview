package posmy.interview.qa.pages;


import org.coronium.page.AutoPage;
import org.coronium.page.core.ui.annotations.Visible;
import org.openqa.selenium.support.FindBy;
import posmy.interview.qa.util.typifiedelement.WebElement;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;

public class NewsPage extends AutoPage<NewsPage> {
    @Visible
    @Name("News Headline")
    @FindBy(css = ".headline.story-pg h1")
    private WebElement newsHeadline;

    @Step("Get News title to compare")
    public String getNewsTitle(){
        return newsHeadline.getText();
    }

    @Step("Close browser")
    public void closeBrowser(){
        //Close driver and browser
        driver.close(); }
}
