@navigateToMOH

Feature: GoogleSearchEngine

  Scenario: Google Search Engine Search "covid 19 in Malaysia"
    Given I navigate to Google Search Page
    And I search on the Google Search Textbox: "covid 19 in Malaysia"
    Then I verify the Top Stories Section on Google Result Page
    And I verify the Top Result Section on Google Result Page
    And I verify the MOH Link Text is on Google Result Page: "Home | COVID-19 MALAYSIA"
    And I click on the MOH Link Text on Google Result Page
    Then I verify the MOH URL
    And I verify the MOH Top Headings
      | COVID-19 MALAYSIA              |
      | Kementerian Kesihatan Malaysia |
