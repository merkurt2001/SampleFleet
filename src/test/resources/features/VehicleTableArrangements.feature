
  Feature:US-004 Vehicle Table Arrangements

#    Background:
#      Given the user is on the vehicles page
#
      @TRANS-1280 @US004_AC1 @RA
    Scenario: The value of 'View Per Page' should be '25' by default
#      When the store manager clicks the "View per page" button
      Then the View per page should be '25' default

    @TRANS-1281 @US004_AC2 @RA
      Scenario: 'View Per Page' includes the values shown as below
     When the user click on View per page button
      Then options should be same with below
        |10 |
        |25 |
        |50 |
        |100|

    @TRANS-1282 @US004_AC3 @RA
      Scenario Outline:'View Per Page' button under the Fleet-Vehicles module displayed truely
        When the user click on View per page button
        And the user clicks on <value> to arrange the row numbers of the results
        Then the rows should be equal or less than the <value>
        Examples:
        |value|
        |10   |
        |25   |
        |50   |

    @TRANS-1283 @US004_AC4 @RA
        Scenario: User can sort a column in ascending or descending order by clicking the column name
          When the user click the Model Year button
          Then the user can sort a column in ascending or descending order

    @TRANS-1284 @US004_AC5 @RA
    Scenario:   User can remove all sortings and filterings on the page by using the reset button
      When the user click the Model Year button
      Then the user click the reset button
      Then the user can remove all sortings and filterings on the page



