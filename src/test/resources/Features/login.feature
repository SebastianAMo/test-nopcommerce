Feature: HU01 Login

As a registered user,
I want to log in to the system
So that I can access my profile to manage my personal information and review my orders.

  Scenario: Valid Login
    Given the user is on the login page
    When the user enters email "johm1@gmail.com" and password "123456"
    And the user clicks the login button
    Then the user is redirected to their profile page

  Scenario: Invalid Login - Incorrect Password
    Given the user is on the login page
    When the user enters email "user@example.com" and password "WrongPassword"
    And the user clicks the login button
    Then an error message "Invalid username or password" is displayed

  Scenario: Invalid Login - Incorrect Username
    Given the user is on the login page
    When the user enters email "wronguser@example.com" and password "Password123"
    And the user clicks the login button
    Then an error message "Invalid username or password" is displayed
