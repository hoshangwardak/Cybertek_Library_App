
@wip2
Feature: Verifying the counts of users, books and borrowedBooks


  Scenario: Verify the book, borrowed books and user counts
    Given I am on the login page
    When I login as a librarian
    And user count should be equal to "userCount"
    And books count should be equal to "booksCount"
    And borrowed Books count should be equal to "borrowedBooksCount"


