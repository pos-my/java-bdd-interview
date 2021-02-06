package posmy.interview.qa.driver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

/**
 * @author Rashidi Zin
 */
public class RemoteWebDriverFactory {

    private RemoteWebDriverFactory() {}

    public static RemoteWebDriver chrome() {
        chromedriver().useLocalVersionsPropertiesFirst().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--headless");

        return new ChromeDriver(options);
    }

}
