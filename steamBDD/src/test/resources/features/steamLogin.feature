Feature: Login functionality on steam website
  As a user, I want to be able to log in to the website or create a new account

  Scenario: Successful login
    Given I am on the login page
    When I enter the correct login and password
    And I click on login button
    Then I should be redirected to the authenticator page

  Scenario Outline: Incorrect login or password
    Given I am on the login page
    When I enter a "<invalid name>" or "<invalid password>"
    And I click on login button
    Then I should see an error message indicating that the name or password is incorrect

    Examples:
      | invalid name | invalid password |
      | csb          | qwerty123456     |
      | qwerty123456 | csb              |
      | wrong_name   | wrong_password   |


  Scenario: Forgot login
    Given I am on the login page
    When I click to forgot account link
    Then I should be redirected to steam support page

  Scenario: About Steam
    Given I am on the login page
    When I click to learn more about steam link
    Then I should be redirected to about Steam page

  Scenario: Create account
    Given I am on the login page
    When I click to create account link
    Then I should be redirected to create account page