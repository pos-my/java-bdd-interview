package posmy.interview.qa.pages;

import org.coronium.page.AutoPage;
import org.coronium.page.core.ui.annotations.Visible;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import posmy.interview.qa.util.typifiedelement.PageFactory;
import posmy.interview.qa.util.typifiedelement.WebElement;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;

public class GoogleLandingPage extends AutoPage{
    @Visible
    @Name("Search box")
    @FindBy(css = "#tsf input[title='Search']")
    private WebElement searchBox;

    public static void open() {
        PageFactory.newInstance(
                GoogleLandingPage.class,
                "https://www.google.com/");
    }

    @Name("Google search button")
    @FindBy(css = "center:nth-child(1) > .gNO89b")
    private WebElement googleSearchButton;

    @Step("Is searchbox displayed")
    public boolean searchboxIsDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(searchBox));
       return searchBox.exists();
    }

    @Step("Set search value")
   public void setSearch(String cases){
        searchBox.sendKeys(cases);
        searchBox.sendKeys(Keys.TAB);
    }

    @Step("Click Google Search button")
    public void clickGoogleSearchButton(){
        googleSearchButton.click();
    }
}
