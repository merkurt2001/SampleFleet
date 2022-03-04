Feature: Delete a car

  @wip
  Scenario: The user should be able to see the delete button by hovering over the three dots at the end of each row
    When the user hovers over the three dots
    Then the user should be able to see the delete button

  Scenario: "Delete Confirmation" pop up should be displayed when the user clicks on the delete button
    When the user hovers over the three dots
    And the user clicks on the delete button
    Then The Delete Confirmation pop up should be displayed


