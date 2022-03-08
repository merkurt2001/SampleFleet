Feature: As a store manager, I should be able to use the "Driver" filter under the Fleet-Vehicles page

  Background:User can select "Driver" filter under 'Fleet-Vehicles' module
    Given the user clicks on filter button
    When the user clicks on manage filter button
    And the user clicks on "Driver" filter
    And the "Driver" filter should be selected
    Then the user clicks on "Driver:All" button

  @US11_AC2
  Scenario: "Driver" filter should provide the methods shown as below in the examples
    When the user clicks on "contains" dropdown
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
  When the user writes the "miss" keyword to Contains method input box and click update button
  Then the results should contain the "miss" keyword
