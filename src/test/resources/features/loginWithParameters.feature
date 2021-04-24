Feature: Login with parameters

  @librarianWithParameters1
  Scenario: Login as librarian 13
    Given I am on the login page
    When I enter username "librarian13@library"
    And I enter password '9rf6axdD'
    And click the sign in button
    And there should be 2841 users
    Then dashboard should be displayed

  @librarianWithParameters2
  Scenario: Login as librarian same line
    Given I am on the login page
    When I login using "librarian13@library" and "9rf6axdD"
    And there should be 2841 'users'
    Then dashboard should be displayed