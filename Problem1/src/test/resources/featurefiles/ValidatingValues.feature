
Feature: Validating values in the screen

  Scenario: Verifying the values
    Given Reading all the values in the screen
    And verify the right count of values appear on the screen
    And verify the values on the screen are greater than zero
    And verify the total balance is correct based on the values listed on the screen
    And verify the values are formatted as currencies
    And verify the total balance matches the sum of the values
