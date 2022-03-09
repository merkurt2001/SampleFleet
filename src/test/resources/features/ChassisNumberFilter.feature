
Feature: The user can use the "Chassis Number" filter under the 'All Car' page

  @US010_AC1
  Scenario: User can select "Chassis Number" filter under 'Fleet-Vehicles' module
    When the user clicks on filter button
    And the user clicks on manage filter button
    And the user clicks on Chassis Number checkbox
    Then the Chassis Number checkbox should be selected

  @US010_AC2
  Scenario: User can select "Chassis Number" filter under 'Fleet-Vehicles' module
    When the user clicks on filter button
    And the user clicks on manage filter button
    And the user clicks on Chassis Number checkbox
    And the user clicks on Chassis Number All button
    And the user clicks on dropdown menu
    Then Chassis Number" filter should provide the methods shown as below
      | Between             |
      | Not Between         |
      | Equals              |
      | Not Equals          |
      | More Than           |
      | Less Than           |
      | Equals Or More Than |
      | Equals Or Less Than |
      | Is Empty            |
      | Is Not Empty        |

  @US10_AC5
    Scenario: When the user selects the "More than" method with numeric values, the results should be more than the specified value
      When the user clicks on filter button
      And the user clicks on manage filter button
      And the user clicks on Chassis Number checkbox
      And the user clicks on Chassis Number All button
      And the user clicks on dropdown menu
      And the user clicks More Than button
      And enter numeric values
      And click update button
      Then the results should be more than specified value