Feature: logging in as different users

  Background:
    Given user is on the login page

  @TC1_1
  Scenario: logging in as librarian
    When user login as a librarian
    Then user should see the dashboard in the url

  @TC1_2
  Scenario: logging in as student
    When user login as a student
    Then user should see the books in the url
