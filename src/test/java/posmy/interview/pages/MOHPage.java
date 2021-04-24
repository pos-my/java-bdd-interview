package posmy.interview.pages;

public class MOHPage extends InterviewMainPage {
    public String mohUrl = "http://covid-19.moh.gov.my/";

    public String getCurrentUrl() {
        return InterviewMainPage.driver.getCurrentUrl();
    }
}
