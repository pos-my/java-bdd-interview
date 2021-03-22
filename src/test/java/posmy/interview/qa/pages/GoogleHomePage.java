package posmy.interview.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.allure.annotations.Step;


public class GoogleHomePage extends BasePage {

    public GoogleHomePage (WebDriver driver) {
        super(driver);
    }

    private static WebDriver driver = new ChromeDriver();

    @FindBy(css = "input[title='Search']")
    private WebElement searchBox;

    @Step("Navigate to Google Home Page")
    public static GoogleHomePage open() {
        driver.get("https://www.google.com");
        return PageFactory.initElements(driver, GoogleHomePage.class);
    }

    @Step
    public ResultsPage setSearch(String keyword) {
        searchBox.click();
        searchBox.sendKeys(keyword);
        searchBox.sendKeys(Keys.ENTER);
        return PageFactory.initElements(driver, ResultsPage.class);
    }

    @Step
    public boolean isSearchBoxDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.isDisplayed();
        return true;
    }


}
