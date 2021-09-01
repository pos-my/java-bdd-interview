package posmy.interview.qa.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

/**
 * @author Rashidi Zin
 */
public class RemoteWebDriverFactory {

    private RemoteWebDriverFactory() {
    }

    public static RemoteWebDriver chrome() {
        chromedriver().useLocalVersionsPropertiesFirst().setup();
        return new ChromeDriver();
    }
}
