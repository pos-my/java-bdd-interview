package posmy.interview.pages;

import org.openqa.selenium.WebDriver;
import posmy.interview.qa.driver.RemoteWebDriverFactory;

public class InterviewMainPage {
    public static WebDriver driver = RemoteWebDriverFactory.chrome();
    public void closeBrowser() {
        driver.close();
    }
}
