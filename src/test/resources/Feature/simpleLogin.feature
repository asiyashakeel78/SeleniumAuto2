Feature: Login Functionality

  Scenario: Successful login with valid credentials
    Given user is on the login page
    When user enters valid username and password
    And user clicks on login button
    Then user is navigated to the dashboard page