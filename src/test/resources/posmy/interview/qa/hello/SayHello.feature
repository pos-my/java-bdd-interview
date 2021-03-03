Feature: Say Hello

  @hello
  Scenario: Greet
    When I say hello
    Then I will see hello

  @goodbye
  Scenario: Goodbye
    When I say hello
    Then I will see hello

  @stay
  Scenario: Stay
    When I say hello
    Then I will stay
