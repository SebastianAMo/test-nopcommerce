Feature: Registering a new user
  Scenario: User registers with valid data
    Given A user navigates to the registration page
    When User enters valid name "John"
    And User enters valid last name "Smith"
    And User enters valid email "johm1@gmail.com"
    And User enters valid password "123456"
    And User enters valid confirm password "123456"
    And User clicks on the register button
    Then User should be taken to the successful registration page

    Scenario: User registers with a email that is already registered
    Given A user navigates to the registration page
    When User enters valid name "John"
    And User enters valid last name "Smith"
    And User enters valid email "johm1@gmail.com"
    And User enters valid password "123456"
    And User enters valid confirm password "123456"
    And User clicks on the register button
    Then User should be see the message "The specified email already exists"
