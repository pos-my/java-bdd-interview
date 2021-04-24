Feature: Java DBB Interview
  Scenario: Search will return results
    Given Open Chrome and go to Google
    And Input keywords in search field
    When Search results available
    And Top stories section available
    And Common questions section available
    Then Click MOH website
    And Verify MOH website
    And Close Chrome
