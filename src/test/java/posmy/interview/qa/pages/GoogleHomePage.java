package posmy.interview.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class GoogleHomePage {

    public GoogleHomePage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[title='Search']")
    private WebElement searchBox;

    @Step
    public void setSearch(String keyword) {
        searchBox.sendKeys(keyword);
        searchBox.sendKeys(Keys.ENTER);
    }

    @Step
    public boolean isSearchBoxDisplayed() {
        searchBox.isDisplayed();
        return true;
    }
}
