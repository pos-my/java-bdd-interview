package posmy.interview.qa.util;


import static posmy.interview.qa.util.constants.genericConstants.defaultGoogleSearchURL;

public class Config {
    public static String getBrowserURL() {
        System.out.println("URL: " + defaultGoogleSearchURL);
        return defaultGoogleSearchURL;
    }
}
