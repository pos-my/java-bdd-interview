package posmy.interview.qa.util;

import com.frameworkium.core.ui.pages.BasePage;
import com.frameworkium.core.ui.pages.PageFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonServices {

    @Step("Navigate to URL link")
    public static <T extends BasePage<T>> T navigateToURL(Class<T> className, String url) {
        return PageFactory.newInstance(className, url);
    }

    @Step("Maximize Browser")
    public static void maximizeBrowser(WebDriver driver) {
        //Mazimize current window
        driver.manage().window().maximize();
    }

    @Step("Verify Link Text exist")
    public static WebElement getLinkText(WebDriver driver, String linkText) {
        return driver.findElement(By.linkText(linkText));
    }

    @Step("Click on Link Text")
    public static <T extends BasePage<T>> T clickOnLinkText(WebDriver driver, Class<T> className, String linkText) {
        CommonServices.getLinkText(driver, linkText).click();
        return PageFactory.newInstance(className);
    }

    @Step("Get the title of the current page")
    public static String getBrowserTitle(WebDriver driver) {
        return driver.getTitle();
    }
}
