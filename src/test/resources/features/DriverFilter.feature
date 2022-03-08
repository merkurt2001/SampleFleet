Feature: As a store manager, I should be able to use the "Driver" filter under the Fleet-Vehicles page

  Background:User can select "Driver" filter under 'Fleet-Vehicles' module
    Given the user clicks on filter button
    When the user clicks on manage filter button
    When the user clicks on "Driver" filter
    Then the "Driver" filter should be selected

  @US11_AC2
  Scenario: "Driver" filter should provide the methods shown as below in the examples
    When the user clicks on "Driver" button
    And the user clicks on "contains" dropdown
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



