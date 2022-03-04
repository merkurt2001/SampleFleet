Feature: Delete a car

  Scenario: The user should be able to see the delete button by hovering over the three dots at the end of each row
    When the user hovers over the three dots of row whose "ChassisNumber" equals "117,312"
    Then the user should be able to see the delete button

  Scenario: "Delete Confirmation" pop up should be displayed when the user clicks on the delete button
    When the user hovers over the three dots of row whose "ChassisNumber" equals "117,312"
    And the user clicks on the delete button
    Then The Delete Confirmation pop up should be displayed

  Scenario: The user should be able to delete any car by clicking on the delete button at the end of each row
    When the user hovers over the three dots of row whose "ChassisNumber" equals "117,312"
    And the user clicks on the delete button
    And the user clicks on the -Yes,Delete- confirmation button
    Then the user should delete the car and "Item deleted" message should be displayed

  @wip
  Scenario: The user should be able to delete a car from General Information page
    When the user clicks on a row whose "ChassisNumber" equals "177,312"
    And the user clicks on the delete button and Yes,Delete confirmation button on the General Information page
    Then the car is deleted and the "Car deleted" message should be displayed


