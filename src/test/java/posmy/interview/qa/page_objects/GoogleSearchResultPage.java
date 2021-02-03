package posmy.interview.qa.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchResultPage extends GoogleHomepage {

    public String getSerpTitle() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return driver.getTitle();
    }

    public String getSection(String section) {
        if (section.equals("Top stories")) {
            WebElement topStories = driver.findElement(By.xpath("//*[text()='Top stories']"));
            return topStories.getText();
        }

        else if (section.equals("Health information")) {
            //scroll down so that the common question section is visible
            JavascriptExecutor jse = ((JavascriptExecutor) driver);
            jse.executeScript("window.scrollTo(0, 3500)");

            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement commonQuestion = driver.findElement(By.xpath("//*[text()='Health information']"));
            return commonQuestion.getText();
        }

        else return "section not found!";
    }

    public void clickMOHResult() {
        WebElement mohLink = driver.findElement(By.linkText("COVID-19 MALAYSIA: Home"));
        mohLink.click();
    }

}
