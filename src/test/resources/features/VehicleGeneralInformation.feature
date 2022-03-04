@us007
Feature:US-007 Vehicle General Information

  @ac1
  Scenario: User can see the "General Information" page by clicking on any vehicle (row)
    When the store manager clicks any row
    Then "General Information" page should be displayed

  @ac2
  Scenario: User can see the "General Information" page clicking on the "Eye (View)" icon at the end of each row
    Then the store manager clicks any three dot at the end of the row
    When the store manager clicks on the Eye "View" icon
    Then "General Information" page should be displayed

  @ac3
  Scenario: User should see "Edit", "Delete" and "Add Event" buttons on the "General Information" page
    When the store manager clicks any row
    Then "General Information" page should be displayed
    Then Edit, Delete, and Add Event button should be displayed

