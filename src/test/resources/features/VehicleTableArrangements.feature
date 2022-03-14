
  Feature:US-004 Vehicle Table Arrangements

#    Background:
#      Given the user is on the vehicles page
#
      @US004_AC1 @RA
    Scenario: The value of 'View Per Page' should be '25' by default
#      When the store manager clicks the "View per page" button
      Then the View per page should be '25' default

    @US004_AC2 @RA
      Scenario: 'View Per Page' includes the values shown as below
#     When the user click on "View per page" button
      Then options should be same with below
        |10 |
        |25 |
        |50 |
        |100|

