@browser
Feature: Google for Covid-19 cases Feature

  Scenario: Google for Covid-19 cases Test Scenario
    Given that I am on Google
    Then I want to search about Covid-19 in Malaysia
    Then I will key in covid 19 in Malaysia
    And click on Google Search button
    Then I will see Top stories section
    Then I will see Common questions section
    Then I will click on first result for Top results
    And will leave Google website
