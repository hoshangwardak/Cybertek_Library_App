@wip2
Feature: Verify the counts of the books and the count of the borrowed books

  Scenario: Verify borrowed books and user counts
    Given I am on the login page
    When I login as a librarian
    And user count should be macthes with DataBase
    And books count should be matches with DataBase
    And borrowed books number should matches with the DataBase
    Then all resulats must macthes with the API result
