@driver
Feature: As a store manager, I should be able to use the "Driver" filter under the Fleet-Vehicles page

  Background:the user clicks on "Driver" filter under 'Fleet-Vehicles' module
    When the user clicks on filter button
    And the user clicks on manage filter button
    And the user clicks on "Driver" filter

  @US11_AC1 @TRANS-1233
  Scenario: User can select "Driver" filter under 'Fleet-Vehicles' module
    Then the "Driver" filter should be selected

  @US11_AC2
  Scenario: "Driver" filter should provide the methods shown as below in the examples
    When the user clicks on "Driver:All" button
    And the user clicks on default dropdown of the "Driver" filter which is "contains" dropdown
    Then the Methods should be seen as below
      | Contains         |
      | Does Not Contain |
      | Is Equal To      |
      | Starts With      |
      | Ends With        |
      | Is Any Of        |
      | Is Not Any Of    |
      | Is Empty         |
      | Is Not Empty     |

  @US11_AC3
  Scenario: "Contains" method should give the results that contain the specified keyword
    When the user clicks on "Driver:All" button
    And the user clicks on default dropdown of the "Driver" filter which is "contains" dropdown
    When the user writes the "miss" keyword to "Contains" method input box and click update button
    Then the results should contain the "miss" keyword

  @US11_AC4
  Scenario: "Does Not Contain" method should give the results that does not contain the specified keyword
    When the user clicks on "Driver:All" button
    And the user clicks on default dropdown of the "Driver" filter which is "contains" dropdown
    And the user clicks on "does not contain" dropdown
    And the user writes the "miss" keyword to "does not contain" method input box and click update button
    Then the results should not contain the "miss" keyword

  @US11_AC5
  Scenario: "Starts With" method should give the results that starts with the specified keyword
    When the user clicks on "Driver:All" button
    Given the user clicks on default dropdown of the "Driver" filter which is "contains" dropdown
    And the user clicks on "starts with" dropdown
    And the user writes the "ma" keyword to "starts with" method input box and click update button
    Then the results should start with the "ma" keyword

  @US11_AC6
  Scenario: "Ends With" method should give the results that ends with the specified keyword
    When the user clicks on "Driver:All" button
    And the user clicks on default dropdown of the "Driver" filter which is "contains" dropdown
    And the user clicks on "ends with" dropdown
    And the user writes the "er" keyword to "ends with" method input box and click update button
    Then the results should end with the "er" keyword