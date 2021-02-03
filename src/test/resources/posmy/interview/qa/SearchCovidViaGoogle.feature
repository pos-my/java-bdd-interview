Feature: Search Covid 19 in Malaysia via Google

  Scenario: Verify that "Top stories" and "Common questions" sections appear in search result page
    Given user navigates to Google search page
    When user search for "covid 19 in Malaysia"
    Then user sees "covid 19 in Malaysia" search result page
    And user sees the Top stories section appear in the search result page
    And user sees the Health information sections appear in the search result page

  Scenario: Verify clicking MOH website link from search result page redirects to MOH page
    Given user navigates to Google search page
    And user search for "covid 19 in Malaysia"
    When user sees "covid 19 in Malaysia" search result page
    And user click the MOH website link from the search result page
    Then user is redirected to MOH website
