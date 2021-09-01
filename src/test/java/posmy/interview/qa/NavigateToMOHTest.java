package posmy.interview.qa;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import posmy.interview.qa.pages.GoogleSearchPage;
import posmy.interview.qa.util.CommonServices;

import java.util.Arrays;
import java.util.List;

import static com.google.common.truth.Truth.assertWithMessage;
import static posmy.interview.qa.driver.RemoteWebDriverFactory.chrome;
import static posmy.interview.qa.util.CommonServices.openChromeToURL;
import static posmy.interview.qa.util.constants.genericConstants.defaultGoogleSearchURL;

public class NavigateToMOHTest {

    @Test
    public void navigateToMOH() {
        String searchText = "covid 19 in Malaysia";
        String mohMainLinkText = "Home | COVID-19 MALAYSIA";
        String mohUrl = "https://covid-19.moh.gov.my";
        List<String> expectedMOHeading = Arrays.asList("COVID-19 MALAYSIA", "Kementerian Kesihatan Malaysia");

        //open browser and go to google search
        RemoteWebDriver driver = chrome();
        openChromeToURL(driver, defaultGoogleSearchURL);
        GoogleSearchPage googleSearchPage = new GoogleSearchPage();
        googleSearchPage.initDriver(driver);
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
        CommonServices.clickOnLinkText(driver, mohMainLinkText);

        assertWithMessage("Link Text: " + mohMainLinkText + " does not exist on Search Result page.")
                .that(driver.getCurrentUrl())
                .ignoringCase()
                .equals(mohUrl);

        //verify MOH Page title
        assertWithMessage("Current page title is not " + expectedMOHeading)
                .that(driver.getTitle())
                .ignoringCase()
                .equals(mohMainLinkText);

        driver.quit();
    }
}
