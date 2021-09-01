package posmy.interview.qa;

import com.frameworkium.core.ui.tests.BaseUITest;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import posmy.interview.qa.pages.GoogleSearchPage;
import posmy.interview.qa.pages.MOHPage;
import posmy.interview.qa.util.CommonServices;

import java.util.Arrays;
import java.util.List;

import static com.google.common.truth.Truth.assertWithMessage;

public class NavigateToMOHTest extends BaseUITest {

    @Feature("Google Search Test")
    @Test(description = "Navigate by Click on MOH website in the Google search result")
    public void navigateToMOH() {
        WebDriver driver;
        String searchText = "covid 19 in Malaysia";
        String mohMainLinkText = "Home | COVID-19 MALAYSIA";
        String mohUrl = "https://covid-19.moh.gov.my";
        List<String> expectedMOHeading = Arrays.asList("COVID-19 MALAYSIA", "Kementerian Kesihatan Malaysia");

        //open browser and go to google search
        GoogleSearchPage googleSearchPage = new GoogleSearchPage().get();
        driver = googleSearchPage.navigateToGoogleSearch();
        googleSearchPage.inputSearchText(searchText);

        //Verify Top Stories section exist
        assertWithMessage("Top Stories Section not available")
                .that(googleSearchPage.verifyTopStoriesSection())
                .isTrue();

        //Verify Top Result section exist
        assertWithMessage("Failed to locate Top Result heading on Result page")
                .that(googleSearchPage.getTopResultElement())
                .isNotNull();

        //Verify the search result contain MOH Website link
        assertWithMessage("Link Text: " + mohMainLinkText + " does not exist on Search Result page.")
                .that(CommonServices.getLinkText(driver, mohMainLinkText).isDisplayed())
                .isTrue();

        //Click on MOH's website url link and navigate to MOH's home page
        CommonServices.clickOnLinkText(driver, MOHPage.class, mohMainLinkText);

        assertWithMessage("Link Text: " + mohMainLinkText + " does not exist on Search Result page.")
                .that(driver.getCurrentUrl())
                .ignoringCase()
                .equals(mohUrl);

        //verify MOH Page title
        assertWithMessage("Current page title is not " + expectedMOHeading)
                .that(CommonServices.getBrowserTitle(driver))
                .ignoringCase()
                .equals(mohMainLinkText);
    }
}
