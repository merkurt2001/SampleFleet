@lot
Feature: Log out
  @Lot1 @TRANS-1267
  Scenario: Store Manager can log out by using log out button inside profile info and ends up in login page
    Given Store Manager click  userNameDropDown
    And click the Logout
    Then The Store Manager should be on the Login Page
  @Lot2 @TRANS-1268
  Scenario: The Store Manager can not go to the home page again by clicking the step back button after successfully logged out.
    Given Store Manager click  userNameDropDown
    And click the Logout
    And The Store Manager should be on the Login Page
    And The Store Manager click the step back button
    Then The Store Manager Should be still on the login page

  @Lot3 @TRANS-1269
  Scenario: The Store Manager be logged out if Store Manager close the tab (if there are multiple open tabs in the app, close all of them)
    Given Store Manager close the tab and open a new page and goes to "https://qa.translantik.com/"
    Then The Store Manager should be on the new Login Page
  @Lot4 @TRANS-1270
  Scenario: The Store Manager be logged out if the user is away from keyboard for 3 minutes
    Given Store Manager doesn't do any keybord and mouse action for 3 minutes
    Then The Store Manager should be on the Login Page