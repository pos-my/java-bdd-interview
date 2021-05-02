Feature: Search  covid 19 News
  Search related news of covid 19
  The news list should be displayed

  Scenario: Search Covid 19 News
    Given I launch the browser
    When  I search the covid 19 news
    Then  I verify top stories and common questions section
    Then  I verify MOH site and Navigate to the site
    And   I close browser