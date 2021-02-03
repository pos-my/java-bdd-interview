package posmy.interview.qa.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleHomepage {

    protected static WebDriver driver;

    public void setWebDriver(WebDriver driver) {
        GoogleHomepage.driver = driver;
    }

    public void openSearchPage() {
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
    }

    public void enterKeywordsToSearch(String query) {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(query);
        searchBox.submit();
    }

}
