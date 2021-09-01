package posmy.interview.qa.util;

import com.frameworkium.core.ui.pages.BasePage;
import com.frameworkium.core.ui.pages.PageFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class CommonServices {
    @Step("Navigate to URL link")
    public static <T extends BasePage<T>> T navigateToURL(Class<T> className, String url) {
        return PageFactory.newInstance(className, url);
    }

    public static void openChromeToURL(WebDriver driver, String url)
    {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get(url);
    }

    @Step("Verify Link Text exist")
    public static WebElement getLinkText(RemoteWebDriver driver, String linkText) {
        return driver.findElement(By.linkText(linkText));
    }

    @Step("Click on Link Text")
    public static void clickOnLinkText(RemoteWebDriver driver, String linkText) {
        CommonServices.getLinkText(driver, linkText).click();
    }

}
