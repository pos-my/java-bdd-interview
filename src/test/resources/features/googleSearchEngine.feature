@GoogleSearchEngine

Feature: GoogleSearchEngine

  @navigateToMOH
  Scenario: Google Search Engine Search "covid 19 in Malaysia"
    Given I navigate to Google Search Page
    And I search on the Google Search Textbox: "covid 19 in Malaysia"
    Then I verify the Top Stories Section on Google Result Page
    And I verify the Top Result Section on Google Result Page
    And I verify the Link Text is on Google Result Page: "Home | COVID-19 MALAYSIA"
    And I click on the MOH Link Text on Google Result Page: "Home | COVID-19 MALAYSIA"
    Then I verify current URL: "https://covid-19.moh.gov.my"
    And I verify the current Page Title: "Home | COVID-19 MALAYSIA"
    And I close the browser
