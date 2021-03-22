Feature: Google Search

  Scenario: Search for covid-19 in Malaysia Scenario
    Given I am on Google Search Page
    When I search for covid 19 in Malaysia
    Then top stories section is displayed in the results page
    And common questions section is displayed in the results page
    When I click on the MOH Website in the search result
    Then MOH website is displayed