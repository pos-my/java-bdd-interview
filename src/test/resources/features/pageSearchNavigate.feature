Feature: Search and Navigation

  Scenario: Verify search result and navigate to MOH website

    Given user search "covid 19 in Malaysia" in "Google"
    And section "Top stories" is visible
    And section "Common question" is visible
    When user click on found link "http://covid-19.moh.gov.my/"
    Then user will navigated to official MOH website