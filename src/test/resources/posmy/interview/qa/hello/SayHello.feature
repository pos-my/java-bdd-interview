Feature: Say Hello

  @hello
  Scenario: Greet
    When I say hello
    Then I will see hello

  @goodbye
  Scenario: Goodbye
    When I say hello
    Then I will see hello
